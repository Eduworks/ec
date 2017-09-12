package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.schema.ebac.EbacContactGrant;

/**
 * Contact Grant that is used to share your public key with another user
 *
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 * @module com.eduworks.ec
 * @class EcContact
 * @extends EbacContactGrant
 * @constructor
 */
public class EcContactGrant extends EbacContactGrant {
	/**
	 * Verifies that the contact grant is valid
	 *
	 * @return {boolean}
	 * true if valid, false if not
	 */
	public boolean valid() {
		if (!verify())
			return false;
		if (invalid())
			return false;
		boolean found = false;
		for (int i = 0; i < EcIdentityManager.ids.$length(); i++) {
			if (EcRsaOaep.verify(EcIdentityManager.ids.$get(i).ppk.toPk(), responseToken, responseSignature))
				found = true;
		}

		return found;
	}

}
