package org.cass.importer;

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
 * 
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
	 * 
	 * @memberOf CSVImport
	 * @method analyzeFile
	 * @static
	 * @param {Object} file
	 * @param {Callback1<Object>} success
	 * @param {Callback1<Object>} failure
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
	 * @memberOf CSVImport
	 * @method transformId
	 * @private
	 * @static
	 * @param {String} oldId
	 * @param {EcRemoteLinkedData} newObject
	 * @param {String} selectedServer
	 */
	private static void transformId(String oldId, EcRemoteLinkedData newObject, String selectedServer)
	{
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
	 * @memberOf CSVImport
	 * @method importCompetencies
	 * @static
	 * @param {Object} file
	 * @param {String} serverUrl
	 * @param {EcIdentity} owner
	 * @param {int} nameIndex
	 * @param {int} descriptionIndex
	 * @param {int} scopeIndex
	 * @param {int} idIndex
	 * @param {Object} relations
	 * @param {int} sourceIndex
	 * @param {int} relationTypeIndex
	 * @param {int} destIndex
	 * @param {Callback2<Array<EcCompetency>, Array<EcAlignment>>} success
	 * @param {Callback1<Object>} failure
	 * @param {Callback1<Object>} incremental
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
								failure.$invoke("One or more names is blank or could not be found in the CSV.");
								return;
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
							if (idIndex != null && idIndex >= 0)
								JSObjectAdapter.$put(importCsvLookup, tabularData.$get(i).$get(idIndex), competency.shortId());
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
	 * @memberOf CSVImport
	 * @method importRelations
	 * @private
	 * @static
	 * @param {String} serverUrl
	 * @param {EcIdentity} owner
	 * @param {Object} file
	 * @param {int} sourceIndex
	 * @param {int} relationTypeIndex
	 * @param {int} destIndex
	 * @param {Array<EcCompetency>} competencies
	 * @param {Callback2<Array<EcCompetency>, Array<EcAlignment>>} success
	 * @param {Callback1<Object>} failure
	 * @param {Callback1<Object>} incremental
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
								return;
							if (JSObjectAdapter.$get(importCsvLookup, destKey) == null)
								return;
							alignment.source = (String) JSObjectAdapter.$get(importCsvLookup, sourceKey);
							alignment.relationType = relationTypeKey;
							alignment.target = (String) JSObjectAdapter.$get(importCsvLookup, destKey);
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
