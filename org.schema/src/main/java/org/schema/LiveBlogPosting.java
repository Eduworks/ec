package org.schema;

/**
 * Schema.org/LiveBlogPosting
 * A blog post intended to provide a rolling textual coverage of an ongoing event through continuous updates.
 *
 * @author schema.org
 * @class LiveBlogPosting
 * @module org.schema
 * @extends BlogPosting
 */
public class LiveBlogPosting extends BlogPosting {
	/**
	 * Schema.org/coverageStartTime
	 * The time when the live blog will begin covering the SchemaEvent. Note that coverage may begin before the SchemaEvent's start time. The LiveBlogPosting may also be created before coverage begins.
	 *
	 * @property coverageStartTime
	 * @type DateTime
	 */
	public String coverageStartTime;
	/**
	 * Schema.org/coverageEndTime
	 * The time when the live blog will stop covering the SchemaEvent. Note that coverage may continue after the SchemaEvent concludes.
	 *
	 * @property coverageEndTime
	 * @type DateTime
	 */
	public String coverageEndTime;
	/**
	 * Schema.org/liveBlogUpdate
	 * An update to the LiveBlog.
	 *
	 * @property liveBlogUpdate
	 * @type BlogPosting
	 */
	public BlogPosting liveBlogUpdate;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LiveBlogPosting() {
		context = "http://schema.org/";
		type = "LiveBlogPosting";
	}

}