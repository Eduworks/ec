package org.schema;

/**
 * Schema.org/ParcelDelivery
 * The delivery of a parcel either via the postal service or a commercial service.
 *
 * @author schema.org
 * @class ParcelDelivery
 * @module org.schema
 * @extends Intangible
 */
public class ParcelDelivery extends Intangible {
	/**
	 * Schema.org/provider
	 * The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller.
	 *
	 * @property provider
	 * @type Person
	 */
	public Person provider;
	/**
	 * Schema.org/trackingUrl
	 * Tracking url for the parcel delivery.
	 *
	 * @property trackingUrl
	 * @type URL
	 */
	public String trackingUrl;
	/**
	 * Schema.org/deliveryAddress
	 * Destination address.
	 *
	 * @property deliveryAddress
	 * @type PostalAddress
	 */
	public PostalAddress deliveryAddress;
	/**
	 * Schema.org/trackingNumber
	 * Shipper tracking number.
	 *
	 * @property trackingNumber
	 * @type Text
	 */
	public String trackingNumber;
	/**
	 * Schema.org/hasDeliveryMethod
	 * Method used for delivery or shipping.
	 *
	 * @property hasDeliveryMethod
	 * @type DeliveryMethod
	 */
	public DeliveryMethod hasDeliveryMethod;
	/**
	 * Schema.org/deliveryStatus
	 * New entry added as the package passes through each leg of its journey (from shipment to final delivery).
	 *
	 * @property deliveryStatus
	 * @type DeliveryEvent
	 */
	public DeliveryEvent deliveryStatus;
	/**
	 * Schema.org/carrier
	 * 'carrier' is an out-dated term indicating the 'provider' for parcel delivery and flights.
	 *
	 * @property carrier
	 * @type Organization
	 */
	public Organization carrier;
	/**
	 * Schema.org/originAddress
	 * Shipper's address.
	 *
	 * @property originAddress
	 * @type PostalAddress
	 */
	public PostalAddress originAddress;
	/**
	 * Schema.org/itemShipped
	 * Item(s) being shipped.
	 *
	 * @property itemShipped
	 * @type Product
	 */
	public Product itemShipped;
	/**
	 * Schema.org/partOfOrder
	 * The overall order the items in this delivery were included in.
	 *
	 * @property partOfOrder
	 * @type Order
	 */
	public Order partOfOrder;
	/**
	 * Schema.org/expectedArrivalFrom
	 * The earliest date the package may arrive.
	 *
	 * @property expectedArrivalFrom
	 * @type DateTime
	 */
	public String expectedArrivalFrom;
	/**
	 * Schema.org/expectedArrivalUntil
	 * The latest date the package may arrive.
	 *
	 * @property expectedArrivalUntil
	 * @type DateTime
	 */
	public String expectedArrivalUntil;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ParcelDelivery() {
		context = "http://schema.org/";
		type = "ParcelDelivery";
	}

}