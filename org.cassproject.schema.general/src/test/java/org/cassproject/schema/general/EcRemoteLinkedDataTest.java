package org.cassproject.schema.general;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcPpk;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/forge/forge.bundle.js" })
public class EcRemoteLinkedDataTest
{
	@Test
	public void signableDataTest()
	{
		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcFile f = new EcFile();
		f.name = "My_File.txt";
		f.mimeType = "text/plain";
		f.data = "BASE64ENCODEDDATA";
		f.generateId("http://sandbox.service.cassproject.org");
		f.checksum = "ABC123";
		f.addOwner(ppk.toPk());
		f.signWith(ppk);
		String signableJson = f.toSignableJson();
		console.log("Signable JSON: " + signableJson);
		assertTrue("No Tabs.", signableJson.indexOf("\t") == -1);
		assertTrue("No Spaces.", signableJson.indexOf(" ") == -1);
		assertTrue("@Context before @Type", signableJson.indexOf("\"@context\"") < signableJson.indexOf("\"@type\""));
		assertTrue("@Type before Checksum", signableJson.indexOf("\"@type\"") < signableJson.indexOf("\"checksum\""));
		assertTrue("Checksum before Data", signableJson.indexOf("\"checksum\"") < signableJson.indexOf("\"data\""));
		assertTrue("Data before MimeType", signableJson.indexOf("\"data\"") < signableJson.indexOf("\"mimeType\""));
		assertTrue("MimeType before Name", signableJson.indexOf("\"mimeType\"") < signableJson.indexOf("\"name\""));
	}

	@Test
	public void signAndVerifyTest()
	{
		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcPpk ppk2 = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAl4oeWRsroJqAR8UXkmkhDHMcRaDM6a9wsFWNkokyugMevv5TtwHVrm9HMJqVlXn1U1AiVS1rEYB7Iavi2IE7e8WV6GkLrGTrce+YcqhrwF3g104ZEuIC2aFCcLrxvXbSqmmuddS3lRMEwqdWkYIS7MKRSKUBpbydl8wScYxjzUSMNzQrvgUpNc//N7GkpEFXYLjYmVWhYdUp578nw/K9StRqTfku8U+Ub86U0mHXowms4spV8IoOlV53OLpOL+8QwcQYZ+koWL4B0rhz6cvelvBAFygx94t8IzZtRiBniaTF+1nBjyj4+R8PdprxFNnM+S2IQBqUdBKJ3oDoKMqdAwIDAQABAoIBAC3BWmB1P7sCa3FAJVnjvELSDttHLhfxDQlxC4oPOu3HO2VXzVcYirhciRY31qqHZHd/Xp5xVD64mHUWPSw5+QfqJNVDwm6PGjgQq+sSx1YSAm1/+zokW8/yTOlUyOD4G6uwtSiGzdeJIorTk+PjbmtmZA+XIuQ0CzFmQLtgNFIpxRmDKLZrjEO5NSaeStZRgi+WVkgfOnvQvWtFK8/djeXfb4f3BnquCRKjm/cOjtdqBHcFq7Fzlyh0U64XXcJPPgBX3hLNK7mr0ZBCwUDOUs0Xna0a/2FHsjESPX7grZ9J1fbkXRwUrSJ04zbeijqROkjni7wokT+HiWtVcZ/HLOECgYEA0/CykuniBAE+Oqt+qj1OEQSnyiENJffnSzeOOjI17ygxcXYFxprEVjYL1ZVj28appGqs4tueNRoxl7jf4jpD6sDMM32scwmUcCA6K3yqk/F/WVj4MYdn7ETtACCZ9m08EUzksrWOaAb86jqm7k1+mM5xu6lbN3dSua1lKxsNFi0CgYEAtwrwuVupz+GmMna7DtW9S2q0ZwgSoUEcELqcXq2cwAPutrd4rh/xS1xsZZNGqnyT1b3/6vFT2zAyxUiL3o+bhDEEv5HcRJ2rugIhUq2dPAJMYf+kBAFONakir2wHwUUXIkaEHecwxsaI8rsTnXDW+anbJogZSLNcFOBydOaBLe8CgYBKDZknsibxxUlsEI4Ch8cmNR03iBLjCFq9sly0wuSLetzDyzw7Z8pgYSQDbd5lZWXS+B8OaTQ/U7auT7+SeU9P0CvJdgjybQ97mhcZKMclSEV5/5dBHxHVwUOaPsntC7/oP5jNRJjMilyGrxWywEsSs1eT/ZnMqJm0HPzzcdFBxQKBgQAMOkTefQsZAf/yOxA/63NbyGMIxvdHomvXij/L61kfUqPtvM/pAeVCnYf4OSBtXykZDDo+XaS2bb/WggQl9/3xlLy2d235f3brVB0ZwtNQIO8tVMCGK/gniYbxpQvXk1/6QC+vN7SAct7PKEQlLlaOExS6vDjELIcoNd4vhP54LQKBgQAOE7+S2AdjUEVXqWBPnlidZV08HMduy3yZ7mblCX0dA07/ozuM/WOfk92cgqcLddOmsbYdTuqTq1sB98v1QN1RwYe9Eiw0dmfbFlQcXT1YAZVfHNQOMO2xI4gJtkNGUqg1HQsYghOO2wkNHSMCNsoq9GWeIzCF2q6/7oH74jfoaQ==-----END RSA PRIVATE KEY-----");
		EcFile f = new EcFile();
		f.name = "My_File.txt";
		f.mimeType = "text/plain";
		f.data = "BASE64ENCODEDDATA";
		f.generateId("http://sandbox.service.cassproject.org");
		f.checksum = "ABC123";
		f.addOwner(ppk.toPk());
		f.signWith(ppk);
		console.log("Signature: "+f.signature.$get(0));
		assertTrue("Signature Verification",f.verify());
		f.removeOwner(ppk.toPk());
		assertTrue("Removed Owner Verification",!f.verify());
		f.addOwner(ppk2.toPk());
		f.addOwner(ppk.toPk());
		assertTrue("Multi Owner Single Signature Verification",f.verify());
		f.signWith(ppk2);
		assertTrue("Multi Owner Multi Signature Verification",f.verify());
		f.signature.$set(0, "z"+f.signature.$get(0).substring(1));
		console.log("Tampered Signature: "+f.signature.$get(0));
		assertTrue("Tampered Signature Verification",!f.verify());
	}
}
