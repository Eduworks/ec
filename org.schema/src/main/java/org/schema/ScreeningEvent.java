package org.schema;

/**
 * Schema.org/ScreeningEvent
 * A screening of a movie or other video.
 *
 * @author schema.org
 * @class ScreeningEvent
 * @module org.schema
 * @extends Event
 */
public class ScreeningEvent extends Event {
	/**
	 * Schema.org/videoFormat
	 * The type of screening or video broadcast used (e.g. IMAX, 3D, SD, HD, etc.).
	 *
	 * @property videoFormat
	 * @type Text
	 */
	public String videoFormat;
	/**
	 * Schema.org/subtitleLanguage
	 * Languages in which subtitles/captions are available, in [IETF BCP 47 standard format](http://tools.ietf.org/html/bcp47).
	 *
	 * @property subtitleLanguage
	 * @type Text
	 */
	public String subtitleLanguage;
	/**
	 * Schema.org/workPresented
	 * The movie presented during this event.
	 *
	 * @property workPresented
	 * @type Movie
	 */
	public Movie workPresented;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ScreeningEvent() {
		context = "http://schema.org/";
		type = "ScreeningEvent";
	}

}