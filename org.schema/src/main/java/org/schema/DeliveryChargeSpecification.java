package org.schema;

/**
 * Schema.org/DeliveryChargeSpecification
 * The price for the delivery of an offer using a particular delivery method.
 *
 * @author schema.org
 * @class DeliveryChargeSpecification
 * @module org.schema
 * @extends PriceSpecification
 */
public class DeliveryChargeSpecification extends PriceSpecification {
	/**
	 * Schema.org/ineligibleRegion
	 * The ISO 3166-1 (ISO 3166-1 alpha-2) or ISO 3166-2 code, the place, or the GeoShape for the geo-political region(s) for which the offer or delivery charge specification is not valid, e.g. a region where the transaction is not allowed.\n\nSee also [[eligibleRegion]].
	 *
	 * @property ineligibleRegion
	 * @type GeoShape
	 */
	public GeoShape ineligibleRegion;
	/**
	 * Schema.org/appliesToDeliveryMethod
	 * The delivery method(s) to which the delivery charge or payment charge specification applies.
	 *
	 * @property appliesToDeliveryMethod
	 * @type DeliveryMethod
	 */
	public DeliveryMethod appliesToDeliveryMethod;
	/**
	 * Schema.org/areaServed
	 * The geographic area where a service or offered item is provided.
	 *
	 * @property areaServed
	 * @type Place
	 */
	public Place areaServed;
	/**
	 * Schema.org/eligibleRegion
	 * The ISO 3166-1 (ISO 3166-1 alpha-2) or ISO 3166-2 code, the place, or the GeoShape for the geo-political region(s) for which the offer or delivery charge specification is valid.\n\nSee also [[ineligibleRegion]].
	 *
	 * @property eligibleRegion
	 * @type Text
	 */
	public String eligibleRegion;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DeliveryChargeSpecification() {
		context = "http://schema.org/";
		type = "DeliveryChargeSpecification";
	}

}