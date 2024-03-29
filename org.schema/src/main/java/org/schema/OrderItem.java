package org.schema;

/**
 * Schema.org/OrderItem
 * An order item is a line of an order. It includes the quantity and shipping details of a bought offer.
 *
 * @author schema.org
 * @class OrderItem
 * @module org.schema
 * @extends Intangible
 */
public class OrderItem extends Intangible {
	/**
	 * Schema.org/orderItemStatus
	 * The current status of the order item.
	 *
	 * @property orderItemStatus
	 * @type OrderStatus
	 */
	public OrderStatus orderItemStatus;
	/**
	 * Schema.org/orderQuantity
	 * The number of the item ordered. If the property is not set, assume the quantity is one.
	 *
	 * @property orderQuantity
	 * @type Number
	 */
	public Double orderQuantity;
	/**
	 * Schema.org/orderedItem
	 * The item ordered.
	 *
	 * @property orderedItem
	 * @type Product
	 */
	public Product orderedItem;
	/**
	 * Schema.org/orderDelivery
	 * The delivery of the parcel related to this order or order item.
	 *
	 * @property orderDelivery
	 * @type ParcelDelivery
	 */
	public ParcelDelivery orderDelivery;
	/**
	 * Schema.org/orderItemNumber
	 * The identifier of the order item.
	 *
	 * @property orderItemNumber
	 * @type Text
	 */
	public String orderItemNumber;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OrderItem() {
		context = "http://schema.org/";
		type = "OrderItem";
	}

}