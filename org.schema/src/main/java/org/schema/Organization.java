package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Organization
 * An organization such as a school, NGO, corporation, club, etc.
 * @author schema.org
 * @class Organization
 * @module org.schema
 * @extends Thing
 */
public class Organization extends Thing
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Organization()
	{
		context="http://schema.org/";
		type="Organization";
	}

	/**
	 * Schema.org/reviews
	 * Review of the item.
	 * @property reviews
	 * @type Review
	 */
	public Review reviews;

	/**
	 * Schema.org/member
	 * A member of an Organization or a ProgramMembership. Organizations can be members of organizations; ProgramMembership is typically for individuals.
	 * @property member
	 * @type schema,Organization | schema,Person
	 */
	public Object member;

	/**
	 * Schema.org/memberOf
	 * An Organization (or ProgramMembership) to which this Person or Organization belongs.
	 * @property memberOf
	 * @type schema,Organization | schema,ProgramMembership
	 */
	public Object memberOf;

	/**
	 * Schema.org/award
	 * An award won by or for this item.
	 * @property award
	 * @type Text
	 */
	public String award;

	/**
	 * Schema.org/contactPoints
	 * A contact point for a person or organization.
	 * @property contactPoints
	 * @type ContactPoint
	 */
	public ContactPoint contactPoints;

	/**
	 * Schema.org/taxID
	 * The Tax / Fiscal ID of the organization or person, e.g. the TIN in the US or the CIF/NIF in Spain.
	 * @property taxID
	 * @type Text
	 */
	public String taxID;

	/**
	 * Schema.org/numberOfEmployees
	 * The number of employees in an organization e.g. business.
	 * @property numberOfEmployees
	 * @type QuantitativeValue
	 */
	public QuantitativeValue numberOfEmployees;

	/**
	 * Schema.org/duns
	 * The Dun & Bradstreet DUNS number for identifying an organization or business person.
	 * @property duns
	 * @type Text
	 */
	public String duns;

	/**
	 * Schema.org/isicV4
	 * The International Standard of Industrial Classification of All Economic Activities (ISIC), Revision 4 code for a particular organization, business person, or place.
	 * @property isicV4
	 * @type Text
	 */
	public String isicV4;

	/**
	 * Schema.org/events
	 * Upcoming or past events associated with this place or organization.
	 * @property events
	 * @type Event
	 */
	public Event events;

	/**
	 * Schema.org/leiCode
	 * An organization identifier that uniquely identifies a legal entity as defined in ISO 17442.
	 * @property leiCode
	 * @type Text
	 */
	public String leiCode;

	/**
	 * Schema.org/event
	 * Upcoming or past event associated with this place, organization, or action.
	 * @property event
	 * @type Event
	 */
	public Event event;

	/**
	 * Schema.org/review
	 * A review of the item.
	 * @property review
	 * @type Review
	 */
	public Review review;

	/**
	 * Schema.org/serviceArea
	 * The geographic area where the service is provided.
	 * @property serviceArea
	 * @type schema,GeoShape | schema,AdministrativeArea | schema,Place
	 */
	public Object serviceArea;

	/**
	 * Schema.org/department
	 * A relationship between an organization and a department of that organization, also described as an organization (allowing different urls, logos, opening hours). For example: a store with a pharmacy, or a bakery with a cafe.
	 * @property department
	 * @type Organization
	 */
	public Organization department;

	/**
	 * Schema.org/members
	 * A member of this organization.
	 * @property members
	 * @type schema,Organization | schema,Person
	 */
	public Object members;

	/**
	 * Schema.org/brand
	 * The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
	 * @property brand
	 * @type schema,Organization | schema,Brand
	 */
	public Object brand;

	/**
	 * Schema.org/areaServed
	 * The geographic area where a service or offered item is provided.
	 * @property areaServed
	 * @type schema,GeoShape | schema,AdministrativeArea | schema,Place | schema,Text
	 */
	public Object areaServed;

	/**
	 * Schema.org/parentOrganization
	 * The larger organization that this local business is a branch of, if any.
	 * @property parentOrganization
	 * @type Organization
	 */
	public Organization parentOrganization;

	/**
	 * Schema.org/address
	 * Physical address of the item.
	 * @property address
	 * @type schema,PostalAddress | schema,Text
	 */
	public Object address;

	/**
	 * Schema.org/awards
	 * Awards won by or for this item.
	 * @property awards
	 * @type Text
	 */
	public String awards;

	/**
	 * Schema.org/contactPoint
	 * A contact point for a person or organization.
	 * @property contactPoint
	 * @type ContactPoint
	 */
	public ContactPoint contactPoint;

	/**
	 * Schema.org/funder
	 * A person or organization that supports (sponsors) something through some kind of financial contribution.
	 * @property funder
	 * @type schema,Organization | schema,Person
	 */
	public Object funder;

	/**
	 * Schema.org/subOrganization
	 * A relationship between two organizations where the first includes the second, e.g., as a subsidiary. See also: the more specific 'department' property.
	 * @property subOrganization
	 * @type Organization
	 */
	public Organization subOrganization;

	/**
	 * Schema.org/foundingDate
	 * The date that this organization was founded.
	 * @property foundingDate
	 * @type Date
	 */
	public String foundingDate;

	/**
	 * Schema.org/alumni
	 * Alumni of an organization.
	 * @property alumni
	 * @type Person
	 */
	public Person alumni;

	/**
	 * Schema.org/vatID
	 * The Value-added Tax ID of the organization or person.
	 * @property vatID
	 * @type Text
	 */
	public String vatID;

	/**
	 * Schema.org/seeks
	 * A pointer to products or services sought by the organization or person (demand).
	 * @property seeks
	 * @type Demand
	 */
	public Demand seeks;

	/**
	 * Schema.org/sponsor
	 * A person or organization that supports a thing through a pledge, promise, or financial contribution. e.g. a sponsor of a Medical Study or a corporate sponsor of an event.
	 * @property sponsor
	 * @type schema,Organization | schema,Person
	 */
	public Object sponsor;

	/**
	 * Schema.org/email
	 * Email address.
	 * @property email
	 * @type Text
	 */
	public String email;

	/**
	 * Schema.org/faxNumber
	 * The fax number.
	 * @property faxNumber
	 * @type Text
	 */
	public String faxNumber;

	/**
	 * Schema.org/location
	 * The location of for example where the event is happening, an organization is located, or where an action takes place.
	 * @property location
	 * @type schema,PostalAddress | schema,Place | schema,Text
	 */
	public Object location;

	/**
	 * Schema.org/hasPOS
	 * Points-of-Sales operated by the organization or person.
	 * @property hasPOS
	 * @type Place
	 */
	public Place hasPOS;

	/**
	 * Schema.org/hasOfferCatalog
	 * Indicates an OfferCatalog listing for this Organization, Person, or Service.
	 * @property hasOfferCatalog
	 * @type OfferCatalog
	 */
	public OfferCatalog hasOfferCatalog;

	/**
	 * Schema.org/telephone
	 * The telephone number.
	 * @property telephone
	 * @type Text
	 */
	public String telephone;

	/**
	 * Schema.org/aggregateRating
	 * The overall rating, based on a collection of reviews or ratings, of the item.
	 * @property aggregateRating
	 * @type AggregateRating
	 */
	public AggregateRating aggregateRating;

	/**
	 * Schema.org/founder
	 * A person who founded this organization.
	 * @property founder
	 * @type Person
	 */
	public Person founder;

	/**
	 * Schema.org/founders
	 * A person who founded this organization.
	 * @property founders
	 * @type Person
	 */
	public Person founders;

	/**
	 * Schema.org/employee
	 * Someone working for this organization.
	 * @property employee
	 * @type Person
	 */
	public Person employee;

	/**
	 * Schema.org/logo
	 * An associated logo.
	 * @property logo
	 * @type schema,ImageObject | schema,URL
	 */
	public Object logo;

	/**
	 * Schema.org/owns
	 * Products owned by the organization or person.
	 * @property owns
	 * @type schema,Product | schema,OwnershipInfo
	 */
	public Object owns;

	/**
	 * Schema.org/legalName
	 * The official name of the organization, e.g. the registered company name.
	 * @property legalName
	 * @type Text
	 */
	public String legalName;

	/**
	 * Schema.org/naics
	 * The North American Industry Classification System (NAICS) code for a particular organization or business person.
	 * @property naics
	 * @type Text
	 */
	public String naics;

	/**
	 * Schema.org/employees
	 * People working for this organization.
	 * @property employees
	 * @type Person
	 */
	public Person employees;

	/**
	 * Schema.org/dissolutionDate
	 * The date that this organization was dissolved.
	 * @property dissolutionDate
	 * @type Date
	 */
	public String dissolutionDate;

	/**
	 * Schema.org/foundingLocation
	 * The place where the Organization was founded.
	 * @property foundingLocation
	 * @type Place
	 */
	public Place foundingLocation;

	/**
	 * Schema.org/makesOffer
	 * A pointer to products or services offered by the organization or person.
	 * @property makesOffer
	 * @type Offer
	 */
	public Offer makesOffer;

	/**
	 * Schema.org/globalLocationNumber
	 * The [Global Location Number](http://www.gs1.org/gln) (GLN, sometimes also referred to as International Location Number or ILN) of the respective organization, person, or place. The GLN is a 13-digit number used to identify parties and physical locations.
	 * @property globalLocationNumber
	 * @type Text
	 */
	public String globalLocationNumber;

}