package org.cassproject.ebac.identity.remote;

import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallbackReturn0;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.schema.ebac.EbacCredential;
import com.eduworks.schema.ebac.EbacCredentialCommit;
import com.eduworks.schema.ebac.EbacCredentialRequest;
import com.eduworks.schema.ebac.EbacCredentials;

import forge.pkcs5;
import forge.util;

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
	private int secretWidth;
	private boolean configured = false;

	protected String selectedServer = null;
	protected String usernameWithSalt = null;
	protected String passwordWithSalt = null;
	protected String secretWithSalt = null;
	protected String pad = null;
	protected String token = null;

	public void configure(String usernameSalt, int usernameIterations, int usernameWidth, String passwordSalt, int passwordIterations, int passwordWidth,
			String secretSalt, int secretIterations, int secretWidth)
	{
		this.usernameSalt = usernameSalt;
		this.usernameIterations = usernameIterations;
		this.usernameWidth = usernameWidth;
		this.passwordSalt = passwordSalt;
		this.passwordIterations = passwordIterations;
		this.passwordWidth = passwordWidth;
		this.secretSalt = secretSalt;
		this.secretIterations = secretIterations;
		this.secretWidth = secretWidth;
	}

	public void clearCredentials()
	{
		selectedServer = null;
		usernameWithSalt = null;
		passwordWithSalt = null;
		secretWithSalt = null;
		pad = null;
		token = null;
	}
	
	public void setIdentityManagementServer(String server)
	{
		selectedServer = server;
	}

	public void login(String username, String password)
	{
		if (!configured)
			Global.alert("Remote Identity not configured.");

		usernameWithSalt = util.encode64(pkcs5.pbkdf2(username, usernameSalt, usernameIterations, usernameWidth));
		passwordWithSalt = util.encode64(pkcs5.pbkdf2(password, passwordSalt, passwordIterations, passwordWidth));

		Array<String> arys = new Array<String>();
		arys.push(username, password);
		String secret = splicePasswords(arys);
		secretWithSalt = util.encode64(pkcs5.pbkdf2(secret, secretSalt, secretIterations, secretWidth));
	}

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
		EcRemote.postExpectingObject(selectedServer, "sky/id/login", fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object arg0)
			{
				EbacCredentials cs = (EbacCredentials) arg0;
				me.pad = cs.pad;
				me.token = cs.token;
				for (int i = 0; i < cs.credentials.$length(); i++)
				{
					EbacCredential c = cs.credentials.$get(i);
					EcIdentity identity = EcIdentity.fromCredential(c,me.secretWithSalt, me.selectedServer);
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

	public void commit(final Callback1<Object> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback)
	{
		String service = "sky/id/commit";
		sendCredentials(success, failure, padGenerationCallback, service);
	}

	public void create(final Callback1<Object> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback)
	{
		String service = "sky/id/create";
		sendCredentials(success, failure, padGenerationCallback, service);
	}

	private void sendCredentials(final Callback1<Object> success, final Callback1<String> failure, EcCallbackReturn0 padGenerationCallback, String service)
	{
		if (!configured)
			Global.alert("Remote Identity not configured.");
		if (usernameWithSalt == null || passwordWithSalt == null || secretWithSalt == null)
		{
			Global.alert("Please log in before performing this operation.");
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

}
