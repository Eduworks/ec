package com.eduworks.ec.crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/forge/forge.bundle.js" })
public class EcPpkTest
{

	@Test
	public void ppkPkKeyTest()
	{
		EcPpk ppk = EcPpk.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
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
