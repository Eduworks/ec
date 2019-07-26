package cass.rollup.processors.v2.graph.collapser;

public class TestGraphBuilder {

    //CYCLE EQUIVS (1)
    //Narrows == isRequiredBy

    //CYCLE EQUIVS (2)
    //Broadens == Requires

    private static void buildTest0(NodeGraph graph) throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);

        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeA, RelationType.RELATION_TYPE.NARROWS);
    }

    private static void buildTest1(NodeGraph graph) throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeD, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeD, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeE, RelationType.RELATION_TYPE.NARROWS);
    }

    private static void buildTest2(NodeGraph graph) throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);

        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.IS_EQUIVALENT_TO);
        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeD, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeD, nodeF, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeF, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeD, nodeE, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeE, nodeG, RelationType.RELATION_TYPE.REQUIRES);
    }

    private static void buildTest3(NodeGraph graph) throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);
        graph.addNode(nodeI);

        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeD, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeD, nodeI, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeI, nodeB, RelationType.RELATION_TYPE.IS_REQUIRED_BY);

        graph.addRelation(nodeD, nodeE, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeE, nodeF, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeF, nodeG, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeG, nodeH, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeH, nodeE, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
    }

    private static void buildTest4(NodeGraph graph) throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);
        graph.addNode(nodeI);


        graph.addRelation(nodeD, nodeE, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeF, nodeG, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeG, nodeH, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeI, nodeB, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeE, nodeF, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeC, nodeD, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeD, nodeI, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeH, nodeE, RelationType.RELATION_TYPE.IS_REQUIRED_BY);

        graph.addRelation(nodeG, nodeB, RelationType.RELATION_TYPE.NARROWS);

        //graph.addRelation(nodeG, nodeA, RelationType.RELATION_TYPE.IS_REQUIRED_BY);


    }

    private static void buildTest5(NodeGraph graph) throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);
        graph.addNode(nodeI);

        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeD, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeD, nodeI, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeI, nodeB, RelationType.RELATION_TYPE.BROADENS);

        graph.addRelation(nodeD, nodeE, RelationType.RELATION_TYPE.BROADENS);

        graph.addRelation(nodeE, nodeF, RelationType.RELATION_TYPE.BROADENS);
        graph.addRelation(nodeF, nodeG, RelationType.RELATION_TYPE.BROADENS);
        graph.addRelation(nodeG, nodeH, RelationType.RELATION_TYPE.REQUIRES);
        graph.addRelation(nodeH, nodeE, RelationType.RELATION_TYPE.NARROWS);
    }


    private static void buildTest6(NodeGraph graph) throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);
        graph.addNode(nodeI);

        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeD, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeD, nodeI, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeI, nodeB, RelationType.RELATION_TYPE.IS_REQUIRED_BY);

        graph.addRelation(nodeD, nodeE, RelationType.RELATION_TYPE.REQUIRES);

        graph.addRelation(nodeE, nodeF, RelationType.RELATION_TYPE.BROADENS);
        graph.addRelation(nodeF, nodeG, RelationType.RELATION_TYPE.BROADENS);
        graph.addRelation(nodeG, nodeH, RelationType.RELATION_TYPE.REQUIRES);
        graph.addRelation(nodeH, nodeE, RelationType.RELATION_TYPE.REQUIRES);
    }

    private static void buildTest7(NodeGraph graph) throws Exception {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.NARROWS);

        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeD, RelationType.RELATION_TYPE.IS_REQUIRED_BY);
        graph.addRelation(nodeD, nodeB, RelationType.RELATION_TYPE.IS_REQUIRED_BY);

        graph.addRelation(nodeB, nodeF, RelationType.RELATION_TYPE.BROADENS);
        graph.addRelation(nodeF, nodeE, RelationType.RELATION_TYPE.REQUIRES);
        graph.addRelation(nodeE, nodeB, RelationType.RELATION_TYPE.REQUIRES);
    }

    public static NodeGraph buildTestGraph() throws Exception {
        NodeGraph graph = new NodeGraph();
        buildTest7(graph);
        graph.createImpliedRelations();
        return graph;
    }
}
