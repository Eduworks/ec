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

/**
 * Asynchronous implementation of {{#crossLink "EcAesCtr"}}EcAesCtr{{/crossLink}}. Uses web workers and assumes 8 workers.
 * @class EcAesCtrAsync
 * @module com.eduworks.ec
 * @author fritz.ray@eduworks.com
 *
 */
public class EcAesCtrAsync
{
	static int rotator;
	static Array<Worker<Object>> w;
	static Array<Array<Callback1>> q1;
	static Array<Array<Callback1>> q2;

	private static void initWorker()
	{
		if (Global.window == null && JSGlobal.typeof(WorkerGlobalScope.self).equals("undefined"))
			return;
		if (!EcRemote.async)
			return;
		if (w != null)
			return;
		rotator = 0;
		q1 = new Array<>();
		q2 = new Array<>();
		w = new Array<>();
		for (int index = 0; index < 8; index++)
		{
			createWorker(index);
		}
	}

	private static void createWorker(final int index)
	{
		q1.push(new Array<Callback1>());
		q2.push(new Array<Callback1>());
		Worker<Object> wkr;
		w.push(wkr = new Worker<Object>(JSObjectAdapter.$get(Global.window, "scriptPath") + "forgeAsync.js"));
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

	/**
	 * Asynchronous form of {{#crossLink "EcAesCtr/encrypt:method"}}EcAesCtr.encrypt{{/crossLink}}
	 * @method encrypt
	 * @static
	 * @param {string} plaintext Text to encrypt.
	 * @param {string} secret Secret to use to encrypt.
	 * @param {string} iv Initialization Vector to use to encrypt.
	 * @param {function(string)} success Success method, result is Base64 encoded Ciphertext.
	 * @param {function(string)} failure Failure method, parameter is error message.
	 */
	public static void encrypt(String plaintext, String secret, String iv, Callback1<String> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcAesCtr.encrypt(plaintext, secret, iv));
		} else
		{
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "secret", secret);
			JSObjectAdapter.$put(o, "iv", iv);
			JSObjectAdapter.$put(o, "text", plaintext);
			JSObjectAdapter.$put(o, "cmd", "encryptAesCtr");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
		}
	}

	/**
	 * Asynchronous form of {{#crossLink "EcAesCtr/decrypt:method"}}EcAesCtr.decrypt{{/crossLink}}
	 * @method decrypt
	 * @static
	 * @param {string} ciphertext Text to decrypt.
	 * @param {string} secret Secret to use to decrypt.
	 * @param {string} iv Initialization Vector to use to decrypt.
	 * @param {function(string)} success Success method, result is Plaintext with no encoding.
	 * @param {function(string)} failure Failure method, parameter is error message.
	 */
	public static void decrypt(String ciphertext, String secret, String iv, Callback1<String> success, Callback1<String> failure)
	{
		initWorker();
		if (!EcRemote.async || w == null)
		{
			success.$invoke(EcAesCtr.decrypt(ciphertext, secret, iv));
		} else
		{
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "secret", secret);
			JSObjectAdapter.$put(o, "iv", iv);
			JSObjectAdapter.$put(o, "text", ciphertext);
			JSObjectAdapter.$put(o, "cmd", "decryptAesCtr");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
		}
	}

}
