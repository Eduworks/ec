package com.eduworks.ec.task;

import com.eduworks.ec.date.Date;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.TimeoutHandler;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.CallbackOrFunction;

/**
 * Created by fray on 7/5/17.
 */
public class Task {
	public static int desiredFps = 10;
	public static Long lastFrame = null;
	public static Array<CallbackOrFunction> tasks = null;
	public static int delayedFunctions = 0;
	public static int immediateFunctions = 0;

	public static TimeoutHandler immediate(final Callback0 c) {
		final Long currentMs = Date.now();
		int nextFrameMs = 1000 / desiredFps;
		if (lastFrame == null || currentMs > lastFrame + nextFrameMs)
			return Global.setTimeout(new Callback0() {
				@Override
				public void $invoke() {
					delayedFunctions++;
					lastFrame = Date.now();
					c.$invoke();
				}
			}, 0);
		else {
			immediateFunctions++;
			c.$invoke();
		}
		return null;
	}
}
