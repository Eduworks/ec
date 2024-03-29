package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * Message used to retrieve credentials from a remote system.
 * <p>
 * TODO: Vulnerable to replay attacks.
 *
 * @author fritz.ray@eduworks.com
 * @class EbacCredentialRequest
 * @module org.cassproject
 */
public class EbacCredentialRequest extends EcLinkedData {
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/credentialRequest";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/credentialRequest";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/kbac/0.2/CredentialRequest";
	private static final String TYPE_0_4 = "https://schema.cassproject.org/kbac/0.4/CredentialRequest";
	/**
	 * Hashed username.
	 *
	 * @property username
	 * @type string
	 */
	public String username;
	/**
	 * Hashed password to authorize request.
	 *
	 * @property password
	 * @type string
	 */
	public String password;
	public EbacCredentialRequest() {
		super(Ebac.context, TYPE_0_4);
	}

	@Override
	protected void upgrade() {
		super.upgrade();
		if (TYPE_0_1==type) {
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(Ebac.context_0_2, TYPE_0_2);
		}
		if (TYPE_0_2==getFullType()) {
			setContextAndType(Ebac.context_0_3, TYPE_0_3);
		}
		if (TYPE_0_3==getFullType()) {
			setContextAndType(Ebac.context_0_4, TYPE_0_4);
		}
	}

	@Override
	public Array<String> getTypes() {
		Array<String> a = new Array<String>();
		a.push(TYPE_0_4);
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
