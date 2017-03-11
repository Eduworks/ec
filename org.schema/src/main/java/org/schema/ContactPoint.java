package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ContactPoint
 * A contact point&#x2014;for example, a Customer Complaints department.
 * @author schema.org
 * @class ContactPoint
 * @module org.schema
 * @extends StructuredValue
 */
public class ContactPoint extends StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ContactPoint()
	{
		context="http://schema.org/";
		type="ContactPoint";
	}

	/**
	 * Schema.org/contactType
	 * A person or organization can have different contact points, for different purposes. For example, a sales contact point, a PR contact point and so on. This property is used to specify the kind of contact point.
	 * @property contactType
	 * @type Text
	 */
	public String contactType;

	/**
	 * Schema.org/faxNumber
	 * The fax number.
	 * @property faxNumber
	 * @type Text
	 */
	public String faxNumber;

	/**
	 * Schema.org/productSupported
	 * The product or service this support contact point is related to (such as product support for a particular product line). This can be a specific product or product line (e.g. "iPhone") or a general category of products or services (e.g. "smartphones").
	 * @property productSupported
	 * @type schema,Text | schema,Product
	 */
	public Object productSupported;

	/**
	 * Schema.org/availableLanguage
	 * A language someone may use with the item. Please use one of the language codes from the [IETF BCP 47 standard](http://tools.ietf.org/html/bcp47). See also [[inLanguage]]
	 * @property availableLanguage
	 * @type schema,Text | schema,Language
	 */
	public Object availableLanguage;

	/**
	 * Schema.org/areaServed
	 * The geographic area where a service or offered item is provided.
	 * @property areaServed
	 * @type schema,GeoShape | schema,Text | schema,Place | schema,AdministrativeArea
	 */
	public Object areaServed;

	/**
	 * Schema.org/hoursAvailable
	 * The hours during which this service or contact is available.
	 * @property hoursAvailable
	 * @type OpeningHoursSpecification
	 */
	public OpeningHoursSpecification hoursAvailable;

	/**
	 * Schema.org/email
	 * Email address.
	 * @property email
	 * @type Text
	 */
	public String email;

	/**
	 * Schema.org/serviceArea
	 * The geographic area where the service is provided.
	 * @property serviceArea
	 * @type schema,GeoShape | schema,Place | schema,AdministrativeArea
	 */
	public Object serviceArea;

	/**
	 * Schema.org/telephone
	 * The telephone number.
	 * @property telephone
	 * @type Text
	 */
	public String telephone;

	/**
	 * Schema.org/contactOption
	 * An option available on this contact point (e.g. a toll-free number or support for hearing-impaired callers).
	 * @property contactOption
	 * @type ContactPointOption
	 */
	public ContactPointOption contactOption;

}