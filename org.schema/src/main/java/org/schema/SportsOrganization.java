package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SportsOrganization
 * Represents the collection of all sports organizations, including sports teams, governing bodies, and sports associations.
 * @author schema.org
 * @module schema.org
 * @class SportsOrganization
 * @extends Organization
 */
public class SportsOrganization extends Organization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SportsOrganization()
	{
		context="http://schema.org/";
		type="SportsOrganization";
	}

	/**
	 * Schema.org/sport
	 * A type of sport (e.g. Baseball).
	 * @property sport
	 * @type schema,Text | schema,URL	 */
	public Object sport;

}