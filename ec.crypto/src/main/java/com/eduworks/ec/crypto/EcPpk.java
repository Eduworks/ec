package com.eduworks.ec.crypto;

import com.eduworks.ec.blob.ArrayBuffer;
import forge.keypair;
import forge.ppk;
import forge.rsa;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import window.CryptoKey;
import window.pemJwk;

/**
 * Helper classes for dealing with RSA Private Keys.
 *
 * @author fritz.ray@eduworks.com
 * @class EcPpk
 * @module com.eduworks.ec
 */
public class EcPpk {
	public static Object cache = null;
	public String defaultPem = null;
	public Object jwk = null;
	public CryptoKey key = null;
	public CryptoKey signKey = null;
	protected ppk ppk;
	protected EcPk defaultPk = null;
	protected EcPpk() {
	}

	static {
		if (cache == null)
			cache = new Object();
	}

	/**
	 * Decodes a PEM encoded PrivateKeyInfo (PKCS#8) or RSAPrivateKey (PKCS#1) formatted RSA Public Key.
	 * (In case you were curious.)
	 *
	 * @param {string} pem PEM as a string.
	 * @return {EcPk} Object used to perform public key operations.
	 * @method fromPem
	 * @static
	 */
	public static EcPpk fromPem(String pem) {
		EcPpk pk = (EcPpk) JSObjectAdapter.$get(cache, pem);
		if (pk != null)
			return pk;
		pk = new EcPpk();
		try {
			pk.ppk = forge.pki.privateKeyFromPem(pem);
		} catch (Exception ex) {
			return null;
		}
		JSObjectAdapter.$put(cache, pem, pk);
		return pk;
	}

	/**
	 * Generates an RSA Keypair using web workers.
	 *
	 * @param {function(EcPpk)} callback Method called when the keypair is generated.
	 * @method generateKeyAsync
	 * @static
	 */
	public static void generateKeyAsync(final Callback1<EcPpk> callback) {
		Object o = new Object();
		JSObjectAdapter.$properties(o).$put("workers", -1);
		rsa.generateKeyPair(o, new Callback2<String, keypair>() {
			public void $invoke(String err, keypair keypair) {
				EcPpk ppk = new EcPpk();
				ppk.ppk = keypair.privateKey;
				callback.$invoke(ppk);
			}
		});
	}

	/**
	 * Generates an RSA Keypair synchronously. Can take a while.
	 *
	 * @return {EcPpk} Public private keypair.
	 * @method generateKey
	 * @static
	 */
	public static EcPpk generateKey() {
		Object o = new Object();
		JSObjectAdapter.$properties(o).$put("workers", -1);
		keypair keypair = rsa.generateKeyPair(o, null);
		EcPpk ppk = new EcPpk();
		ppk.ppk = keypair.privateKey;
		return ppk;
	}

	/**
	 * Returns true iff the PEM forms of the public private keypair match.
	 * Can also match against a public key if the public portion of the keypair match.
	 *
	 * @param {EcPpk|EcPk} Key to compare to.
	 * @return boolean If they match.
	 * @method equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EcPpk)
			return toPem().equals(((EcPpk) obj).toPem());
		if (obj instanceof EcPk)
			return toPk().toPem().equals(((EcPk) obj).toPem());
		return super.equals(obj);
	}

	/**
	 * Encodes the private key into a PEM encoded RSAPrivateKey (PKCS#1) formatted RSA Public Key.
	 * (In case you were curious.)
	 *
	 * @return {string} PEM encoded public key without whitespace.
	 * @method toPem
	 */
	public String toPem() {
		if (defaultPem == null)
			defaultPem = forge.pki.privateKeyToPem(ppk).replaceAll("\r", "").replaceAll("\n", "");
		return defaultPem;
	}

	/**
	 * Encodes the private key into a PEM encoded RSAPrivateKey (PKCS#1) formatted RSA Public Key.
	 * (In case you were curious.)
	 *
	 * @return {string} PEM encoded public key without whitespace.
	 * @method toPkcs1Pem
	 */
	public String toPkcs1Pem() {
		return forge.pki.privateKeyToPem(ppk).replaceAll("\r", "").replaceAll("\n", "");
	}

	/**
	 * Encodes the private key into a PEM encoded PrivateKeyInfo (PKCS#8) formatted RSA Public Key.
	 * (In case you were curious.)
	 *
	 * @return {string} PEM encoded public key without whitespace.
	 * @method toPkcs8Pem
	 */
	public String toPkcs8Pem() {
		return forge.pki.privateKeyInfoToPem(forge.pki.wrapRsaPrivateKey(forge.pki.privateKeyToAsn1(ppk))).replaceAll("\r", "").replaceAll("\n", "");
	}

	public Object toJwk() {
		if (jwk == null)
			jwk = pemJwk.pem2jwk(forge.pki.privateKeyToPem(ppk));
		return jwk;
	}

	public ArrayBuffer toPkcs8() {
		return forge.pki.wrapRsaPrivateKey(forge.pki.privateKeyToAsn1(ppk));
	}

	/**
	 * Extracts the public key portion from the public private keypair.
	 *
	 * @return {EcPk} Public Key Helper.
	 * @method toPk
	 */
	public EcPk toPk() {
		if (defaultPk != null)
			return defaultPk;
		EcPk pk = defaultPk = new EcPk();
		pk.pk = forge.rsa.setPublicKey(ppk.n, ppk.e);
		return pk;
	}

	/**
	 * Returns true if this PPK is in an array of PPKs.
	 *
	 * @param {Array<EcPpk>} ppks Array of ppks
	 * @return true iff this PPK in ppks.
	 * @method inArray
	 */
	public boolean inArray(Array<EcPpk> ppks) {
		for (int i = 0; i < ppks.$length(); i++) {
			if (ppks.$get(i).equals(this))
				return true;
		}
		return false;
	}
}
