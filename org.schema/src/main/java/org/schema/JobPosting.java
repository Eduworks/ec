package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/JobPosting
 * A listing that describes a job opening in a certain organization.
 * @author schema.org
 * @class JobPosting
 * @module org.schema
 * @extends Intangible
 */
public class JobPosting extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public JobPosting()
	{
		context="http://schema.org/";
		type="JobPosting";
	}

	/**
	 * Schema.org/baseSalary
	 * The base salary of the job or of an employee in an EmployeeRole.
	 * @property baseSalary
	 * @type schema,Number | schema,PriceSpecification | schema,MonetaryAmount
	 */
	public Object baseSalary;

	/**
	 * Schema.org/benefits
	 * Description of benefits associated with the job.
	 * @property benefits
	 * @type Text
	 */
	public String benefits;

	/**
	 * Schema.org/jobBenefits
	 * Description of benefits associated with the job.
	 * @property jobBenefits
	 * @type Text
	 */
	public String jobBenefits;

	/**
	 * Schema.org/experienceRequirements
	 * Description of skills and experience needed for the position.
	 * @property experienceRequirements
	 * @type Text
	 */
	public String experienceRequirements;

	/**
	 * Schema.org/hiringOrganization
	 * Organization offering the job position.
	 * @property hiringOrganization
	 * @type Organization
	 */
	public Organization hiringOrganization;

	/**
	 * Schema.org/employmentType
	 * Type of employment (e.g. full-time, part-time, contract, temporary, seasonal, internship).
	 * @property employmentType
	 * @type Text
	 */
	public String employmentType;

	/**
	 * Schema.org/workHours
	 * The typical working hours for this job (e.g. 1st shift, night shift, 8am-5pm).
	 * @property workHours
	 * @type Text
	 */
	public String workHours;

	/**
	 * Schema.org/responsibilities
	 * Responsibilities associated with this role.
	 * @property responsibilities
	 * @type Text
	 */
	public String responsibilities;

	/**
	 * Schema.org/skills
	 * Skills required to fulfill this role.
	 * @property skills
	 * @type Text
	 */
	public String skills;

	/**
	 * Schema.org/qualifications
	 * Specific qualifications required for this role.
	 * @property qualifications
	 * @type Text
	 */
	public String qualifications;

	/**
	 * Schema.org/occupationalCategory
	 * Category or categories describing the job. Use BLS O*NET-SOC taxonomy: http://www.onetcenter.org/taxonomy.html. Ideally includes textual label and formal code, with the property repeated for each applicable value.
	 * @property occupationalCategory
	 * @type Text
	 */
	public String occupationalCategory;

	/**
	 * Schema.org/incentives
	 * Description of bonus and commission compensation aspects of the job.
	 * @property incentives
	 * @type Text
	 */
	public String incentives;

	/**
	 * Schema.org/validThrough
	 * The date after when the item is not valid. For example the end of an offer, salary period, or a period of opening hours.
	 * @property validThrough
	 * @type DateTime
	 */
	public String validThrough;

	/**
	 * Schema.org/title
	 * The title of the job.
	 * @property title
	 * @type Text
	 */
	public String title;

	/**
	 * Schema.org/educationRequirements
	 * Educational background needed for the position.
	 * @property educationRequirements
	 * @type Text
	 */
	public String educationRequirements;

	/**
	 * Schema.org/specialCommitments
	 * Any special commitments associated with this job posting. Valid entries include VeteranCommit, MilitarySpouseCommit, etc.
	 * @property specialCommitments
	 * @type Text
	 */
	public String specialCommitments;

	/**
	 * Schema.org/incentiveCompensation
	 * Description of bonus and commission compensation aspects of the job.
	 * @property incentiveCompensation
	 * @type Text
	 */
	public String incentiveCompensation;

	/**
	 * Schema.org/salaryCurrency
	 * The currency (coded using [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) ) used for the main salary information in this job posting or for this employee.
	 * @property salaryCurrency
	 * @type Text
	 */
	public String salaryCurrency;

	/**
	 * Schema.org/jobLocation
	 * A (typically single) geographic location associated with the job position.
	 * @property jobLocation
	 * @type Place
	 */
	public Place jobLocation;

	/**
	 * Schema.org/industry
	 * The industry associated with the job position.
	 * @property industry
	 * @type Text
	 */
	public String industry;

	/**
	 * Schema.org/datePosted
	 * Publication date for the job posting.
	 * @property datePosted
	 * @type Date
	 */
	public String datePosted;

}