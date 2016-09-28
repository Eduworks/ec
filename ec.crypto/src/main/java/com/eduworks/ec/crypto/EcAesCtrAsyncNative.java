package com.eduworks.ec.crypto;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Window;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.CallbackOrFunction;
import org.stjs.javascript.jquery.Promise;
import org.stjs.javascript.worker.ErrorEvent;
import org.stjs.javascript.worker.MessageEvent;
import org.stjs.javascript.worker.Worker;
import org.stjs.javascript.worker.WorkerGlobalScope;

import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.blob.BlobHelper;
import com.eduworks.ec.remote.EcRemote;

import forge.cipher;
import forge.cipheroutput;
import forge.util;
import window.AlgorithmIdentifier;
import window.ArrayBuffer;
import window.base64;
import window.crypto;

public class EcAesCtrAsync
{
	static Worker<Object> w;
	static Array<Callback1> q1;
	static Array<Callback1> q2;

	public static void initWorker()
	{
		if (JSGlobal.typeof(WorkerGlobalScope.self).equals("undefined"))
			return;
		if (!EcRemote.async)
			return;
		if (w != null)
			return;
		q1 = new Array<>();
		q2 = new Array<>();
		w = new Worker<Object>(JSObjectAdapter.$get(Global.window, "scriptPath") + "forgeAsync.js");
		w.onmessage = new Callback1<MessageEvent<Object>>()
		{
			@Override
			public void $invoke(MessageEvent<Object> p1)
			{
				Object o = p1.data;
				Callback1 success = q1.shift();
				Callback1 failure = q2.shift();
				if (success != null)
					success.$invoke(JSObjectAdapter.$get(o, "result"));
			}
		};
		w.onerror = new Callback1<ErrorEvent>()
		{
			@Override
			public void $invoke(ErrorEvent p1)
			{
				Callback1 success = q1.shift();
				Callback1 failure = q2.shift();
				if (failure != null)
					failure.$invoke(p1.toString());
			}
		};
	}

	public static void encrypt(String text, String secret, String iv, final Callback1<String> success, Callback1<String> failure)
	{
		AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "AES-CTR";
		algorithm.iv = base64.decode(iv);
		ArrayBuffer key;
		key = base64.decode(secret);
		ArrayBuffer data;
		data = base64.decode(text);
		Promise p = crypto.subtle.encrypt(algorithm, key, data);
		p.then(new Callback1<Array>()
		{
			@Override
			public void $invoke(Array p1)
			{
				ArrayBuffer ab = new ArrayBuffer(p1);
				success.$invoke(base64.encode(ab));
			}
		});
	}

	public static void decrypt(String text, String secret, String iv, final Callback1<String> success, Callback1<String> failure)
	{
		AlgorithmIdentifier algorithm = new AlgorithmIdentifier();
		algorithm.name = "AES-CTR";
		algorithm.iv = base64.decode(iv);
		ArrayBuffer key;
		key = base64.decode(secret);
		ArrayBuffer data;
		data = base64.decode(text);
		Promise p = crypto.subtle.decrypt(algorithm, key, data);
		p.then(new Callback1<Array>()
		{
			@Override
			public void $invoke(Array p1)
			{
				ArrayBuffer ab = new ArrayBuffer(p1);
				success.$invoke(BlobHelper.ab2str(ab));
			}
		});
	}

}
