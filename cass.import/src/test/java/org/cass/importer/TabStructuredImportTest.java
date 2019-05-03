package org.cass.importer;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"lib/require.js", "rollupInit.js", "base64toArrayBuffer.js", "base64toArrayBuffer.js"})
public class TabStructuredImportTest extends ImportTestBase {

    @Test
    public void basicTabStructuredImport() {
        final TabStructuredImportTest me = this;
        TabStructuredImport.importCompetencies("A\n" +
                "\tA.1\n" +
                "\t\tA.1.1\n" +
                "\tA.2\n" +
                "\t\tA.2.1\n" +
                "\t\tA.2.2\n" +
                "\t\t\tA.2.2.1\n" +
                "B\n" +
                "\tB.1\n" +
                "\t\tB.1.1\n" +
                "\tB.2\n" +
                "\t\tB.2.1\n" +
                "\t\tB.2.2\n" +
                "\t\t\tB.2.2.1\n" +
                "C\n" +
                "D\n" +
                " D.1\n" +
                " D.2\n" +
                "  D.2.1\n" +
                "  D.2.2\n" +
                " D.3\n" +
                "  D.3.1\n" +
                "E", repo.selectedServer, newId1, new Callback2<Array<EcCompetency>, Array<EcAlignment>>() {
            @Override
            public void $invoke(Array<EcCompetency> competencies, Array<EcAlignment> alignments) {
                EcFramework f = new EcFramework();
                f.setName("Tab Structured Import Test Framework");
                f.generateId(me.repo.selectedServer);
                f.competency = new Array<>();
                f.relation = new Array<>();
                final Array<EcRemoteLinkedData> everything = new Array<>();
                for (int i = 0;i < competencies.$length();i++) {
                    f.competency.push(competencies.$get(i).shortId());
                    everything.push(competencies.$get(i));
                }
                for (int i = 0;i < alignments.$length();i++) {
                    f.relation.push(alignments.$get(i).shortId());
                    everything.push(alignments.$get(i));
                }
                everything.push(f);
                me.repo.multiput(everything, new Callback1<String>() {
                    @Override
                    public void $invoke(String s) {
                        for (int i = 0;i < everything.$length();i++)
                            me.repo.deleteRegistered(everything.$get(i),null,failure);
                    }
                }, failure);
            }
        }, failure, logObject,repo,false);
    }
}
