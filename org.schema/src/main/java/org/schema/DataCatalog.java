package org.schema;

/**
 * Schema.org/DataCatalog
 * A collection of datasets.
 * @author schema.org
 * @class DataCatalog
 * @module org.schema
 * @extends CreativeWork
 */
public class DataCatalog extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DataCatalog()
	{
		context="http://schema.org/";
		type="DataCatalog";
	}

	/**
	 * Schema.org/dataset
	 * A dataset contained in this catalog.
	 * @property dataset
	 * @type Dataset
	 */
	public Dataset dataset;

}