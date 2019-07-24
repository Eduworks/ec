package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/AlignmentMap
 * An entity comprised of a set of alignment or mapping assertions between two existing entities such as mapping a certificate providing advanced standing to a degree.
 * Alignment maps provide the means for parties to assert sets of alignments between already existing entities created by themselves or other parties--e.g., a 3rd party mapping of a learning resource owned by one party to a credential owned by another; or, mapping a military occupational experience or Military Occupational Specialty (MOS code) as advanced standing to a course or credential.
 * @author credentialengine.org
 * @class AlignmentMap
 * @module org.credentialengine
 */
public class AlignmentMap extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AlignmentMap()
	{
		super("http://schema.eduworks.com/simpleCtdl","AlignmentMap");
	}

	/**
	 * http://purl.org/ctdl/terms/hasStatement
	 * Alignment assertion belonging to the alignment map.
	 * @property hasStatement
	 * @type Statement
	 */
	public Object hasStatement;

}