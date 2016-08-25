package com.eduworks.ec.crypto;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.worker.ErrorEvent;
import org.stjs.javascript.worker.MessageEvent;
import org.stjs.javascript.worker.Worker;
import org.stjs.javascript.worker.WorkerGlobalScope;

import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.remote.EcRemote;

import forge.cipher;
import forge.cipheroutput;
import forge.util;

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

	public static void encrypt(String text, String secret, String iv, Callback1<String> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcAesCtr.encrypt(text, secret, iv));
		}
		else
		{
			Object o = new Object();
			JSObjectAdapter.$put(o, "secret", secret);
			JSObjectAdapter.$put(o, "iv", iv);
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "encryptAesCtr");
			q1.push(success);
			q2.push(failure);
			w.postMessage(o);
		}
	}

	public static void decrypt(String text, String secret, String iv, Callback1<String> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcAesCtr.decrypt(text, secret, iv));
		}
		else
		{
			Object o = new Object();
			JSObjectAdapter.$put(o, "secret", secret);
			JSObjectAdapter.$put(o, "iv", iv);
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "decryptAesCtr");
			q1.push(success);
			q2.push(failure);
			w.postMessage(o);
		}
	}

}
