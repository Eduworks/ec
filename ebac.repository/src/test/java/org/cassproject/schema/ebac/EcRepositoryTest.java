package org.cassproject.schema.ebac;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcFile;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.random.EcRandom;
import com.eduworks.ec.remote.EcRemote;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/forge/forge.bundle.js" })
public class EcRepositoryTest
{
	String server = "http://localhost:9722/api/custom/";

	@Test
	public void createPublicFileTest()
	{
		EcRemote.async = false;

		EcFile thing = new EcFile();
		thing.id = server;
		if (!thing.id.endsWith("/"))
			thing.id += "/";
		thing.id += "data/";
		thing.id += thing.type.replace("http://", "").replaceAll("/", ".");
		thing.id += "/";
		thing.id += "test-public-object";
		thing.id += "/";
		thing.name = "Testing Public Object";

		console.log("Saving Public Object...");
		EcRepository.save(thing, new Callback1<String>()
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

		console.log("Retrieving Public Object...");
		EcRepository.get(thing.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFile retrieved = (EcFile) p1;

				if (retrieved.owner != null)
					Assert.assertEquals("File is not Public, has an owner", retrieved.owner.$length(), 0);
				Assert.assertEquals("Name Does Not Match Saved Object Name", thing.name, retrieved.name);
				Assert.assertEquals("Name Does Not Match Saved Object Name", thing.id, retrieved.id);

				console.log("Retrieved Unchanged.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to retrieve");
				console.log(p1);
				Assert.fail("Failed to retrieve public object after save.");
			}
		});

		console.log("Trying to Delete...");
		EcRepository._delete(thing, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Assert.fail("Deleted a Public Object, this shouldn't be allowed!");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Good, Cannot Delete Public Object.");
				console.log(p1);
			}
		});
	}

	@Test
	public void searchForSomethingThatCantExist()
	{
		EcRemote.async = false;
		
		EcRepository r = new EcRepository();
		r.selectedServer = server;
		
		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		
		console.log("Searching...");
		r.search("@type:\"http://schema.eduworks.com/general/0.1/nonsense\"", null, new Callback1<Array<EcRemoteLinkedData>>()
		{
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1)
			{
				assertTrue(true);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to search.");
				console.log(p1);
				Assert.fail("Failed to search for object that doesn't have an existing type in the database.");
			}
		});
		
		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);
		
		console.log("Searching...");
		r.search("@type:\"http://schema.eduworks.com/general/0.1/nonsense\"", null, new Callback1<Array<EcRemoteLinkedData>>()
		{
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1)
			{
				assertTrue(true);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to search w/signature.");
				console.log(p1);
				Assert.fail("Failed to search for object that doesn't have an existing type in the database (using a signature).");
			}
		});
		
	}
	
	@Test
	public void createAndDeleteOwnedFileTest()
	{
		EcRemote.async = false;

		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		EcFile thing = new EcFile();
		thing.generateId(server);
		thing.name = "Testing Owned Object";

		thing.addOwner(ppk.toPk());
		thing.signWith(ppk);

		EcIdentity newId1 = new EcIdentity();
		newId1.ppk = ppk;

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		console.log("Saving...");
		EcRepository.save(thing, new Callback1<String>()
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

		console.log("Retrieving...");
		EcRepository.get(thing.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFile retrieved = (EcFile) p1;

				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));
				Assert.assertEquals("Name Does Not Match Saved Object Name", thing.name, retrieved.name);
				Assert.assertEquals("Name Does Not Match Saved Object Name", thing.id, retrieved.id);

				console.log("Retrieved Unchanged");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to retrieve.");
				console.log(p1);
				Assert.fail("Failed to retrieve object after save.");
			}
		});

		EcRepository r = new EcRepository();
		r.selectedServer = server;
		console.log("Searching...");
		r.search("@type:\"http://schema.eduworks.com/general/0.1/file\"", null, new Callback1<Array<EcRemoteLinkedData>>()
		{
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1)
			{
				boolean found = false;
				for (int i = 0; i < p1.$length(); i++)
				{
					if (p1.$get(i).shortId().equals(thing.shortId()))
						found = true;
				}
				assertTrue(found);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to search.");
				console.log(p1);
				Assert.fail("Failed to search for object after save.");
			}
		});

		console.log("Deleting...");
		EcRepository._delete(thing, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Deleted the Owned Object.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log(p1);
				Assert.fail("Failed to Delete the Owned Object from Repository");
			}
		});
	}

}
