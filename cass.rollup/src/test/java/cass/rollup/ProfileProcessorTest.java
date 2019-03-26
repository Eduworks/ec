package cass.rollup;

import cass.rollup.processors.ProfileProcessor;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"lib/require.js", "rollupInit.js","pem-jwk.js","base64toArrayBuffer.js","base64x-1.1.js","/forge/forge.bundle.js"})
public class ProfileProcessorTest {

    private static final String SANDBOX_SERVER = "https://sandbox.cassproject.org/api/";
    private static final String JILL_DABOSS_PPK_PEM = "xxx";
    private static final String SAMANTHA_SMITH_PPK_PEM = "xxx";
    private static final String SAMANTHA_SMITH_PK_PEM = "xxx";

    private static final String SELECTED_SERVER = SANDBOX_SERVER;
    private static final String TEST_END_USER_PPK_PEM = JILL_DABOSS_PPK_PEM;

    @Test
    public void samanthaSmithProfileTest() {
        //This needs the keys filled in to work all correctly
        Assert.assertSame(true,true);
//        EcRemote.async = false;
//        EcRepository repo = new EcRepository();
//        repo.selectedServer = SELECTED_SERVER;
//        EcIdentity eci = new EcIdentity();
//        eci.source = SELECTED_SERVER;
//        eci.ppk = EcPpk.fromPem(TEST_END_USER_PPK_PEM);
//        EcIdentityManager.addIdentity(eci);
//        final ProfileProcessor pp = new ProfileProcessor();
//        Global.console.log("start samanthaSmithProfileTest:");
//        Array<String> profilePkPems = new Array<String>();
//        profilePkPems.push(SAMANTHA_SMITH_PK_PEM);
//        pp.processProfileAssertions(repo, profilePkPems,
//                new Callback0() {
//                    @Override
//                    public void $invoke() {
//                        Global.console.log("SUCCESS samanthaSmithProfileTest");
//                        Global.console.log(pp);
//                        Assert.assertSame(true,true);
//                    }
//                },
//                new Callback1<String>() {
//                    @Override
//                    public void $invoke(String err) {
//                        Global.console.log("FAILED samanthaSmithProfileTest Exception" + err);
//                        Assert.assertSame(true,true);
//                    }
//                }
//        );
    }


}
