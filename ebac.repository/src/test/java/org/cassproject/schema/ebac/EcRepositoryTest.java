package org.cassproject.schema.ebac;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcFile;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSON;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.random.EcRandom;
import com.eduworks.ec.remote.EcRemote;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/forge/forge.bundle.js" })
public class EcRepositoryTest
{
	String server = "http://localhost:9722/api/custom/";


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
	public void createPublicObjectTest()
	{
		EcRemote.async = false;

		EcRemoteLinkedData thing = new EcRemoteLinkedData(org.cassproject.schema.general.General.schema,
				org.cassproject.schema.general.General.schema+"/test");
		thing.id = server;
		if (!thing.id.endsWith("/"))
			thing.id += "/";
		thing.id += "data/";
		thing.id += thing.type.replace("http://", "").replaceAll("/", ".");
		thing.id += "/";
		thing.id += "test-public-object";
		thing.id += "/";
		JSObjectAdapter.$put(thing, "name", "Test Public Object");

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
				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(thing, "name"), retrieved.name);
				Assert.assertEquals("ID Does Not Match Saved Object ID", thing.id, retrieved.id);

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

		EcRemoteLinkedData thing2 = new EcRemoteLinkedData(org.cassproject.schema.general.General.schema,
				org.cassproject.schema.general.General.schema+"/test");
		thing2.copyFrom(thing);;
		JSObjectAdapter.$put(thing, "name", "Changed Public Object Name");
		
