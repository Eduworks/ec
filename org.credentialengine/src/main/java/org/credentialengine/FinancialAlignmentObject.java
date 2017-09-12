package org.credentialengine;

/**
 * credentialengine.org/FinancialAlignmentObject
 * An alignment to a financial framework.
 *
 * @author credentialengine.org
 * @class FinancialAlignmentObject
 * @module org.credentialengine
 * @extends CredentialAlignmentObject
 */
public class FinancialAlignmentObject extends CredentialAlignmentObject {
	/**
	 * http://purl.org/ctdl/terms/alignmentDate
	 * The date  the alignment was made.
	 *
	 * @property alignmentDate
	 * @type date
	 */
	public String alignmentDate;
	/**
	 * http://purl.org/ctdl/terms/alignmentType
	 * A category of alignment between the learning resource and the framework node.
	 *
	 * @property alignmentType
	 * @type Literal
	 */
	public String alignmentType;
	/**
	 * http://purl.org/ctdl/terms/codedNotation
	 * A short set of alpha-numeric symbols that uniquely identifies a resource and supports its discovery.
	 *
	 * @property codedNotation
	 * @type Literal
	 */
	public String codedNotation;
	/**
	 * http://purl.org/ctdl/terms/framework
	 * The framework to which the resource being described is aligned.
	 *
	 * @property framework
	 * @type anyURI
	 */
	public String framework;
	/**
	 * http://purl.org/ctdl/terms/frameworkName
	 * The name of the framework to which the resource being described is aligned.
	 *
	 * @property frameworkName
	 * @type Literal
	 */
	public String frameworkName;
	/**
	 * http://purl.org/ctdl/terms/targetNode
	 * The node of a framework targeted by the alignment.
	 *
	 * @property targetNode
	 * @type anyURI
	 */
	public String targetNode;
	/**
	 * http://purl.org/ctdl/terms/targetNodeDescription
	 * The description of a node in an established educational framework.
	 *
	 * @property targetNodeDescription
	 * @type Literal
	 */
	public String targetNodeDescription;
	/**
	 * http://purl.org/ctdl/terms/targetNodeName
	 * The name of a node in an established educational framework.
	 *
	 * @property targetNodeName
	 * @type Literal
	 */
	public String targetNodeName;
	/**
	 * http://purl.org/ctdl/terms/weight
	 * An asserted measurement of the weight, degree, percent, or strength of a recommendation, requirement, or comparison.
	 *
	 * @property weight
	 * @type float
	 */
	public Float weight;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FinancialAlignmentObject() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "FinancialAlignmentObject";
	}

}