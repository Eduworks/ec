package org.cass.importer;

import js.FileReader;
import js.X2JS;
import org.cass.competency.EcCompetency;
import org.cassproject.ebac.identity.EcIdentity;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

/**
 * Importer methods to create competencies based on a
 * Medbiquitous competency XML file
 *
 * @author devlin.junker@eduworks.com
 * @author fritz.ray@eduworks.com
 * @module org.cassproject
 * @class MedbiqImport
 * @static
 * @extends Importer
 */
public class MedbiqImport extends Importer {

	private final static int INCREMENTAL_STEP = 5;
	static Array<EcCompetency> medbiqXmlCompetencies;
	static Object progressObject;
	static int saved;

	/**
	 * Does the legwork of looking for competencies in the XML
	 *
	 * @param {Object} obj
	 *                 Parsed XML Object
	 * @memberOf MedbiqImport
	 * @method medbiqXmlLookForCompetencyObject
	 * @private
	 * @static
	 */
	private static void medbiqXmlLookForCompetencyObject(Object obj) {
		if (isObject(obj) || isArray(obj))
			for (String key : JSObjectAdapter.$properties(obj)) {
				if (key == "CompetencyObject")
					medbiqXmlParseCompetencyObject(JSObjectAdapter.$get(obj, key));
				else
					medbiqXmlLookForCompetencyObject(JSObjectAdapter.$get(obj, key));
			}
	}

	/**
	 * Does the legwork of parsing the competencies out of the parsed XML
	 *
	 * @param {Object} obj
	 *                 Parsed XML Object
	 * @memberOf MedbiqImport
	 * @method medbiqXmlParseCompetencyObject
	 * @private
	 * @static
	 */
	private static void medbiqXmlParseCompetencyObject(Object obj) {
		if (isArray(obj)) {
			for (String key : JSObjectAdapter.$properties(obj)) {
				medbiqXmlParseCompetencyObject(JSObjectAdapter.$get(obj, key));
			}
		} else {
			EcCompetency newCompetency = new EcCompetency();

			if (JSObjectAdapter.$get(obj, "lom") != null && JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general") != null) {

				newCompetency.name = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "title"), "string").toString();

				if (JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "description") != null)
					newCompetency.description = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "description"), "string").toString();

				if (JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "identifier") != null)
					newCompetency.url = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(obj, "lom"), "general"), "identifier"), "entry").toString();

				if (newCompetency.description == null)
					newCompetency.description = "";

				medbiqXmlCompetencies.push(newCompetency);
			}
		}
	}

	/**
	 * Analyzes a Medbiquitous XML file for competencies and saves them for use in the import process
	 *
	 * @param {Object}                         file
	 *                                         Medbiquitous XML file
	 * @param {Callback1<Array<EcCompetency>>} success
	 *                                         Callback triggered on succesfully analyzing competencies,
	 *                                         returns an array of all of the competencies found
	 * @param {Callback1<String>}              [failure]
	 *                                         Callback triggered on error analyzing file
	 * @memberOf MedbiqImport
	 * @method analyzeFile
	 * @static
	 */
	public static void analyzeFile(Object file, final Callback1<Array<EcCompetency>> success, final Callback1<String> failure) {
		if (file == null) {
			failure.$invoke("No file to analyze");
			return;
		}

		if (JSObjectAdapter.$get(file, "name") == null) {
			failure.$invoke("Invalid file");
			return;
		} else if (!((String) JSObjectAdapter.$get(file, "name")).endsWith(".xml")) {
			failure.$invoke("Invalid file type");
			return;
		}

		FileReader reader = new FileReader();

		reader.onload = new Callback1<Object>() {
			@Override
			public void $invoke(Object e) {
				String result = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(e, "target"), "result");

				Object jsonObject = new X2JS().xml_str2json(result);

				medbiqXmlCompetencies = JSCollections.$array();

				medbiqXmlLookForCompetencyObject(jsonObject);

				success.$invoke(medbiqXmlCompetencies);
			}
		};

		reader.onerror = new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				failure.$invoke("Error Reading File");
			}
		};

		reader.readAsText(file);
	}

	/**
	 * Method for actually creating the competencies in the CASS repository after a
	 * Medbiquitous XML file has been parsed. Must be called after analyzeFile
	 *
	 * @param {String}                         serverUrl
	 *                                         URL Prefix for the created competencies (and relationships?)
	 * @param {EcIdentity}                     owner
	 *                                         EcIdentity that will own the created competencies (and relationships?)
	 * @param {Callback1<Array<EcCompetency>>} success
	 *                                         Callback triggered after successfully creating the competencies from the XML file
	 * @param {Callback1<Object>}              [failure]
	 *                                         Callback triggered if there is an error while creating the competencies
	 * @param {Callback1<Object>}              [incremental]
	 *                                         Callback triggered incrementally while the competencies are being created to show progress,
	 *                                         returns an object indicating the number of competencies created so far
	 * @memberOf MedbiqImport
	 * @method importCompetencies
	 * @static
	 */
	public static void importCompetencies(final String serverUrl, final EcIdentity owner,
	                                      final Callback1<Array<EcCompetency>> success, final Callback1<Object> failure, final Callback1<Object> incremental) {
		progressObject = null;
		saved = 0;
		for (int i = 0; i < medbiqXmlCompetencies.$length(); i++) {
			EcCompetency comp = medbiqXmlCompetencies.$get(i);

			comp.generateId(serverUrl);

			if (owner != null)
				comp.addOwner(owner.ppk.toPk());

			comp.save(new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					saved++;

					if (saved % INCREMENTAL_STEP == 0) {
						if (progressObject == null)
							progressObject = new Object();

						JSObjectAdapter.$put(progressObject, "competencies", saved);

						incremental.$invoke(progressObject);
					}

					if (saved == medbiqXmlCompetencies.$length()) {
						if (progressObject == null)
							progressObject = new Object();

						JSObjectAdapter.$put(progressObject, "competencies", saved);
						incremental.$invoke(progressObject);

						success.$invoke(medbiqXmlCompetencies);
					}
				}
			}, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					failure.$invoke("Failed to Save Competency");
				}
			});
		}
	}
}
