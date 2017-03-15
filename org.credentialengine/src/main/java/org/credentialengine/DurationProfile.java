package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/DurationProfile
 * A resource describing the temporal aspects of a resource.
 * @author credentialengine.org
 * @class DurationProfile
 * @module org.credentialengine
 */
public class DurationProfile extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DurationProfile()
	{
		super(null,null);
		context="http://purl.org/ctdl/terms/";
		type="DurationProfile";
	}

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * credentialengine.org/maximumDuration
	 * The maximum amount of time it will take to complete the described resource.
	 * @property maximumDuration
	 * @type duration
	 */
	public String maximumDuration;

}