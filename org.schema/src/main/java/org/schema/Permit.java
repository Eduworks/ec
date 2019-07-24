package org.schema;

/**
 * Schema.org/Permit
 * A permit issued by an organization, e.g. a parking pass.
 *
 * @author schema.org
 * @class Permit
 * @module org.schema
 * @extends Intangible
 */
public class Permit extends Intangible {
	/**
	 * Schema.org/validFor
	 * The time validity of the permit.
	 *
	 * @property validFor
	 * @type Duration
	 */
	public Duration validFor;
	/**
	 * Schema.org/validUntil
	 * The date when the item is no longer valid.
	 *
	 * @property validUntil
	 * @type Date
	 */
	public String validUntil;
	/**
	 * Schema.org/validFrom
	 * The date when the item becomes valid.
	 *
	 * @property validFrom
	 * @type DateTime
	 */
	public String validFrom;
	/**
	 * Schema.org/issuedBy
	 * The organization issuing the ticket or permit.
	 *
	 * @property issuedBy
	 * @type Organization
	 */
	public Organization issuedBy;
	/**
	 * Schema.org/issuedThrough
	 * The service through with the permit was granted.
	 *
	 * @property issuedThrough
	 * @type Service
	 */
	public Service issuedThrough;
	/**
	 * Schema.org/permitAudience
	 * The target audience for this permit.
	 *
	 * @property permitAudience
	 * @type Audience
	 */
	public Audience permitAudience;
	/**
	 * Schema.org/validIn
	 * The geographic area where the permit is valid.
	 *
	 * @property validIn
	 * @type AdministrativeArea
	 */
	public AdministrativeArea validIn;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Permit() {
		context = "http://schema.org/";
		type = "Permit";
	}

}