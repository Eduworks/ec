package cass.rollup;

import cass.rollup.processors.v3.graph.EcFrameworkGraph;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.profile.EcAssertion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback0;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"lib/require.js", "rollupInit.js", "/forge/forge.bundle.js","base64toArrayBuffer.js"})
public class GraphEvidenceProcessingTest extends EvidenceProcessingTestBase {
	@Test
	public void basicTrueTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(a.shortId());
	}

	@Test
	public void basicFalseTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newFalseAssertion(c);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(a.shortId());
	}

	@Test
	public void basicIndeterminantTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c);
		final EcAssertion a2 = newFalseAssertion(c);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				assertions.push(a2);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(a.shortId());
		deleteById(a2.shortId());
	}

	@Test
	public void basicUnknownTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");

		f.addCompetency(c.shortId());

		f.save(null, failure,repo);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(null,(Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion"));
						Assert.assertEquals(null,(Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion"));
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
	}

	@Test
	public void basicEquivalenceTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c2);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"positiveAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicEquivalenceFalseTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newFalseAssertion(c2);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"negativeAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicEquivalenceIndeterminantTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c);
		final EcAssertion a2 = newFalseAssertion(c2);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				assertions.push(a2);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"negativeAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(a2.shortId());
		deleteById(r.shortId());
	}

	public void basicEquivalenceUnknownTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(null,(Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion"));
						Assert.assertEquals(null,(Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion"));
						Assert.assertEquals(null,(Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"positiveAssertion"));
						Assert.assertEquals(null,(Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"negativeAssertion"));
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicEquivalenceEquivalenceTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");
		final EcCompetency c3 = newCompetency("Amass");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());
		f.addCompetency(c3.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		EcAlignment r2 = newRelation(c2, c3, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());
		f.addRelation(r2.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c3);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c3),"positiveAssertion")).$length());
					}
				},failure);
			}
		}, failure);

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

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");
		final EcCompetency c3 = newCompetency("Amass");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());
		f.addCompetency(c3.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.IS_EQUIVALENT_TO);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c3);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(null,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")));
						Assert.assertEquals(null,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"positiveAssertion")));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c3),"positiveAssertion")).$length());
					}
				},failure);
			}
		}, failure);

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

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.REQUIRES);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"positiveAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicRequiresFalseTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.REQUIRES);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newFalseAssertion(c2);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"negativeAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}
	@Test
	public void basicNarrowsTrueTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.NARROWS);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c2);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"positiveAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicNarrowsFalseTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.NARROWS);

		f.addRelation(r.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newFalseAssertion(c);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"negativeAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
	}

	@Test
	public void basicNarrowsNarrowsTrueTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");
		final EcCompetency c3 = newCompetency("Amass");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());
		f.addCompetency(c3.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.NARROWS);

		EcAlignment r2 = newRelation(c2, c3, EcAlignment.NARROWS);

		f.addRelation(r.shortId());
		f.addRelation(r2.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newAssertion(c3);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"positiveAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c3),"positiveAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(c3.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
		deleteById(r2.shortId());
	}

	@Test
	public void basicNarrowsNarrowsFalseTest() {
		EcFramework f = newFramework("Billy's Framework");

		final EcCompetency c = newCompetency("Add");
		final EcCompetency c2 = newCompetency("Sum");
		final EcCompetency c3 = newCompetency("Amass");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());
		f.addCompetency(c3.shortId());

		EcAlignment r = newRelation(c, c2, EcAlignment.NARROWS);

		EcAlignment r2 = newRelation(c2, c3, EcAlignment.NARROWS);

		f.addRelation(r.shortId());
		f.addRelation(r2.shortId());

		f.save(null, failure,repo);

		final EcAssertion a = newFalseAssertion(c);

		final EcFrameworkGraph fg = new EcFrameworkGraph();
		fg.addFramework(f, repo, new Callback0() {
			@Override
			public void $invoke() {
				Array<EcAssertion> assertions = new Array<>();
				assertions.push(a);
				fg.processAssertionsBoolean(assertions, new Callback0() {
					@Override
					public void $invoke() {
						Global.console.log(fg.getMetaStateCompetency(c));
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c),"negativeAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c2),"negativeAssertion")).$length());
						Assert.assertEquals(1,((Array)JSObjectAdapter.$get(fg.getMetaStateCompetency(c3),"negativeAssertion")).$length());
					}
				},failure);
			}
		}, failure);

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(c3.shortId());
		deleteById(a.shortId());
		deleteById(r.shortId());
		deleteById(r2.shortId());
	}

}
