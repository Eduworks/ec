package cass.rollup.processors.predictor;

import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

public class PapDependencyDefinitions {

    private static final double DEFAULT_WEIGHT = 1.0;
    private static final double DEFAULT_LEAK = 0.0;
    private static final boolean DEFAULT_REVERSE = false;

    private static final String DEFAULT_NARROWS_BASE_CLASS = "broadens";
    private static final boolean DEFAULT_NARROWS_REVERSE = true;
    private static final double DEFAULT_NARROWS_WEIGHT = 0.9;
    private static final double DEFAULT_NARROWS_LEAK = 0.0;
    private static final String DEFAULT_NARROWS_KEY = "narrows";

    private static final String DEFAULT_ENABLES_BASE_CLASS = "isSufficientFor";
    private static final boolean DEFAULT_ENABLES_REVERSE = true;
    private static final double DEFAULT_ENABLES_WEIGHT = 0.9;
    private static final double DEFAULT_ENABLES_LEAK = 0.0;
    private static final String DEFAULT_ENABLES_KEY = "enables";

    private static final String DEFAULT_REQUIRES_BASE_CLASS = "isRequiredBy";
    private static final boolean DEFAULT_REQUIRES_REVERSE = false;
    private static final double DEFAULT_REQUIRES_WEIGHT = 0.9;
    private static final double DEFAULT_REQUIRES_LEAK = 0.0;
    private static final String DEFAULT_REQUIRES_KEY = "requires";

    private Map<String,PapDependencyDefinitionBase> dependencyDefinitionMap;

    public PapDependencyDefinitions() {
        dependencyDefinitionMap = JSCollections.$map();
    }

    /**
     * Pulled default values from CruncherAssertionProcessor
     dependencyDefs = new JSONObject();

     JSONObject narrows = new JSONObject();
     narrows.put("class","broadens");
     narrows.put("reverse",true);
     narrows.put("weight",0.9);
     dependencyDefs.put("narrows",narrows);

     JSONObject enables = new JSONObject();
     enables.put("class","isSufficientFor");
     enables.put("weight",0.9);
     enables.put("reverse",true);
     dependencyDefs.put("enables",enables);

     JSONObject requires = new JSONObject();
     requires.put("class","isRequiredBy");
     requires.put("weight",0.9);
     dependencyDefs.put("requires",requires);

     */
    public void initDefaultDefinitions() {
        PapDependencyDefinitionBase narrowsDepDef = new PapDependencyDefinitionBase(DEFAULT_NARROWS_BASE_CLASS, DEFAULT_NARROWS_REVERSE, DEFAULT_NARROWS_WEIGHT, DEFAULT_NARROWS_LEAK);
        PapDependencyDefinitionBase enablesDepDef = new PapDependencyDefinitionBase(DEFAULT_ENABLES_BASE_CLASS, DEFAULT_ENABLES_REVERSE, DEFAULT_ENABLES_WEIGHT, DEFAULT_ENABLES_LEAK);
        PapDependencyDefinitionBase requiresDepDef = new PapDependencyDefinitionBase(DEFAULT_REQUIRES_BASE_CLASS, DEFAULT_REQUIRES_REVERSE, DEFAULT_REQUIRES_WEIGHT, DEFAULT_REQUIRES_LEAK);
        addDependencyDefinition(DEFAULT_NARROWS_KEY,narrowsDepDef);
        addDependencyDefinition(DEFAULT_ENABLES_KEY,enablesDepDef);
        addDependencyDefinition(DEFAULT_REQUIRES_KEY,requiresDepDef);
    }

    public Double getWeightForType(String depType) {
        PapDependencyDefinitionBase base = dependencyDefinitionMap.$get(depType);
        if (base == null) return DEFAULT_WEIGHT;
        else return base.getWeight();
    }

    public Double getLeakForType(String depType) {
        PapDependencyDefinitionBase base = dependencyDefinitionMap.$get(depType);
        if (base == null) return DEFAULT_LEAK;
        else return base.getLeak();
    }

    public boolean getReverseForType(String depType) {
        PapDependencyDefinitionBase base = dependencyDefinitionMap.$get(depType);
        if (base == null) return DEFAULT_REVERSE;
        else return base.getReverse();
    }

    public void addDependencyDefinition(String relationshipName, PapDependencyDefinitionBase definition) {
        getDependencyDefinitionMap().$put(relationshipName,definition);
    }

    public Map<String, PapDependencyDefinitionBase> getDependencyDefinitionMap() {return dependencyDefinitionMap;}
    public void setDependencyDefinitionMap(Map<String, PapDependencyDefinitionBase> dependencyDefinitionMap) {this.dependencyDefinitionMap = dependencyDefinitionMap;}
}
