package org.schema;

/**
 * Schema.org/EmployeeRole
 * A subclass of OrganizationRole used to describe employee relationships.
 *
 * @author schema.org
 * @class EmployeeRole
 * @module org.schema
 * @extends OrganizationRole
 */
public class EmployeeRole extends OrganizationRole {
	/**
	 * Schema.org/salaryCurrency
	 * The currency (coded using [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) ) used for the main salary information in this job posting or for this employee.
	 *
	 * @property salaryCurrency
	 * @type Text
	 */
	public String salaryCurrency;
	/**
	 * Schema.org/baseSalary
	 * The base salary of the job or of an employee in an EmployeeRole.
	 *
	 * @property baseSalary
	 * @type MonetaryAmount
	 */
	public MonetaryAmount baseSalary;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public EmployeeRole() {
		context = "http://schema.org/";
		type = "EmployeeRole";
	}

}