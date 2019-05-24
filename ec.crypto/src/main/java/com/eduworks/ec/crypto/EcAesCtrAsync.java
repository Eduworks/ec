package com.eduworks.ec.crypto;

import com.eduworks.ec.blob.ArrayBuffer;
import com.eduworks.ec.blob.BlobHelper;
import com.eduworks.ec.remote.EcRemote;
import forge.util;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.jquery.Promise;
import window.*;

/**
 * Async version of EcAesCtr that uses browser extensions (window.crypto) to accomplish cryptography much faster.
 * Falls back to EcAesCtrAsyncWorker, if window.crypto is not available.
 * @class EcAesCtrAsync
 */
public class EcAesCtrAsync {
    /**
     * Asynchronous form of {{#crossLink
     * "EcAesCtr/encrypt:method"}}EcAesCtr.encrypt{{/crossLink}}
     *
     * @param {string}           plaintext Text to encrypt.
     * @param {string}           secret Secret to use to encrypt.
     * @param {string}           iv Initialization Vector to use to encrypt.
     * @param {function(string)} success Success method, result is Base64
     *                           encoded Ciphertext.
     * @param {function(string)} failure Failure method, parameter is error
     *                           message.
     * @method encrypt
     * @static
     */
    public static void encrypt(String plaintext, String secret, String iv, final Callback1<String> success, final Callback1<String> failure) {
        if (Global.window == null || window.crypto == null || crypto.subtle == null) {
            EcAesCtrAsyncWorker.encrypt(plaintext, secret, iv, success, failure);
            return;
        }
        if (EcRemote.async == false) {
            success.$invoke(EcAesCtr.encrypt(plaintext, secret, iv));
            return;
        }
        Array<String> keyUsages = new Array<>();
        keyUsages.push("encrypt", "decrypt");
        final AlgorithmIdentifier algorithm = (AlgorithmIdentifier) new Object();
        algorithm.name = "AES-CTR";
        algorithm.counter = base64.decode(iv);
        algorithm.length = 128;
        final ArrayBuffer data;
        data = BlobHelper.str2ab(util.encodeUtf8(plaintext));
        crypto.subtle.importKey("raw", base64.decode(secret), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
            @Override
            public void $invoke(CryptoKey key) {
                Promise p = crypto.subtle.encrypt(algorithm, key, data);

                p.then(new Callback1<ArrayBuffer>() {
                    @Override
                    public void $invoke(ArrayBuffer p1) {
                        success.$invoke(base64.encode(p1));
                    }
                }, failure);
            }
        }, failure);
    }

    /**
     * Asynchronous form of {{#crossLink
     * "EcAesCtr/decrypt:method"}}EcAesCtr.decrypt{{/crossLink}}
     *
     * @param {string}           ciphertext Text to decrypt.
     * @param {string}           secret Secret to use to decrypt.
     * @param {string}           iv Initialization Vector to use to decrypt.
     * @param {function(string)} success Success method, result is Plaintext
     *                           with no encoding.
     * @param {function(string)} failure Failure method, parameter is error
     *                           message.
     * @method decrypt
     * @static
     */
    public static void decrypt(final String ciphertext, final String secret, final String iv, final Callback1<String> success, final Callback1<String> failure) {
        if (EcCrypto.caching) {
            final Object cacheGet = JSObjectAdapter.$get(EcCrypto.decryptionCache, secret + iv + ciphertext);
            if (cacheGet != null) {
                success.$invoke((String) cacheGet);
                return;
            }
        }
        if (window.crypto == null || crypto.subtle == null) {
            EcAesCtrAsyncWorker.decrypt(ciphertext, secret, iv, success, failure);
            return;
        }
        if (EcRemote.async == false) {
            success.$invoke(EcAesCtr.decrypt(ciphertext, secret, iv));
        }
        Array<String> keyUsages = new Array<>();
        keyUsages.push("encrypt", "decrypt");
        final AlgorithmIdentifier algorithm = (AlgorithmIdentifier) new Object();
        algorithm.name = "AES-CTR";
        algorithm.counter = base64.decode(iv);
        algorithm.length = 128;
        final ArrayBuffer data;
        data = base64.decode(ciphertext);
        crypto.subtle.importKey("raw", base64.decode(secret), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
            @Override
            public void $invoke(CryptoKey key) {
                Promise p = crypto.subtle.decrypt(algorithm, key, data);
                p.then(new Callback1<ArrayBuffer>() {
                    @Override
                    public void $invoke(ArrayBuffer p1) {
                        JSObjectAdapter.$put(EcCrypto.decryptionCache, secret + iv + ciphertext, util.decodeUtf8(BlobHelper.ab2str(p1)));
                        success.$invoke(util.decodeUtf8(BlobHelper.ab2str(p1)));
                    }
                }, failure);
            }
        }, failure);
    }

}
