package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SoftwareApplication
 * A software application.
 * @author schema.org
 * @class SoftwareApplication
 * @module org.schema
 * @extends CreativeWork
 */
public class SoftwareApplication extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SoftwareApplication()
	{
		context="http://schema.org/";
		type="SoftwareApplication";
	}

	/**
	 * Schema.org/storageRequirements
	 * Storage requirements (free space required).
	 * @property storageRequirements
	 * @type schema,URL | schema,Text
	 */
	public Object storageRequirements;

	/**
	 * Schema.org/device
	 * Device required to run the application. Used in cases where a specific make/model is required to run the application.
	 * @property device
	 * @type Text
	 */
	public String device;

	/**
	 * Schema.org/installUrl
	 * URL at which the app may be installed, if different from the URL of the item.
	 * @property installUrl
	 * @type URL
	 */
	public String installUrl;

	/**
	 * Schema.org/countriesSupported
	 * Countries for which the application is supported. You can also provide the two-letter ISO 3166-1 alpha-2 country code.
	 * @property countriesSupported
	 * @type Text
	 */
	public String countriesSupported;

	/**
	 * Schema.org/softwareVersion
	 * Version of the software instance.
	 * @property softwareVersion
	 * @type Text
	 */
	public String softwareVersion;

	/**
	 * Schema.org/softwareAddOn
	 * Additional content for a software application.
	 * @property softwareAddOn
	 * @type SoftwareApplication
	 */
	public SoftwareApplication softwareAddOn;

	/**
	 * Schema.org/supportingData
	 * Supporting data for a SoftwareApplication.
	 * @property supportingData
	 * @type DataFeed
	 */
	public DataFeed supportingData;

	/**
	 * Schema.org/memoryRequirements
	 * Minimum memory requirements.
	 * @property memoryRequirements
	 * @type schema,URL | schema,Text
	 */
	public Object memoryRequirements;

	/**
	 * Schema.org/applicationSubCategory
	 * Subcategory of the application, e.g. 'Arcade Game'.
	 * @property applicationSubCategory
	 * @type schema,URL | schema,Text
	 */
	public Object applicationSubCategory;

	/**
	 * Schema.org/featureList
	 * Features or modules provided by this application (and possibly required by other applications).
	 * @property featureList
	 * @type schema,URL | schema,Text
	 */
	public Object featureList;

	/**
	 * Schema.org/softwareHelp
	 * Software application help.
	 * @property softwareHelp
	 * @type CreativeWork
	 */
	public CreativeWork softwareHelp;

	/**
	 * Schema.org/screenshot
	 * A link to a screenshot image of the app.
	 * @property screenshot
	 * @type schema,URL | schema,ImageObject
	 */
	public Object screenshot;

	/**
	 * Schema.org/permissions
	 * Permission(s) required to run the app (for example, a mobile app may require full internet access or may run only on wifi).
	 * @property permissions
	 * @type Text
	 */
	public String permissions;

	/**
	 * Schema.org/requirements
	 * Component dependency requirements for application. This includes runtime environments and shared libraries that are not included in the application distribution package, but required to run the application (Examples: DirectX, Java or .NET runtime).
	 * @property requirements
	 * @type schema,URL | schema,Text
	 */
	public Object requirements;

	/**
	 * Schema.org/applicationCategory
	 * Type of software application, e.g. 'Game, Multimedia'.
	 * @property applicationCategory
	 * @type schema,URL | schema,Text
	 */
	public Object applicationCategory;

	/**
	 * Schema.org/releaseNotes
	 * Description of what changed in this version.
	 * @property releaseNotes
	 * @type schema,URL | schema,Text
	 */
	public Object releaseNotes;

	/**
	 * Schema.org/operatingSystem
	 * Operating systems supported (Windows 7, OSX 10.6, Android 1.6).
	 * @property operatingSystem
	 * @type Text
	 */
	public String operatingSystem;

	/**
	 * Schema.org/processorRequirements
	 * Processor architecture required to run the application (e.g. IA64).
	 * @property processorRequirements
	 * @type Text
	 */
	public String processorRequirements;

	/**
	 * Schema.org/countriesNotSupported
	 * Countries for which the application is not supported. You can also provide the two-letter ISO 3166-1 alpha-2 country code.
	 * @property countriesNotSupported
	 * @type Text
	 */
	public String countriesNotSupported;

	/**
	 * Schema.org/availableOnDevice
	 * Device required to run the application. Used in cases where a specific make/model is required to run the application.
	 * @property availableOnDevice
	 * @type Text
	 */
	public String availableOnDevice;

	/**
	 * Schema.org/softwareRequirements
	 * Component dependency requirements for application. This includes runtime environments and shared libraries that are not included in the application distribution package, but required to run the application (Examples: DirectX, Java or .NET runtime).
	 * @property softwareRequirements
	 * @type schema,URL | schema,Text
	 */
	public Object softwareRequirements;

	/**
	 * Schema.org/fileSize
	 * Size of the application / package (e.g. 18MB). In the absence of a unit (MB, KB etc.), KB will be assumed.
	 * @property fileSize
	 * @type Text
	 */
	public String fileSize;

	/**
	 * Schema.org/applicationSuite
	 * The name of the application suite to which the application belongs (e.g. Excel belongs to Office).
	 * @property applicationSuite
	 * @type Text
	 */
	public String applicationSuite;

	/**
	 * Schema.org/downloadUrl
	 * If the file can be downloaded, URL to download the binary.
	 * @property downloadUrl
	 * @type URL
	 */
	public String downloadUrl;

}