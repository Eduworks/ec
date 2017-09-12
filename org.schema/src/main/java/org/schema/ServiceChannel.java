package org.schema;

/**
 * Schema.org/ServiceChannel
 * A means for accessing a service, e.g. a government office location, web site, or phone number.
 * @author schema.org
 * @class ServiceChannel
 * @module org.schema
 * @extends Intangible
 */
public class ServiceChannel extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ServiceChannel()
	{
		context="http://schema.org/";
		type="ServiceChannel";
	}

	/**
	 * Schema.org/providesService
	 * The service provided by this channel.
	 * @property providesService
	 * @type Service
	 */
	public Service providesService;

	/**
	 * Schema.org/availableLanguage
	 * A language someone may use with the item. Please use one of the language codes from the [IETF BCP 47 standard](http://tools.ietf.org/html/bcp47). See also [[inLanguage]]
	 * @property availableLanguage
	 * @type schema,Text | schema,Language
	 */
	public Object availableLanguage;

	/**
	 * Schema.org/serviceUrl
	 * The website to access the service.
	 * @property serviceUrl
	 * @type URL
	 */
	public String serviceUrl;

	/**
	 * Schema.org/servicePhone
	 * The phone number to use to access the service.
	 * @property servicePhone
	 * @type ContactPoint
	 */
	public ContactPoint servicePhone;

	/**
	 * Schema.org/processingTime
	 * Estimated processing time for the service using this channel.
	 * @property processingTime
	 * @type Duration
	 */
	public Duration processingTime;

	/**
	 * Schema.org/servicePostalAddress
	 * The address for accessing the service by mail.
	 * @property servicePostalAddress
	 * @type PostalAddress
	 */
	public PostalAddress servicePostalAddress;

	/**
	 * Schema.org/serviceSmsNumber
	 * The number to access the service by text message.
	 * @property serviceSmsNumber
	 * @type ContactPoint
	 */
	public ContactPoint serviceSmsNumber;

	/**
	 * Schema.org/serviceLocation
	 * The location (e.g. civic structure, local business, etc.) where a person can go to access the service.
	 * @property serviceLocation
	 * @type Place
	 */
	public Place serviceLocation;

}