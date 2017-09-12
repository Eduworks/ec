package org.schema;

/**
 * Schema.org/Audience
 * Intended audience for an item, i.e. the group for whom the item was created.
 *
 * @author schema.org
 * @class Audience
 * @module org.schema
 * @extends Intangible
 */
public class Audience extends Intangible {
	/**
	 * Schema.org/audienceType
	 * The target group associated with a given audience (e.g. veterans, car owners, musicians, etc.).
	 *
	 * @property audienceType
	 * @type Text
	 */
	public String audienceType;
	/**
	 * Schema.org/geographicArea
	 * The geographic area associated with the audience.
	 *
	 * @property geographicArea
	 * @type AdministrativeArea
	 */
	public AdministrativeArea geographicArea;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Audience() {
		context = "http://schema.org/";
		type = "Audience";
	}

}