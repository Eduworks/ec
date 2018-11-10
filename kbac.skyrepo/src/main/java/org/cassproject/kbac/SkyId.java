package org.cassproject.kbac;

import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.schema.ebac.EbacSignature;
import forge.pkcs5;
import forge.util;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSFunctionAdapter;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.functions.Function0;

@GlobalScope
public class SkyId {
	private static String usernameSalt = null;
	private static String passwordSalt = null;
	private static String secretSalt = null;
	public static String skyIdSalt = null;
	public static String skyIdSecretStr = null;
	public static String skyIdSecret(){return skyIdSecretStr;};
	public static String skyIdSecretKey = null;
	private static EcPpk skyIdPem = null;

	private static Object cachedSalts = new Object();

	public static Function0<String> salts = new Function0<String>() {
		@Override
		public String $invoke() {
			return Global.JSON.stringify(cachedSalts);
		}
	};

	public static Function0<String> skyIdCreate = new Function0<String>() {
		@Override
		public String $invoke() {
			String id = null;
			String password = null;
			String credentials = null;
			Object searchParams = Global.JSON.parse(levr.fileToString(JSFunctionAdapter.call(levr.fileFromDatastream, this, "credentialCommit", null)));
			if (searchParams != null) {
				if (JSObjectAdapter.$get(searchParams, "username") != null)
					id = (String) JSObjectAdapter.$get(searchParams, "username");
				if (JSObjectAdapter.$get(searchParams, "password") != null)
					password = (String) JSObjectAdapter.$get(searchParams, "password");
				if (JSObjectAdapter.$get(searchParams, "credentials") != null)
					credentials = (String) JSObjectAdapter.$get(searchParams, "credentials");
			}
			if (id == null)
				levr.error("Missing username.", 422);
			if (password == null)
				levr.error("Missing password.", 422);
			Object payload = credentials;

			String saltedPassword = util.encode64(pkcs5.pbkdf2(password, skyIdSalt, 10000, 64));
			JSObjectAdapter.$put(payload, "password", saltedPassword);

			String saltedId = util.encode64(pkcs5.pbkdf2(id, skyIdSalt, 10000, 16));

			Array<EbacSignature> signatureSheet = new Array<EbacSignature>();
			signatureSheet.push(EcIdentityManager.createSignature(60000, null, skyIdPem));
			JSObjectAdapter.$put(this, "signatureSheet", signatureSheet);

			Object get = JSFunctionAdapter.call(SkyRepo.skyrepoGetParsed, this, saltedId,null,"schema.cassproject.org.kbac.0.2.EncryptedValue",null);
			if (get != null)
				get = Global.JSON.parse(EcAesCtr.decrypt((String) JSObjectAdapter.$get(get, "payload"), skyIdSecretKey, saltedId));

			EcEncryptedValue encryptedPayload = new EcEncryptedValue();
			encryptedPayload.addOwner(skyIdPem.toPk());
			encryptedPayload.payload = EcAesCtr.encrypt(Global.JSON.stringify(payload), skyIdSecretKey, saltedId);

			if (get == null)
				JSFunctionAdapter.call(SkyRepo.skyrepoPutParsed, this, Global.JSON.parse(encryptedPayload.toJson()), saltedId, null, "schema.cassproject.org.kbac.0.2.EncryptedValue");
			else
				levr.error("Cannot create, account already exists.", 422);
			return null;
		}
	};

