package org.cassproject.schema.cass.profile;

import com.eduworks.schema.ebac.EbacEncryptedSecret;
import org.stjs.javascript.Array;

public class AssertionCodebook {
	public EbacEncryptedSecret agent;
	public EbacEncryptedSecret subject;
	public EbacEncryptedSecret assertionDate;
	public EbacEncryptedSecret expirationDate;
	public EbacEncryptedSecret decayFunction;
	public EbacEncryptedSecret negative;
	public Array<EbacEncryptedSecret> evidence;
	public String assertionShortId;
}
