package org.cass.importer;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.crypto.EcPpk;
import js.Papa;
import js.PapaParseParams;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Relation;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Callback3;

import static org.stjs.javascript.JSGlobal.typeof;

public class CTDLASNCSVImport {

	public static void analyzeFile(Object file, final Callback2<Integer, Integer> success, final Callback1<Object> failure) {

		if (file == null) {
			failure.$invoke("No file to analyze");
			return;
		}

		if (JSObjectAdapter.$get(file, "name") == null) {
			failure.$invoke("Invalid file");
		} else if (!((String) JSObjectAdapter.$get(file, "name")).endsWith(".csv")) {
			failure.$invoke("Invalid file type");
		}

		Papa.parse(file, new PapaParseParams() {
			{
				encoding = "UTF-8";
				complete = new Callback1<Object>() {
					@Override
					public void $invoke(Object results) {
						Array<Array<String>> tabularData = (Array<Array<String>>) JSObjectAdapter.$get(results, "data");

						Array<String> colNames = tabularData.$get(0);

						Object nameToCol = new Object();
						for (int i = 0; i < colNames.$length(); i++)
							JSObjectAdapter.$put(nameToCol, colNames.$get(i), i);

						int frameworkCounter = 0;
						int competencyCounter = 0;
						Integer typeCol = (Integer) JSObjectAdapter.$get(nameToCol, "@type");
						if (typeCol == null) {
							error.$invoke("No @type in CSV.");
							return;
						}
						for (int i = 0; i < tabularData.$length(); i++) {
							if (i == 0) continue;
							Array<String> col = tabularData.$get(i);
							if (col.$get(typeCol) != null && col.$get(typeCol).trim() == "ceasn:CompetencyFramework")
								frameworkCounter++;
							else if (col.$get(typeCol) != null && col.$get(typeCol).trim() == "ceasn:Competency")
								competencyCounter++;
							else if (col.$get(typeCol) == null || col.$get(typeCol) == "")
								continue;
							else {
								error.$invoke("Found unknown type:" + col.$get(typeCol));
								return;
							}
						}
						success.$invoke(frameworkCounter, competencyCounter);
					}
				};
				error = failure;
			}
		});
	}

