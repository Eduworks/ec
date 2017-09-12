package com.eduworks.ec.crypto;

import com.eduworks.ec.blob.ArrayBuffer;
import com.eduworks.ec.blob.BlobHelper;
import com.eduworks.ec.remote.EcRemote;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import window.AlgorithmIdentifier;
import window.CryptoKey;
import window.base64;
import window.crypto;

public class EcRsaOaepAsync {
	public static void encrypt(final EcPk pk, final String text, final Callback1<String> success, final Callback1<String> failure) {
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.encrypt(pk, text));
			return;
		}
		if (crypto.subtle == null) {
			EcRsaOaepAsyncWorker.encrypt(pk, text, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("encrypt");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "RSA-OAEP";
		algorithm.hash = "SHA-1";

		if (pk.key == null)
			crypto.subtle.importKey("jwk", pk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					pk.key = key;
					crypto.subtle.encrypt(algorithm, key, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
						@Override
						public void $invoke(ArrayBuffer p1) {
							success.$invoke(base64.encode(p1));
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.encrypt(algorithm, pk.key, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
				@Override
				public void $invoke(ArrayBuffer p1) {
					success.$invoke(base64.encode(p1));
				}
			}, failure);

	}

	public static void decrypt(final EcPpk ppk, final String text, final Callback1<String> success, final Callback1<String> failure) {

		if (EcCrypto.caching) {
			Object cacheGet = null;
			cacheGet = JSObjectAdapter.$get(EcCrypto.decryptionCache, ppk.toPem() + text);
			if (cacheGet != null) {
				success.$invoke((String) cacheGet);
				return;
			}
		}
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.decrypt(ppk, text));
			return;
		}
		if (crypto.subtle == null) {
			EcRsaOaepAsyncWorker.decrypt(ppk, text, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("decrypt");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "RSA-OAEP";
		algorithm.hash = "SHA-1";

		if (ppk.key == null)
			crypto.subtle.importKey("jwk", ppk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					ppk.key = key;
					crypto.subtle.decrypt(algorithm, key, base64.decode(text)).then(new Callback1<ArrayBuffer>() {
						@Override
						public void $invoke(ArrayBuffer p1) {
							success.$invoke(BlobHelper.ab2str(p1));
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.decrypt(algorithm, ppk.key, base64.decode(text)).then(new Callback1<ArrayBuffer>() {
				@Override
				public void $invoke(ArrayBuffer p1) {
					success.$invoke(BlobHelper.ab2str(p1));
				}
			}, failure);
	}

	public static void sign(final EcPpk ppk, final String text, final Callback1<String> success, final Callback1<String> failure) {
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.sign(ppk, text));
			return;
		}
		if (crypto.subtle == null) {
			EcRsaOaepAsyncWorker.sign(ppk, text, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("sign");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "RSASSA-PKCS1-v1_5";
		algorithm.hash = "SHA-1";

		if (ppk.signKey == null)
			crypto.subtle.importKey("jwk", ppk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					ppk.signKey = key;
					crypto.subtle.sign(algorithm, key, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
						@Override
						public void $invoke(ArrayBuffer p1) {
							success.$invoke(base64.encode(p1));
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.sign(algorithm, ppk.signKey, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
				@Override
				public void $invoke(ArrayBuffer p1) {
					success.$invoke(base64.encode(p1));
				}
			}, failure);
	}

	public static void signSha256(final EcPpk ppk, final String text, final Callback1<String> success, final Callback1<String> failure) {
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.signSha256(ppk, text));
			return;
		}
		if (crypto.subtle == null) {
			EcRsaOaepAsyncWorker.sign(ppk, text, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("sign");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "RSASSA-PKCS1-v1_5";
		algorithm.hash = "SHA-256";

		if (ppk.signKey == null)
			crypto.subtle.importKey("jwk", ppk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					ppk.signKey = key;
					crypto.subtle.sign(algorithm, key, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
						@Override
						public void $invoke(ArrayBuffer p1) {
							success.$invoke(base64.encode(p1));
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.sign(algorithm, ppk.signKey, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
				@Override
				public void $invoke(ArrayBuffer p1) {
					success.$invoke(base64.encode(p1));
				}
			}, failure);
	}

	public static void verify(final EcPk pk, final String text, final String signature, final Callback1<Boolean> success, final Callback1<String> failure) {
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.verify(pk, text, signature));
			return;
		}
		if (crypto.subtle == null) {
			EcRsaOaepAsyncWorker.verify(pk, text, signature, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("verify");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "RSASSA-PKCS1-v1_5";
		algorithm.hash = "SHA-1";

		if (pk.signKey == null)
			crypto.subtle.importKey("jwk", pk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					pk.signKey = key;
					crypto.subtle.verify(algorithm, key, base64.decode(signature), BlobHelper.str2ab(text)).then(new Callback1<Boolean>() {
						@Override
						public void $invoke(Boolean p1) {
							success.$invoke(p1);
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.verify(algorithm, pk.signKey, base64.decode(signature), BlobHelper.str2ab(text)).then(new Callback1<Boolean>() {
				@Override
				public void $invoke(Boolean p1) {
					success.$invoke(p1);
				}
			}, failure);
	}
}
