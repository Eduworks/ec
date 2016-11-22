package com.eduworks.ec.crypto;

import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.jquery.Promise;

import com.eduworks.ec.blob.ArrayBuffer;
import com.eduworks.ec.blob.BlobHelper;

import window.AlgorithmIdentifier;
import window.CryptoKey;
import window.base64;
import window.crypto;

public class EcRsaOaepAsyncNative
{
	public static void encrypt(EcPk pk, String text, final Callback1<String> success, Callback1<String> failure)
	{
		String base64pk = pk.toPkcs8Pem().replace("-----BEGIN RSA PUBLIC KEY-----", "").replace("-----END RSA PUBLIC KEY-----", "");

		Array<String> keyUsages = new Array<>();
		keyUsages.push("encrypt");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "RSA-OAEP";
		algorithm.hash = "SHA-1";
		
		final ArrayBuffer data;
		data = BlobHelper.str2ab(text);
		crypto.subtle.importKey("spki", base64.decode(base64pk), algorithm, false, keyUsages).then(new Callback1<CryptoKey>()
		{
			@Override
			public void $invoke(CryptoKey key)
			{
				Promise p = crypto.subtle.encrypt(algorithm, key, data);
				
				p.then(new Callback1<ArrayBuffer>()
				{
					@Override
					public void $invoke(ArrayBuffer p1)
					{
						success.$invoke(base64.encode(p1));
					}
				});
			}
		});
	}

	public static void decrypt(EcPpk ppk, final String text, final Callback1<String> success, Callback1<String> failure)
	{
		String base64ppk = ppk.toPem().replace("-----BEGIN RSA PRIVATE KEY-----", "").replace("-----END RSA PRIVATE KEY-----", "");

		Array<String> keyUsages = new Array<>();
		keyUsages.push("decrypt");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "RSA-OAEP";
		algorithm.hash = "SHA-1";
		
		crypto.subtle.importKey("pkcs8", base64.decode(base64ppk), algorithm, false, keyUsages).then(new Callback1<CryptoKey>()
		{
			@Override
			public void $invoke(CryptoKey key)
			{
				Promise p = crypto.subtle.decrypt(algorithm, key, base64.decode(text));
				
				p.then(new Callback1<ArrayBuffer>()
				{
					@Override
					public void $invoke(ArrayBuffer p1)
					{
						success.$invoke(BlobHelper.ab2str(p1));
					}
				});
			}
		});
	}

	public static void sign(EcPpk ppk, String text, Callback1<String> success, Callback1<String> failure)
	{
		
	}

	public static void signSha256(EcPpk ppk, String text, Callback1<String> success, Callback1<String> failure)
	{
		
	}

	public static void verify(EcPk pk, String text, String signature, Callback1<Boolean> success, Callback1<String> failure)
	{
		
	}
}
