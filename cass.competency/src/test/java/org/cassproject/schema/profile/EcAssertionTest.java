package org.cassproject.schema.profile;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cass.competency.EcCompetency;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
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

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"/forge/forge.bundle.js"})
public class EcAssertionTest {
	static String server = "http://localhost:8080/api/";
	static EcPpk ppk1;
	static EcPpk ppk2;
	static EcPpk ppk3;
	static EcIdentity newId1 = new EcIdentity();
	static EcIdentity newId2 = new EcIdentity();
	static EcIdentity newId3 = new EcIdentity();
	static EcRepository repo = new EcRepository();

	static EcCompetency comp;
	static EcAssertion assn;

	@Before
	public void setup() {
		Global.console.log("setup");

		EcRemote.async = false;

		repo.selectedServer = server;

		ppk1 = EcPpk.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");

		newId1.ppk = ppk1;

		ppk2 = EcPpk.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEowIBAAKCAQEAtjVO4W6FVf1SyCKEzwd2dKnT43dWRFes6SJeKVI+/GalNR1bxhc7UWOBZ3T2xuIo83tRot0ybFpTHMD7JAptkfP4C9YtidVyRBznQLwqExS6+0Qc39L+lefpHbi6QD24MKPZa5+FylcQJ7Olu30NIXDQd7ZOZrXkV/C4KAHVKg+CrhDPGfLp3IuQh3+ZAhRKIvP3I2MP0rUpNU5ChdjQJyro3AzBuuf92K6QBG8sfn2al0qJiNqREhusHE+SDhk+IbvISr38nmEMgwZrN1z/UrXf0ycK6hIpgTQH0SVWMxYTt4G3MLLALGTUzAM1LcmOaDwt8xAdJyS/4Y/BicsuVQIDAQABAoIBAFFV9JNPKbgb8AMk3ZIpK6iiUtK8Z8b0OFyNmejqLPGwxFi0dU40+qa3O4G6RZq8RDmEOAnyodqaa3Vvc+w/t2+qr3RhNEzN+kcLe/N6y3FfFKSrYBRN9JVoQ7ifyIx6wKj9y0VunWOYf76pQ/cwuFbQLE70E4Vn9rmG3D4Hq2ctabiIxl00h1CQ0t7EyOsneOmiMkBFjSguzJDRD8q3eFD39rpRdP913G0HsqhHEh3/nvK2rXnGHki3VEVp2TupPUyWu2RyK1liAJe8zqt0ghosu5DutBkbxdVL4e3AqmZy4yBc6sKGhg4pfyBbLumO5keZa63ynESbiDGdNw4WtKECgYEA7D197RuirwlCtWIhWKVQCzKLdKEsqzsIDQ/QtERSNJjAPGEcsNWlFUV6yPTRjtHpmN9gWTmWzaXBE9zVUMDIdWDxdyr5O11rXV0ZIjJ3GepTd9fpelOzxJhmA96LHVXS2OeyThY6T/gpl6tKLTPD2KUKVAgXUWcSnrZuHeVv8C0CgYEAxXLadIXn0AXe7zk3t2Ff78njEEPSdzLcRzG35k6NoBgUTr2rJKe8oYMS4L6NWFMfZWla1YSNCC/vINJLdbJGvSI8ttTMAs8IM2PegrW2QLS596TDqMsVbo1PfyawlmGjybvZf7zIm0lDW1qUTWgQMdealdEwn4ONmlQdpt5L58kCgYEAvjGnn2yfZmKDRXrStAar0cgIxIY6a0UkbzerZGaY9GWCZ1ob+jaXKO/+MaoAyQYxFnXIoS0fP0PSlYY2a0Q6X14EKVf8vhGxLcKVSJXuk3u3ZYX8IBMhaQb1IupZf+2nyh+HyxxUKCv4eHZcStYhN9tv3EWDWHMuZ38iWolsvKUCgYBMIgsl3vQRfBIH//IB3aQWW6wX+27N02iocv1L6oIlduNtsSiqi5rqVBYVXqQ1qGd0vPjvV5rhy0nTSAMcsM8h4m+yt76qXpX06s9DazmJHaaPXJKtJRFwfUBn8M0qTx/Oi4ZEANEBP3Cfav/AER4dedr7ZZvwBdO17DU6wIBYMQKBgCpQSniwFgW54C4OGUUBnSil/mKBo7mC8DJdOaXqLp5yjNqGGxVH78FAnkYpLpO+mbF2GUFWs8GvXY08Bt/hN2DdqIxViUqGcppr7LHxMRdEj7vGxL+ek5VdUvC8eIzeOtNBzypBBo1lSQD49c3Fg9Dc5DYa+oZSWqGOo1+InUbC-----END RSA PRIVATE KEY-----");

		newId2.ppk = ppk2;

		ppk3 = EcPpk.fromPem("-----BEGIN RSA PRIVATE KEY-----MIIEpQIBAAKCAQEAlDSpGeoXBxlIKLglcMKDtTLbiY/KZfndBfP1OQbRZTYpR2/IXAG3t5IJqHa2UzQjwNzFVPXACtLC3v/lNCorwbecol9Y3soYOrtHb6UjR8PifqnCRUqb1/wQMJ+HS3iqIa1R1R341fdPdtD/HASgcNp8kpgiSrh/wQOrsc4BD8zysu4mWA331rTLhuwTGgEovc+ua64DIHEgTqVcQy36cw8FUKtkQDSX6pZyAUKfF0aTibfxHJCLKTasITkne/FUKrp2watJ+hnUih8LsXSQzeVkOdkK1RhZjFYzqigwdWhYKy36ArEJz3bdSA/Y03wKqzUfn/bMvPTR1ACRkRc83QIDAQABAoIBAQCDbtAoczlIylr8AZLylQ5Iu3mGXUaZeSVSCjAHCszYfVfOSovdTIio+5IlHGJFF5A9kYxO9EIDVzYKndWelWeIvFTkiro9mewy6bNIh6LqGgXbXqEy4h+jQ574AAH0JGZ8x0AzSAlNd625KU+UgWXnr1uaheCjc0uY2LCDVrYKU9Bca5+mTzQzUrmrVG0U8xS1C3uVYKAGbnjHup3PEW0wXA3FPeq6YKw3BSxO3EggMPLiLTElWTVEsnZY0zBU5eXMS/e7iJvc5QgmrT4N7+rDY00ZUlcgoU51WyQmAIOrtEHqQHBAF68s3lHxHrix1y9+spaA8PYWKdxePto1gWEBAoGBAOiLXWum4v7AGNX5iLvr1rsL6h7WO6V/VqZ4JGnzDu/Ww7i1ODaAa6HX8rrNsnWFJgQH3Mkc1q81m5rnyH7q7TpEC9rC6trZhhCDfIGsxWo3+6lc6zxUVoiAyLADLfh/ND49kLivHklQIwhwfUxDVTb7SFwMJPS4fad49Ms76UbpAoGBAKMnjDx2ia4gjQghiN3aDaHYhCBn5sQ1q8xxQGcDD3Kfot9djoXpdLb2wrW9KalAaCZGROyl3DREDdJ8vKAS6LW2Hfom2bO11szjsNwkjDoyw2y4owfkRAXfN5BDIRQAPxsY+y/qtPiBPccsI68g6FhUi4VeJ8rOqHyZb/PpKTXVAoGALx/2+ZbjT17caZhc9kAvzs32TvN5OOuaQrf8ISBpeX8bQLYwwxK5PR4HCYYf0SL/djelrXfTpcQGWZj5D4dKNdGOWXHAqEMGoRgURi8d/o2DyWmUHjC1LIp0oP6z9TTKAIb3agXK7G55+v7Y1Xibrz2zBzxKzPEKPcMMUJc+iekCgYEAlwsFyPP0gj+gUOa6zqgP9sV7jISkHwGRCrPN64/pvTQMlL0INPDsHHZVy+pTp1z5DnX/WRYzxi86nKLd/VOEHLV9CxjscnLlaMlh8mvjZf2Y7g4A4E1yq/z6c5OyC9IumeeGo9WltGnxx3IVlwvgDeY3REDmldq8IJ3sBuLURAECgYEA4cA5aTnJ8EWhDSW12QVxUdgaPN6YYfpCHV42UgLbz7Zc3yT3K7aTLVJRxBPenk9Hbc3y81y1INmgRDfzkpgNgTHkfqME6AVMeCD9N6YSz+Gz4NEsfZ9W11uXoCPCywKC1iw8x2YOaq7ilAH6NQLgZO1/Om693Z4tUwn0OEZ/tcY=-----END RSA PRIVATE KEY-----");

		newId3.ppk = ppk3;

		comp = new EcCompetency();
		comp.name = "Just a Competency";
		comp.generateId(server);
		comp.addOwner(ppk1.toPk());

		comp.save(null, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Assert.fail("Failed to Save Competency");
			}
		},null);

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
	public void assertionEncryptDecryptTest() {
		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		EcAssertion assn = new EcAssertion();
		EcPk agent = ppk1.toPk();
		EcPk subject = ppk2.toPk();
		EcPk thirdParty = ppk3.toPk();

		Long assertionDate = (Long)(Object)Date.now();
		Long expirationDate = (Long)(Object)Date.now()+1000*60*60*24*30;
		assn.generateId(server);
		assn.addOwner(agent);
		assn.setSubject(subject);
		assn.setAgent(agent);
		assn.setCompetency(comp.id);
		assn.setConfidence(0.85); //How confident, from 0-1, is the agent in this assertion?
		assn.setAssertionDate(assertionDate); //UTC Milliseconds
		assn.setExpirationDate(expirationDate); //UTC Milliseconds, 30 days in the future.
		assn.setDecayFunction("t"); //Decays linearly with time. Could also be t^2 or sqrt(t)
		assn.setNegative(false); //This is an assertion that an individual *can* do something, not that they *cannot*.
		Array<String> evidences = new Array<>();
		evidences.push("I saw them do it.");
		assn.setEvidence(evidences); //An array of evidence is required. Any string (URLs for instance) will do.

		Global.console.log("Setup of assertion");
		Global.console.log(assn);

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId2);

		Assert.assertEquals("Subject not readable by subject.", subject.toPem(), assn.getSubject().toPem());
		Assert.assertEquals("Agent not readable by subject.", agent.toPem(), assn.getAgent().toPem());
		Assert.assertEquals("Assertion Date not readable by subject.", assertionDate, assn.getAssertionDate());
		Assert.assertEquals("Expiration Date not readable by subject.", expirationDate, assn.getExpirationDate());
		Assert.assertEquals("Evidence not readable by subject.", evidences.$get(0), assn.getEvidence(0));
		Assert.assertEquals("Negative not readable by subject.", false, assn.getNegative());
		Assert.assertEquals("Decay Function not readable by subject.", "t", assn.getDecayFunction());

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		assn.addReader(thirdParty);
		Global.console.log("Added Third Party to assertion");
		Global.console.log(assn);

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId3);

		Assert.assertEquals("Subject not readable by third party.", subject.toPem(), assn.getSubject().toPem());
		Assert.assertEquals("Agent not readable by third party.", agent.toPem(), assn.getAgent().toPem());
		Assert.assertEquals("Assertion Date not readable by third party.", assertionDate, assn.getAssertionDate());
		Assert.assertEquals("Expiration Date not readable by third party.", expirationDate, assn.getExpirationDate());
		Assert.assertEquals("Evidence not readable by third party.", evidences.$get(0), assn.getEvidence(0));
		Assert.assertEquals("Negative not readable by third party.", false, assn.getNegative());
		Assert.assertEquals("Decay Function not readable by third party.", "t", assn.getDecayFunction());

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		assn.removeReader(thirdParty);
		Global.console.log("Removed Third Party to assertion");
		Global.console.log(assn);

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId3);

		Assert.assertEquals("Subject readable by third party.", null, assn.getSubject());
		Assert.assertEquals("Agent readable by third party.", null, assn.getAgent());
		Assert.assertEquals("Assertion Date readable by third party.", null, assn.getAssertionDate());
		Assert.assertEquals("Expiration Date readable by third party.", null, assn.getExpirationDate());
		Assert.assertEquals("Evidence readable by third party.", null, assn.getEvidence(0));
		Assert.assertEquals("Negative readable by third party.", false, assn.getNegative());
		Assert.assertEquals("Decay Function readable by third party.", null, assn.getDecayFunction());
	}
}
