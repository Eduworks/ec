package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.schema.ebac.EbacContactGrant;

public class EcContactGrant extends EbacContactGrant
{
	public static String myType = "http://schema.eduworks.com/ebac/0.1/contactGrant";
	public boolean valid()
	{
		if (!verify()) return false;
		if (invalid()) return false;
		boolean found = false;
		for (int i = 0;i < EcIdentityManager.ids.$length();i++)
		{
			if (EcRsaOaep.verify(EcIdentityManager.ids.$get(i).ppk.toPk(), responseToken, responseSignature))
				found = true;
		}
		
		return found;
	}
}