		console.log("Updating Public Object...");
		EcRepository.save(thing2, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Updated.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to update.");
				console.log(p1);
				Assert.fail("Failed to update object.");
			}
		});
		
		console.log("Retrieving After update...");
		EcRepository.get(thing2.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFile retrieved = (EcFile) p1;

				if (retrieved.owner != null)
					Assert.assertEquals("File is not Public, has an owner", retrieved.owner.$length(), 0);
				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(thing2, "name"), retrieved.name);
				Assert.assertEquals("ID Does Not Match Saved Object ID", thing2.id, retrieved.id);

				console.log("Retrieved Unchanged.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to retrieve after update");
				console.log(p1);
				Assert.fail("Failed to retrieve public object after update.");
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
	public void createAndDeleteSingleOwnedObjectTest()
	{
		EcRemote.async = false;

		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		EcRemoteLinkedData thing = new EcRemoteLinkedData(org.cassproject.schema.general.General.schema,
				org.cassproject.schema.general.General.schema+"/test");
		thing.generateId(server);
		JSObjectAdapter.$put(thing, "name", "Testing Owned Object");

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

		EcIdentityManager.ids = JSCollections.$array();
		
		console.log("Retrieving...");
		EcRepository.get(thing.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFile retrieved = (EcFile) p1;

				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));
				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(thing, "name"), retrieved.name);
				Assert.assertEquals("ID Does Not Match Saved Object ID", thing.id, retrieved.id);

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
		r.search("@type:\""+thing.type+"\"", null, new Callback1<Array<EcRemoteLinkedData>>()
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
				assertTrue("Unable to find object in search. ", found);
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
		
		console.log("Trying to delete as public...");
		EcRepository._delete(thing, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Assert.fail("Deleted the Owned Object as public");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log(p1);
				console.log("Denied Access");
			}
		});

		
		
		EcIdentityManager.addIdentity(newId1);
		
		
		EcRemoteLinkedData thing2 = new EcRemoteLinkedData(org.cassproject.schema.general.General.schema,
				org.cassproject.schema.general.General.schema+"/test");
		thing2.copyFrom(thing);;
		JSObjectAdapter.$put(thing, "name", "Changed Object Name");
		
		console.log("Updating Owned Object...");
		EcRepository.save(thing2, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Updated.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to update.");
				console.log(p1);
				Assert.fail("Failed to update object.");
			}
		});
		
		console.log("Retrieving Owned Object...");
		EcRepository.get(thing2.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFile retrieved = (EcFile) p1;

				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(thing2, "name"), retrieved.name);
				Assert.assertEquals("Id Does Not Match Saved Object Id", thing2.id, retrieved.id);

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

	@Test
	public void createAndDeleteTwoOwnerObjectTest(){
		EcRemote.async = false;

		EcPpk ppk = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		EcPpk ppk2 = EcPpk
				.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEowIBAAKCAQEAg2cDnkHswuKCvjpFwiXuMoHf9C0qEFupDBalvVscxg7F6qWUSxpISYznkZ/dpXwtrR6w+C5fB+KmTNRUxTl9uT4O1Z4AhJ6b9l6WGQWYlRBZZqXmJwcWnCFcOPGfbVcKHuX7AlIaend7/HC7IudfSiLTcfo6EM7k2xiygrGagW89yEe+Q9DsnruU8UkkT9J7Hzi70RVnc6ovqasqFubECNbIoiFW52AJ2EZYRFCXAAfA2Wb9Tmv170RRjsjBS8TJ+C8WSbtCWOztMnUJlJmQtbiVRnfXRFI9igR4bzpQHmOS1khln9VBo4aiosUeaLNMjs2suEia+6HdLbhZfP26cQIDAQABAoIBAEFu+9tD4t2NJCQMKo6qirn1+IrELs0kh8KwSGpJw8NQuffF6lmXxeVyWCIpJJtygeBShzefB82KbNuXZHstzNCA+awgWQuxW+LMaRwesEOSd6Jo/Hn0yqqG5kCo+YXeMPj/9wXJ0sunUkN784RHCSmGvBpmy6FxFX+RBduVC2ZmPCxsv21HXjGAUled7mzZ/6u7g2Q7nAFd72QLKK3qaLflzfCnqTYqdsIwlR8Lp8F5+FcGQUM9SGv/mdAT9U05ovVuQSB7yToe4d+vV/u+6ixk0TM4RFm7ZWYyXqpuGCy5Logo6aZYWfKWZbKJuGmgwf1przZC3euu91kKR+ui81ECgYEA8QhPYGEG+ExaQ6vQzeLlddxriAQuvfBQR7W82/6UnaBtswolNQdRQ1KeOV8MJ57pYZeZidPq7Xc2tFcrH6FYVF2h+Sxe0jpKFf9CAzqammZjR3c7ddHeif45VeGUM0kdID1baAMvLIJg0e7Q2n/PuEY3FL+5GBlkxJdQnz6r2V0CgYEAi4/ql978ac63ex0Rz898lWMYY60nrJaYBPohpf+CMQ7c/lrretbX2ZoswheVKaho/yn3fpcPnUwh7rTuTLnMjxbl5D7LWfHIA9ZyNqwGZjL525p+pSjPsN3S1NNI8tH8UQ9lMuV/xr3R6vVdZT7UiWr09MUX4DYceKAuoP4/kCUCgYBQq0VVrmOUyokTSPfTUHMXpTPgC/ZQ35MezPZucp/uuXi9iVG2k8Jg08/cx7DbudXGMeTTOjfQTivi46GtLmTPp57ENFNv7M5K2mmPhxejQU1M59zgq+LdMFakJaFiIMA8wAxNnXM2ZFRfLpx75Hby550btqcOJ8GQAkybX3BIiQKBgQCIJGUpr6m1oaTVIV9txC75H4j8Oz7XmrRDLqpCX4TmTGSCb7kExK4dpMuCrzSgRZvfRlYblEr0G/+B99f62sjU0PaD+EmwvS5rp/cUpC095v5cHlLq1Gv+UfXIDTA9R2CGxqjmxIAoJKWxOZfZGziDsOWyHM4Ut1SAy2mRPVROTQKBgD5lboXnZMpRsamgZ5Jwg4bES6npFyPsrNaeJnp6QWz0Q1Ur/dw473VafpeKUZc4/uRRWTtuwooD4x2iCRZzRYAgImyZMeISMOIy8Yt6UZh9AScXsuhOSWiUKj/c1EGjMzMvV59ZzEddXohzMysZ0V/hjVW48HG7ZOcqIAk83Et+-----END RSA PRIVATE KEY-----");

		EcRemoteLinkedData thing = new EcRemoteLinkedData(org.cassproject.schema.general.General.schema,
				org.cassproject.schema.general.General.schema+"/test");
		thing.generateId(server);
		JSObjectAdapter.$put(thing, "name", "Testing Owned Object");

		thing.addOwner(ppk.toPk());
		thing.signWith(ppk);
		
		ppk2.toPk().toPem();
		
		EcPk pk2 = EcPk.fromPem(ppk2.toPk().toPem());
		thing.addOwner(pk2);

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
		
		EcIdentityManager.ids = JSCollections.$array();

		console.log("Retrieving...");
		EcRepository.get(thing.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFile retrieved = (EcFile) p1;

				Assert.assertTrue("Object is not Owned by the Identity that Created It", retrieved.canEdit(newId1.ppk.toPk()));
				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(thing, "name"), retrieved.name);
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
		r.search("@type:\""+thing.type+"\"", null, new Callback1<Array<EcRemoteLinkedData>>()
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
				
				assertTrue("Unable to find object in search. ", found);
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

		
		EcIdentity newId2 = new EcIdentity();
		newId2.ppk = ppk2;
		EcIdentityManager.addIdentity(newId2);
		
		EcRemoteLinkedData thing2 = new EcRemoteLinkedData(org.cassproject.schema.general.General.schema,
				org.cassproject.schema.general.General.schema+"/test");
		thing2.copyFrom(thing);
		JSObjectAdapter.$put(thing, "name", "Changed Object Name");
		
		console.log("Updating Owned Object as owner 2...");
		EcRepository.save(thing2, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Updated.");
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				console.log("Failed to update.");
				console.log(p1);
				Assert.fail("Failed to update object.");
			}
		});
		
		console.log("Retrieving Owned Object as owner 2...");
		EcRepository.get(thing2.shortId(), new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcFile retrieved = (EcFile) p1;

				Assert.assertEquals("Name Does Not Match Saved Object Name", JSObjectAdapter.$get(thing2, "name"), retrieved.name);
				Assert.assertEquals("Id Does Not Match Saved Object Id", thing2.id, retrieved.id);

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
