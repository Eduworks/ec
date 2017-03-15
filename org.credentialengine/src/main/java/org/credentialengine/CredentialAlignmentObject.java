package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialAlignmentObject
 * An alignment to a credentialing framework.
 * @author credentialengine.org
 * @class CredentialAlignmentObject
 * @module org.credentialengine
 * @extends AlignmentObject
 */
public class CredentialAlignmentObject extends org.schema.AlignmentObject
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CredentialAlignmentObject()
	{
		context="http://purl.org/ctdl/terms/";
		type="CredentialAlignmentObject";
	}

	/**
	 * credentialengine.org/alignmentDate
	 * The date  the alignment was made.
	 * @property alignmentDate
	 * @type dateTime
	 */
	public String alignmentDate;

	/**
	 * credentialengine.org/alignmentType
	 * A category of alignment between the learning resource and the framework node.
	 * @property alignmentType
	 * @type Literal
	 */
	public String alignmentType;

	/**
	 * credentialengine.org/codedNotation
	 * A short set of alpha-numeric symbols that uniquely identifies a resource and supports its discovery.
	 * @property codedNotation
	 * @type Literal
	 */
	public String codedNotation;

	/**
	 * credentialengine.org/framework
	 * The framework to which the resource being described is aligned.
	 * @property framework
	 * @type anyURI
	 */
	public String framework;

	/**
	 * credentialengine.org/frameworkName
	 * The name of the framework to which the resource being described is aligned.
	 * @property frameworkName
	 * @type Literal
	 */
	public String frameworkName;

	/**
	 * credentialengine.org/targetNode
	 * The node of a framework targeted by the alignment.
	 * @property targetNode
	 * @type anyURI
	 */
	public String targetNode;

	/**
	 * credentialengine.org/targetNodeDescription
	 * The description of a node in an established educational framework.
	 * @property targetNodeDescription
	 * @type Literal
	 */
	public String targetNodeDescription;

	/**
	 * credentialengine.org/targetNodeName
	 * The name of a node in an established educational framework.
	 * @property targetNodeName
	 * @type Literal
	 */
	public String targetNodeName;

	/**
	 * credentialengine.org/weight
	 * An asserted measurement of the weight, degree, percent, or strength of a recommendation, requirement, or comparison.
	 * @property weight
	 * @type float
	 */
	public float weight;

}