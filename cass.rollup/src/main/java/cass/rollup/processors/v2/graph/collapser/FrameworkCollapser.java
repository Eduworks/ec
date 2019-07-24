package cass.rollup.processors.v2.graph.collapser;

import cass.rollup.processors.v3.graph.EcFrameworkGraph;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

import static cass.rollup.processors.util.EcGraphUtil.buildIdSearchQueryForIdList;

public class FrameworkCollapser {

	private EcRepository repo;
	private EcFramework framework;
	private boolean createImpliedRelations;
	private Array<EcCompetency> competencyArray;
	private Map<String, Node> competencyNodeMap;
	private Array<EcAlignment> relationArray;
	private NodeGraph frameworkNodeGraph;
	private NodePacketGraph collapsedFrameworkNodePacketGraph;
	private Callback2<String, NodePacketGraph> successCallback;
	private Callback1<String> failureCallback;

	private void addCompetenciesToFrameworkNodeGraph() {
		EcCompetency cmp;
		Node n;
		competencyNodeMap = JSCollections.$map();
		for (int i = 0; i < competencyArray.$length(); i++) {
			cmp = competencyArray.$get(i);
			n = new Node(cmp.shortId());
			n.setName(cmp.getName());
			n.setDescription(cmp.getDescription());
			frameworkNodeGraph.addNode(n);
			competencyNodeMap.$put(cmp.shortId(), n);
		}
	}

	private RelationType.RELATION_TYPE getRelationType(String rs) {
		if ("requires".equalsIgnoreCase(rs)) return RelationType.RELATION_TYPE.REQUIRES;
		else if ("narrows".equalsIgnoreCase(rs)) return RelationType.RELATION_TYPE.NARROWS;
		else if ("isEquivalentTo".equalsIgnoreCase(rs)) return RelationType.RELATION_TYPE.IS_EQUIVALENT_TO;
		else return null;
	}

	private void addRelationshipsToFrameworkNodeGraph() throws Exception {
		EcAlignment rel;
		RelationType.RELATION_TYPE type;
		Node sourceNode;
		Node targetNode;
		for (int i = 0; i < relationArray.$length(); i++) {
			rel = relationArray.$get(i);
			type = getRelationType(rel.relationType);
			if (type != null) {
				sourceNode = competencyNodeMap.$get(rel.source);
				targetNode = competencyNodeMap.$get(rel.target);
				if (sourceNode != null && targetNode != null) {
					frameworkNodeGraph.addRelation(sourceNode, targetNode, type);
				}
			}
		}
	}

	private void generateFrameworkNodeGraph() throws Exception {
		frameworkNodeGraph = new NodeGraph();
		addCompetenciesToFrameworkNodeGraph();
		addRelationshipsToFrameworkNodeGraph();
		if (createImpliedRelations) frameworkNodeGraph.createImpliedRelations();
	}

	private void collapseFrameworkNodeGraph() throws Exception {
		CyclicGraphCollapser cgc = new CyclicGraphCollapser();
		collapsedFrameworkNodePacketGraph = cgc.collapseGraph(frameworkNodeGraph);
	}

	private void continueFrameworkCollapse() {
		try {
			generateFrameworkNodeGraph();
			try {
				collapseFrameworkNodeGraph();
				successCallback.$invoke(framework.shortId(), collapsedFrameworkNodePacketGraph);
			} catch (Exception e2) {
				failureCallback.$invoke("Framework collapse failed: " + e2.toString());
			}
		} catch (Exception e) {
			failureCallback.$invoke("Framework node graph generation failed: " + e.toString());
		}
	}

	private void fetchFrameworkAlignments(final EcFramework framework) {
		final FrameworkCollapser me = this;
		EcAlignment.search(repo, buildIdSearchQueryForIdList(framework.relation),
				new Callback1<Array<EcAlignment>>() {
					@Override
					public void $invoke(Array<EcAlignment> ecaa) {
						me.relationArray = ecaa;
						me.continueFrameworkCollapse();
					}
				},
				me.failureCallback,
				null
		);
	}

