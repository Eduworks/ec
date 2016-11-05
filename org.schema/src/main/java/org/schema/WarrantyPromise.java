package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WarrantyPromise
 * A structured value representing the duration and scope of services that will be provided to a customer free of charge in case of a defect or malfunction of a product.
 * @author schema.org
 * @module schema.org
 * @class WarrantyPromise
 * @extends StructuredValue
 */
public class WarrantyPromise extends StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WarrantyPromise()
	{
		context="http://schema.org/";
		type="WarrantyPromise";
	}

	/**
	 * Schema.org/durationOfWarranty
	 * The duration of the warranty promise. Common unitCode values are ANN for year, MON for months, or DAY for days.
	 * @property durationOfWarranty
	 * @type QuantitativeValue
	 */
	public QuantitativeValue durationOfWarranty;

	/**
	 * Schema.org/warrantyScope
	 * The scope of the warranty promise.
	 * @property warrantyScope
	 * @type WarrantyScope
	 */
	public WarrantyScope warrantyScope;

}