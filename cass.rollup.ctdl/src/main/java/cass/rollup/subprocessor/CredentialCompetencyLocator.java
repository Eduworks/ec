package cass.rollup.subprocessor;


import com.eduworks.ec.array.EcArray;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.credentialengine.*;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;

/**
 * Attempts to find all 'required' competencies for a given 'Credential' type (Badge, Certificate, Degree, Credential)
 * by traversing the associated required 'ConditionProfile' for 'targetLearningOpportunities' and 'targetAssessments'
 *
 * @author fritz.ray@eduworks.com
 * @author tom.buskirk@eduworks.com
 * @class CredentialCompetencyLocator
 * @module org.cassproject
 */
public class CredentialCompetencyLocator {

	//private static final String CERTIFICATE_TYPE_SUFFIX = "Certificate";
	//private static final String CREDENTIAL_TYPE_SUFFIX = "Credential";
	//private static final String BADGE_TYPE_SUFFIX = "Badge";
	//private static final String DEGREE_TYPE_SUFFIX = "Degree"; //Doesn't seem to exist...

	private static final String ASSESSMENT_PROFILE_TYPE_SUFFIX = "AssessmentProfile";
	private static final String LEARNING_OPPORTUNITY_PROFILE_TYPE_SUFFIX = "LearningOpportunityProfile";

	private static final String CONDITION_PROFILE_TYPE = "ConditionProfile";

	public Array<String> logBuffer;

	public String credentialLocator;
	public String resourceLocatorUrl;
	public boolean stripId = true;
	public Callback1<Array<CredentialAlignmentObject>> success;
	public Callback1<String> failure;

	private boolean inputValid = false;
	private Credential sourceCredential;
	private Array<CredentialAlignmentObject> competencyList;
	private Map<String, CredentialAlignmentObject> competencyMap;

	private Array<String> currentTargetList;
	private int numberOfTargetsToProcess;
	private int numberOfTargetsProcessed;

	private Array<String> nextTargetList;
	private Map<String, String> targetsProcessed;

	private void log(String s) {
		logBuffer.push(s);
	}

	private void validateInput() {
		log("Validating input...");
		inputValid = false;
		if (failure == null) {
			log("Invalid failure callback");
		} else if (success == null) {
			log("Invalid success callback");
			failure.$invoke("success callback required");
		} else if (credentialLocator == null || credentialLocator.trim().equals("")) {
			log("Invalid credentialLocator");
			failure.$invoke("credentialLocator required");
		} else if (resourceLocatorUrl == null || resourceLocatorUrl.trim().equals("")) {
			log("Invalid resourceLocatorUrl");
			failure.$invoke("resourceLocatorUrl required");
		} else {
			inputValid = true;
		}
	}

	private void initLocator() {
		log("Initializing parameters...");
		competencyList = new Array<CredentialAlignmentObject>();
		competencyMap = JSCollections.$map();
		targetsProcessed = JSCollections.$map();
	}

	private void logCreativeWorkArray(Array<? extends CreativeWork> cwa) {
		for (int i = 0; i < cwa.$length(); i++) {
			log("[" + i + "]: " + cwa.$get(i).name);
		}
	}

	private void logStringArray(Array<String> sa) {
		for (int i = 0; i < sa.$length(); i++) {
			log("[" + i + "]: " + sa.$get(i));
		}
	}

	private void logCredentialAlignmentArray(Array<CredentialAlignmentObject> caoa) {
		for (int i = 0; i < caoa.$length(); i++) {
			log("[" + i + "]-framework: " + caoa.$get(i).framework);
			log("[" + i + "]-targetNode: " + caoa.$get(i).targetNode);
		}
	}

	private ConditionProfile generateConditionProfile(Object o) {
		ConditionProfile cp = new ConditionProfile();
		cp.copyFrom(o);
		return cp;
	}

	private Array<String> getStringArray(Object o) {
		if (o == null) new Array<String>();
		Array<String> sa;
		if (EcArray.isArray(o)) sa = (Array<String>) o;
		else {
			sa = new Array<String>();
			sa.push((String) o);
		}
		return sa;
	}

	private Array<CredentialAlignmentObject> getTargetCompetencyList(Object targetCompetencyObject) {
		if (targetCompetencyObject == null) return new Array<CredentialAlignmentObject>();
		Array<CredentialAlignmentObject> caoa = new Array<CredentialAlignmentObject>();
		CredentialAlignmentObject cao;
		if (EcArray.isArray(targetCompetencyObject)) {
			Array<Object> oa = (Array<Object>) targetCompetencyObject;
			for (int i = 0; i < oa.$length(); i++) {
				cao = new CredentialAlignmentObject();
				cao.copyFrom(oa.$get(i));
				caoa.push(cao);
			}
		} else {
			cao = new CredentialAlignmentObject();
			cao.copyFrom(targetCompetencyObject);
			caoa.push(cao);
		}
		return caoa;
	}

