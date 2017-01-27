package org.cass.importer;

import com.eduworks.ec.random.EcRandom;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.JSStringAdapter;
import org.stjs.javascript.RegExp;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

import js.Papa;
import js.PapaParseParams;

/**
 * Import methods to handle an CSV file of competencies and a 
 * CSV file of relationships and store them in a CASS instance
 * 
 * @module org.cassproject
 * @class CSVImport
 * @static
 * @extends Importer
 * 
 * @author devlin.junker@eduworks.com
 * @author fritz.ray@eduworks.com
 */
public class CSVImport
{
	private final static int INCREMENTAL_STEP = 5;
	

	/**
	 * Analyzes a CSV File to return the column names to the user for specifying
	 * which columns contain which data. This should be called before import.
	 * 
	 * @memberOf CSVImport
	 * @method analyzeFile
	 * @static
	 * @param {Object} file
	 * 			CSV file to be analyzed
	 * @param {Callback1<Object>} success
	 * 			Callback triggered after successfully analyzing the CSV file
	 * @param {Callback1<Object>} [failure]
	 * 			Callback triggered if there is an error analyzing the CSV file
	 */
	public static void analyzeFile(Object file, final Callback1<Object> success, final Callback1<Object> failure)
	{
		if(file == null){
			failure.$invoke("No file to analyze");	
			return;
		}
		
		if(JSObjectAdapter.$get(file, "name") == null){
			failure.$invoke("Invalid file");
		}else if(!((String)JSObjectAdapter.$get(file, "name")).endsWith(".csv")){
			failure.$invoke("Invalid file type");
		}
		
		Papa.parse(file, new PapaParseParams()
		{
			{
				complete = new Callback1<Object>()
				{
					@Override
					public void $invoke(Object results)
					{
						Object tabularData = JSObjectAdapter.$get(results, "data");
						success.$invoke(tabularData);
					}
				};
				error = failure;
			}
		});
	}

	static Object importCsvLookup;
	static int saved;

	static Object progressObject;
	
	/**
	 * Helper function to transform a competencies oldID to match the new server url
	 * 
	 * @memberOf CSVImport
	 * @method transformId
	 * @private
	 * @static
	 * @param {String} oldId
	 * 			Old ID found in the CSV file
	 * @param {EcRemoteLinkedData} newObject
	 * 			New competency being created
	 * @param {String} selectedServer
	 * 			New URL Prefix that the new competency's ID should match
	 */
	private static void transformId(String oldId, EcRemoteLinkedData newObject, String selectedServer)
	{
        if (oldId == null || oldId == "")
            oldId = EcRandom.generateUUID();
		if (oldId.indexOf("http") != -1)
		{
			Array<String> parts = JSStringAdapter.split(oldId, "/");
			String guid = null;
			String timestamp = null;
			RegExp pattern = new RegExp("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$",
					"i");
			for (int i = 0; i < parts.$length(); i++)
			{
				if (!JSGlobal.isNaN(JSGlobal.parseInt(parts.$get(i))))
					timestamp = parts.$get(i);
				else if (pattern.test(parts.$get(i)))
					guid = parts.$get(i);
			}
			if (guid == null)
				newObject.assignId(selectedServer, parts.$get(parts.$length() - 2));
			else
				newObject.assignId(selectedServer, guid);
		} else
			newObject.assignId(selectedServer, oldId);
	}

