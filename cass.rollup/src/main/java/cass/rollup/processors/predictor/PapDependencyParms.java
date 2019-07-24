package cass.rollup.processors.predictor;

public class PapDependencyParms {

    private Integer parentIndex;
    private Integer childIndex;
    private String type;
    private Double weight;
    private Double leak;
    private boolean dependencyFirst;
    private boolean reverse;

    public PapDependencyParms() {}

    public Integer getParentIndex() {return parentIndex;}
    public void setParentIndex(Integer parentIndex) {this.parentIndex = parentIndex;}

    public Integer getChildIndex() {return childIndex;}
    public void setChildIndex(Integer childIndex) {this.childIndex = childIndex;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public Double getWeight() {return weight;}
    public void setWeight(Double weight) {this.weight = weight;}

    public Double getLeak() {return leak;}
    public void setLeak(Double leak) {this.leak = leak;}

    public boolean getDependencyFirst() {return dependencyFirst;}
    public void setDependencyFirst(boolean dependencyFirst) {this.dependencyFirst = dependencyFirst;}

    public boolean getReverse() {return reverse;}
    public void setReverse(boolean reverse) {this.reverse = reverse;}

    public void swapParentChildIndexes() {
        Integer temp = parentIndex;
        parentIndex = childIndex;
        childIndex = temp;
    }

}
