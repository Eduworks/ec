package org.w3.skos;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

/**
 * www.w3.org/2004/02/skos/core/ConceptScheme
 * A set of concepts, optionally including statements about semantic relationships between those concepts.
 * A concept scheme may be defined to include concepts from different sources.
 * @author w3.org
 * @class ConceptScheme
 * @module org.w3.skos
 */
public class ConceptScheme extends EcRemoteLinkedData
{
	private static final String TYPE_0_1 = "http://schema.cassproject.org/0.3/skos/ConceptScheme";
	private static final String TYPE_0_2 = "https://schema.cassproject.org/0.3/skos/ConceptScheme";
	private static final String TYPE_0_3 = "https://schema.cassproject.org/0.4/skos/ConceptScheme";
	public static final String myType = TYPE_0_3;
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ConceptScheme()
	{
		super("https://schema.cassproject.org/0.4/skos/","ConceptScheme");
	}

	/**
	 * www.w3.org/2004/02/skos/core/hasTopConcept
	 * Relates, by convention, a concept scheme to a concept which is topmost in the broader/narrower concept hierarchies for that scheme, providing an entry point to these hierarchies.
	 * @property hasTopConcept
	 * @type Concept
	 */
	public Concept hasTopConcept;

	@Override
	protected void upgrade() {
		super.upgrade();
		if (TYPE_0_1.equals(getFullType())) {
			setContextAndType("https://schema.cassproject.org/0.3/skos", TYPE_0_2);
		}
		if (TYPE_0_2.equals(getFullType())) {
			setContextAndType("https://schema.cassproject.org/0.4/skos", TYPE_0_3);
		}
	}

	@Override
	public Array<String> getTypes() {
		Array<String> a = new Array<String>();
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}