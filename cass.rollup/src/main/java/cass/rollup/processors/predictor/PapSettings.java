package cass.rollup.processors.predictor;

public class PapSettings {

    private static final int DEFAULT_ITERATIONS = 200;
    private static final boolean DEFAULT_ABRUPT_EXP = false;
    private static final boolean DEFAULT_GRAD_FORGETTING = true;
    private static final double DEFAULT_EVIDENCE_WEIGHT = 1.0;
    private static final double DEFAULT_DISCOUNT = 1.0;
    private static final double DEFAULT_PRIORITY_QUEUE_THRESHOLD = 0.01;
    private static final double DEFAULT_BETA_PRECISION = 0.1;
    private static final double DEFAULT_BETA_MEAN = 0.2;

    private Integer iterations;// [int, default 200]
    private boolean abruptExpiration; // [boolean, default false]
    private boolean gradualForgetting; // [boolean, default true]
    private Double evidenceWeight; // [double, default 1.0]
    private Double discount; //[double, default 1.0]
    private Double priorityQueueThreshold; //[double, default 0.01]
    private Double betaPrecision; //[double, default 0.1]
    private Double betaMean; //[double, default 0.2]

    //STJS is weird about inline initializations so doing it this way to be safe...
    public PapSettings() {
        iterations = DEFAULT_ITERATIONS;
        abruptExpiration = DEFAULT_ABRUPT_EXP;
        gradualForgetting = DEFAULT_GRAD_FORGETTING;
        evidenceWeight = DEFAULT_EVIDENCE_WEIGHT;
        discount = DEFAULT_DISCOUNT;
        priorityQueueThreshold = DEFAULT_PRIORITY_QUEUE_THRESHOLD;
        betaPrecision = DEFAULT_BETA_PRECISION;
        betaMean = DEFAULT_BETA_MEAN;
    }

    public Integer getIterations() {return iterations;}
    public void setIterations(Integer iterations) {this.iterations = iterations;}

    public boolean getAbruptExpiration() {return abruptExpiration;}
    public void setAbruptExpiration(boolean abruptExpiration) {this.abruptExpiration = abruptExpiration;}

    public boolean getGradualForgetting() {return gradualForgetting;}
    public void setGradualForgetting(boolean gradualForgetting) {this.gradualForgetting = gradualForgetting;}

    public Double getEvidenceWeight() {return evidenceWeight;}
    public void setEvidenceWeight(Double evidenceWeight) {this.evidenceWeight = evidenceWeight;}

    public Double getDiscount() {return discount;}
    public void setDiscount(Double discount) {this.discount = discount;}

    public Double getPriorityQueueThreshold() {return priorityQueueThreshold;}
    public void setPriorityQueueThreshold(Double priorityQueueThreshold) {this.priorityQueueThreshold = priorityQueueThreshold;}

    public Double getBetaPrecision() {return betaPrecision;}
    public void setBetaPrecision(Double betaPrecision) {this.betaPrecision = betaPrecision;}

    public Double getBetaMean() {return betaMean;}
    public void setBetaMean(Double betaMean) {this.betaMean = betaMean;}
}
