package cass.rollup.processors.predictor;

import org.stjs.javascript.Array;
import org.stjs.javascript.Map;

public class PapCompetencyNetwork {

    private static final String LOW_CONFLICT_CLASS = "low";
    private static final String MEDIUM_CONFLICT_CLASS = "medium";
    private static final String HIGH_CONFLICT_CLASS = "high";
    private static final double EMPTY_PREDICTION = 0.0;
    private static final double EMPTY_CONFLICT_LEVEL = 0.0;
    private static final double MEDIUM_CONFLICT_CLASS_QUALIFIER = 1.05;
    private static final double HIGH_CONFLICT_CLASS_QUALIFIER = 1.5;

    private Map<String,Map<String,Array<PapDependency>>> dependencies;

    private Array<Double> activations;
    private Array<Double> alphas;
    private Array<Double> betas;
    private Array<Boolean> updated;
    private int numberNodes;

    public PapCompetencyNetwork(Map<String,Map<String,Array<PapDependency>>> dependencies, int numberNodes, PapSettings settings) {
        this.numberNodes=numberNodes;
        this.dependencies=dependencies;
        this.activations=new Array<Double>();
        this.alphas=new Array<Double>();
        this.betas=new Array<Double>();
        this.updated = new Array<Boolean>();
        for (int i=0; i < numberNodes;i++) {
            double beta_prior = settings.getBetaPrecision();
            double beta_mean = settings.getBetaMean();
            alphas.push(beta_mean*beta_prior);
            betas.push((1.0-beta_mean)*beta_prior);
            activations.push(beta_mean);
            updated.push(false);
        }
    }

    public void update(int nodeIndex, double change, boolean positive) {
        double a = alphas.$get(nodeIndex);
        double b = betas.$get(nodeIndex);
        if (positive) alphas.$set(nodeIndex, a+change);
        else betas.$set(nodeIndex,b+change);
        activations.$set(nodeIndex,(a+(positive ? change : 0))/(a+b+change));
        updated.$set(nodeIndex,true);
    }

    public double getPrediction(int index) {
        if (updated.$get(index)) {
            return activations.$get(index);
        }
        else return EMPTY_PREDICTION;
    }


    public double getConflictLevel(int index) {
        if (updated.$get(index)) {
            double a = alphas.$get(index);
            double b = betas.$get(index);
            double act = activations.$get(index);
            double stdev = Math.sqrt((a * b) / (a + b + 1)) / (a + b);
            return Math.min(act, 1.0 - act) / stdev;
        }
        else return EMPTY_CONFLICT_LEVEL;
    }

    public String getConflictClass(int index) {
        double level = getConflictLevel(index);
        String res = LOW_CONFLICT_CLASS;
        if (level >= MEDIUM_CONFLICT_CLASS_QUALIFIER) res = MEDIUM_CONFLICT_CLASS;
        if (level >= HIGH_CONFLICT_CLASS_QUALIFIER) res = HIGH_CONFLICT_CLASS;
        return res;
    }

    public Map<String, Map<String, Array<PapDependency>>> getDependencies() {return dependencies;}
    public void setDependencies(Map<String, Map<String, Array<PapDependency>>> dependencies) {this.dependencies = dependencies;}

    public Array<Double> getActivations() {return activations;}
    public void setActivations(Array<Double> activations) {this.activations = activations;}

    public Array<Double> getAlphas() {return alphas;}
    public void setAlphas(Array<Double> alphas) {this.alphas = alphas;}

    public Array<Double> getBetas() {return betas;}
    public void setBetas(Array<Double> betas) {this.betas = betas;}

    public Array<Boolean> getUpdated() {return updated;}
    public void setUpdated(Array<Boolean> updated) {this.updated = updated;}

    public int getNumberNodes() {return numberNodes;}
    public void setNumberNodes(int numberNodes) {this.numberNodes = numberNodes;}
}
