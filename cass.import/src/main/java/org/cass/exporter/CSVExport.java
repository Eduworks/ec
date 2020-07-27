package org.cass.exporter;

import com.eduworks.ec.array.EcArray;
import js.Papa;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.Thing;
import org.stjs.javascript.*;
import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

/**
 * Export methods to handle exporting two CSV file , one of competencies
 * and one of relationships representing a framework
 *
 * @author devlin.junker@eduworks.com
 * @author fritz.ray@eduworks.com
 * @module org.cassproject
 * @class CSVExport
 * @static
 * @extends Exporter
 */
public class CSVExport extends Exporter {

	static Array<EcRemoteLinkedData> frameworkCompetencies;
	static Array<EcRemoteLinkedData> frameworkRelations;

	public static void exportObjects(Array<EcRemoteLinkedData> objects, String fileName, Boolean piped) {
		CSVExportProcess compExport = new CSVExport().new CSVExportProcess();
		compExport.buildExport(objects, piped);
		compExport.downloadCSV(fileName);
	}

	public static void exportCTDLASN(Object json, String name) {
		Array<EcRemoteLinkedData> objects = JSCollections.$array();
		findGraphs(json, objects);
		exportObjects(objects, name + ".csv", true);
	}

	static void findGraphs(Object json, Array<EcRemoteLinkedData> objects) {
		Array<Object> jsonArray;
		if (!EcArray.isArray(json)) {
			jsonArray = JSCollections.$array(json);
		}
		else {
			jsonArray = (Array<Object>)json;
		}
		for (int j = 0; j < jsonArray.$length(); j++) {
			Object framework = jsonArray.$get(j);
			Array<Object> graph = (Array<Object>)JSObjectAdapter.$get(framework, "@graph");
			if (graph != null) {
				for (int i = 0; i < graph.$length(); i++) {
					EcRemoteLinkedData rld = new EcRemoteLinkedData("https://credreg.net/ctdlasn/schema/context/json", (String)JSObjectAdapter.$get(graph.$get(i), "@type"));
					rld.copyFrom(graph.$get(i));
					objects.push(rld);
					if (JSObjectAdapter.$get(graph.$get(i), "@graph") != null) {
						findGraphs(graph.$get(i), objects);
					}
				}
			}
		}
	}

	/**
	 * Method to export the CSV files of competencies and relationships for a framework
	 *
	 * @param {String}            frameworkId
	 *                            Id of the framework to export
	 * @param {Callback0}         success
	 *                            Callback triggered after both files have been successfully exported
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if an error occurs during export
	 * @memberOf CSVExport
	 * @method export
	 * @static
	 */
	public static void exportFramework(String frameworkId, final Callback0 success, final Callback1<String> failure) {
		if (frameworkId == null) {
			failure.$invoke("Framework not selected.");
			return;
		}

		frameworkCompetencies = JSCollections.$array();
		frameworkRelations = JSCollections.$array();

		EcRepository.get(frameworkId, new Callback1<EcRemoteLinkedData>() {

			public void $invoke(EcRemoteLinkedData data) {
				if (data.isAny(new EcFramework().getTypes())) {
					final EcFramework fw = new EcFramework();
					fw.copyFrom(data);
					if (fw.competency == null || fw.competency.$length() == 0)
						failure.$invoke("No Competencies in Framework");


					for (int i = 0; i < fw.competency.$length(); i++) {
						String competencyUrl = fw.competency.$get(i);

						EcRepository.get(competencyUrl, new Callback1<EcRemoteLinkedData>() {
							public void $invoke(EcRemoteLinkedData competency) {
								frameworkCompetencies.push(competency);

								if (frameworkCompetencies.$length() == fw.competency.$length()) {
									CSVExportProcess compExport = new CSVExport().new CSVExportProcess();
									compExport.buildExport(frameworkCompetencies, false);
									compExport.downloadCSV(fw.getName() + " - Competencies.csv");
								} else {
									// incremental if we want
								}
							}
						}, new Callback1<String>() {
							public void $invoke(String s) {
								frameworkCompetencies.push(null);

								if (frameworkCompetencies.$length() == fw.competency.$length()) {
									CSVExportProcess compExport = new CSVExport().new CSVExportProcess();
									compExport.buildExport(frameworkCompetencies, false);
									compExport.downloadCSV(fw.getName() + " - Competencies.csv");
								} else {
									// incremental if we want
								}
							}
						});
					}

					for (int i = 0; i < fw.relation.$length(); i++) {
						String relationUrl = fw.relation.$get(i);

						EcRepository.get(relationUrl, new Callback1<EcRemoteLinkedData>() {
							public void $invoke(EcRemoteLinkedData relation) {
								frameworkRelations.push(relation);
								if (frameworkRelations.$length() == fw.relation.$length()) {
									CSVExportProcess compExport = new CSVExport().new CSVExportProcess();
									compExport.buildExport(frameworkRelations, false);
									compExport.downloadCSV(fw.getName() + " - Relations.csv");
									if (success != null && success != JSGlobal.undefined)
										success.$invoke();
								} else {
									// incremental if we want
								}

							}
						}, new Callback1<String>() {
							@Override
							public void $invoke(String s) {
								frameworkRelations.push(null);
								if (frameworkRelations.$length() == fw.relation.$length()) {
									CSVExportProcess compExport = new CSVExport().new CSVExportProcess();
									compExport.buildExport(frameworkRelations, false);
									compExport.downloadCSV(fw.getName() + " - Relations.csv");
									if (success != null && success != JSGlobal.undefined)
										success.$invoke();
								} else {
									// incremental if we want
								}
							}
						});
					}
				}
			}
		}, failure);
	}

