package cass.rollup.processors.v2.graph;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

public class NodeGraph {

    //CYCLE EQUIVS (1)
    //Narrows == isRequiredBy

    //CYCLE EQUIVS (2)
    //Broadens == Requires

    private Array<Node> nodeList;
    private Map<String,Node> nodeMap;

    private Array<NodeRelation> relationList;
    private Map<String,Array<NodeRelation>> relationMap;

    public NodeGraph() {
        nodeList = new Array<Node>();
        relationList = new Array<NodeRelation>();
        nodeMap = JSCollections.$map();
        relationMap = JSCollections.$map();
    }

    public void addNode(Node n) {
        if (nodeMap.$get(n.getId()) == null) {
            nodeList.push(n);
            nodeMap.$put(n.getId(),n);
        }
    }

    public void createImpliedRelations() throws Exception {
        Array<NodeRelation> relationsToAdd = new Array<NodeRelation>();
        NodeRelation nr;
        for (int i=0;i<relationList.$length();i++) {
            nr = relationList.$get(i);
            if (nr.getType().equals(RelationType.RELATION_TYPE.NARROWS)) {
                relationsToAdd.push(new NodeRelation(nr.getTarget(),nr.getSource(),RelationType.RELATION_TYPE.BROADENS));
            }
            else if (nr.getType().equals(RelationType.RELATION_TYPE.REQUIRES)) {
                relationsToAdd.push(new NodeRelation(nr.getTarget(),nr.getSource(),RelationType.RELATION_TYPE.IS_REQUIRED_BY));
            }
        }
        NodeRelation nnr;
        for (int i=0;i<relationsToAdd.$length();i++) {
            nnr = relationsToAdd.$get(i);
            addRelation(nnr.getSource(),nnr.getTarget(),nnr.getType());
        }
    }

    public void addRelation(Node sourceNode, Node targetNode, RelationType.RELATION_TYPE relationType) throws Exception {
        Array<NodeRelation> nodeRelationList;
        if (nodeHasRelations(sourceNode)) nodeRelationList = getRelationListForNode(sourceNode);
        else {
            nodeRelationList = new Array<NodeRelation>();
            relationMap.$put(sourceNode.getId(),nodeRelationList);
        }
        NodeRelation newNodeRelation = new NodeRelation(sourceNode,targetNode,relationType);
        if (!doesRelationAlreadyExist(newNodeRelation, nodeRelationList)) {
            nodeRelationList.push(newNodeRelation);
            relationList.push(newNodeRelation);
        }
    }

    public Array<NodeRelation> getRelationListForNode(Node n) {return relationMap.$get(n.getId());}

    public Array<NodeRelation> getNarrowsIsRequiredByEqualsRelationListForNode(Node n) {
        Array<NodeRelation> retList = new Array<NodeRelation>();
        if (relationMap.$get(n.getId()) != null) {
            Array<NodeRelation> nra = relationMap.$get(n.getId());
            NodeRelation nr;
            for (int i=0;i<nra.$length();i++) {
                nr = nra.$get(i);
                if (nr.getType().equals(RelationType.RELATION_TYPE.IS_EQUIVALENT_TO) ||
                        nr.getType().equals(RelationType.RELATION_TYPE.NARROWS) ||
                        nr.getType().equals(RelationType.RELATION_TYPE.IS_REQUIRED_BY)) {
                    retList.push(nr);
                }
            }
        }
        return retList;
    }

    public Array<NodeRelation> getBroadensRequiresEqualsRelationListForNode(Node n) {
        Array<NodeRelation> retList = new Array<NodeRelation>();
        if (relationMap.$get(n.getId()) != null) {
            Array<NodeRelation> nra = relationMap.$get(n.getId());
            NodeRelation nr;
            for (int i=0;i<nra.$length();i++) {
                nr = nra.$get(i);
                if (nr.getType().equals(RelationType.RELATION_TYPE.IS_EQUIVALENT_TO) ||
                        nr.getType().equals(RelationType.RELATION_TYPE.BROADENS) ||
                        nr.getType().equals(RelationType.RELATION_TYPE.REQUIRES)) {
                    retList.push(nr);
                }
            }
        }
        return retList;
    }

    public Array<Node> getNodeList() {return nodeList;}
    public void setNodeList(Array<Node> nodeList) {this.nodeList = nodeList;}

    public Array<NodeRelation> getRelationList() {return relationList;}
    public void setRelationList(Array<NodeRelation> relationList) {this.relationList = relationList;}

    public boolean nodeHasRelations(Node n) {
        if (relationMap.$get(n.getId()) == null) return false;
        return true;
    }

    private boolean doesRelationAlreadyExist(NodeRelation nodeRelation, Array<NodeRelation> nodeRelationList) {
        NodeRelation nr;
        for (int i=0;i<nodeRelationList.$length();i++) {
            nr = nodeRelationList.$get(i);
            if (nodeRelation.getSource().getId().equals(nr.getSource().getId()) &&
                    nodeRelation.getTarget().getId().equals(nr.getTarget().getId()) &&
                    nodeRelation.getType().equals(nr.getType())) return true;
        }
        return false;
    }

    //DEBUGING****************************************************************************************************************************

    //cant use StringBuffer with stjs...
    public String toStringGraphAll() {
        String ret = "";
        Node n;
        for (int i=0;i<nodeList.$length();i++) {
            n = nodeList.$get(i);
            ret = ret + n.toString() + "\n";
        }
        NodeRelation nr;
        for (int i=0;i<relationList.$length();i++) {
            nr = relationList.$get(i);
            ret = ret + nr.toString() + "\n";
        }
        return ret;
    }

    //cant use StringBuffer with stjs...
    public String toStringGraphByNode() {
        String ret = "";
        ret = ret + " - TEST HOWDY - \n";
        Node n;
        Array<NodeRelation> nra;
        NodeRelation nr;
        for (int i=0;i<nodeList.$length();i++) {
            n = nodeList.$get(i);
            ret = ret + "   --> " + n.toString() + "\n";
            if (nodeHasRelations(n)) {
                nra = getRelationListForNode(n);
                for (int j=0;j<nra.$length();j++) {
                    nr = nra.$get(j);
                    ret = ret + "\t\t" + nr.toString() + "\n";
                }
            }
            else ret = ret + "\t\t---------NO RELATIONSHIPS---------" + "\n";
        }
        return ret;
    }

    //cant use StringBuffer with stjs...
    public String toStringGraphByNodeSplit() {
        String ret = "";
        Node n;
        Array<NodeRelation> nra;
        NodeRelation nr;
        for (int i=0;i<nodeList.$length();i++) {
            n = nodeList.$get(i);
            ret = ret + "   --> " + n.toString() + "\n";
            if (nodeHasRelations(n)) {

                ret = ret + "\t\t=== Narrows/isRequiredBy ===" + "\n";
                nra = getNarrowsIsRequiredByEqualsRelationListForNode(n);
                for (int j=0;j<nra.$length();j++) {
                    nr = nra.$get(j);
                    ret = ret + "\t\t" + nr.toString() + "\n";
                }
                ret = ret + "\t\t=== Broadens/Requires ===" + "\n";
                nra = getBroadensRequiresEqualsRelationListForNode(n);
                for (int j=0;j<nra.$length();j++) {
                    nr = nra.$get(j);
                    ret = ret + "\t\t" + nr.toString() + "\n";
                }
            }
            else ret = ret + "\t\t---------NO RELATIONSHIPS---------" + "\n";
        }
        return ret;
    }
}