	public void collapseFramework(EcRepository repo, EcFramework framework, boolean createImpliedRelations, final Callback2<String, NodePacketGraph> success, final Callback1<String> failure) {
		if (framework == null) failure.$invoke("Framework is null or undefined");
		else if (framework.competency == null || framework.competency.$length() < 1) failure.$invoke("Framework has no competencies");
		else if (repo == null) failure.$invoke("Repo is null or undefined");
		else {
			this.repo = repo;
			this.framework = framework;
			this.createImpliedRelations = createImpliedRelations;
			successCallback = success;
			failureCallback = failure;
			final FrameworkCollapser me = this;
			final EcFramework fwkParam = framework;
			EcCompetency.search(repo, buildIdSearchQueryForIdList(framework.competency),
					new Callback1<Array<EcCompetency>>() {
						@Override
						public void $invoke(Array<EcCompetency> ecca) {
							me.competencyArray = ecca;
							me.fetchFrameworkAlignments(fwkParam);
						}
					},
					me.failureCallback,
					null
			);
		}
	}

//	private Array<String> buildFrameworkUrlLookups() {
//		Array<String> urlArray = new Array<String>();
//		String cid;
//		String rid;
//		for (int i = 0; i < framework.competency.$length(); i++) {
//			cid = framework.competency.$get(i);
//			urlArray.push(cid);
//		}
//		if (framework.relation != null && framework.relation.$length() > 0) {
//			for (int i = 0; i < framework.relation.$length(); i++) {
//				rid = framework.relation.$get(i);
//				urlArray.push(rid);
//			}
//		}
//		return urlArray;
//	}

//	private void continueFrameworkCollapse(Array<EcRemoteLinkedData> rlda) {
//		parseCompetencies(rlda);
//		parseRelationships(rlda);
//		try {
//			generateFrameworkNodeGraph();
//			try {
//				collapseFrameworkNodeGraph();
//				successCallback.$invoke(framework.shortId(), collapsedFrameworkNodePacketGraph);
//			} catch (Exception e2) {
//				failureCallback.$invoke("Framework collapse failed: " + e2.toString());
//			}
//		} catch (Exception e) {
//			failureCallback.$invoke("Framework node graph generation failed: " + e.toString());
//		}
//	}

//	private void parseCompetencies(Array<EcRemoteLinkedData> rlda) {
//		competencyArray = new Array<EcCompetency>();
//		EcCompetency c;
//		for (int i = 0; i < rlda.$length(); i++) {
//			//if ("competency".equalsIgnoreCase(rlda.$get(i).type)) {
//			if (rlda.$get(i).isAny(new EcCompetency().getTypes())) {
//				c = new EcCompetency();
//				c.copyFrom(rlda.$get(i));
//				competencyArray.push(c);
//			}
//		}
//	}
//
//	private void parseRelationships(Array<EcRemoteLinkedData> rlda) {
//		relationArray = new Array<EcAlignment>();
//		EcAlignment r;
//		for (int i = 0; i < rlda.$length(); i++) {
//			//if ("relation".equalsIgnoreCase(rlda.$get(i).type)) {
//			if (rlda.$get(i).isAny(new EcAlignment().getTypes())) {
//				r = new EcAlignment();
//				r.copyFrom(rlda.$get(i));
//				relationArray.push(r);
//			}
//		}
//	}

//	public void collapseFramework(EcRepository repo, EcFramework framework, boolean createImpliedRelations, final Callback2<String, NodePacketGraph> success, final Callback1<String> failure) {
//		if (framework == null) failure.$invoke("Framework is null or undefined");
//		else if (framework.competency == null || framework.competency.$length() < 1)
//			failure.$invoke("Framework has no competencies");
//		else if (repo == null) failure.$invoke("Repo is null or undefined");
//		else {
//			this.framework = framework;
//			this.createImpliedRelations = createImpliedRelations;
//			successCallback = success;
//			failureCallback = failure;
//			final FrameworkCollapser fc = this;
//			repo.multiget(buildFrameworkUrlLookups(),
//					new Callback1<Array<EcRemoteLinkedData>>() {
//						@SuppressWarnings("unchecked")
//						@Override
//						public void $invoke(Array<EcRemoteLinkedData> rlda) {
//							fc.continueFrameworkCollapse(rlda);
//						}
//					},
//					fc.failureCallback
//			);
//		}
//	}
}
