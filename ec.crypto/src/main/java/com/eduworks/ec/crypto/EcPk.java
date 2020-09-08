package com.eduworks.ec.crypto;

import forge.*;
import org.stjs.javascript.JSObjectAdapter;
import window.CryptoKey;
import window.pemJwk;

/**
 * Helper classes for dealing with RSA Public Keys.
 *
 * @author fritz.ray@eduworks.com
 * @class EcPk
 * @module com.eduworks.ec
 */
public class EcPk {
    public static Object cache = null;
    public pk pk;
    public String defaultPem = null;
    public Object jwk = null;
    public CryptoKey key = null;
    public CryptoKey signKey = null;

    protected EcPk() {
    }

    static {
        if (cache == null)
            cache = new Object();
    }

    /**
     * Decodes a PEM encoded SubjectPublicKeyInfo (PKCS#8) or RSAPublicKey (PKCS#1) formatted RSA Public Key.
     * (In case you were curious.)
     *
     * @param {string} pem PEM as a string.
     * @return {EcPk} Object used to perform public key operations.
     * @method fromPem
     * @static
     */
    public static EcPk fromPem(String pem) {
        EcPk pk = (EcPk) JSObjectAdapter.$get(cache, pem);
        if (pk != null)
            return pk;
        pk = new EcPk();
        try {
            pk.pk = pki.publicKeyFromPem(pem);
        } catch (Exception ex) {
            return null;
        }
        JSObjectAdapter.$put(cache, pem, pk);
        return pk;
    }

    /**
     * Compares two public keys, and returns true if their PEM forms match.
     *
     * @param {EcPk} obj Object to compare to.
     * @return {boolean} True if the keys match.
     * @method equals
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EcPk)
            return toPem().equals(((EcPk) obj).toPem());
        return super.equals(obj);
    }

    /**
     * Encodes the public key into a PEM encoded SubjectPublicKeyInfo (PKCS#8) formatted RSA Public Key.
     * (In case you were curious.)
     *
     * @return {string} PEM encoded public key without whitespace.
     * @method toPem
     */
    public String toPem() {
        if (defaultPem == null)
            defaultPem = pki.publicKeyToPem(pk).replaceAll("\r", "").replaceAll("\n", "");
        return defaultPem;
    }

    /**
     * Encodes the public key into a PEM encoded RSAPublicKey (PKCS#1) formatted RSA Public Key.
     * (In case you were curious.)
     *
     * @return {string} PEM encoded public key without whitespace.
     * @method toPkcs1Pem
     */
    public String toPkcs1Pem() {
        return pki.publicKeyToRSAPublicKeyPem(pk).replaceAll("\r", "").replaceAll("\n", "");
    }

    /**
     * Encodes the public key into a PEM encoded SubjectPublicKeyInfo (PKCS#8) formatted RSA Public Key.
     * (In case you were curious.)
     *
     * @return {string} PEM encoded public key without whitespace.
     * @method toPkcs8Pem
     */
    public String toPkcs8Pem() {
        return pki.publicKeyToPem(pk).replaceAll("\r", "").replaceAll("\n", "");
    }

    public Object toJwk() {
        if (jwk == null)
            jwk = pemJwk.pem2jwk(pki.publicKeyToPem(pk));
        return jwk;
    }

    /**
     * Hashes the public key into an SSH compatible fingerprint.
     *
     * @return {string} Public key fingerprint.
     * @method fingerprint
     */
    public String fingerprint() {
        Object o = new Object();
        JSObjectAdapter.$put(o, "encoding", "hex");
        return ssh.getPublicKeyFingerprint(pk, o);
    }

    public Boolean verify(bytes bytes, payload decode64) {
        return pk.verify(bytes, decode64);
    }
}
