package org.schema;

/**
 * Schema.org/BorrowAction
 * The act of obtaining an object under an agreement to return it at a later date. Reciprocal of LendAction.\n\nRelated actions:\n\n* [[LendAction]]: Reciprocal of BorrowAction.
 *
 * @author schema.org
 * @class BorrowAction
 * @module org.schema
 * @extends TransferAction
 */
public class BorrowAction extends TransferAction {
	/**
	 * Schema.org/lender
	 * A sub property of participant. The person that lends the object being borrowed.
	 *
	 * @property lender
	 * @type Organization
	 */
	public Organization lender;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BorrowAction() {
		context = "http://schema.org/";
		type = "BorrowAction";
	}

}