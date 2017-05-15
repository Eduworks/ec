package org.cassproject.ebac.identity.remote;

import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.blob.BlobHelper;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cassproject.ebac.identity.EcContact;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.dom.File;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Function0;

/**
 * Created by fray on 5/9/17.
 */
public class OAuth2FileBasedRemoteIdentityManager implements RemoteIdentityManagerInterface {

	public static boolean oauthEnabled = false;
	public String server = null;
	public Object configuration = null;
	public Object oauthLoginResponse = null;
	public String network = null;

	public OAuth2FileBasedRemoteIdentityManager() {
		final OAuth2FileBasedRemoteIdentityManager me = this;
		EcRemote.getExpectingObject("/", "hello.json", new Callback1<Object>() {
			@Override
			public void $invoke(Object o) {
				try {
					me.configuration = o;
					hello.init(o).then(new Callback1<Object>() {
						@Override
						public void $invoke(Object o) {
							me.oauthEnabled = true;
						}
					});
				} catch (Exception ex) {
					me.oauthEnabled = false;
				}
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String s) {
				me.oauthEnabled = false;
			}
		});
		//JSObjectAdapter.$put(initObject,"google","1076634271317-lsr7f2nhvov5b7j09kk8ajbdg2dlu790.apps.googleusercontent.com");
	}

	@Override
	public void configure(String usernameSalt, int usernameIterations, int usernameWidth, String passwordSalt, int passwordIterations, int passwordWidth, String secretSalt, int secretIterations) {

	}

	@Override
	public void configureFromServer(Callback1<Object> success, Callback1<String> failure) {
		success.$invoke(null);
	}

	@Override
	public void clear() {
		oauthEnabled = false;
		if (server != null)
			hello.logout(server, null);
	}

	@Override
	public void setDefaultIdentityManagementServer(String server) {
		this.server = server;
	}

	@Override
	public void startLogin(String username, String password) {
	}

