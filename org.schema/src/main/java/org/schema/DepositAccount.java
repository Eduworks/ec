package org.schema;

/**
 * Schema.org/DepositAccount
 * A type of Bank Account with a main purpose of depositing funds to gain interest or other benefits.
 *
 * @author schema.org
 * @class DepositAccount
 * @module org.schema
 * @extends BankAccount
 */
public class DepositAccount extends BankAccount {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DepositAccount() {
		context = "http://schema.org/";
		type = "DepositAccount";
	}

}