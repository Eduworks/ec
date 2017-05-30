package org.angles.schema.angles;

import org.schema.Duration;
import org.schema.VideoObject;

/**
 * Created by fray on 5/9/17.
 */
public class VideoStory extends VideoObject {

	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VideoStory()
	{
		context="http://schema.eduworks.com/angles/0.1/";
		type="VideoStory";
	}

	/***
	 * The starting time of this story WRT the start of the video. In ISO 8601 Duration format.
	 */
	public Duration startTime;

}
