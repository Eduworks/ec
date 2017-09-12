package org.schema;

/**
 * Schema.org/Dataset
 * A body of structured information describing some topic(s) of interest.
 *
 * @author schema.org
 * @class Dataset
 * @module org.schema
 * @extends CreativeWork
 */
public class Dataset extends CreativeWork {
	/**
	 * Schema.org/spatial
	 * The range of spatial applicability of a dataset, e.g. for a dataset of New York weather, the state of New York.
	 *
	 * @property spatial
	 * @type Place
	 */
	public Place spatial;
	/**
	 * Schema.org/includedDataCatalog
	 * A data catalog which contains this dataset (this property was previously 'catalog', preferred name is now 'includedInDataCatalog').
	 *
	 * @property includedDataCatalog
	 * @type DataCatalog
	 */
	public DataCatalog includedDataCatalog;
	/**
	 * Schema.org/includedInDataCatalog
	 * A data catalog which contains this dataset.
	 *
	 * @property includedInDataCatalog
	 * @type DataCatalog
	 */
	public DataCatalog includedInDataCatalog;
	/**
	 * Schema.org/temporal
	 * The range of temporal applicability of a dataset, e.g. for a 2011 census dataset, the year 2011 (in ISO 8601 time interval format).
	 *
	 * @property temporal
	 * @type DateTime
	 */
	public String temporal;
	/**
	 * Schema.org/datasetTimeInterval
	 * The range of temporal applicability of a dataset, e.g. for a 2011 census dataset, the year 2011 (in ISO 8601 time interval format).
	 *
	 * @property datasetTimeInterval
	 * @type DateTime
	 */
	public String datasetTimeInterval;
	/**
	 * Schema.org/distribution
	 * A downloadable form of this dataset, at a specific location, in a specific format.
	 *
	 * @property distribution
	 * @type DataDownload
	 */
	public DataDownload distribution;
	/**
	 * Schema.org/catalog
	 * A data catalog which contains this dataset.
	 *
	 * @property catalog
	 * @type DataCatalog
	 */
	public DataCatalog catalog;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Dataset() {
		context = "http://schema.org/";
		type = "Dataset";
	}

}