package cass.rollup.processors.predictor;

import cass.rollup.processors.v2.graph.CgEdge;
import cass.rollup.processors.v2.graph.CompetencyGraph;
import cass.rollup.processors.v2.graph.SimpleAssertion;
import org.stjs.javascript.*;
import org.stjs.javascript.Math;

public class PredictiveAssertionProcessor {

    private static final boolean LOG_ENABLED = false;

    private static final double ABRUBT_EXP_RETENTION = 0.0;
    private static final double DEFAULT_RETENTION = 1.0;
    private static final double STEP_SIZE_NUMERATOR = 1.0;
    private static final double INITIAL_VALUE = 0.0;
    private static final int INIT_PARENT_IDX_DEP_PARM = -1;
    private static final int INIT_CHILD_IDX_DEP_PARM = -1;
    private static final double INIT_WEIGHT_DEP_PARM = 0.0;
    private static final double INIT_LEAK_DEP_PARM = 0.0;
    private static final boolean INIT_REVERSE_DEP_PARM = false;
    private static final double DEFAULT_PROB_LEARN_UNMET_REQS = 0.0;
    private static final double DEFAULT_PROB_INSUFF = 0.0;
    private static final double DEFAULT_DISCOUNT = 1.0;

    private Map<String,Integer> competencyIndex;
    private Array<Double> values;
    private Map<String,Map<String,Array<PapDependency>>> dependencies;
    private Map<String,Array<PapAssertion>> assertions;
    private PapDependencyDefinitions dependencyDefs;
    private PapSettings settings;
    private CompetencyGraph inputGraph;
    private String subjectPem;
    private Long predictionDate;
    private PapCompetencyNetwork competencyNetwork;

    private double stepSize;
    private double priorityQueueThreshold;

    private PapNetworkPrediction competencePrediction;

    private void log(String s) {
        if (LOG_ENABLED) {
            Global.console.log(s);
        }
    }

    private void verifyDependencyDefs() {
        if (dependencyDefs == null) {
            dependencyDefs = new PapDependencyDefinitions();
            dependencyDefs.initDefaultDefinitions();
        }
    }

    private void processInputParameters(CompetencyGraph inputGraph, String subjectPem, Long predictionDate, PapDependencyDefinitions dependencyDefs, PapSettings settings) {
        this.dependencyDefs = dependencyDefs;
        verifyDependencyDefs();
        this.settings = settings;
        if (this.settings == null) this.settings = new PapSettings();
        this.inputGraph = inputGraph;
        this.subjectPem = subjectPem;
        if (this.subjectPem != null) this.subjectPem = this.subjectPem.trim();
        this.predictionDate = predictionDate;
        if (this.predictionDate == null) this.predictionDate = (long)(new Date()).getTime();
        stepSize = STEP_SIZE_NUMERATOR /this.settings.getIterations();
        priorityQueueThreshold = this.settings.getPriorityQueueThreshold()/this.settings.getIterations();
    }

    private void initDependenciesMap() {
        dependencies = JSCollections.$map();
        String type;
        for (int i=0; i< PapDependency.getDependencyTypes().$length();i++) {
            type = PapDependency.getDependencyTypes().$get(i);
            Map<String,Array<PapDependency>> dependencySubMap = JSCollections.$map();
            dependencies.$put(type,dependencySubMap);
        }
    }

    private void initAssertionsMap() {
        assertions = JSCollections.$map();
        for (int i = 0; i < inputGraph.getNodes().$length();i++) {
            assertions.$put(String.valueOf(i),new Array<PapAssertion>());
        }
    }

    private void buildValuesCompetencyIndexAndDependencies() {
        competencyIndex = JSCollections.$map();
        values = new Array<Double>();
        for (int i=0;i<inputGraph.getNodes().$length();i++){
            values.push(INITIAL_VALUE);
            competencyIndex.$put(inputGraph.getNodes().$get(i),i);
            String type;
            for (int j=0; j< PapDependency.getDependencyTypes().$length();j++) {
                type = PapDependency.getDependencyTypes().$get(j);
                dependencies.$get(type).$put(String.valueOf(i),new Array<PapDependency>());
            }
        }
    }

    private void initDataStructures() {
        initDependenciesMap();
        initAssertionsMap();
        buildValuesCompetencyIndexAndDependencies();
    }

