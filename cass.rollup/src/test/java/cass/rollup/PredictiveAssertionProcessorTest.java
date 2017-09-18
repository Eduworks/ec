package cass.rollup;

import cass.rollup.processors.predictor.PapNetworkPrediction;
import cass.rollup.processors.predictor.PredictiveAssertionProcessor;
import cass.rollup.processors.v2.graph.CgEdge;
import cass.rollup.processors.v2.graph.CompetencyGraph;
import cass.rollup.processors.v2.graph.SimpleAssertion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.Global;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "lib/require.js", "rollupInit.js", "/forge/forge.bundle.js" })
public class PredictiveAssertionProcessorTest extends EvidenceProcessingTestBase {

    public static final String SUBJECT_PEM = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtKxQMxXdoogq+eNihcCcbgloNDk333Vt55kKf8Bjko+QqL4DLAnYB+TCS+7fQesaq69BIBDetIWudaS+pdAohzLz8PXJiMrBoNk23PrVwdhe6E6BXh1b33WnsbSwTvbwvo402cY9+RndnOCBRhIm7ehJKyt1x4erm3luXhyz4PISmwLJ+1FIP4rF5jNi6jyEPpyHuLB7jfr8WbOOkhlsTiRVc0KmfTycVyxQXZayGyIhABGZGFfewY9N2oL8btucebP06TDUX5fL1abNTnGUe6yDjfTKV7ndQ4RBBw1k0cIVJCandQ3P5hG4vOQSslpPMq5QXXI/XjyiBFD1VZWDEwIDAQAB-----END PUBLIC KEY-----";
    private static final String ASSERTION_DATE = "1505322211793";
    private static final String EXPIRATION_DATE = "1642527163582";

    private Array<String> buildNodeArray() {
        Array<String> na = new Array<String>();
        na.push("COMP-A");
        na.push("COMP-B");
        na.push("COMP-C");
        na.push("COMP-D");
        na.push("COMP-E");
        na.push("COMP-F");
        na.push("COMP-G");
        na.push("COMP-H");
        na.push("COMP-I");
        na.push("COMP-J");
        na.push("COMP-K");
        return na;
    }

    private Array<CgEdge> buildEdgeArray() {
        Array<CgEdge> ea = new Array<CgEdge>();
        CgEdge ce;
        ce = new CgEdge("COMP-A","COMP-B","requires");
        ea.push(ce);
        ce = new CgEdge("COMP-B","COMP-C","requires");
        ea.push(ce);
        ce = new CgEdge("COMP-C","COMP-A","requires");
        ea.push(ce);
        ce = new CgEdge("COMP-A","COMP-D","requires");
        ea.push(ce);
        ce = new CgEdge("COMP-I","COMP-K","enables");
        ea.push(ce);
        ce = new CgEdge("COMP-J","COMP-K","enables");
        ea.push(ce);
        ce = new CgEdge("COMP-E","COMP-G","narrows");
        ea.push(ce);
        ce = new CgEdge("COMP-F","COMP-G","narrows");
        ea.push(ce);
        return ea;
    }

    private Array<SimpleAssertion> buildPositiveAssertionArray() {
        Array<SimpleAssertion> paa = new Array<SimpleAssertion>();
        SimpleAssertion sa;
        sa = new SimpleAssertion("pa-1", "COMP-A", 0.82);
        sa.setSubjectPem(SUBJECT_PEM);
        sa.setAssertionDate(new Long(ASSERTION_DATE));
        sa.setExpirationDate(new Long(EXPIRATION_DATE));
        sa.setNegative(false);
        paa.push(sa);
        sa = new SimpleAssertion("pa-2", "COMP-B", 0.82);
        sa.setSubjectPem(SUBJECT_PEM);
        sa.setAssertionDate(new Long(ASSERTION_DATE));
        sa.setExpirationDate(new Long(EXPIRATION_DATE));
        sa.setNegative(false);
        paa.push(sa);
        sa = new SimpleAssertion("pa-3", "COMP-G", 1.0);
        sa.setSubjectPem(SUBJECT_PEM);
        sa.setAssertionDate(new Long(ASSERTION_DATE));
        sa.setExpirationDate(new Long(EXPIRATION_DATE));
        sa.setNegative(false);
        paa.push(sa);
        sa = new SimpleAssertion("pa-4", "COMP-I", 1.0);
        sa.setSubjectPem(SUBJECT_PEM);
        sa.setAssertionDate(new Long(ASSERTION_DATE));
        sa.setExpirationDate(new Long(EXPIRATION_DATE));
        sa.setNegative(false);
        paa.push(sa);
        sa = new SimpleAssertion("pa-5", "COMP-K", 1.0);
        sa.setSubjectPem(SUBJECT_PEM);
        sa.setAssertionDate(new Long(ASSERTION_DATE));
        sa.setExpirationDate(new Long(EXPIRATION_DATE));
        sa.setNegative(false);
        paa.push(sa);
        return paa;
    }

    private Array<SimpleAssertion> buildNegativeAssertionArray() {
        Array<SimpleAssertion> naa = new Array<SimpleAssertion>();
        SimpleAssertion sa;
        sa = new SimpleAssertion("na-1", "COMP-D", 0.82);
        sa.setSubjectPem(SUBJECT_PEM);
        sa.setAssertionDate(new Long(ASSERTION_DATE));
        sa.setExpirationDate(new Long(EXPIRATION_DATE));
        sa.setNegative(true);
        naa.push(sa);
        sa = new SimpleAssertion("na-1", "COMP-E", 1.0);
        sa.setSubjectPem(SUBJECT_PEM);
        sa.setAssertionDate(new Long(ASSERTION_DATE));
        sa.setExpirationDate(new Long(EXPIRATION_DATE));
        sa.setNegative(true);
        naa.push(sa);
        return naa;
    }

    private CompetencyGraph generateTestCompetencyGraph() {
        CompetencyGraph cg = new CompetencyGraph(true);
        cg.setNodes(buildNodeArray());
        cg.setEdges(buildEdgeArray());
        cg.setPositiveAssertions(buildPositiveAssertionArray());
        cg.setNegativeAssertions(buildNegativeAssertionArray());
        return cg;
    }

    @Test
    public void runPredictiveAssertionProcessorTest() {
        CompetencyGraph cg = generateTestCompetencyGraph();
        Global.console.log("*******************************Input Competency Graph: ");
        Global.console.log(cg.getJsonString());
        PredictiveAssertionProcessor pap = new PredictiveAssertionProcessor();
        PapNetworkPrediction pnp = pap.predictAll(cg,SUBJECT_PEM, null,null,null);
        Global.console.log("*******************************Prediction: ");
        Global.console.log(pnp.getJsonString());
    }

}
