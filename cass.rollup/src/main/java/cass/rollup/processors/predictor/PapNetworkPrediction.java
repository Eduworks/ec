package cass.rollup.processors.predictor;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;

public class PapNetworkPrediction {

    private Long predictionDate;
    private String subjectPem;
    private Array<PapCompetencyPrediction> predictions;

    public PapNetworkPrediction(Long predictionDate, String subjectPem, Array<String> competencyList, PapCompetencyNetwork competencyNetwork) {
        this.predictionDate = predictionDate;
        this.subjectPem = subjectPem;
        predictions = new Array<PapCompetencyPrediction>();
        String currentCompetency;
        PapCompetencyPrediction pcp;
        for (int i=0;i<competencyList.$length();i++) {
           currentCompetency = competencyList.$get(i);
           pcp = new PapCompetencyPrediction();
           pcp.setCompetencyId(currentCompetency);
           pcp.setConfidence(competencyNetwork.getPrediction(i));
           pcp.setConflictLevel(competencyNetwork.getConflictLevel(i));
           pcp.setConflictClass(competencyNetwork.getConflictClass(i));
           predictions.push(pcp);
        }
    }

    public Long getPredictionDate() {return predictionDate;}
    public void setPredictionDate(Long predictionDate) {this.predictionDate = predictionDate;}

    public String getSubjectPem() {return subjectPem;}
    public void setSubjectPem(String subjectPem) {this.subjectPem = subjectPem;}

    public Array<PapCompetencyPrediction> getPredictions() {return predictions;}
    public void setPredictions(Array<PapCompetencyPrediction> predictions) {this.predictions = predictions;}

    public String getJsonString() {
        return Global.JSON.stringify(this);
    }

}
