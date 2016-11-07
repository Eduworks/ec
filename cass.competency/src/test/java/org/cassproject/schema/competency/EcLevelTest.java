package org.cassproject.schema.competency;

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

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import com.sun.tools.javac.resources.compiler;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/forge/forge.bundle.js" })
public class EcLevelTest {

	static String server = "http://localhost:9722/api/custom/";
	static EcPpk ppk;
	static EcIdentity newId1 = new EcIdentity();
	static EcRepository repo = new EcRepository();
	
	static EcLevel level;
	
	static EcCompetency comp;
	
	@Before
	public void setup(){
		Global.console.log("setup");
		
		EcRemote.async = false;
		
		repo.selectedServer = server;
		
		ppk = EcPpk.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		
		newId1.ppk = ppk;
		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);
		
		level = new EcLevel();
		level.generateId(server);
		level.name= "Test Level Name";
		level.description = "Test Level Description";
		level.title = "test level Title";
		level.performance = "Performance Description";
		
		level.addOwner(ppk.toPk());
		
		comp = new EcCompetency();
		comp.name = "Level Competency";
		comp.generateId(server);
		comp.addOwner(ppk.toPk());
		
		comp.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Save Level Competency");
			}
		});
		
		level.competency = comp.shortId();
		
		level.save(null, new Callback1<String>(){
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to save Level");
			}
		});
	}
	
	@After
	public void breakdown(){
		level._delete(null,  new Callback1<String>(){
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to delete Level");
			}
		});
		
		comp._delete(null,  new Callback1<String>(){
			@Override
			public void $invoke(String p1) {
				Assert.fail("Unable to delete Level Competency");
			}
		}, null);
	}
	
	@Test
	public void createLevelTest(){
		repo.search(new EcLevel().getSearchStringByType(), null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				for(int i = 0; i < p1.$length(); i++){
					EcRemoteLinkedData d = p1.$get(i);
					
					if(d.id == level.id){
						return;
					}
				}
				
				Assert.fail("Unable to search for level after save");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Search for level");
			}
		});
	}
	
	@Test
	public void createLevelNoNameTest(){
		EcLevel noName = new EcLevel();
		
		noName.generateId(server);
		noName.competency = comp.shortId();
		
		noName.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Level saved without name, should not happen");
			}
		}, null);
	}
	
	@Test
	public void createLevelNoCompetencyTest(){
		EcLevel noComp = new EcLevel();
		
		noComp.generateId(server);
		noComp.name = "Test Level Name";
		
		noComp.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Level saved without competency, should not happen");
			}
		}, null);
	}
	
	@Test
	public void viewLevelTest(){
		EcRepository.get(level.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcLevel l = new EcLevel();
				l.copyFrom(p1);
				
				Assert.assertEquals(level.id, l.id);
				Assert.assertEquals("Name not equal to saved name", level.name, l.name);
				Assert.assertEquals("Description not equal to saved description", level.description, l.description);
				Assert.assertEquals("Title not equal to saved Title", level.title, l.title);
				Assert.assertEquals("Performance not equal to saved Performance", level.performance, l.performance);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Get Competency");
			}
		});
	}
	
	@Test
	public void updateLevelInfoTest(){
		level.name = "Changed Name";
		level.description = "Changed Description";
		level.title = "Changed Title";
		level.performance = "Changed performance";
		
		Global.console.log("Updating Level...");
		level.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Level Updated");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Update the Level");
			}
		});
		
		Global.console.log("Retrieving Level after update...");
		EcRepository.get(level.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcLevel l = new EcLevel();
				l.copyFrom(p1);
				
				Assert.assertEquals(level.id, l.id);
				Assert.assertEquals("Name not equal to updated name", level.name, l.name);
				Assert.assertEquals("Description not equal to updated description", level.description, l.description);
				Assert.assertEquals("Title not equal to updated Title", level.title, l.title);
				Assert.assertEquals("Performance not equal to updated Performance", level.performance, l.performance);
				
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Retrieve Competency after Update");
			}
		});
	}
	
	@Test
	public void updateLevelNoNameTest(){
		level.name = "";
		level.competency = comp.shortId();
		
		Global.console.log("Updating Level without name...");
		level.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Updated Level without name, shouldn't happen");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Failed to update Level");
			}
		});
	}
	
	@Test
	public void updateLevelNoCompetencyTest(){
		level.name = "updated name";
		level.competency = "";
		
		Global.console.log("Updating Level without competency...");
		level.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Updated Level without competency, shouldn't happen");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Failed to update Level");
			}
		});
	}
	
	@Test
	public void deleteLevelTest(){
		
		final EcLevel toDelete = new EcLevel();
		toDelete.generateId(server);
		toDelete.name = "Competency To Delete";
		toDelete.addOwner(ppk.toPk());
		toDelete.competency = comp.shortId();
		
		Global.console.log("saving level to delete...");
		toDelete.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to save level for delete");
			}
		});
		
		Global.console.log("deleting level...");
		toDelete._delete(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to delete Level");
			}
		});
		
		Global.console.log("searching for deleted level...");
		repo.search("@type:\""+toDelete.myType+"\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				for(int i = 0; i < p1.$length(); i++){
					EcRemoteLinkedData d = p1.$get(i);
					
					if(d.id == toDelete.id){
						Assert.fail("Shouldnt find level after delete");
					}
				}
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Search for level after delete");
			}
		});
	}
	
	
}
