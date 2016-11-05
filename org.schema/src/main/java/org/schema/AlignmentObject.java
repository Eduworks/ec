package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AlignmentObject
 * An intangible item that describes an alignment between a learning resource and a node in an educational framework.
 * @author schema.org
 * @module schema.org
 * @class AlignmentObject
 * @extends Intangible
 */
public class AlignmentObject extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AlignmentObject()
	{
		context="http://schema.org/";
		type="AlignmentObject";
	}

	/**
	 * Schema.org/educationalFramework
	 * The framework to which the resource being described is aligned.
	 * @property educationalFramework
	 * @type Text
	 */
	public String educationalFramework;

	/**
	 * Schema.org/targetName
	 * The name of a node in an established educational framework.
	 * @property targetName
	 * @type Text
	 */
	public String targetName;

	/**
	 * Schema.org/alignmentType
	 * A category of alignment between the learning resource and the framework node. Recommended values include: 'assesses', 'teaches', 'requires', 'textComplexity', 'readingLevel', 'educationalSubject', and 'educationLevel'.
	 * @property alignmentType
	 * @type Text
	 */
	public String alignmentType;

	/**
	 * Schema.org/targetDescription
	 * The description of a node in an established educational framework.
	 * @property targetDescription
	 * @type Text
	 */
	public String targetDescription;

	/**
	 * Schema.org/targetUrl
	 * The URL of a node in an established educational framework.
	 * @property targetUrl
	 * @type URL
	 */
	public String targetUrl;

}