    private PapDependencyParms getDefaultPapDependencyParms() {
        PapDependencyParms depParms = new PapDependencyParms();
        depParms.setType(PapDependency.NULL_TYPE);
        depParms.setParentIndex(INIT_PARENT_IDX_DEP_PARM);
        depParms.setChildIndex(INIT_CHILD_IDX_DEP_PARM);
        depParms.setWeight(INIT_WEIGHT_DEP_PARM);
        depParms.setLeak(INIT_LEAK_DEP_PARM);
        depParms.setReverse(INIT_REVERSE_DEP_PARM);
        return depParms;
    }

    private PapDependencyParms getDependencyParmsForEdge(CgEdge edge) {
        String depType = edge.getRelation();
        String depClass = dependencyDefs.getDependencyDefinitionMap().$get(depType).getDepClass();
        PapDependencyParms depParms = getDefaultPapDependencyParms();
        switch (depClass.toLowerCase()) {
            case "isrequiredby":
                depParms.setChildIndex(competencyIndex.$get(edge.getSource()));
                depParms.setParentIndex(competencyIndex.$get(edge.getTarget()));
                depParms.setType(PapDependency.NECESSARY_TYPE);
                depParms.setWeight(dependencyDefs.getWeightForType(depType));
                depParms.setLeak(dependencyDefs.getLeakForType(depType));
                depParms.setReverse(dependencyDefs.getReverseForType(depType));
                break;
            case "issufficientfor":
                depParms.setChildIndex(competencyIndex.$get(edge.getSource()));
                depParms.setParentIndex(competencyIndex.$get(edge.getTarget()));
                depParms.setType(PapDependency.SUFFICIENT_TYPE);
                depParms.setWeight(dependencyDefs.getWeightForType(depType));
                depParms.setLeak(dependencyDefs.getLeakForType(depType));
                depParms.setReverse(dependencyDefs.getReverseForType(depType));
                break;
            case "isequivalentto":
                depParms.setParentIndex(competencyIndex.$get(edge.getSource()));
                depParms.setChildIndex(competencyIndex.$get(edge.getTarget()));
                depParms.setType(PapDependency.EQUIVALENCE_TYPE);
                depParms.setWeight(dependencyDefs.getWeightForType(depType));
                break;
            case "broadens":
                depParms.setParentIndex(competencyIndex.$get(edge.getSource()));
                depParms.setChildIndex(competencyIndex.$get(edge.getTarget()));
                depParms.setType(PapDependency.BROADENS_TYPE);
                depParms.setWeight(dependencyDefs.getWeightForType(depType));
                depParms.setReverse(dependencyDefs.getReverseForType(depType));
                break;
        }
        return depParms;
    }

    private boolean dependencyExists(String type, String index, PapDependency dependency) {
        Array<PapDependency> dependencyArray = dependencies.$get(type).$get(index);
        if (dependencyArray == null) {
            //this shouldn't happen
            return true;
        }
        PapDependency currentDep;
        for (int i=0;i<dependencyArray.$length();i++) {
            currentDep = dependencyArray.$get(i);
            if (currentDep.equals(dependency)) return true;
        }
        return false;
    }

    private void processEdges() {
        for (int i=0;i<inputGraph.getEdges().$length();i++) {
            CgEdge edge = inputGraph.getEdges().$get(i);
            PapDependencyParms depParms = getDependencyParmsForEdge(edge);
            PapDependency newDep;
            if (PapDependency.EQUIVALENCE_TYPE.equals(depParms.getType())) {
                depParms.setDependencyFirst(true);
                // This type of dependency is symmetric, so we add 2 dependencies to the network (one for each node).
                newDep = new PapDependency(depParms);
                if (!dependencyExists(depParms.getType(),String.valueOf(depParms.getParentIndex()),newDep)) {
                    dependencies.$get(depParms.getType()).$get(String.valueOf(depParms.getParentIndex())).push(newDep);
                }
                depParms.swapParentChildIndexes();
                newDep = new PapDependency(depParms);
                if (!dependencyExists(depParms.getType(),String.valueOf(depParms.getParentIndex()),newDep)) {
                    dependencies.$get(depParms.getType()).$get(String.valueOf(depParms.getParentIndex())).push(newDep);
                }
            }
            else if (edge.getRelation() != null && edge.getRelation().trim().length() > 0){
                depParms.setDependencyFirst(!depParms.getReverse());
                newDep = new PapDependency(depParms);
                if (!dependencyExists(depParms.getType(),String.valueOf(depParms.getParentIndex()),newDep)) {
                    dependencies.$get(depParms.getType()).$get(String.valueOf(depParms.getParentIndex())).push(newDep);
                }
            }
        }
    }

