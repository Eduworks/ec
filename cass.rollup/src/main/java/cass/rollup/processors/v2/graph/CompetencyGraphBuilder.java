package cass.rollup.processors.v2.graph;

import com.eduworks.ec.crypto.EcPk;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcFramework;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;

public class CompetencyGraphBuilder {

	private static final int SIZE_OF_ASSERTION_QUERY = 5000;

	public Callback1<CompetencyGraph> success;
	public Callback1<ExceptionReturn> failure;
	public boolean includeAssertions = true;
	public String frameworkId;
	public String rootCompetencyId;
	public Array<EcRepository> repositories;
	public Array<EcPk> subjects;

	private boolean createImpliedEdges = true;
	private CompetencyGraph competencyGraph;
	private Map<String, Array<EcAlignment>> frameworkRelationMap;
	private Array<EcAlignment> frameworkRelationList;
	private Array<EcAssertion> assertionList;
	private Map<String, SimpleAssertion> assertionMap;

	private int relationshipsToProcess;
	private int relationshipsProcessed;

	private int repositoriesToQuery;
	private int repostioriesQueried;

	private int assertionsToFillIn;
	private int assertionsFilledIn;

	public CompetencyGraphBuilder() {
		repositories = new Array<EcRepository>();
		subjects = new Array<EcPk>();
	}

	private Array<EcAlignment> getRelationsForCompetency(String competencyId) {
		Array<EcAlignment> competencyRelations = frameworkRelationMap.$get(competencyId);
		if (competencyRelations == null) {
			competencyRelations = new Array<EcAlignment>();
			frameworkRelationMap.$put(competencyId, competencyRelations);
		}
		return competencyRelations;
	}

	private void addRelationToCompetencyMap(String competencyId, EcAlignment relation) {
		Array<EcAlignment> competencyRelations;
		competencyRelations = getRelationsForCompetency(competencyId);
		competencyRelations.push(relation);
		frameworkRelationMap.$put(competencyId, competencyRelations);
	}

	private void buildFrameworkRelationsMap() {
		EcAlignment relation;
		for (int i = 0; i < frameworkRelationList.$length(); i++) {
			relation = frameworkRelationList.$get(i);
			addRelationToCompetencyMap(relation.source, relation);
			addRelationToCompetencyMap(relation.target, relation);
		}
	}

	private void addCompetencyTreeToGraph(String competencyId) {
		competencyGraph.addNode(competencyId);
		Array<EcAlignment> competencyRelations = frameworkRelationMap.$get(competencyId);
		if (competencyRelations != null && competencyRelations.$length() > 0) {
			EcAlignment relation;
			for (int i = 0; i < competencyRelations.$length(); i++) {
				relation = competencyRelations.$get(i);
				if (!competencyGraph.graphContainsEdge(relation.source, relation.target, relation.relationType)) {
					competencyGraph.addEdge(relation.source, relation.target, relation.relationType);
				}
				if (!competencyGraph.graphContainsNode(relation.target)) {
					addCompetencyTreeToGraph(relation.target);
				}
				if (!competencyGraph.graphContainsNode(relation.source)) {
					addCompetencyTreeToGraph(relation.source);
				}
			}
		}
	}

	private void returnGraph() {
		success.$invoke(competencyGraph);
	}

	private void addAssertionsToGraph() {
		SimpleAssertion sa;
		EcAssertion a;
		for (int i = 0; i < assertionList.$length(); i++) {
			a = assertionList.$get(i);
			sa = assertionMap.$get(a.id);
			if (sa != null) {
				if (sa.isNegative()) competencyGraph.addNegativeAssertion(sa);
				else competencyGraph.addPositiveAssertion(sa);
			}
		}
	}

	private void checkAssertionDetailsFetched() {
		if (assertionsFilledIn >= assertionsToFillIn) {
			addAssertionsToGraph();
			returnGraph();
		}
	}

	private void fetchAssertionDetailsNegativeStatus(final EcAssertion a, final SimpleAssertion sa) {
		final CompetencyGraphBuilder cgb = this;
		a.getNegativeAsync(
				new Callback1<Boolean>() {
					@Override
					public void $invoke(Boolean negative) {
						if (negative != null && negative) sa.setNegative(true);
						else sa.setNegative(false);
						cgb.assertionMap.$put(sa.getId(), sa);
						cgb.assertionsFilledIn++;
						cgb.checkAssertionDetailsFetched();
					}
				},
				new Callback1<String>() {
					@Override
					public void $invoke(String s) {
						sa.setNegative(false);
						cgb.assertionMap.$put(sa.getId(), sa);
						cgb.assertionsFilledIn++;
						cgb.checkAssertionDetailsFetched();
					}
				});
	}

