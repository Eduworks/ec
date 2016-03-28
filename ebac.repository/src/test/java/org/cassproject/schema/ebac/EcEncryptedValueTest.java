package org.cassproject.schema.ebac;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcFile;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.schema.ebac.EbacEncryptedValue;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/forge/forge.bundle.js" })
public class EcEncryptedValueTest
{
	@Test
	public void encryptDecryptTest()
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
		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;
		EcIdentityManager.addIdentity(newId1);
		EcEncryptedValue v = null;
		console.log("Encrypting: " + f.name);
		v = EcEncryptedValue.encryptValueOld(f.name, f.id, "name", ppk.toPk());
		console.log("Encrypted object: " + v.toJson());
		assertTrue("Owner exists in encrypted object.", v.hasOwner(ppk.toPk()));
		assertTrue("Owner can decrypt object.", v.decryptIntoString().equals(f.name));
		Array<String> readers = new Array<String>();
		readers.push(ppk2.toPk().toPem());
		EcEncryptedValue v2 = null;
		console.log("Encrypting: " + f.name);
		v2 = EcEncryptedValue.encryptValue(f.name, f.id, "name", f.owner, readers);
		console.log("Encrypted object: " + v2.toJson());

		EcIdentity newId2 = new EcIdentity();
		newId2.ppk = ppk2;
		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId2);
		assertTrue("Reader Decryption:", v2.decryptIntoString().equals(f.name));
	}

	@Test
	public void encryptObjectUploadDownloadDecryptTest()
	{
		EcRemote.async = false;
		console.log("Encrypted Object Upload Download then Decrypt Test.");
		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcPpk ppk2 = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAl4oeWRsroJqAR8UXkmkhDHMcRaDM6a9wsFWNkokyugMevv5TtwHVrm9HMJqVlXn1U1AiVS1rEYB7Iavi2IE7e8WV6GkLrGTrce+YcqhrwF3g104ZEuIC2aFCcLrxvXbSqmmuddS3lRMEwqdWkYIS7MKRSKUBpbydl8wScYxjzUSMNzQrvgUpNc//N7GkpEFXYLjYmVWhYdUp578nw/K9StRqTfku8U+Ub86U0mHXowms4spV8IoOlV53OLpOL+8QwcQYZ+koWL4B0rhz6cvelvBAFygx94t8IzZtRiBniaTF+1nBjyj4+R8PdprxFNnM+S2IQBqUdBKJ3oDoKMqdAwIDAQABAoIBAC3BWmB1P7sCa3FAJVnjvELSDttHLhfxDQlxC4oPOu3HO2VXzVcYirhciRY31qqHZHd/Xp5xVD64mHUWPSw5+QfqJNVDwm6PGjgQq+sSx1YSAm1/+zokW8/yTOlUyOD4G6uwtSiGzdeJIorTk+PjbmtmZA+XIuQ0CzFmQLtgNFIpxRmDKLZrjEO5NSaeStZRgi+WVkgfOnvQvWtFK8/djeXfb4f3BnquCRKjm/cOjtdqBHcFq7Fzlyh0U64XXcJPPgBX3hLNK7mr0ZBCwUDOUs0Xna0a/2FHsjESPX7grZ9J1fbkXRwUrSJ04zbeijqROkjni7wokT+HiWtVcZ/HLOECgYEA0/CykuniBAE+Oqt+qj1OEQSnyiENJffnSzeOOjI17ygxcXYFxprEVjYL1ZVj28appGqs4tueNRoxl7jf4jpD6sDMM32scwmUcCA6K3yqk/F/WVj4MYdn7ETtACCZ9m08EUzksrWOaAb86jqm7k1+mM5xu6lbN3dSua1lKxsNFi0CgYEAtwrwuVupz+GmMna7DtW9S2q0ZwgSoUEcELqcXq2cwAPutrd4rh/xS1xsZZNGqnyT1b3/6vFT2zAyxUiL3o+bhDEEv5HcRJ2rugIhUq2dPAJMYf+kBAFONakir2wHwUUXIkaEHecwxsaI8rsTnXDW+anbJogZSLNcFOBydOaBLe8CgYBKDZknsibxxUlsEI4Ch8cmNR03iBLjCFq9sly0wuSLetzDyzw7Z8pgYSQDbd5lZWXS+B8OaTQ/U7auT7+SeU9P0CvJdgjybQ97mhcZKMclSEV5/5dBHxHVwUOaPsntC7/oP5jNRJjMilyGrxWywEsSs1eT/ZnMqJm0HPzzcdFBxQKBgQAMOkTefQsZAf/yOxA/63NbyGMIxvdHomvXij/L61kfUqPtvM/pAeVCnYf4OSBtXykZDDo+XaS2bb/WggQl9/3xlLy2d235f3brVB0ZwtNQIO8tVMCGK/gniYbxpQvXk1/6QC+vN7SAct7PKEQlLlaOExS6vDjELIcoNd4vhP54LQKBgQAOE7+S2AdjUEVXqWBPnlidZV08HMduy3yZ7mblCX0dA07/ozuM/WOfk92cgqcLddOmsbYdTuqTq1sB98v1QN1RwYe9Eiw0dmfbFlQcXT1YAZVfHNQOMO2xI4gJtkNGUqg1HQsYghOO2wkNHSMCNsoq9GWeIzCF2q6/7oH74jfoaQ==-----END RSA PRIVATE KEY-----");
		EcFile f = new EcFile();
		f.name = "My_File.txt";
		f.mimeType = "text/plain";
		f.data = "BASE64ENCODEDDATA";
		f.generateId("http://skyrepo.service.eduworks.com");
		f.checksum = "ABC123";
		f.addOwner(ppk.toPk());
		f.signWith(ppk);
		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;
		EcIdentityManager.addIdentity(newId1);
		EcEncryptedValue v = null;
		console.log("Encrypting: " + f.name);
		v = EcEncryptedValue.toEncryptedValue(f, false);
		console.log("Encrypted object: " + v.toJson());
		assertTrue("Owner exists in encrypted object.", v.hasOwner(ppk.toPk()));
		EcRepository.save(v, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Saved.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});
		EcRepository.get(v.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				console.log("Read.");
				EcEncryptedValue val = new EcEncryptedValue();
				val.copyFrom(p1);
				EcRemoteLinkedData decryptedObject = val.decryptIntoObject();
				EcFile file = new EcFile();
				file.copyFrom(decryptedObject);
				assertTrue(file.name.equals(f.name));
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Assert.fail("Failed to read object.");
			}
		});
		EcRepository._delete(f, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{

			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Assert.fail("Failed to delete object. " + p1);
			}
		});
	}

	@Test
	public void encryptValueUploadDownloadDecryptTest()
	{
		EcRemote.async = false;
		console.log("Encrypted Value Upload Download then Decrypt Test.");
		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcPpk ppk2 = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAl4oeWRsroJqAR8UXkmkhDHMcRaDM6a9wsFWNkokyugMevv5TtwHVrm9HMJqVlXn1U1AiVS1rEYB7Iavi2IE7e8WV6GkLrGTrce+YcqhrwF3g104ZEuIC2aFCcLrxvXbSqmmuddS3lRMEwqdWkYIS7MKRSKUBpbydl8wScYxjzUSMNzQrvgUpNc//N7GkpEFXYLjYmVWhYdUp578nw/K9StRqTfku8U+Ub86U0mHXowms4spV8IoOlV53OLpOL+8QwcQYZ+koWL4B0rhz6cvelvBAFygx94t8IzZtRiBniaTF+1nBjyj4+R8PdprxFNnM+S2IQBqUdBKJ3oDoKMqdAwIDAQABAoIBAC3BWmB1P7sCa3FAJVnjvELSDttHLhfxDQlxC4oPOu3HO2VXzVcYirhciRY31qqHZHd/Xp5xVD64mHUWPSw5+QfqJNVDwm6PGjgQq+sSx1YSAm1/+zokW8/yTOlUyOD4G6uwtSiGzdeJIorTk+PjbmtmZA+XIuQ0CzFmQLtgNFIpxRmDKLZrjEO5NSaeStZRgi+WVkgfOnvQvWtFK8/djeXfb4f3BnquCRKjm/cOjtdqBHcFq7Fzlyh0U64XXcJPPgBX3hLNK7mr0ZBCwUDOUs0Xna0a/2FHsjESPX7grZ9J1fbkXRwUrSJ04zbeijqROkjni7wokT+HiWtVcZ/HLOECgYEA0/CykuniBAE+Oqt+qj1OEQSnyiENJffnSzeOOjI17ygxcXYFxprEVjYL1ZVj28appGqs4tueNRoxl7jf4jpD6sDMM32scwmUcCA6K3yqk/F/WVj4MYdn7ETtACCZ9m08EUzksrWOaAb86jqm7k1+mM5xu6lbN3dSua1lKxsNFi0CgYEAtwrwuVupz+GmMna7DtW9S2q0ZwgSoUEcELqcXq2cwAPutrd4rh/xS1xsZZNGqnyT1b3/6vFT2zAyxUiL3o+bhDEEv5HcRJ2rugIhUq2dPAJMYf+kBAFONakir2wHwUUXIkaEHecwxsaI8rsTnXDW+anbJogZSLNcFOBydOaBLe8CgYBKDZknsibxxUlsEI4Ch8cmNR03iBLjCFq9sly0wuSLetzDyzw7Z8pgYSQDbd5lZWXS+B8OaTQ/U7auT7+SeU9P0CvJdgjybQ97mhcZKMclSEV5/5dBHxHVwUOaPsntC7/oP5jNRJjMilyGrxWywEsSs1eT/ZnMqJm0HPzzcdFBxQKBgQAMOkTefQsZAf/yOxA/63NbyGMIxvdHomvXij/L61kfUqPtvM/pAeVCnYf4OSBtXykZDDo+XaS2bb/WggQl9/3xlLy2d235f3brVB0ZwtNQIO8tVMCGK/gniYbxpQvXk1/6QC+vN7SAct7PKEQlLlaOExS6vDjELIcoNd4vhP54LQKBgQAOE7+S2AdjUEVXqWBPnlidZV08HMduy3yZ7mblCX0dA07/ozuM/WOfk92cgqcLddOmsbYdTuqTq1sB98v1QN1RwYe9Eiw0dmfbFlQcXT1YAZVfHNQOMO2xI4gJtkNGUqg1HQsYghOO2wkNHSMCNsoq9GWeIzCF2q6/7oH74jfoaQ==-----END RSA PRIVATE KEY-----");
		EcFile f = new EcFile();
		f.name = "My_File.txt";
		f.mimeType = "text/plain";
		f.data = "BASE64ENCODEDDATA";
		f.generateId("http://skyrepo.service.eduworks.com");
		f.checksum = "ABC123";
		f.addOwner(ppk.toPk());
		f.signWith(ppk);
		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;
		EcIdentityManager.addIdentity(newId1);
		JSObjectAdapter.$put(f, "name", EcEncryptedValue.encryptValue(f.name, f.shortId(), "name", f.owner, null));
		console.log(f.toJson());
		EcRepository.save(f, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Saved.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});
		EcRepository.get(f.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				console.log("Read.");
				EcFile val = new EcFile();
				console.log(p1.toJson());
				val.copyFrom(p1);
				console.log(val.toJson());
				EcEncryptedValue val1 = new EcEncryptedValue();
				val1.copyFrom(JSObjectAdapter.$get(val, "name"));
				console.log("Encrypted, downloaded = " + val1.toJson());
				String decryptIntoString = val1.decryptIntoString();
				console.log("Decrypted = " + decryptIntoString);
				assertTrue(decryptIntoString.equals("My_File.txt"));
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Assert.fail("Failed to read object.");
			}
		});
		EcRepository._delete(f, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{

			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Assert.fail("Failed to delete object. " + p1);
			}
		});
	}

	@Test
	public void encryptValueWithReaderUploadSearchByPkWithSignatureTest()
	{
		EcRemote.async = false;
		console.log("encryptValueWithReaderUploadSearchByPkWithSignatureTest Test.");
		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcPpk ppk2 = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAl4oeWRsroJqAR8UXkmkhDHMcRaDM6a9wsFWNkokyugMevv5TtwHVrm9HMJqVlXn1U1AiVS1rEYB7Iavi2IE7e8WV6GkLrGTrce+YcqhrwF3g104ZEuIC2aFCcLrxvXbSqmmuddS3lRMEwqdWkYIS7MKRSKUBpbydl8wScYxjzUSMNzQrvgUpNc//N7GkpEFXYLjYmVWhYdUp578nw/K9StRqTfku8U+Ub86U0mHXowms4spV8IoOlV53OLpOL+8QwcQYZ+koWL4B0rhz6cvelvBAFygx94t8IzZtRiBniaTF+1nBjyj4+R8PdprxFNnM+S2IQBqUdBKJ3oDoKMqdAwIDAQABAoIBAC3BWmB1P7sCa3FAJVnjvELSDttHLhfxDQlxC4oPOu3HO2VXzVcYirhciRY31qqHZHd/Xp5xVD64mHUWPSw5+QfqJNVDwm6PGjgQq+sSx1YSAm1/+zokW8/yTOlUyOD4G6uwtSiGzdeJIorTk+PjbmtmZA+XIuQ0CzFmQLtgNFIpxRmDKLZrjEO5NSaeStZRgi+WVkgfOnvQvWtFK8/djeXfb4f3BnquCRKjm/cOjtdqBHcFq7Fzlyh0U64XXcJPPgBX3hLNK7mr0ZBCwUDOUs0Xna0a/2FHsjESPX7grZ9J1fbkXRwUrSJ04zbeijqROkjni7wokT+HiWtVcZ/HLOECgYEA0/CykuniBAE+Oqt+qj1OEQSnyiENJffnSzeOOjI17ygxcXYFxprEVjYL1ZVj28appGqs4tueNRoxl7jf4jpD6sDMM32scwmUcCA6K3yqk/F/WVj4MYdn7ETtACCZ9m08EUzksrWOaAb86jqm7k1+mM5xu6lbN3dSua1lKxsNFi0CgYEAtwrwuVupz+GmMna7DtW9S2q0ZwgSoUEcELqcXq2cwAPutrd4rh/xS1xsZZNGqnyT1b3/6vFT2zAyxUiL3o+bhDEEv5HcRJ2rugIhUq2dPAJMYf+kBAFONakir2wHwUUXIkaEHecwxsaI8rsTnXDW+anbJogZSLNcFOBydOaBLe8CgYBKDZknsibxxUlsEI4Ch8cmNR03iBLjCFq9sly0wuSLetzDyzw7Z8pgYSQDbd5lZWXS+B8OaTQ/U7auT7+SeU9P0CvJdgjybQ97mhcZKMclSEV5/5dBHxHVwUOaPsntC7/oP5jNRJjMilyGrxWywEsSs1eT/ZnMqJm0HPzzcdFBxQKBgQAMOkTefQsZAf/yOxA/63NbyGMIxvdHomvXij/L61kfUqPtvM/pAeVCnYf4OSBtXykZDDo+XaS2bb/WggQl9/3xlLy2d235f3brVB0ZwtNQIO8tVMCGK/gniYbxpQvXk1/6QC+vN7SAct7PKEQlLlaOExS6vDjELIcoNd4vhP54LQKBgQAOE7+S2AdjUEVXqWBPnlidZV08HMduy3yZ7mblCX0dA07/ozuM/WOfk92cgqcLddOmsbYdTuqTq1sB98v1QN1RwYe9Eiw0dmfbFlQcXT1YAZVfHNQOMO2xI4gJtkNGUqg1HQsYghOO2wkNHSMCNsoq9GWeIzCF2q6/7oH74jfoaQ==-----END RSA PRIVATE KEY-----");

		EcRepository r = new EcRepository();
		r.selectedServer = "http://skyrepo.service.eduworks.com";

		EcFile f = new EcFile();
		f.name = "My_File.txt";
		f.mimeType = "text/plain";
		f.data = "BASE64ENCODEDDATA";
		f.generateId(r.selectedServer);
		f.checksum = "ABC123";
		f.addOwner(ppk.toPk());
		f.signWith(ppk);
		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;
		EcIdentity newId2 = new EcIdentity();
		newId2.ppk = ppk2;
		EcIdentityManager.addIdentity(newId1);
		Array<String> readers = new Array<String>();
		readers.push(ppk2.toPk().toPem());
		JSObjectAdapter.$put(f, "name", EcEncryptedValue.encryptValue(f.name, f.shortId(), "name", f.owner, readers));
		console.log(f.toJson());
		EcRepository.save(f, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Saved.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});

		Callback1<EcRemoteLinkedData> eachCallback = new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
			}
		};
		Callback1<Array<EcRemoteLinkedData>> success = new Callback1<Array<EcRemoteLinkedData>>()
		{
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1)
			{
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++)
				{
					if (p1.$get(i).shortId().equals(f.shortId()))
						found = true;
				}
				assertTrue(found);
			}
		};
		Callback1<Array<EcRemoteLinkedData>> successInvert = new Callback1<Array<EcRemoteLinkedData>>()
		{
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1)
			{
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++)
				{
					if (p1.$get(i).shortId().equals(f.shortId()))
						found = true;
				}
				assertTrue(!found);
			}
		};
		Callback1<String> failure = new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Assert.fail(p1);
			}
		};
		try
		{
			console.log("ID Search, searching with signature 1.");
			r.search("@id:\"" + f.shortId() + "\"", eachCallback, success, failure);
			console.log("Owner Search, searching for signature 1 using signature 1 signatureSheet.");
			r.search("@owner:\"" + ppk.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("Owner Search minus whitespace, searching for signature 1 using signature 1 signatureSheet.");
			r.search("@owner:\"" + ppk.toPk().toPem().replaceAll("\r?\n", "") + "\"", eachCallback, success, failure);
			console.log("Reader Search, searching for signature 2 using signature 1 signatureSheet.");
			r.search("@reader:\"" + ppk2.toPk().toPem() + "\" OR \\*\\[@reader\\]:\"" + ppk2.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("Reader Search minus whitespace, searching for signature 2 using signature 1 signatureSheet.");
			r.search("@reader:\"" + ppk2.toPk().toPem().replaceAll("\r?\n", "") + "\" OR \\*\\[@reader\\]:\"" + ppk2.toPk().toPem().replaceAll("\r?\n", "") + "\"", eachCallback, success, failure);
			console.log("_all Search, searching for signature 1 using signature 1 signatureSheet.");
			r.search("\""+ppk.toPk().toPem()+"\"", eachCallback, success, failure);
			console.log("_all Search minus whitespace, searching for signature 1 using signature 1 signatureSheet.");
			r.search("\""+ppk.toPk().toPem().replaceAll("\r?\n", "")+"\"", eachCallback, success, failure);

			EcIdentityManager.ids = new Array<EcIdentity>();
			EcIdentityManager.addIdentity(newId2);
			console.log("ID Search, searching with signature 2.");
			r.search("@id:\"" + f.shortId() + "\"", eachCallback, success, failure);
			console.log("_all Search, searching for signature 1 using signature 2 signatureSheet.");
			r.search("\""+ppk.toPk().toPem()+"\"", eachCallback, success, failure);
			console.log("_all Search, searching for signature 2 using signature 2 signatureSheet.");
			r.search("\""+ppk2.toPk().toPem()+"\"", eachCallback, success, failure);

			EcIdentityManager.ids = new Array<EcIdentity>();
			console.log("ID Search.");
			r.search("@id:\"" + f.shortId()+"\"", eachCallback, success, failure);
			console.log("_all Search, searching for signature 1.");
			r.search("\""+ppk.toPk().toPem()+"\"", eachCallback, success, failure);
			console.log("Owner Search, searching for signature 1");
			r.search("@owner:\"" + ppk.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("(SHOULD NOT FIND) Reader Search, searching for signature 2.");
			r.search("@reader:\"" + ppk2.toPk().toPem() + "\" OR \\*\\[@reader\\]:\"" + ppk2.toPk().toPem() + "\"", eachCallback, successInvert, failure);
			console.log("_all Search, searching for signature 1.");
			r.search("\""+ppk.toPk().toPem()+"\"", eachCallback, success, failure);
			console.log("(SHOULD NOT FIND) _all Search, searching for signature 2.");
			r.search("\""+ppk2.toPk().toPem()+"\"", eachCallback, successInvert, failure);
		}
		finally
		{
			EcIdentityManager.ids = new Array<EcIdentity>();
			EcIdentityManager.addIdentity(newId1);
			EcRepository._delete(f, new Callback1<String>()
			{
				@Override
				public void $invoke(String p1)
				{

				}
			}, new Callback1<String>()
			{
				@Override
				public void $invoke(String p1)
				{
					Assert.fail("Failed to delete object. " + p1);
				}
			});
		}
	}
	// Test that saves an object with an encrypted value and reads that object
	// back and checks the value.
	// Test that
}
