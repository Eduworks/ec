package cass.rollup;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.competency.EcLevel;
import org.cass.profile.EcAssertion;
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

import com.eduworks.ec.callback.EcCallbackReturn1;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.schema.ebac.EbacSignature;

import cass.rollup.InquiryPacket.IPType;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "lib/require.js", "rollupInit.js", "/forge/forge.bundle.js" })
public class EvidenceProcessingEquivalentTest
{
	EcRepository repo;
	String frameworkId;
	String competencyId;
	String competencyId2;
	String assertionId;
	EcIdentity newId1;
	EcFramework f;
	EcCompetency c;
	EcCompetency c2;
	EcAlignment r;

	@Before
	public void setup()
	{
		repo = new EcRepository();
		repo.selectedServer = "https://dev.cassproject.org/api/custom";

		newId1 =  new EcIdentity();
		newId1.ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
;

		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

		f = new EcFramework();
		f.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		f.name = "Bobby's Framework";
		f.generateId(repo.selectedServer);
		frameworkId = f.shortId();

		c = new EcCompetency();
		c.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		c.name = "Add";
		c.generateId(repo.selectedServer);
		competencyId = c.shortId();

		c2 = new EcCompetency();
		c2.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		c2.name = "Sums";
		c2.generateId(repo.selectedServer);
		competencyId2 = c2.shortId();

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());
		
		r = new EcAlignment();
		r.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		r.generateId(repo.selectedServer);
		r.relationType = EcAlignment.IS_EQUIVALENT_TO;
		r.source = c.shortId();
		r.target = c2.shortId();
		
		f.addRelation(r.shortId());

		EcRemote.async = false;

		f.save(null, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Global.console.log(p1);
			}
		});
		c.save(null, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Global.console.log(p1);
			}
		});
		c2.save(null, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Global.console.log(p1);
			}
		});

		r.save(null, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Global.console.log(p1);
			}
		});

		Global.console.log("setup");

		EcAssertion a = new EcAssertion();
		a.generateId(repo.selectedServer);
		a.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setSubject(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setAgent(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setCompetency(competencyId2);
		a.setConfidence(1.0);
		a.setAssertionDate((long) new Date().getTime());
		a.setExpirationDate((long) (new Date().getTime()) + 1000 * 60 * 60);
		a.setDecayFunction("t");
		a.save(null, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Global.console.log(p1);
			}
		});
		assertionId = a.shortId();
	}

	@After
	public void breakdown()
	{
		deleteById(frameworkId);
		deleteById(competencyId);
		deleteById(competencyId2);
		deleteById(assertionId);
		deleteById(r.shortId());
	}

	public static void deleteById(String id)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcRepository._delete(p1, null, new Callback1<String>()
				{
					@Override
					public void $invoke(String p1)
					{
						Global.console.log(p1);
					}
				});
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Global.console.log(p1);
			}
		});
	}

	@Test
	public void basicTest()
	{
		EvidenceProcessor ep = new EvidenceProcessor();
		ep.logFunction = new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				Global.console.log(p1);
			}
		};
		ep.repositories.push(repo);
		Array<EcPk> subject = new Array<>();
		subject.push(EcIdentityManager.ids.$get(0).ppk.toPk());
		
		EcCompetency competency = c;
		EcLevel level = null;
		EcFramework context = f;
		Array<EbacSignature> additionalSignatures = null;
		ep.has(subject, competency, level, context, additionalSignatures, new Callback1<InquiryPacket>()
		{
			@Override
			public void $invoke(InquiryPacket p1)
			{
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(p1.result, InquiryPacket.ResultType.TRUE);
			}
		}, new EcCallbackReturn1()
		{
			@Override
			public String callback(Object param1)
			{
				Global.console.log(param1);
				return null;
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				Global.console.log(p1);
				Assert.fail(p1);
			}
		});
	}

}
