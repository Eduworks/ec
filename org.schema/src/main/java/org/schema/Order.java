package org.schema;

/**
 * Schema.org/Order
 * An order is a confirmation of a transaction (a receipt), which can contain multiple line items, each represented by an Offer that has been accepted by the customer.
 * @author schema.org
 * @class Order
 * @module org.schema
 * @extends Intangible
 */
public class Order extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Order()
	{
		context="http://schema.org/";
		type="Order";
	}

	/**
	 * Schema.org/orderDelivery
	 * The delivery of the parcel related to this order or order item.
	 * @property orderDelivery
	 * @type ParcelDelivery
	 */
	public ParcelDelivery orderDelivery;

	/**
	 * Schema.org/discountCurrency
	 * The currency (in 3-letter ISO 4217 format) of the discount.
	 * @property discountCurrency
	 * @type Text
	 */
	public String discountCurrency;

	/**
	 * Schema.org/isGift
	 * Was the offer accepted as a gift for someone other than the buyer.
	 * @property isGift
	 * @type Boolean
	 */
	public Boolean isGift;

	/**
	 * Schema.org/broker
	 * An entity that arranges for an exchange between a buyer and a seller.  In most cases a broker never acquires or releases ownership of a product or service involved in an exchange.  If it is not clear whether an entity is a broker, seller, or buyer, the latter two terms are preferred.
	 * @property broker
	 * @type schema,Organization | schema,Person
	 */
	public Object broker;

	/**
	 * Schema.org/discountCode
	 * Code used to redeem a discount.
	 * @property discountCode
	 * @type Text
	 */
	public String discountCode;

	/**
	 * Schema.org/paymentMethod
	 * The name of the credit card or other method of payment for the order.
	 * @property paymentMethod
	 * @type PaymentMethod
	 */
	public PaymentMethod paymentMethod;

	/**
	 * Schema.org/orderNumber
	 * The identifier of the transaction.
	 * @property orderNumber
	 * @type Text
	 */
	public String orderNumber;

	/**
	 * Schema.org/billingAddress
	 * The billing address for the order.
	 * @property billingAddress
	 * @type PostalAddress
	 */
	public PostalAddress billingAddress;

	/**
	 * Schema.org/paymentDueDate
	 * The date that payment is due.
	 * @property paymentDueDate
	 * @type DateTime
	 */
	public String paymentDueDate;

	/**
	 * Schema.org/paymentMethodId
	 * An identifier for the method of payment used (e.g. the last 4 digits of the credit card).
	 * @property paymentMethodId
	 * @type Text
	 */
	public String paymentMethodId;

	/**
	 * Schema.org/orderStatus
	 * The current status of the order.
	 * @property orderStatus
	 * @type OrderStatus
	 */
	public OrderStatus orderStatus;

	/**
	 * Schema.org/paymentUrl
	 * The URL for sending a payment.
	 * @property paymentUrl
	 * @type URL
	 */
	public String paymentUrl;

	/**
	 * Schema.org/orderedItem
	 * The item ordered.
	 * @property orderedItem
	 * @type schema,OrderItem | schema,Product
	 */
	public Object orderedItem;

	/**
	 * Schema.org/seller
	 * An entity which offers (sells / leases / lends / loans) the services / goods.  A seller may also be a provider.
	 * @property seller
	 * @type schema,Organization | schema,Person
	 */
	public Object seller;

	/**
	 * Schema.org/customer
	 * Party placing the order or paying the invoice.
	 * @property customer
	 * @type schema,Organization | schema,Person
	 */
	public Object customer;

	/**
	 * Schema.org/paymentDue
	 * The date that payment is due.
	 * @property paymentDue
	 * @type DateTime
	 */
	public String paymentDue;

	/**
	 * Schema.org/acceptedOffer
	 * The offer(s) -- e.g., product, quantity and price combinations -- included in the order.
	 * @property acceptedOffer
	 * @type Offer
	 */
	public Offer acceptedOffer;

	/**
	 * Schema.org/confirmationNumber
	 * A number that confirms the given order or payment has been received.
	 * @property confirmationNumber
	 * @type Text
	 */
	public String confirmationNumber;

	/**
	 * Schema.org/orderDate
	 * Date order was placed.
	 * @property orderDate
	 * @type DateTime
	 */
	public String orderDate;

	/**
	 * Schema.org/merchant
	 * 'merchant' is an out-dated term for 'seller'.
	 * @property merchant
	 * @type schema,Organization | schema,Person
	 */
	public Object merchant;

	/**
	 * Schema.org/partOfInvoice
	 * The order is being paid as part of the referenced Invoice.
	 * @property partOfInvoice
	 * @type Invoice
	 */
	public Invoice partOfInvoice;

	/**
	 * Schema.org/discount
	 * Any discount applied (to an Order).
	 * @property discount
	 * @type schema,Number | schema,Text
	 */
	public Object discount;

}