    private void addAssertions(Array<SimpleAssertion> assertionList) {
        SimpleAssertion sa;
        PapAssertion pa;
        for (int i=0;i<assertionList.$length();i++) {
            sa = assertionList.$get(i);
            if (sa.getAssertionDate() <= predictionDate && ((!settings.getAbruptExpiration()) || predictionDate <= sa.getExpirationDate())) {
                Integer index = competencyIndex.$get(sa.getCompetencyId());
                pa = new PapAssertion(sa.getConfidence(),index,sa.getAssertionDate(),sa.getExpirationDate(),!sa.isNegative());
                assertions.$get(String.valueOf(index)).push(pa);
            }
        }
    }

    private void processAssertions() {
        if (subjectPem == null || subjectPem.length() <= 0) {
            addAssertions(inputGraph.getNegativeAssertions());
            addAssertions(inputGraph.getPositiveAssertions());
        }
        else {
            SimpleAssertion sa;
            Array<SimpleAssertion> matchingAssertionList = new Array<SimpleAssertion>();
            for (int i=0;i<inputGraph.getNegativeAssertions().$length();i++) {
                sa = inputGraph.getNegativeAssertions().$get(i);
                if (subjectPem.equals(sa.getSubjectPem())) matchingAssertionList.push(sa);
            }
            addAssertions(matchingAssertionList);
            //Verfied with Robbie(Waffles)that the array is supposed to be emptied here
            matchingAssertionList = new Array<SimpleAssertion>();
            for (int i=0;i<inputGraph.getPositiveAssertions().$length();i++) {
                sa = inputGraph.getPositiveAssertions().$get(i);
                if (subjectPem.equals(sa.getSubjectPem())) matchingAssertionList.push(sa);
            }
            addAssertions(matchingAssertionList);
        }
    }

    private double getTimeFactor(Long assertionDate, Long expirationDate) {
        long range = expirationDate - assertionDate;
        long timeUntilPrediction = predictionDate - assertionDate;
        double rate = ((double) timeUntilPrediction)/range;
        return rate;
    }

    private double getRetention(Long assertionDate, Long expirationDate) {
        if (settings.getAbruptExpiration() && predictionDate >(expirationDate)) return ABRUBT_EXP_RETENTION;
        else {
            if (settings.getGradualForgetting()) {
                double factor = getTimeFactor(assertionDate, expirationDate);
                return Math.exp(-factor);
            }
            else return DEFAULT_RETENTION;
        }
    }

    private void addAssertionsToUpdateQueue(Array<PapUpdate> updateQueue) {
        Array<PapAssertion> assertionList;
        PapAssertion assertion;
        double val;
        for (int i=0; i < inputGraph.getNodes().$length();i++) {
            assertionList = assertions.$get(String.valueOf(i));
            for (int j=0; j<assertionList.$length(); j++) {
                assertion = assertionList.$get(j);
                val = stepSize * assertion.getConfidence() * settings.getEvidenceWeight() * getRetention(assertion.getAssertionDate(),assertion.getExpirationDate());
                if (val > priorityQueueThreshold) {
                    updateQueue.push(new PapUpdate(assertion.getCompetencyIndex(),val,assertion.getResult()));
                }
            }
        }
    }

    private void processNecessaryNetworkDependencies(PapUpdate update, Array<PapUpdate> updateQueue) {
        Array<PapDependency> updateDependencies = competencyNetwork.getDependencies().$get(PapDependency.NECESSARY_TYPE).$get(String.valueOf(update.getIndex()));
        if (updateDependencies != null ) {
            double probabilityLearnUnmetRequirements = DEFAULT_PROB_LEARN_UNMET_REQS;
            if (updateDependencies.$length() > 0) {
                probabilityLearnUnmetRequirements = updateDependencies.$get(0).getLeak();
            }
            double totalRes = (1 - probabilityLearnUnmetRequirements);
            PapDependency dep;
            for (int i = 0; i < updateDependencies.$length(); i++) {
                dep = updateDependencies.$get(i);
                totalRes *= (1 - dep.getWeight() * competencyNetwork.getActivations().$get(dep.getChildIndex()));
            }
            double gradient;
            for (int i = 0; i < updateDependencies.$length(); i++) {
                dep = updateDependencies.$get(i);
                if (!update.hasVisited(dep.getChildIndex())) {
                    gradient = update.getChange() * totalRes / (1 - dep.getWeight() * competencyNetwork.getActivations().$get(dep.getChildIndex())) * dep.getWeight() * settings.getDiscount();
                    if (gradient > priorityQueueThreshold) {
                        updateQueue.push(update.updateChild(dep.getChildIndex(), gradient));
                    }
                }
            }
        }
    }

