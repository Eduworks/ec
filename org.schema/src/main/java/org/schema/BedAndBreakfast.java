package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BedAndBreakfast
 * Bed and breakfast.
<br /><br />
See also the <a href="/docs/hotels.html">dedicated document on the use of schema.org for marking up hotels and other forms of accommodations</a>.

 * @author schema.org
 * @class BedAndBreakfast
 * @module org.schema
 * @extends LodgingBusiness
 */
public class BedAndBreakfast extends LodgingBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BedAndBreakfast()
	{
		context="http://schema.org/";
		type="BedAndBreakfast";
	}

}