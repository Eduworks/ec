package com.eduworks.schema.ebac;

import org.cassproject.schema.general.Ebac;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * Message used to commit credentials to a remote login server.
 * 
 * TODO: Semi-vulnerable to replay attacks. Token field prevents some replay
 * attacks.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacCredentialCommit extends EcLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/credentialCommit";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/credentialCommit";
	public EbacCredentialCommit()
	{
		super(Ebac.context, TYPE_0_2);
		credentials = new EbacCredentials();
	}

	/**
	 * Hashed username.
	 */
	public String username;
	/**
	 * Hashed password to authorize commit.
	 */
	public String password;
	/**
	 * Token provided to client when previously executed Request was done. May
	 * be empty if this is used as part of Create action.
	 */
	public String token;
	/**
	 * List of credentials to commit to the login server storage.
	 */
	public EbacCredentials credentials;
	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (type.equals(TYPE_0_1))
		{
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(Ebac.context_0_2,TYPE_0_2);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
