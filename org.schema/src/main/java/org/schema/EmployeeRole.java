package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EmployeeRole
 * A subclass of OrganizationRole used to describe employee relationships.
 * @author schema.org
 * @module schema.org
 * @class EmployeeRole
 * @extends OrganizationRole
 */
public class EmployeeRole extends OrganizationRole
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EmployeeRole()
	{
		context="http://schema.org/";
		type="EmployeeRole";
	}

	/**
	 * Schema.org/baseSalary
	 * The base salary of the job or of an employee in an EmployeeRole.
	 * @property baseSalary
	 * @type schema,MonetaryAmount | schema,Number | schema,PriceSpecification	 */
	public Object baseSalary;

	/**
	 * Schema.org/salaryCurrency
	 * The currency (coded using [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) ) used for the main salary information in this job posting or for this employee.
	 * @property salaryCurrency
	 * @type Text
	 */
	public String salaryCurrency;

}