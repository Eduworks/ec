package cass.rollup.processors.v2.graph.collapser;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

public class NodePacket {

    private Array<Node> nodeList;
    private Map<String,Node> nodeMap;

    public NodePacket() {
        nodeList = new Array<Node>();
        nodeMap = JSCollections.$map();
    }

    public Array<Node> getNodeList() {return nodeList;}
    public void setNodeList(Array<Node> nodeList) {this.nodeList = nodeList;}

    public int getNodeCount() {return nodeList.$length();}

    public void addNode(Node n) {
        if (nodeMap.$get(n.getId()) == null) {
            nodeList.push(n);
            nodeMap.$put(n.getId(),n);
        }
    }

    public String toString() {
        String ret = "";
        ret = ret + "NodePacket: (";
        for (int i=0;i<nodeList.$length();i++) {
            if ((i + 1) < nodeList.$length()) ret = ret + nodeList.$get(i).toString() + ", ";
            else ret = ret + nodeList.$get(i).toString();
        }
        ret = ret + ")";
        return ret;
    }
}