	@Override
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		return false;
	}

	@Override
	public void fetch(final Callback1<Object> success, final Callback1<String> failure) {
		Object o = new Object();
		JSObjectAdapter.$put(o, "scope", JSObjectAdapter.$get(configuration, server + "Scope"));
		final OAuth2FileBasedRemoteIdentityManager me = this;
		hello.login(server, o).then(new Callback1<Object>() {
			@Override
			public void $invoke(Object o) {
				me.oauthLoginResponse = o;
				me.network = (String) JSObjectAdapter.$get(me.oauthLoginResponse, "network");
				hello.api(me.network, "me/folders", "get", new Object()).then(new Callback1<Object>() {
					@Override
					public void $invoke(Object folderResponse) {
						Array<Object> folders = (Array<Object>) JSObjectAdapter.$get(folderResponse, "data");
						boolean foundIdentities = false;
						boolean foundContacts = false;
						for (int i = 0; i < folders.$length(); i++) {
							Object d = folders.$get(i);
							String name = (String) JSObjectAdapter.$get(d, "name");
							String id = (String) JSObjectAdapter.$get(d, "id");
							if (name == "CASS Identities") {
								foundIdentities = true;
								me.hookIdentityManagerIdentities(id);
								me.readIdentityFiles(id, success, failure);
							}
							if (name == "CASS Contacts") {
								foundContacts = true;
								me.hookIdentityManagerContacts(id);
								me.readContactFiles(id, success, failure);
							}
						}
						if (!foundIdentities) {
							me.createIdentityFolder(success);
						}
						if (!foundContacts) {
							me.createContactFolder();
						}
					}
				}).fail(failure);
			}
		}).fail(failure);
	}

	private void createContactFolder() {
		final OAuth2FileBasedRemoteIdentityManager me = this;
		Object o = new Object();
		JSObjectAdapter.$put(o, "name", "CASS Contacts");
		hello.api(me.network, "me/folders", "post", o).then(new Callback1<Object>() {
			@Override
			public void $invoke(Object r) {
				me.hookIdentityManagerContacts((String) JSObjectAdapter.$get(r, "id"));
			}
		});
	}

	private void createIdentityFolder(final Callback1<Object> success) {
		final OAuth2FileBasedRemoteIdentityManager me = this;
		Object o = new Object();
		JSObjectAdapter.$put(o, "name", "CASS Identities");
		hello.api(me.network, "me/folders", "post", o).then(new Callback1<Object>() {
			@Override
			public void $invoke(Object r) {
				me.hookIdentityManagerIdentities((String) JSObjectAdapter.$get(r, "id"));
				success.$invoke(r);
			}
		});
	}

	private void writeIdentityFiles(final String folderId, final Callback1<Object> success) {
		final OAuth2FileBasedRemoteIdentityManager me = this;
		EcAsyncHelper<EcIdentity> helper = new EcAsyncHelper<>();
		helper.each(EcIdentityManager.ids, new Callback2<EcIdentity, Callback0>() {
			@Override
			public void $invoke(EcIdentity identity, Callback0 callback0) {
				me.writeIdentityFile(folderId, identity, callback0);
			}
		}, new Callback1<Array<EcIdentity>>() {
			@Override
			public void $invoke(Array<EcIdentity> strings) {
				success.$invoke(strings);
			}
		});
	}

	private void writeIdentityFile(String folderId, final EcIdentity identity, final Callback0 finished) {
		File file = BlobHelper.stringToFile(identity.ppk.toPem(), identity.displayName + ".pem", "text/plain");
		Object o = new Object();
		JSObjectAdapter.$put(o, "parent", folderId);
		JSObjectAdapter.$put(o, "id", JSObjectAdapter.$get(identity, "id"));
		JSObjectAdapter.$put(o, "name", file.name);
		Array<File> files = new Array<>();
		files.push(file);
		JSObjectAdapter.$put(o, "file", files);

		hello.api(network, "me/files", JSObjectAdapter.$get(identity, "id") == null ? "post" : "put", o).then(new Callback1<Object>() {
			@Override
			public void $invoke(Object r) {
				JSObjectAdapter.$put(identity, "id", JSObjectAdapter.$get(r, "id"));
				if (finished != null)
					finished.$invoke();
			}
		});
	}

	private void writeContactFiles(String folderId) {
		for (int i = 0; i < EcIdentityManager.contacts.$length(); i++) {
			writeContactFile(folderId, EcIdentityManager.contacts.$get(i));
		}
	}

	private void writeContactFile(String folderId, final EcContact contact) {
		File file = BlobHelper.stringToFile(contact.pk.toPem(), contact.displayName + ".pem", "text/plain");
		Object o = new Object();
		JSObjectAdapter.$put(o, "parent", folderId);
		JSObjectAdapter.$put(o, "id", JSObjectAdapter.$get(contact, "id"));
		JSObjectAdapter.$put(o, "name", file.name);
		Array<File> files = new Array<>();
		files.push(file);
		JSObjectAdapter.$put(o, "file", files);

		hello.api(network, "me/files", JSObjectAdapter.$get(contact, "id") == null ? "post" : "put", o).then(new Callback1<Object>() {
			@Override
			public void $invoke(Object r) {
				JSObjectAdapter.$put(contact, "id", JSObjectAdapter.$get(r, "id"));
			}
		});
	}

	private void readIdentityFiles(String folderId, final Callback1<Object> success, final Callback1<String> failure) {
		final Object o = new Object();
		JSObjectAdapter.$put(o, "id", folderId);
		hello.api(network, "me/folder", "get", o).then(
				new Callback1<Object>() {
					public void $invoke(Object folderResponse) {
						Array<Object> files = (Array<Object>) JSObjectAdapter.$get(folderResponse, "data");
						EcAsyncHelper<Object> h = new EcAsyncHelper();
						h.each(files, new Callback2<Object, Callback0>() {
							@Override
							public void $invoke(Object d, final Callback0 callback0) {
								final String name = ((String) JSObjectAdapter.$get(d, "name")).replace("\\.pem", "");
								final String id = (String) JSObjectAdapter.$get(d, "id");
								String directLink = (String) JSObjectAdapter.$get(d, "downloadUrl");
								EcRemote.getExpectingString(directLink, "", new Callback1<String>() {
									@Override
									public void $invoke(String s) {
										EcIdentity identity = new EcIdentity();
										identity.displayName = name.replace(".pem", "");
										identity.ppk = EcPpk.fromPem(s);
										identity.source = "google";
										JSObjectAdapter.$put(identity, "id", id);
										EcIdentityManager.addIdentityQuietly(identity);
										callback0.$invoke();
									}
								}, failure);
							}
						}, new Callback1<Array<Object>>() {
							@Override
							public void $invoke(Array<Object> strings) {
								success.$invoke(null);
							}
						});
					}
				}
		);
	}

	private void readContactFiles(String folderId, final Callback1<Object> success, final Callback1<String> failure) {
		final Object o = new Object();
		JSObjectAdapter.$put(o, "id", folderId);
		hello.api(network, "me/folder", "get", o).then(
				new Callback1<Object>() {
					public void $invoke(Object folderResponse) {
						Array<Object> files = (Array<Object>) JSObjectAdapter.$get(folderResponse, "data");
						EcAsyncHelper<Object> h = new EcAsyncHelper();
						h.each(files, new Callback2<Object, Callback0>() {
							@Override
							public void $invoke(Object d, final Callback0 callback0) {
								final String name = ((String) JSObjectAdapter.$get(d, "name")).replace("\\.pem", "");
								final String id = (String) JSObjectAdapter.$get(d, "id");
								String directLink = (String) JSObjectAdapter.$get(d, "downloadUrl");
								EcRemote.getExpectingString(directLink, "", new Callback1<String>() {
									@Override
									public void $invoke(String s) {
										EcContact contact = new EcContact();
										contact.displayName = name.replace(".pem", "");
										contact.pk = EcPk.fromPem(s);
										contact.source = "google";
										JSObjectAdapter.$put(contact, "id", id);
										EcIdentityManager.addContactQuietly(contact);
										callback0.$invoke();
									}
								}, failure);
							}
						}, new Callback1<Array<Object>>() {
							@Override
							public void $invoke(Array<Object> strings) {
								success.$invoke(null);
							}
						});
					}
				}
		);
	}

	private void hookIdentityManagerIdentities(final String folderId) {
		final OAuth2FileBasedRemoteIdentityManager me = this;
		EcIdentityManager.onIdentityChanged = new Callback1<EcIdentity>() {
			@Override
			public void $invoke(final EcIdentity identity) {
				me.writeIdentityFile(folderId, identity, null);
			}
		};
	}

	private void hookIdentityManagerContacts(final String folderId) {
		final OAuth2FileBasedRemoteIdentityManager me = this;
		EcIdentityManager.onContactChanged = new Callback1<EcContact>() {
			@Override
			public void $invoke(final EcContact contact) {
				me.writeContactFile(folderId, contact);
			}
		};
	}

	@Override
	public void commit(final Callback1<String> success, final Callback1<String> failure, Function0<String> padGenerationCallback) {
		final OAuth2FileBasedRemoteIdentityManager me = this;
		if (hello.getAuthReponse(server))
			hello.api(me.network, "me/folders", "get", new Object()).then(new Callback1<Object>() {
				@Override
				public void $invoke(Object folderResponse) {
					Array<Object> folders = (Array<Object>) JSObjectAdapter.$get(folderResponse, "data");
					for (int i = 0; i < folders.$length(); i++) {
						Object d = folders.$get(i);
						String name = (String) JSObjectAdapter.$get(d, "name");
						String id = (String) JSObjectAdapter.$get(d, "id");
						if (name == "CASS Identities") {
							me.writeIdentityFiles(id, (Callback1<Object>) (Object) success);
						}
						if (name == "CASS Contacts") {
							me.writeContactFiles(id);
						}
					}
				}
			}).fail(failure);
		else
			failure.$invoke("Please login again.");
	}

	@Override
	public void create(final Callback1<String> success, final Callback1<String> failure, Function0<String> padGenerationCallback) {
		Object o = new Object();
		JSObjectAdapter.$put(o, "scope", JSObjectAdapter.$get(configuration, server + "Scope"));
		final OAuth2FileBasedRemoteIdentityManager me = this;
		hello.login(server, o).then(new Callback1<Object>() {
			@Override
			public void $invoke(Object o) {
				me.oauthLoginResponse = o;
				me.network = (String) JSObjectAdapter.$get(me.oauthLoginResponse, "network");
				hello.api(me.network, "me/folders", "get", new Object()).then(new Callback1<Object>() {
					@Override
					public void $invoke(Object folderResponse) {
						Array<Object> folders = (Array<Object>) JSObjectAdapter.$get(folderResponse, "data");
						boolean foundIdentities = false;
						boolean foundContacts = false;
						for (int i = 0; i < folders.$length(); i++) {
							Object d = folders.$get(i);
							String name = (String) JSObjectAdapter.$get(d, "name");
							String id = (String) JSObjectAdapter.$get(d, "id");
							if (name == "CASS Identities") {
								foundIdentities = true;
								me.hookIdentityManagerIdentities(id);
								me.readIdentityFiles(id, (Callback1<Object>) (Object) success, failure);
							}
							if (name == "CASS Contacts") {
								foundContacts = true;
								me.hookIdentityManagerContacts(id);
								me.readContactFiles(id, (Callback1<Object>) (Object) success, failure);
							}
						}
						if (!foundIdentities) {
							me.createIdentityFolder((Callback1<Object>) (Object) success);
						}
						if (!foundContacts) {
							me.createContactFolder();
						}
					}
				}).fail(failure);
			}
		}).fail(failure);
	}

	@Override
	public void fetchServerAdminKeys(Callback1<Array<String>> success, Callback1<String> failure) {
		success.$invoke(null);
	}
}