	private void fetchAssertionDetailsExpirationDate(final EcAssertion a, final SimpleAssertion sa) {
		final CompetencyGraphBuilder cgb = this;
		a.getExpirationDateAsync(
				new Callback1<Long>() {
					@Override
					public void $invoke(Long expirationDate) {
						//null expiration date or expired assertion
						if (expirationDate == null || expirationDate <= (long) new Date().getTime()) {
							cgb.assertionsFilledIn++;
							cgb.checkAssertionDetailsFetched();
						} else {
							sa.setExpirationDate(expirationDate);
							cgb.fetchAssertionDetailsNegativeStatus(a, sa);
						}
					}
				},
				new Callback1<String>() {
					@Override
					public void $invoke(String s) {
						cgb.failure.$invoke(new ExceptionReturn("Failed fetchAssertionDetailsExpirationDate: " + s));
					}
				});
	}

	private void fetchAssertionDetailsAssertionDate(final EcAssertion a, final SimpleAssertion sa) {
		final CompetencyGraphBuilder cgb = this;
		a.getAssertionDateAsync(
				new Callback1<Long>() {
					@Override
					public void $invoke(Long assertionDate) {
						//null assertion date or future assertion
						if (assertionDate == null || assertionDate > (long) new Date().getTime()) {
							cgb.assertionsFilledIn++;
							cgb.checkAssertionDetailsFetched();
						} else {
							sa.setAssertionDate(assertionDate);
							cgb.fetchAssertionDetailsExpirationDate(a, sa);
						}
					}
				},
				new Callback1<String>() {
					@Override
					public void $invoke(String s) {
						cgb.failure.$invoke(new ExceptionReturn("Failed fetchAssertionDetailsAssertionDate: " + s));
					}
				});
	}

	private boolean isASubject(EcPk pk) {
		if (subjects == null || subjects.$length() == 0) return true;
		EcPk sub;
		for (int i = 0; i < subjects.$length(); i++) {
			sub = subjects.$get(i);
			if (sub.toPem().trim() == pk.toPem().trim()) return true;
		}
		return false;
	}

	private void fetchAssertionDetailsSubject(final EcAssertion a, final SimpleAssertion sa) {
		final CompetencyGraphBuilder cgb = this;
		a.getSubjectAsync(
				new Callback1<EcPk>() {
					@Override
					public void $invoke(EcPk sub) {
						//if assertion subject is null or assertion subject is not a requested subject
						if (sub == null || !cgb.isASubject(sub)) {
							cgb.assertionsFilledIn++;
							cgb.checkAssertionDetailsFetched();
						} else {
							sa.setSubjectPem(sub.toPem());
							cgb.fetchAssertionDetailsAssertionDate(a, sa);
						}
					}
				},
				new Callback1<String>() {
					@Override
					public void $invoke(String s) {
						cgb.failure.$invoke(new ExceptionReturn("Failed fetchAssertionDetailsSubject: " + s));
					}
				});
	}

	private void fillInAssertions() {
		assertionsToFillIn = assertionList.$length();
		assertionsFilledIn = 0;
		if (assertionsToFillIn == 0) returnGraph();
		EcAssertion a;
		SimpleAssertion sa;
		for (int i = 0; i < assertionList.$length(); i++) {
			a = assertionList.$get(i);
			sa = new SimpleAssertion(a.id, a.competency, a.confidence);
			fetchAssertionDetailsSubject(a, sa);
		}
	}

	private void checkNumberOfReposQueried() {
		if (repostioriesQueried >= repositoriesToQuery) {
			fillInAssertions();
		}
	}

	private void addAssertionsToList(Array<EcAssertion> repoAssertions) {
		for (int i = 0; i < repoAssertions.$length(); i++) {
			assertionList.push(repoAssertions.$get(i));
		}
		repostioriesQueried++;
	}

	private String buildAssertionSearchQuery() {
		String query = "(";
		for (int i = 0; i < competencyGraph.getNodes().$length(); i++) {
			if (i != 0) query += " OR ";
			query += "competency:\"" + competencyGraph.getNodes().$get(i) + "\"";
		}
		query += ")";
		if (subjects != null) {
			for (int i = 0; i < subjects.$length(); i++) {
				query += " AND (\\*reader:\"" + subjects.$get(i).toPem() + "\")";
			}
		}
		return query;
	}

