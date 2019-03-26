package cass.rollup.processors;

import cass.rollup.processors.v3.graph.EcFrameworkGraph;
import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.date.Date;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.profile.AssertionEnvelope;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Processor used in determining all the competencies a for which a user has assertions.
 * Utilizes EcFrameworkGraph
 *
 * @author fritz.ray@eduworks.com
 * @author tom.buskirk@eduworks.com
 * @class ProfileProcessor
 * @module org.cassproject
 */

public class ProfileProcessor {

    public static final boolean DEBUG = true;

    private Array<String> profilePkPems;
    private EcRepository repo;
    private Callback0 successCallback;
    private Callback1<String> failureCallback;

    private int frameworksToProcess = 0;
    private int frameworksProcessed = 0;

    private Array<EcFrameworkGraph> assertedFrameworkGraphs;
    private Array<EcAssertion> unfilteredAssertionList;
    private Array<EcAssertion> profileAssertions;

    private Array<String> addedAssertionIds;
    private Array<String> assertionCompetencies;

    public ProfileProcessor() {
    }

    private void debugMessage(Object o) {
        if (DEBUG) Global.console.log(o);
    }

    private void checkAllFrameworkGraphAssertionsHaveProcessed() {
        debugMessage("checkAllFrameworkGraphAssertionsHaveProcessed");
        debugMessage("frameworksProcessed: " + frameworksProcessed);
        if (frameworksProcessed >= frameworksToProcess) {
            debugMessage("All profile assertion framework graphs processed");
            successCallback.$invoke();
        }
    }

    private void processFrameworkGraphAssertions(final EcFrameworkGraph efg, EcFramework framework) {
        debugMessage("(" + Date.now() + ") Processing framework graph assertions for:");
        debugMessage(framework.shortId());
        debugMessage(framework.getName());
        final ProfileProcessor me = this;
        efg.processAssertionsBoolean(profileAssertions,
                new Callback0() {
                    @Override
                    public void $invoke() {
                        me.frameworksProcessed++;
                        me.assertedFrameworkGraphs.push(efg);
                        me.checkAllFrameworkGraphAssertionsHaveProcessed();
                    }
                },
                new Callback1<String>() {
                    @Override
                    public void $invoke(String err) {
                        me.handleFailedFrameworkGraphOperation("Process Graph: " + err);
                    }
                }
        );
    }

    private void handleFailedFrameworkGraphOperation(String err) {
        debugMessage("handleFailedFrameworkGraphOperation: " + err);
        frameworksProcessed++;
        checkAllFrameworkGraphAssertionsHaveProcessed();
    }

    private void buildProfileAssertionFrameworkGraph(final EcFramework framework) {
        debugMessage("(" + Date.now() + ") Generating framework graph for:");
        debugMessage(framework.shortId());
        debugMessage(framework.getName());
        final ProfileProcessor me = this;
        final EcFrameworkGraph efg = new EcFrameworkGraph();
        efg.addFramework(framework,repo,
                new Callback0() {
                    @Override
                    public void $invoke() {
                        me.processFrameworkGraphAssertions(efg,framework);
                    }
                },
                new Callback1<String>() {
                    @Override
                    public void $invoke(String err) {
                        me.handleFailedFrameworkGraphOperation("Build Graph: " + err);
                    }
                }
        );
    }

    private void generateProfileAssertionFrameworkGraphs(Array<EcFramework> profileAssertionFrameworks) {
        if (profileAssertionFrameworks.$length() <= 0) successCallback.$invoke();
        else {
            frameworksToProcess = profileAssertionFrameworks.$length();
            debugMessage("Generating framework graphs...");
            debugMessage(profileAssertionFrameworks);
            for (int i=0;i<profileAssertionFrameworks.$length();i++) {
                buildProfileAssertionFrameworkGraph(profileAssertionFrameworks.$get(i));
            }
        }
    }

    private void buildAssertionCompetencyList() {
        assertionCompetencies = new Array<String>();
        for (int i=0;i<profileAssertions.$length();i++) {
            EcAssertion asr = profileAssertions.$get(i);
            if (!EcArray.has(assertionCompetencies,asr.competency)) {
                assertionCompetencies.push(asr.competency);
            }
        }
    }

    private String getFrameworkSearchQueryForAssertionCompetencies() {
        String searchQuery = "";
        if (assertionCompetencies.$length() > 1) searchQuery = "(";
        for (int i = 0; i < assertionCompetencies.$length(); i++) {
            if (i > 0) searchQuery += " OR ";
            searchQuery += "(competency:\"" + assertionCompetencies.$get(i) + "\")";
        }
        if (assertionCompetencies.$length() > 1) searchQuery += ")";
        debugMessage("Framework search query: " + searchQuery);
        return searchQuery;
    }

    private void findFrameworksForProfileAssertions() {
        unfilteredAssertionList = null;
        buildAssertionCompetencyList();
        debugMessage("Fetching Assertion Frameworks...");
        final ProfileProcessor me = this;
        EcFramework.search(repo, getFrameworkSearchQueryForAssertionCompetencies(),
                new Callback1<Array<EcFramework>>() {
                    @Override
                    public void $invoke(Array<EcFramework> arrayOfEcFrameworks) {
                        me.debugMessage("Assertion Frameworks Fetched");
                        me.generateProfileAssertionFrameworkGraphs(arrayOfEcFrameworks);
                    }
                },
                me.failureCallback,
                null
        );
    }

