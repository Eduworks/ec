package cass.rollup;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.profile.EcAssertion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"lib/require.js", "rollupInit.js", "/forge/forge.bundle.js","base64toArrayBuffer.js"})
public class EvidenceProcessingTest extends EvidenceProcessingTestBase {
	@Test
	public void basicTrueTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.TRUE, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(a.shortId());
	}

	@Test
	public void basicFalseTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newFalseAssertion(c);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.FALSE, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(a.shortId());
	}

	@Test
	public void basicIndeterminantTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c);
		EcAssertion a2 = newFalseAssertion(c);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.INDETERMINANT, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(a.shortId());
		deleteById(a2.shortId());
	}

	@Test
	public void basicUnknownTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.UNKNOWN, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
	}

	@Test
	public void basicEquivalenceTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c2);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.TRUE, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicEquivalenceFalseTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newFalseAssertion(c2);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.FALSE, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicEquivalenceIndeterminantTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c);
		EcAssertion a2 = newFalseAssertion(c2);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.INDETERMINANT, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(a2.shortId());
		deleteById(r.shortId());
	}

	public void basicEquivalenceUnknownTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.INDETERMINANT, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicEquivalenceEquivalenceTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Sum");
		EcCompetency c3 = newCompetency("Amass");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());
		f.addCompetency(c3.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		EcAlignment r2 = newRelation(c2, c3, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());
		f.addRelation(r2.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c3);

		performTest(f, c, new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.TRUE, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(c3.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
		deleteById(r2.shortId());
	}

	@Test
	public void basicEquivalenceUnEquivalentTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Sum");
		EcCompetency c3 = newCompetency("Amass");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());
		f.addCompetency(c3.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c3);

		Callback1<InquiryPacket> isTest = new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.UNKNOWN, p1.result);
			}
		};

		performTest(f, c, isTest);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(c3.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicRequiresSatisfiedTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.REQUIRES);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c2);

		Callback1<InquiryPacket> isTest = new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.UNKNOWN, p1.result);
			}
		};

		performTest(f, c, isTest);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicNarrowsSatisfiedTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Multiply");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.NARROWS);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c2);

		Callback1<InquiryPacket> isTest = new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.TRUE, p1.result);
			}
		};

		performTest(f, c, isTest);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicNarrowsUnsatisfiedTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Multiply");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.NARROWS);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c);

		Callback1<InquiryPacket> isTest = new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.UNKNOWN, p1.result);
			}
		};

		performTest(f, c2, isTest);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicNarrowsPositiveNegativeTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Multiply");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.NARROWS);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newAssertion(c);
		EcAssertion a2 = newFalseAssertion(c);

		Callback1<InquiryPacket> isTest = new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.FALSE, p1.result);
			}
		};

		performTest(f, c2, isTest);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicRequiresFalseTest() {
		EcFramework f = newFramework("Billy's Framework");

		EcCompetency c = newCompetency("Add");
		EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.REQUIRES);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		EcAssertion a = newFalseAssertion(c2);

		Callback1<InquiryPacket> isTest = new Callback1<InquiryPacket>() {
			@Override
			public void $invoke(InquiryPacket p1) {
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.FALSE, p1.result);
			}
		};

		performTest(f, c, isTest);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}
}
