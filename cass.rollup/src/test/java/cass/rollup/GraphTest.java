package cass.rollup;

import cass.rollup.processors.v2.graph.CompetencyGraph;
import cass.rollup.processors.v2.graph.CompetencyGraphBuilder;
import cass.rollup.processors.v2.graph.ExceptionReturn;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "lib/require.js", "rollupInit.js", "/forge/forge.bundle.js" })
public class GraphTest extends EvidenceProcessingTestBase {

    @Test
    public void generateBasicGraphTest() {
        Global.console.log("Start generateBasicGraphTest");

        CompetencyGraphBuilder cgb = new CompetencyGraphBuilder();
        cgb.frameworkId = "https://dev.cassproject.org/api/custom/data/schema.cassproject.org.0.2.Framework/16e49f6b-cd42-4edf-9e2c-4d80d4246672";
        cgb.rootCompetencyId = "https://dev.cassproject.org/api/custom/data/schema.cassproject.org.0.2.Competency/0066c94e-d07a-4010-ad6f-a5be36cff874";
        cgb.success = new Callback1<CompetencyGraph>()
        {
            @Override
            public void $invoke(CompetencyGraph cg)
            {
                Global.console.log("CompetencyGraphBuilder success :)");
                Global.console.log("Object: " + cg);
                Global.console.log("JSON String: " + cg.getJsonString());
                Assert.assertSame(true,true);
            }
        };
        cgb.failure = new Callback1<ExceptionReturn>()
        {
            @Override
            public void $invoke(ExceptionReturn er)
            {
                Global.console.log("CompetencyGraphBuilder failed :(");
                Global.console.log("Object: " + er);
                Global.console.log("JSON String: " + er.getJsonString());
                Assert.fail();
            }
        };
        cgb.buildCompetencyGraph(true);

    }

}
