package cass.rollup.processors.v2.graph;

public class Node {

    private String name;
    private String id;

    public Node(String nameId) {
        this.name = nameId;
        this.id = nameId;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String toString() {
        return "Node: " + "\"" + id + "\"";
    }

}
