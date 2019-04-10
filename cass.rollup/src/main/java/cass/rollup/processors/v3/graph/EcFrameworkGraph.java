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
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

import static cass.rollup.processors.util.EcGraphUtil.buildIdSearchQueryForIdList;

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

	public EcFrameworkGraph(){
		metaVerticies = (Map)new Object();
		metaEdges = (Map)new Object();
		competencyMap = new Object();
		edgeMap = new Object();
		dontTryAnyMore = new Object();
		frameworks = new Array<EcFramework>();
	}

//	public EcCompetency generateCompetencyFromRemoteLinkedData(EcRemoteLinkedData rld) {
//		EcCompetency c = new EcCompetency();
//		c.copyFrom(rld);
//		return c;
//	}
//
//	public EcAlignment generateAlignmentFromRemoteLinkedData(EcRemoteLinkedData rld) {
//		EcAlignment a = new EcAlignment();
//		a.copyFrom(rld);
//		return a;
//	}

	//multiget is REALLY slowing this down...
	public void addFramework(final EcFramework framework, EcRepository repo, final Callback0 success, Callback1<String> failure) {
		frameworks.push(framework);
		final EcFrameworkGraph me = this;
		Global.console.log("addFramework about to multiget: " + Date.now());
		repo.multiget(framework.competency.concat(framework.relation), new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> data) {
				Global.console.log("Multiget complete: " + Date.now());
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

	private void fetchFrameworkAlignments(final EcFramework framework) {
		final EcFrameworkGraph me = this;
		EcAlignment.search(repo, buildIdSearchQueryForIdList(framework.relation),
				new Callback1<Array<EcAlignment>>() {
					@Override
					public void $invoke(Array<EcAlignment> ecaa) {
						for (int i = 0; i < ecaa.$length(); i++) {
							EcAlignment a = ecaa.$get(i);
							me.addRelation(a);
							me.addToMetaStateArray(me.getMetaStateAlignment(a),"framework",framework);
						}
						me.addFrameworkSuccessCallback.$invoke();
					}
				},
				me.addFrameworkFailureCallback,
				null
		);
	}

//	public void addFramework(final EcFramework framework, EcRepository repo, final Callback0 success, Callback1<String> failure) {
//		addFrameworkSuccessCallback = success;
//		addFrameworkFailureCallback = failure;
//		frameworks.push(framework);
//		this.repo = repo;
//		final EcFrameworkGraph me = this;
//		EcCompetency.search(repo, buildIdSearchQueryForIdList(framework.competency),
//				new Callback1<Array<EcCompetency>>() {
//					@Override
//					public void $invoke(Array<EcCompetency> ecca) {
//						for (int i = 0; i < ecca.$length(); i++) {
//							EcCompetency c = ecca.$get(i);
//							me.addCompetency(c);
//							me.addToMetaStateArray(me.getMetaStateCompetency(c),"framework",framework);
//						}
//						me.fetchFrameworkAlignments(framework);
//					}
//				},
//				me.addFrameworkFailureCallback,
//				null
//		);
//	}

	public void processAssertionsBoolean(final Array<EcAssertion> assertions, final Callback0 success, final Callback1<String> failure) {
		final EcFrameworkGraph me = this;
		final EcAsyncHelper<EcAssertion> eah = new EcAsyncHelper<EcAssertion>();
		eah.each(assertions, new Callback2<EcAssertion, Callback0>() {
			@Override
			public void $invoke(final EcAssertion assertion, final Callback0 done) {
				//final EcCompetency competency = EcCompetency.getBlocking(assertion.competency);
				final EcCompetency competency = me.getCompetency(assertion.competency);
				if (competency == null || !me.containsVertex(competency))
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
					EcCompetency c = me.getCompetency(alignment.target);
					if (alignment.relationType == Relation.NARROWS)
						me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0,visited);
					else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
						me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0,visited);
					else
						callback0.$invoke();
				}
			}, new Callback1<Array<EcAlignment>>() {
				@Override
				public void $invoke(Array<EcAlignment> strings) {
					new EcAsyncHelper<EcAlignment>().each(me.getInEdges(competency), new Callback2<EcAlignment, Callback0>() {
						@Override
						public void $invoke(EcAlignment alignment, Callback0 callback0) {
							EcCompetency c = me.getCompetency(alignment.source);
							if (alignment.relationType == Relation.REQUIRES)
								me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0,visited);
							else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
								me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0,visited);
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
					EcCompetency c = me.getCompetency(alignment.source);
					if (alignment.relationType == Relation.NARROWS)
						me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0,visited);
					else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
						me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0,visited);
					else
						callback0.$invoke();
				}
			}, new Callback1<Array<EcAlignment>>() {
				@Override
				public void $invoke(Array<EcAlignment> strings) {
					new EcAsyncHelper<EcAlignment>().each(me.getOutEdges(competency), new Callback2<EcAlignment, Callback0>() {
						@Override
						public void $invoke(EcAlignment alignment, Callback0 callback0) {
							EcCompetency c = me.getCompetency(alignment.target);
							if (alignment.relationType == Relation.REQUIRES)
								me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0,visited);
							else if (alignment.relationType == Relation.IS_EQUIVALENT_TO)
								me.processAssertionsBooleanPerAssertion(assertion, negative, c, callback0,visited);
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
		if (metaState == null) return;
		if (JSObjectAdapter.$get(metaState,key) == null)
			JSObjectAdapter.$put(metaState,key,new Array());
		((Array)JSObjectAdapter.$get(metaState,key)).push(value);
	}

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
	public boolean containsVertex(EcCompetency competency){
		return JSObjectAdapter.$get(competencyMap,competency.shortId()) != null;
	}

	@Override
	public boolean containsEdge(EcAlignment competency){
		return JSObjectAdapter.$get(edgeMap,competency.shortId()) != null;
	}

	private EcCompetency getCompetency(String competencyId) {
		EcCompetency c = null;
		c = (EcCompetency)JSObjectAdapter.$get(competencyMap,competencyId);
		if (c == null) c = EcCompetency.getBlocking(competencyId);
		return c;
	}

	private boolean addCompetency(EcCompetency competency) {
		if (competency == null) return false;
		if (containsVertex(competency)) return false;
		JSObjectAdapter.$put(competencyMap,competency.shortId(),competency);
		JSObjectAdapter.$put(competencyMap,competency.id,competency);
		return addVertex(competency);
	}

	private boolean addRelation(EcAlignment alignment) {
		if (alignment == null) return false;
		if (containsEdge(alignment)) return false;

		EcCompetency source = (EcCompetency) JSObjectAdapter.$get(competencyMap,alignment.source);
		if (source == null && JSObjectAdapter.$get(dontTryAnyMore,alignment.source) != null)
			return false;
		//if (source == null) source = EcCompetency.getBlocking(alignment.source);
		if (source == null) source = getCompetency(alignment.source);
		if (source == null) JSObjectAdapter.$put(dontTryAnyMore,alignment.source,"");

		EcCompetency target = (EcCompetency) JSObjectAdapter.$get(competencyMap,alignment.target);
		if (target == null && JSObjectAdapter.$get(dontTryAnyMore,alignment.target) != null)
			return false;
		//if (target == null) target = EcCompetency.getBlocking(alignment.target);
		if (target == null) target = getCompetency(alignment.target);
		if (target == null) JSObjectAdapter.$put(dontTryAnyMore,alignment.target,"");
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