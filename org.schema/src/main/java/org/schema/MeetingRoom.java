package org.schema;

/**
 * Schema.org/MeetingRoom
 * A meeting room, conference room, or conference hall is a room provided for singular events such as business conferences and meetings (Source: Wikipedia, the free encyclopedia, see <a href="http://en.wikipedia.org/wiki/Conference_hall">http://en.wikipedia.org/wiki/Conference_hall</a>).
<br /><br />
See also the <a href="/docs/hotels.html">dedicated document on the use of schema.org for marking up hotels and other forms of accommodations</a>.

 * @author schema.org
 * @class MeetingRoom
 * @module org.schema
 * @extends Room
 */
public class MeetingRoom extends Room
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MeetingRoom()
	{
		context="http://schema.org/";
		type="MeetingRoom";
	}

}