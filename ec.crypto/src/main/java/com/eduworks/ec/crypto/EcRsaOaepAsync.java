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

import com.eduworks.ec.remote.EcRemote;

public class EcRsaOaepAsync
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

	public static void encrypt(EcPk pk, String text, Callback1<String> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcRsaOaep.encrypt(pk, text));
		}
		else
		{
			Object o = new Object();
			JSObjectAdapter.$put(o, "pk", pk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "encryptRsaOaep");
			q1.push(success);
			q2.push(failure);
			w.postMessage(o);
		}
	}

	public static void decrypt(EcPpk ppk, String text, Callback1<String> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcRsaOaep.decrypt(ppk, text));
		}
		else
		{
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "decryptRsaOaep");
			q1.push(success);
			q2.push(failure);
			w.postMessage(o);
		}
	}

	public static void sign(EcPpk ppk, String text, Callback1<String> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcRsaOaep.sign(ppk, text));
		}
		else
		{
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "signRsaOaep");
			q1.push(success);
			q2.push(failure);
			w.postMessage(o);
		}
	}

	public static void signSha256(EcPpk ppk, String text, Callback1<String> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcRsaOaep.signSha256(ppk, text));
		}
		else
		{
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "signSha256RsaOaep");
			q1.push(success);
			q2.push(failure);
			w.postMessage(o);
		}
	}

	public static void verify(EcPk pk, String text, String signature, Callback1<Boolean> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcRsaOaep.verify(pk, text, signature));
		}
		else
		{
			Object o = new Object();
			JSObjectAdapter.$put(o, "pk", pk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "signature", signature);
			JSObjectAdapter.$put(o, "cmd", "verifyRsaOaep");
			q1.push(success);
			q2.push(failure);
			w.postMessage(o);
		}
	}
}
