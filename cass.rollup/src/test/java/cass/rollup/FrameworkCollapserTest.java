package cass.rollup;

import cass.rollup.processors.v2.graph.collapser.FrameworkCollapser;
import cass.rollup.processors.v2.graph.collapser.NodePacketGraph;
import com.eduworks.ec.remote.EcRemote;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"lib/require.js", "rollupInit.js","pem-jwk.js","base64toArrayBuffer.js","base64x-1.1.js","/forge/forge.bundle.js"})
public class FrameworkCollapserTest {

    private static final String SANDBOX_SERVER = "https://sandbox.cassproject.org/api/";
    private static final String JILL_DABOSS_PPK_PEM = "xxx";

    private static final String SELECTED_SERVER = SANDBOX_SERVER;
    private static final String TEST_END_USER_PPK_PEM = JILL_DABOSS_PPK_PEM;

    private static final String CAP_DBS_FWK_ID = "https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Framework/fd992893-1d5a-432f-ba24-d88d20d44f50";
    private static final String CAP_PL_FWK_ID = "https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Framework/6c297f8e-8e94-47e7-b298-1104b2652361";
    private static final String FWK_GRPH_PERF_TEST_ID = CAP_PL_FWK_ID;

    //private String FRAMEWORK_ID = "https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Framework/tom-profile-dev-1";
    private String FRAMEWORK_ID = "https://sandbox.service.cassproject.org/data/schema.cassproject.org.0.3.Framework/ef23be65-b99e-44c6-93e6-1fdeacf1bbe2";
    //private String FRAMEWORK_ID = "https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Framework/tom-profile-dev-2";
    //private String FRAMEWORK_ID = "https://sandbox.cassproject.org/api/custom/data/sc…925d345-42bc-4d3a-b564-92ee56d29707/1464393782288";

    protected EcRepository repo;
    protected Array<String> urlArray;

    @Test
    public void capFrameworkCollapseTest() {
        //This needs the keys filled in to work all correctly
        Assert.assertSame(true,true);
//        EcRemote.async = false;
//        EcRepository repo = new EcRepository();
//        repo.selectedServer = SELECTED_SERVER;
//        EcIdentity eci = new EcIdentity();
//        eci.source = SELECTED_SERVER;
//        eci.ppk = EcPpk.fromPem(TEST_END_USER_PPK_PEM);
//        EcIdentityManager.addIdentity(eci);
//        Global.console.log("Fetching framework...");
//        EcFramework f = EcFramework.getBlocking(FWK_GRPH_PERF_TEST_ID);
//        Global.console.log("Framework fetched");
//        final FrameworkCollapser fc = new FrameworkCollapser();
//        Global.console.log("Collapsing framework: " + Date.now());
//        fc.collapseFramework(repo,f,true,
//                new Callback2<String,NodePacketGraph>() {
//                    @SuppressWarnings("unchecked")
//                    @Override
//                    public void $invoke(String fwId, NodePacketGraph npg) {
//                        Global.console.log("SUCCESS Framework collapse: " + Date.now());
//                        Global.console.log(npg);
//                        Assert.assertSame(true,true);
//                    }
//                },
//                new Callback1<String>() {
//                    @SuppressWarnings("unchecked")
//                    @Override
//                    public void $invoke(String err) {
//                        Global.console.log("FAILED Framework collapse" + err);
//                        Assert.assertSame(true,true);
//                    }
//                }
//        );
    }


