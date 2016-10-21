package com.eduworks.ec.array;

import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

public class EcAsyncHelper<T>
{
	public static String scriptPath = null;
	public Integer counter;

	public void each(final Array<T> array, Callback2<T, Callback0> each, final Callback1<Array<T>> after)
	{
		final EcAsyncHelper me = this;
		counter = array.$length();
		if (array.$length() == 0)
			after.$invoke(array);
		for (int i = 0; i < array.$length(); i++)
		{
			if (counter > 0)
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
	}
	public void stop()
	{
		counter = -1;
	}
}
