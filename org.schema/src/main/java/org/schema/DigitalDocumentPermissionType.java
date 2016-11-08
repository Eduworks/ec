package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DigitalDocumentPermissionType
 * A type of permission which can be granted for accessing a digital document.
 * @author schema.org
 * @class DigitalDocumentPermissionType
 * @module org.schema
 * @extends Enumeration
 */
public class DigitalDocumentPermissionType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DigitalDocumentPermissionType()
	{
		context="http://schema.org/";
		type="DigitalDocumentPermissionType";
	}

}