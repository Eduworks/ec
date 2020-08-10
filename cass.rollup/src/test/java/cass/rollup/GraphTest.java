package cass.rollup;

import cass.rollup.processors.v2.graph.CompetencyGraph;
import cass.rollup.processors.v2.graph.CompetencyGraphBuilder;
import cass.rollup.processors.v2.graph.ExceptionReturn;
import org.cassproject.ebac.repository.EcRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "lib/require.js", "rollupInit.js", "/forge/forge.bundle.js" })
public class GraphTest extends EvidenceProcessingTestBase {

    private static final String REPOSITORY_URL = "https://dev.cassproject.org/api/";
    private static final String FRAMREWORK_ID = "https://dev.cassproject.org/api/data/schema.cassproject.org.0.2.Framework/775965fc-6b50-4b78-b15e-cc60fbad66a0";
    private static final String COMPETENCY_ID = "https://dev.cassproject.org/api/data/schema.cassproject.org.0.2.Competency/1f2126b3-cb90-4ab2-a646-40da40384c93";
    //private static final String COMPETENCY_ID = "https://dev.cassproject.org/api/data/schema.cassproject.org.0.2.Competency/48b4ba83-3aa4-475a-bff5-de4e3c05613e";
    private static final boolean CREATE_IMPLIED_EDGES = true;
    private static final boolean ADD_ASSERTIONS = true;

    private CompetencyGraphBuilder buildAndConfigureGraphBuilder() {
        EcRepository repo = new EcRepository();
        repo.selectedServer = REPOSITORY_URL;
        EcRepository.alwaysTryUrl = true;
        CompetencyGraphBuilder cgb = new CompetencyGraphBuilder();
        cgb.repositories.push(repo);
        cgb.includeAssertions = ADD_ASSERTIONS;
        cgb.frameworkId = FRAMREWORK_ID;
        cgb.rootCompetencyId = COMPETENCY_ID;
        cgb.success = new Callback1<CompetencyGraph>() {
            @Override
            public void $invoke(CompetencyGraph cg)
            {
                Global.console.log("CompetencyGraphBuilder success :)");
                Global.console.log("Object: " + cg);
                Global.console.log("JSON String: " + cg.getJsonString());
                Assert.assertSame(true,true);
            }
        };
        cgb.failure = new Callback1<ExceptionReturn>() {
            @Override
            public void $invoke(ExceptionReturn er)
            {
                Global.console.log("CompetencyGraphBuilder failed :(");
                Global.console.log("Object: " + er);
                Global.console.log("JSON String: " + er.getJsonString());
                Assert.fail();
            }
        };
        return cgb;
    }

    @Test
    public void generateBasicGraphTest() {
        Global.console.log("Start generateBasicGraphTest");
        CompetencyGraphBuilder cgb = buildAndConfigureGraphBuilder();
        //Added createImpliedEdges as a required parameter instead of a config item to force the consumer to acknowledge what is happening...
        cgb.buildCompetencyGraph(CREATE_IMPLIED_EDGES);
    }

}
