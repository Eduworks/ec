package cass.rollup.processors.v2.graph;

public class SimpleAssertion {

    private String id;
    private String subjectPem;
    private String competencyId;
    private Double confidence;
    private Long assertionDate;
    private Long expirationDate;
    private Boolean negative;

    public SimpleAssertion (String id, String competencyId, Double confidence) {
        this.id = id;
        this.competencyId = competencyId;
        this.confidence = confidence;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getSubjectPem() {return subjectPem;}
    public void setSubjectPem(String subjectPem) {this.subjectPem = subjectPem;}

    public String getCompetencyId() {return competencyId;}
    public void setCompetencyId(String competencyId) {this.competencyId = competencyId;}

    public Double getConfidence() {return confidence;}
    public void setConfidence(Double confidence) {this.confidence = confidence;}

    public Long getAssertionDate() {return assertionDate;}
    public void setAssertionDate(Long assertionDate) {this.assertionDate = assertionDate;}

    public Long getExpirationDate() {return expirationDate;}
    public void setExpirationDate(Long expirationDate) {this.expirationDate = expirationDate;}

    public Boolean isNegative() {return negative;}
    public void setNegative(Boolean negative) {this.negative = negative;}

}
