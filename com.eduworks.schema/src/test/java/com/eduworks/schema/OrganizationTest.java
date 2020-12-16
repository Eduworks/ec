package com.eduworks.schema;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.schema.EcOrganization;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"pem-jwk.js", "require.js", "/forge/forge.bundle.js"})
public class OrganizationTest {

    private static final String CASS_SERVER = "";
    private static final String PPK_PEM = "";

    private static final String ORG_ID = "";

    static EcIdentity newId1 = new EcIdentity();
    static EcRepository repo = new EcRepository();

    @Before
    public void setup() {
//        Global.console.log("setup");
//
//        EcRemote.async = false;
//
//        repo.selectedServer = CASS_SERVER;
//
//        EcPpk ppk = EcPpk.fromPem(PPK_PEM);
//
//        newId1.ppk = ppk;
//        EcIdentityManager.ids = new Array<EcIdentity>();
//        EcIdentityManager.addIdentity(newId1);
    }

    @Test
    public void basicOrganizationUpgradeTest() {
//        Global.console.log("start basicOrganizationUpgradeTest");
//        EcOrganization o = EcOrganization.getBlocking(ORG_ID);
//        Global.console.log(o.getName());
        // o.rekeyAndSave(null,null,repo);
        Assert.assertTrue(true);
    }

}
