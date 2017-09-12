package org.schema;

/**
 * Schema.org/LendAction
 * The act of providing an object under an agreement that it will be returned at a later date. Reciprocal of BorrowAction.\n\nRelated actions:\n\n* [[BorrowAction]]: Reciprocal of LendAction.
 *
 * @author schema.org
 * @class LendAction
 * @module org.schema
 * @extends TransferAction
 */
public class LendAction extends TransferAction {
	/**
	 * Schema.org/borrower
	 * A sub property of participant. The person that borrows the object being lent.
	 *
	 * @property borrower
	 * @type Person
	 */
	public Person borrower;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LendAction() {
		context = "http://schema.org/";
		type = "LendAction";
	}

}