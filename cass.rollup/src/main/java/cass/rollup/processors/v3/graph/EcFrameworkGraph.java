package cass.rollup.processors.v3.graph;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.graph.EcDirectedGraph;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Relation;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

import static cass.rollup.processors.util.EcGraphUtil.buildIdSearchQueryForIdList;

/**
 * Graph for working with a framework. Additional computed data (such as profile data) can be overlaid on the graph through the use of "metaverticies" and "metaedges" that hold additional information.
 *
 * @author fritz.ray@eduworks.com
 * @author tom.buskirk@eduworks.com
 * @class EcFrameworkGraph
 */
public class EcFrameworkGraph extends EcDirectedGraph<EcCompetency, EcAlignment> {

    private Map<String, Object> metaVerticies;
    private Map<String, Object> metaEdges;
    Object competencyMap = null;
    Object edgeMap = null;
    Object dontTryAnyMore = null;
    Array<EcFramework> frameworks = null;

    private Callback0 addFrameworkSuccessCallback;
    private Callback1<String> addFrameworkFailureCallback;
    private EcRepository repo;

	public EcFrameworkGraph() {
		metaVerticies = (Map) new Object();
		metaEdges = (Map) new Object();
		competencyMap = new Object();
		edgeMap = new Object();
		dontTryAnyMore = new Object();
		frameworks = new Array<EcFramework>();
	}

