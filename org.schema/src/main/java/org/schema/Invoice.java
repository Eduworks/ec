package org.schema;

/**
 * Schema.org/Invoice
 * A statement of the money due for goods or services; a bill.
 * @author schema.org
 * @class Invoice
 * @module org.schema
 * @extends Intangible
 */
public class Invoice extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Invoice()
	{
		context="http://schema.org/";
		type="Invoice";
	}

	/**
	 * Schema.org/referencesOrder
	 * The Order(s) related to this Invoice. One or more Orders may be combined into a single Invoice.
	 * @property referencesOrder
	 * @type Order
	 */
	public Order referencesOrder;

	/**
	 * Schema.org/broker
	 * An entity that arranges for an exchange between a buyer and a seller.  In most cases a broker never acquires or releases ownership of a product or service involved in an exchange.  If it is not clear whether an entity is a broker, seller, or buyer, the latter two terms are preferred.
	 * @property broker
	 * @type schema,Organization | schema,Person
	 */
	public Object broker;

	/**
	 * Schema.org/minimumPaymentDue
	 * The minimum payment required at this time.
	 * @property minimumPaymentDue
	 * @type schema,PriceSpecification | schema,MonetaryAmount
	 */
	public Object minimumPaymentDue;

	/**
	 * Schema.org/scheduledPaymentDate
	 * The date the invoice is scheduled to be paid.
	 * @property scheduledPaymentDate
	 * @type Date
	 */
	public String scheduledPaymentDate;

	/**
	 * Schema.org/paymentMethod
	 * The name of the credit card or other method of payment for the order.
	 * @property paymentMethod
	 * @type PaymentMethod
	 */
	public PaymentMethod paymentMethod;

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
	 * Schema.org/totalPaymentDue
	 * The total amount due.
	 * @property totalPaymentDue
	 * @type schema,PriceSpecification | schema,MonetaryAmount
	 */
	public Object totalPaymentDue;

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
	 * Schema.org/paymentStatus
	 * The status of payment; whether the invoice has been paid or not.
	 * @property paymentStatus
	 * @type schema,Text | schema,PaymentStatusType
	 */
	public Object paymentStatus;

	/**
	 * Schema.org/accountId
	 * The identifier for the account the payment will be applied to.
	 * @property accountId
	 * @type Text
	 */
	public String accountId;

	/**
	 * Schema.org/provider
	 * The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller.
	 * @property provider
	 * @type schema,Organization | schema,Person
	 */
	public Object provider;

	/**
	 * Schema.org/confirmationNumber
	 * A number that confirms the given order or payment has been received.
	 * @property confirmationNumber
	 * @type Text
	 */
	public String confirmationNumber;

	/**
	 * Schema.org/billingPeriod
	 * The time interval used to compute the invoice.
	 * @property billingPeriod
	 * @type Duration
	 */
	public Duration billingPeriod;

	/**
	 * Schema.org/category
	 * A category for the item. Greater signs or slashes can be used to informally indicate a category hierarchy.
	 * @property category
	 * @type schema,Text | schema,Thing
	 */
	public Object category;

}