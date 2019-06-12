package org.cassproject.schema.competency;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
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
@ScriptsBefore({"/forge/forge.bundle.js"})
public class EcFrameworkTest {

	static String server = "http://localhost:8080/api/";
	static EcPpk ppk;
	static EcIdentity newId1 = new EcIdentity();
	static EcRepository repo = new EcRepository();

	static String frameworkId;
	;

	static EcFramework framework;

	static EcCompetency comp;
	static EcCompetency comp2;
	static EcLevel level;
	static EcAlignment rel;

	@Before
	public void setup() {
		Global.console.log("setup");

		EcRemote.async = false;

		frameworkId = server + "data/" + EcFramework.myType.replace("http://", "").replace("https://", "").replaceAll("/", ".") + "/testFramework/1";

		ppk = EcPpk.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		newId1.ppk = ppk;
		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		repo.selectedServer = server;


		framework = new EcFramework();
		framework.generateId(server);

		framework.description = "Testing framework description";
		framework.name = "Framework Name";

		frameworkId = framework.id;
		framework.addOwner(ppk.toPk());


		Global.console.log("Saving Framework...");
		framework.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				frameworkId = framework.id;
				Global.console.log("Framework Saved.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Save Framework");
			}
		},null);


		comp = new EcCompetency();
		comp.generateId(server);
		comp.setName("Test Competency");

		comp.addOwner(ppk.toPk());

		Global.console.log("Saving Competency");
		EcRepository.save(comp, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Save Competency");
			}
		});

		level = new EcLevel();
		level.generateId(server);
		level.setName("Test Level");

		level.addOwner(ppk.toPk());

		Global.console.log("Saving Level");
		EcRepository.save(level, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Save Level");
			}
		});


		comp2 = new EcCompetency();
		comp2.generateId(server);
		comp2.setName("Test Competency 2");

		comp2.addOwner(ppk.toPk());

		Global.console.log("Saving 2nd Competency");
		EcRepository.save(comp2, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Save 2nd Competency");
			}
		});

		rel = new EcAlignment();
		rel.generateId(server);
		rel.source = comp.id;
		rel.target = comp2.id;
		rel.name = "Test Relation";
		rel.relationType = "requires";

		rel.addOwner(ppk.toPk());

		Global.console.log("Saving Relation");
		EcRepository.save(rel, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Save Relation");
			}
		});
	}

	@After
	public void afterTest() {
		framework._delete(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Delete Framework");
			}
		});

		comp._delete(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Delete Competency");
			}
		}, null);

		comp2._delete(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Delete 2nd Competency");
			}
		}, null);

		EcRepository._delete(rel, null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Delete Relation");
			}
		});

		EcRepository._delete(level, null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Delete Level");
			}
		});
	}


	@Test
	public void createFrameworkTest() {

		repo.search(new EcFramework().getSearchStringByType(), null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				for (int i = 0; i < p1.$length(); i++) {
					EcRemoteLinkedData d = p1.$get(i);

					if (d.id == framework.id) {
						return;
					}
				}

				Assert.fail("Unable to search for framework after save");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Search for Framework");
			}
		});
	}

	@Test
	public void createNoNameFrameworkTest() {
		EcFramework noName = new EcFramework();

		noName.generateId(server);

		noName.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("No Name Framework saved, should not be able to save a framework without a name");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Failed to save a Framework without a name");
			}
		},null);
	}

	@Test
	public void viewFrameworkTest() {

		EcRepository.get(framework.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				Assert.assertEquals("Name does not match saved name", framework.name, f.name);
				Assert.assertEquals("Description does not match saved description", framework.description, f.description);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework");
			}
		});
	}

	@Test
	public void updateFrameworkInfoTest() {
		final EcFramework editedFramework = new EcFramework();
		editedFramework.copyFrom(framework);
		editedFramework.name = "Updated Name";
		editedFramework.description = "Updated Description";

		Global.console.log("Updating Framework...");
		editedFramework.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to update Framework");
			}
		},null);

		EcRepository.get(editedFramework.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				Assert.assertEquals("Name does not match updated name", editedFramework.name, f.name);
				Assert.assertEquals("Description does not match updated description", editedFramework.description, f.description);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});
	}

	@Test
	public void updateFrameworkNoNameTest() {
		final EcFramework editedFramework = new EcFramework();
		editedFramework.copyFrom(framework);
		editedFramework.name = "";
		editedFramework.description = "Updated Description";

		Global.console.log("Updating Framework...");
		editedFramework.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Saved Framework with no name, this shouldnt be allowed");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Failed to update framework with no name");
			}
		},null);

		EcRepository.get(editedFramework.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				Assert.assertNotSame("Name should not be empty", editedFramework.name, f.name);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});
	}

	@Test
	public void updateFrameworkAddRemoveCompetencyTest() {

		EcFramework editedFramework = new EcFramework();
		editedFramework.copyFrom(framework);

		editedFramework.addCompetency(comp.id);

		Global.console.log("Adding Competency to Framework...");
		editedFramework.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to add competency to Framework");
			}
		},null);

		EcRepository.get(editedFramework.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if (f.competency.indexOf(comp.shortId()) != -1)
					return;

				Assert.fail("Unable to find competency in framework");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});

		EcFramework frameworkCompRemoved = new EcFramework();
		frameworkCompRemoved.copyFrom(editedFramework);
		frameworkCompRemoved.removeCompetency(comp.id, null, null);

		Global.console.log("Updating Framework...");
		frameworkCompRemoved.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Remove Competency from Framework");
			}
		},null);

		EcRepository.get(frameworkCompRemoved.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if (f.competency.indexOf(comp.id) == -1)
					return;

				Assert.fail("Competency not removed from framework");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});
	}

	@Test
	public void updateFrameworkRemoveNonCompetencyTest() {
		EcFramework frameworkCompRemoved = new EcFramework();
		frameworkCompRemoved.copyFrom(framework);

		final int compSize = framework.competency == null ? 0 : frameworkCompRemoved.competency.$length();
		frameworkCompRemoved.removeCompetency(comp.id, null, null);

		Global.console.log("Updating Framework...");
		frameworkCompRemoved.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Remove Competency from Framework");
			}
		},null);

		EcRepository.get(frameworkCompRemoved.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if ((f.competency == null && compSize == 0) || f.competency.$length() == compSize)
					return;

				Assert.fail("Competency array size did not remain unchanged");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});
	}

	@Test
	public void updateFrameworkAddRemoveLevelTest() {

		EcFramework editedFramework = new EcFramework();
		editedFramework.copyFrom(framework);

		editedFramework.addLevel(level.id);

		Global.console.log("Adding Level to Framework...");
		editedFramework.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to add level to Framework");
			}
		},null);

		EcRepository.get(editedFramework.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if (f.level.indexOf(level.shortId()) != -1)
					return;

				Assert.fail("Unable to find level in framework");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});


		EcFramework frameworkLevelRemoved = new EcFramework();
		frameworkLevelRemoved.copyFrom(editedFramework);
		frameworkLevelRemoved.removeLevel(level.id);

		Global.console.log("Updating Framework...");
		frameworkLevelRemoved.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Remove Level from Framework");
			}
		},null);

		EcRepository.get(frameworkLevelRemoved.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if (f.level.indexOf(level.id) == -1)
					return;

				Assert.fail("Level not removed from framework");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});
	}

	@Test
	public void updateFrameworkRemoveNonLevelTest() {
		EcFramework frameworkCompRemoved = new EcFramework();
		frameworkCompRemoved.copyFrom(framework);

		final int levelSize = framework.level == null ? 0 : frameworkCompRemoved.level.$length();
		frameworkCompRemoved.removeLevel(level.id);

		Global.console.log("Updating Framework...");
		frameworkCompRemoved.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Remove Competency from Framework");
			}
		},null);

		EcRepository.get(frameworkCompRemoved.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if ((f.level == null && levelSize == 0) || f.level.$length() == levelSize)
					return;

				Assert.fail("Level array size did not remain unchanged");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});
	}

	public void updateFrameworkAddRemoveRelationTest() {
		EcFramework editedFramework = new EcFramework();
		editedFramework.copyFrom(framework);

		editedFramework.addRelation(rel.id);

		Global.console.log("Adding Level to Framework...");
		editedFramework.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to add relation to Framework");
			}
		},null);

		EcRepository.get(editedFramework.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if (f.relation.indexOf(rel.shortId()) != -1)
					return;

				Assert.fail("Unable to find relation in framework");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});


		EcFramework frameworkRelationRemoved = new EcFramework();
		frameworkRelationRemoved.copyFrom(editedFramework);
		frameworkRelationRemoved.removeRelation(rel.id);

		Global.console.log("Updating Framework...");
		frameworkRelationRemoved.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Remove relation from Framework");
			}
		},null);

		EcRepository.get(frameworkRelationRemoved.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if (f.relation.indexOf(rel.id) == -1)
					return;

				Assert.fail("relation not removed from framework");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});
	}

	@Test
	public void updateFrameworkRemoveNonRelationTest() {
		EcFramework frameworkCompRemoved = new EcFramework();
		frameworkCompRemoved.copyFrom(framework);

		final int relSize = framework.relation == null ? 0 : frameworkCompRemoved.relation.$length();
		frameworkCompRemoved.removeRelation(rel.id);

		Global.console.log("Updating Framework...");
		frameworkCompRemoved.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Updated.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Remove Competency from Framework");
			}
		},null);

		EcRepository.get(frameworkCompRemoved.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework f = (EcFramework) p1;

				if ((f.relation == null && relSize == 0) || f.relation.$length() == relSize)
					return;

				Assert.fail("Level array size did not remain unchanged");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Retreive Framework after update");
			}
		});
	}


	@Test
	public void deleteFramework() {
		EcFramework toDelete = new EcFramework();
		toDelete.generateId(server);
		toDelete.name = "Framework to Delete";

		toDelete.addOwner(ppk.toPk());

		Global.console.log("Saving Framework to Delete");
		toDelete.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Framework Saved.");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Save Framework");
			}
		},null);

		Global.console.log("Deleting Framework...");
		toDelete._delete(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Successfully deleted Framework");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to Delete Framework");
			}
		});

		EcRepository.get(toDelete.shortId(), new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				if ((p1.context != "" && p1.context != null) || (p1.type != "" && p1.type != null))
					Assert.fail("Shouldn't be able to Retreive Framework after delete");
			}
		}, null);
	}
}
