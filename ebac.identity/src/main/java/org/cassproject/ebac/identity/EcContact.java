package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcPk;

/**
 * A contact is an identity that we do not own. Using the public key we may: 1.
 * Send them information (by encrypting data with their public key) 2. Verify a
 * signed message that was sent (by using the verify function of the public key)
 * 3. Distinguish between this identity and other identities through the
 * displayName.
 * 
 * @author fray
 *
 */
public class EcContact
{
	public EcPk pk;
	public String displayName;
	public String source;

	public String getImageUrl()
	{
		return "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/48px-User_icon_2.svg.png";
	}
}
