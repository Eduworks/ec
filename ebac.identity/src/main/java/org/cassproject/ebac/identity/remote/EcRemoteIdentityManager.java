package org.cassproject.ebac.identity.remote;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.schema.ebac.*;
import forge.pkcs5;
import forge.util;
import org.cassproject.ebac.identity.EcContact;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

/**
 * Logs into and stores/retrieves credentials from a compatible remote server.
 * Performs anonymization of the user.
 * <p>
 * Requires initialization with server specific salts. Server specific salts
 * prevent co-occurrence attacks, should credentials on one server be
 * compromised (intercepted in transit).
 * <p>
 * Transmits hashed username, hashed password, and encrypts credentials using
 * the hashed combination of the username and password. This prevents the system
 * storing the credentials from having any knowledge of the user.
 * <p>
 * Password recovery is done by, when the password changes, creating a
 * cryptographic pad (or perfect cipher) where one half is stored on the server,
 * and the other half is stored with the user. Should the user lose this pad and
 * forget their password, they are not able to recover or reset their password,
 * and their data should be considered lost.
 *
 * @author fritz.ray@eduworks.com
 * @module com.eduworks.ec
 * @class EcRemoteIdentityManager
 */
public class EcRemoteIdentityManager implements RemoteIdentityManagerInterface {
	public String server = null;
	public Boolean global = null;
	protected String usernameWithSalt = null;
	protected String passwordWithSalt = null;
	protected String secretWithSalt = null;
	protected String pad = null;
	protected String token = null;
	private String usernameSalt = null;
	private int usernameIterations;
	private int usernameWidth;
	private String passwordSalt = null;
	private int passwordIterations;
	private int passwordWidth;
	private String secretSalt = null;
	private int secretIterations;
	private boolean configured = false;

	/**
	 * Returns true if the identity manager is global. Returns false if the identity manager is local to the server.
	 *
	 * @return {Boolean} true if the identity manager is global.
	 * @memberOf EcRemoteIdentityManager
	 */
	public Boolean isGlobal() {
		if (global == null)
			return false;
		return global;
	}

