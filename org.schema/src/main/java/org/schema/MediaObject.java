package org.schema;

/**
 * Schema.org/MediaObject
 * A media object, such as an image, video, or audio object embedded in a web page or a downloadable dataset i.e. DataDownload. Note that a creative work may have many media objects associated with it on the same web page. For example, a page about a single song (MusicRecording) may have a music video (VideoObject), and a high and low bandwidth audio stream (2 AudioObject's).
 *
 * @author schema.org
 * @class MediaObject
 * @module org.schema
 * @extends CreativeWork
 */
public class MediaObject extends CreativeWork {
	/**
	 * Schema.org/expires
	 * Date the content expires and is no longer useful or available. Useful for videos.
	 *
	 * @property expires
	 * @type Date
	 */
	public String expires;
	/**
	 * Schema.org/regionsAllowed
	 * The regions where the media is allowed. If not specified, then it's assumed to be allowed everywhere. Specify the countries in [ISO 3166 format](http://en.wikipedia.org/wiki/ISO_3166).
	 *
	 * @property regionsAllowed
	 * @type Place
	 */
	public Place regionsAllowed;
	/**
	 * Schema.org/encodingFormat
	 * mp3, mpeg4, etc.
	 *
	 * @property encodingFormat
	 * @type Text
	 */
	public String encodingFormat;
	/**
	 * Schema.org/embedUrl
	 * A URL pointing to a player for a specific video. In general, this is the information in the ```src``` element of an ```embed``` tag and should not be the same as the content of the ```loc``` tag.
	 *
	 * @property embedUrl
	 * @type URL
	 */
	public String embedUrl;
	/**
	 * Schema.org/height
	 * The height of the item.
	 *
	 * @property height
	 * @type schema, Distance | schema,QuantitativeValue
	 */
	public Object height;
	/**
	 * Schema.org/requiresSubscription
	 * Indicates if use of the media require a subscription  (either paid or free). Allowed values are ```true``` or ```false``` (note that an earlier version had 'yes', 'no').
	 *
	 * @property requiresSubscription
	 * @type Boolean
	 */
	public Boolean requiresSubscription;
	/**
	 * Schema.org/playerType
	 * Player type required&#x2014;for example, Flash or Silverlight.
	 *
	 * @property playerType
	 * @type Text
	 */
	public String playerType;
	/**
	 * Schema.org/duration
	 * The duration of the item (movie, audio recording, event, etc.) in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601).
	 *
	 * @property duration
	 * @type Duration
	 */
	public Duration duration;
	/**
	 * Schema.org/contentUrl
	 * Actual bytes of the media object, for example the image file or video file.
	 *
	 * @property contentUrl
	 * @type URL
	 */
	public String contentUrl;
	/**
	 * Schema.org/width
	 * The width of the item.
	 *
	 * @property width
	 * @type schema, Distance | schema,QuantitativeValue
	 */
	public Object width;
	/**
	 * Schema.org/associatedArticle
	 * A NewsArticle associated with the Media Object.
	 *
	 * @property associatedArticle
	 * @type NewsArticle
	 */
	public NewsArticle associatedArticle;
	/**
	 * Schema.org/productionCompany
	 * The production company or studio responsible for the item e.g. series, video game, episode etc.
	 *
	 * @property productionCompany
	 * @type Organization
	 */
	public Organization productionCompany;
	/**
	 * Schema.org/uploadDate
	 * Date when this media object was uploaded to this site.
	 *
	 * @property uploadDate
	 * @type Date
	 */
	public String uploadDate;
	/**
	 * Schema.org/bitrate
	 * The bitrate of the media object.
	 *
	 * @property bitrate
	 * @type Text
	 */
	public String bitrate;
	/**
	 * Schema.org/encodesCreativeWork
	 * The CreativeWork encoded by this media object.
	 *
	 * @property encodesCreativeWork
	 * @type CreativeWork
	 */
	public CreativeWork encodesCreativeWork;
	/**
	 * Schema.org/contentSize
	 * File size in (mega/kilo) bytes.
	 *
	 * @property contentSize
	 * @type Text
	 */
	public String contentSize;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MediaObject() {
		context = "http://schema.org/";
		type = "MediaObject";
	}

}