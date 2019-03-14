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

public class EcFrameworkGraph extends EcDirectedGraph<EcCompetency, EcAlignment> {

	private Map<String, Object> metaVerticies;
	private Map<String, Object> metaEdges;

	public EcFrameworkGraph(){
		metaVerticies = (Map)new Object();
		metaEdges = (Map)new Object();
	}

	public void addFramework(final EcFramework framework, EcRepository repo, final Callback0 success, Callback1<String> failure) {
		final EcFrameworkGraph me = this;
		repo.multiget(framework.competency.concat(framework.relation), new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> data) {
				EcCompetency competencyTemplate = new EcCompetency();
				EcAlignment alignmentTemplate = new EcAlignment();
				for (int i = 0; i < data.$length(); i++) {
					EcRemoteLinkedData d = data.$get(i);
					if (d.isAny(competencyTemplate.getTypes())) {
						EcCompetency c = EcCompetency.getBlocking(d.id);
						me.addCompetency(c);
						me.addToMetaStateArray(me.getMetaStateCompetency(c),"framework",framework);
					}
					else if (d.isAny(alignmentTemplate.getTypes())) {
						EcAlignment alignment = EcAlignment.getBlocking(d.id);
						me.addRelation(alignment);
						me.addToMetaStateArray(me.getMetaStateAlignment(alignment),"framework",framework);
					}
				}
				success.$invoke();
			}
		}, failure);
	}

	public void processAssertionsBoolean(final Array<EcAssertion> assertions, final Callback0 success, final Callback1<String> failure) {
		final EcFrameworkGraph me = this;
		final EcAsyncHelper<EcAssertion> eah = new EcAsyncHelper<EcAssertion>();
		eah.each(assertions, new Callback2<EcAssertion, Callback0>() {
			@Override
			public void $invoke(final EcAssertion assertion, final Callback0 done) {
				final EcCompetency competency = EcCompetency.getBlocking(assertion.competency);
				if (!me.containsVertex(competency))
				{
					done.$invoke();
					return;
				}
				assertion.getNegativeAsync(new Callback1<Boolean>() {
					@Override
					public void $invoke(Boolean negative) {
						me.processAssertionsBooleanPerAssertion(assertion, negative, competency, done,new Array<EcCompetency>());
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
		if (EcArray.has(visited,competency)) {
			done.$invoke();
			return;
		}
		visited.push(competency);
		if (negative)
		{
			//Negative Traversal
			Object metaState = getMetaStateCompetency(competency);
			addToMetaStateArray(metaState,"negativeAssertion",assertion);
			new EcAsyncHelper<EcAlignment>().each(me.getOutEdges(competency), new Callback2<EcAlignment, Callback0>() {
				@Override
				public void $invoke(EcAlignment alignment, Callback0 callback0) {
					if (alignment.relationType == Relation.NARROWS)
						me.processAssertionsBooleanPerAssertion(assertion, negative, EcCompetency.getBlocking(alignment.target), callback0,visited);
					else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
						me.processAssertionsBooleanPerAssertion(assertion, negative, EcCompetency.getBlocking(alignment.target), callback0,visited);
					else
						callback0.$invoke();
				}
			}, new Callback1<Array<EcAlignment>>() {
				@Override
				public void $invoke(Array<EcAlignment> strings) {
					new EcAsyncHelper<EcAlignment>().each(me.getInEdges(competency), new Callback2<EcAlignment, Callback0>() {
						@Override
						public void $invoke(EcAlignment alignment, Callback0 callback0) {
							if (alignment.relationType == Relation.REQUIRES)
								me.processAssertionsBooleanPerAssertion(assertion, negative, EcCompetency.getBlocking(alignment.source), callback0,visited);
							else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
								me.processAssertionsBooleanPerAssertion(assertion, negative, EcCompetency.getBlocking(alignment.source), callback0,visited);
							else
								callback0.$invoke();
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
		else
		{
			//Positive Traversal
			Object metaState = getMetaStateCompetency(competency);
			addToMetaStateArray(metaState,"positiveAssertion",assertion);
			new EcAsyncHelper<EcAlignment>().each(me.getInEdges(competency), new Callback2<EcAlignment, Callback0>() {
				@Override
				public void $invoke(EcAlignment alignment, Callback0 callback0) {
					if (alignment.relationType == Relation.NARROWS)
						me.processAssertionsBooleanPerAssertion(assertion, negative, EcCompetency.getBlocking(alignment.source), callback0,visited);
					else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
						me.processAssertionsBooleanPerAssertion(assertion, negative, EcCompetency.getBlocking(alignment.source), callback0,visited);
					else
						callback0.$invoke();
				}
			}, new Callback1<Array<EcAlignment>>() {
				@Override
				public void $invoke(Array<EcAlignment> strings) {
					new EcAsyncHelper<EcAlignment>().each(me.getOutEdges(competency), new Callback2<EcAlignment, Callback0>() {
						@Override
						public void $invoke(EcAlignment alignment, Callback0 callback0) {
							if (alignment.relationType == Relation.REQUIRES)
								me.processAssertionsBooleanPerAssertion(assertion, negative, EcCompetency.getBlocking(alignment.target), callback0,visited);
							else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
								me.processAssertionsBooleanPerAssertion(assertion, negative, EcCompetency.getBlocking(alignment.target), callback0,visited);
							else
								callback0.$invoke();
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

	private void addToMetaStateArray(Object metaState, String key, Object value) {
		if (JSObjectAdapter.$get(metaState,key) == null)
			JSObjectAdapter.$put(metaState,key,new Array());
		((Array)JSObjectAdapter.$get(metaState,key)).push(value);
	}

	public Object getMetaStateCompetency(EcCompetency c) {
		if (containsVertex(c) == false) return null;
		if (metaVerticies.$get(c.shortId()) == null)
			metaVerticies.$put(c.shortId(), new Object());
		return metaVerticies.$get(c.shortId());
	}

	public Object getMetaStateAlignment(EcAlignment a) {
		if (containsEdge(a) == false) return null;
		if (metaEdges.$get(a.shortId()) == null)
			metaEdges.$put(a.shortId(), new Object());
		return metaEdges.$get(a.shortId());
	}

	private boolean addCompetency(EcCompetency competency) {
		return addVertex(competency);
	}

	private boolean addRelation(EcAlignment alignment) {
		return addEdge(alignment, EcCompetency.getBlocking(alignment.source), EcCompetency.getBlocking(alignment.target));
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