	/**
	 * Configure parameters of the remote login storage.
	 *
	 * @param {String} usernameSalt
	 *                 Salt used in hashing the username.
	 * @param {int}    usernameIterations
	 *                 Number of times to hash the username.
	 * @param {int}    usernameWidth
	 *                 Resultant width of username in bytes.
	 * @param {String} passwordSalt
	 *                 Salt used to hash password.
	 * @param {int}    passwordIterations
	 *                 Number of times to hash password.
	 * @param {int}    passwordWidth
	 *                 Resultant width of password in bytes.
	 * @param {String} secretSalt
	 *                 Salt used to hash secret (composed of username + password)
	 * @param {int}    secretIterations
	 *                 Number of times to hash secret.
	 * @memberOf EcRemoteIdentityManager
	 * @method configure
	 */
	@Override
	public void configure(String usernameSalt, int usernameIterations, int usernameWidth, String passwordSalt, int passwordIterations, int passwordWidth,
	                      String secretSalt, int secretIterations) {
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
	 * Configures parameters of the remote server by accessing configuration details via webservice
	 *
	 * @param {Callback1<Object>} success
	 *                            Callback triggered after successfully configured
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if an error during failure
	 * @memberOf EcRemoteIdentityManager
	 * @method configureFromServer
	 */
	@Override
	public void configureFromServer(final Callback1<Object> success, final Callback1<String> failure) {
		final EcRemoteIdentityManager me = this;
		EcRemote.getExpectingObject(server, "sky/id/salts", new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				me.usernameSalt = (String) JSObjectAdapter.$get(p1, "usernameSalt");
				if (me.usernameSalt.length() < 16) {
					failure.$invoke("Insufficient length on Username Salt");
					return;
				}
				me.usernameIterations = (int) JSObjectAdapter.$get(p1, "usernameIterations");
				if (me.usernameIterations < 1000) {
					failure.$invoke("Insufficient iterations on Username Hash");
					return;
				}
				me.usernameWidth = (int) JSObjectAdapter.$get(p1, "usernameLength");
				if (me.usernameWidth != 64) {
					failure.$invoke("Username Hash required to be length 64.");
					return;
				}
				me.passwordSalt = (String) JSObjectAdapter.$get(p1, "passwordSalt");
				if (me.passwordSalt.length() < 16) {
					failure.$invoke("Insufficient length on Password Salt");
					return;
				}
				me.passwordIterations = (int) JSObjectAdapter.$get(p1, "passwordIterations");
				if (me.passwordIterations < 1000) {
					failure.$invoke("Insufficient iterations on Password Hash");
					return;
				}
				me.passwordWidth = (int) JSObjectAdapter.$get(p1, "passwordLength");
				if (me.passwordWidth != 64) {
					failure.$invoke("Password Hash required to be length 64.");
					return;
				}
				me.secretSalt = (String) JSObjectAdapter.$get(p1, "secretSalt");
				if (me.secretSalt.length() < 16) {
					failure.$invoke("Insufficient length on Secret Salt");
					return;
				}
				me.secretIterations = (int) JSObjectAdapter.$get(p1, "secretIterations");
				if (me.secretIterations < 1000) {
					failure.$invoke("Insufficient iterations on Secret Hash");
					return;
				}
				me.configured = true;
				if (success != null)
					success.$invoke(p1);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				me.configured = false;
				if (failure != null)
					failure.$invoke(p1);
				else
					Global.console.error(p1);
			}
		});
	}

	/**
	 * Wipes login data.
	 *
	 * @memberOf EcRemoteIdentityManager
	 * @method clear
	 */
	@Override
	public void clear() {
		usernameWithSalt = null;
		passwordWithSalt = null;
		secretWithSalt = null;
		pad = null;
		token = null;
	}

	/**
	 * Configure compatible remote identity management server.
	 *
	 * @param {String} server
	 *                 URL to remote identity management server.
	 * @memberOf EcRemoteIdentityManager
	 * @method setDefaultIdentityManagementServer
	 */
	@Override
	public void setDefaultIdentityManagementServer(String server) {
		this.server = server;
	}

	/**
	 * "Log Into" system, generating credentials. Does not actually remotely
	 * access any machine.
	 * <p>
	 * Please clear username and password fields after this function is called.
	 *
	 * @param {String} username
	 *                 Username to login with
	 * @param {String} password
	 *                 Password to authenticate username with
	 * @memberOf EcRemoteIdentityManager
	 * @method startLogin
	 */
	@Override
	public void startLogin(String username, String password) {
		if (!configured) {
			Global.alert("Remote Identity not configured.");
			return;
		}

		usernameWithSalt = util.encode64(pkcs5.pbkdf2(username, usernameSalt, usernameIterations, usernameWidth));
		passwordWithSalt = util.encode64(pkcs5.pbkdf2(password, passwordSalt, passwordIterations, passwordWidth));

		Array<String> arys = new Array<String>();
		arys.push(username, password);
		String secret = splicePasswords(arys);
		secretWithSalt = util.encode64(pkcs5.pbkdf2(secret, secretSalt, secretIterations, 32));
	}

	/**
	 * Change password of user in memory. Does not automatically commit new credentials.
	 * <p>
	 * Please clear username and password fields after this function is called.
	 *
	 * @param {String} username
	 *                 Username
	 * @param {String} oldPassword
	 *                 Current password
	 * @param {String} newPassword
	 *                 Desired password
	 * @return {boolean}
	 * Valid password change request.
	 * @memberOf EcRemoteIdentityManager
	 * @method changePassword
	 */
	@Override
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		String usernameHash = util.encode64(pkcs5.pbkdf2(username, usernameSalt, usernameIterations, usernameWidth));
		if (usernameWithSalt != usernameHash) {
			Global.alert("Username does not match. Aborting password change.");
			return false;
		}

		String oldPasswordHash = util.encode64(pkcs5.pbkdf2(oldPassword, passwordSalt, passwordIterations, passwordWidth));
		if (passwordWithSalt != oldPasswordHash) {
			Global.alert("Old password does not match. Aborting password change.");
			return false;
		}

		passwordWithSalt = util.encode64(pkcs5.pbkdf2(newPassword, passwordSalt, passwordIterations, passwordWidth));

		Array<String> arys = new Array<String>();
		arys.push(username, newPassword);
		String secret = splicePasswords(arys);
		secretWithSalt = util.encode64(pkcs5.pbkdf2(secret, secretSalt, secretIterations, 32));
		return true;
	}

	/**
	 * Fetch credentials from server, invoking events based on login success or
	 * failure.
	 * <p>
	 * Automatically populates EcIdentityManager.
	 * <p>
	 * Requires login().
	 *
	 * @param {Callback1<Object>} success
	 * @param {Callback1<String>} failure
	 * @memberOf EcRemoteIdentityManager
	 * @method fetch
	 */
	@Override
	public void fetch(final Callback1<Object> success, final Callback1<String> failure) {
		if (!configured) {
			failure.$invoke("Remote Identity not configured.");
			return;
		}
		if (usernameWithSalt == null || passwordWithSalt == null || secretWithSalt == null) {
			failure.$invoke("Please log in before performing this operation.");
			return;
		}

		EbacCredentialRequest r = new EbacCredentialRequest();
		r.username = usernameWithSalt;
		r.password = passwordWithSalt;

		FormData fd = new FormData();
		fd.append("credentialRequest", r.toJson());
		final EcRemoteIdentityManager me = this;
		EcRemote.postExpectingObject(server, "sky/id/login", fd, new Callback1<Object>() {
			@Override
			public void $invoke(Object arg0) {
				EbacCredentials cs = (EbacCredentials) arg0;
				me.pad = cs.pad;
				me.token = cs.token;
				if (cs.credentials != null)
					for (int i = 0; i < cs.credentials.$length(); i++) {
						EbacCredential c = cs.credentials.$get(i);
						EcIdentity identity = EcIdentity.fromCredential(c, me.secretWithSalt, me.server);
						EcIdentityManager.addIdentity(identity);
					}
				if (cs.contacts != null)
					for (int i = 0; i < cs.contacts.$length(); i++) {
						EbacContact c = cs.contacts.$get(i);
						EcContact identity = EcContact.fromEncryptedContact(c, me.secretWithSalt, me.server);
						EcIdentityManager.addContact(identity);
					}

				success.$invoke(arg0);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String arg0) {
				failure.$invoke(arg0);
			}
		});
	}

	/**
	 * Commits credentials in EcIdentityManager to remote server.
	 * <p>
	 * Will trigger pad generation and fail if the pad has not been specified.
	 *
	 * @param {Callback1<String>}   success
	 * @param {Callback1<String>}   failure
	 * @param padGenerationCallback
	 * @memberOf EcRemoteIdentityManager
	 * @method commit
	 */
	@Override
	public void commit(final Callback1<String> success, final Callback1<String> failure, Function0<String> padGenerationCallback) {
		String service = "sky/id/commit";
		sendCredentials(success, failure, padGenerationCallback, service);
	}

	/**
	 * Creates an account.
	 * <p>
	 * Please note that the remote login server does not throw error messages if
	 * an account creation is blocked due to being a duplicate. This prevents
	 * login probing. This will always succeed (if the request is properly
	 * formed and makes it to the server).
	 * <p>
	 * Will trigger pad generation and fail if the pad has not been specified.
	 *
	 * @param {Callback1<String>}   success
	 *                              Callback triggered after successfully creating an account
	 * @param {Callback1<String>}   failure
	 *                              Callback triggered if error creating an account
	 * @param padGenerationCallback Callback triggered if pad not specified
	 * @memberOf EcRemoteIdentityManager
	 * @method create
	 */
	@Override
	public void create(final Callback1<String> success, final Callback1<String> failure, Function0<String> padGenerationCallback) {
		String service = "sky/id/create";
		sendCredentials(success, failure, padGenerationCallback, service);
	}

	/**
	 * Sends the identity managers credentials to the service specified
	 *
	 * @param {Callback1<String>}   success
	 *                              Callback triggered if credentials sent successfully
	 * @param {Callback1<String>}   failure
	 *                              Callback triggered if error sending credentials
	 * @param padGenerationCallback Callback triggered if pad needed
	 * @param service               Service to send credentials to on server
	 * @memberOf EcRemoteIdentityManager
	 * @method sendCredentials
	 */
	private void sendCredentials(final Callback1<String> success, final Callback1<String> failure, Function0<String> padGenerationCallback,
	                             final String service) {
		if (!configured)
			Global.alert("Remote Identity not configured.");
		if (usernameWithSalt == null || passwordWithSalt == null || secretWithSalt == null) {
			Global.alert("Please log in before performing this operation.");
			return;
		}

		Array<EbacCredential> credentials = new Array<EbacCredential>();
		Array<EbacContact> contacts = new Array<EbacContact>();
		if (pad == null && padGenerationCallback != null)
			pad = padGenerationCallback.$invoke();

		for (int i = 0; i < EcIdentityManager.ids.$length(); i++) {
			EcIdentity id = EcIdentityManager.ids.$get(i);
			if (id.source != null && id.source != server)
				continue;
			id.source = server;
			credentials.push(id.toCredential(secretWithSalt));
		}
		for (int i = 0; i < EcIdentityManager.contacts.$length(); i++) {
			EcContact id = EcIdentityManager.contacts.$get(i);
			if (id.source != null && id.source != server)
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

		final FormData fd = new FormData();
		fd.append("credentialCommit", commit.toJson());
		final EcRemoteIdentityManager me = this;
		EcIdentityManager.signatureSheetAsync(60000, server, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				fd.append("signatureSheet", p1);
				EcRemote.postExpectingString(me.server, service, fd, new Callback1<String>() {
					@Override
					public void $invoke(String arg0) {
						success.$invoke(arg0);
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String arg0) {
						failure.$invoke(arg0);
					}
				});
			}
		},failure);

	}

	/**
	 * Splices together passwords (in a fashion more like shuffling a deck of
	 * cards, not appending).
	 *
	 * @param {String[]} passwords
	 *                   Passwords to splice.
	 * @return {String}
	 * Spliced password.
	 * @memberOf EcRemoteIdentityManager
	 * @method splicePasswords
	 */
	public String splicePasswords(Array<String> passwords) {
		String passwordSplice = "";
		for (int charIndex = 0; charIndex > 0; charIndex++) {
			boolean foundAny = false;
			for (int passwordIndex = 0; passwordIndex < passwords.$length(); passwordIndex++) {
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
}
