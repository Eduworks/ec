package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DigitalDocumentPermission
 * A permission for a particular person or group to access a particular file.
 * @author schema.org
 * @module schema.org
 * @class DigitalDocumentPermission
 * @extends Intangible
 */
public class DigitalDocumentPermission extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DigitalDocumentPermission()
	{
		context="http://schema.org/";
		type="DigitalDocumentPermission";
	}

	/**
	 * Schema.org/permissionType
	 * The type of permission granted the person, organization, or audience.
	 * @property permissionType
	 * @type DigitalDocumentPermissionType
	 */
	public DigitalDocumentPermissionType permissionType;

	/**
	 * Schema.org/grantee
	 * The person, organization, contact point, or audience that has been granted this permission.
	 * @property grantee
	 * @type schema,Organization | schema,ContactPoint | schema,Person | schema,Audience	 */
	public Object grantee;

}