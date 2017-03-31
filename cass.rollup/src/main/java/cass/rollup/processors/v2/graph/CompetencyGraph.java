package cass.rollup.processors.v2.graph;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

public class CompetencyGraph {

    public static final String NARROWS_RELATION_TEXT = "narrows";
    public static final String BROADENS_RELATION_TEXT = "broadens";
    public static final String REQUIRES_RELATION_TEXT = "requires";
    public static final String IS_REQUIRED_BY_RELATION_TEXT = "isRequiredBy";
    public static final String IS_EQUIVALENT_TO_RELATION_TEXT = "isEquivalentTo";

    private static final String EDGE_MAP_FIELD_DELIMETER = " -------||||||------- ";

    private class Edge {

        private String source;
        private String target;
        private String relation;

        public Edge (String source, String target, String relation) {
            this.source = source;
            this.target = target;
            this.relation = relation;
        }

        public String getSource() {return source;}
        public void setSource(String source) {this.source = source;}

        public String getTarget() {return target;}
        public void setTarget(String target) {this.target = target;}

        public String getRelation() {return relation;}
        public void setRelation(String relation) {this.relation = relation;}

    }

    private class CleanGraph {
        private Array<String> nodes;
        private Array<Edge> edges;

        public CleanGraph(Array<String> nodes, Array<Edge> edges) {
            this.nodes = nodes;
            this.edges = edges;
        }
    }

    private class CleanGraphWithAssertions  {

        private Array<String> nodes;
        private Array<Edge> edges;
        private Array<SimpleAssertion> positiveAssertions;
        private Array<SimpleAssertion> negativeAssertions;

        public CleanGraphWithAssertions(Array<String> nodes, Array<Edge> edges, Array<SimpleAssertion> positiveAssertions,
                                        Array<SimpleAssertion> negativeAssertions) {
            this.nodes = nodes;
            this.edges = edges;
            this.positiveAssertions = positiveAssertions;
            this.negativeAssertions = negativeAssertions;
        }
    }

    private Array<String> nodes;
    private Array<Edge> edges;
    private Array<SimpleAssertion> positiveAssertions;
    private Array<SimpleAssertion> negativeAssertions;

    private Map<String,String> nodeMap;
    private Map<String,String> edgeMap;

    private boolean includeAssertions;

    public CompetencyGraph(boolean includeAssertions) {
        nodes = new Array<String>();
        edges = new Array<Edge>();
        positiveAssertions = new Array<SimpleAssertion>();
        negativeAssertions = new Array<SimpleAssertion>();
        nodeMap = JSCollections.$map();
        edgeMap = JSCollections.$map();
        this.includeAssertions = includeAssertions;
    }

    public Array<String> getNodes() {return nodes;}

    public void addNode(String id) {
        if (!graphContainsNode(id)) {
            nodes.push(id);
            nodeMap.$put(id,id);
        }
    }

    private String getEdgeKey(String source, String target, String relationType) {
        return source + EDGE_MAP_FIELD_DELIMETER + target + EDGE_MAP_FIELD_DELIMETER + relationType;
    }

    public void addEdge(String source, String target, String relationType) {
        if (!graphContainsEdge(source,target,relationType)) {
            edges.push(new Edge(source,target,relationType));
            String edgeKey = getEdgeKey(source,target,relationType);
            edgeMap.$put(edgeKey,edgeKey);
        }
    }

    public void addPositiveAssertion(SimpleAssertion simpleAssertion) {
        if (simpleAssertion != null) positiveAssertions.push(simpleAssertion);
    }

    public void addNegativeAssertion(SimpleAssertion simpleAssertion) {
        if (simpleAssertion != null) negativeAssertions.push(simpleAssertion);
    }

    public boolean graphContainsNode(String nodeId) {
        if (nodeMap.$get(nodeId) == null) return false;
        return true;
    }

    public boolean graphContainsEdge(String source, String target, String relationType) {
        if (edgeMap.$get(getEdgeKey(source,target,relationType)) == null) return false;
        return true;
    }

    public void createImpliedRelationships() {
        Array<Edge> edgesToAdd = new Array<Edge>();
        Edge e;
        for (int i=0;i<edges.$length();i++) {
            e = edges.$get(i);
            if (e.getRelation().equalsIgnoreCase(NARROWS_RELATION_TEXT)) {
                edgesToAdd.push(new Edge(e.getTarget(),e.getSource(),BROADENS_RELATION_TEXT));
            }
            else if (e.getRelation().equalsIgnoreCase(REQUIRES_RELATION_TEXT)) {
                edgesToAdd.push(new Edge(e.getTarget(),e.getSource(),IS_REQUIRED_BY_RELATION_TEXT));
            }
            else if (e.getRelation().equalsIgnoreCase(IS_EQUIVALENT_TO_RELATION_TEXT)) {
                edgesToAdd.push(new Edge(e.getTarget(),e.getSource(),IS_EQUIVALENT_TO_RELATION_TEXT));
            }
//            else if (e.getRelation().equalsIgnoreCase(BROADENS_RELATION_TEXT)) {
//                edgesToAdd.push(new Edge(e.getTarget(),e.getSource(),NARROWS_RELATION_TEXT));
//            }
//            else if (e.getRelation().equalsIgnoreCase(IS_REQUIRED_BY_RELATION_TEXT)) {
//                edgesToAdd.push(new Edge(e.getTarget(),e.getSource(),REQUIRES_RELATION_TEXT));
//            }
        }
        Edge ne;
        for (int i=0;i<edgesToAdd.$length();i++) {
            ne = edgesToAdd.$get(i);
            addEdge(ne.getSource(),ne.getTarget(),ne.getRelation());
        }
    }

    public String getJsonString() {
        if (includeAssertions) return Global.JSON.stringify(new CleanGraphWithAssertions(nodes,edges,positiveAssertions,negativeAssertions));
        else return Global.JSON.stringify(new CleanGraph(nodes,edges));
    }

}
