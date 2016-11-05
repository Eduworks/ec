package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TechArticle
 * A technical article - Example: How-to (task) topics, step-by-step, procedural troubleshooting, specifications, etc.
 * @author schema.org
 * @module schema.org
 * @class TechArticle
 * @extends Article
 */
public class TechArticle extends Article
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TechArticle()
	{
		context="http://schema.org/";
		type="TechArticle";
	}

	/**
	 * Schema.org/dependencies
	 * Prerequisites needed to fulfill steps in article.
	 * @property dependencies
	 * @type Text
	 */
	public String dependencies;

	/**
	 * Schema.org/proficiencyLevel
	 * Proficiency needed for this content; expected values: 'Beginner', 'Expert'.
	 * @property proficiencyLevel
	 * @type Text
	 */
	public String proficiencyLevel;

}