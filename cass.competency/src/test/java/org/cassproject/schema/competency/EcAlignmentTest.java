package org.cassproject.schema.competency;

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
import org.stjs.javascript.Date;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/forge/forge.bundle.js" })
public class EcAlignmentTest {

	static String server = "http://localhost:9722/api/custom/";
	static EcPpk ppk;
	static EcIdentity newId1 = new EcIdentity();
	static EcRepository repo = new EcRepository();
	
	static EcCompetency sourceComp;
	static EcCompetency targetComp;
	
	static EcAlignment relation;
	
	@Before
	public void setup(){
		Global.console.log("setup");
		
		EcRemote.async = false;
		
		repo.selectedServer = server;
		
		ppk = EcPpk.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		
		newId1.ppk = ppk;
		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);
		
		sourceComp = new EcCompetency();
		sourceComp.generateId(server);
		sourceComp.name = "Source Name";
		sourceComp.addOwner(ppk.toPk());
		
		targetComp = new EcCompetency();
		targetComp.generateId(server);
		targetComp.name = "Target Name";
		targetComp.addOwner(ppk.toPk());
		
		relation = new EcAlignment();
		relation.generateId(server);
		relation.source = sourceComp.shortId();
		relation.target = targetComp.shortId();
		relation.name = "source to target relation";
		relation.relationType = "requires";
		relation.addOwner(ppk.toPk());
		relation.validFrom = new Date().toDateString();
		Date end = new Date();
		end.setFullYear(2017);
		relation.validThrough = end.toDateString();
		relation.agent = "test agent";
		
		
		sourceComp.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to create Source Competency");
			}
		});
		
		targetComp.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to create Target Competency");
			}
		});
		
		relation.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to create Relation");
			}
		});
	}
	
	@After
	public void breakdown(){
		relation._delete(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to delete relation");
			}
		});
		
		sourceComp._delete(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to delete source competency");
			}
		}, null);
		
		targetComp._delete( null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("failed to delete target competency");
			}
		}, null);
	}
	
	
	@Test
	public void createAlignmentTest(){
		repo.search("@type:\""+relation.myType+"\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				for(int i = 0; i < p1.$length(); i++){
					EcRemoteLinkedData d = p1.$get(i);
					
					if(d.id == relation.id){
						return;
					}
				}
				
				Assert.fail("Unable to find relation after save");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Search for relation after save");
			}
		});
	}
	
	@Test
	public void createNoSourceAlignmentTest(){
		EcAlignment noSource = new EcAlignment();
		
		noSource.generateId(server);
		noSource.target = targetComp.shortId();
		noSource.relationType = "requires";
		noSource.addOwner(ppk.toPk());
		
		noSource.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Relation Saved without source competency, shouldn't happen");
			}
		}, null);
	}
	
	@Test
	public void createNoTargetAlignmentTest(){
		EcAlignment noSource = new EcAlignment();
		
		noSource.generateId(server);
		noSource.source = sourceComp.shortId();
		noSource.relationType = "requires";
		noSource.addOwner(ppk.toPk());
		
		noSource.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Relation Saved without target competency, shouldn't happen");
			}
		}, null);
	}
	
	@Test
	public void createNoTypeAlignmentTest(){
		EcAlignment noSource = new EcAlignment();
		
		noSource.generateId(server);
		noSource.source = sourceComp.shortId();
		noSource.target = targetComp.shortId();
		noSource.addOwner(ppk.toPk());
		
		noSource.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Relation Saved without relationType field, shouldn't happen");
			}
		}, null);
	}
	
	@Test
	public void viewAlignmentTest(){
		EcRepository.get(relation.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcAlignment r = new EcAlignment();
				r.copyFrom(p1);
				
				Assert.assertEquals(relation.id, r.id);
				Assert.assertEquals("Name not equal to saved name", relation.name, r.name);
				
				Assert.assertEquals("Title not equal to saved Title", relation.description, r.description);
				Assert.assertEquals("Source does not match source competency short Id", relation.source, sourceComp.shortId());
				Assert.assertEquals("Target does not match target competency short Id", relation.target, targetComp.shortId());

				Assert.assertEquals("validFrom does not match saved validFrom", relation.validFrom, r.validFrom);
				Assert.assertEquals("validThrough does not match saved validThrough", relation.validThrough, r.validThrough);
				Assert.assertEquals("Agent does not match saved agent", relation.agent, r.agent);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Get relation");
			}
		});
	}
	
	@Test
	public void updateAlignmentInfo(){
		relation.name = "changed relation name";
		relation.description = "changed description";
		relation.relationType = "required By";
		relation.validFrom = new Date().toDateString();
		Date end = new Date();
		end.setFullYear(2017);
		relation.validThrough = end.toDateString();
		relation.agent = "changed agent";
	
		Global.console.log("Updating Relation");
		relation.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log("Updated Relation successfully");
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to save updated relation");
			}
		});
		
		Global.console.log("Getting Relation after update");
		EcRepository.get(relation.id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcAlignment r = new EcAlignment();
				r.copyFrom(p1);
				
				Assert.assertEquals(relation.id, r.id);
				Assert.assertEquals("Name not equal to saved name", relation.name, r.name);
				
				Assert.assertEquals("Title not equal to saved Title", relation.description, r.description);

				Assert.assertEquals("validFrom does not match saved validFrom", relation.validFrom, r.validFrom);
				Assert.assertEquals("validThrough does not match saved validThrough", relation.validThrough, r.validThrough);
				Assert.assertEquals("Agent does not match saved agent", relation.agent, r.agent);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Get relation after update");
			}
		});
	}
	
	@Test
	public void updateAlignmentRemoveSource(){
		relation.source = null;
		relation.target = targetComp.shortId();
		
		relation.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Saved Relation without source, shouldn't be allowed");
			}
		}, null);
	}
	
	@Test
	public void updateAlignmentRemoveTarget(){
		relation.source = sourceComp.shortId();
		relation.target = null;
		
		relation.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Saved Relation without target, shouldn't be allowed");
			}
		}, null);
	}
	
	@Test
	public void updateAlignmentRemoveType(){
		relation.source = sourceComp.shortId();
		relation.target = targetComp.shortId();
		relation.relationType = null;
		
		relation.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Saved Relation without relation Type, shouldn't be allowed");
			}
		}, null);
	}
	
	@Test
	public void deleteAlignmentTest(){
		EcAlignment toDelete = new EcAlignment();
		toDelete.generateId(server);
		toDelete.name = "Relation To Delete";
		toDelete.source = sourceComp.shortId();
		toDelete.target = targetComp.shortId();
		toDelete.addOwner(ppk.toPk());
		
		Global.console.log("saving relation to delete...");
		EcRepository.save(toDelete, null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to save relation for delete");
			}
		});
		
		Global.console.log("deleting relation...");
		toDelete._delete(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to delete relation");
			}
		});
		
		Global.console.log("searching for deleted relation...");
		repo.search("@type:\""+toDelete.myType+"\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				for(int i = 0; i < p1.$length(); i++){
					EcRemoteLinkedData d = p1.$get(i);
					
					if(d.id == toDelete.id){
						Assert.fail("Shouldnt find relation after delete");
					}
				}
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Search for relation after delete");
			}
		});
	}
}
