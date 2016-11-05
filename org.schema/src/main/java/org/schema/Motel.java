package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Motel
 * A motel.
<br /><br />
See also the <a href="/docs/hotels.html">dedicated document on the use of schema.org for marking up hotels and other forms of accommodations</a>.

 * @author schema.org
 * @module schema.org
 * @class Motel
 * @extends LodgingBusiness
 */
public class Motel extends LodgingBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Motel()
	{
		context="http://schema.org/";
		type="Motel";
	}

}