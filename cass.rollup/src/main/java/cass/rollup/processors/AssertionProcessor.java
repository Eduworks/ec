package cass.rollup.processors;

import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.competency.EcLevel;
import org.cass.competency.EcRollupRule;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function1;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.schema.ebac.EbacSignature;

import cass.rollup.InquiryPacket;
import cass.rollup.InquiryPacket.IPType;
import com.eduworks.ec.array.EcAsyncHelper;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.SortFunction;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback2;

/**
 * Processor used in Assertion Processing. Can estimate or determine competence
 * of individuals.
 *
 * @class AssertionProcessor
 * @module org.cassproject
 * @author fritz.ray@eduworks.com
 * @author tom.buskirk@eduworks.com
 */
public abstract class AssertionProcessor {

    public Array<EcRepository> repositories;
    public boolean step;
    public Callback1<Object> logFunction;
    public Object assertions;

    private static final boolean DEF_STEP = false;

    public Map<String, String> processedEquivalencies;

    public AssertionProcessor() {
        repositories = new Array<EcRepository>();
        step = DEF_STEP;
    }

    protected void log(InquiryPacket ip, Object string) {
        if (logFunction != null) {
            logFunction.$invoke(string);
        }
        ip.log += "\n" + string;
    }

    /**
     * Asynchronously processes and provides an answer to the question: Does an
     * individual hold a competency?
     *
     * @method has
     * @param {EcPk[]} subject Public keys that identify the subject.
     * @param {EcCompetency} competency The Competency being inquired about.
     * @param {EcLevel} level The Level of the Competency at which the question
     * is being asked.
     * @param {EcFramework} context The Framework in which to scope the inquiry.
     * @param {EbacSignature[]} additionalSignatures Additional signatures
     * provided by an authority, used to request additional access on a one-time
     * basis.
     * @param {function(InquiryPacket)} success The method that is invoked when
     * a decision has been reached.
     * @param {string function(string)} ask The method that is invoked when the
     * assertion processor detects that it needs information. (Usernames,
     * passwords, etc)
     * @param {function(string)} failure The method that is invoked when the
     * assertion processor has failed.
     */
    public void has(Array<EcPk> subject, EcCompetency competency, EcLevel level, EcFramework context, Array<EbacSignature> additionalSignatures,
            final Callback1<InquiryPacket> success, Function1<String, String> ask, Callback1<String> failure) {
        final InquiryPacket ip = new InquiryPacket(subject, competency, level, context, success, failure, null, IPType.COMPETENCY);
        processedEquivalencies = JSCollections.$map();
        assertions = new Object();
        log(ip, "Created new inquiry.");
        final AssertionProcessor me = this;
        ip.success = new Callback1<InquiryPacket>() {
            @Override
            public void $invoke(InquiryPacket p1) {
                ip.success = success;
                me.collectAssertionsForSecondPass(ip, new Callback1<InquiryPacket>() {
                    @Override
                    public void $invoke(InquiryPacket p1) {
                        me.continueProcessingSecondPass(ip);
                    }
                });
            }
        };
        continueProcessing(ip);
    }

    public void collectAssertionsForSecondPass(final InquiryPacket ip, final Callback1 success) {
        Array<EcCompetency> listOfActivatedCompetencies = new Array<>();
        collectCompetencies(ip, listOfActivatedCompetencies, new Array<InquiryPacket>());
        final AssertionProcessor me = this;
        listOfActivatedCompetencies.sort(new SortFunction<EcCompetency>() {
            @Override
            public int $invoke(EcCompetency a, EcCompetency b) {
                return b.shortId().compareTo(a.shortId());
            }
        });
        for (int i = 0; i < repositories.$length(); i++) {
            EcRepository currentRepository = repositories.$get(i);

            log(ip, "Querying repositories for subject assertions on " + listOfActivatedCompetencies.$length() + " competencies");
            ip.numberOfQueriesRunning++;
            Object params = new Object();
            JSObjectAdapter.$put(params, "size", 5000);
            EcAssertion.search(currentRepository,buildAssertionsSearchQuery(ip, listOfActivatedCompetencies), new Callback1<Array<EcAssertion>>() {
                public void $invoke(Array<EcAssertion> p1) {
                    ip.numberOfQueriesRunning--;
                    for (int i = 0;i < p1.$length();i++)
                    {
                        EcAssertion a = p1.$get(i);
                        if (JSObjectAdapter.$get(me.assertions,a.competency) == null)
                            JSObjectAdapter.$put(me.assertions,a.competency,new Array<EcAssertion>());
                        Array<EcAssertion> as = (Array<EcAssertion>) JSObjectAdapter.$get(me.assertions, a.competency);
                        as.push(a);
                    }
                    if (ip.numberOfQueriesRunning == 0)
                        success.$invoke(ip);
                }
            }, new Callback1<String>() {
                public void $invoke(String p1) {
                    ip.numberOfQueriesRunning--;
                    if (ip.numberOfQueriesRunning == 0)
                        success.$invoke(ip);
                }
            },params);
        }

    }

