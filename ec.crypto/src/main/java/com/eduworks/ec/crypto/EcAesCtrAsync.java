package com.eduworks.ec.crypto;

import com.eduworks.ec.blob.ArrayBuffer;
import com.eduworks.ec.blob.BlobHelper;
import com.eduworks.ec.remote.EcRemote;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.jquery.Promise;
import window.*;

public class EcAesCtrAsync {
	public static void encrypt(String plaintext, String secret, String iv, final Callback1<String> success, final Callback1<String> failure) {
		if (Global.window == null || window.crypto == null || crypto.subtle == null) {
			EcAesCtrAsyncWorker.encrypt(plaintext, secret, iv, success, failure);
			return;
		}
		if (EcRemote.async == false)
		{
			success.$invoke(EcAesCtr.encrypt(plaintext, secret, iv));
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("encrypt", "decrypt");
		final AlgorithmIdentifier algorithm = (AlgorithmIdentifier)new Object();
		algorithm.name = "AES-CTR";
		algorithm.counter = base64.decode(iv);
		algorithm.length = 128;
		final ArrayBuffer data;
		data = BlobHelper.str2ab(plaintext);
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

	public static void decrypt(String ciphertext, String secret, String iv, final Callback1<String> success, final Callback1<String> failure) {
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
		if (EcRemote.async == false)
		{
			success.$invoke(EcAesCtr.decrypt(ciphertext, secret, iv));
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("encrypt", "decrypt");
		final AlgorithmIdentifier algorithm = (AlgorithmIdentifier)new Object();
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
						success.$invoke(BlobHelper.ab2str(p1));
					}
				}, failure);
			}
		}, failure);
	}

}
