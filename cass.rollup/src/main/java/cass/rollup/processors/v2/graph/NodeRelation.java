package cass.rollup.processors.v2.graph;

public class NodeRelation {

    private RelationType.RELATION_TYPE type;
    private Node source;
    private Node target;

    public NodeRelation(Node source, Node target, RelationType.RELATION_TYPE type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }

    public Node getSource() {return source;}
    public void setSource(Node source) {this.source = source;}

    public Node getTarget() {return target;}
    public void setTarget(Node target) {this.target = target;}

    public RelationType.RELATION_TYPE getType() {return type;}
    public void setType(RelationType.RELATION_TYPE type) {this.type = type;}

    public String toString() {
        return getSource().toString() + " >>" + getType() + "<< " + getTarget().toString();
    }
}
