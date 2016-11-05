package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Room
 * A room is a distinguishable space within a structure, usually separated from other spaces by interior walls. (Source: Wikipedia, the free encyclopedia, see <a href="http://en.wikipedia.org/wiki/Room">http://en.wikipedia.org/wiki/Room</a>).
<br /><br />
See also the <a href="/docs/hotels.html">dedicated document on the use of schema.org for marking up hotels and other forms of accommodations</a>.

 * @author schema.org
 * @module schema.org
 * @class Room
 * @extends Accommodation
 */
public class Room extends Accommodation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Room()
	{
		context="http://schema.org/";
		type="Room";
	}

}