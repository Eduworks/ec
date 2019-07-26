package org.cassproject.schema.competency;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcLevel;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"pem-jwk.js", "require.js","/forge/forge.bundle.js"})
public class EcCompetencyTest {

	static String server = "http://localhost:8080/api/";
	static EcPpk ppk;
	static EcIdentity newId1 = new EcIdentity();
	static EcRepository repo = new EcRepository();

	static EcCompetency comp;

	@Before
	public void setup() {
		Global.console.log("setup");

		EcRemote.async = false;

		repo.selectedServer = server;

		ppk = EcPpk.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		newId1.ppk = ppk;
		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		comp = new EcCompetency();
		comp.generateId(server);
		comp.name = "Test Competency Name";
		comp.description = "Test Competency Description";

		comp.addOwner(ppk.toPk());

		comp.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to save Competency");
			}
		}, null);
	}

	@After
	public void breakdown() {
		comp._delete(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to delete Competency");
			}
		}, null);
	}

	@Test
	public void createCompetencyTest() {
		repo.search(new EcCompetency().getSearchStringByType(), null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				for (int i = 0; i < p1.$length(); i++) {
					EcRemoteLinkedData d = p1.$get(i);

					if (d.id == comp.id) {
						return;
					}
				}

				Assert.fail("Unable to search for competency after save");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Search for Competency");
			}
		});
	}

	@Test
	public void createNoNameCompetencyTest() {
		EcCompetency noName = new EcCompetency();
		noName.generateId(server);
		noName.addOwner(ppk.toPk());

		noName.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Saved Competency with missing name, shouldn't happen");
			}
		}, null, null);
	}

	@Test
	public void viewCompetencyTest() {
		EcRepository.get(comp.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcCompetency c = new EcCompetency();
				c.copyFrom(p1);

				Assert.assertEquals("Name not equal to saved name", c.name, comp.name);
				Assert.assertEquals("Description not equal to saved description", c.description, comp.description);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Get Competency");
			}
		});
	}

	@Test
	public void competencyAddRemoveRelationshipTest() {

		EcCompetency comp2 = new EcCompetency();

		comp2.name = "Relation Target Competency";
		comp2.addOwner(ppk.toPk());
		comp2.generateId(server);

		comp2.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to save target competency");
			}
		}, null);


		Global.console.log("Creating Relationship..");
		final EcAlignment rel = comp.addAlignment(comp2, "requires", ppk, server, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Relationship Created");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to create relationship");
			}
		}, null);

		Global.console.log("finding relationships...");
		comp.relationships(repo, new Callback1<EcAlignment>() {
			@Override
			public void $invoke(EcAlignment p1) {
				Assert.assertEquals(rel.id, p1.id);
				Assert.assertEquals("Relationship source does not match competency", comp.shortId(), p1.source);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to find relationships");
			}
		}, new Callback1<Array<EcAlignment>>() {
			@Override
			public void $invoke(Array<EcAlignment> p1) {
				if (p1.$length() == 0)
					Assert.fail("Relationship does not exist in the repository");
			}
		});

		Global.console.log("deleting relationship...");
		EcRepository._delete(rel, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {

				Global.console.log("finding relationships after delete...");
				comp.relationships(repo, new Callback1<EcAlignment>() {
					@Override
					public void $invoke(EcAlignment p1) {
						Assert.fail("No Relationships should be found. "+p1.shortId());
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						Assert.fail("failed to search for relationships");
					}
				}, new Callback1<Array<EcAlignment>>() {
					@Override
					public void $invoke(Array<EcAlignment> p1) {
						if (p1.$length() > 0)
							Assert.fail("Return a relationship after deleting it");
					}
				});

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to delete relationship");
			}
		});

		comp2._delete(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to delete target competency");

			}
		}, null);
	}

	@Test
	public void competencyAddRemoveLevelTest() {

		Global.console.log("Creating Level...");
		final EcLevel lev = comp.addLevel("Level Test", "Description of level Test", ppk, server, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Level Created");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Create Level");
			}
		}, null);

		Global.console.log("Finding level...");
		comp.levels(repo, new Callback1<EcLevel>() {
			@Override
			public void $invoke(EcLevel p1) {
				Assert.assertEquals(lev.id, p1.id);
				Assert.assertEquals("Level Competency does not match competency ID", comp.shortId(), lev.competency);
			}
		}, new Callback1<String>() {

			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Retrieve Level");
			}
		}, new Callback1<Array<EcLevel>>() {

			@Override
			public void $invoke(Array<EcLevel> p1) {
				if (p1.$length() != 1)
					Assert.fail("Unable to find competency");
			}
		});

		Global.console.log("deleting level...");
		EcRepository._delete(lev, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("deleted level");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to delete level");
			}
		});

		Global.console.log("finding relationships after delete...");
		comp.levels(repo, new Callback1<EcLevel>() {
			@Override
			public void $invoke(EcLevel p1) {
				Assert.fail("No levels should be found");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to search for levels");
			}
		}, new Callback1<Array<EcLevel>>() {
			@Override
			public void $invoke(Array<EcLevel> p1) {
				if (p1.$length() > 0)
					Assert.fail("Returned a level after deleting it");
			}
		});
	}

	@Test
	public void updateCompetencyInfo() {
		comp.name = "Changed Name";
		comp.description = "Changed Description";
		comp.scope = "a scope is added!";

		Global.console.log("Updating Competency...");
		comp.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Competency Updated");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Update the Competency");
			}
		}, null);

		Global.console.log("Retrieving Competency after update...");
		EcRepository.get(comp.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcCompetency c = new EcCompetency();
				c.copyFrom(p1);

				Assert.assertEquals(comp.id, c.id);
				Assert.assertEquals(comp.name, c.name);
				Assert.assertEquals(comp.description, c.description);
				Assert.assertEquals(comp.scope, c.scope);

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Retrieve Competency after Update");
			}
		});
	}

	@Test
	public void deleteCompetencyTest() {

		final EcCompetency toDelete = new EcCompetency();
		toDelete.generateId(server);
		toDelete.name = "Competency To Delete";
		toDelete.addOwner(ppk.toPk());

		Global.console.log("saving competency to delete...");
		toDelete.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to save competency for delete");
			}
		}, null);

		Global.console.log("deleting competency...");
		toDelete._delete(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				// TODO Auto-generated method stub

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to delete Competency");
			}
		}, null);

		Global.console.log("searching for deleted competency...");
		repo.search("@type:\"" + toDelete.myType + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				for (int i = 0; i < p1.$length(); i++) {
					EcRemoteLinkedData d = p1.$get(i);

					if (d.id == toDelete.id) {
						Assert.fail("Shouldnt find competency after delete");
					}
				}
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Search for Competency");
			}
		});

	}

	@Test
	public void deleteCompetencyWithRelationshipTest() {

		final EcCompetency toDelete = new EcCompetency();
		toDelete.generateId(server);
		toDelete.name = "Competency To Delete";
		toDelete.addOwner(ppk.toPk());

		Global.console.log("saving competency to delete...");
		toDelete.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to save competency for delete");
			}
		}, null);

		EcCompetency comp2 = new EcCompetency();
		comp2.generateId(server);
		comp2.name = "target Comeptency";
		comp2.addOwner(ppk.toPk());

		Global.console.log("Saving Target Competency...");
		comp2.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Saved Target Competency");
			}
		}, null);

		Global.console.log("Creating Relationship...");
		EcAlignment rel = toDelete.addAlignment(comp2, "requires", ppk, server, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Created Relationship");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Create Relationship");
			}
		}, null);

		Global.console.log("Deleting Competency with Relationship...");
		toDelete._delete(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Deleted Competency with Relationship");
				toDelete.relationships(repo, new Callback1<EcAlignment>() {
					@Override
					public void $invoke(EcAlignment p1) {
						Assert.fail("No Relationships should be found");
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						Assert.fail("failed to search for relationships");
					}
				}, new Callback1<Array<EcAlignment>>() {
					@Override
					public void $invoke(Array<EcAlignment> p1) {
						if (p1.$length() > 0)
							Assert.fail("Returned a relationship after deleting the competency");
					}
				});

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to delete relationship Competency");
			}
		}, repo);


		comp2._delete(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				// TODO Auto-generated method stub

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to delete target Competency");
			}
		}, null);

	}

	@Test
	public void deleteCompetencyWithLevelTest() {

		final EcCompetency toDelete = new EcCompetency();
		toDelete.generateId(server);
		toDelete.name = "Competency To Delete";
		toDelete.addOwner(ppk.toPk());

		Global.console.log("saving competency to delete...");
		toDelete.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to save competency for delete");
			}
		}, null);


		Global.console.log("Creating Relationship...");
		EcLevel level = toDelete.addLevel("level to be deleted", "level description", ppk, server, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Created Level");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Create Level");
			}
		}, null);

		Global.console.log("Deleting Competency with Level...");
		toDelete._delete(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Deleted Competency with Level");
				toDelete.levels(repo, new Callback1<EcLevel>() {
					@Override
					public void $invoke(EcLevel p1) {
						Assert.fail("No Relationships should be found");
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						Assert.fail("failed to search for relationships");
					}
				}, new Callback1<Array<EcLevel>>() {
					@Override
					public void $invoke(Array<EcLevel> p1) {
						if (p1.$length() > 0)
							Assert.fail("Returned a relationship after deleting the competency");
					}
				});

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to delete Level Competency");
			}
		}, repo);

	}

}