	/**
	 * Method to create competencies (and relationships if the parameters are passed in)
	 * based on a CSV file and references to which columns correspond to which pieces
	 * of data.
	 * 
	 * @memberOf CSVImport
	 * @method importCompetencies
	 * @static
	 * @param {Object} file
	 * 			CSV File to import competencies from
	 * @param {String} serverUrl
	 * 			URL Prefix for the created competencies (and relationships?)
	 * @param {EcIdentity} owner
	 * 			EcIdentity that will own the created competencies (and relationships?)
	 * @param {int} nameIndex
	 * 			Index of the column that contains the competency names
	 * @param {int} descriptionIndex
	 * 			Index of the column that contains the competency descriptions
	 * @param {int} scopeIndex
	 * 			Index of the column that contains the competency scopes
	 * @param {int} idIndex
	 * 			Index of the column that contains the old competency ID (Optional, if not exists pass null or negative)
	 * @param {Object} [relations]
	 * 			CSV File to import relationships from (Optional, if not exists pass null)
	 * @param {int} [sourceIndex]
	 * 			Index (in relation file) of the column containing the relationship source competency ID (Optional, if not exists pass null or negative)
	 * @param {int} [relationTypeIndex]
	 * 			Index (in relation file) of the column containing the relationship type (Optional, if not exists pass null or negative)
	 * @param {int} [destIndex]
	 * 			Index (in relation file) of the column containing the relationship destination competency ID (Optional, if not exists pass null or negative)
	 * @param {Callback2<Array<EcCompetency>, Array<EcAlignment>>} success
	 * 			Callback triggered after the competencies (and relationships?) have been created
	 * @param {Callback1<Object>} [failure]
	 * 			Callback triggered if an error during creating the competencies
	 * @param {Callback1<Object>} [incremental]
	 * 			Callback triggered incrementally during creation of competencies to indicate progress,
	 * 			returns an object indicating the number of competencies (and relationships?) created so far
	 * 			
	 */
	public static void importCompetencies(Object file, final String serverUrl, final EcIdentity owner,
			final Integer nameIndex, final Integer descriptionIndex, final Integer scopeIndex, final Integer idIndex,
			final Object relations, final Integer sourceIndex, final Integer relationTypeIndex, final Integer destIndex,
			final Callback2<Array<EcCompetency>, Array<EcAlignment>> success, final Callback1<Object> failure,
			final Callback1<Object> incremental)
	{
		progressObject = null;
		importCsvLookup = new Object();
		if (nameIndex < 0)
		{
			failure.$invoke("Name Index not Set");
			return;
		}

		final Array<EcCompetency> competencies = JSCollections.$array();
		Papa.parse(file, new PapaParseParams()
		{
			{
				complete = new Callback1<Object>()
				{
					@Override
					public void $invoke(Object results)
					{
						Array<Array<String>> tabularData = (Array<Array<String>>) JSObjectAdapter.$get(results, "data");

						for (int i = 1; i < tabularData.$length(); i++)
						{
							EcCompetency competency = new EcCompetency();
							if(tabularData.$get(i).$length() == 0 || 
									(tabularData.$get(i).$length() == 1 && 
										(tabularData.$get(i).$get(0) == null || tabularData.$get(i).$get(0) == "")))
							{
								continue;
							}
							if (tabularData.$get(i).$get(nameIndex) == null
									|| tabularData.$get(i).$get(nameIndex) == "")
							{
								continue;
							}
							competency.name = tabularData.$get(i).$get(nameIndex);

							if (descriptionIndex >= 0)
								competency.description = tabularData.$get(i).$get(descriptionIndex);
							if (scopeIndex >= 0)
								competency.scope = tabularData.$get(i).$get(scopeIndex);

							String shortId = null;
							if (idIndex != null && idIndex >= 0)
							{
								competency.id = tabularData.$get(i).$get(idIndex);
								shortId = competency.shortId();
							}
							if (idIndex != null && idIndex >= 0)
								transformId(tabularData.$get(i).$get(idIndex), competency, serverUrl);
							else
								competency.generateId(serverUrl);
							if (idIndex != null && idIndex >= 0 && tabularData.$get(i).$get(idIndex) != null && tabularData.$get(i).$get(idIndex) != "")
                            {
                                if (JSObjectAdapter.$get(importCsvLookup, tabularData.$get(i).$get(idIndex)) != null)
                                    continue;
								JSObjectAdapter.$put(importCsvLookup, tabularData.$get(i).$get(idIndex), competency.shortId());
                            }
                            else if (JSObjectAdapter.$get(importCsvLookup, competency.name) != null)
                                continue;
							JSObjectAdapter.$put(importCsvLookup, competency.name, competency.shortId());
							if (shortId != null && idIndex >= 0)
								JSObjectAdapter.$put(importCsvLookup, shortId, competency.shortId());

							if (owner != null)
								competency.addOwner(owner.ppk.toPk());

							competencies.push(competency);
						}

						saved = 0;
						for (int i = 0; i < competencies.$length(); i++)
						{
							EcCompetency comp = competencies.$get(i);
							comp.save(new Callback1<String>()
							{
								public void $invoke(String results)
								{
									saved++;

									if(saved % INCREMENTAL_STEP == 0){
										if(progressObject == null)
											progressObject = new Object();
										
										JSObjectAdapter.$put(progressObject, "competencies", saved);
											
										incremental.$invoke(progressObject);
									}
									
									if (saved == competencies.$length())
									{
										if (relations == null)
											success.$invoke(competencies, new Array<EcAlignment>());
										else
											importRelations(serverUrl, owner, relations, sourceIndex, relationTypeIndex,
													destIndex, competencies, success, failure, incremental);
									}
								}

							}, new Callback1<String>()
							{
								public void $invoke(String results)
								{
									failure.$invoke("Failed to save competency");

									for (int j = 0; j < competencies.$length(); j++)
									{
										competencies.$get(j)._delete(null, null, null);
									}
								}
							});
						}
					}
				};
				error = failure;
			}
		});
	}

