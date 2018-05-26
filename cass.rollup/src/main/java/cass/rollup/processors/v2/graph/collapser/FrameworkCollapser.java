package cass.rollup.processors.v2.graph.collapser;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

public class FrameworkCollapser {

    private EcFramework framework;
    private boolean createImpliedRelations;
    private Array<EcCompetency> competencyArray;
    private Map<String, Node> competencyNodeMap;
    private Array<EcAlignment> relationArray;
    private NodeGraph frameworkNodeGraph;
    private NodePacketGraph collapsedFrameworkNodePacketGraph;
    private Callback2<String,NodePacketGraph> successCallback;
    private Callback1<String> failureCallback;

    private Array<String> buildFrameworkUrlLookups() {
        Array<String> urlArray = new Array<String>();
        String cid;
        String rid;
        for (int i=0;i<framework.competency.$length();i++) {
            cid = framework.competency.$get(i);
            urlArray.push(cid);
        }
        if (framework.relation != null && framework.relation.$length() > 0) {
            for (int i=0;i<framework.relation.$length();i++) {
                rid = framework.relation.$get(i);
                urlArray.push(rid);
            }
        }
        return urlArray;
    }

    private void parseCompetencies(Array<EcRemoteLinkedData> rlda) {
        competencyArray = new Array<EcCompetency>();
        EcRemoteLinkedData rld;
        for (int i=0;i<rlda.$length();i++) {
            rld = rlda.$get(i);
            if ("competency".equalsIgnoreCase(rld.type)) competencyArray.push((EcCompetency)rld);
        }
    }

    private void parseRelationships(Array<EcRemoteLinkedData> rlda) {
        relationArray = new Array<EcAlignment>();
        EcRemoteLinkedData rld;
        for (int i=0;i<rlda.$length();i++) {
            rld = rlda.$get(i);
            if ("relation".equalsIgnoreCase(rld.type)) relationArray.push((EcAlignment)rld);
        }
    }

    private void addCompetenciesToFrameworkNodeGraph() {
        EcCompetency cmp;
        Node n;
        competencyNodeMap = JSCollections.$map();
        for (int i=0;i<competencyArray.$length();i++) {
            cmp = competencyArray.$get(i);
            n = new Node(cmp.shortId());
            n.setName(cmp.name);
            n.setDescription(cmp.description);
            frameworkNodeGraph.addNode(n);
            competencyNodeMap.$put(cmp.shortId(),n);
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
        for (int i=0;i<relationArray.$length();i++) {
            rel = relationArray.$get(i);
            type = getRelationType(rel.relationType);
            if (type != null) {
                sourceNode = competencyNodeMap.$get(rel.source);
                targetNode = competencyNodeMap.$get(rel.target);
                if (sourceNode != null && targetNode != null) {
                    frameworkNodeGraph.addRelation(sourceNode,targetNode,type);
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

    private void continueFrameworkCollapse(Array<EcRemoteLinkedData> rlda) {
        parseCompetencies(rlda);
        parseRelationships(rlda);
        try {
            generateFrameworkNodeGraph();
            try {
                collapseFrameworkNodeGraph();
                successCallback.$invoke(framework.shortId(),collapsedFrameworkNodePacketGraph);
            }
            catch (Exception e2) {
                failureCallback.$invoke("Framework collapse failed: " + e2.toString());
            }
        }
        catch (Exception e) {
            failureCallback.$invoke("Framework node graph generation failed: " + e.toString());
        }
    }

    public void collapseFramework(EcRepository repo, EcFramework framework, boolean createImpliedRelations, final Callback2<String,NodePacketGraph> success, final Callback1<String> failure) {
        if (framework == null) failure.$invoke("Framework is null or undefined");
        else if (framework.competency == null || framework.competency.$length() < 1) failure.$invoke("Framework has no competencies");
        else if (repo == null) failure.$invoke("Repo is null or undefined");
        else {
            this.framework = framework;
            this.createImpliedRelations = createImpliedRelations;
            successCallback = success;
            failureCallback = failure;
            final FrameworkCollapser fc = this;
            repo.multiget(buildFrameworkUrlLookups(),
                    new Callback1<Array<EcRemoteLinkedData>>() {
                        @SuppressWarnings("unchecked")
                        @Override
                        public void $invoke(Array<EcRemoteLinkedData> rlda) {
                            fc.continueFrameworkCollapse(rlda);
                        }
                    },
                    fc.failureCallback,
                    new Callback1<Array<EcRemoteLinkedData>>() {
                        @SuppressWarnings("unchecked")
                        @Override
                        public void $invoke(Array<EcRemoteLinkedData> rlda) {
                            fc.continueFrameworkCollapse(rlda);
                        }
                    }
            );
        }
    }
}
