package org.schema;

/**
 * Schema.org/SuspendAction
 * The act of momentarily pausing a device or application (e.g. pause music playback or pause a timer).
 *
 * @author schema.org
 * @class SuspendAction
 * @module org.schema
 * @extends ControlAction
 */
public class SuspendAction extends ControlAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SuspendAction() {
		context = "http://schema.org/";
		type = "SuspendAction";
	}

}