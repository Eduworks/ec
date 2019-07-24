package org.schema;

/**
 * Schema.org/PerformingArtsTheater
 * A theater or other performing art center.
 *
 * @author schema.org
 * @class PerformingArtsTheater
 * @module org.schema
 * @extends CivicStructure
 */
public class PerformingArtsTheater extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PerformingArtsTheater() {
		context = "http://schema.org/";
		type = "PerformingArtsTheater";
	}

}