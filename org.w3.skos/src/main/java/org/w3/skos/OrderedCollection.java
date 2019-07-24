package org.w3.skos;

import org.stjs.javascript.Array;

/**
 * www.w3.org/2004/02/skos/core/OrderedCollection
 * An ordered collection of concepts, where both the grouping and the ordering are meaningful.
 * Ordered collections can be used where you would like a set of concepts to be displayed in a specific order, and optionally under a 'node label'.
 * @author w3.org
 * @class OrderedCollection
 * @module org.w3.skos
 * @extends Collection
 */
public class OrderedCollection extends Collection
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OrderedCollection()
	{
		context="https://schema.cassproject.org/0.4/skos/";
		type="OrderedCollection";
	}

	/**
	 * www.w3.org/2004/02/skos/core/memberList
	 * Relates an ordered collection to the RDF list containing its members.
	 * @property memberList
	 * @type List
	 */
	public Array<Object> memberList;

}