	public static Function0<String> skyIdCommit = new Function0<String>() {
		@Override
		public String $invoke() {
			String id = null;
			String password = null;
			String token = null;
			String credentials = null;
			Object searchParams = Global.JSON.parse(levr.fileToString(JSFunctionAdapter.call(levr.fileFromDatastream, this, "credentialCommit", null)));
			if (searchParams != null) {
				if (JSObjectAdapter.$get(searchParams, "username") != null)
					id = (String) JSObjectAdapter.$get(searchParams, "username");
				if (JSObjectAdapter.$get(searchParams, "password") != null)
					password = (String) JSObjectAdapter.$get(searchParams, "password");
				if (JSObjectAdapter.$get(searchParams, "token") != null)
					token = (String) JSObjectAdapter.$get(searchParams, "token");
				if (JSObjectAdapter.$get(searchParams, "credentials") != null)
					credentials = (String) JSObjectAdapter.$get(searchParams, "credentials");
			}
			if (id == null)
				levr.error("Missing username.", 422);
			if (password == null)
				levr.error("Missing password.", 422);
			if (token == null)
				levr.error("Missing token.", 422);
			Object payload = credentials;
			JSObjectAdapter.$put(payload, "token", token);

			String saltedPassword = util.encode64(pkcs5.pbkdf2(password, skyIdSalt, 10000, 64));
			JSObjectAdapter.$put(payload, "password", saltedPassword);

			String saltedId = util.encode64(pkcs5.pbkdf2(id, skyIdSalt, 10000, 16));

			EcEncryptedValue encryptedPayload = new EcEncryptedValue();
			encryptedPayload.addOwner(skyIdPem.toPk());
			encryptedPayload.payload = EcAesCtr.encrypt(Global.JSON.stringify(payload), skyIdSecretKey, saltedId);

			Array<EbacSignature> signatureSheet = new Array<EbacSignature>();
			signatureSheet.push(EcIdentityManager.createSignature(60000, null, skyIdPem));
			JSObjectAdapter.$put(this, "signatureSheet", signatureSheet);

			Object get = JSFunctionAdapter.call(SkyRepo.skyrepoGetParsed, this, saltedId,null,"schema.cassproject.org.kbac.0.2.EncryptedValue",null);
			if (get == null)
				levr.error("User does not exist.",404);
			get = Global.JSON.parse(EcAesCtr.decrypt((String) JSObjectAdapter.$get(get, "payload"), skyIdSecretKey, saltedId));

			if (JSObjectAdapter.$get(get, "token") != token)
				levr.error("An error in synchronization has occurred. Please re-login and try again.", 403);

			JSFunctionAdapter.call(SkyRepo.skyrepoPutParsed, this, Global.JSON.parse(encryptedPayload.toJson()), saltedId, null, "schema.cassproject.org.kbac.0.2.EncryptedValue");

			return null;
		}
	};

	public static Function0<String> skyIdLogin = new Function0<String>() {
		@Override
		public String $invoke() {
			String id = null;
			String password = null;
			String credentials = null;
			Object searchParams = Global.JSON.parse(levr.fileToString(JSFunctionAdapter.call(levr.fileFromDatastream, this, "credentialRequest", null)));
			if (searchParams != null) {
				if (JSObjectAdapter.$get(searchParams, "username") != null)
					id = (String) JSObjectAdapter.$get(searchParams, "username");
				if (JSObjectAdapter.$get(searchParams, "password") != null)
					password = (String) JSObjectAdapter.$get(searchParams, "password");
				if (JSObjectAdapter.$get(searchParams, "credentials") != null)
					credentials = (String) JSObjectAdapter.$get(searchParams, "credentials");
			}
			if (id == null)
				levr.error("Missing username.", 422);
			if (password == null)
				levr.error("Missing password.", 422);

			String saltedPassword = util.encode64(pkcs5.pbkdf2(password, skyIdSalt, 10000, 64));
			String saltedId = util.encode64(pkcs5.pbkdf2(id, skyIdSalt, 10000, 16));

			Array<EbacSignature> signatureSheet = new Array<EbacSignature>();
			signatureSheet.push(EcIdentityManager.createSignature(60000, null, skyIdPem));
			JSObjectAdapter.$put(this, "signatureSheet", signatureSheet);

			Object get = JSFunctionAdapter.call(SkyRepo.skyrepoGetParsed, this, saltedId,null,"schema.cassproject.org.kbac.0.2.EncryptedValue",null);
			if (get == null)
				levr.error("User does not exist.",404);
			get = Global.JSON.parse(EcAesCtr.decrypt((String) JSObjectAdapter.$get(get, "payload"), skyIdSecretKey, saltedId));
			if (JSObjectAdapter.$get(get,"password") != saltedPassword)
				levr.error("Invalid password.",403);

			JSObjectAdapter.$put(get, "token", levr.randomString(20));

			EcEncryptedValue encryptedPayload = new EcEncryptedValue();
			encryptedPayload.addOwner(skyIdPem.toPk());
			encryptedPayload.payload = EcAesCtr.encrypt(Global.JSON.stringify(get), skyIdSecretKey, saltedId);

			JSFunctionAdapter.call(SkyRepo.skyrepoPutParsed, this, Global.JSON.parse(encryptedPayload.toJson()), saltedId, null, "schema.cassproject.org.kbac.0.2.EncryptedValue");

			JSObjectAdapter.$properties(get).$delete("password");
			return Global.JSON.stringify(get);
		}
	};

