package org.schema;

/**
 * Schema.org/LodgingBusiness
 * A lodging business, such as a motel, hotel, or inn.
 *
 * @author schema.org
 * @class LodgingBusiness
 * @module org.schema
 * @extends LocalBusiness
 */
public class LodgingBusiness extends LocalBusiness {
	/**
	 * Schema.org/audience
	 * An intended audience, i.e. a group for whom something was created.
	 *
	 * @property audience
	 * @type Audience
	 */
	public Audience audience;
	/**
	 * Schema.org/checkinTime
	 * The earliest someone may check into a lodging establishment.
	 *
	 * @property checkinTime
	 * @type DateTime
	 */
	public String checkinTime;
	/**
	 * Schema.org/petsAllowed
	 * Indicates whether pets are allowed to enter the accommodation or lodging business. More detailed information can be put in a text value.
	 *
	 * @property petsAllowed
	 * @type Boolean
	 */
	public Boolean petsAllowed;
	/**
	 * Schema.org/availableLanguage
	 * A language someone may use with the item. Please use one of the language codes from the [IETF BCP 47 standard](http://tools.ietf.org/html/bcp47). See also [[inLanguage]]
	 *
	 * @property availableLanguage
	 * @type Language
	 */
	public Language availableLanguage;
	/**
	 * Schema.org/amenityFeature
	 * An amenity feature (e.g. a characteristic or service) of the Accommodation. This generic property does not make a statement about whether the feature is included in an offer for the main accommodation or available at extra costs.
	 *
	 * @property amenityFeature
	 * @type LocationFeatureSpecification
	 */
	public LocationFeatureSpecification amenityFeature;
	/**
	 * Schema.org/starRating
	 * An official rating for a lodging business or food establishment, e.g. from national associations or standards bodies. Use the author property to indicate the rating organization, e.g. as an Organization with name such as (e.g. HOTREC, DEHOGA, WHR, or Hotelstars).
	 *
	 * @property starRating
	 * @type Rating
	 */
	public Rating starRating;
	/**
	 * Schema.org/checkoutTime
	 * The latest someone may check out of a lodging establishment.
	 *
	 * @property checkoutTime
	 * @type DateTime
	 */
	public String checkoutTime;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LodgingBusiness() {
		context = "http://schema.org/";
		type = "LodgingBusiness";
	}

}