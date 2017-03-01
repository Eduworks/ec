package com.eduworks.ec.crypto;

import forge.sha1;
import forge.sha256;
import forge.util;
import org.stjs.javascript.JSObjectAdapter;
import static org.stjs.javascript.jquery.GlobalJQuery.$;
import window.EcLevrCrypto;

/**
 * Helper methods for performing RSA Encryption methods. Uses Optimal Asymmetric
 * Encryption Padding (OAEP) encryption and decryption. Uses RSA SSA PKCS#1 v1.5
 * (RSASSA-PKCS1-V1_5) signing and verifying with UTF8 encoding.
 *
 * @author fritz.ray@eduworks.com
 * @module com.eduworks.ec
 * @class EcRsaOaep
 *
 */
public class EcRsaOaep
{

    /**
     * Encrypts a block of plaintext (no more than 256 bytes) with a public key
     * using RSA OAEP encryption. Returns a base64 encoded ciphertext.
     *
     * @method encrypt
     * @static
     * @param {EcPk} pk Public Key.
     * @param {string} plaintext Plaintext. Does not perform encoding.
     */
    public static String encrypt(EcPk pk, String plaintext)
    {
        if ($ == null)
        {
            return EcLevrCrypto.rsaEncrypt(plaintext, pk.toPem());
        }
        return forge.util.encode64(pk.pk.encrypt(plaintext, "RSA-OAEP"));
    }

    /**
     * Decrypts a block of ciphertext (no more than 256 bytes) with a private
     * key using RSA OAEP encryption. Returns a unencoded plaintext.
     *
     * @method decrypt
     * @static
     * @param {EcPpk} ppk Public private keypair.
     * @param {string} ciphertext Ciphertext.
     * @return {string} Unencoded plaintext.
     */
    public static String decrypt(EcPpk ppk, String ciphertext)
    {
        if (EcCrypto.caching)
        {
            Object cacheGet = null;
            cacheGet = JSObjectAdapter.$get(EcCrypto.decryptionCache, ppk.toPem() + ciphertext);
            if (cacheGet != null)
            {
                return (String) cacheGet;
            }
        }
        final String result;
        if ($ == null)
        {
            result = EcLevrCrypto.rsaDecrypt(ciphertext, ppk.toPem());
        }
        else
        {
            result = ppk.ppk.decrypt(forge.util.decode64(ciphertext), "RSA-OAEP");
        }
        if (EcCrypto.caching)
        {
            JSObjectAdapter.$put(EcCrypto.decryptionCache, ppk.toPem() + ciphertext, result);
        }
        return result;
    }

    /**
     * Creates a signature for the provided text using the public private
     * keypair. May be verified with the public key. Uses SHA1 hash with a UTF8
     * decoding of the text. Returns base64 encoded signature.
     *
     * @method sign
     * @static
     * @param {EcPpk} ppk Public private keypair.
     * @param {string} text Text to sign.
     * @return Base64 encoded signature.
     */
    public static String sign(EcPpk ppk, String text)
    {
        if ($ == null)
        {
            return EcLevrCrypto.rsaSign(text, ppk.toPem());
        }
        sha1 s = sha1.create();
        s.update(text, "utf8");
        return util.encode64(ppk.ppk.sign(s));
    }

    /**
     * Creates a signature for the provided text using the public private
     * keypair. May be verified with the public key. Uses SHA256 hash with a
     * UTF8 decoding of the text. Returns base64 encoded signature.
     *
     * @method signSha256
     * @static
     * @param {EcPpk} ppk Public private keypair.
     * @param {string} text Text to sign.
     * @return Base64 encoded signature.
     */
    public static String signSha256(EcPpk ppk, String text)
    {
        sha256 s = sha256.create();
        s.update(text, "utf8");
        return util.encode64(ppk.ppk.sign(s));
    }

    /**
     * Verifies the integrity of the provided text using a signature and a
     * public key. Uses SHA1 hash with a UTF8 decoding of the text.
     *
     * @static
     * @method verify
     * @param {EcPk} pk Public key.
     * @param {string} text Text to verify.
     * @param {string} signature Base64 encoded signature.
     * @return True IFF the signature is valid.
     */
    public static Boolean verify(EcPk pk, String text, String signature)
    {
        if ($ == null)
        {
            return EcLevrCrypto.rsaVerify(signature, pk.toPem(), text);
        }
        sha1 s = sha1.create();
        s.update(text, "utf8");
        try
        {
            return pk.verify(s.digest().bytes(), util.decode64(signature));
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}
