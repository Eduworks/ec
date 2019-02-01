package org.schema;

/**
 * Schema.org/Person
 * A person (alive, dead, undead, or fictional).
 *
 * @author schema.org
 * @class Person
 * @module org.schema
 * @extends Thing
 */
public class Person extends Thing {
	/**
	 * Schema.org/address
	 * Physical address of the item.
	 *
	 * @property address
	 * @type PostalAddress
	 */
	public PostalAddress address;
	/**
	 * Schema.org/spouse
	 * The person's spouse.
	 *
	 * @property spouse
	 * @type Person
	 */
	public Person spouse;
	/**
	 * Schema.org/funder
	 * A person or organization that supports (sponsors) something through some kind of financial contribution.
	 *
	 * @property funder
	 * @type Person
	 */
	public Person funder;
	/**
	 * Schema.org/colleagues
	 * A colleague of the person.
	 *
	 * @property colleagues
	 * @type Person
	 */
	public Person colleagues;
	/**
	 * Schema.org/deathDate
	 * Date of death.
	 *
	 * @property deathDate
	 * @type Date
	 */
	public String deathDate;
	/**
	 * Schema.org/memberOf
	 * An Organization (or ProgramMembership) to which this Person or Organization belongs.
	 *
	 * @property memberOf
	 * @type Organization
	 */
	public Organization memberOf;
	/**
	 * Schema.org/height
	 * The height of the item.
	 *
	 * @property height
	 * @type Distance
	 */
	public Distance height;
	/**
	 * Schema.org/workLocation
	 * A contact location for a person's place of work.
	 *
	 * @property workLocation
	 * @type ContactPoint
	 */
	public ContactPoint workLocation;
	/**
	 * Schema.org/netWorth
	 * The total financial value of the person as calculated by subtracting assets from liabilities.
	 *
	 * @property netWorth
	 * @type PriceSpecification
	 */
	public PriceSpecification netWorth;
	/**
	 * Schema.org/children
	 * A child of the person.
	 *
	 * @property children
	 * @type Person
	 */
	public Person children;
	/**
	 * Schema.org/jobTitle
	 * The job title of the person (for example, Financial Manager).
	 *
	 * @property jobTitle
	 * @type Text
	 */
	public String jobTitle;
	/**
	 * Schema.org/hasOfferCatalog
	 * Indicates an OfferCatalog listing for this Organization, Person, or Service.
	 *
	 * @property hasOfferCatalog
	 * @type OfferCatalog
	 */
	public OfferCatalog hasOfferCatalog;
	/**
	 * Schema.org/deathPlace
	 * The place where the person died.
	 *
	 * @property deathPlace
	 * @type Place
	 */
	public Place deathPlace;
	/**
	 * Schema.org/globalLocationNumber
	 * The [Global Location Number](http://www.gs1.org/gln) (GLN, sometimes also referred to as International Location Number or ILN) of the respective organization, person, or place. The GLN is a 13-digit number used to identify parties and physical locations.
	 *
	 * @property globalLocationNumber
	 * @type Text
	 */
	public String globalLocationNumber;
	/**
	 * Schema.org/birthPlace
	 * The place where the person was born.
	 *
	 * @property birthPlace
	 * @type Place
	 */
	public Place birthPlace;
	/**
	 * Schema.org/gender
	 * Gender of the person. While schema:Male and schema:Female may be used, text strings are also acceptable for people who do not identify as a binary gender.
	 *
	 * @property gender
	 * @type Text
	 */
	public String gender;
	/**
	 * Schema.org/parents
	 * A parents of the person.
	 *
	 * @property parents
	 * @type Person
	 */
	public Person parents;
	/**
	 * Schema.org/alumniOf
	 * An organization that the person is an alumni of.
	 *
	 * @property alumniOf
	 * @type EducationalOrganization
	 */
	public EducationalOrganization alumniOf;
	/**
	 * Schema.org/homeLocation
	 * A contact location for a person's residence.
	 *
	 * @property homeLocation
	 * @type ContactPoint
	 */
	public ContactPoint homeLocation;
	/**
	 * Schema.org/duns
	 * The Dun & Bradstreet DUNS number for identifying an organization or business person.
	 *
	 * @property duns
	 * @type Text
	 */
	public String duns;
	/**
	 * Schema.org/taxID
	 * The Tax / Fiscal ID of the organization or person, e.g. the TIN in the US or the CIF/NIF in Spain.
	 *
	 * @property taxID
	 * @type Text
	 */
	public String taxID;
	/**
	 * Schema.org/award
	 * An award won by or for this item.
	 *
	 * @property award
	 * @type Text
	 */
	public String award;
	/**
	 * Schema.org/birthDate
	 * Date of birth.
	 *
	 * @property birthDate
	 * @type Date
	 */
	public String birthDate;
	/**
	 * Schema.org/makesOffer
	 * A pointer to products or services offered by the organization or person.
	 *
	 * @property makesOffer
	 * @type Offer
	 */
	public Offer makesOffer;
	/**
	 * Schema.org/contactPoints
	 * A contact point for a person or organization.
	 *
	 * @property contactPoints
	 * @type ContactPoint
	 */
	public ContactPoint contactPoints;
	/**
	 * Schema.org/awards
	 * Awards won by or for this item.
	 *
	 * @property awards
	 * @type Text
	 */
	public String awards;
	/**
	 * Schema.org/familyName
	 * Family name. In the U.S., the last name of an Person. This can be used along with givenName instead of the name property.
	 *
	 * @property familyName
	 * @type Text
	 */
	public String familyName;
	/**
	 * Schema.org/seeks
	 * A pointer to products or services sought by the organization or person (demand).
	 *
	 * @property seeks
	 * @type Demand
	 */
	public Demand seeks;
	/**
	 * Schema.org/sibling
	 * A sibling of the person.
	 *
	 * @property sibling
	 * @type Person
	 */
	public Person sibling;
	/**
	 * Schema.org/performerIn
	 * Event that this person is a performer or participant in.
	 *
	 * @property performerIn
	 * @type Event
	 */
	public Event performerIn;
	/**
	 * Schema.org/honorificPrefix
	 * An honorific prefix preceding a Person's name such as Dr/Mrs/Mr.
	 *
	 * @property honorificPrefix
	 * @type Text
	 */
	public String honorificPrefix;
	/**
	 * Schema.org/additionalName
	 * An additional name for a Person, can be used for a middle name.
	 *
	 * @property additionalName
	 * @type Text
	 */
	public String additionalName;
	/**
	 * Schema.org/siblings
	 * A sibling of the person.
	 *
	 * @property siblings
	 * @type Person
	 */
	public Person siblings;
	/**
	 * Schema.org/telephone
	 * The telephone number.
	 *
	 * @property telephone
	 * @type Text
	 */
	public String telephone;
	/**
	 * Schema.org/email
	 * Email address.
	 *
	 * @property email
	 * @type Text
	 */
	public String email;
	/**
	 * Schema.org/weight
	 * The weight of the product or person.
	 *
	 * @property weight
	 * @type QuantitativeValue
	 */
	public QuantitativeValue weight;
	/**
	 * Schema.org/contactPoint
	 * A contact point for a person or organization.
	 *
	 * @property contactPoint
	 * @type ContactPoint
	 */
	public ContactPoint contactPoint;
	/**
	 * Schema.org/colleague
	 * A colleague of the person.
	 *
	 * @property colleague
	 * @type URL
	 */
	public String colleague;
	/**
	 * Schema.org/givenName
	 * Given name. In the U.S., the first name of a Person. This can be used along with familyName instead of the name property.
	 *
	 * @property givenName
	 * @type Text
	 */
	public String givenName;
	/**
	 * Schema.org/naics
	 * The North American Industry Classification System (NAICS) code for a particular organization or business person.
	 *
	 * @property naics
	 * @type Text
	 */
	public String naics;
	/**
	 * Schema.org/hasPOS
	 * Points-of-Sales operated by the organization or person.
	 *
	 * @property hasPOS
	 * @type Place
	 */
	public Place hasPOS;
	/**
	 * Schema.org/parent
	 * A parent of this person.
	 *
	 * @property parent
	 * @type Person
	 */
	public Person parent;
	/**
	 * Schema.org/owns
	 * Products owned by the organization or person.
	 *
	 * @property owns
	 * @type OwnershipInfo
	 */
	public OwnershipInfo owns;
	/**
	 * Schema.org/affiliation
	 * An organization that this person is affiliated with. For example, a school/university, a club, or a team.
	 *
	 * @property affiliation
	 * @type Organization
	 */
	public Organization affiliation;
	/**
	 * Schema.org/sponsor
	 * A person or organization that supports a thing through a pledge, promise, or financial contribution. e.g. a sponsor of a Medical Study or a corporate sponsor of an event.
	 *
	 * @property sponsor
	 * @type Organization
	 */
	public Organization sponsor;
	/**
	 * Schema.org/isicV4
	 * The International Standard of Industrial Classification of All Economic Activities (ISIC), Revision 4 code for a particular organization, business person, or place.
	 *
	 * @property isicV4
	 * @type Text
	 */
	public String isicV4;
	/**
	 * Schema.org/brand
	 * The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
	 *
	 * @property brand
	 * @type Organization
	 */
	public Organization brand;
	/**
	 * Schema.org/honorificSuffix
	 * An honorific suffix preceding a Person's name such as M.D. /PhD/MSCSW.
	 *
	 * @property honorificSuffix
	 * @type Text
	 */
	public String honorificSuffix;
	/**
	 * Schema.org/vatID
	 * The Value-added Tax ID of the organization or person.
	 *
	 * @property vatID
	 * @type Text
	 */
	public String vatID;
	/**
	 * Schema.org/nationality
	 * Nationality of the person.
	 *
	 * @property nationality
	 * @type Country
	 */
	public Country nationality;
	/**
	 * Schema.org/faxNumber
	 * The fax number.
	 *
	 * @property faxNumber
	 * @type Text
	 */
	public String faxNumber;
	/**
	 * Schema.org/relatedTo
	 * The most generic familial relation.
	 *
	 * @property relatedTo
	 * @type Person
	 */
	public Person relatedTo;
	/**
	 * Schema.org/follows
	 * The most generic uni-directional social relation.
	 *
	 * @property follows
	 * @type Person
	 */
	public Person follows;
	/**
	 * Schema.org/knows
	 * The most generic bi-directional social/work relation.
	 *
	 * @property knows
	 * @type Person
	 */
	public Person knows;
	/**
	 * Schema.org/worksFor
	 * Organizations that the person works for.
	 *
	 * @property worksFor
	 * @type Organization
	 */
	public Organization worksFor;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Person() {
		context = "http://schema.org/";
		type = "Person";
	}

}