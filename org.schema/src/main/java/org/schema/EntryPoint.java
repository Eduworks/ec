package org.schema;

/**
 * Schema.org/EntryPoint
 * An entry point, within some Web-based protocol.
 * @author schema.org
 * @class EntryPoint
 * @module org.schema
 * @extends Intangible
 */
public class EntryPoint extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EntryPoint()
	{
		context="http://schema.org/";
		type="EntryPoint";
	}

	/**
	 * Schema.org/contentType
	 * The supported content type(s) for an EntryPoint response.
	 * @property contentType
	 * @type Text
	 */
	public String contentType;

	/**
	 * Schema.org/actionApplication
	 * An application that can complete the request.
	 * @property actionApplication
	 * @type SoftwareApplication
	 */
	public SoftwareApplication actionApplication;

	/**
	 * Schema.org/urlTemplate
	 * An url template (RFC6570) that will be used to construct the target of the execution of the action.
	 * @property urlTemplate
	 * @type Text
	 */
	public String urlTemplate;

	/**
	 * Schema.org/actionPlatform
	 * The high level platform(s) where the Action can be performed for the given URL. To specify a specific application or operating system instance, use actionApplication.
	 * @property actionPlatform
	 * @type schema,URL | schema,Text
	 */
	public Object actionPlatform;

	/**
	 * Schema.org/httpMethod
	 * An HTTP method that specifies the appropriate HTTP method for a request to an HTTP EntryPoint. Values are capitalized strings as used in HTTP.
	 * @property httpMethod
	 * @type Text
	 */
	public String httpMethod;

	/**
	 * Schema.org/encodingType
	 * The supported encoding type(s) for an EntryPoint request.
	 * @property encodingType
	 * @type Text
	 */
	public String encodingType;

	/**
	 * Schema.org/application
	 * An application that can complete the request.
	 * @property application
	 * @type SoftwareApplication
	 */
	public SoftwareApplication application;

}