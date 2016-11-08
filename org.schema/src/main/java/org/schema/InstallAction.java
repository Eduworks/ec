package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/InstallAction
 * The act of installing an application.
 * @author schema.org
 * @class InstallAction
 * @module org.schema
 * @extends ConsumeAction
 */
public class InstallAction extends ConsumeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InstallAction()
	{
		context="http://schema.org/";
		type="InstallAction";
	}

}