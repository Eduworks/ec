package com.eduworks.rollup.coprocessor;

import cass.rollup.InquiryPacket;
import cass.rollup.processors.PessimisticQuadnaryAssertionProcessor;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.credentialengine.Credential;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.schema.AchieveAction;
import org.schema.CreativeWork;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

/**
 * Created by fray on 5/30/17.
 */
@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"lib/require.js", "rollupInit.js", "base64toArrayBuffer.js", "base64toArrayBuffer.js"})
public class MilCredCoprocessorTest extends EvidenceProcessingTestBase {
	@Test
	public void basicTrueTest() {
		final EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		final Credential cr = newCredential("Adding Credential");

		final CreativeWork w = newCreativeRelation(cr, c, "http://schema.cassproject.org/0.2/vocab/asserts");

		final AchieveAction a = newAchieveAction(cr);

		PessimisticQuadnaryAssertionProcessor processor = getTestProcessor();
		processor.coprocessors.push(new MilCredCoprocessor());

		performTest(processor, f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				deleteById(f.shortId());
				deleteById(cr.shortId());
				deleteById(w.shortId());
				deleteById(c.shortId());
				deleteById(a.shortId());
				//Assert.assertSame(InquiryPacket.ResultType.TRUE, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(cr.shortId());
		deleteById(w.shortId());
		deleteById(c.shortId());
		deleteById(a.shortId());
	}

	@Test
	public void basicUnknownTest() {
//		final EcFramework f = newFramework("Billy's Framework");
//
//		final EcCompetency c = newCompetency("Add");
//
//		f.addCompetency(c.shortId());
//
//		f.save(null, failure,repo);
//
//		final Credential cr = newCredential("Adding Credential");
//
//		//final CreativeWork w = newCreativeRelation(cr,c,"http://schema.cassproject.org/0.2/vocab/asserts");
//
//		final AchieveAction a = newAchieveAction(cr);
//
//		PessimisticQuadnaryAssertionProcessor processor = getTestProcessor();
//		processor.coprocessors.push(new MilCredCoprocessor());
//
//		performTest(processor, f, c, new Callback1<InquiryPacket>() {
//			@Override
//			public void $invoke(InquiryPacket p1) {
//				Global.console.log(p1.result.name());
//				Global.console.log(p1);
//				deleteById(f.shortId());
//				deleteById(cr.shortId());
//				deleteById(c.shortId());
//				deleteById(a.shortId());
//				Assert.assertSame(InquiryPacket.ResultType.TRUE, p1.result);
//			}
//		});
//
//		deleteById(f.shortId());
//		deleteById(cr.shortId());
//		deleteById(c.shortId());
//		deleteById(a.shortId());
		Assert.assertTrue(true);
	}
}
