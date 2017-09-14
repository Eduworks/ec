package cass.rollup.processors.predictor;

public class PapAssertion {

    private Double confidence;
    private Integer competencyIndex;
    private Long assertionDate;
    private Long expirationDate;
    private boolean result;

    public PapAssertion(Double confidence, Integer competencyIndex, Long assertionDate, Long expirationDate, boolean result) {
        this.confidence = confidence;
        this.assertionDate=assertionDate;
        this.expirationDate=expirationDate;
        this.result=result;
        this.competencyIndex = competencyIndex;
    }

    public Double getConfidence() {return confidence;}
    public void setConfidence(Double confidence) {this.confidence = confidence;}

    public Integer getCompetencyIndex() {return competencyIndex;}
    public void setCompetencyIndex(Integer competencyIndex) {this.competencyIndex = competencyIndex;}

    public Long getAssertionDate() {return assertionDate;}
    public void setAssertionDate(Long assertionDate) {this.assertionDate = assertionDate;}

    public Long getExpirationDate() {return expirationDate;}
    public void setExpirationDate(Long expirationDate) {this.expirationDate = expirationDate;}

    public boolean getResult() {return result;}
    public void setResult(boolean result) {this.result = result;}

}
