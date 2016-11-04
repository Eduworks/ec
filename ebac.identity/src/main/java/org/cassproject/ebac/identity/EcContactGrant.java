package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.schema.ebac.EbacContactGrant;

public class EcContactGrant extends EbacContactGrant
{
	public boolean valid()
	{
		if (!verify())
			return false;
		if (invalid())
			return false;
		boolean found = false;
		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			if (EcRsaOaep.verify(EcIdentityManager.ids.$get(i).ppk.toPk(), responseToken, responseSignature))
				found = true;
		}

		return found;
	}

}
