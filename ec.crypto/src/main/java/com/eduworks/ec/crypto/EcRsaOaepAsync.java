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
	static int rotator;
	static Array<Worker<Object>> w;
	static Array<Array<Callback1>> q1;
	static Array<Array<Callback1>> q2;

	public static void initWorker()
	{
		if (JSGlobal.typeof(WorkerGlobalScope.self).equals("undefined"))
			return;
		if (!EcRemote.async)
			return;
		if (w != null)
			return;
		rotator = 0;
		q1 = new Array<>();
		q2 = new Array<>();
		w = new Array<>();
		for (int index = 0;index < 8;index++)
		{
			createWorker(index);
		}
	}

	private static void createWorker(final int index)
	{
		q1.push(new Array<Callback1>());
		q2.push(new Array<Callback1>());
		Worker<Object> wkr;
		w.push(wkr=new Worker<Object>(JSObjectAdapter.$get(Global.window, "scriptPath") + "forgeAsync.js"));
		wkr.onmessage = new Callback1<MessageEvent<Object>>()
		{
			@Override
			public void $invoke(MessageEvent<Object> p1)
			{
				Object o = p1.data;
				Callback1 success = q1.$get(index).shift();
				Callback1 failure = q2.$get(index).shift();
				if (success != null)
					success.$invoke(JSObjectAdapter.$get(o, "result"));
			}
		};
		wkr.onerror = new Callback1<ErrorEvent>()
		{
			@Override
			public void $invoke(ErrorEvent p1)
			{
				Callback1 success = q1.$get(index).shift();
				Callback1 failure = q2.$get(index).shift();
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
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "pk", pk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "encryptRsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
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
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "decryptRsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
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
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "signRsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
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
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "cmd", "signSha256RsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
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
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "pk", pk.toPem());
			JSObjectAdapter.$put(o, "text", text);
			JSObjectAdapter.$put(o, "signature", signature);
			JSObjectAdapter.$put(o, "cmd", "verifyRsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
		}
	}
}