	private void registerTargetAsProcessed(String id) {
		targetsProcessed.$put(id, id);
	}

	private boolean hasTargetBeenProcessed(String id) {
		if (targetsProcessed.$get(id) == null) return false;
		return true;
	}

	private void buildCompetencyList() {
		for (String s : competencyMap) {
			competencyList.push(competencyMap.$get(s));
		}
	}

	private void checkForAllTargetsProcessed() {
		if (numberOfTargetsProcessed >= numberOfTargetsToProcess) {
			if (nextTargetList.$length() == 0) {
				log("All targets processed...prepping for success invoke...");
				buildCompetencyList();
				success.$invoke(competencyList);
			} else {
				log("Preparing to process next target list...");
				currentTargetList = nextTargetList;
				processCurrentTargetList();
			}
		} else {
			log("Targets still processing...");
		}
	}

	private void addCompetenciesToMap(Array<CredentialAlignmentObject> competencyList) {
		CredentialAlignmentObject cao;
		for (int i = 0; i < competencyList.$length(); i++) {
			cao = competencyList.$get(i);
			competencyMap.$put(cao.framework + "---" + cao.targetNode, cao);
		}
	}

	private void addSubTargetsToNextTargetList(Object requiresObj) {
		if (requiresObj != null) {
			log("Looking for sub targets...");
			Array<String> subTargets = getTargetsFromRequirementsObject(requiresObj);
			if (subTargets.$length() > 0) {
				for (int i = 0; i < subTargets.$length(); i++) {
					if (subTargets.$get(i) != null && subTargets.$get(i).trim().length() > 0) {
						log("Adding sub target: " + subTargets.$get(i));
						nextTargetList.push(subTargets.$get(i));
					}
				}
			} else log("No sub targets found");
		} else log("No requires object for target -> no sub targets exist");
	}

	private void processAssessmentProfile(AssessmentProfile ap) {
		log("Processing as Assessment Profile...");
		Array<CredentialAlignmentObject> tca = getTargetCompetencyList(ap.targetCompetency);
		log("Target competency list(" + tca.$length() + "):");
		logCredentialAlignmentArray(tca);
		addCompetenciesToMap(tca);
		addSubTargetsToNextTargetList(ap.requires);
	}

	private void processLearningOpportunityProfile(LearningOpportunityProfile lop) {
		log("Processing as Learning Opportunity Profile...");
		Array<CredentialAlignmentObject> tca = getTargetCompetencyList(lop.targetCompetency);
		log("Target competency list(" + tca.$length() + "):");
		logCredentialAlignmentArray(tca);
		addCompetenciesToMap(tca);
		addSubTargetsToNextTargetList(lop.requires);
	}

	private void processTarget(EcRemoteLinkedData erld) {
		CreativeWork cw = new CreativeWork();
		cw.copyFrom(erld);
		log("Processing target: " + cw.shortId());
		log("Target type: " + cw.getFullType());
		if (cw.getFullType().endsWith(ASSESSMENT_PROFILE_TYPE_SUFFIX)) {
			AssessmentProfile ap = new AssessmentProfile();
			ap.copyFrom(erld);
			processAssessmentProfile(ap);
		} else if (cw.getFullType().endsWith(LEARNING_OPPORTUNITY_PROFILE_TYPE_SUFFIX)) {
			LearningOpportunityProfile lop = new LearningOpportunityProfile();
			lop.copyFrom(erld);
			processLearningOpportunityProfile(lop);
		}
		registerTargetAsProcessed(cw.shortId());
		numberOfTargetsProcessed++;
		checkForAllTargetsProcessed();
	}

	private void processCurrentTargetList() {
		log("Processing current target list...");
		nextTargetList = new Array<String>();
		numberOfTargetsToProcess = currentTargetList.$length();
		numberOfTargetsProcessed = 0;
		String currentTargetId;
		final CredentialCompetencyLocator ccl = this;
		for (int i = 0; i < numberOfTargetsToProcess; i++) {
			currentTargetId = currentTargetList.$get(i);
			if (hasTargetBeenProcessed(resourceLocatorUrl + currentTargetId)) {
				numberOfTargetsProcessed++;
				checkForAllTargetsProcessed();
			} else {
				EcRepository.get(resourceLocatorUrl + currentTargetId,
						new Callback1<EcRemoteLinkedData>() {
							@Override
							public void $invoke(EcRemoteLinkedData p1) {
								ccl.processTarget(p1);
							}
						},
						new Callback1<String>() {
							@Override
							public void $invoke(String p1) {
								ccl.log("Target lookup failed: " + p1);
								ccl.numberOfTargetsProcessed++;
								ccl.checkForAllTargetsProcessed();
							}
						});
			}
		}
	}