	private void processCompetencyAssertions() {
		repositoriesToQuery = repositories.$length();
		repostioriesQueried = 0;
		EcRepository currentRepository;
		Object params = new Object();
		JSObjectAdapter.$put(params, "size", SIZE_OF_ASSERTION_QUERY);
		String searchQuery = buildAssertionSearchQuery();
		final CompetencyGraphBuilder cgb = this;
		for (int i = 0; i < repositories.$length(); i++) {
			currentRepository = repositories.$get(i);
			EcAssertion.search(currentRepository, searchQuery,
					new Callback1<Array<EcAssertion>>() {
						@Override
						public void $invoke(Array<EcAssertion> assertions) {
							cgb.addAssertionsToList(assertions);
							cgb.checkNumberOfReposQueried();
						}
					},
					new Callback1<String>() {
						@Override
						public void $invoke(String s) {
							cgb.failure.$invoke(new ExceptionReturn("Error fetching assertions: " + s));
						}
					},
					params);
		}
	}

	private void assembleGraphComponents() {
		try {
			buildFrameworkRelationsMap();
			addCompetencyTreeToGraph(rootCompetencyId);
			if (createImpliedEdges) competencyGraph.createImpliedRelationships();
			if (includeAssertions) processCompetencyAssertions();
			else returnGraph();
		} catch (Exception e) {
			failure.$invoke(new ExceptionReturn("Exception buildAndReturnCompetencyGraph: " + e.toString()));
		}
	}

	private void checkNumberOfRelationsProcessed() {
		if (relationshipsProcessed >= relationshipsToProcess) {
			assembleGraphComponents();
		}
	}

	private void addRelationshipToList(EcAlignment a) {
		frameworkRelationList.push(a);
		relationshipsProcessed++;
	}

	private void fetchFrameworkRelations(EcFramework f) {
		relationshipsToProcess = f.relation.$length();
		relationshipsProcessed = 0;
		final CompetencyGraphBuilder cgb = this;
		if (relationshipsToProcess == 0) {
			competencyGraph.addNode(rootCompetencyId);
			success.$invoke(competencyGraph);
		} else {
			for (int i = 0; i < relationshipsToProcess; i++) {
				EcAlignment.get(f.relation.$get(i),
						new Callback1<EcAlignment>() {
							@Override
							public void $invoke(EcAlignment a) {
								cgb.addRelationshipToList(a);
								cgb.checkNumberOfRelationsProcessed();
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

	private void fetchFrameworkAndGo() {
		final CompetencyGraphBuilder cgb = this;
		EcFramework.get(frameworkId,
				new Callback1<EcFramework>() {
					@Override
					public void $invoke(EcFramework f) {
						cgb.fetchFrameworkRelations(f);
					}
				},
				new Callback1<String>() {
					@Override
					public void $invoke(String s) {
						cgb.failure.$invoke(new ExceptionReturn("Error fetching framework(" + cgb.frameworkId + "): " + s));
					}
				});
	}

	private void validateInput() {
		if (includeAssertions && (repositories == null || repositories.$length() == 0)) {
			failure.$invoke(new ExceptionReturn("Assertion repository information not provided."));
		} else if (success == null) {
			failure.$invoke(new ExceptionReturn("Success callback required."));
		} else if (frameworkId == null) {
			failure.$invoke(new ExceptionReturn("Framework ID required."));
		} else if (rootCompetencyId == null) {
			failure.$invoke(new ExceptionReturn("Root Competency ID required."));
		}
	}

	private void initBuilder(boolean createImpliedEdges) {
		this.createImpliedEdges = createImpliedEdges;
		competencyGraph = new CompetencyGraph(includeAssertions);
		assertionMap = JSCollections.$map();
		frameworkRelationMap = JSCollections.$map();
		frameworkRelationList = new Array<EcAlignment>();
		assertionList = new Array<EcAssertion>();
	}

	//Added createImpliedEdges as a required parameter instead of a config item to force the consumer to acknowledge what is happening...
	public void buildCompetencyGraph(boolean createImpliedEdges) {
		validateInput();
		initBuilder(createImpliedEdges);
		fetchFrameworkAndGo();
	}

}
