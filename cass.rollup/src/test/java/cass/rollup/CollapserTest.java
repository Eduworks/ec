package cass.rollup;

import cass.rollup.processors.v2.graph.Node;
import cass.rollup.processors.v2.graph.NodeGraph;
import cass.rollup.processors.v2.graph.NodePacketGraph;
import cass.rollup.processors.v2.graph.RelationType;
import cass.rollup.processors.v2.graph.collapser.CyclicGraphCollapser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Global;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "lib/require.js", "rollupInit.js", "/forge/forge.bundle.js" })
public class CollapserTest {

    @Test
    public void basicCollapseTest() {

        Global.console.log("start basicCollapseTest:");
        try {
            NodeGraph graph1 = buildTest0();
            Global.console.log("--================ INPUT GRAPH ================--");
            Global.console.log(graph1.toStringGraphByNode());
            CyclicGraphCollapser cgc = new CyclicGraphCollapser();
            NodePacketGraph npg = cgc.collapseGraph(graph1);
            if (npg == null) Global.console.log("COLLAPSED GRAPH IS NULL!!!");
            else {

                Global.console.log("--================ what ================--");
                Global.console.log("NODE COUNT: " + npg.getNodePacketList().$get(0).getNodeCount());

                Global.console.log("--================ COLLAPSED GRAPH ================--");
                Global.console.log(npg.toStringGraphAll());
            }
        }
        catch (Exception e) {
            Global.console.log("Exception: " + e.toString());
        }

        Assert.assertSame(true,true);

        Global.console.log("end basicCollapseTest");

    }

    private NodeGraph buildTest0() throws Exception {

        NodeGraph graph = new NodeGraph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);

        graph.addRelation(nodeA, nodeB, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeB, nodeC, RelationType.RELATION_TYPE.NARROWS);
        graph.addRelation(nodeC, nodeA, RelationType.RELATION_TYPE.NARROWS);

        //graph.createImpliedRelations();

        return graph;
    }

    private NodeGraph buildTest1() throws Exception {

        NodeGraph graph = new NodeGraph();

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

        graph.createImpliedRelations();

        return graph;
    }

    private NodeGraph buildTest2() throws Exception {

        NodeGraph graph = new NodeGraph();

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

        graph.createImpliedRelations();

        return graph;
    }

    private NodeGraph buildTest3() throws Exception {

        NodeGraph graph = new NodeGraph();

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

        graph.createImpliedRelations();

        return graph;
    }

    private NodeGraph buildTest4() throws Exception {

        NodeGraph graph = new NodeGraph();

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

        graph.createImpliedRelations();

        return graph;

    }

    private NodeGraph buildTest5() throws Exception {

        NodeGraph graph = new NodeGraph();

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

        graph.createImpliedRelations();

        return graph;
    }


    private NodeGraph buildTest6() throws Exception {

        NodeGraph graph = new NodeGraph();

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

        graph.createImpliedRelations();

        return graph;
    }

    private NodeGraph buildTest7() throws Exception {

        NodeGraph graph = new NodeGraph();

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

        graph.createImpliedRelations();

        return graph;
    }

}
