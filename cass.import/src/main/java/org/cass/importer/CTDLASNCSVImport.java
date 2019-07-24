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
									for (String key : JSObjectAdapter.$properties(translator)) {
										if (JSObjectAdapter.$get(translator, key) == "") {
											JSObjectAdapter.$put(translator, key, null);
										}
										else if (JSObjectAdapter.$get(translator, key) != null){
											Object thisKey = JSObjectAdapter.$get(translator, key);
											if (typeof(thisKey) == "string" && ((String)thisKey).indexOf("|") != -1) {
												thisKey = ((String)thisKey).split("|");
												JSObjectAdapter.$put(translator, key, thisKey);
											}
										}
									}
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
									for (String key : JSObjectAdapter.$properties(translator)) {
										if (JSObjectAdapter.$get(translator, key) == "") {
											JSObjectAdapter.$put(translator, key, null);
										}
										else if (JSObjectAdapter.$get(translator, key) != null){
											Object thisKey = JSObjectAdapter.$get(translator, key);
											if (typeof(thisKey) == "string" && ((String)thisKey).indexOf("|") != -1) {
												thisKey = ((String)thisKey).split("|");
												JSObjectAdapter.$put(translator, key, thisKey);
											}
										}
									}
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

											if (JSObjectAdapter.$get(e, "ceasn:isChildOf") != null) {
												EcAlignment r = new EcAlignment();
												r.generateId(repo.selectedServer);
												if (ceo != null)
													r.addOwner(ceo.ppk.toPk());
												if (id.ppk != null)
													r.addOwner(id.ppk.toPk());
												r.source = (String) JSObjectAdapter.$get(e, "id");
												r.relationType = Relation.NARROWS;
												r.target = (String) JSObjectAdapter.$get(e, "ceasn:isChildOf");
												relations.push(r);
												JSObjectAdapter.$put(relationById, r.shortId(), r);
												((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
											}
											if (JSObjectAdapter.$get(e, "ceasn:broadAlignment") != null) {
												if (!EcArray.isArray(JSObjectAdapter.$get(e, "ceasn:broadAlignment"))) {
													Array<String> broad = JSGlobal.Array((String)JSObjectAdapter.$get(e, "ceasn:broadAlignment"));
													JSObjectAdapter.$put(e, "ceasn:broadAlignment", broad);
												}
												for (int i = 0; i < ((Array<String>)JSObjectAdapter.$get(e, "ceasn:broadAlignment")).$length(); i++) {
													EcAlignment r = new EcAlignment();
													r.generateId(repo.selectedServer);
													if (ceo != null)
														r.addOwner(ceo.ppk.toPk());
													if (id.ppk != null)
														r.addOwner(id.ppk.toPk());
													r.source = (String) JSObjectAdapter.$get(e, "id");
													r.relationType = Relation.NARROWS;
													r.target = ((Array<String>)JSObjectAdapter.$get(e, "ceasn:broadAlignment")).$get(i);
													relations.push(r);
													JSObjectAdapter.$put(relationById, r.shortId(), r);
													((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
												}

											}
											if (JSObjectAdapter.$get(e, "ceasn:narrowAlignment") != null) {
												if (!EcArray.isArray(JSObjectAdapter.$get(e, "ceasn:narrowAlignment"))) {
													Array<String> narrow = JSGlobal.Array((String)JSObjectAdapter.$get(e, "ceasn:narrowAlignment"));
													JSObjectAdapter.$put(e, "ceasn:narrowAlignment", narrow);
												}
												for (int i = 0; i < ((Array<String>)JSObjectAdapter.$get(e, "ceasn:narrowAlignment")).$length(); i++) {
													EcAlignment r = new EcAlignment();
													r.generateId(repo.selectedServer);
													if (ceo != null)
														r.addOwner(ceo.ppk.toPk());
													if (id.ppk != null)
														r.addOwner(id.ppk.toPk());
													r.source = ((Array<String>)JSObjectAdapter.$get(e, "ceasn:narrowAlignment")).$get(i);
													r.relationType = Relation.NARROWS;
													r.target = (String) JSObjectAdapter.$get(e, "id");
													relations.push(r);
													JSObjectAdapter.$put(relationById, r.shortId(), r);
													((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
												}
											}
											if (JSObjectAdapter.$get(e, "sameAs") != null) {
												if (!EcArray.isArray(JSObjectAdapter.$get(e, "sameAs"))) {
													Array<String> same = JSGlobal.Array((String)JSObjectAdapter.$get(e, "sameAs"));
													JSObjectAdapter.$put(e, "sameAs", same);
												}
												for (int i = 0; i < ((Array<String>)JSObjectAdapter.$get(e, "sameAs")).$length(); i++) {
													EcAlignment r = new EcAlignment();
													r.generateId(repo.selectedServer);
													if (ceo != null)
														r.addOwner(ceo.ppk.toPk());
													if (id.ppk != null)
														r.addOwner(id.ppk.toPk());
													r.source = (String) JSObjectAdapter.$get(e, "id");
													r.relationType = Relation.IS_EQUIVALENT_TO;
													r.target = ((Array<String>)JSObjectAdapter.$get(e, "sameAs")).$get(i);
													relations.push(r);
													JSObjectAdapter.$put(relationById, r.shortId(), r);
													((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
												}
											}
											if (JSObjectAdapter.$get(e, "ceasn:majorAlignment") != null) {
												if (!EcArray.isArray(JSObjectAdapter.$get(e, "ceasn:majorAlignment"))) {
													Array<String> major = JSGlobal.Array((String)JSObjectAdapter.$get(e, "ceasn:majorAlignment"));
													JSObjectAdapter.$put(e, "ceasn:majorAlignment", major);
												}
												for (int i = 0; i < ((Array<String>)JSObjectAdapter.$get(e, "ceasn:majorAlignment")).$length(); i++) {
													EcAlignment r = new EcAlignment();
													r.generateId(repo.selectedServer);
													if (ceo != null)
														r.addOwner(ceo.ppk.toPk());
													if (id.ppk != null)
														r.addOwner(id.ppk.toPk());
													r.source = (String) JSObjectAdapter.$get(e, "id");
													r.relationType = "majorRelated";
													r.target = ((Array<String>)JSObjectAdapter.$get(e, "ceasn:majorAlignment")).$get(i);
													relations.push(r);
													JSObjectAdapter.$put(relationById, r.shortId(), r);
													((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
												}
											}
											if (JSObjectAdapter.$get(e, "ceasn:minorAlignment") != null) {
												if (!EcArray.isArray(JSObjectAdapter.$get(e, "ceasn:minorAlignment"))) {
													Array<String> minor = JSGlobal.Array((String)JSObjectAdapter.$get(e, "ceasn:minorAlignment"));
													JSObjectAdapter.$put(e, "ceasn:minorAlignment", minor);
												}
												for (int i = 0; i < ((Array<String>)JSObjectAdapter.$get(e, "ceasn:minorAlignment")).$length(); i++) {
													EcAlignment r = new EcAlignment();
													r.generateId(repo.selectedServer);
													if (ceo != null)
														r.addOwner(ceo.ppk.toPk());
													if (id.ppk != null)
														r.addOwner(id.ppk.toPk());
													r.source = (String) JSObjectAdapter.$get(e, "id");
													r.relationType = "minorRelated";
													r.target = ((Array<String>)JSObjectAdapter.$get(e, "ceasn:minorAlignment")).$get(i);
													relations.push(r);
													JSObjectAdapter.$put(relationById, r.shortId(), r);
													((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
												}
											}
											if (JSObjectAdapter.$get(e, "ceasn:prerequisiteAlignment") != null) {
												if (!EcArray.isArray(JSObjectAdapter.$get(e, "ceasn:prerequisiteAlignment"))) {
													Array<String> prereq = JSGlobal.Array((String)JSObjectAdapter.$get(e, "ceasn:prerequisiteAlignment"));
													JSObjectAdapter.$put(e, "ceasn:prerequisiteAlignment", prereq);
												}
												for (int i = 0; i < ((Array<String>)JSObjectAdapter.$get(e, "ceasn:prerequisiteAlignment")).$length(); i++) {
													EcAlignment r = new EcAlignment();
													r.generateId(repo.selectedServer);
													if (ceo != null)
														r.addOwner(ceo.ppk.toPk());
													if (id.ppk != null)
														r.addOwner(id.ppk.toPk());
													r.source = (String) JSObjectAdapter.$get(e, "id");
													r.relationType = Relation.REQUIRES;
													r.target = ((Array<String>)JSObjectAdapter.$get(e, "ceasn:prerequisiteAlignment")).$get(i);
													relations.push(r);
													JSObjectAdapter.$put(relationById, r.shortId(), r);
													((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
												}
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