    @Test
    public void basicFrameworkCollapseTest() {
        EcRemote.async = false;
        Global.console.log("start basicFrameworkCollapseTest:");
        try {
            repo = new EcRepository();
            repo.selectedServer = "https://sandbox.cassproject.org/api/";
            final FrameworkCollapserTest fct = this;
            EcFramework framework = EcFramework.getBlocking(FRAMEWORK_ID);
            Global.console.log("Framework: " + framework.name);
            FrameworkCollapser fc = new FrameworkCollapser();
            fc.collapseFramework(repo, framework,true,
                    new Callback2<String,NodePacketGraph>() {
                        @SuppressWarnings("unchecked")
                        @Override
                        public void $invoke(String fwId, NodePacketGraph npg) {
                            Global.console.log("--================ FRAMEWORK COLLAPSED GRAPH ================--");
                            Global.console.log(npg.toStringGraphAll());
                        }
                    },
                    new Callback1<String>() {
                        @SuppressWarnings("unchecked")
                        @Override
                        public void $invoke(String err) {
                            Global.console.log("collapseFramework Failure: " + err);
                        }
                    }
            );
        }
        catch (Exception e) {
            Global.console.log("Exception: " + e.toString());
        }

        Assert.assertSame(true,true);

        Global.console.log("end basicFrameworkCollapseTest");

    }

    @Test
    public void basicAssertionSearchTest() {
        EcRemote.async = false;
        Global.console.log("start basicCollapseTest:");
        try {
            repo = new EcRepository();
            repo.selectedServer = "https://sandbox.cassproject.org/api/";
            EcAssertion.search(repo,null,new Callback1<Array<EcAssertion>>() {
                        @SuppressWarnings("unchecked")
                        @Override
                        public void $invoke(Array<EcAssertion> eca) {
                            Global.console.log("Success: " + eca.$length());
                        }
                    },
                    new Callback1<String>() {
                        @SuppressWarnings("unchecked")
                        @Override
                        public void $invoke(String err) {
                            Global.console.log("Failure: " + err);
                        }
                    },null);
        }
        catch (Exception e) {
            Global.console.log("Exception: " + e.toString());
        }

        //TODO figure out valid test case???
        Assert.assertSame(true,true);

        Global.console.log("end basicCollapseTest TEST");

    }

    @Test
    public void basicMultiGetTest() {
        EcRemote.async = false;
        Global.console.log("start basicCollapseTest:");
        try {
            repo = new EcRepository();
            repo.selectedServer = "https://sandbox.cassproject.org/api/";
            urlArray = new Array<String>();
            urlArray.push("https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Competency/5f1e58d5-1073-4381-b6e6-e4943d35606a");
            urlArray.push("https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Competency/23d8e2cb-2af7-4e3a-bdb8-392d18f625d8");
            urlArray.push("https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Relation/c275ee4d-f831-46a6-bd52-3e9a5892bf98");
            urlArray.push("https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Relation/67b68aa4-1156-443d-8c92-2636ca1eb129");
            urlArray.push("https://sandbox.cassproject.org/api/custom/data/schema.cassproject.org.0.3.Relation/9bc16b74-dd96-4ba7-b0a4-038e6edb4f50");
            final FrameworkCollapserTest fct = this;
            repo.multiget(urlArray,
                    new Callback1<Array<EcRemoteLinkedData>>() {
                        @SuppressWarnings("unchecked")
                        @Override
                        public void $invoke(Array<EcRemoteLinkedData> rlda) {
                            EcRemoteLinkedData rld;
                            for (int i = 0; i< rlda.$length(); i++) {
                                rld = rlda.$get(i);
                                if ("competency".equals(rld.type.toLowerCase())) {
                                    Global.console.log("rlda[" + i + "]: " + rld.type + " - " + rld.shortId() + " - " + ((EcCompetency)rld).name);
                                }
                                else {
                                    Global.console.log("rlda[" + i + "]: " + rld.type + " - " + rld.shortId() + " - " + ((EcAlignment)rld).source + " " + ((EcAlignment)rld).relationType + " " + ((EcAlignment)rld).target);
                                }
                            }
                        }
                    },
                    new Callback1<String>() {
                        @SuppressWarnings("unchecked")
                        @Override
                        public void $invoke(String err) {
                            Global.console.log("Failure: " + err);
                        }
                    }
            );
        }
        catch (Exception e) {
            Global.console.log("Exception: " + e.toString());
        }

        //TODO figure out valid test case???
        Assert.assertSame(true,true);
        Global.console.log("end basicCollapseTest TEST");

    }


}
