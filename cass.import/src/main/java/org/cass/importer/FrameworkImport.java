package org.cass.importer;

import com.eduworks.ec.task.Task;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Importer methods to copy or link to competencies that already
 * exist in another framework in a CASS instance.
 *
 * @author devlin.junker@eduworks.com
 * @module org.cassproject
 * @class FrameworkImport
 * @static
 * @extends Importer
 */
public class FrameworkImport {

	public static int savedComp;
	public static int savedRel;

	public static EcFramework targetUsable;

	static Array<EcCompetency> competencies;

	static Array<EcAlignment> relations;

	static Map<String, String> compMap;

	/**
	 * Copies or links competencies that exist in one framework in a CASS instance,
	 * to another different framework in the same CASS instance.
	 *
	 * @param {EcFramework}                    source
	 *                                         Framework to copy or link the competencies from
	 * @param {EcFramework}                    target
	 *                                         Framework to add the copied or linked competencies to
	 * @param {boolean}                        copy
	 *                                         Flag indicating whether or not to copy or link the competencies in the source framework
	 * @param {String}                         serverUrl
	 *                                         URL Prefix for the created competencies if copied
	 * @param {EcIdentity}                     owner
	 *                                         EcIdentity that will own the created competencies if copied
	 * @param {Callback1<Array<EcCompetency>>} success
	 *                                         Callback triggered after succesfully copying or linking all of the competencies,
	 *                                         returns an array of the new or linked competencies
	 * @param {Callback1<Object>}              [failure]
	 *                                         Callback triggered if an error occurred while creating the competencies
	 * @memberOf FrameworkImport
	 * @method importCompetencies
	 * @static
	 */
	public static void importCompetencies(final EcFramework source, final EcFramework target, boolean copy,
	                                      final String serverUrl, final EcIdentity owner,
	                                      final Callback2<Array<EcCompetency>, Array<EcAlignment>> success, final Callback1<Object> failure, final EcRepository repo) {

		if (source == null) {
			failure.$invoke("Source Framework not set");
			return;
		}

		if (target == null) {
			failure.$invoke("Target Framework not Set");
			return;
		}
		targetUsable = target;

		if (source.competency == null || source.competency.$length() == 0) {
			failure.$invoke("Source Has No Competencies");
			return;
		}

		competencies = JSCollections.$array();
		relations = JSCollections.$array();
		if (copy) {
			compMap = JSCollections.$map();
			savedComp = 0;
			savedRel = 0;

			for (int i = 0; i < source.competency.$length(); i++) {
				String id = source.competency.$get(i);

				EcCompetency.get(id, new Callback1<EcCompetency>() {
					public void $invoke(EcCompetency comp) {
						final EcCompetency competency = new EcCompetency();
						competency.copyFrom(comp);

						if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
							competency.generateId(serverUrl);
						else
							competency.generateShortId(serverUrl);

						compMap.$put(comp.shortId(), competency.shortId());

						if (owner != null)
							competency.addOwner(owner.ppk.toPk());

						final String id = competency.id;
						Task.asyncImmediate(new Callback1() {
							@Override
							public void $invoke(Object o) {
								final Callback0 keepGoing = (Callback0) o;
								competency.save(new Callback1<String>() {
									public void $invoke(String str) {
										savedComp++;
										targetUsable.addCompetency(id);

										if (savedComp == competencies.$length()) {

											targetUsable.save(new Callback1<String>() {
												@Override
												public void $invoke(String p1) {
													for (int i = 0; i < source.relation.$length(); i++) {
														String id = source.relation.$get(i);

														EcAlignment.get(id, new Callback1<EcAlignment>() {
															public void $invoke(EcAlignment rel) {
																final EcAlignment relation = new EcAlignment();
																relation.copyFrom(rel);

																if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
																	relation.generateId(serverUrl);
																else
																	relation.generateShortId(serverUrl);

																relation.source = compMap.$get(rel.source);
																relation.target = compMap.$get(rel.target);

																if (owner != null)
																	relation.addOwner(owner.ppk.toPk());

																final String id = relation.id;
																Task.asyncImmediate(new Callback1() {
																	@Override
																	public void $invoke(Object o) {
																		final Callback0 keepGoing2 = (Callback0) o;
																		relation.save(new Callback1<String>() {
																			public void $invoke(String str) {
																				savedRel++;
																				targetUsable.addRelation(id);

																				if (savedRel == relations.$length()) {

																					targetUsable.save(new Callback1<String>() {
																						@Override
																						public void $invoke(String p1) {


																							success.$invoke(competencies, relations);
																						}
																					}, new Callback1<String>() {
																						@Override
																						public void $invoke(String p1) {
																							failure.$invoke(p1);
																						}
																					},repo);
																				}
																				keepGoing2.$invoke();
																			}
																		}, new Callback1<String>() {
																			public void $invoke(String str) {
																				failure.$invoke("Trouble Saving Copied Competency");
																				keepGoing2.$invoke();
																			}
																		},repo);
																	}
																});

																relations.push(relation);
															}
														}, new Callback1<String>() {
															public void $invoke(String str) {
																failure.$invoke(str);
															}
														});

													}
												}
											}, new Callback1<String>() {
												@Override
												public void $invoke(String p1) {
													failure.$invoke(p1);
												}
											},repo);
										}
										keepGoing.$invoke();
									}
								}, new Callback1<String>() {
									public void $invoke(String str) {
										failure.$invoke("Trouble Saving Copied Competency");
										keepGoing.$invoke();
									}
								},repo);
							}
						});

						competencies.push(competency);
					}
				}, new Callback1<String>() {
					public void $invoke(String str) {
						failure.$invoke(str);
					}
				});

			}

		} else {
			for (int i = 0; i < source.competency.$length(); i++) {
				if (target.competency == null || (target.competency.indexOf(source.competency.$get(i)) == -1
						&& target.competency.indexOf(EcRemoteLinkedData.trimVersionFromUrl(source.competency.$get(i))) == -1)) {
					EcCompetency.get(source.competency.$get(i), new Callback1<EcCompetency>() {
						@Override
						public void $invoke(EcCompetency comp) {
							competencies.push(comp);

							targetUsable.addCompetency(comp.id);

							if (competencies.$length() == source.competency.$length()) {
								JSObjectAdapter.$properties(targetUsable).$delete("competencyObjects");
								targetUsable.save(new Callback1<String>() {
									@Override
									public void $invoke(String p1) {
										for (int i = 0; i < source.relation.$length(); i++) {
											if (target.relation == null || (target.relation.indexOf(source.relation.$get(i)) == -1
													&& target.relation.indexOf(EcRemoteLinkedData.trimVersionFromUrl(source.competency.$get(i))) == -1)) {
												EcAlignment.get(source.relation.$get(i), new Callback1<EcAlignment>() {
													@Override
													public void $invoke(EcAlignment relation) {
														relations.push(relation);

														targetUsable.addRelation(relation.id);

														if (relations.$length() == source.relation.$length()) {
															JSObjectAdapter.$properties(targetUsable).$delete("competencyObjects");
															Task.asyncImmediate(new Callback1() {
																@Override
																public void $invoke(Object o) {
																	final Callback0 keepGoing = (Callback0) o;
																	targetUsable.save(new Callback1<String>() {
																		@Override
																		public void $invoke(String p1) {
																			success.$invoke(competencies, relations);
																			keepGoing.$invoke();
																		}
																	}, new Callback1<String>() {
																		@Override
																		public void $invoke(String p1) {
																			failure.$invoke(p1);
																			keepGoing.$invoke();
																		}
																	},repo);
																}
															});
														}
													}
												}, new Callback1<String>() {
													@Override
													public void $invoke(String p1) {
														failure.$invoke(p1);
													}
												});
											}
										}
									}
								}, new Callback1<String>() {
									@Override
									public void $invoke(String p1) {
										failure.$invoke(p1);
									}
								},repo);
							}
						}
					}, new Callback1<String>() {
						@Override
						public void $invoke(String p1) {
							failure.$invoke(p1);
						}
					});
				}
			}


		}
	}
}