    private void filterAssertionList() {
        if (unfilteredAssertionList.$length() == 0) successCallback.$invoke();
        else {
            final ProfileProcessor me = this;
            final EcAsyncHelper<EcAssertion> eah = new EcAsyncHelper<EcAssertion>();
            eah.each(unfilteredAssertionList,
                    new Callback2<EcAssertion, Callback0>() {
                        @Override
                        public void $invoke(final EcAssertion assertion, final Callback0 done) {
                            assertion.getSubjectAsync(
                                    new Callback1<EcPk>() {
                                        @Override
                                        public void $invoke(EcPk subject) {
                                            if (subject != null) {
                                                if (EcArray.has(me.profilePkPems,subject.toPem())) {
                                                    if (!EcArray.has(me.addedAssertionIds,assertion.shortId())) {
                                                        me.profileAssertions.push(assertion);
                                                        me.addedAssertionIds.push(assertion.shortId());
                                                    }
                                                }
                                            }
                                            done.$invoke();
                                        }
                                    },
                                    eah.failWithCallback(me.failureCallback, done)
                            );
                        }
                    },
                    new Callback1<Array<EcAssertion>>() {
                        @Override
                        public void $invoke(Array<EcAssertion> aa) {
                            me.debugMessage("Assertions filtered");
                            me.debugMessage(me.profileAssertions);
                            me.findFrameworksForProfileAssertions();
                        }
                    }
            );
        }
    }

    private boolean isEnvelopeOwnedByProfileUser(EcRemoteLinkedData asrEnv) {
        if (asrEnv.owner == null) return false;
        for (int i = 0; i< asrEnv.owner.$length(); i++) {
            if (EcArray.has(profilePkPems,asrEnv.owner.$get(i))) return true;
        }
        return false;
    }

    private boolean isEncryptedAssertionEnvelope(EcRemoteLinkedData asrEnv) {
        //TODO This won't work in Java
        return true;
        //if (asrEnv.encryptedType == "AssertionEnvelope") return true;
        //return false;
    }

    private void processPotentialAssertionEnvelope(EcRemoteLinkedData potAsrEnv) {
        debugMessage("processPotentialAssertionEnvelope: " + potAsrEnv.shortId());
        if (isEncryptedAssertionEnvelope(potAsrEnv) && isEnvelopeOwnedByProfileUser(potAsrEnv)) {
            EcEncryptedValue nv = new EcEncryptedValue();
            nv.copyFrom(potAsrEnv);
            EcRemoteLinkedData aed = nv.decryptIntoObject();
            AssertionEnvelope realAsrEnv = new AssertionEnvelope();
            realAsrEnv.copyFrom(aed);
            for (int i = 0; i < realAsrEnv.assertion.$length(); i++) {
                EcAssertion eca = new EcAssertion();
                eca.copyFrom(realAsrEnv.getAssertion(i));
                unfilteredAssertionList.push(eca);
            }
        }
    }

    private void processAssertionEnvelopes(Array<EcRemoteLinkedData> ecRldArray) {
        debugMessage("Processing Assertion Envelopes...");
        if (ecRldArray != null && ecRldArray.$length() > 0) {
            for (int i = 0; i < ecRldArray.$length(); i++) {
                processPotentialAssertionEnvelope(ecRldArray.$get(i));
            }
        }
        filterAssertionList();
    }

    private void fetchAssertionEnvelopes() {
        debugMessage("Fetching Assertion Envelopes...");
        final ProfileProcessor me = this;
        repo.searchWithParams(new AssertionEnvelope().getSearchStringByType(),null,null,
                new Callback1<Array<EcRemoteLinkedData>>() {
                    @Override
                    public void $invoke(Array<EcRemoteLinkedData> ecRldArray) {
                        me.debugMessage("Assertion Envelopes Fetched");
                        me.processAssertionEnvelopes(ecRldArray);
                    }
                },
                me.failureCallback
        );
    }

    private String getAssertionSearchQueryForProfilePkPems() {
        String searchQuery = "";
        if (profilePkPems.$length() > 1) searchQuery = "(";
        for (int i = 0; i < profilePkPems.$length(); i++) {
            if (i > 0) searchQuery += " OR ";
            searchQuery += "(\\*@reader:\"" + profilePkPems.$get(i) + "\")";
        }
        if (profilePkPems.$length() > 1) searchQuery += ")";
        debugMessage("Assertion search query: " + searchQuery);
        return searchQuery;
    }

    private void fetchProfileAssertions() {
        debugMessage("Fetching Assertions...");
        final ProfileProcessor me = this;
        EcAssertion.search(repo, getAssertionSearchQueryForProfilePkPems(),
                new Callback1<Array<EcAssertion>>() {
                    @Override
                    public void $invoke(Array<EcAssertion> arrayOfEcAssertions) {
                        me.debugMessage("Assertions Fetched");
                        if (arrayOfEcAssertions != null && arrayOfEcAssertions.$length() > 0) {
                            me.unfilteredAssertionList = arrayOfEcAssertions;
                        }
                        me.fetchAssertionEnvelopes();
                    }
                },
                me.failureCallback,
                null
        );
    }

    public void processProfileAssertions(EcRepository repo, Array<String> profilePkPems, final Callback0 success, final Callback1<String> failure) {
        this.profilePkPems = profilePkPems;
        this.repo = repo;
        successCallback = success;
        failureCallback = failure;
        assertedFrameworkGraphs = new Array<EcFrameworkGraph>();
        profileAssertions = new Array<EcAssertion>();
        unfilteredAssertionList = new Array<EcAssertion>();
        addedAssertionIds = new Array<String>();
        fetchProfileAssertions();
    }

}