	/**
	 * Adds a framework to the graph, and creates the edges to connect the competencies in the framework.
	 *
	 * @param {EcFramework}     framework Framework to add to the graph.
	 * @param {EcRepository}    repo Repository to fetch data from that exists in the framework.
	 * @param {function()}      success Method to invoke when done adding the framework.
	 * @param {function(error)} failure Method to invoke when things go badly.
	 * @method addFramework
	 * @memberOf EcFrameworkGraph
	 */
	public void addFramework(final EcFramework framework, EcRepository repo, final Callback0 success, Callback1<String> failure) {
		frameworks.push(framework);
		final EcFrameworkGraph me = this;
		Array<String> precache = new Array();
		if (framework.competency != null) {
			precache.concat(framework.competency);
		}
		if (framework.relation != null) {
			precache.concat(framework.relation);
		}
		repo.multiget(precache, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> data) {
				final EcCompetency competencyTemplate = new EcCompetency();
				final EcAlignment alignmentTemplate = new EcAlignment();
				EcAsyncHelper<EcRemoteLinkedData> eah = new EcAsyncHelper();
				eah.each(data, new Callback2<EcRemoteLinkedData, Callback0>() {
					@Override
					public void $invoke(EcRemoteLinkedData d, final Callback0 callback0) {
						if (d.isAny(competencyTemplate.getTypes())) {
							EcCompetency.get(d.id, new Callback1<EcCompetency>() {
								@Override
								public void $invoke(EcCompetency c) {
									me.addToMetaStateArray(me.getMetaStateCompetency(c), "framework", framework);
									me.addCompetency(c);
									callback0.$invoke();
								}
							}, (Callback1) callback0);
						} else if (d.isAny(alignmentTemplate.getTypes())) {
							EcAlignment.get(d.id, new Callback1<EcAlignment>() {
								@Override
								public void $invoke(EcAlignment alignment) {
									me.addRelation(alignment);
									me.addToMetaStateArray(me.getMetaStateAlignment(alignment), "framework", framework);
									callback0.$invoke();
								}
							}, (Callback1) callback0);
						} else
							callback0.$invoke();
					}
				}, new Callback1<Array<EcRemoteLinkedData>>() {
					@Override
					public void $invoke(Array<EcRemoteLinkedData> strings) {
						success.$invoke();
					}
				});
			}
		}, failure);
	}

	private void fetchFrameworkAlignments(final EcFramework framework) {
		final EcFrameworkGraph me = this;
		EcAlignment.search(repo, buildIdSearchQueryForIdList(framework.relation),
				new Callback1<Array<EcAlignment>>() {
					@Override
					public void $invoke(Array<EcAlignment> ecaa) {
						for (int i = 0; i < ecaa.$length(); i++) {
							EcAlignment a = ecaa.$get(i);
							me.addRelation(a);
							me.addToMetaStateArray(me.getMetaStateAlignment(a), "framework", framework);
						}
						me.addFrameworkSuccessCallback.$invoke();
					}
				},
				me.addFrameworkFailureCallback,
				null
		);
	}

	/**
	 * Helper method to populate the graph with assertion data, based on propagation rules implicit in the relations (see devs.cassproject.org, Relations). Does not draw conclusions. Must be able to decrypt 'negative' value.
	 *
	 * @param {Assertion[]}     assertions Assertion candidates to use to populate the graph.
	 * @param {function()}      success Method to invoke when the operation completes successfully.
	 * @param {function(error)} failure Error method.
	 */
	public void processAssertionsBoolean(final Array<EcAssertion> assertions, final Callback0 success, final Callback1<String> failure) {
		final EcFrameworkGraph me = this;
		final EcAsyncHelper<EcAssertion> eah = new EcAsyncHelper<EcAssertion>();
		eah.each(assertions, new Callback2<EcAssertion, Callback0>() {
			@Override
			public void $invoke(final EcAssertion assertion, final Callback0 done) {
				final EcCompetency competency = me.getCompetency(assertion.competency);
				if (competency == null || !me.containsVertex(competency)) {
					done.$invoke();
					return;
				}
				assertion.getNegativeAsync(new Callback1<Boolean>() {
					@Override
					public void $invoke(Boolean negative) {
						me.processAssertionsBooleanPerAssertion(assertion, negative, competency, done, new Array<EcCompetency>());
					}
				}, eah.failWithCallback(failure, done));
			}
		}, new Callback1<Array<EcAssertion>>() {
			@Override
			public void $invoke(Array<EcAssertion> strings) {
				success.$invoke();
			}
		});
	}

	private void processAssertionsBooleanPerAssertion(final EcAssertion assertion, final Boolean negative, final EcCompetency competency, final Callback0 done, final Array<EcCompetency> visited) {
		final EcFrameworkGraph me = this;
		if (EcArray.has(visited, competency)) {
			done.$invoke();
			return;
		}
		visited.push(competency);
		if (negative) {
			//Negative Traversal
			Object metaState = getMetaStateCompetency(competency);
			addToMetaStateArray(metaState, "negativeAssertion", assertion);
			new EcAsyncHelper<EcAlignment>().each(me.getOutEdges(competency), new Callback2<EcAlignment, Callback0>() {
				@Override
				public void $invoke(EcAlignment alignment, Callback0 callback0) {
					EcCompetency c = me.getCompetency(alignment.target);
					me.processAssertionBooleanOutward(alignment, callback0, c, me, assertion, negative, visited);
				}
			}, new Callback1<Array<EcAlignment>>() {
				@Override
				public void $invoke(Array<EcAlignment> strings) {
					new EcAsyncHelper<EcAlignment>().each(me.getInEdges(competency), new Callback2<EcAlignment, Callback0>() {
						@Override
						public void $invoke(EcAlignment alignment, Callback0 callback0) {
							EcCompetency c = me.getCompetency(alignment.source);
							me.processAssertionBooleanInward(alignment, callback0, c, me, assertion, negative, visited);
						}
					}, new Callback1<Array<EcAlignment>>() {
						@Override
						public void $invoke(Array<EcAlignment> strings) {
							done.$invoke();
						}
					});
				}
			});
		} else {
			//Positive Traversal
			Object metaState = getMetaStateCompetency(competency);
			addToMetaStateArray(metaState, "positiveAssertion", assertion);
			new EcAsyncHelper<EcAlignment>().each(me.getInEdges(competency), new Callback2<EcAlignment, Callback0>() {
				@Override
				public void $invoke(EcAlignment alignment, Callback0 callback0) {
					EcCompetency c = me.getCompetency(alignment.source);
					me.processAssertionBooleanOutward(alignment, callback0, c, me, assertion, negative, visited);
				}
			}, new Callback1<Array<EcAlignment>>() {
				@Override
				public void $invoke(Array<EcAlignment> strings) {
					new EcAsyncHelper<EcAlignment>().each(me.getOutEdges(competency), new Callback2<EcAlignment, Callback0>() {
						@Override
						public void $invoke(EcAlignment alignment, Callback0 callback0) {
							EcCompetency c = me.getCompetency(alignment.target);
							me.processAssertionBooleanInward(alignment, callback0, c, me, assertion, negative, visited);
						}
					}, new Callback1<Array<EcAlignment>>() {
						@Override
						public void $invoke(Array<EcAlignment> strings) {
							done.$invoke();
						}
					});
				}
			});
		}
	}

	private void processAssertionBooleanOutward(EcAlignment alignment, Callback0 callback0, EcCompetency c, EcFrameworkGraph me, EcAssertion assertion, Boolean negative, Array<EcCompetency> visited) {
		if (alignment.relationType == Relation.NARROWS)
			me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0, visited);
		else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
			me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0, visited);
		else
			callback0.$invoke();
	}

	private void processAssertionBooleanInward(EcAlignment alignment, Callback0 callback0, EcCompetency c, EcFrameworkGraph me, EcAssertion assertion, Boolean negative, Array<EcCompetency> visited) {
		if (alignment.relationType == Relation.REQUIRES)
			me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0, visited);
		else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
			me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0, visited);
		else
			callback0.$invoke();
	}

	private void addToMetaStateArray(Object metaState, String key, Object value) {
		if (metaState == null) return;
		if (JSObjectAdapter.$get(metaState, key) == null)
			JSObjectAdapter.$put(metaState, key, new Array());
		((Array) JSObjectAdapter.$get(metaState, key)).push(value);
	}

	/**
	 * Fetches the Meta Competency (additional state information used to compute profiles or other data) for a competency.
	 *
	 * @param {EcCompetency} c Competency to fetch meta state for.
	 * @return Meta state (empty object by default)
	 * @method getMetaStateCompetency
	 * @memberOf EcFrameworkGraph
	 */
	public Object getMetaStateCompetency(EcCompetency c) {
		Object result = metaVerticies.$get(c.shortId());
		if (result == null) {
			if (containsVertex(c) == false) return null;
			if (metaVerticies.$get(c.shortId()) == null)
				metaVerticies.$put(c.shortId(), result = new Object());
		}
		return result;
	}

    public Object getMetaStateAlignment(EcAlignment a) {
        Object result = metaEdges.$get(a.shortId());
        if (result == null) {
            if (containsEdge(a) == false) return null;
            if (metaEdges.$get(a.shortId()) == null)
                metaEdges.$put(a.shortId(), result = new Object());
        }
        return result;
    }

	@Override
	public boolean containsVertex(EcCompetency competency) {
		return JSObjectAdapter.$get(competencyMap, competency.shortId()) != null;
	}

	@Override
	public boolean containsEdge(EcAlignment competency) {
		return JSObjectAdapter.$get(edgeMap, competency.shortId()) != null;
	}

	private EcCompetency getCompetency(String competencyId) {
		EcCompetency c = null;
		c = (EcCompetency) JSObjectAdapter.$get(competencyMap, competencyId);
		if (c == null) c = EcCompetency.getBlocking(competencyId);
		return c;
	}

	private boolean addCompetency(EcCompetency competency) {
		if (competency == null) return false;
		if (containsVertex(competency)) return false;
		JSObjectAdapter.$put(competencyMap, competency.shortId(), competency);
		JSObjectAdapter.$put(competencyMap, competency.id, competency);
		return addVertex(competency);
	}

    private boolean addRelation(EcAlignment alignment) {
        if (alignment == null) return false;
        if (containsEdge(alignment)) return false;

		EcCompetency source = (EcCompetency) JSObjectAdapter.$get(competencyMap, alignment.source);
		if (source == null && JSObjectAdapter.$get(dontTryAnyMore, alignment.source) != null)
			return false;
		//if (source == null) source = EcCompetency.getBlocking(alignment.source);
		if (source == null) source = getCompetency(alignment.source);
		if (source == null) JSObjectAdapter.$put(dontTryAnyMore, alignment.source, "");

		EcCompetency target = (EcCompetency) JSObjectAdapter.$get(competencyMap, alignment.target);
		if (target == null && JSObjectAdapter.$get(dontTryAnyMore, alignment.target) != null)
			return false;
		//if (target == null) target = EcCompetency.getBlocking(alignment.target);
		if (target == null) target = getCompetency(alignment.target);
		if (target == null) JSObjectAdapter.$put(dontTryAnyMore, alignment.target, "");
		if (source == null || target == null) return false;

        return addEdgeUnsafely(alignment, source, target);
    }

    @Override
    public boolean addHyperEdge(EcAlignment edge, Array<? extends EcCompetency> vertices) {
        throw new RuntimeException("Don't do this.");
    }

    @Override
    public String getEdgeType(EcAlignment edge) {
        return edge.relationType;
    }

    @Override
    public String getDefaultEdgeType() {
        return EcAlignment.NARROWS;
    }
}