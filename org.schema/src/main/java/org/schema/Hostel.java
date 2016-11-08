package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Hostel
 * A hostel - cheap accommodation, often in shared dormitories.
<br /><br />
See also the <a href="/docs/hotels.html">dedicated document on the use of schema.org for marking up hotels and other forms of accommodations</a>.

 * @author schema.org
 * @class Hostel
 * @module org.schema
 * @extends LodgingBusiness
 */
public class Hostel extends LodgingBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Hostel()
	{
		context="http://schema.org/";
		type="Hostel";
	}

}