package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/APIReference
 * Reference documentation for application programming interfaces (APIs).
 * @author schema.org
 * @class APIReference
 * @module org.schema
 * @extends TechArticle
 */
public class APIReference extends TechArticle
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public APIReference()
	{
		context="http://schema.org/";
		type="APIReference";
	}

	/**
	 * Schema.org/assembly
	 * Library file name e.g., mscorlib.dll, system.web.dll.
	 * @property assembly
	 * @type Text
	 */
	public String assembly;

	/**
	 * Schema.org/executableLibraryName
	 * Library file name e.g., mscorlib.dll, system.web.dll.
	 * @property executableLibraryName
	 * @type Text
	 */
	public String executableLibraryName;

	/**
	 * Schema.org/assemblyVersion
	 * Associated product/technology version. e.g., .NET Framework 4.5.
	 * @property assemblyVersion
	 * @type Text
	 */
	public String assemblyVersion;

	/**
	 * Schema.org/targetPlatform
	 * Type of app development: phone, Metro style, desktop, XBox, etc.
	 * @property targetPlatform
	 * @type Text
	 */
	public String targetPlatform;

	/**
	 * Schema.org/programmingModel
	 * Indicates whether API is managed or unmanaged.
	 * @property programmingModel
	 * @type Text
	 */
	public String programmingModel;

}