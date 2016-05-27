package com.eduworks.schema.ebac;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

/**
 * Encrypted JSON-LD object.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacEncryptedValue extends EcRemoteLinkedData
{
	public static final String type = "http://schema.eduworks.com/ebac/0.1/encryptedValue";

	public EbacEncryptedValue()
	{
		super(Ebac.context, type);
	} 

	/**
	 * Optional Hint used to aid search, showing the type of the inner encrypted
	 * object.
	 */
	public String encryptedType;

	/**
	 * Base-64 encoded, AES encrypted form of the encrypted object (or data).
	 */
	public String payload;

	/**
	 * Optional Hint used to aid view, showing a name of the inner encrypted
	 * object.
	 */
	public String name;

}
