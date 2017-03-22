package cass.rollup.processors.v2.graph.collapser;

import cass.rollup.processors.v2.graph.*;
import cass.rollup.processors.v2.graph.util.*;
import org.stjs.javascript.Array;

public class CyclicGraphCollapser {

    private Array<Node> nodesProcessed;
    private Array<Node> visitedNodes;

    public CyclicGraphCollapser() {
    }

    private NodeRelationMap buildNarrowsIsRequiredByEqualsMap(NodeGraph graph) {
        NodeRelationMap relationMap = new NodeRelationMap();
        Node n;
        Array<Node> nodeList = graph.getNodeList();
        for (int i=0;i<nodeList.$length();i++) {
            n = nodeList.$get(i);
            relationMap.addNodeRelations(n,graph.getNarrowsIsRequiredByEqualsRelationListForNode(n));
        }
        return relationMap;
    }

    private NodeRelationMap buildBroadensRequiresEqualsMap(NodeGraph graph) {
        NodeRelationMap relationMap = new NodeRelationMap();
        Node n;
        Array<Node> nodeList = graph.getNodeList();
        for (int i=0;i<nodeList.$length();i++) {
            n = nodeList.$get(i);
            relationMap.addNodeRelations(n,graph.getBroadensRequiresEqualsRelationListForNode(n));
        }
        return relationMap;
    }

    private void mergeEquivalentNodes(NodeRelationMap relationMap, NodePacketGraph npg) {
        Array<Node> nodeList = relationMap.getNodeList();
        Array<NodeRelation> nodeRelations;
        NodeRelation nr;
        for (int i=0;i<nodeList.$length();i++) {
            nodeRelations =  relationMap.getRelationsForNode(nodeList.$get(i));
            for (int j=0;j<nodeRelations.$length();j++) {
                nr = nodeRelations.$get(j);
                if (nr.getType().equals(RelationType.RELATION_TYPE.IS_EQUIVALENT_TO)) {
                    npg.mergeNodePackets(npg.getNodePacketForNode(nr.getSource()),npg.getNodePacketForNode(nr.getTarget()));
                }
            }
        }
    }

    private void mergeCyclicNodes(Node startCycleNode, NodePacketGraph npg) {
        //int startingIdx = visitedNodes.lastIndexOf(startCycleNode);
        int startingIdx = ArrayUtil.arrayLastIndexOf(visitedNodes,startCycleNode);
        Node partOfCycleNode;
        for (int i=startingIdx + 1;i<visitedNodes.$length();i++) {
            partOfCycleNode = visitedNodes.$get(i);
            if (partOfCycleNode != startCycleNode) npg.mergeNodePackets(npg.getNodePacketForNode(startCycleNode),npg.getNodePacketForNode(partOfCycleNode));
        }
    }

    private void findCycles(Node n, NodeRelationMap relationMap, NodePacketGraph npg) {
        if (ArrayUtil.arrayContains(visitedNodes,n)) {
            mergeCyclicNodes(n,npg);
        }
        else  {
            nodesProcessed.push(n);
            Array<NodeRelation> relationsToVisit = relationMap.getRelationsForNode(n);
            if (relationsToVisit == null || relationsToVisit.$length() == 0) return;
            else {
                visitedNodes.push(n);
                NodeRelation nr;
                for (int i=0;i<relationsToVisit.$length();i++){
                    nr = relationsToVisit.$get(i);
                    findCycles(nr.getTarget(),relationMap,npg);
                }
                //TODO Im not sure if this is going to work...TB...may have to return visitedNodes or something...
                visitedNodes = ArrayUtil.arrayRemove(visitedNodes,n);
                //visitedNodes.remove(n);
            }
        }
    }

    private void startFindCycles(NodeRelationMap relationMap, NodePacketGraph npg) {
        Array<Node> nodeList = relationMap.getNodeList();
        for (int i=0;i<nodeList.$length();i++) {
            visitedNodes = new Array<Node>();
            //this may be something we can change for efficiency...I was alternating between these two to see if there was any difference...
            //if (!nodesProcessed.contains(n)) findCycles(n,relationMap,npg,new ArrayList<Node>());
            findCycles(nodeList.$get(i),relationMap,npg);
        }
    }

    private NodePacketGraph buildNodePacketGraph(NodeRelationMap relationMap) {
        NodePacketGraph npg = new NodePacketGraph();
        npg.initNodePacketGraph(relationMap.getNodeList());
        mergeEquivalentNodes(relationMap,npg);
        nodesProcessed = new Array<Node>();
        startFindCycles(relationMap, npg);
        return npg;
    }

    public NodePacketGraph mergeNodePacketGraphs(NodePacketGraph nirbeNpg, NodePacketGraph breNpg) {
        NodePacketGraph mergedNpg = nirbeNpg;
        NodePacket np;
        Array<NodePacket> nodePacketList = breNpg.getNodePacketList();
        for (int i=0;i<nodePacketList.$length();i++) {
            np = nodePacketList.$get(i);
            if (np.getNodeCount() > 1) {
                NodePacket targetNodePacket = mergedNpg.getNodePacketForNode(np.getNodeList().$get(0));
                for (int j=1;j<np.getNodeList().$length();j++) {
                    mergedNpg.mergeNodePackets(targetNodePacket,mergedNpg.getNodePacketForNode(np.getNodeList().$get(j)));
                }
            }
        }
        return mergedNpg;
    }

    public NodePacketGraph collapseGraph(NodeGraph graph) throws Exception {
        try {
            NodePacketGraph nirbeNpg = buildNodePacketGraph(buildNarrowsIsRequiredByEqualsMap(graph));
            NodePacketGraph breNpg = buildNodePacketGraph(buildBroadensRequiresEqualsMap(graph));
            NodePacketGraph finalNodePacketGraph = mergeNodePacketGraphs(nirbeNpg,breNpg);
            finalNodePacketGraph.buildPacketRelationsFromNodeRelations(graph.getRelationList());
            //TODO handle handle mutli related packets (two packets with multiple relationships)
            return finalNodePacketGraph;
        }
        catch (Exception e) {
            throw e;
        }
    }

//    public static void main (String[] args) throws Exception {
//        NodeGraph ng = TestGraphBuilder.buildTestGraph();
//        System.out.println("--================ INPUT GRAPH ================--");
//        ng.printGraphByNode();
//        //ng.printGraphByNodeSplit();
//        CyclicGraphCollapser cgc = new CyclicGraphCollapser();
//        NodePacketGraph npg = cgc.collapseGraph(ng,false);
//        System.out.println("\n\n");
//        if (npg == null) System.out.println("COLLAPSED GRAPH IS NULL!!!");
//        else {
//            System.out.println("--================ COLLAPSED GRAPH ================--");
//            npg.printGraphByNode();
//        }
//
//    }
}
