package cass.rollup.processors.v2.graph;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcFramework;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;

public class CompetencyGraphBuilder {

    public Callback1<CompetencyGraph> success;
    public Callback1<ExceptionReturn> failure;
    public String frameworkId;
    public String rootCompetencyId;

    private boolean createImpliedEdges = true;
    private CompetencyGraph ngj;
    private Map<String,Array<EcAlignment>> frameworkRelationMap;
    private Array<EcAlignment> frameworkRelationList;

    private int relationshipsToProcess;
    private int relationshipsProcessed;

    public CompetencyGraphBuilder() {}


    private Array<EcAlignment> getRelationsForCompetency(String competencyId) {
        Array<EcAlignment> competencyRelations = frameworkRelationMap.$get(competencyId);
        if (competencyRelations == null) {
            competencyRelations = new Array<EcAlignment>();
            frameworkRelationMap.$put(competencyId,competencyRelations);
        }
        return competencyRelations;
    }

    private void addRelationToCompetencyMap(String competencyId, EcAlignment relation){
        Array<EcAlignment> competencyRelations;
        competencyRelations = getRelationsForCompetency(competencyId);
        competencyRelations.push(relation);
        frameworkRelationMap.$put(competencyId,competencyRelations);
    }

    private void buildFrameworkRelationsMap() {
        EcAlignment relation;
        for (int i=0;i<frameworkRelationList.$length();i++) {
            relation = frameworkRelationList.$get(i);
            addRelationToCompetencyMap(relation.source,relation);
            addRelationToCompetencyMap(relation.target,relation);
        }
    }

    private void addCompetencyTreeToGraph(String competencyId) {
        ngj.addNode(competencyId);
        Array<EcAlignment> competencyRelations = frameworkRelationMap.$get(competencyId);
        if (competencyRelations != null && competencyRelations.$length() > 0) {
            EcAlignment relation;
            for (int i = 0; i < competencyRelations.$length(); i++) {
                relation = competencyRelations.$get(i);
                if (!ngj.graphContainsEdge(relation.source, relation.target, relation.relationType)) {
                    ngj.addEdge(relation.source, relation.target, relation.relationType);
                }
                if (!ngj.graphContainsNode(relation.target)) {
                    addCompetencyTreeToGraph(relation.target);
                }
                if (!ngj.graphContainsNode(relation.source)) {
                    addCompetencyTreeToGraph(relation.source);
                }
            }
        }
    }

    private void buildAndReturnCompetencyGraph() {
        try {
            buildFrameworkRelationsMap();
            addCompetencyTreeToGraph(rootCompetencyId);
            if (createImpliedEdges) ngj.createImpliedEdges();
            success.$invoke(ngj);
        }
        catch (Exception e) {
            failure.$invoke(new ExceptionReturn("Exception buildAndReturnCompetencyGraph: " + e.toString()));
        }
    }

    private void checkNumberOfRelationsProcessed() {
        if (relationshipsProcessed >= relationshipsToProcess) {
            buildAndReturnCompetencyGraph();
        }
    }

    private void addRelationship(EcAlignment a) {
        frameworkRelationList.push(a);
        relationshipsProcessed++;
        checkNumberOfRelationsProcessed();
    }

    private void fetchFrameworkRelations(EcFramework f) {
        relationshipsToProcess = f.relation.$length();
        relationshipsProcessed = 0;
        final CompetencyGraphBuilder cgb = this;
        if (relationshipsToProcess == 0) {
            ngj.addNode(rootCompetencyId);
            success.$invoke(ngj);
        }
        else {
            for (int i = 0; i < relationshipsToProcess; i++) {
                EcAlignment.get(f.relation.$get(i),
                        new Callback1<EcAlignment>() {
                            @Override
                            public void $invoke(EcAlignment a) {
                                cgb.addRelationship(a);
                            }
                        },
                        new Callback1<String>() {
                            @Override
                            public void $invoke(String s) {
                                cgb.failure.$invoke(new ExceptionReturn("Error fetching relationship: " + s));
                            }
                        });
            }
        }
    }

    public void buildCompetencyGraph(boolean createImpliedEdges) {
        this.createImpliedEdges = createImpliedEdges;
        ngj = new CompetencyGraph();
        frameworkRelationMap = JSCollections.$map();
        frameworkRelationList = new Array<EcAlignment>();
        final CompetencyGraphBuilder cgb = this;
        EcFramework.get(frameworkId,
                new Callback1<EcFramework>()
                {
                    @Override
                    public void $invoke(EcFramework f) {
                        cgb.fetchFrameworkRelations(f);
                    }
                },
                new Callback1<String>()
                {
                    @Override
                    public void $invoke(String s) {
                        cgb.failure.$invoke(new ExceptionReturn("Error fetching framework(" + cgb.frameworkId + "): " + s));
                    }
                });
    }

}
