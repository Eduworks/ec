package com.eduworks.ec.array;

import org.stjs.javascript.Array;

public class EcArray
{
	public static boolean isArray(Object o)
	{
		return toString.call(o)=="[object Array]";
	}
	
	public static void removeDuplicates(Array a)
	{
		for (int i = 0;i < a.$length();i++)
			for (int j = i;j < a.$length();j++)
			{
				if (j == i) continue;
				if (a.$get(i) == a.$get(j))
					a.splice(j,1);
			}
	}
}
