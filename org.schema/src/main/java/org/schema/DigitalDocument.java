package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DigitalDocument
 * An electronic file or document.
 * @author schema.org
 * @module schema.org
 * @class DigitalDocument
 * @extends CreativeWork
 */
public class DigitalDocument extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DigitalDocument()
	{
		context="http://schema.org/";
		type="DigitalDocument";
	}

	/**
	 * Schema.org/hasDigitalDocumentPermission
	 * A permission related to the access to this document (e.g. permission to read or write an electronic document). For a public document, specify a grantee with an Audience with audienceType equal to "public".
	 * @property hasDigitalDocumentPermission
	 * @type DigitalDocumentPermission
	 */
	public DigitalDocumentPermission hasDigitalDocumentPermission;

}