package org.schema;

/**
 * Schema.org/ReceiveAction
 * The act of physically/electronically taking delivery of an object thathas been transferred from an origin to a destination. Reciprocal of SendAction.\n\nRelated actions:\n\n* [[SendAction]]: The reciprocal of ReceiveAction.\n* [[TakeAction]]: Unlike TakeAction, ReceiveAction does not imply that the ownership has been transfered (e.g. I can receive a package, but it does not mean the package is now mine).
 *
 * @author schema.org
 * @class ReceiveAction
 * @module org.schema
 * @extends TransferAction
 */
public class ReceiveAction extends TransferAction {
	/**
	 * Schema.org/deliveryMethod
	 * A sub property of instrument. The method of delivery.
	 *
	 * @property deliveryMethod
	 * @type DeliveryMethod
	 */
	public DeliveryMethod deliveryMethod;
	/**
	 * Schema.org/sender
	 * A sub property of participant. The participant who is at the sending end of the action.
	 *
	 * @property sender
	 * @type Audience
	 */
	public Audience sender;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ReceiveAction() {
		context = "http://schema.org/";
		type = "ReceiveAction";
	}

}