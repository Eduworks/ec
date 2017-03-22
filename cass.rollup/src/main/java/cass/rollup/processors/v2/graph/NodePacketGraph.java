package cass.rollup.processors.v2.graph;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import cass.rollup.processors.v2.graph.util.*;

public class NodePacketGraph {

    private Array<NodePacket> nodePacketList;
    private Map<String,NodePacket> nodePacketMap;

    private Array<PacketRelation> relationList;

    public NodePacketGraph() {
        nodePacketList = new Array<NodePacket>();
        nodePacketMap = JSCollections.$map();
        relationList = new Array<PacketRelation>();
    }

    public void initNodePacketGraph(Array<Node> nodes) {
        NodePacket np;
        Node n;
        for (int i=0;i<nodes.$length();i++) {
            n = nodes.$get(i);
            np = new NodePacket();
            np.addNode(n);
            nodePacketList.push(np);
            nodePacketMap.$put(n.getId(),np);
        }
    }

    public NodePacket getNodePacketForNode(Node n) {return nodePacketMap.$get(n.getId());}

    public void mergeNodePackets(NodePacket packet1, NodePacket packet2) {
        if (packet1 != packet2) {
            Node n;
            Array<Node> na = packet2.getNodeList();
            for (int i=0;i<na.$length();i++) {
                n = na.$get(i);
                packet1.addNode(n);
                nodePacketMap.$put(n.getId(),packet1);
            }
            nodePacketList = ArrayUtil.arrayRemove(nodePacketList,packet2);
        }
    }

    public Array<NodePacket> getNodePacketList() {return nodePacketList;}
    public void setNodePacketList(Array<NodePacket> nodePacketList) {this.nodePacketList = nodePacketList;}

    public Array<PacketRelation> getRelationList() {return relationList;}
    public void setRelationList(Array<PacketRelation> relationList) {this.relationList = relationList;}

    public void addNodePacket(NodePacket np) {nodePacketList.push(np);}

    //public boolean nodePacketHasRelations(NodePacket np) {return relationMap.containsKey(np);}

    //public ArrayList<PacketRelation> getRelationListForNodePacket(NodePacket np) {return relationMap.get(np);}

    public void addRelation(NodePacket sourceNodePacket, NodePacket targetNodePacket, RelationType.RELATION_TYPE relationType) {
//        ArrayList<PacketRelation> packetRelationList;
//        if (nodePacketHasRelations(sourceNodePacket)) packetRelationList = getRelationListForNodePacket(sourceNodePacket);
//        else {
//            packetRelationList = new ArrayList<PacketRelation>();
//            relationMap.put(sourceNodePacket,packetRelationList);
//        }
        PacketRelation newPacketRelation = new PacketRelation(sourceNodePacket,targetNodePacket,relationType);
        //packetRelationList.add(newPacketRelation);
        relationList.push(newPacketRelation);
    }

    public void buildPacketRelationsFromNodeRelations(Array<NodeRelation> nodeRelationList) {
        NodePacket sourceNodePacket;
        NodePacket targetNodePacket;
        NodeRelation nr;
        for (int i=0;i<nodeRelationList.$length();i++) {
            nr = nodeRelationList.$get(i);
            sourceNodePacket = getNodePacketForNode(nr.getSource());
            targetNodePacket = getNodePacketForNode(nr.getTarget());
            if (sourceNodePacket != targetNodePacket) addRelation(sourceNodePacket,targetNodePacket, nr.getType());
        }
    }

    //DEBUGING****************************************************************************************************************************

    //cant use StringBuffer with stjs...
    public String toStringGraphAll() {
        String ret = "";
        ret = ret + "> Packets: " + "\n";
        NodePacket np;
        for (int i=0;i<nodePacketList.$length();i++) {
            np = nodePacketList.$get(i);
            ret = ret + "   " + np.toString() + "\n";
        }
        PacketRelation pr;
        if (relationList.$length() > 0) {
            ret = ret + ">>Relationships: >" + "\n";
            for (int i=0;i<relationList.$length();i++) {
                pr = relationList.$get(i);
                ret = ret + "   " + pr.toString() + "\n";
            }
        }
        return ret;
    }

    //cant use StringBuffer with stjs...
//    public String toStringGraphByNode() {
//        String ret = "";
//        for (NodePacket np:nodePacketList) {
//            ret = ret + "   --> " + np.toString() + "\n";
//            if (nodePacketHasRelations(np)) {
//                for (PacketRelation pr:getRelationListForNodePacket(np)) ret = ret + "\t\t" + pr.toString() + "\n";
//            }
//            else ret = ret + "\t\t---------NO RELATIONSHIPS---------" + "\n";
//        }
//        return ret;
//    }
}
