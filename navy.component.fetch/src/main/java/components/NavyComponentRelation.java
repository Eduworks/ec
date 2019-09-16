package components;

public class NavyComponentRelation {

    private static final String RELATION_TYPE = "narrows";

    private NavyComponent source;
    private NavyComponent target;

    public NavyComponent getSource() {return source;}
    public void setSource(NavyComponent source) {this.source = source;}

    public NavyComponent getTarget() {return target;}
    public void setTarget(NavyComponent target) {this.target = target;}
}
