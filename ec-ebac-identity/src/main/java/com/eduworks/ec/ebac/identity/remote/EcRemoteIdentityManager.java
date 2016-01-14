package com.eduworks.ec.ebac.identity.remote;

import static org.stjs.javascript.Global.alert;

import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallbackReturn0;
import com.eduworks.ec.ebac.identity.EcIdentity;
import com.eduworks.ec.ebac.identity.EcIdentityManager;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

import forge.pkcs5;
import forge.util;

public class EcRemoteIdentityManager
{
	private static String usernameSalt = null;
	private static int usernameIterations;
	private static int usernameWidth;
	private static String passwordSalt = null;
	private static int passwordIterations;
	private static int passwordWidth;
	private static String secretSalt = null;
	private static int secretIterations;
	private static int secretWidth;
	private static boolean configured = false;

	protected static String selectedServer = null;
	protected static String usernameWithSalt = null;
	protected static String passwordWithSalt = null;
	protected static String secretWithSalt = null;
	protected static String pad = null;
	protected static String token = null;

	public static void configure(String usernameSalt, int usernameIterations, int usernameWidth, String passwordSalt, int passwordIterations,
			int passwordWidth, String secretSalt, int secretIterations, int secretWidth)
	{
		EcRemoteIdentityManager.usernameSalt = usernameSalt;
		EcRemoteIdentityManager.usernameIterations = usernameIterations;
		EcRemoteIdentityManager.usernameWidth = usernameWidth;
		EcRemoteIdentityManager.passwordSalt = passwordSalt;
		EcRemoteIdentityManager.passwordIterations = passwordIterations;
		EcRemoteIdentityManager.passwordWidth = passwordWidth;
		EcRemoteIdentityManager.secretSalt = secretSalt;
		EcRemoteIdentityManager.secretIterations = secretIterations;
		EcRemoteIdentityManager.secretWidth = secretWidth;
	}

	public static void setIdentityManagementServer(String server)
	{
		EcRemoteIdentityManager.selectedServer = server;
	}

	public static void login(String username, String password)
	{
		if (!configured)
			alert("Remote Identity not configured.");

		usernameWithSalt = util.encode64(pkcs5.pbkdf2(username, usernameSalt, usernameIterations, usernameWidth));
		passwordWithSalt = util.encode64(pkcs5.pbkdf2(password, passwordSalt, passwordIterations, passwordWidth));

		Array<String> arys = new Array<String>();
		arys.push(username, password);
		String secret = splicePasswords(arys);
		secretWithSalt = util.encode64(pkcs5.pbkdf2(secret, secretSalt, secretIterations, secretWidth));
	}

	public static void fetch(final Callback1<Object> success, final Callback1<String> failure)
	{
		if (!configured)
			alert("Remote Identity not configured.");
		if (usernameWithSalt == null || passwordWithSalt == null || secretWithSalt == null)
		{
			alert("Please log in before performing this operation.");
			return;
		}

		EbacCredentialRequest r = new EbacCredentialRequest();
		r.username = usernameWithSalt;
		r.password = passwordWithSalt;

		FormData fd = new FormData();
		fd.append("credentialRequest", r.toJson());
		EcRemote.postExpectingObject(selectedServer, "sky/id/login", fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object arg0)
			{
				EbacCredentials cs = (EbacCredentials) arg0;
				pad = cs.pad;
				token = cs.token;
				for (int i = 0; i < cs.credentials.$length(); i++)
				{
					EbacCredential c = cs.credentials.$get(i);
					EcIdentity identity = c.toIdentity(secretWithSalt, selectedServer);
					EcIdentityManager.add(identity);
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

	public static void commit(final Callback1<Object> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback)
	{
		String service = "sky/id/commit";
		sendCredentials(success, failure, padGenerationCallback, service);
	}

	public static void create(final Callback1<Object> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback)
	{
		String service = "sky/id/create";
		sendCredentials(success, failure, padGenerationCallback, service);
	}

	private static void sendCredentials(final Callback1<Object> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback,
			String service)
	{
		if (!configured)
			alert("Remote Identity not configured.");
		if (usernameWithSalt == null || passwordWithSalt == null || secretWithSalt == null)
		{
			alert("Please log in before performing this operation.");
			return;
		}

		Array<EbacCredential> credentials = new Array<EbacCredential>();
		if (pad == null)
			pad = padGenerationCallback.callback();

		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			EcIdentity id = EcIdentityManager.ids.$get(i);
			credentials.push(id.toCredential(secretWithSalt));
		}

		EbacCredentialCommit commit = new EbacCredentialCommit();

		commit.username = usernameWithSalt;
		commit.password = passwordWithSalt;
		commit.token = token;
		commit.credentials = credentials;

		FormData fd = new FormData();
		fd.append("credentialCommit", commit.toJson());
		EcRemote.postExpectingObject(selectedServer, service, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object arg0)
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

	public static String splicePasswords(Array<String> passwords)
	{
		String passwordSplice = "";
		for (int charIndex = 0;charIndex > 0; charIndex++)
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
}
