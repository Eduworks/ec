package com.eduworks.ec.ebac.identity;

import com.eduworks.ec.crypto.EcPpk;

public class EcIdentity
{
	public EcPpk ppk;
	public String displayName;
	public String source;
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EcIdentity)
			return ppk.equals(((EcIdentity)obj).ppk);
		return super.equals(obj);
	}
}
