package cass.rollup;

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

    //test
//    private class TestClass {
//        private String name;
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }

    @Test
    public void generateBasicGraphTest() {
        Global.console.log("Start generateBasicGraphTest");
//        TestClass test = new TestClass();
//        test.setName("testName");
//        Global.console.log("Stringify: " + Global.JSON.stringify(test));
        EcFramework.get("http://dev.cassproject.org/api/custom/data/schema.cassproject.org.0.2.Framework/16e49f6b-cd42-4edf-9e2c-4d80d4246672/1490720392795",
                new Callback1<EcFramework>()
                {
                    @Override
                    public void $invoke(EcFramework f) {
                        Global.console.log("Framework fetched: " + f.name);
                        Assert.assertSame(true,true);
                    }
                },
                new Callback1<String>()
                {
                    @Override
                    public void $invoke(String s) {
                        Global.console.log("Framework fetch failed: " + s);
                        Assert.assertSame(true,false);
                    }
                });

    }

}
