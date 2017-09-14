package cass.rollup.processors.v2.graph.collapser;

public class PacketRelation {

    private RelationType.RELATION_TYPE type;
    private NodePacket source;
    private NodePacket target;

    public PacketRelation(NodePacket source, NodePacket target, RelationType.RELATION_TYPE type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }

    public NodePacket getSource() {return source;}
    public void setSource(NodePacket source) {this.source = source;}

    public NodePacket getTarget() {return target;}
    public void setTarget(NodePacket target) {this.target = target;}

    public RelationType.RELATION_TYPE getType() {return type;}
    public void setType(RelationType.RELATION_TYPE type) {this.type = type;}

    public String toString() {
        return getSource().toString() + " >>" + getType() + "<< " + getTarget().toString();
    }
}
