package org.cass.exporter;

import js.Papa;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
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

	public static void exportObjects(Array<EcRemoteLinkedData> objects, String fileName) {
		CSVExportProcess compExport = new CSVExport().new CSVExportProcess();
		compExport.buildExport(objects);
		compExport.downloadCSV(fileName);
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
									compExport.buildExport(frameworkCompetencies);
									compExport.downloadCSV(fw.getName() + " - Competencies.csv");
								} else {
									// incremental if we want
								}
							}
						}, failure);
					}

					for (int i = 0; i < fw.relation.$length(); i++) {
						String relationUrl = fw.relation.$get(i);

						EcRepository.get(relationUrl, new Callback1<EcRemoteLinkedData>() {
							public void $invoke(EcRemoteLinkedData relation) {
								frameworkRelations.push(relation);


								if (frameworkRelations.$length() == fw.relation.$length()) {
									CSVExportProcess compExport = new CSVExport().new CSVExportProcess();
									compExport.buildExport(frameworkRelations);
									compExport.downloadCSV(fw.getName() + " - Relations.csv");
									if (success != null && success != JSGlobal.undefined)
										success.$invoke();
								} else {
									// incremental if we want
								}

							}
						}, failure);
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

		public void flattenObject(EcRemoteLinkedData flattenedObject, Object object, String prefix) {

			EcRemoteLinkedData data = new EcRemoteLinkedData((String) JSObjectAdapter.$get(object, "@context"), (String) JSObjectAdapter.$get(object, "@type"));
			data.copyFrom(object);
			Object tempObj = Global.JSON.parse(data.toJson());

			Map<String, Object> props = JSObjectAdapter.$properties(tempObj);
			for (String prop : props) {
				String id;
				if (prefix != null && prefix != JSGlobal.undefined)
					id = prefix + "." + prop;
				else
					id = prop;
				if (props.$get(prop) != null && props.$get(prop) != "" && props.$get(prop) instanceof Object) {
					flattenObject(flattenedObject, props.$get(prop), id);
				} else {
					JSObjectAdapter.$put(flattenedObject, id, props.$get(prop));
				}
			}
		}

		public void addCSVRow(EcRemoteLinkedData object) {
			EcRemoteLinkedData flattenedObject = new EcRemoteLinkedData(object.context, object.type);

			flattenObject(flattenedObject, object, null);
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

		public void buildExport(Array<EcRemoteLinkedData> objects) {
			for (int i = 0; i < objects.$length(); i++) {
				EcRemoteLinkedData object = objects.$get(i);

				addCSVRow(object);
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
