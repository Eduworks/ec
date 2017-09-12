package org.schema;

/**
 * Schema.org/ResumeAction
 * The act of resuming a device or application which was formerly paused (e.g. resume music playback or resume a timer).
 * @author schema.org
 * @class ResumeAction
 * @module org.schema
 * @extends ControlAction
 */
public class ResumeAction extends ControlAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ResumeAction()
	{
		context="http://schema.org/";
		type="ResumeAction";
	}

}