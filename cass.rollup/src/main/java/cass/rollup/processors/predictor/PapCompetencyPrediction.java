package cass.rollup.processors.predictor;

public class PapCompetencyPrediction {

    private String competencyId;
    private double confidence;
    private double conflictLevel;
    private String conflictClass;

    public String getCompetencyId() {return competencyId;}
    public void setCompetencyId(String competencyId) {this.competencyId = competencyId;}

    public double getConfidence() {return confidence;}
    public void setConfidence(double confidence) {this.confidence = confidence;}

    public double getConflictLevel() {return conflictLevel;}
    public void setConflictLevel(double conflictLevel) {this.conflictLevel = conflictLevel;}

    public String getConflictClass() {return conflictClass;}
    public void setConflictClass(String conflictClass) {this.conflictClass = conflictClass;}

}