	public static void importFrameworksAndCompetencies(final EcRepository repo, Object file, final Callback3<Array<EcFramework>, Array<EcCompetency>, Array<EcAlignment>> success, final Callback1<Object> failure, final EcIdentity ceo) {

		if (file == null) {
			failure.$invoke("No file to analyze");
			return;
		}

		if (JSObjectAdapter.$get(file, "name") == null) {
			failure.$invoke("Invalid file");
		} else if (!((String) JSObjectAdapter.$get(file, "name")).endsWith(".csv")) {
			failure.$invoke("Invalid file type");
		}

		Papa.parse(file, new PapaParseParams() {
			{
				header = true;
				encoding = "UTF-8";
				complete = new Callback1<Object>() {
					@Override
					public void $invoke(Object results) {
						Array<Object> tabularData = (Array<Object>) JSObjectAdapter.$get(results, "data");

						final Object frameworks = new Object();
						final Array frameworkArray = new Array<EcFramework>();
						final Object frameworkRows = new Object();
						final Array competencies = new Array<EcCompetency>();
						final Object competencyRows = new Object();
						final Array relations = new Array<EcAlignment>();
						final Object relationById = new Object();
						new EcAsyncHelper<Object>().each(tabularData, new Callback2<Object, Callback0>() {
							@Override
							public void $invoke(final Object pretranslatedE, final Callback0 callback0) {
								if (JSObjectAdapter.$get(pretranslatedE, "@type") == "ceasn:CompetencyFramework") {
									EcLinkedData translator = new EcLinkedData(null, null);
									translator.copyFrom(pretranslatedE);
									cleanUpTranslator(translator);

									translator.recast("https://schema.cassproject.org/0.4/ceasn2cass", "https://schema.cassproject.org/0.4", new Callback1<EcLinkedData>() {
										@Override
										public void $invoke(EcLinkedData e) {
											EcFramework f = new EcFramework();
											f.copyFrom(e);
											if (JSObjectAdapter.$get(e, "owner") != null) {
												EcIdentity id = new EcIdentity();
												id.ppk = EcPpk.fromPem((String) JSObjectAdapter.$get(e, "owner"));
												f.addOwner(id.ppk.toPk());
												EcIdentityManager.addIdentityQuietly(id);
											}
											if (ceo != null)
												f.addOwner(ceo.ppk.toPk());

											if (EcFramework.template != null && JSObjectAdapter.$get(EcFramework.template,("schema:dateCreated")) != null) {
												setDateCreated(e, f);
											}


											JSObjectAdapter.$put(frameworks, f.id, f);
											JSObjectAdapter.$put(frameworkRows, f.id, e);
											JSObjectAdapter.$put(f, "ceasn:hasChild", null);
											JSObjectAdapter.$put(f, "ceasn:hasTopChild", null);
											frameworkArray.push(f);
											f.competency = new Array();
											f.relation = new Array();
											//Delete ceasn:hasTopChild, ceasn:isChildOf, ceasn:hasChild, etc.
											callback0.$invoke();
										}
									}, (Callback1) failure);
								} else if (JSObjectAdapter.$get(pretranslatedE, "@type") == "ceasn:Competency") {
									EcLinkedData translator = new EcLinkedData(null, null);
									translator.copyFrom(pretranslatedE);
									cleanUpTranslator(translator);
									translator.recast("https://schema.cassproject.org/0.4/ceasn2cass", "https://schema.cassproject.org/0.4", new Callback1<EcLinkedData>() {
										@Override
										public void $invoke(EcLinkedData e) {
											EcCompetency f = new EcCompetency();
											f.copyFrom(e);
											if (JSObjectAdapter.$get(e, "id") == null) {
												callback0.$invoke();
												return;
											}
											if (JSObjectAdapter.$get(e, "ceasn:isPartOf") != null) {
												((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).competency.push(f.shortId());
											} else {
												Object parent = e;
												boolean done = false;
												while (!done && parent != null) {
													if (JSObjectAdapter.$get(parent, "ceasn:isChildOf") != null && JSObjectAdapter.$get(parent, "ceasn:isChildOf") != "") {
														parent = JSObjectAdapter.$get(competencyRows, (String) JSObjectAdapter.$get(parent, "ceasn:isChildOf"));
													} else if (JSObjectAdapter.$get(parent, "ceasn:isTopChildOf") != null && JSObjectAdapter.$get(parent, "ceasn:isTopChildOf") != "") {
														parent = JSObjectAdapter.$get(frameworkRows, (String) JSObjectAdapter.$get(parent, "ceasn:isTopChildOf"));
														done = true;
													}
												}
												if (!done) {
													error.$invoke("Could not find framework:" + JSObjectAdapter.$get(e, "type"));
													return;
												}
												if (parent != null) {
													if (JSObjectAdapter.$get(parent, "type") == "Framework") {
														JSObjectAdapter.$put(e, "ceasn:isPartOf", (String) JSObjectAdapter.$get(parent, "id"));
														((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(parent, "id"))).competency.push(f.shortId());
													} else {
														error.$invoke("Object cannot trace to framework:" + JSObjectAdapter.$get(e, "type"));
														return;
													}
												} else {
													error.$invoke("Object has no framework:" + JSObjectAdapter.$get(e, "type"));
													return;
												}
											}

											if (JSObjectAdapter.$get(e, "owner") == null) {
												if (JSObjectAdapter.$get(JSObjectAdapter.$get(frameworkRows, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf")), "owner") != null)
													JSObjectAdapter.$put(e, "owner", JSObjectAdapter.$get(JSObjectAdapter.$get(frameworkRows, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf")), "owner"));
											}
											EcIdentity id = new EcIdentity();
											if (JSObjectAdapter.$get(e, "owner") != null) {
												id.ppk = EcPpk.fromPem((String) JSObjectAdapter.$get(e, "owner"));
												if (id.ppk != null)
													f.addOwner(id.ppk.toPk());
												EcIdentityManager.addIdentityQuietly(id);
											}
											if (ceo != null)
												f.addOwner(ceo.ppk.toPk());

											if (EcCompetency.template != null && JSObjectAdapter.$get(EcCompetency.template,("schema:dateCreated")) != null) {
												setDateCreated(e, f);
											}

											//isChildOf does not have multiple values
											if (JSObjectAdapter.$get(e, "ceasn:isChildOf") != null) {
												createEachRelation(e, "ceasn:isChildOf", Relation.NARROWS, repo, ceo, id, relations, relationById, frameworks, -1);
											}
											if (JSObjectAdapter.$get(e, "ceasn:broadAlignment") != null) {
												createRelations(e, "ceasn:broadAlignment", Relation.NARROWS, repo, ceo, id, relations, relationById, frameworks);
											}
											if (JSObjectAdapter.$get(e, "ceasn:narrowAlignment") != null) {
												createRelations(e, "ceasn:narrowAlignment", Relation.NARROWS, repo, ceo, id, relations, relationById, frameworks);
											}
											if (JSObjectAdapter.$get(e, "sameAs") != null) {
												createRelations(e, "sameAs", Relation.IS_EQUIVALENT_TO, repo, ceo, id, relations, relationById, frameworks);
											}
											if (JSObjectAdapter.$get(e, "ceasn:majorAlignment") != null) {
												createRelations(e, "ceasn:majorAlignment", "majorRelated", repo, ceo, id, relations, relationById, frameworks);
											}
											if (JSObjectAdapter.$get(e, "ceasn:minorAlignment") != null) {
												createRelations(e, "ceasn:minorAlignment", "minorRelated", repo, ceo, id, relations, relationById, frameworks);
											}
											if (JSObjectAdapter.$get(e, "ceasn:prerequisiteAlignment") != null) {
												createRelations(e, "ceasn:prerequisiteAlignment", Relation.REQUIRES, repo, ceo, id, relations, relationById, frameworks);
											}
											JSObjectAdapter.$put(f, "ceasn:isTopChildOf", null);
											JSObjectAdapter.$put(f, "ceasn:isChildOf", null);
											JSObjectAdapter.$put(f, "ceasn:isPartOf", null);
											JSObjectAdapter.$put(f, "ceasn:broadAlignment", null);
											JSObjectAdapter.$put(f, "ceasn:narrowAlignment", null);
											//Translation of ceasn:exactAlignment
											JSObjectAdapter.$put(f, "sameAs", null);
											JSObjectAdapter.$put(f, "ceasn:majorAlignment", null);
											JSObjectAdapter.$put(f, "ceasn:minorAlignment", null);
											JSObjectAdapter.$put(f, "ceasn:prerequisiteAlignment", null);
											JSObjectAdapter.$put(f, "ceasn:hasChild", null);
											competencies.push(f);
											JSObjectAdapter.$put(competencyRows, f.id, e);
											callback0.$invoke();
										}
									}, (Callback1) failure);
								} else if (JSObjectAdapter.$get(pretranslatedE, "@type") == null || JSObjectAdapter.$get(pretranslatedE, "@type") == "")
								{callback0.$invoke();return;}

								else {
									error.$invoke("Found unknown type:" + JSObjectAdapter.$get(pretranslatedE, "@type"));
									callback0.$invoke();
									return;
								}
							}
						}, new Callback1<Array<Object>>() {
							@Override
							public void $invoke(Array<Object> strings) {
								success.$invoke(frameworkArray, competencies, relations);
							}
						});
					}
				};
				error = failure;
			}
		});
	}

	static void cleanUpTranslator(EcLinkedData translator) {
		for (String key : JSObjectAdapter.$properties(translator)) {
			if (JSObjectAdapter.$get(translator, key) == "") {
				JSObjectAdapter.$put(translator, key, null);
			}
			else if (JSObjectAdapter.$get(translator, key) != null){
				Object thisKey = JSObjectAdapter.$get(translator, key);
				if (typeof(thisKey) == "string") {
					//If it's only whitespace, remove value
					if (((String)JSObjectAdapter.$get(translator, key)).trim().length() == 0) {
						JSObjectAdapter.$put(translator, key, null);
					}
					//If multiple values, split string into an array
					else if (((String)thisKey).indexOf("|") != -1) {
						thisKey = ((String)thisKey).split("|");
						JSObjectAdapter.$put(translator, key, thisKey);
					}
				}
				//Strip whitespace from keys
				if (key != key.trim()) {
					String trimKey = key.trim();
					JSObjectAdapter.$put(translator, trimKey, JSObjectAdapter.$get(translator, key));
					JSObjectAdapter.$put(translator, key, null);
				}
			}
		}
	}

	static void createRelations(EcLinkedData e, String field, String type, EcRepository repo, EcIdentity ceo, EcIdentity id, Array relations, Object relationById, Object frameworks) {
		if (!EcArray.isArray(JSObjectAdapter.$get(e, field))) {
			Array<String> makeArray = JSGlobal.Array((String)JSObjectAdapter.$get(e, field));
			JSObjectAdapter.$put(e, field, makeArray);
		}
		for (int i = 0; i < ((Array<String>)JSObjectAdapter.$get(e, field)).$length(); i++) {
			createEachRelation(e, field, type, repo, ceo, id, relations, relationById, frameworks, i);
		}
	}

	static void createEachRelation(EcLinkedData e, String field, String type, EcRepository repo, EcIdentity ceo, EcIdentity id, Array relations, Object relationById, Object frameworks, int i) {
		EcAlignment r = new EcAlignment();
		r.generateId(repo.selectedServer);
		if (ceo != null)
			r.addOwner(ceo.ppk.toPk());
		if (id.ppk != null)
			r.addOwner(id.ppk.toPk());

		r.relationType = type;
		if (field == "ceasn:narrowAlignment") {
			r.source = ((Array<String>)JSObjectAdapter.$get(e, field)).$get(i);
			r.target = (String) JSObjectAdapter.$get(e, "id");
		}
		else {
			r.source = (String) JSObjectAdapter.$get(e, "id");
			if (i != -1) {
				r.target = ((Array<String>) JSObjectAdapter.$get(e, field)).$get(i);
			}
			//i = -1 if field is not an array
			else {
				r.target = ((String) JSObjectAdapter.$get(e, field));
			}
		}

		relations.push(r);
		JSObjectAdapter.$put(relationById, r.shortId(), r);
		((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
	}

	public static void setDateCreated(EcLinkedData importObject, EcRemoteLinkedData object) {
		if (JSObjectAdapter.$get(importObject, "ceasn:dateCreated") == null && JSObjectAdapter.$get(importObject, "schema:dateCreated") == null) {
			Integer timestamp = object.getTimestamp();
			String date;
			if (timestamp != null) {
				date = new Date(JSGlobal.parseInt(timestamp)).toISOString();
			} else {
				date = new Date().toISOString();
			}
			JSObjectAdapter.$put(object, "schema:dateCreated", date);
		}
	}
}