	/**
	 * Handles actually importing the relationships from the relationship CSV file
	 * 
	 * @memberOf CSVImport
	 * @method importRelations
	 * @private
	 * @static
	 * @param {String} serverUrl
	 * 			URL Prefix for the created competencies (and relationships?)
	 * @param {EcIdentity} owner
	 * 			EcIdentity that will own the created competencies (and relationships?)
	 * @param {Object} file
	 * 			CSV File to import competencies from
	 * @param {int} sourceIndex
	 *			Index (in relation file) of the column containing the relationship source competency ID
	 * @param {int} relationTypeIndex
	 * 			Index (in relation file) of the column containing the relationship type
	 * @param {int} destIndex
	 * 			Index (in relation file) of the column containing the relationship destination competency ID
	 * @param {Array<EcCompetency>} competencies
	 * 			Array of newly created competencies
	 * @param {Callback2<Array<EcCompetency>, Array<EcAlignment>>} success
	 * 			Callback triggered after the relationships have been created
	 * @param {Callback1<Object>} failure
	 * 			Callback triggered if an error during creating the relationships
	 * @param {Callback1<Object>} incremental
	 * 			Callback triggered incrementally during creation to indicate progress
	 */
	private static void importRelations(final String serverUrl, final EcIdentity owner, Object file,
			final Integer sourceIndex, final Integer relationTypeIndex, final Integer destIndex,
			final Array<EcCompetency> competencies, final Callback2<Array<EcCompetency>, Array<EcAlignment>> success,
			final Callback1<Object> failure, final Callback1<Object> incremental)
	{
		final Array<EcAlignment> relations = new Array<>();

		if (sourceIndex == null || sourceIndex < 0)
		{
			failure.$invoke("Source Index not Set");
			return;
		}

		if (relationTypeIndex == null || relationTypeIndex < 0)
		{
			failure.$invoke("Relation Type Index not Set");
			return;
		}

		if (destIndex == null || destIndex < 0)
		{
			failure.$invoke("Destination Index not Set");
			return;
		}

		Papa.parse(file, new PapaParseParams()
		{
			{
				complete = new Callback1<Object>()
				{
					@Override
					public void $invoke(Object results)
					{
						Array<Array<String>> tabularData = (Array<Array<String>>) JSObjectAdapter.$get(results, "data");

						for (int i = 1; i < tabularData.$length(); i++)
						{
							EcAlignment alignment = new EcAlignment();
							String sourceKey = tabularData.$get(i).$get(sourceIndex);
							String relationTypeKey = tabularData.$get(i).$get(relationTypeIndex);
							String destKey = tabularData.$get(i).$get(destIndex);
							if (JSObjectAdapter.$get(importCsvLookup, sourceKey) == null)
								continue;
							if (JSObjectAdapter.$get(importCsvLookup, destKey) == null)
								continue;
							alignment.source = (String) JSObjectAdapter.$get(importCsvLookup, sourceKey);
							alignment.relationType = relationTypeKey;
							alignment.target = (String) JSObjectAdapter.$get(importCsvLookup, destKey);
							if (owner != null)
								alignment.addOwner(owner.ppk.toPk());
							alignment.generateId(serverUrl);
							relations.push(alignment);
						}

						saved = 0;
						for (int i = 0; i < relations.$length(); i++)
						{
							EcAlignment comp = relations.$get(i);
							comp.save(new Callback1<String>()
							{
								public void $invoke(String results)
								{
									saved++;

									if(saved % INCREMENTAL_STEP == 0){
										if(progressObject == null)
											progressObject = new Object();
										
										JSObjectAdapter.$put(progressObject, "relations", saved);
											
										incremental.$invoke(progressObject);
										
										incremental.$invoke(saved);
									}
									
									if (saved == relations.$length())
									{
										success.$invoke(competencies, relations);
									}
								}

							}, new Callback1<String>()
							{
								public void $invoke(String results)
								{
									failure.$invoke("Failed to save competency or relation");

									for (int j = 0; j < competencies.$length(); j++)
									{
										competencies.$get(j)._delete(null, null, null);
									}
									for (int j = 0; j < relations.$length(); j++)
									{
										relations.$get(j)._delete(null, null);
									}
								}
							});
						}
					}
				};
				error = failure;
			}
		});
	}

}
