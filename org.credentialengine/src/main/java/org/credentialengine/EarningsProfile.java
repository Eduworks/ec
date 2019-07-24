package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/EarningsProfile
 * Entity that describes earning and related statistical information for a given credential.
 * @author credentialengine.org
 * @class EarningsProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class EarningsProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EarningsProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="EarningsProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * Effective date of the content of a credential, assessment or learning opportunity.
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;

	/**
	 * http://purl.org/ctdl/terms/highEarnings
	 * Upper interquartile earnings.
	 * @property highEarnings
	 * @type integer
	 */
	public Integer highEarnings;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * Geographic or political region in which the credential is formally applicable or an organization has authority to act.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/lowEarnings
	 * Lower interquartile earnings.
	 * @property lowEarnings
	 * @type integer
	 */
	public Integer lowEarnings;

	/**
	 * http://purl.org/ctdl/terms/medianEarnings
	 * Median earnings.
	 * @property medianEarnings
	 * @type integer
	 */
	public Integer medianEarnings;

	/**
	 * http://purl.org/ctdl/terms/postReceiptMonths
	 * Number of months after earning a credential when employment and earnings data is collected.
	 * Number of months usually range between 3 months (one quarter) to ten years.
	 * @property postReceiptMonths
	 * @type integer
	 */
	public Integer postReceiptMonths;

	/**
	 * http://purl.org/ctdl/terms/region
	 * Entity that describes the longitude, latitude and other location details of an area.
	 * @property region
	 * @type Place
	 */
	public Place region;

	/**
	 * http://purl.org/ctdl/terms/source
	 * Authoritative source of an entity's information.
	 * Citation or description of an authoritative souce from which information or description has been derived.
	 * @property source
	 * @type anyURI
	 */
	public String source;

}