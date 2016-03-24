package com.eduworks.ec.crypto;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/forge/forge.bundle.js" })
public class EcPpkTest
{

	@Test
	public void keyGenerationTest()
	{
		console.log("Key Generation Test.");
		EcPpk ppk = EcPpk.generateKey();
		assertTrue("PPK != null",ppk.ppk != null);
		assertTrue("PPK.N != 0",ppk.ppk.n != 0);
		assertTrue("PPK.E != 0",ppk.ppk.e != 0);
		assertTrue("PPK.D != 0",ppk.ppk.d != 0);
		assertTrue("PPK.P != 0",ppk.ppk.p != 0);
		assertTrue("PPK.Q != 0",ppk.ppk.q != 0);
		String ppkPem = ppk.toPem();
		console.log(ppkPem);
		assertTrue("PPK.toPem != null",ppkPem != null);
		EcPk pk = ppk.toPk();
		console.log(pk.toPem());
		assertTrue("PPK.toPk != null",pk != null);
		assertTrue("PPK.toPk().pk != null",pk.pk != null);
		assertTrue("PPK.toPk().e == PPK.e",pk.pk.e == ppk.ppk.e);
		assertTrue("PPK.toPk().n == PPK.n",pk.pk.n == ppk.ppk.n);
		EcPpk ppkToFromPem = EcPpk.fromPem(ppkPem);
		assertTrue("PPK.toPem().fromPem().n == PPK.n",(""+ppkToFromPem.ppk.n) == (""+ppk.ppk.n));
		assertTrue("PPK.toPem().fromPem().e == PPK.e",(""+ppkToFromPem.ppk.e) == (""+ppk.ppk.e));
		assertTrue("PPK.toPem().fromPem().d == PPK.d",(""+ppkToFromPem.ppk.d) == (""+ppk.ppk.d));
		assertTrue("PPK.toPem().fromPem().p == PPK.p",(""+ppkToFromPem.ppk.p) == (""+ppk.ppk.p));
		assertTrue("PPK.toPem().fromPem().q == PPK.q",(""+ppkToFromPem.ppk.q) == (""+ppk.ppk.q));
		EcPk pkToFromPem = EcPk.fromPem(pk.toPem());
		assertTrue("PPK.toPk().toPem().fromPem().n == PPK.n",(""+pkToFromPem.pk.n) == (""+ppk.ppk.n));
		assertTrue("PPK.toPk().toPem().fromPem().e == PPK.e",(""+pkToFromPem.pk.e) == (""+ppk.ppk.e));
	}
	
	
}