    private void processSufficientNetworkDependencies(PapUpdate update, Array<PapUpdate> updateQueue) {
        Array<PapDependency> updateDependencies = competencyNetwork.getDependencies().$get(PapDependency.SUFFICIENT_TYPE).$get(String.valueOf(update.getIndex()));
        if (updateDependencies != null ) {
            double probabilityInsufficient = DEFAULT_PROB_INSUFF;
            if (updateDependencies.$length() > 0) {
                probabilityInsufficient = updateDependencies.$get(0).getLeak();
            }
            double totalRes = (1 - probabilityInsufficient);
            PapDependency dep;
            for (int i = 0; i < updateDependencies.$length(); i++) {
                dep = updateDependencies.$get(i);
                totalRes *= (1.0 - (1.0 - competencyNetwork.getActivations().$get(dep.getChildIndex())) * dep.getWeight());
            }
            double gradient;
            for (int i = 0; i < updateDependencies.$length(); i++) {
                dep = updateDependencies.$get(i);
                if (!update.hasVisited(dep.getChildIndex())) {
                    gradient = update.getChange() * (1.0 - totalRes / (1.0 - dep.getWeight() * (1.0 - competencyNetwork.getActivations().$get(dep.getChildIndex())))) * settings.getDiscount();
                    if (gradient > priorityQueueThreshold) {
                        updateQueue.push(update.updateChild(dep.getChildIndex(), gradient));
                    }
                }
            }
        }
    }

    private void processEquivalenceNetworkDependencies(PapUpdate update, Array<PapUpdate> updateQueue) {
        Array<PapDependency> updateDependencies = competencyNetwork.getDependencies().$get(PapDependency.EQUIVALENCE_TYPE).$get(String.valueOf(update.getIndex()));
        if (updateDependencies != null) {
            PapDependency dep;
            double gradient;
            for (int i = 0; i < updateDependencies.$length(); i++) {
                dep = updateDependencies.$get(i);
                if (!update.hasVisited(dep.getChildIndex())) {
                    gradient = update.getChange() * dep.getWeight() * settings.getDiscount();
                    if (Math.abs(gradient) > priorityQueueThreshold) {
                        updateQueue.push(update.updateChild(dep.getChildIndex(), gradient));
                    }
                }
            }
        }
    }

    private void processBroadensNetworkDependencies(PapUpdate update, Array<PapUpdate> updateQueue) {
        Array<PapDependency> updateDependencies = competencyNetwork.getDependencies().$get(PapDependency.BROADENS_TYPE).$get(String.valueOf(update.getIndex()));
        if (updateDependencies != null) {
            PapDependency dep;
            double gradient;
            for (int i = 0; i < updateDependencies.$length(); i++) {
                dep = updateDependencies.$get(i);
                if (!update.hasVisited(dep.getChildIndex())) {
                    gradient = update.getChange() * settings.getDiscount() * dep.getWeight();
                    if (gradient > priorityQueueThreshold) {
                        updateQueue.push(update.updateChild(dep.getChildIndex(), gradient));
                    }
                }
            }
        }
    }

    private void predictCompetence() {
        competencyNetwork = new PapCompetencyNetwork(dependencies,inputGraph.getNodes().$length(),settings);
        Array<PapUpdate> updateQueue;
        PapUpdate currentUpdate;
        for (int iteration = 0; iteration < settings.getIterations(); iteration++) {
            updateQueue = new Array<PapUpdate>();
            addAssertionsToUpdateQueue(updateQueue);
            while (updateQueue.$length() > 0) {
                currentUpdate = updateQueue.pop();
                competencyNetwork.update(currentUpdate.getIndex(),currentUpdate.getChange(),currentUpdate.getPositive());
                processNecessaryNetworkDependencies(currentUpdate,updateQueue);
                processSufficientNetworkDependencies(currentUpdate,updateQueue);
                processEquivalenceNetworkDependencies(currentUpdate,updateQueue);
                processBroadensNetworkDependencies(currentUpdate,updateQueue);
            }
        }
    }

    //There are better ways to do this but I wanted to have this here in case we decide to do something different with it...
    private void buildCompetencePrediction() {
        competencePrediction = new PapNetworkPrediction(predictionDate,subjectPem,inputGraph.getNodes(),competencyNetwork);
    }

    public PapNetworkPrediction predictAll(CompetencyGraph inputGraph, String subjectPem, Long predictionDate, PapDependencyDefinitions dependencyDefs, PapSettings settings) {
        processInputParameters(inputGraph,subjectPem,predictionDate,dependencyDefs,settings);
        initDataStructures();
        processEdges();
        processAssertions();
        predictCompetence();
        buildCompetencePrediction();
        return competencePrediction;
    }

}
