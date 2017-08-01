package com.eduworks.ec.array;

import com.eduworks.ec.task.Task;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Pattern (probably similar to Promise) that provides fine grained control over asynchronous execution.
 * Will iterate over all items in an array and perform 'each(item,callback)'. 
 * Every 'each' needs to call the callback. This callback can be passed down through several asynchronous calls. 
 * When all callbacks have been called, 'after(array)' is called. 
 * @author fritz.ray@eduworks.com
 * @module com.eduworks.ec
 * @class EcAsyncHelper
 */
public class EcAsyncHelper<T>
{
	public static String scriptPath = null;
	/**
	 * Counter that counts down when each callback is called. Lots of tricks can be done to cause after to proc in different ways.
	 * @property counter
	 * @type integer
	 */
	public Integer counter;

	/**
	 * "Each" method. See class description.
	 * @method each
	 * @param {Array} array Array to iterate over.
	 * @param {function(item,callback)} each Method that gets invoked per item in the array.
	 * @param {function(array)} after Method invoked when all callbacks are called.
	 */
	public void each(final Array<T> array, Callback2<T, Callback0> each, final Callback1<Array<T>> after)
	{
		final EcAsyncHelper me = this;
		counter = array.$length();
		if (array.$length() == 0)
			after.$invoke(array);
		for (int i = 0; i < array.$length(); i++)
		{
			if (counter > 0)
				execute(array, each, after, me, i);
		}
	}

	private void execute(final Array<T> array, final Callback2<T, Callback0> each, final Callback1<Array<T>> after, final EcAsyncHelper me, final int i) {
		Task.immediate(new Callback0() {
			@Override
			public void $invoke() {
				each.$invoke(array.$get(i), new Callback0()
				{
					@Override
					public void $invoke()
					{
						me.counter--;
						if (me.counter == 0)
							after.$invoke(array);
					}
				});
			}
		});
	}

	/**
	 * Will prevent 'after' from being called.
	 * @method stop
	 */
	public void stop()
	{
		counter = -1;
	}
}
