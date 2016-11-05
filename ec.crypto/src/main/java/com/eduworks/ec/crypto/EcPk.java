package com.eduworks.ec.crypto;

import forge.bytes;
import forge.payload;
import forge.pk;
import forge.pki;

/**
 * Helper classes for dealing with RSA Public Keys.
 * @class EcPk
 * @module com.eduworks.ec
 * @author fritz.ray@eduworks.com
 */
public class EcPk
{
	/**
	 * Decodes a PEM encoded SubjectPublicKeyInfo (PKCS#8) or RSAPublicKey (PKCS#1) formatted RSA Public Key.
	 * (In case you were curious.)
	 * @method fromPem
	 * @static
	 * @param {string} pem PEM as a string.
	 * @return {EcPk} Object used to perform public key operations.
	 */
	public static EcPk fromPem(String pem)
	{
		EcPk pk = new EcPk();
		try
		{
			pk.pk = pki.publicKeyFromPem(pem);
		} catch (Exception ex)
		{
			return null;
		}
		return pk;
	}

	public pk pk;

	protected EcPk()
	{
	}

	/**
	 * Compares two public keys, and returns true if their PEM forms match.
	 * @method equals
	 * @param {EcPk} obj Object to compare to.
	 * @return {boolean} True if the keys match.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EcPk)
			return toPem().equals(((EcPk) obj).toPem());
		return super.equals(obj);
	}

	/**
	 * Encodes the public key into a PEM encoded SubjectPublicKeyInfo (PKCS#8) formatted RSA Public Key.
	 * (In case you were curious.)
	 * @method toPem
	 * @return {string} PEM encoded public key without whitespace.
	 */
	public String toPem()
	{
		return pki.publicKeyToPem(pk).replaceAll("\r?\n", "");
	}

	/**
	 * Encodes the public key into a PEM encoded RSAPublicKey (PKCS#1) formatted RSA Public Key.
	 * (In case you were curious.)
	 * @method toPem
	 * @return {string} PEM encoded public key without whitespace.
	 */
	public String toPkcs1Pem()
	{
		return pki.publicKeyToRSAPublicKeyPem(pk).replaceAll("\r?\n", "");
	}

	/**
	 * Encodes the public key into a PEM encoded SubjectPublicKeyInfo (PKCS#8) formatted RSA Public Key.
	 * (In case you were curious.)
	 * @method toPem
	 * @return {string} PEM encoded public key without whitespace.
	 */
	public String toPkcs8Pem()
	{
		return pki.publicKeyToPem(pk).replaceAll("\r?\n", "");
	}

	public Boolean verify(bytes bytes, payload decode64)
	{
		return pk.verify(bytes, decode64);
	}
}
