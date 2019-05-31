package org.w3.skos;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

/**
 * www.w3.org/2004/02/skos/core/Concept
 * An idea or notion; a unit of thought.
 * @author w3.org
 * @class Concept
 * @module org.w3.skos
 */
public class Concept extends EcRemoteLinkedData
{
	private static final String TYPE_0_1 = "http://schema.cassproject.org/0.3/skos/Concept";
	private static final String TYPE_0_2 = "https://schema.cassproject.org/0.3/skos/Concept";
	public static final String myType = "http://schema.cassproject.org/0.3/skos/Concept";
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Concept()
	{
		super("http://schema.cassproject.org/0.3/skos/","Concept");
	}

	/**
	 * www.w3.org/2004/02/skos/core/topConceptOf
	 * Relates a concept to the concept scheme that it is a top level concept of.
	 * @property topConceptOf
	 * @type ConceptScheme
	 */
	public ConceptScheme topConceptOf;

	/**
	 * www.w3.org/2004/02/skos/core/semanticRelation
	 * Links a concept to a concept related by meaning.
	 * @property semanticRelation
	 * @type Concept
	 */
	public Concept semanticRelation;

	@Override
	public Array<String> getTypes() {
		Array<String> a = new Array<String>();
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}

}