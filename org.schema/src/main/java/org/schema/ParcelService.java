package org.schema;

/**
 * Schema.org/ParcelService
 * A private parcel service as the delivery mode available for a certain offer.\n\nCommonly used values:\n\n* http://purl.org/goodrelations/v1#DHL\n* http://purl.org/goodrelations/v1#FederalExpress\n* http://purl.org/goodrelations/v1#UPS
 *
 * @author schema.org
 * @class ParcelService
 * @module org.schema
 * @extends DeliveryMethod
 */
public class ParcelService extends DeliveryMethod {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ParcelService() {
		context = "http://schema.org/";
		type = "ParcelService";
	}

}