	private void addStringsToMap(Map<String, String> m, Array<String> sa) {
		for (int i = 0; i < sa.$length(); i++) {
			if (sa.$get(i) != null && sa.$get(i).trim().length() > 0) m.$put(sa.$get(i).trim(), sa.$get(i).trim());
		}
	}

	private String stripIdString(String s) {
		if (s.indexOf("/") > -1) {
			return s.substring(s.lastIndexOf("/") + 1);
		} else return s;
	}

	private Array<String> getMapKeyList(Map<String, String> m, boolean doIdStrip) {
		Array<String> sa = new Array<String>();
		for (String s : m) {
			if (doIdStrip) sa.push(stripIdString(s));
			else sa.push(s);
		}
		return sa;
	}

	private Array<String> getTargetListFromConditionProfiles(Array<ConditionProfile> cpa) {
		ConditionProfile cp;
		Array<String> targetAssessmentList;
		Array<String> targetLearningOpportunityList;
		Map<String, String> targetMap = JSCollections.$map();
		for (int i = 0; i < cpa.$length(); i++) {
			cp = cpa.$get(i);
			targetAssessmentList = getStringArray(cp.targetAssessment);
			targetLearningOpportunityList = getStringArray(cp.targetLearningOpportunity);
			addStringsToMap(targetMap, targetAssessmentList);
			addStringsToMap(targetMap, targetLearningOpportunityList);
		}
		return getMapKeyList(targetMap, stripId);
	}

	private Array<ConditionProfile> getRequiredConditionProfilesList(Object requiresObj) {
		Array<ConditionProfile> cpa = new Array<ConditionProfile>();
		CreativeWork cw;
		if (!EcArray.isArray(requiresObj)) {
			cw = new CreativeWork();
			cw.copyFrom(requiresObj);
			if (CONDITION_PROFILE_TYPE.equalsIgnoreCase(cw.getFullType()))
				cpa.push(generateConditionProfile(requiresObj));
		} else {
			Array<Object> oa = (Array<Object>) requiresObj;
			for (int i = 0; i < oa.$length(); i++) {
				cw = new CreativeWork();
				cw.copyFrom(oa.$get(i));
				if (CONDITION_PROFILE_TYPE.equalsIgnoreCase(cw.getFullType()))
					cpa.push(generateConditionProfile(oa.$get(i)));
			}
		}
		return cpa;
	}

	private Array<String> getTargetsFromRequirementsObject(Object requiresObject) {
		log("Processing requirements...");
		Array<ConditionProfile> conditionProfileList = getRequiredConditionProfilesList(requiresObject);
		log("Required Condition Profiles(" + conditionProfileList.$length() + "):");
		logCreativeWorkArray(conditionProfileList);
		return getTargetListFromConditionProfiles(conditionProfileList);
	}

	private void processSourceCredential() {
		log("Processing source credential...");
		currentTargetList = getTargetsFromRequirementsObject(sourceCredential.requires);
		log("Initial Target List(" + currentTargetList.$length() + "):");
		logStringArray(currentTargetList);
		if (currentTargetList.$length() == 0) {
			log("No aligned Learning Opportunity or Assessesment Profiles exist for the credential therefore no competencies can be mapped");
			success.$invoke(competencyList);
		}
		registerTargetAsProcessed(sourceCredential.shortId());
		processCurrentTargetList();
	}

	private void fetchSourceCredentialAndGo() {
		log("Fetching source credential: " + credentialLocator);
		final CredentialCompetencyLocator ccl = this;
		EcRepository.get(credentialLocator,
				new Callback1<EcRemoteLinkedData>() {
					@Override
					public void $invoke(EcRemoteLinkedData p1) {
						ccl.sourceCredential = new Credential();
						ccl.sourceCredential.copyFrom(p1);
						ccl.log("Source credential fetched: " + ccl.sourceCredential.name);
						ccl.processSourceCredential();
					}
				},
				new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						ccl.log("Source credential fetch failed: " + p1);
						ccl.failure.$invoke("Source credential fetch failed: " + p1);
					}
				});
	}

	public void locateCompetencies() {
		logBuffer = new Array<String>();
		validateInput();
		if (inputValid) {
			log("Input valid proceeding...");
			initLocator();
			fetchSourceCredentialAndGo();
		}
	}
}