	public class CSVExportProcess {
		Array<Object> csvOutput;

		public CSVExportProcess() {
			csvOutput = JSCollections.$array();
		}

		public void flattenObject(EcRemoteLinkedData flattenedObject, Object object, String prefix, Boolean piped) {

			EcRemoteLinkedData data = new EcRemoteLinkedData((String) JSObjectAdapter.$get(object, "@context"), (String) JSObjectAdapter.$get(object, "@type"));
			data.copyFrom(object);
			Object tempObj = Global.JSON.parse(data.toJson());

			Map<String, Object> props = JSObjectAdapter.$properties(tempObj);
			for (String prop : props) {
				String id;
				if (prefix != null && prefix != JSGlobal.undefined && !piped)
					id = prefix + "." + prop;
				else
					id = prop;
				if (props.$get(prop) != null && props.$get(prop) != "" && props.$get(prop) instanceof Object && !piped) {
					flattenObject(flattenedObject, props.$get(prop), id, false);
				} else if (props.$get(prop) != null && props.$get(prop) != "" && (props.$get(prop) instanceof Object || EcArray.isArray(props.$get(prop))) && piped) {
					String display = "";
					Map<String, Object> props2 = JSObjectAdapter.$properties(props.$get(prop));
					for (String prop2 : props2) {
						display += props2.$get(prop2) + "|";
					}
					display = display.substring(0, display.length()-1);
					JSObjectAdapter.$put(flattenedObject, id, display);
				} else {
					String display = Thing.getDisplayStringFrom(props.$get(prop));
					JSObjectAdapter.$put(flattenedObject, id, display);
				}
			}
		}

		public void addCSVRow(EcRemoteLinkedData object, Boolean piped) {
			EcRemoteLinkedData flattenedObject = new EcRemoteLinkedData(object.context, object.type);

			flattenObject(flattenedObject, object, null, piped);
			csvOutput.push(Global.JSON.parse(flattenedObject.toJson()));

			Map<String, Object> props = JSObjectAdapter.$properties(Global.JSON.parse(flattenedObject.toJson()));
			for (String prop : props) {
				if (props.$get(prop) != null && props.$get(prop) != "") {
					for (int i = 0; i < csvOutput.$length(); i++) {
						Object row = csvOutput.$get(i);
						if (!JSObjectAdapter.hasOwnProperty(row, prop)) {
							JSObjectAdapter.$put(row, prop, "");
						}
					}
				}
			}
		}

		public void buildExport(Array<EcRemoteLinkedData> objects, Boolean piped) {
			for (int i = 0; i < objects.$length(); i++)
				if (objects.$get(i) != null) {

					EcRemoteLinkedData object = objects.$get(i);

					addCSVRow(object, piped);
				}
		}

		public void downloadCSV(String name) {
			String csv = Papa.unparse(csvOutput);
			Element pom = Global.window.document.createElement("a");

			pom.setAttribute("href", "data:text/csv;charset=utf-8," + Global.encodeURIComponent(csv));
			pom.setAttribute("download", name);

			if (JSObjectAdapter.$get(Global.window.document, "createEvent") != null) {
				DOMEvent event = JSFunctionAdapter.call(JSObjectAdapter.$get(Global.window.document, "createEvent"), Global.window.document, "MouseEvents");

				JSFunctionAdapter.call(JSObjectAdapter.$get(event, "initEvent"), event, "click", true, true);

				pom.dispatchEvent(event);
			} else {
				JSFunctionAdapter.call(JSObjectAdapter.$get(pom, "click"), pom);
			}
		}
	}

}
