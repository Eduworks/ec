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

public class EcAesCtrAsyncNative
{
	public static void encrypt(String text, String secret, String iv, final Callback1<String> success, Callback1<String> failure)
	{
		Array<String> keyUsages = new Array<>();
		keyUsages.push("encrypt", "decrypt");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "AES-CTR";
		algorithm.counter = base64.decode(iv);
		algorithm.length = 128;
		final ArrayBuffer data;
		data = BlobHelper.str2ab(text);
		crypto.subtle.importKey("raw", base64.decode(secret), algorithm, false, keyUsages).then(new Callback1<CryptoKey>()
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

	public static void decrypt(String text, String secret, String iv, final Callback1<String> success, Callback1<String> failure)
	{
		Array<String> keyUsages = new Array<>();
		keyUsages.push("encrypt", "decrypt");
		final AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "AES-CTR";
		algorithm.counter = base64.decode(iv);
		algorithm.length = 128;
		final ArrayBuffer data;
		data = base64.decode(text);
		crypto.subtle.importKey("raw", base64.decode(secret), algorithm, false, keyUsages).then(new Callback1<CryptoKey>()
		{
			@Override
			public void $invoke(CryptoKey key)
			{
				Promise p = crypto.subtle.decrypt(algorithm, key, data);
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

}
