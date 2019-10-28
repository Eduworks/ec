package org.cassproject.schema.ebac;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.schema.Thing;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;


@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"pem-jwk.js", "require.js","/forge/forge.bundle.js"})
public class EcVersioningTest {
	static String server = "http://localhost/api/";

	static class console{
		EcRepository r;
		console(){
			r = new EcRepository();
			r.selectedServer = server;
		}
		static void log(String s){
			EcRemote.getExpectingString(server,"ping?log="+s,null,null);
		}
		static void error(String s){
			EcRemote.getExpectingString(server,"ping?error=true&log="+s,null,null);
		}
	}
	@Before
	public void begin() {
		EcRemote.async = false;
	}

	@Test
	public void testSaveTwoVersionsBothExist() {
		EcRemote.async = false;

		final EcRepository r = new EcRepository();
		r.selectedServer = server;

		EcPpk ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		final Thing t = new Thing();
		t.name = "Foo";
		t.generateId(r.selectedServer);
		t.addOwner(ppk.toPk());

		EcRepository.save(t, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("First save OK.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Couldn't save the object.");
			}
		});
		t.name = "Foo2";
		final String oldVersion = t.id;

		EcRepository.save(t, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("First save OK.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Couldn't save the object.");
			}
		});

		final String newVersion = t.id;

		EcRepository.get(oldVersion, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				Thing t = new Thing();
				t.copyFrom(p1);
				Assert.assertEquals(t.name, "Foo");
				Assert.assertEquals(t.id, oldVersion);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Couldn't retrieve the old version.");
			}
		});
		EcRepository.get(newVersion, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				Thing t = new Thing();
				t.copyFrom(p1);
				Assert.assertEquals(t.name, "Foo2");
				Assert.assertEquals(t.id, newVersion);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Couldn't retrieve the old version.");
			}
		});
		r._delete(t, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				console.log("Deleted the thing.");
				EcRepository.get(t.shortId(), new Callback1<EcRemoteLinkedData>() {
					@Override
					public void $invoke(EcRemoteLinkedData p1) {
						Assert.fail("Could find the thing that was supposed to be gone.");
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						console.log("Couldn't find the deleted 'latest' -- good.");
					}
				});
				r.search("\""+t.shortId()+"\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
					@Override
					public void $invoke(Array<EcRemoteLinkedData> p1) {
						if (p1.$length() != 0)
							Assert.fail("Could find the thing that was supposed to be gone.");
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						console.log("Couldn't find the deleted 'latest' -- good.");
					}
				});
			}
		}, new Callback1<String>() {

			@Override
			public void $invoke(String p1) {
				Assert.fail("Couldn't delete it.");
			}
		});
		EcRepository.get(oldVersion, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				Thing t = new Thing();
				t.copyFrom(p1);
				Assert.assertEquals(t.name, "Foo");
				Assert.assertEquals(t.id, oldVersion);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Couldn't retrieve the old version 2.");
			}
		});
		EcRepository.get(newVersion, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				Thing t = new Thing();
				t.copyFrom(p1);
				Assert.assertEquals(t.name, "Foo2");
				Assert.assertEquals(t.id, newVersion);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Couldn't retrieve the old version 2.");
			}
		});

	}
}
