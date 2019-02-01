package org.schema;

/**
 * Schema.org/AlignmentObject
 * An intangible item that describes an alignment between a learning resource and a node in an educational framework.
 *
 * @author schema.org
 * @class AlignmentObject
 * @module org.schema
 * @extends Intangible
 */
public class AlignmentObject extends Intangible {
	/**
	 * Schema.org/targetDescription
	 * The description of a node in an established educational framework.
	 *
	 * @property targetDescription
	 * @type Text
	 */
	public String targetDescription;
	/**
	 * Schema.org/alignmentType
	 * A category of alignment between the learning resource and the framework node. Recommended values include: 'assesses', 'teaches', 'requires', 'textComplexity', 'readingLevel', 'educationalSubject', and 'educationalLevel'.
	 *
	 * @property alignmentType
	 * @type Text
	 */
	public String alignmentType;
	/**
	 * Schema.org/targetUrl
	 * The URL of a node in an established educational framework.
	 *
	 * @property targetUrl
	 * @type URL
	 */
	public String targetUrl;
	/**
	 * Schema.org/targetName
	 * The name of a node in an established educational framework.
	 *
	 * @property targetName
	 * @type Text
	 */
	public String targetName;
	/**
	 * Schema.org/educationalFramework
	 * The framework to which the resource being described is aligned.
	 *
	 * @property educationalFramework
	 * @type Text
	 */
	public String educationalFramework;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AlignmentObject() {
		context = "http://schema.org/";
		type = "AlignmentObject";
	}

}