package com.eduworks.rollup.coprocessor;

import cass.rollup.InquiryPacket;
import cass.rollup.processors.PessimisticQuadnaryAssertionProcessor;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.schema.ebac.EbacSignature;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.credentialengine.Credential;
import org.junit.Assert;
import org.junit.Before;
import org.schema.*;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function1;
import org.stjs.testing.annotation.ScriptsBefore;

@ScriptsBefore({"lib/require.js", "rollupInit.js", "/forge/forge.bundle.js"})
public class EvidenceProcessingTestBase {

	public Function1<String, String> ask;
	protected EcRepository repo;
	protected Callback1<String> failure;
	protected Callback1<Object> logObject;
	EcIdentity newId1;

	public static void deleteById(String id) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcRepository._delete(p1, null, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						Global.console.log(p1);
					}
				});
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log(p1);
			}
		});
	}

	@Before
	public void setup() {
		EcRemote.async = false;
		failure = new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Global.console.log(p1);
				Assert.fail();
			}
		};
		logObject = new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				Global.console.log(p1);
			}
		};
		ask = new Function1<String, String>() {
			@Override
			public String $invoke(String param1) {
				Global.console.log(param1);
				return null;
			}
		};

		repo = new EcRepository();
		repo.selectedServer = "https://dev.cassproject.org/api";

		newId1 = new EcIdentity();
		newId1.ppk = EcPpk.fromPem(
				"-----BEGIN RSA PRIVATE KEY-----MIIEpAIBAAKCAQEAz4BiFucFE9bNcKfGD+e6aPRHl402YM4Z6nrurDRNlnwsWpsCoZasPLkjC314pVtHAI2duZo+esGKDloBsiLxASRJo3R2XiXVh2Y8U1RcHA5mWL4tMG5UY2d0libpNEHbHPNBmooVYpA2yhxN/vGibIk8x69uZWxJcFOxOg6zWG8EjF8UMgGnRCVSMTY3THhTlfZ0cGUzvrfb7OvHUgdCe285XkmYkj/V9P/m7hbWoOyJAJSTOm4/s6fIKpl72lblfN7bKaxTCsJp6/rQdmUeo+PIaa2lDOfo7dWbuTMcqkZ93kispNfYYhsEGUGlCsrrVWhlve8MenO4GdLsFP+HRwIDAQABAoIBAGaQpOuBIYde44lNxJ7UAdYi+Mg2aqyK81Btl0/TQo6hriLTAAfzPAt/z4y8ZkgFyCDD3zSAw2VWCPFzF+d/UfUohKWgyWlb9iHJLQRbbHQJwhkXV6raviesWXpmnVrROocizkie/FcNxac9OmhL8+cGJt7lHgJP9jTpiW6TGZ8ZzM8KBH2l80x9AWdvCjsICuPIZRjc706HtkKZzTROtq6Z/F4Gm0uWRnwAZrHTRpnh8qjtdBLYFrdDcUoFtzOM6UVRmocTfsNe4ntPpvwY2aGTWY7EmTj1kteMJ+fCQFIS+KjyMWQHsN8yQNfD5/j2uv6/BdSkO8uorGSJT6DwmTECgYEA8ydoQ4i58+A1udqA+fujM0Zn46++NTehFe75nqIt8rfQgoduBam3lE5IWj2U2tLQeWxQyr1ZJkLbITtrAI3PgfMnuFAii+cncwFo805Fss/nbKx8K49vBuCEAq3MRhLjWy3ZvIgUHj67jWvl50dbNqc7TUguxhS4BxGr/cPPkP0CgYEA2nbJPGzSKhHTETL37NWIUAdU9q/6NVRISRRXeRqZYwE1VPzs2sIUxA8zEDBHX7OtvCKzvZy1Lg5Unx1nh4nCEVkbW/8npLlRG2jOcZJF6NRfhzwLz3WMIrP6j9SmjJaB+1mnrTjfsg36tDEPDjjJLjJHCx9z/qRJh1v4bh4aPpMCgYACG31T2IOEEZVlnvcvM3ceoqWT25oSbAEBZ6jSLyWmzOEJwJK7idUFfAg0gAQiQWF9K+snVqzHIB02FIXA43nA7pKRjmA+RiqZXJHEShFgk1y2HGiXGA8mSBvcyhTTJqbBy4vvjl5eRLzrZNwBPSUVPC3PZajCHrvZk9WhxWivIQKBgQCzCu1MH2dy4R7ZlqsIJ8zKweeJMZpfQI7pjclO0FTrhh7+Yzd+5db9A/P2jYrBTVHSwaILgTYf49DIguHJfEZXz26TzB7iapqlWxTukVHISt1ryPNo+E58VoLAhChnSiaHJ+g7GESE+d4A9cAACNwgh0YgQIvhIyW70M1e+j7KDwKBgQDQSBLFDFmvvTP3sIRAr1+0OZWd1eRcwdhs0U9GwootoCoUP/1Y64pqukT6B9oIB/No9Nyn8kUX3/ZDtCslaGKEUGMJXQ4hc5J+lq0tSi9ZWBdhqOuMPEfUF3IxW+9yeILP4ppUBn1m5MVOWg5CvuuEeCmy4bhMaUErUlHZ78t5cA==-----END RSA PRIVATE KEY-----");
		;
		EcIdentityManager.ids = new Array<EcIdentity>();
		EcIdentityManager.addIdentity(newId1);

	}

	protected EcAssertion newAssertion(EcCompetency competencyToAssert) {
		EcAssertion a = new EcAssertion();
		a.generateId(repo.selectedServer);
		a.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setSubject(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setAgent(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setCompetency(competencyToAssert.shortId());
		a.setConfidence(1.0);
		a.setAssertionDate((long) new Date().getTime());
		a.setExpirationDate((long) (new Date().getTime()) + 1000 * 60 * 60);
		a.setDecayFunction("t");
		a.save(null, failure,repo);
		return a;
	}

	protected EcAssertion newFalseAssertion(EcCompetency competencyToAssert) {
		EcAssertion a = new EcAssertion();
		a.generateId(repo.selectedServer);
		a.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setSubject(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setAgent(EcIdentityManager.ids.$get(0).ppk.toPk());
		a.setCompetency(competencyToAssert.shortId());
		a.setConfidence(1.0);
		a.setNegative(true);
		a.setAssertionDate((long) new Date().getTime());
		a.setExpirationDate((long) (new Date().getTime()) + 1000 * 60 * 60);
		a.setDecayFunction("t");
		a.save(null, failure,repo);
		return a;
	}

	protected EcCompetency newCompetency(String competencyName) {
		EcCompetency competency = new EcCompetency();
		competency.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		competency.name = competencyName;
		competency.generateId(repo.selectedServer);

		competency.save(null, failure,repo);
		return competency;
	}

	protected Credential newCredential(String credentialName) {
		Credential credential = new Credential();
		credential.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		credential.name = credentialName;
		credential.generateId(repo.selectedServer);

		repo.saveTo(credential, null, failure);
		return credential;
	}

	protected AchieveAction newAchieveAction(Credential credential) {
		AchieveAction action = new AchieveAction();
		action.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		action.object = (Thing) (Object) credential.shortId();
		action.agent = (Person) (Object) EcIdentityManager.ids.$get(0).ppk.toPk().toPem();
		action.generateId(repo.selectedServer);
		repo.save(action, null, failure);
		return action;
	}

	protected EcAlignment newRelation(EcCompetency c, EcCompetency c2, String relationType) {
		EcAlignment r = new EcAlignment();
		r.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		r.generateId(repo.selectedServer);
		r.relationType = relationType;
		r.source = c.shortId();
		r.target = c2.shortId();
		r.save(null, failure,repo);

		return r;
	}

	protected CreativeWork newCreativeRelation(Thing c, Thing c2, String alignmentType) {
		CreativeWork r = new CreativeWork();
		r.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		r.generateId(repo.selectedServer);
		r.educationalAlignment = new AlignmentObject();
		r.url = c.shortId();
		r.educationalAlignment.targetUrl = c2.shortId();
		r.educationalAlignment.alignmentType = alignmentType;
		repo.save(r, null, failure);

		return r;
	}

	protected void performTest(PessimisticQuadnaryAssertionProcessor ep, EcFramework context, EcCompetency target, Callback1<InquiryPacket> isTest) {
		Array<EcPk> subject = new Array<>();
		subject.push(EcIdentityManager.ids.$get(0).ppk.toPk());

		Array<EbacSignature> additionalSignatures = null;

		ep.has(subject, target, null, context, additionalSignatures, isTest, ask, failure);
	}

	public PessimisticQuadnaryAssertionProcessor getTestProcessor() {
		PessimisticQuadnaryAssertionProcessor ep = new PessimisticQuadnaryAssertionProcessor();
		ep.logFunction = logObject;
		ep.repositories.push(repo);
		return ep;
	}

	protected EcFramework newFramework(String frameworkName) {
		EcFramework framework = new EcFramework();
		framework.name = frameworkName;
		framework.addOwner(EcIdentityManager.ids.$get(0).ppk.toPk());
		framework.generateId(repo.selectedServer);

		framework.save(null, failure,repo);
		return framework;
	}

}
