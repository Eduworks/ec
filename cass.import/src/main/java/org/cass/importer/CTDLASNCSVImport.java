package org.cass.importer;

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
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Callback3;

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
							if (col.$get(typeCol) == "ceasn:CompetencyFramework")
								frameworkCounter++;
							else if (col.$get(typeCol) == "ceasn:Competency")
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
						Array<Array<String>> tabularData = (Array<Array<String>>) JSObjectAdapter.$get(results, "data");

						Object frameworks = new Object();
						Array frameworkArray = new Array<EcFramework>();
						Object frameworkRows = new Object();
						Array competencies = new Array<EcCompetency>();
						Object competencyRows = new Object();
						Array relations = new Array<EcAlignment>();
						Object relationById = new Object();
						for (int i = 0; i < tabularData.$length(); i++) {
							Object e = tabularData.$get(i);
							if (JSObjectAdapter.$get(e, "@type") == "ceasn:CompetencyFramework") {
								EcFramework f = new EcFramework();

								if (JSObjectAdapter.$get(e, "@owner") != null) {
									EcIdentity id = new EcIdentity();
									id.ppk = EcPpk.fromPem((String) JSObjectAdapter.$get(e, "@owner"));
									if (ceo != null)
										f.addOwner(ceo.ppk.toPk());
									f.addOwner(id.ppk.toPk());
									EcIdentityManager.addIdentityQuietly(id);
								}

								f.id = (String) JSObjectAdapter.$get(e, "@id");
								JSObjectAdapter.$put(frameworks, f.id, f);
								JSObjectAdapter.$put(frameworkRows, f.id, e);
								frameworkArray.push(f);
								f.competency = new Array();
								f.relation = new Array();
								f.name = (String) JSObjectAdapter.$get(e, "ceasn:name");
								if (JSObjectAdapter.$get(e, "ceasn:creator") != null)
									JSObjectAdapter.$put(e, "ceasn:creator", ((String) JSObjectAdapter.$get(e, "ceasn:creator")).toLowerCase());
								JSObjectAdapter.$put(f, "schema:creator", JSObjectAdapter.$get(e, "ceasn:creator"));
								JSObjectAdapter.$put(f, "ceasn:derivedFrom", JSObjectAdapter.$get(e, "ceasn:derivedFrom"));
								JSObjectAdapter.$put(f, "dc:source", JSObjectAdapter.$get(e, "ceasn:source"));
							} else if (JSObjectAdapter.$get(e, "@type") == "ceasn:Competency") {
								EcCompetency f = new EcCompetency();
								if (JSObjectAdapter.$get(e, "@id") == null) continue;
								f.id = (String) JSObjectAdapter.$get(e, "@id");
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
										error.$invoke("Could not find framework:" + JSObjectAdapter.$get(e, "@type"));
										return;
									}
									if (parent != null) {
										if (JSObjectAdapter.$get(parent, "@type") == "ceasn:CompetencyFramework") {
											JSObjectAdapter.$put(e, "ceasn:isPartOf", (String) JSObjectAdapter.$get(parent, "@id"));
											((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(parent, "@id"))).competency.push(f.shortId());
										} else {
											error.$invoke("Object cannot trace to framework:" + JSObjectAdapter.$get(e, "@type"));
											return;
										}
									} else {
										error.$invoke("Object has no framework:" + JSObjectAdapter.$get(e, "@type"));
										return;
									}
								}

								if (JSObjectAdapter.$get(e, "@owner") == null) {
									if (JSObjectAdapter.$get(JSObjectAdapter.$get(frameworkRows, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf")), "@owner") != null)
										JSObjectAdapter.$put(e, "@owner", JSObjectAdapter.$get(JSObjectAdapter.$get(frameworkRows, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf")), "@owner"));
								}
								EcIdentity id = new EcIdentity();
								if (JSObjectAdapter.$get(e, "@owner") != null) {
									id.ppk = EcPpk.fromPem((String) JSObjectAdapter.$get(e, "@owner"));
									if (ceo != null)
										f.addOwner(ceo.ppk.toPk());
									if (id.ppk != null)
										f.addOwner(id.ppk.toPk());
									EcIdentityManager.addIdentityQuietly(id);
								}

								f.name = (String) JSObjectAdapter.$get(e, "ceasn:competencyText");
								if (f.name == null || f.name == "")
									f.name = (String) JSObjectAdapter.$get(e, "ceasn:name");
								if (JSObjectAdapter.$get(e, "ceasn:comment") != null)
									f.description = (String) JSObjectAdapter.$get(e, "ceasn:comment");
								JSObjectAdapter.$put(f, "schema:creator", JSObjectAdapter.$get(e, "ceasn:creator"));
								JSObjectAdapter.$put(f, "ceasn:codedNotation", JSObjectAdapter.$get(e, "ceasn:codedNotation"));
								JSObjectAdapter.$put(f, "ceasn:listID", JSObjectAdapter.$get(e, "ceasn:listID"));

								if (JSObjectAdapter.$get(e, "ceasn:isChildOf") != null) {
									EcAlignment r = new EcAlignment();
									r.generateId(repo.selectedServer);
									if (ceo != null)
										r.addOwner(ceo.ppk.toPk());
									if (id.ppk != null)
										r.addOwner(id.ppk.toPk());
									r.source = (String) JSObjectAdapter.$get(e, "@id");
									r.relationType = Relation.NARROWS;
									r.target = (String) JSObjectAdapter.$get(e, "ceasn:isChildOf");
									relations.push(r);
									JSObjectAdapter.$put(relationById, r.shortId(), r);
									((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
								}
//								if (e["schema:sameAs"] != null)
//									for (var sameAs in e["schema:sameAs"].split(" ")) {
//									EcAlignment r = new EcAlignment();
//									r.generateId(repo.selectedServer);
//									r.addOwner(ceo.ppk.toPk());
//									r.addOwner(id.ppk.toPk());
//									r.source = e["@id"];
//									r.relationType = Relation.IS_EQUIVALENT_TO;
//									r.target = sameAs;
//									relations.push(r);
//									relationById[r.shortId()] = r;
//									frameworks[e["ceasn:isPartOf"]].relation.push(r.shortId());
//								}
								JSObjectAdapter.$put(f, "ceasn:derivedFrom", JSObjectAdapter.$get(e, "ceasn:derivedFrom"));
								competencies.push(f);
								JSObjectAdapter.$put(competencyRows, f.id, e);
							} else if (JSObjectAdapter.$get(e, "@type") == null || JSObjectAdapter.$get(e, "@type") == "")
								continue;
							else {
								error.$invoke("Found unknown type:" + JSObjectAdapter.$get(e, "@type"));
								return;
							}
						}
						success.$invoke(frameworkArray, competencies, relations);
					}
				};
				error = failure;
			}
		});
	}
}