    public boolean isIn(InquiryPacket ip, Array<InquiryPacket> alreadyDone) {
        for (int i = 0; i < alreadyDone.$length(); i++) {
            if (ip == alreadyDone.$get(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean continueProcessingSecondPass(InquiryPacket ip) {
        if (!ip.hasCheckedAssertionsForCompetency) {
            findSubjectAssertionsForCompetency(ip);
            return true;
        } else {
            if (processChildPacketsSecondPass(ip.equivalentPackets)) {
                return true;
            }
            if (processChildPacketsSecondPass(ip.subPackets)) {
                return true;
            }
        }
        if (ip.result == null) {
            determineResult(ip);
            if (ip.result != null && ip.success != null) {
                ip.success.$invoke(ip);
            }
            return true;
        }
        return false;
    }

    public boolean continueProcessing(InquiryPacket ip) {
        // Build inquiry packet tree
        if (!ip.finished) {
            if (!ip.hasCheckedRelationshipsForCompetency) {
                findCompetencyRelationships(ip);
                return true;
            } else if (!ip.hasCheckedRollupRulesForCompetency) {
                findRollupRulesForCompetency(ip);
                return true;
            } else {
                ip.finished = true;
            }
        }
        if (ip.finished) {
            if (processChildPackets(ip.equivalentPackets)) {
                return true;
            }
            if (processChildPackets(ip.subPackets)) {
                return true;
            }
        }
        if (ip.success != null) {
            ip.success.$invoke(ip);
            return true;
        }
        return false;
    }

    protected abstract void determineResult(InquiryPacket ip);

    protected abstract void findCompetencyRelationships(InquiryPacket ip);

    protected abstract void findSubjectAssertionsForCompetency(InquiryPacket ip);

    private boolean processChildPackets(Array<InquiryPacket> childPackets) {
        if (childPackets != null) {
            for (int i = 0; i < childPackets.$length(); i++) {
                if (continueProcessing(childPackets.$get(i))) {
                    return true;
                }
                // TB - not sure why this return was here
                // FR - The return is here because we don't want to process
                // multiple things at the same time, as it locks up the UI
                // thread and spams the log with async data.
                // FR - "drip processing" makes the logs more readable and will
                // interrupt the UI thread less.
            }
        }
        return false;
    }

    protected void checkStep(InquiryPacket ip) {
        // TODO Fritz, please make sure this is correct
        log(ip, "Checkstep: " + ip.numberOfQueriesRunning);
        if (ip.numberOfQueriesRunning == 0) {
            if (!step) {
                continueProcessing(ip);
            }
        }
        // FR - This isn't a polling loop. If step is turned on, then we expect
        // an external process to keep clicking continueProcessing.
        // FR - If step is turned off, when a single thing gets done, we can
        // start doing the next thing.
        // FR - This is another artifact of 'drip processing', where we have to
        // trickle the process and allow the UI thread to jump in and refresh
        // the screen during any async operation.
        // else
        // {
        // checkStep(ip);
        // }
    }

    private boolean processChildPacketsSecondPass(Array<InquiryPacket> childPackets) {
        if (childPackets != null) {
            for (int i = 0; i < childPackets.$length(); i++) {
                if (continueProcessingSecondPass(childPackets.$get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void checkStepSecondPass(InquiryPacket ip) {
        // TODO Fritz, please make sure this is correct
        log(ip, "Checkstep: " + ip.numberOfQueriesRunning);
        if (ip.numberOfQueriesRunning == 0) {
            if (!step) {
                continueProcessingSecondPass(ip);
            }
        }
    }

    protected void processEventFailure(String message, InquiryPacket ip) {
        log(ip, "Event failed: " + message);
        ip.numberOfQueriesRunning--;
        ip.failure.$invoke(message);
    }

    protected void logFoundAssertion(EcAssertion a, InquiryPacket ip) {
        log(ip, "No issues found with assertion.");
        log(ip, "Record Id: " + a.shortId());
        log(ip, "Confidence: " + a.confidence);
        log(ip, "Number of pieces of evidence: " + a.getEvidenceCount());
//		log(ip, "Evidence:");
//		for (int j = 0; j < a.getEvidenceCount(); j++)
//			log(ip, "  " + a.getEvidence(j));
        log(ip, "Recording in inquiry.");
    }

    protected String buildAssertionSearchQuery(InquiryPacket ip, EcCompetency competency) {
        String result = null;
        if (IPType.ROLLUPRULE.equals(ip.type)) {
            result = "(" + new EcAssertion().getSearchStringByType() + ") AND (" + ip.rule + ")";
        } else if (IPType.COMPETENCY.equals(ip.type)) {
            result = new EcAssertion().getSearchStringByTypeAndCompetency(competency);
        }
        for (int i = 0; i < ip.subject.$length(); i++) {
            result += " AND (\\*@reader:\"" + ip.subject.$get(i).toPem() + "\")";
        }
        if (result != null) {
            return result;
        }
        throw new RuntimeException("Trying to build an assertion search query on an unsupported type: " + ip.type);
    }

    protected String buildAssertionsSearchQuery(InquiryPacket ip, Array<EcCompetency> competencies) {
        String result = null;
        if (IPType.ROLLUPRULE.equals(ip.type)) {
            ip.failure.$invoke("NOT SUPPOSED TO BE HERE.");
            throw new RuntimeException("Collecting assertions when root node is a rollup rule. Not supported.");
        } else if (IPType.COMPETENCY.equals(ip.type)) {
            result = "(";
            for (int i = 0;i < competencies.$length();i++)
            {
                if (i != 0)
                    result += " OR ";
                result += "competency:\"" + competencies.$get(i).shortId() + "\"";
            }
            result += ")";
        }
        for (int i = 0; i < ip.subject.$length(); i++) {
            result += " AND (\\*@reader:\"" + ip.subject.$get(i).toPem() + "\")";
        }
        if (result != null) {
            return result;
        }
        throw new RuntimeException("Trying to build an assertion search query on an unsupported type: " + ip.type);
    }

    protected void processRelationshipPacketsGenerated(InquiryPacket ip, EcCompetency competency) {
        log(ip, "Relationships succesfully processed for: " + competency.id);
        ip.numberOfQueriesRunning--;
        checkStep(ip);
    }

    protected void processRollupRuleInterpretSuccess(Boolean status, InquiryPacket ip) {
        log(ip, "Rollup rule successfully interpreted.");
        ip.numberOfQueriesRunning--;
        checkStep(ip);
    }

    protected void processRollupRuleInterpretSkipped(InquiryPacket ip) {
        log(ip, "Rollup rule skipped.");
        ip.numberOfQueriesRunning--;
        checkStep(ip);
    }

    private void findRollupRulesForCompetency(final InquiryPacket ip) {
        ip.hasCheckedRollupRulesForCompetency = true;
        if (!IPType.COMPETENCY.equals(ip.type)) {
            log(ip, "No rollup rules for combinator types");
            checkStep(ip);
            return;
        }
        final AssertionProcessor ep = this;
        if (ip.getContext().rollupRule == null) {
            continueProcessing(ip);
        } else {
            for (int i = 0; i < ip.getContext().rollupRule.$length(); i++) {
                ip.numberOfQueriesRunning++;
                EcRollupRule.get(ip.getContext().rollupRule.$get(i), new Callback1<EcRollupRule>() {
                    @Override
                    public void $invoke(EcRollupRule rr) {
                        ep.processFindRollupRuleSuccess(rr, ip);
                    }
                }, new Callback1<String>() {
                    @Override
                    public void $invoke(String p1) {
                        ep.processEventFailure(p1, ip);
                    }
                });
            }
        }
    }

    protected abstract void processFindRollupRuleSuccess(EcRollupRule rr, InquiryPacket ip);

    private void collectCompetencies(InquiryPacket ip, Array<EcCompetency> listOfActivatedCompetencies, Array<InquiryPacket> listOfVisitedPackets) {
        for (int i = 0; i < listOfVisitedPackets.$length(); i++) {
            if (ip == listOfVisitedPackets.$get(i)) {
                return;
            }
        }
        listOfVisitedPackets.push(ip);
        for (int i = 0; i < ip.competency.$length(); i++) {
            listOfActivatedCompetencies.push(ip.competency.$get(i));
        }
        for (int i = 0; i < ip.equivalentPackets.$length(); i++) {
            collectCompetencies(ip.equivalentPackets.$get(i), listOfActivatedCompetencies, listOfVisitedPackets);
        }
        for (int i = 0; i < ip.subPackets.$length(); i++) {
            collectCompetencies(ip.subPackets.$get(i), listOfActivatedCompetencies, listOfVisitedPackets);
        }
    }

}
