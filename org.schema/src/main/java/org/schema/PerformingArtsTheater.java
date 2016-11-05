package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PerformingArtsTheater
 * A theater or other performing art center.
 * @author schema.org
 * @module schema.org
 * @class PerformingArtsTheater
 * @extends CivicStructure
 */
public class PerformingArtsTheater extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PerformingArtsTheater()
	{
		context="http://schema.org/";
		type="PerformingArtsTheater";
	}

}