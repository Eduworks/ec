package cass.rollup.processors.v2.graph.util;

import cass.rollup.processors.v2.graph.Node;
import cass.rollup.processors.v2.graph.NodeRelation;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

public class NodeRelationMap {

    private Array<Node> nodeList;
    private Map<String,Array<NodeRelation>> relationMap;

    public NodeRelationMap() {
        nodeList = new Array<Node>();
        relationMap = JSCollections.$map();
    }

    public void addNodeRelations(Node n, Array<NodeRelation> rm) {
        nodeList.push(n);
        relationMap.$put(n.getId(),rm);
    }

    public Array<NodeRelation> getRelationsForNode(Node n) {return relationMap.$get(n.getId());}

    public Array<Node> getNodeList() {return nodeList;}
    public void setNodeList(Array<Node> nodeList) {this.nodeList = nodeList;}

    public Map<String, Array<NodeRelation>> getRelationMap() {return relationMap;}
    public void setRelationMap(Map<String, Array<NodeRelation>> relationMap) {this.relationMap = relationMap;}

    public String toString() {
        String ret = "";
        Node n;
        Array<NodeRelation> nra;
        for (int i=0;i<nodeList.$length();i++) {
            n = nodeList.$get(i);
            ret = ret + n.toString() + "\n";
            nra = relationMap.$get(n.getId());
            for (int j=0;j<nra.$length();j++) {
                ret = ret + "\t" + nra.$get(j).toString() + "\n";
            }
        }
        return ret;
    }
}
