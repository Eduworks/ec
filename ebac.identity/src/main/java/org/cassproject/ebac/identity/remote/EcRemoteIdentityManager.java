package org.cassproject.ebac.identity.remote;

import org.cassproject.ebac.identity.EcContact;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallbackReturn0;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.schema.ebac.EbacContact;
import com.eduworks.schema.ebac.EbacCredential;
import com.eduworks.schema.ebac.EbacCredentialCommit;
import com.eduworks.schema.ebac.EbacCredentialRequest;
import com.eduworks.schema.ebac.EbacCredentials;

import forge.pkcs5;
import forge.util;

/**
 * Logs into and stores/retrieves credentials from a compatible remote server.
 * Performs complete anonymization of the user.
 * 
 * Requires initialization with application specific salts. Application specific
 * salts prevent co-occurrence attacks, should credentials in one application be
 * compromised (intercepted in transit).
 * 
 * Transmits hashed username, hashed password, and encrypts credentials using
 * the hashed combination of the username and password. This prevents the system
 * storing the credentials from having any knowledge of the user.
 * 
 * Password recovery is done through, when the password changes, creating a
 * cryptographic pad (or perfect cipher) where one half is stored on the server,
 * and the other half is stored with the user. Should the user lose this pad and
 * forget their password, they are not able to recover or reset their password,
 * and their data should be considered lost.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EcRemoteIdentityManager
{
	private String usernameSalt = null;
	private int usernameIterations;
	private int usernameWidth;
	private String passwordSalt = null;
	private int passwordIterations;
	private int passwordWidth;
	private String secretSalt = null;
	private int secretIterations;
	private boolean configured = false;

	protected String server = null;

	protected String usernameWithSalt = null;
	protected String passwordWithSalt = null;
	protected String secretWithSalt = null;
	protected String pad = null;
	protected String token = null;

	/**
	 * Configure parameters of the remote login storage.
	 * 
	 * @param usernameSalt
	 *            Salt used in hashing the username.
	 * @param usernameIterations
	 *            Number of times to hash the username.
	 * @param usernameWidth
	 *            Resultant width of username in bytes.
	 * @param passwordSalt
	 *            Salt used to hash password.
	 * @param passwordIterations
	 *            Number of times to hash password.
	 * @param passwordWidth
	 *            Resultant width of password in bytes.
	 * @param secretSalt
	 *            Salt used to hash secret (composed of username + password)
	 * @param secretIterations
	 *            Number of times to hash secret.
	 */
	public void configure(String usernameSalt, int usernameIterations, int usernameWidth, String passwordSalt, int passwordIterations, int passwordWidth,
			String secretSalt, int secretIterations)
	{
		this.usernameSalt = usernameSalt;
		this.usernameIterations = usernameIterations;
		this.usernameWidth = usernameWidth;
		this.passwordSalt = passwordSalt;
		this.passwordIterations = passwordIterations;
		this.passwordWidth = passwordWidth;
		this.secretSalt = secretSalt;
		this.secretIterations = secretIterations;
		configured = true;
	}

	/**
	 * Wipes login data.
	 */
	public void clear()
	{
		usernameWithSalt = null;
		passwordWithSalt = null;
		secretWithSalt = null;
		pad = null;
		token = null;
	}

	/**
	 * Configure compatible remote identity management server.
	 * 
	 * @param server
	 *            URL to remote identity management server.
	 */
	public void setDefaultIdentityManagementServer(String server)
	{
		this.server = server;
	}

	/**
	 * "Log Into" system, generating credentials. Does not actually remotely
	 * access any machine.
	 * 
	 * Please clear username and password fields after this function is called.
	 * 
	 * @param username
	 *            Username
	 * @param password
	 *            Password
	 */
	public void startLogin(String username, String password)
	{
		if (!configured)
			Global.alert("Remote Identity not configured.");

		usernameWithSalt = util.encode64(pkcs5.pbkdf2(username, usernameSalt, usernameIterations, usernameWidth));
		passwordWithSalt = util.encode64(pkcs5.pbkdf2(password, passwordSalt, passwordIterations, passwordWidth));

		Array<String> arys = new Array<String>();
		arys.push(username, password);
		String secret = splicePasswords(arys);
		secretWithSalt = util.encode64(pkcs5.pbkdf2(secret, secretSalt, secretIterations, 32));
	}

	/**
	 * Fetch credentials from server, invoking events based on login success or
	 * failure.
	 * 
	 * Automatically populates EcIdentityManager.
	 * 
	 * Requires login().
	 * 
	 * @param success
	 * @param failure
	 */
	public void fetch(final Callback1<Object> success, final Callback1<String> failure)
	{
		if (!configured)
			Global.alert("Remote Identity not configured.");
		if (usernameWithSalt == null || passwordWithSalt == null || secretWithSalt == null)
		{
			Global.alert("Please log in before performing this operation.");
			return;
		}

		EbacCredentialRequest r = new EbacCredentialRequest();
		r.username = usernameWithSalt;
		r.password = passwordWithSalt;

		FormData fd = new FormData();
		fd.append("credentialRequest", r.toJson());
		final EcRemoteIdentityManager me = this;
		EcRemote.postExpectingObject(server, "sky/id/login", fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object arg0)
			{
				EbacCredentials cs = (EbacCredentials) arg0;
				me.pad = cs.pad;
				me.token = cs.token;
				if (cs.credentials != null)
					for (int i = 0; i < cs.credentials.$length(); i++)
					{
						EbacCredential c = cs.credentials.$get(i);
						EcIdentity identity = EcIdentity.fromCredential(c, me.secretWithSalt, me.server);
						EcIdentityManager.addIdentity(identity);
					}
				if (cs.contacts != null)
					for (int i = 0; i < cs.contacts.$length(); i++)
					{
						EbacContact c = cs.contacts.$get(i);
						EcContact identity = EcContact.fromEncryptedContact(c, me.secretWithSalt, me.server);
						EcIdentityManager.addContact(identity);
					}

				success.$invoke(arg0);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String arg0)
			{
				failure.$invoke(arg0);
			}
		});
	}

	/**
	 * Commits credentials in EcIdentityManager to remote server.
	 * 
	 * Will trigger pad generation and fail if the pad has not been specified.
	 * 
	 * @param success
	 * @param failure
	 * @param padGenerationCallback
	 */
	public void commit(final Callback1<String> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback)
	{
		String service = "sky/id/commit";
		sendCredentials(success, failure, padGenerationCallback, service);
	}

	/**
	 * Creates an account.
	 * 
	 * Please note that the remote login server does not throw error messages if
	 * an account creation is blocked due to being a duplicate. This prevents
	 * login probing. This will always succeed (if the request is properly
	 * formed and makes it to the server).
	 * 
	 * Will trigger pad generation and fail if the pad has not been specified.
	 * 
	 * @param success
	 * @param failure
	 * @param padGenerationCallback
	 */
	public void create(final Callback1<String> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback)
	{
		String service = "sky/id/create";
		sendCredentials(success, failure, padGenerationCallback, service);
	}

	private void sendCredentials(final Callback1<String> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback, String service)
	{
		if (!configured)
			Global.alert("Remote Identity not configured.");
		if (usernameWithSalt == null || passwordWithSalt == null || secretWithSalt == null)
		{
			Global.alert("Please log in before performing this operation.");
			return;
		}

		Array<EbacCredential> credentials = new Array<EbacCredential>();
		Array<EbacContact> contacts = new Array<EbacContact>();
		if (pad == null && padGenerationCallback != null)
			pad = padGenerationCallback.callback();

		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			EcIdentity id = EcIdentityManager.ids.$get(i);
			if (id.source != null && id.source.equals(server) == false) 
				continue;
			id.source = server;
			credentials.push(id.toCredential(secretWithSalt));
		}
		for (int i = 0; i < EcIdentityManager.contacts.$length(); i++)
		{
			EcContact id = EcIdentityManager.contacts.$get(i);
			if (id.source != null && id.source.equals(server) == false) 
				continue;
			id.source = server;
			contacts.push(id.toEncryptedContact(secretWithSalt));
		}

		EbacCredentialCommit commit = new EbacCredentialCommit();

		commit.username = usernameWithSalt;
		commit.password = passwordWithSalt;
		commit.token = token;
		commit.credentials.pad = pad;
		commit.credentials.credentials = credentials;
		commit.credentials.contacts = contacts;

		FormData fd = new FormData();
		fd.append("credentialCommit", commit.toJson());
		fd.append("signatureSheet",EcIdentityManager.signatureSheet(60000, server));

		EcRemote.postExpectingString(server, service, fd, new Callback1<String>()
		{
			@Override
			public void $invoke(String arg0)
			{
				success.$invoke(arg0);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String arg0)
			{
				failure.$invoke(arg0);
			}
		});
	}

	/**
	 * Splices together passwords (in a fashion more like shuffling a deck of
	 * cards, not appending).
	 * 
	 * @param passwords
	 *            Passwords to splice.
	 * @return Spliced password.
	 */
	public String splicePasswords(Array<String> passwords)
	{
		String passwordSplice = "";
		for (int charIndex = 0; charIndex > 0; charIndex++)
		{
			boolean foundAny = false;
			for (int passwordIndex = 0; passwordIndex < passwords.$length(); passwordIndex++)
			{
				if (charIndex >= passwords.$get(passwordIndex).length())
					continue;
				passwordSplice += passwords.$get(passwordIndex).charAt(charIndex);
				foundAny = true;
			}
			if (!foundAny)
				break;
		}
		return passwordSplice;
	}

	public void fetchServerAdminKeys(Callback1<Array<String>> success, Callback1<String> failure){
		EcRemote.getExpectingObject(server, "sky/admin", new Callback1<Object>(){
			@Override
			public void $invoke(Object p1) {
				success.$invoke((Array<String>) p1); 
			}
		}, new Callback1<String>(){
			@Override
			public void $invoke(String p1) {
				failure.$invoke("");
			}
		});
	}
}
