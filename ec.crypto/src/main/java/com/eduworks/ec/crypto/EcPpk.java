package com.eduworks.ec.crypto;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

import com.eduworks.ec.blob.ArrayBuffer;

import forge.keypair;
import forge.ppk;
import forge.rsa;

/**
 * Helper classes for dealing with RSA Private Keys.
 * @class EcPpk
 * @author fritz.ray@eduworks.com
 */
public class EcPpk
{
	/**
	 * Decodes a PEM encoded PrivateKeyInfo (PKCS#8) or RSAPrivateKey (PKCS#1) formatted RSA Public Key.
	 * (In case you were curious.)
	 * @method fromPem
	 * @static
	 * @param {string} pem PEM as a string.
	 * @return {EcPk} Object used to perform public key operations.
	 */
	public static EcPpk fromPem(String pem)
	{
		EcPpk pk = new EcPpk();
		try
		{
			pk.ppk = forge.pki.privateKeyFromPem(pem);
		} catch (Exception ex)
		{
			return null;
		}
		return pk;
	}

	/**
	 * Generates an RSA Keypair using web workers.
	 * @method generateKeyAsync
	 * @static
	 * @param {function(EcPpk)} callback Method called when the keypair is generated.
	 */
	public static void generateKeyAsync(final Callback1<EcPpk> callback)
	{
		Object o = new Object();
		JSObjectAdapter.$properties(o).$put("workers", -1);
		rsa.generateKeyPair(o, new Callback2<String, keypair>()
		{
			public void $invoke(String err, keypair keypair)
			{
				EcPpk ppk = new EcPpk();
				ppk.ppk = keypair.privateKey;
				callback.$invoke(ppk);
			}
		});
	}

	/**
	 * Generates an RSA Keypair synchronously. Can take a while.
	 * @method generateKey
	 * @static
	 * @return {EcPpk} Public private keypair.
	 */
	public static EcPpk generateKey()
	{
		Object o = new Object();
		JSObjectAdapter.$properties(o).$put("workers", -1);
		keypair keypair = rsa.generateKeyPair(o, null);
		EcPpk ppk = new EcPpk();
		ppk.ppk = keypair.privateKey;
		return ppk;
	}

	protected ppk ppk;

	/**
	 * Returns true iff the PEM forms of the public private keypair match.
	 * Can also match against a public key if the public portion of the keypair match.
	 * @method equals
	 * @param {EcPpk|EcPk} Key to compare to.
	 * @return boolean If they match.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EcPpk)
			return toPem().equals(((EcPpk) obj).toPem());
		if (obj instanceof EcPk)
			return toPk().toPem().equals(((EcPk) obj).toPem());
		return super.equals(obj);
	}

	protected EcPpk()
	{
	}

	/**
	 * Encodes the private key into a PEM encoded RSAPrivateKey (PKCS#1) formatted RSA Public Key.
	 * (In case you were curious.)
	 * @method toPem
	 * @return {string} PEM encoded public key without whitespace.
	 */
	public String toPem()
	{
		return forge.pki.privateKeyToPem(ppk).replaceAll("\r?\n", "");
	}

	/**
	 * Encodes the private key into a PEM encoded RSAPrivateKey (PKCS#1) formatted RSA Public Key.
	 * (In case you were curious.)
	 * @method toPkcs1Pem
	 * @return {string} PEM encoded public key without whitespace.
	 */
	public String toPkcs1Pem()
	{
		return forge.pki.privateKeyToPem(ppk).replaceAll("\r?\n", "");
	}

	/**
	 * Encodes the private key into a PEM encoded PrivateKeyInfo (PKCS#8) formatted RSA Public Key.
	 * (In case you were curious.)
	 * @method toPkcs8Pem
	 * @return {string} PEM encoded public key without whitespace.
	 */
	public String toPkcs8Pem()
	{
		return forge.pki.privateKeyInfoToPem(ppk).replaceAll("\r?\n", "");
	}

	public ArrayBuffer toPkcs8()
	{
		return forge.pki.wrapRsaPrivateKey(forge.pki.privateKeyToAsn1(ppk));
	}

	/**
	 * Extracts the public key portion from the public private keypair.
	 * @method toPk
	 * @return {EcPk} Public Key Helper.
	 */
	public EcPk toPk()
	{
		EcPk pk = new EcPk();
		pk.pk = forge.rsa.setPublicKey(ppk.n, ppk.e);
		return pk;
	}

	/**
	 * Returns true if this PPK is in an array of PPKs.
	 * @method inArray
	 * @param {Array<EcPpk>} ppks Array of ppks
	 * @return true iff this PPK in ppks.
	 */
	public boolean inArray(Array<EcPpk> ppks)
	{
		for (int i = 0; i < ppks.$length(); i++)
		{
			if (ppks.$get(i).equals(this))
				return true;
		}
		return false;
	}
}