	static String loadConfigurationFile(String path,Function0 dflt)
	{
		if (levr.fileExists(path))
			return levr.fileToString(levr.fileLoad(path));
		if (levr.fileExists("etc/"+path))
			return levr.fileToString(levr.fileLoad("etc/"+path));
		levr.fileSave(dflt.$invoke(),"etc/"+path);
		return levr.fileToString(levr.fileLoad("etc/"+path));
	}

	static {
		usernameSalt = loadConfigurationFile("skyId.username.public.salt",new Function0(){
			@Override
			public Object $invoke() {
				return levr.randomString(2048);
			}
		});

		passwordSalt = loadConfigurationFile("skyId.password.public.salt",new Function0(){
			@Override
			public Object $invoke() {
				return levr.randomString(2048);
			}
		});

		secretSalt = loadConfigurationFile("skyId.secret.public.salt",new Function0(){
			@Override
			public Object $invoke() {
				return levr.randomString(2048);
			}
		});

		JSObjectAdapter.$put(cachedSalts, "usernameSalt", usernameSalt);
		JSObjectAdapter.$put(cachedSalts, "usernameIterations", 5000);
		JSObjectAdapter.$put(cachedSalts, "usernameLength", 64);
		JSObjectAdapter.$put(cachedSalts, "passwordSalt", passwordSalt);
		JSObjectAdapter.$put(cachedSalts, "passwordIterations", 5000);
		JSObjectAdapter.$put(cachedSalts, "passwordLength", 64);
		JSObjectAdapter.$put(cachedSalts, "secretSalt", secretSalt);
		JSObjectAdapter.$put(cachedSalts, "secretIterations", 5000);
		JSObjectAdapter.$put(cachedSalts, "secretLength", 64);

		skyIdSalt = loadConfigurationFile("skyId.salt",new Function0(){
			@Override
			public Object $invoke() {
				return levr.randomString(2048);
			}
		});

		skyIdSecretStr = loadConfigurationFile("skyId.secret",new Function0(){
			@Override
			public Object $invoke() {
				return levr.randomString(2048);
			}
		});

		skyIdSecretKey = util.encode64(pkcs5.pbkdf2(skyIdSecretStr,skyIdSalt,10000,16));

		skyIdPem = EcPpk.fromPem(loadConfigurationFile("skyId.pem",new Function0(){
			@Override
			public Object $invoke() {
				return EcPpk.fromPem(levr.rsaGenerate()).toPem();
			}
		}));

		levr.bindWebService("/sky/id/salts", salts);
		levr.bindWebService("/sky/id/create", skyIdCreate);
		levr.bindWebService("/sky/id/commit", skyIdCommit);
		levr.bindWebService("/sky/id/login", skyIdLogin);
	}
}
