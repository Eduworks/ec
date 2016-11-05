package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DownloadAction
 * The act of downloading an object.
 * @author schema.org
 * @module schema.org
 * @class DownloadAction
 * @extends TransferAction
 */
public class DownloadAction extends TransferAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DownloadAction()
	{
		context="http://schema.org/";
		type="DownloadAction";
	}

}