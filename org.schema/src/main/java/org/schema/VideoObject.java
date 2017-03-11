package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/VideoObject
 * A video file.
 * @author schema.org
 * @class VideoObject
 * @module org.schema
 * @extends MediaObject
 */
public class VideoObject extends MediaObject
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VideoObject()
	{
		context="http://schema.org/";
		type="VideoObject";
	}

	/**
	 * Schema.org/director
	 * A director of e.g. tv, radio, movie, video gaming etc. content, or of an event. Directors can be associated with individual items or with a series, episode, clip.
	 * @property director
	 * @type Person
	 */
	public Person director;

	/**
	 * Schema.org/actor
	 * An actor, e.g. in tv, radio, movie, video games etc., or in an event. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actor
	 * @type Person
	 */
	public Person actor;

	/**
	 * Schema.org/thumbnail
	 * Thumbnail image for an image or video.
	 * @property thumbnail
	 * @type ImageObject
	 */
	public ImageObject thumbnail;

	/**
	 * Schema.org/transcript
	 * If this MediaObject is an AudioObject or VideoObject, the transcript of that object.
	 * @property transcript
	 * @type Text
	 */
	public String transcript;

	/**
	 * Schema.org/musicBy
	 * The composer of the soundtrack.
	 * @property musicBy
	 * @type schema,Person | schema,MusicGroup
	 */
	public Object musicBy;

	/**
	 * Schema.org/actors
	 * An actor, e.g. in tv, radio, movie, video games etc. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actors
	 * @type Person
	 */
	public Person actors;

	/**
	 * Schema.org/videoQuality
	 * The quality of the video.
	 * @property videoQuality
	 * @type Text
	 */
	public String videoQuality;

	/**
	 * Schema.org/videoFrameSize
	 * The frame size of the video.
	 * @property videoFrameSize
	 * @type Text
	 */
	public String videoFrameSize;

	/**
	 * Schema.org/caption
	 * The caption for this object.
	 * @property caption
	 * @type Text
	 */
	public String caption;

	/**
	 * Schema.org/directors
	 * A director of e.g. tv, radio, movie, video games etc. content. Directors can be associated with individual items or with a series, episode, clip.
	 * @property directors
	 * @type Person
	 */
	public Person directors;

}