package org.cassproject.schema.ebac;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.general.repository.GeneralFile;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"/forge/forge.bundle.js"})
public class EcEncryptedValueTest {
	static String server = "https://dev.cassproject.org/api/";

	@Test
	public void encryptDecryptTest() {
		EcPpk ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcPpk ppk2 = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAl4oeWRsroJqAR8UXkmkhDHMcRaDM6a9wsFWNkokyugMevv5TtwHVrm9HMJqVlXn1U1AiVS1rEYB7Iavi2IE7e8WV6GkLrGTrce+YcqhrwF3g104ZEuIC2aFCcLrxvXbSqmmuddS3lRMEwqdWkYIS7MKRSKUBpbydl8wScYxjzUSMNzQrvgUpNc//N7GkpEFXYLjYmVWhYdUp578nw/K9StRqTfku8U+Ub86U0mHXowms4spV8IoOlV53OLpOL+8QwcQYZ+koWL4B0rhz6cvelvBAFygx94t8IzZtRiBniaTF+1nBjyj4+R8PdprxFNnM+S2IQBqUdBKJ3oDoKMqdAwIDAQABAoIBAC3BWmB1P7sCa3FAJVnjvELSDttHLhfxDQlxC4oPOu3HO2VXzVcYirhciRY31qqHZHd/Xp5xVD64mHUWPSw5+QfqJNVDwm6PGjgQq+sSx1YSAm1/+zokW8/yTOlUyOD4G6uwtSiGzdeJIorTk+PjbmtmZA+XIuQ0CzFmQLtgNFIpxRmDKLZrjEO5NSaeStZRgi+WVkgfOnvQvWtFK8/djeXfb4f3BnquCRKjm/cOjtdqBHcFq7Fzlyh0U64XXcJPPgBX3hLNK7mr0ZBCwUDOUs0Xna0a/2FHsjESPX7grZ9J1fbkXRwUrSJ04zbeijqROkjni7wokT+HiWtVcZ/HLOECgYEA0/CykuniBAE+Oqt+qj1OEQSnyiENJffnSzeOOjI17ygxcXYFxprEVjYL1ZVj28appGqs4tueNRoxl7jf4jpD6sDMM32scwmUcCA6K3yqk/F/WVj4MYdn7ETtACCZ9m08EUzksrWOaAb86jqm7k1+mM5xu6lbN3dSua1lKxsNFi0CgYEAtwrwuVupz+GmMna7DtW9S2q0ZwgSoUEcELqcXq2cwAPutrd4rh/xS1xsZZNGqnyT1b3/6vFT2zAyxUiL3o+bhDEEv5HcRJ2rugIhUq2dPAJMYf+kBAFONakir2wHwUUXIkaEHecwxsaI8rsTnXDW+anbJogZSLNcFOBydOaBLe8CgYBKDZknsibxxUlsEI4Ch8cmNR03iBLjCFq9sly0wuSLetzDyzw7Z8pgYSQDbd5lZWXS+B8OaTQ/U7auT7+SeU9P0CvJdgjybQ97mhcZKMclSEV5/5dBHxHVwUOaPsntC7/oP5jNRJjMilyGrxWywEsSs1eT/ZnMqJm0HPzzcdFBxQKBgQAMOkTefQsZAf/yOxA/63NbyGMIxvdHomvXij/L61kfUqPtvM/pAeVCnYf4OSBtXykZDDo+XaS2bb/WggQl9/3xlLy2d235f3brVB0ZwtNQIO8tVMCGK/gniYbxpQvXk1/6QC+vN7SAct7PKEQlLlaOExS6vDjELIcoNd4vhP54LQKBgQAOE7+S2AdjUEVXqWBPnlidZV08HMduy3yZ7mblCX0dA07/ozuM/WOfk92cgqcLddOmsbYdTuqTq1sB98v1QN1RwYe9Eiw0dmfbFlQcXT1YAZVfHNQOMO2xI4gJtkNGUqg1HQsYghOO2wkNHSMCNsoq9GWeIzCF2q6/7oH74jfoaQ==-----END RSA PRIVATE KEY-----");
		GeneralFile f = new GeneralFile();
		f.name = "My_File.txt";
		f.mimeType = "text/plain";
		f.data = "BASE64ENCODEDDATA";
		f.generateId(server);
		f.checksum = "ABC123";
		f.addOwner(ppk.toPk());
		f.signWith(ppk);
		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;
		EcIdentityManager.addIdentity(newId1);
		EcEncryptedValue v = null;
		console.log("Encrypting: " + f.name);
		v = EcEncryptedValue.encryptValueOld(f.name, f.id, ppk.toPk());
		console.log("Encrypted object: " + v.toJson());
		assertTrue("Owner exists in encrypted object.", v.hasOwner(ppk.toPk()));
		assertTrue("Owner can decrypt object.", v.decryptIntoString().equals(f.name));
		Array<String> readers = new Array<String>();
		readers.push(ppk2.toPk().toPem());
		EcEncryptedValue v2 = null;
		console.log("Encrypting: " + f.name);
		v2 = EcEncryptedValue.encryptValue(f.name, f.id, f.owner, readers);
		console.log("Encrypted object: " + v2.toJson());

		EcIdentity newId2 = new EcIdentity();
		newId2.ppk = ppk2;
		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId2);
		assertTrue("Reader Decryption:", v2.decryptIntoString().equals(f.name));
	}

	@Test
	public void encryptObjectUploadDownloadDecryptTest() {
		EcRemote.async = false;
		console.log("Encrypted Object Upload Download then Decrypt Test.");
		EcPpk ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcPpk ppk2 = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAl4oeWRsroJqAR8UXkmkhDHMcRaDM6a9wsFWNkokyugMevv5TtwHVrm9HMJqVlXn1U1AiVS1rEYB7Iavi2IE7e8WV6GkLrGTrce+YcqhrwF3g104ZEuIC2aFCcLrxvXbSqmmuddS3lRMEwqdWkYIS7MKRSKUBpbydl8wScYxjzUSMNzQrvgUpNc//N7GkpEFXYLjYmVWhYdUp578nw/K9StRqTfku8U+Ub86U0mHXowms4spV8IoOlV53OLpOL+8QwcQYZ+koWL4B0rhz6cvelvBAFygx94t8IzZtRiBniaTF+1nBjyj4+R8PdprxFNnM+S2IQBqUdBKJ3oDoKMqdAwIDAQABAoIBAC3BWmB1P7sCa3FAJVnjvELSDttHLhfxDQlxC4oPOu3HO2VXzVcYirhciRY31qqHZHd/Xp5xVD64mHUWPSw5+QfqJNVDwm6PGjgQq+sSx1YSAm1/+zokW8/yTOlUyOD4G6uwtSiGzdeJIorTk+PjbmtmZA+XIuQ0CzFmQLtgNFIpxRmDKLZrjEO5NSaeStZRgi+WVkgfOnvQvWtFK8/djeXfb4f3BnquCRKjm/cOjtdqBHcFq7Fzlyh0U64XXcJPPgBX3hLNK7mr0ZBCwUDOUs0Xna0a/2FHsjESPX7grZ9J1fbkXRwUrSJ04zbeijqROkjni7wokT+HiWtVcZ/HLOECgYEA0/CykuniBAE+Oqt+qj1OEQSnyiENJffnSzeOOjI17ygxcXYFxprEVjYL1ZVj28appGqs4tueNRoxl7jf4jpD6sDMM32scwmUcCA6K3yqk/F/WVj4MYdn7ETtACCZ9m08EUzksrWOaAb86jqm7k1+mM5xu6lbN3dSua1lKxsNFi0CgYEAtwrwuVupz+GmMna7DtW9S2q0ZwgSoUEcELqcXq2cwAPutrd4rh/xS1xsZZNGqnyT1b3/6vFT2zAyxUiL3o+bhDEEv5HcRJ2rugIhUq2dPAJMYf+kBAFONakir2wHwUUXIkaEHecwxsaI8rsTnXDW+anbJogZSLNcFOBydOaBLe8CgYBKDZknsibxxUlsEI4Ch8cmNR03iBLjCFq9sly0wuSLetzDyzw7Z8pgYSQDbd5lZWXS+B8OaTQ/U7auT7+SeU9P0CvJdgjybQ97mhcZKMclSEV5/5dBHxHVwUOaPsntC7/oP5jNRJjMilyGrxWywEsSs1eT/ZnMqJm0HPzzcdFBxQKBgQAMOkTefQsZAf/yOxA/63NbyGMIxvdHomvXij/L61kfUqPtvM/pAeVCnYf4OSBtXykZDDo+XaS2bb/WggQl9/3xlLy2d235f3brVB0ZwtNQIO8tVMCGK/gniYbxpQvXk1/6QC+vN7SAct7PKEQlLlaOExS6vDjELIcoNd4vhP54LQKBgQAOE7+S2AdjUEVXqWBPnlidZV08HMduy3yZ7mblCX0dA07/ozuM/WOfk92cgqcLddOmsbYdTuqTq1sB98v1QN1RwYe9Eiw0dmfbFlQcXT1YAZVfHNQOMO2xI4gJtkNGUqg1HQsYghOO2wkNHSMCNsoq9GWeIzCF2q6/7oH74jfoaQ==-----END RSA PRIVATE KEY-----");
		final GeneralFile f = new GeneralFile();
		f.name = "My_File.txt";
		f.mimeType = "text/plain";
		f.data = "BASE64ENCODEDDATA";
		f.generateId(server);
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
		EcRepository.save(v, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Saved.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});
		EcRepository.get(v.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				console.log("Read.");
				EcEncryptedValue val = new EcEncryptedValue();
				val.copyFrom(p1);
				EcRemoteLinkedData decryptedObject = val.decryptIntoObject();
				GeneralFile file = new GeneralFile();
				file.copyFrom(decryptedObject);
				assertTrue(file.name.equals(f.name));
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to read object.");
			}
		});
		EcRepository._delete(f, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to delete object. " + p1);
			}
		});
	}

	@Test
	public void encryptValueUploadDownloadDecryptTest() {
		EcRemote.async = false;
		console.log("Encrypted Value Upload Download then Decrypt Test.");
		EcPpk ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcPpk ppk2 = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAl4oeWRsroJqAR8UXkmkhDHMcRaDM6a9wsFWNkokyugMevv5TtwHVrm9HMJqVlXn1U1AiVS1rEYB7Iavi2IE7e8WV6GkLrGTrce+YcqhrwF3g104ZEuIC2aFCcLrxvXbSqmmuddS3lRMEwqdWkYIS7MKRSKUBpbydl8wScYxjzUSMNzQrvgUpNc//N7GkpEFXYLjYmVWhYdUp578nw/K9StRqTfku8U+Ub86U0mHXowms4spV8IoOlV53OLpOL+8QwcQYZ+koWL4B0rhz6cvelvBAFygx94t8IzZtRiBniaTF+1nBjyj4+R8PdprxFNnM+S2IQBqUdBKJ3oDoKMqdAwIDAQABAoIBAC3BWmB1P7sCa3FAJVnjvELSDttHLhfxDQlxC4oPOu3HO2VXzVcYirhciRY31qqHZHd/Xp5xVD64mHUWPSw5+QfqJNVDwm6PGjgQq+sSx1YSAm1/+zokW8/yTOlUyOD4G6uwtSiGzdeJIorTk+PjbmtmZA+XIuQ0CzFmQLtgNFIpxRmDKLZrjEO5NSaeStZRgi+WVkgfOnvQvWtFK8/djeXfb4f3BnquCRKjm/cOjtdqBHcFq7Fzlyh0U64XXcJPPgBX3hLNK7mr0ZBCwUDOUs0Xna0a/2FHsjESPX7grZ9J1fbkXRwUrSJ04zbeijqROkjni7wokT+HiWtVcZ/HLOECgYEA0/CykuniBAE+Oqt+qj1OEQSnyiENJffnSzeOOjI17ygxcXYFxprEVjYL1ZVj28appGqs4tueNRoxl7jf4jpD6sDMM32scwmUcCA6K3yqk/F/WVj4MYdn7ETtACCZ9m08EUzksrWOaAb86jqm7k1+mM5xu6lbN3dSua1lKxsNFi0CgYEAtwrwuVupz+GmMna7DtW9S2q0ZwgSoUEcELqcXq2cwAPutrd4rh/xS1xsZZNGqnyT1b3/6vFT2zAyxUiL3o+bhDEEv5HcRJ2rugIhUq2dPAJMYf+kBAFONakir2wHwUUXIkaEHecwxsaI8rsTnXDW+anbJogZSLNcFOBydOaBLe8CgYBKDZknsibxxUlsEI4Ch8cmNR03iBLjCFq9sly0wuSLetzDyzw7Z8pgYSQDbd5lZWXS+B8OaTQ/U7auT7+SeU9P0CvJdgjybQ97mhcZKMclSEV5/5dBHxHVwUOaPsntC7/oP5jNRJjMilyGrxWywEsSs1eT/ZnMqJm0HPzzcdFBxQKBgQAMOkTefQsZAf/yOxA/63NbyGMIxvdHomvXij/L61kfUqPtvM/pAeVCnYf4OSBtXykZDDo+XaS2bb/WggQl9/3xlLy2d235f3brVB0ZwtNQIO8tVMCGK/gniYbxpQvXk1/6QC+vN7SAct7PKEQlLlaOExS6vDjELIcoNd4vhP54LQKBgQAOE7+S2AdjUEVXqWBPnlidZV08HMduy3yZ7mblCX0dA07/ozuM/WOfk92cgqcLddOmsbYdTuqTq1sB98v1QN1RwYe9Eiw0dmfbFlQcXT1YAZVfHNQOMO2xI4gJtkNGUqg1HQsYghOO2wkNHSMCNsoq9GWeIzCF2q6/7oH74jfoaQ==-----END RSA PRIVATE KEY-----");
		GeneralFile f = new GeneralFile();
		f.name = "My_File.txt";
		f.mimeType = "text/plain";
		f.data = "BASE64ENCODEDDATA";
		f.generateId(server);
		f.checksum = "ABC123";
		f.addOwner(ppk.toPk());
		f.signWith(ppk);
		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;
		EcIdentityManager.addIdentity(newId1);
		JSObjectAdapter.$put(f, "encryptedName", EcEncryptedValue.encryptValue(f.name, f.shortId(), f.owner, null));
		console.log(f.toJson());
		EcRepository.save(f, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Saved.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});
		EcRepository.get(f.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				console.log("Read.");
				GeneralFile val = new GeneralFile();
				console.log(p1.toJson());
				val.copyFrom(p1);
				console.log(val.toJson());
				EcEncryptedValue val1 = new EcEncryptedValue();
				val1.copyFrom(JSObjectAdapter.$get(val, "encryptedName"));
				console.log("Encrypted, downloaded = " + val1.toJson());
				String decryptIntoString = val1.decryptIntoString();
				console.log("Decrypted = " + decryptIntoString);
				assertTrue(decryptIntoString.equals("My_File.txt"));
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to read object.");
			}
		});
		EcRepository._delete(f, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to delete object. " + p1);
			}
		});
	}

	@Test
	public void encryptValueWithReaderUploadSearchByPkWithSignatureTest() {
		EcRemote.async = false;
		console.log("encryptValueWithReaderUploadSearchByPkWithSignatureTest Test.");
		EcPpk ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		EcPpk ppk2 = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAl4oeWRsroJqAR8UXkmkhDHMcRaDM6a9wsFWNkokyugMevv5TtwHVrm9HMJqVlXn1U1AiVS1rEYB7Iavi2IE7e8WV6GkLrGTrce+YcqhrwF3g104ZEuIC2aFCcLrxvXbSqmmuddS3lRMEwqdWkYIS7MKRSKUBpbydl8wScYxjzUSMNzQrvgUpNc//N7GkpEFXYLjYmVWhYdUp578nw/K9StRqTfku8U+Ub86U0mHXowms4spV8IoOlV53OLpOL+8QwcQYZ+koWL4B0rhz6cvelvBAFygx94t8IzZtRiBniaTF+1nBjyj4+R8PdprxFNnM+S2IQBqUdBKJ3oDoKMqdAwIDAQABAoIBAC3BWmB1P7sCa3FAJVnjvELSDttHLhfxDQlxC4oPOu3HO2VXzVcYirhciRY31qqHZHd/Xp5xVD64mHUWPSw5+QfqJNVDwm6PGjgQq+sSx1YSAm1/+zokW8/yTOlUyOD4G6uwtSiGzdeJIorTk+PjbmtmZA+XIuQ0CzFmQLtgNFIpxRmDKLZrjEO5NSaeStZRgi+WVkgfOnvQvWtFK8/djeXfb4f3BnquCRKjm/cOjtdqBHcFq7Fzlyh0U64XXcJPPgBX3hLNK7mr0ZBCwUDOUs0Xna0a/2FHsjESPX7grZ9J1fbkXRwUrSJ04zbeijqROkjni7wokT+HiWtVcZ/HLOECgYEA0/CykuniBAE+Oqt+qj1OEQSnyiENJffnSzeOOjI17ygxcXYFxprEVjYL1ZVj28appGqs4tueNRoxl7jf4jpD6sDMM32scwmUcCA6K3yqk/F/WVj4MYdn7ETtACCZ9m08EUzksrWOaAb86jqm7k1+mM5xu6lbN3dSua1lKxsNFi0CgYEAtwrwuVupz+GmMna7DtW9S2q0ZwgSoUEcELqcXq2cwAPutrd4rh/xS1xsZZNGqnyT1b3/6vFT2zAyxUiL3o+bhDEEv5HcRJ2rugIhUq2dPAJMYf+kBAFONakir2wHwUUXIkaEHecwxsaI8rsTnXDW+anbJogZSLNcFOBydOaBLe8CgYBKDZknsibxxUlsEI4Ch8cmNR03iBLjCFq9sly0wuSLetzDyzw7Z8pgYSQDbd5lZWXS+B8OaTQ/U7auT7+SeU9P0CvJdgjybQ97mhcZKMclSEV5/5dBHxHVwUOaPsntC7/oP5jNRJjMilyGrxWywEsSs1eT/ZnMqJm0HPzzcdFBxQKBgQAMOkTefQsZAf/yOxA/63NbyGMIxvdHomvXij/L61kfUqPtvM/pAeVCnYf4OSBtXykZDDo+XaS2bb/WggQl9/3xlLy2d235f3brVB0ZwtNQIO8tVMCGK/gniYbxpQvXk1/6QC+vN7SAct7PKEQlLlaOExS6vDjELIcoNd4vhP54LQKBgQAOE7+S2AdjUEVXqWBPnlidZV08HMduy3yZ7mblCX0dA07/ozuM/WOfk92cgqcLddOmsbYdTuqTq1sB98v1QN1RwYe9Eiw0dmfbFlQcXT1YAZVfHNQOMO2xI4gJtkNGUqg1HQsYghOO2wkNHSMCNsoq9GWeIzCF2q6/7oH74jfoaQ==-----END RSA PRIVATE KEY-----");

		EcRepository r = new EcRepository();
		r.selectedServer = server;
		final GeneralFile f = new GeneralFile();
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
		JSObjectAdapter.$put(f, "encryptedName", EcEncryptedValue.encryptValue(f.name, f.shortId(), f.owner, readers));
		console.log(f.toJson());
		EcRepository.save(f, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Saved.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});

		Callback1<EcRemoteLinkedData> eachCallback = new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
			}
		};
		Callback1<Array<EcRemoteLinkedData>> success = new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(f.shortId()))
						found = true;
				}
				assertTrue(found);
			}
		};
		Callback1<Array<EcRemoteLinkedData>> successInvert = new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(f.shortId()))
						found = true;
				}
				assertTrue(!found);
			}
		};
		Callback1<String> failure = new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail(p1);
			}
		};
		try {
			console.log("ID Search, searching with signature 1.");
			r.search("@id:\"" + f.shortId() + "\"", eachCallback, success, failure);
			console.log("Owner Search, searching for signature 1 using signature 1 signatureSheet.");
			r.search("@owner:\"" + ppk.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("Owner Search minus whitespace, searching for signature 1 using signature 1 signatureSheet.");
			r.search("@owner:\"" + ppk.toPk().toPem().replaceAll("\r?\n", "") + "\"", eachCallback, success, failure);
			console.log("Reader Search, searching for signature 2 using signature 1 signatureSheet.");
			r.search("@reader:\"" + ppk2.toPk().toPem() + "\" OR \\*@reader:\"" + ppk2.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("Reader Search minus whitespace, searching for signature 2 using signature 1 signatureSheet.");
			r.search("@reader:\"" + ppk2.toPk().toPem().replaceAll("\r?\n", "") + "\" OR \\*@reader:\"" + ppk2.toPk().toPem().replaceAll("\r?\n", "") + "\"",
					eachCallback, success, failure);
			console.log("_all Search, searching for signature 1 using signature 1 signatureSheet.");
			r.search("\"" + ppk.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("_all Search minus whitespace, searching for signature 1 using signature 1 signatureSheet.");
			r.search("\"" + ppk.toPk().toPem().replaceAll("\r?\n", "") + "\"", eachCallback, success, failure);

			EcIdentityManager.ids = new Array<EcIdentity>();
			EcIdentityManager.addIdentity(newId2);
			console.log("ID Search, searching with signature 2.");
			r.search("@id:\"" + f.shortId() + "\"", eachCallback, success, failure);
			console.log("_all Search, searching for signature 1 using signature 2 signatureSheet.");
			r.search("\"" + ppk.toPk().toPem() + "\"", eachCallback, success, failure);

			//
			// This test should not work because sig2 is a @reader on the file
			// and this is an _all search, where the @reader field is not
			// included
			//
			// console.log("_all Search, searching for signature 2 using
			// signature 2 signatureSheet.");
			// r.search("\""+ppk2.toPk().toPem()+"\"", eachCallback, success,
			// failure);
			EcIdentityManager.ids = new Array<EcIdentity>();
			console.log("ID Search.");
			r.search("@id:\"" + f.shortId() + "\"", eachCallback, success, failure);
			console.log("_all Search, searching for signature 1.");
			r.search("\"" + ppk.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("Owner Search, searching for signature 1");
			r.search("@owner:\"" + ppk.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("(SHOULD NOT FIND) Reader Search, searching for signature 2.");
			r.search("@reader:\"" + ppk2.toPk().toPem() + "\" OR \\*@reader:\"" + ppk2.toPk().toPem() + "\"", eachCallback, successInvert, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					console.log("\""+p1+"\"");
					Assert.assertTrue(
							p1.trim().equals("Readers only exist in encrypted data. Please provide signatures to allow access to resources.")
									||
									p1.trim().equals("error!"));
				}
			});
			console.log("_all Search, searching for signature 1.");
			r.search("\"" + ppk.toPk().toPem() + "\"", eachCallback, success, failure);
			console.log("(SHOULD NOT FIND) _all Search, searching for signature 2.");
			r.search("\"" + ppk2.toPk().toPem() + "\"", eachCallback, successInvert, failure);
		} finally {
			EcIdentityManager.ids = new Array<EcIdentity>();
			EcIdentityManager.addIdentity(newId1);
			EcRepository._delete(f, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {

				}
			}, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					Assert.fail("Failed to delete object. " + p1);
				}
			});
		}
	}

	@Test
	public void encryptedValueOneOwnerTest() {
		EcRemote.async = false;

		EcPpk ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		final EcRemoteLinkedData thing = new EcRemoteLinkedData(org.cassproject.schema.general.General.context,
				org.cassproject.schema.general.General.context + "/test");
		thing.generateId(server);
		JSObjectAdapter.$put(thing, "value", "Private Object Value");

		thing.addOwner(ppk.toPk());
		thing.signWith(ppk);

		final EcEncryptedValue encThing = EcEncryptedValue.toEncryptedValue(thing, false);

		final EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		console.log("Saving...");
		EcRepository.save(encThing, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Saved.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});

		console.log("Retrieving...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcEncryptedValue retrieved = new EcEncryptedValue();
				retrieved.copyFrom(p1);

				Assert.assertEquals("ID Does Not Match Saved Object", encThing.id, retrieved.id);
				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));

				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(encThing.decryptIntoObject(), "value"),
						JSObjectAdapter.$get(retrieved.decryptIntoObject(), "value"));

				console.log("Retrieved Unchanged");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to retrieve.");
				console.log(p1);
				Assert.fail("Failed to retrieve object after save.");
			}
		});

		EcRepository r = new EcRepository();
		r.selectedServer = server;
		console.log("Searching...");
		r.search("@encryptedType:\"" + thing.type + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}

				assertTrue("Unable to find object in search. ", found);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to search.");
				console.log(p1);
				Assert.fail("Failed to search for object after save.");
			}
		});

		EcIdentityManager.ids = JSCollections.$array();

		console.log("Trying to retrieve as public...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				console.log("Retrieved encrypted object as public");
				if (p1.type != null && !p1.type.equals(""))
					Assert.fail("Retrieved encrypted object as public");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Access Denied");
			}
		});

		console.log("Searching public...");
		r.search("@encryptedType:\"" + thing.type + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}

				Assert.assertFalse("Found the encrypted Object", found);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Could not find object in search");
			}
		});

		console.log("Deleting as Public...");
		EcRepository._delete(thing, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Deleted the Owned Object from Repository as public");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to Delete the Owned Object.");
				console.log(p1);
			}
		});

		JSObjectAdapter.$put(thing, "value", "Changed Value");

		final EcEncryptedValue encThing2 = EcEncryptedValue.toEncryptedValue(thing, false);

		console.log("Trying to Update as Public...");
		EcRepository.save(encThing2, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Saved as public.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to save as public.");
				console.log(p1);
			}
		});

		EcIdentityManager.addIdentity(newId1);

		console.log("Updating...");
		EcRepository.save(encThing2, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to update.");
				console.log(p1);
				Assert.fail("Failed to update object.");
			}
		});

		console.log("Retrieving after update...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcEncryptedValue retrieved = new EcEncryptedValue();
				retrieved.copyFrom(p1);

				Assert.assertEquals("ID Does Not Match Saved Object Name", encThing2.id, retrieved.id);
				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));

				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(encThing2.decryptIntoObject(), "value"),
						JSObjectAdapter.$get(retrieved.decryptIntoObject(), "value"));

				console.log("Retrieved After update");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to retrieve updates.");
				console.log(p1);
				Assert.fail("Failed to retrieve updated object");
			}
		});

		console.log("Deleting...");
		EcRepository._delete(thing, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Deleted the Owned Object.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log(p1);
				Assert.fail("Failed to Delete the Owned Object from Repository");
			}
		});

	}

	@Test
	public void encryptedValueTwoOwnerTest() {
		EcRemote.async = false;

		final EcPpk ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		final EcPpk ppk2 = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEowIBAAKCAQEAg2cDnkHswuKCvjpFwiXuMoHf9C0qEFupDBalvVscxg7F6qWUSxpISYznkZ/dpXwtrR6w+C5fB+KmTNRUxTl9uT4O1Z4AhJ6b9l6WGQWYlRBZZqXmJwcWnCFcOPGfbVcKHuX7AlIaend7/HC7IudfSiLTcfo6EM7k2xiygrGagW89yEe+Q9DsnruU8UkkT9J7Hzi70RVnc6ovqasqFubECNbIoiFW52AJ2EZYRFCXAAfA2Wb9Tmv170RRjsjBS8TJ+C8WSbtCWOztMnUJlJmQtbiVRnfXRFI9igR4bzpQHmOS1khln9VBo4aiosUeaLNMjs2suEia+6HdLbhZfP26cQIDAQABAoIBAEFu+9tD4t2NJCQMKo6qirn1+IrELs0kh8KwSGpJw8NQuffF6lmXxeVyWCIpJJtygeBShzefB82KbNuXZHstzNCA+awgWQuxW+LMaRwesEOSd6Jo/Hn0yqqG5kCo+YXeMPj/9wXJ0sunUkN784RHCSmGvBpmy6FxFX+RBduVC2ZmPCxsv21HXjGAUled7mzZ/6u7g2Q7nAFd72QLKK3qaLflzfCnqTYqdsIwlR8Lp8F5+FcGQUM9SGv/mdAT9U05ovVuQSB7yToe4d+vV/u+6ixk0TM4RFm7ZWYyXqpuGCy5Logo6aZYWfKWZbKJuGmgwf1przZC3euu91kKR+ui81ECgYEA8QhPYGEG+ExaQ6vQzeLlddxriAQuvfBQR7W82/6UnaBtswolNQdRQ1KeOV8MJ57pYZeZidPq7Xc2tFcrH6FYVF2h+Sxe0jpKFf9CAzqammZjR3c7ddHeif45VeGUM0kdID1baAMvLIJg0e7Q2n/PuEY3FL+5GBlkxJdQnz6r2V0CgYEAi4/ql978ac63ex0Rz898lWMYY60nrJaYBPohpf+CMQ7c/lrretbX2ZoswheVKaho/yn3fpcPnUwh7rTuTLnMjxbl5D7LWfHIA9ZyNqwGZjL525p+pSjPsN3S1NNI8tH8UQ9lMuV/xr3R6vVdZT7UiWr09MUX4DYceKAuoP4/kCUCgYBQq0VVrmOUyokTSPfTUHMXpTPgC/ZQ35MezPZucp/uuXi9iVG2k8Jg08/cx7DbudXGMeTTOjfQTivi46GtLmTPp57ENFNv7M5K2mmPhxejQU1M59zgq+LdMFakJaFiIMA8wAxNnXM2ZFRfLpx75Hby550btqcOJ8GQAkybX3BIiQKBgQCIJGUpr6m1oaTVIV9txC75H4j8Oz7XmrRDLqpCX4TmTGSCb7kExK4dpMuCrzSgRZvfRlYblEr0G/+B99f62sjU0PaD+EmwvS5rp/cUpC095v5cHlLq1Gv+UfXIDTA9R2CGxqjmxIAoJKWxOZfZGziDsOWyHM4Ut1SAy2mRPVROTQKBgD5lboXnZMpRsamgZ5Jwg4bES6npFyPsrNaeJnp6QWz0Q1Ur/dw473VafpeKUZc4/uRRWTtuwooD4x2iCRZzRYAgImyZMeISMOIy8Yt6UZh9AScXsuhOSWiUKj/c1EGjMzMvV59ZzEddXohzMysZ0V/hjVW48HG7ZOcqIAk83Et+-----END RSA PRIVATE KEY-----");

		final EcRemoteLinkedData thing = new EcRemoteLinkedData(org.cassproject.schema.general.General.context,
				org.cassproject.schema.general.General.context + "/test");
		thing.generateId(server);
		JSObjectAdapter.$put(thing, "value", "Private Object Value");

		thing.addOwner(ppk.toPk());
		thing.signWith(ppk);

		thing.addOwner(EcPk.fromPem(ppk2.toPk().toPem()));

		final EcEncryptedValue encThing = EcEncryptedValue.toEncryptedValue(thing, false);

		final EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		console.log("Saving...");
		EcRepository.save(encThing, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Saved.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});

		console.log("Retrieving as owner 1...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcEncryptedValue retrieved = new EcEncryptedValue();
				retrieved.copyFrom(p1);

				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));
				Assert.assertEquals("Value Does Not Match Saved Object Value", JSObjectAdapter.$get(encThing.decryptIntoObject(), "name"),
						JSObjectAdapter.$get(retrieved.decryptIntoObject(), "name"));
				Assert.assertEquals("ID Does Not Match Saved Object Name", encThing.id, retrieved.id);

				Assert.assertTrue("Object does not have first owner", retrieved.hasOwner(ppk.toPk()));
				Assert.assertTrue("Object does not have second owner", retrieved.hasOwner(ppk2.toPk()));
				console.log("Retrieved Unchanged");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to retrieve as owner 1.");
				console.log(p1);
				Assert.fail("Failed to retrieve object as owner 1 after save.");
			}
		});

		EcRepository r = new EcRepository();
		r.selectedServer = server;
		console.log("Searching as owner 1...");
		r.search("@encryptedType:\"" + thing.type + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}

				assertTrue("Unable to find object in search as owner 1. ", found);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to search.");
				console.log(p1);
				Assert.fail("Failed to search for object as owner 1.");
			}
		});

		EcIdentity newId2 = new EcIdentity();
		newId2.ppk = ppk2;

		EcIdentityManager.ids = JSCollections.$array();
		EcIdentityManager.addIdentity(newId2);

		console.log("Retrieving as owner 2...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcEncryptedValue retrieved = new EcEncryptedValue();
				retrieved.copyFrom(p1);

				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));
				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(encThing.decryptIntoObject(), "name"),
						JSObjectAdapter.$get(retrieved.decryptIntoObject(), "name"));
				Assert.assertEquals("ID Does Not Match Saved Object Name", encThing.id, retrieved.id);

				Assert.assertTrue("Object does not have first owner", retrieved.hasOwner(ppk.toPk()));
				Assert.assertTrue("Object does not have second owner", retrieved.hasOwner(ppk2.toPk()));
				console.log("Retrieved Unchanged");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to retrieve as owner 2.");
				console.log(p1);
				Assert.fail("Failed to retrieve object as owner 2");
			}
		});

		console.log("Searching as owner 2...");
		r.search("@encryptedType:\"" + thing.type + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}

				assertTrue("Unable to find object in search as owner 2. ", found);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to search.");
				console.log(p1);
				Assert.fail("Failed to search for object as owner 2.");
			}
		});

		EcIdentityManager.ids = JSCollections.$array();

		console.log("Trying to retrieve as public...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				console.log("Retrieved encrypted object as public");
				if (p1.type != null && !p1.type.equals(""))
					Assert.fail("Retrieved encrypted object as public");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Access Denied");
			}
		});

		console.log("Searching public...");
		r.search("@encryptedType:\"" + thing.type + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}

				Assert.assertFalse("Found the encrypted Object", found);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Could not find object in search");
			}
		});

		console.log("Deleting as Public...");
		EcRepository._delete(thing, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Deleted the Owned Object from Repository as public");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to Delete the Owned Object.");
				console.log(p1);
			}
		});

		EcIdentityManager.addIdentity(newId2);

		JSObjectAdapter.$put(thing, "value", "Changed Object Value");

		EcEncryptedValue encThing2 = EcEncryptedValue.toEncryptedValue(thing, false);

		console.log("Updating as owner 2...");
		EcRepository.save(encThing, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Updated as owner 2.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to Update as owner2.");
				console.log(p1);
				Assert.fail("Failed to Update object as owner2.");
			}
		});

		console.log("Retrieving after update...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcEncryptedValue retrieved = new EcEncryptedValue();
				retrieved.copyFrom(p1);

				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));
				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(encThing.decryptIntoObject(), "value"),
						JSObjectAdapter.$get(retrieved.decryptIntoObject(), "value"));
				Assert.assertEquals("ID Does Not Match Saved Object Name", encThing.id, retrieved.id);

				Assert.assertTrue("Object does not have first owner", retrieved.hasOwner(ppk.toPk()));
				Assert.assertTrue("Object does not have second owner", retrieved.hasOwner(ppk2.toPk()));
				console.log("Retrieved Unchanged");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to retrieve as owner 2 after update.");
				console.log(p1);
				Assert.fail("Failed to retrieve object as owner 2");
			}
		});

		console.log("Deleting as owner 2...");
		EcRepository._delete(thing, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Deleted the Owned Object as owner 2.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log(p1);
				Assert.fail("Failed to Delete the Owned Object from Repository as owner 2");
			}
		});

	}

	@Test
	public void encryptedValueOwnerReaderTest() {
		EcRemote.async = false;

		final EcPpk ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		EcPpk ppk2 = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEowIBAAKCAQEAg2cDnkHswuKCvjpFwiXuMoHf9C0qEFupDBalvVscxg7F6qWUSxpISYznkZ/dpXwtrR6w+C5fB+KmTNRUxTl9uT4O1Z4AhJ6b9l6WGQWYlRBZZqXmJwcWnCFcOPGfbVcKHuX7AlIaend7/HC7IudfSiLTcfo6EM7k2xiygrGagW89yEe+Q9DsnruU8UkkT9J7Hzi70RVnc6ovqasqFubECNbIoiFW52AJ2EZYRFCXAAfA2Wb9Tmv170RRjsjBS8TJ+C8WSbtCWOztMnUJlJmQtbiVRnfXRFI9igR4bzpQHmOS1khln9VBo4aiosUeaLNMjs2suEia+6HdLbhZfP26cQIDAQABAoIBAEFu+9tD4t2NJCQMKo6qirn1+IrELs0kh8KwSGpJw8NQuffF6lmXxeVyWCIpJJtygeBShzefB82KbNuXZHstzNCA+awgWQuxW+LMaRwesEOSd6Jo/Hn0yqqG5kCo+YXeMPj/9wXJ0sunUkN784RHCSmGvBpmy6FxFX+RBduVC2ZmPCxsv21HXjGAUled7mzZ/6u7g2Q7nAFd72QLKK3qaLflzfCnqTYqdsIwlR8Lp8F5+FcGQUM9SGv/mdAT9U05ovVuQSB7yToe4d+vV/u+6ixk0TM4RFm7ZWYyXqpuGCy5Logo6aZYWfKWZbKJuGmgwf1przZC3euu91kKR+ui81ECgYEA8QhPYGEG+ExaQ6vQzeLlddxriAQuvfBQR7W82/6UnaBtswolNQdRQ1KeOV8MJ57pYZeZidPq7Xc2tFcrH6FYVF2h+Sxe0jpKFf9CAzqammZjR3c7ddHeif45VeGUM0kdID1baAMvLIJg0e7Q2n/PuEY3FL+5GBlkxJdQnz6r2V0CgYEAi4/ql978ac63ex0Rz898lWMYY60nrJaYBPohpf+CMQ7c/lrretbX2ZoswheVKaho/yn3fpcPnUwh7rTuTLnMjxbl5D7LWfHIA9ZyNqwGZjL525p+pSjPsN3S1NNI8tH8UQ9lMuV/xr3R6vVdZT7UiWr09MUX4DYceKAuoP4/kCUCgYBQq0VVrmOUyokTSPfTUHMXpTPgC/ZQ35MezPZucp/uuXi9iVG2k8Jg08/cx7DbudXGMeTTOjfQTivi46GtLmTPp57ENFNv7M5K2mmPhxejQU1M59zgq+LdMFakJaFiIMA8wAxNnXM2ZFRfLpx75Hby550btqcOJ8GQAkybX3BIiQKBgQCIJGUpr6m1oaTVIV9txC75H4j8Oz7XmrRDLqpCX4TmTGSCb7kExK4dpMuCrzSgRZvfRlYblEr0G/+B99f62sjU0PaD+EmwvS5rp/cUpC095v5cHlLq1Gv+UfXIDTA9R2CGxqjmxIAoJKWxOZfZGziDsOWyHM4Ut1SAy2mRPVROTQKBgD5lboXnZMpRsamgZ5Jwg4bES6npFyPsrNaeJnp6QWz0Q1Ur/dw473VafpeKUZc4/uRRWTtuwooD4x2iCRZzRYAgImyZMeISMOIy8Yt6UZh9AScXsuhOSWiUKj/c1EGjMzMvV59ZzEddXohzMysZ0V/hjVW48HG7ZOcqIAk83Et+-----END RSA PRIVATE KEY-----");

		final EcRemoteLinkedData thing = new EcRemoteLinkedData(org.cassproject.schema.general.General.context,
				org.cassproject.schema.general.General.context + "/test");
		thing.generateId(server);
		JSObjectAdapter.$put(thing, "value", "Private Object Value");

		thing.addOwner(ppk.toPk());
		thing.signWith(ppk);

		final EcEncryptedValue encThing = EcEncryptedValue.toEncryptedValue(thing, false);

		final EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		console.log("Saving...");
		EcRepository.save(encThing, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Saved.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to save.");
				console.log(p1);
				Assert.fail("Failed to save object.");
			}
		});

		console.log("Retrieving as owner ...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcEncryptedValue retrieved = new EcEncryptedValue();
				retrieved.copyFrom(p1);

				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));
				Assert.assertEquals("Value Does Not Match Saved Object Value", JSObjectAdapter.$get(encThing.decryptIntoObject(), "value"),
						JSObjectAdapter.$get(retrieved.decryptIntoObject(), "value"));
				Assert.assertEquals("ID Does Not Match Saved Object Name", encThing.id, retrieved.id);

				Assert.assertTrue("Object does not have first owner", retrieved.hasOwner(ppk.toPk()));
				console.log("Retrieved Unchanged");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to retrieve as owner 1.");
				console.log(p1);
				Assert.fail("Failed to retrieve object as owner 1 after save.");
			}
		});

		EcRepository r = new EcRepository();
		r.selectedServer = server;
		console.log("Searching as owner ...");
		r.search("@encryptedType:\"" + thing.type + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}

				assertTrue("Unable to find object in search as owner. ", found);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to search.");
				console.log(p1);
				Assert.fail("Failed to search for object after save.");
			}
		});

		final EcIdentity newId2 = new EcIdentity();
		newId2.ppk = ppk2;

		EcIdentityManager.ids = JSCollections.$array();
		EcIdentityManager.addIdentity(newId2);

		console.log("Trying to retrieve as other user...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				console.log("Retrieved encrypted object as other user");
				if (p1.type != null && !p1.type.equals(""))
					Assert.fail("Retrieved encrypted object as other user");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Access Denied");
			}
		});

		EcIdentityManager.ids = JSCollections.$array();
		EcIdentityManager.addIdentity(newId1);

		final EcEncryptedValue encThingWithReader = EcEncryptedValue.toEncryptedValue(thing, false);
		encThingWithReader.addReader(EcPk.fromPem(ppk2.toPk().toPem()));

		console.log("Adding reader...");
		EcRepository.save(encThingWithReader, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Reader Added.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to add reader.");
				console.log(p1);
				Assert.fail("Failed to add reader to object.");
			}
		});

		EcIdentityManager.ids = JSCollections.$array();
		EcIdentityManager.addIdentity(newId2);

		console.log("Retrieving as reader...");
		EcRepository.get(encThingWithReader.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				if (p1.type == null || p1.type.equals(""))
					Assert.fail("Unable to retreive object as reader");
				EcEncryptedValue retrieved = new EcEncryptedValue();
				retrieved.copyFrom(p1);

				EcIdentityManager.addIdentity(newId2);
				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));
				Assert.assertEquals("Value Does Not Match Saved Object Value", JSObjectAdapter.$get(encThingWithReader.decryptIntoObject(), "value"),
						JSObjectAdapter.$get(retrieved.decryptIntoObject(), "value"));
				Assert.assertEquals("ID Does Not Match Saved Object Id", encThingWithReader.id, retrieved.id);

				Assert.assertTrue("Object does not have first owner", retrieved.hasOwner(ppk.toPk()));
				console.log("Retrieved as Reader");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to retrieve as reader");
				console.log(p1);
				Assert.fail("Failed to retrieve object as reader.");
			}
		});

		console.log("Searching as reader...");
		r.search("@encryptedType:\"" + thing.type + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}

				assertTrue("Unable to find object in search as reader ", found);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to search.");
				console.log(p1);
				Assert.fail("Failed to search for object after save.");
			}
		});

		EcIdentityManager.ids = JSCollections.$array();

		console.log("Trying to retrieve as public...");
		EcRepository.get(encThingWithReader.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				console.log("Retrieved encrypted object as public");
				if (p1.type != null && !p1.type.equals(""))
					Assert.fail("Retrieved encrypted object as public");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Access Denied");
			}
		});

		console.log("Searching public...");
		r.search("@encryptedType:\"" + thing.type + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++) {
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}

				Assert.assertFalse("Found the encrypted Object", found);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Could not find object in search");
			}
		});

		console.log("Deleting as Public...");
		EcRepository._delete(encThingWithReader, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Deleted the Owned Object from Repository as public");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to Delete Owned Object as public.");
				console.log(p1);
			}
		});

		EcIdentityManager.addIdentity(newId2);
		console.log("Deleting as reader...");
		EcRepository._delete(encThingWithReader, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Deleted the Owned Object from Repository as reader");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to Delete the Object as reader.");
				console.log(p1);
			}
		});

		EcIdentityManager.ids = JSCollections.$array();
		EcIdentityManager.addIdentity(newId1);

		EcEncryptedValue encThingNoReader = new EcEncryptedValue();
		encThingNoReader.copyFrom(encThingWithReader);

		encThingNoReader.removeReader(EcPk.fromPem(ppk2.toPk().toPem()));

		console.log("removing reader...");
		EcRepository.save(encThingNoReader, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Updated without reader.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Failed to remove reader.");
				console.log(p1);
				Assert.fail("Failed to remove reader from object.");
			}
		});

		EcIdentityManager.ids = JSCollections.$array();
		EcIdentityManager.addIdentity(newId2);

		console.log("Trying to retrieve as other user...");
		EcRepository.get(encThing.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				console.log("Retrieved encrypted object as other user");
				if (p1.type != null && !p1.type.equals(""))
					Assert.fail("Retrieved encrypted object as other user");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Access Denied");
			}
		});

		EcIdentityManager.ids = JSCollections.$array();
		EcIdentityManager.addIdentity(newId1);

		console.log("Deleting...");
		EcRepository._delete(encThingNoReader, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Deleted the Owned Object as owner.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log(p1);
				Assert.fail("Failed to Delete the Owned Object from Repository as owner");
			}
		});

	}

}
