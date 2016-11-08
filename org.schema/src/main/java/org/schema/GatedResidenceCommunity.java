package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GatedResidenceCommunity
 * Residence type: Gated community.
 * @author schema.org
 * @class GatedResidenceCommunity
 * @module org.schema
 * @extends Residence
 */
public class GatedResidenceCommunity extends Residence
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GatedResidenceCommunity()
	{
		context="http://schema.org/";
		type="GatedResidenceCommunity";
	}

}