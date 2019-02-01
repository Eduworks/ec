package org.schema;

/**
 * Schema.org/DigitalDocumentPermission
 * A permission for a particular person or group to access a particular file.
 *
 * @author schema.org
 * @class DigitalDocumentPermission
 * @module org.schema
 * @extends Intangible
 */
public class DigitalDocumentPermission extends Intangible {
	/**
	 * Schema.org/grantee
	 * The person, organization, contact point, or audience that has been granted this permission.
	 *
	 * @property grantee
	 * @type ContactPoint
	 */
	public ContactPoint grantee;
	/**
	 * Schema.org/permissionType
	 * The type of permission granted the person, organization, or audience.
	 *
	 * @property permissionType
	 * @type DigitalDocumentPermissionType
	 */
	public DigitalDocumentPermissionType permissionType;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DigitalDocumentPermission() {
		context = "http://schema.org/";
		type = "DigitalDocumentPermission";
	}

}