package cass.rollup.processors.predictor;

public class PapDependencyDefinitionBase {

    private String depClass;
    private boolean reverse;
    private Double weight;
    private Double leak;

    public  PapDependencyDefinitionBase(String depClass, boolean reverse, Double weight, Double leak) {
        this.depClass = depClass;
        this.reverse = reverse;
        this.weight = weight;
        this.leak = leak;
    }

    public String getDepClass() {return depClass;}
    public void setDepClass(String depClass) {this.depClass = depClass;}

    public boolean getReverse() {return reverse;}
    public void setReverse(boolean reverse) {this.reverse = reverse;}

    public Double getWeight() {return weight;}
    public void setWeight(Double weight) {this.weight = weight;}

    public Double getLeak() {return leak;}
    public void setLeak(Double leak) {this.leak = leak;}
}
