package com.eduworks.ec.ebac.identity;

import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;

public class EcIdentityManager
{
	protected static Array<EcIdentity> ids;
	protected static Array<EcContact> contacts;
	public static Callback1<EcPpk> onKeyAdded = null;
	public static void keyAdded(EcPpk ppk)
	{
		if (onKeyAdded != null)
			onKeyAdded.$invoke(ppk);
	}
	public static void add(EcIdentity identity)
	{
		// TODO Auto-generated method stub
		
	}
}
