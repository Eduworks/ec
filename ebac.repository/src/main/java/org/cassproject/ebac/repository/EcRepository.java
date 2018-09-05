package org.cassproject.ebac.repository;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.crypto.EcCrypto;
import com.eduworks.ec.log.Logger;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.ec.task.Task;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

import static com.eduworks.ec.remote.EcRemote.urlAppend;

/**
 * Repository object used to interact with the CASS Repository web services.
 * Should be used for all CRUD and search operations
 *
 * @author fritz.ray@eduworks.com
 * @module com.eduworks.ec
 * @class EcRepository
 */
public class EcRepository {

	public static boolean caching = false;
	public static boolean cachingSearch = false;
	public static boolean unsigned = false;
	public static boolean alwaysTryUrl = false;
	public static Object cache = new Object();
	public static Object fetching = new Object();
	public static Array<EcRepository> repos = new Array<>();
	public Array<String> adminKeys = null;
	public String selectedServer = null;
	public boolean autoDetectFound = false;

	public EcRepository() {
		repos.push(this);
	}

	/**
	 * Gets a JSON-LD object from the place designated by the URI.
	 * <p>
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 *
	 * @param {String}                               url URL of the remote object.
	 * @param {Callback1<EcRemoteLinkedData>}success Event to call upon
	 *                                               successful retrieval.
	 * @param {Callback1<String>}                    failure Event to call upon spectacular
	 *                                               failure.
	 * @memberOf EcRepository
	 * @method get
	 * @static
	 */
	public static void get(String url, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure) {
		final String originalUrl = url;
		if (EcRemote.async == false) {
			EcRemoteLinkedData result = getBlocking(url);
			if (result == null) {
				if (failure != null)
					failure.$invoke("Could not locate object. May be due to EcRepository.alwaysTryUrl flag.");
			} else if (success != null)
				success.$invoke(result);
			return;
		}
		if (caching) {
			if (JSObjectAdapter.$get(cache, url) != null) {
				if (EcRemote.async) {
					Task.immediate(new Callback0() {
						@Override
						public void $invoke() {
							success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, originalUrl));
						}
					});
				} else {
					success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, url));
				}
				return;
			}
			if (EcRemote.async) {
				if (JSObjectAdapter.$get(fetching, url) != null) {
					if ((Double) JSObjectAdapter.$get(fetching, url) > new Date().getTime()) {
						Global.setTimeout(new Callback0() {
							@Override
							public void $invoke() {
								get(originalUrl, success, failure);
							}
						}, 100);
						return;
					}
				}
				JSObjectAdapter.$put(fetching, url, new Date().getTime() + 60000);
			}
		}
		if (!shouldTryUrl(url)) {
			if (repos.$length() == 1)
				url = EcRemoteLinkedData.veryShortId(repos.$get(0).selectedServer, EcCrypto.md5(url));
			else {
				EcRepository.find(url, "Could not locate object. May be due to EcRepository.alwaysTryUrl flag.", new Object(), 0, success, failure);
				return;
			}
		}
		final FormData fd = new FormData();
		final String finalUrl = url;
		if (unsigned) {
			EcRemote.getExpectingObject(finalUrl, null, new Callback1<Object>() {
				@Override
				public void $invoke(Object p1) {
					JSObjectAdapter.$properties(fetching).$delete(originalUrl);
					EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
					d.copyFrom(p1);
					if (d.getFullType() == null) {
						EcRepository.find(originalUrl, Global.JSON.stringify(p1), new Object(), 0, success, failure);
						return;
					}
					if (caching) {
						JSObjectAdapter.$put(cache, d.id, d);
						JSObjectAdapter.$put(cache, d.shortId(), d);
					}
					success.$invoke(d);
				}
			}, new Callback1<String>() {

				@Override
				public void $invoke(String p1) {
					EcRepository.find(originalUrl, p1, new Object(), 0, success, failure);
				}
			});
		} else
			EcIdentityManager.signatureSheetAsync(60000, url, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					if (JSObjectAdapter.$get(cache, originalUrl) != null) {
						JSObjectAdapter.$properties(fetching).$delete(originalUrl);
						success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, originalUrl));
						return;
					}
					fd.append("signatureSheet", p1);
					EcRemote.postExpectingObject(finalUrl, null, fd, new Callback1<Object>() {
						@Override
						public void $invoke(Object p1) {
							JSObjectAdapter.$properties(fetching).$delete(originalUrl);
							EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
							d.copyFrom(p1);
							if (d.getFullType() == null) {
								EcRepository.find(originalUrl, Global.JSON.stringify(p1), new Object(), 0, success, failure);
								return;
							}
							if (caching) {
								JSObjectAdapter.$put(cache, d.id, d);
								JSObjectAdapter.$put(cache, d.shortId(), d);
							}
							success.$invoke(d);
						}
					}, new Callback1<String>() {

						@Override
						public void $invoke(String p1) {
							EcRepository.find(originalUrl, p1, new Object(), 0, success, failure);
						}
					});
				}
			}, failure);
	}

	private static boolean shouldTryUrl(String url) {
		if (url == null)
			return false;
		if (alwaysTryUrl)
			return true;
		if (repos.$length() == 0)
			return true;
		if (url.indexOf("/api/") != -1 || url.indexOf("/data/") != -1)
			return true;
		boolean validUrlFound = false;
		for (int i = 0; i < repos.$length(); i++) {
			if (repos.$get(i).selectedServer == null)
				continue;
			validUrlFound = true;
		}
		if (!validUrlFound)
			return true;
		return false;
	}

	private static void find(final String url, final String error, final Object history, final int i, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure) {
		if (JSGlobal.isNaN(i) || (Object) i == JSGlobal.undefined || i > repos.$length() || repos.$get(i) == null) {
			JSObjectAdapter.$properties(fetching).$delete(url);
			if (failure != null)
				failure.$invoke(error);
			return;
		}
		final EcRepository repo = repos.$get(i);
		if (repo.selectedServer == null) {
			find(url, error, history, i + 1, success, failure);
			return;
		}
		if (((Boolean) JSObjectAdapter.$get(history, repo.selectedServer)) == true) {
			find(url, error, history, i + 1, success, failure);
			return;
		}
		JSObjectAdapter.$put(history, repo.selectedServer, true);
		repo.search("@id:\"" + url + "\"", null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> strings) {
				if (strings == null || strings.$length() == 0)
					find(url, error, history, i + 1, success, failure);
				else {
					boolean done = false;
					for (int i = 0; i < strings.$length(); i++) {
						if (strings.$get(i).id == url) {
							if (done)
								Logger.log("Searching for exact ID:" + url + ", found more than one@:" + repo.selectedServer);
							done = true;
							JSObjectAdapter.$properties(fetching).$delete(url);
							if (caching) {
								JSObjectAdapter.$put(cache, url, strings.$get(i));
							}
							success.$invoke(strings.$get(i));
						}
					}
					if (done)
						return;
					find(url, error, history, i + 1, success, failure);
				}
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String s) {
				find(url, s, history, i + 1, success, failure);
			}
		});
	}

	private static EcRemoteLinkedData findBlocking(final String url, final String error, final Object history, final int i) {
		if (i > repos.$length() || repos.$get(i) == null) {
			JSObjectAdapter.$properties(fetching).$delete(url);
			return null;
		}
		final EcRepository repo = repos.$get(i);
		if (((Boolean) JSObjectAdapter.$get(history, repo.selectedServer)) == true)
			findBlocking(url, error, history, i + 1);
		JSObjectAdapter.$put(history, repo.selectedServer, true);
		Array<EcRemoteLinkedData> strings = repo.searchBlocking("@id:\"" + url + "\"");
		if (strings == null || strings.$length() == 0)
			return findBlocking(url, error, history, i + 1);
		else {
			for (int j = 0; j < strings.$length(); j++) {
				if (strings.$get(j).id == url) {
					JSObjectAdapter.$properties(fetching).$delete(url);
					if (caching) {
						JSObjectAdapter.$put(cache, url, strings.$get(j));
					}
					return strings.$get(j);
				}
			}
		}
		return findBlocking(url, error, history, i + 1);
	}

	/**
	 * Retrieves a piece of data synchronously from the server, blocking until
	 * it is returned
	 *
	 * @param {String} url URL ID of the data to be retrieved
	 * @return {EcRemoteLinkedData} Data retrieved, corresponding to the ID
	 * @memberOf EcRepository
	 * @method getBlocking
	 * @static
	 */
	public static EcRemoteLinkedData getBlocking(String url) {
		final String originalUrl = url;
		if (originalUrl == null)
			return null;
		if (caching) {
			if (JSObjectAdapter.$get(cache, originalUrl) != null) {
				return (EcRemoteLinkedData) JSObjectAdapter.$get(cache, originalUrl);
			}
		}
		if (!shouldTryUrl(originalUrl)) {
			if (repos.$length() == 1)
				url = EcRemoteLinkedData.veryShortId(repos.$get(0).selectedServer, EcCrypto.md5(url));
			else {
				return EcRepository.findBlocking(originalUrl, "Could not locate object. May be due to EcRepository.alwaysTryUrl flag.", new Object(), 0);
			}
		}
		final FormData fd = new FormData();
		String p1 = null;

		if (unsigned == false) {
			p1 = EcIdentityManager.signatureSheet(60000, originalUrl);
			fd.append("signatureSheet", p1);
		}
		boolean oldAsync = EcRemote.async;
		EcRemote.async = false;
		final String finalUrl = url;
		EcRemote.postExpectingObject(finalUrl, null, fd, new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
				d.copyFrom(p1);
				if (d.getFullType() == null) {
					EcRepository.findBlocking(originalUrl, Global.JSON.stringify(p1), new Object(), 0);
					return;
				}
				JSObjectAdapter.$put(cache, originalUrl, d);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String s) {
				JSObjectAdapter.$put(cache, originalUrl, EcRepository.findBlocking(originalUrl, s, new Object(), 0));
			}
		});
		EcRemote.async = oldAsync;
		EcRemoteLinkedData result = (EcRemoteLinkedData) JSObjectAdapter.$get(cache, originalUrl);
		if (!caching) {
			JSObjectAdapter.$properties(cache).$delete(originalUrl);
		}
		return result;
	}

	/**
	 * Escapes a search query
	 *
	 * @param {String} query Query string to escape
	 * @return {String} Escaped query string
	 * @memberOf EcRepository
	 * @method escapeSearch
	 * @static
	 */
	public static String escapeSearch(String query) {
		String s = null;
		s = JSCollections.$castArray(query.split("\\")).join("\\\\");
		s = JSCollections.$castArray(s.split("-")).join("\\-");
		s = JSCollections.$castArray(s.split("=")).join("\\=");
		s = JSCollections.$castArray(s.split("&&")).join("\\&&");
		s = JSCollections.$castArray(s.split("||")).join("\\||");
		s = JSCollections.$castArray(s.split("<")).join("\\<");
		s = JSCollections.$castArray(s.split(">")).join("\\>");
		s = JSCollections.$castArray(s.split("|")).join("\\|");
		s = JSCollections.$castArray(s.split("(")).join("\\(");
		s = JSCollections.$castArray(s.split(")")).join("\\)");
		s = JSCollections.$castArray(s.split("{")).join("\\{");
		s = JSCollections.$castArray(s.split("}")).join("\\}");
		s = JSCollections.$castArray(s.split("[")).join("\\[");
		s = JSCollections.$castArray(s.split("]")).join("\\]");
		s = JSCollections.$castArray(s.split("^")).join("\\^");
		s = JSCollections.$castArray(s.split("\"")).join("\\\"");
		s = JSCollections.$castArray(s.split("~")).join("\\~");
		s = JSCollections.$castArray(s.split("*")).join("\\*");
		s = JSCollections.$castArray(s.split("?")).join("\\?");
		s = JSCollections.$castArray(s.split(":")).join("\\:");
		s = JSCollections.$castArray(s.split("/")).join("\\/");
		s = JSCollections.$castArray(s.split("+")).join("\\+");
		return s;
	}

	/**
	 * Attempts to save a piece of data.
	 * <p>
	 * Uses a signature sheet informed by the owner field of the data.
	 *
	 * @param {EcRemoteLinkedData} data Data to save to the location designated
	 *                             by its id.
	 * @param {Callback1<String>}  success Callback triggered on successful save
	 * @param {Callback1<String>}  failure Callback triggered if error during
	 *                             save
	 * @memberOf EcRepository
	 * @method save
	 * @static
	 */
	public static void save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) {
		//Using EcRepository 'save' method, if this is intentional consider calling '_save'
		//Using this method instead of the save method for your object (if it exists) bypasses quality checks.
		_save(data, success, failure, null);
	}

	/**
	 * Attempts to save a piece of data. If the @id of the data is not of this server, will register the data to the server.
	 * <p>
	 * Uses a signature sheet informed by the owner field of the data.
	 *
	 * @param {EcRemoteLinkedData} data Data to save to the location designated
	 *                             by its id.
	 * @param {Callback1<String>}  success Callback triggered on successful save
	 * @param {Callback1<String>}  failure Callback triggered if error during
	 *                             save
	 * @memberOf EcRepository
	 * @method save
	 * @static
	 */
	public void saveTo(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) {
		//Using EcRepository 'save' method, if this is intentional consider calling '_save'
		//Using this method instead of the save method for your object (if it exists) bypasses quality checks.
		_save(data, success, failure, this);
	}

	/**
	 * Attempts to save a piece of data. Does some checks before saving to
	 * ensure the data is valid. This version does not send a console warning,
	 * <p>
	 * Uses a signature sheet informed by the owner field of the data.
	 *
	 * @param {EcRemoteLinkedData} data Data to save to the location designated
	 *                             by its id.
	 * @param {Callback1<String>}  success Callback triggered on successful save
	 * @param {Callback1<String>}  failure Callback triggered if error during
	 *                             save
	 * @memberOf EcRepository
	 * @method _save
	 * @static
	 */

	public static void _save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure, EcRepository repo) {
		if (data.invalid()) {
			String msg = "Cannot save data. It is missing a vital component.";
			if (failure != null) {
				failure.$invoke(msg);
			} else {
				Global.console.error(msg);
			}
			return;
		}

		if (data.reader != null && data.reader.$length() == 0) {
			JSObjectAdapter.$properties(data).$delete("reader");
		}

		if (data.owner != null && data.owner.$length() == 0) {
			JSObjectAdapter.$properties(data).$delete("owner");
		}

		if (EcEncryptedValue.encryptOnSave(data.id, null)) {
			EcEncryptedValue encrypted = EcEncryptedValue.toEncryptedValue(data, false);
			EcIdentityManager.sign(data);
			_saveWithoutSigning(data, success, failure, repo);
		} else {
			EcIdentityManager.sign(data);
			_saveWithoutSigning(data, success, failure, repo);
		}
	}

	/**
	 * Attempts to save a piece of data without signing it.
	 * <p>
	 * Uses a signature sheet informed by the owner field of the data.
	 *
	 * @param {EcRemoteLinkedData} data Data to save to the location designated
	 *                             by its id.
	 * @param {Callback1<String>}  success Callback triggered on successful save
	 * @param {Callback1<String>}  failure Callback triggered if error during
	 *                             save
	 * @memberOf EcRepository
	 * @method _saveWithoutSigning
	 * @static
	 */
	private static void _saveWithoutSigning(final EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure, final EcRepository repo) {

		if (caching) {
			JSObjectAdapter.$properties(cache).$delete(data.id);
			JSObjectAdapter.$properties(cache).$delete(data.shortId());
		}
		if (data.invalid()) {
			failure.$invoke("Data is malformed.");
			return;
		}

		if (alwaysTryUrl || repo == null || repo.shouldTryUrl(data.id))
			data.updateTimestamp();

		final FormData fd = new FormData();
		fd.append("data", data.toJson());
		Callback1 afterSignatureSheet = new Callback1<String>() {
			@Override
			public void $invoke(String signatureSheet) {
				fd.append("signatureSheet", signatureSheet);
				if (!alwaysTryUrl)
					if (repo != null)
						if (!repo.shouldTryUrl(data.id)) {
							EcRemote.postExpectingString(urlAppend(repo.selectedServer, "data/" + data.getDottedType() + "/" + EcCrypto.md5(data.id)), "", fd, success, failure);
							return;
						}
				EcRemote.postExpectingString(data.id, "", fd, success, failure);
			}
		};

		if (EcRemote.async == false) {
			String signatureSheet;
			if (data.owner != null && data.owner.$length() > 0) {
				signatureSheet = EcIdentityManager.signatureSheetFor(data.owner, 60000, data.id);
			} else {
				signatureSheet = EcIdentityManager.signatureSheet(60000, data.id);
			}
			afterSignatureSheet.$invoke(signatureSheet);
		} else if (data.owner != null && data.owner.$length() > 0) {
			EcIdentityManager.signatureSheetForAsync(data.owner, 60000, data.id, afterSignatureSheet, failure);
		} else {
			EcIdentityManager.signatureSheetAsync(60000, data.id, afterSignatureSheet, failure);
		}

	}

	/**
	 * Attempts to delete a piece of data.
	 * <p>
	 * Uses a signature sheet informed by the owner field of the data.
	 *
	 * @param {EcRemoteLinkedData} data Data to save to the location designated
	 *                             by its id.
	 * @param {Callback1<String>}  success Callback triggered on successful
	 *                             delete
	 * @param {Callback1<String>}  failure Callback triggered if error during
	 *                             delete
	 * @memberOf EcRepository
	 * @method _delete
	 * @static
	 */
	public static void _delete(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) {
		DELETE(data, success, failure);
	}

	/**
	 * Attempts to delete a piece of data.
	 * <p>
	 * Uses a signature sheet informed by the owner field of the data.
	 *
	 * @param {EcRemoteLinkedData} data Data to save to the location designated
	 *                             by its id.
	 * @param {Callback1<String>}  success Callback triggered on successful
	 *                             delete
	 * @param {Callback1<String>}  failure Callback triggered if error during
	 *                             delete
	 * @memberOf EcRepository
	 * @method DELETE
	 * @static
	 */
	public static void DELETE(final EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) {

		if (caching) {
			JSObjectAdapter.$properties(cache).$delete(data.id);
			JSObjectAdapter.$properties(cache).$delete(data.shortId());
		}
		final String targetUrl;
		targetUrl = data.shortId();

		if (data.owner != null && data.owner.$length() > 0) {
			if (EcRemote.async) {
				EcIdentityManager.signatureSheetForAsync(data.owner, 60000, data.id, new Callback1<String>() {
					@Override
					public void $invoke(String signatureSheet) {
						if (signatureSheet.length() == 2) {
							for (int i = 0; i < repos.$length(); i++) {
								if (data.id.indexOf(repos.$get(i).selectedServer) != -1) {
									repos.$get(i).deleteRegistered(data, success, failure);
									return;
								}
							}
							failure.$invoke("Cannot delete object without a signature. If deleting from a server, use the non-static _delete");
						} else
							EcRemote._delete(targetUrl, signatureSheet, success, failure);
					}
				}, failure);
			} else {
				String signatureSheet = EcIdentityManager.signatureSheetFor(data.owner, 60000, data.id);
				if (signatureSheet.length() == 2) {
					for (int i = 0; i < repos.$length(); i++) {
						if (data.id.indexOf(repos.$get(i).selectedServer) != -1) {
							repos.$get(i).deleteRegistered(data, success, failure);
							return;
						}
					}
					failure.$invoke("Cannot delete object without a signature. If deleting from a server, use the non-static _delete");
				} else
					EcRemote._delete(targetUrl, signatureSheet, success, failure);
			}
		} else {
			EcRemote._delete(targetUrl, "[]", success, failure);
		}

	}

	/**
	 * Attempts to delete a piece of data.
	 * <p>
	 * Uses a signature sheet informed by the owner field of the data.
	 *
	 * @param {EcRemoteLinkedData} data Data to save to the location designated
	 *                             by its id.
	 * @param {Callback1<String>}  success Callback triggered on successful
	 *                             delete
	 * @param {Callback1<String>}  failure Callback triggered if error during
	 *                             delete
	 * @memberOf EcRepository
	 * @method DELETE
	 * @static
	 */
	public void deleteRegistered(final EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) {
		if (caching) {
			JSObjectAdapter.$properties(cache).$delete(data.id);
			JSObjectAdapter.$properties(cache).$delete(data.shortId());
		}
		final String targetUrl;
		if (shouldTryUrl(data.id))
			targetUrl = data.shortId();
		else {
			targetUrl = urlAppend(selectedServer, "data/" + data.getDottedType() + "/" + EcCrypto.md5(data.id));
		}

		final EcRepository me = this;
		if (data.owner != null && data.owner.$length() > 0) {
			if (EcRemote.async) {
				EcIdentityManager.signatureSheetForAsync(data.owner, 60000, data.id, new Callback1<String>() {
					@Override
					public void $invoke(String signatureSheet) {
						if (signatureSheet.length() == 2 && me.adminKeys != null) {
							EcIdentityManager.signatureSheetForAsync(me.adminKeys, 60000, data.id, new Callback1<String>() {
								@Override
								public void $invoke(String signatureSheet) {
									EcRemote._delete(targetUrl, signatureSheet, success, failure);
								}
							}, failure);
						} else
							EcRemote._delete(targetUrl, signatureSheet, success, failure);
					}
				}, failure);
			} else {
				String signatureSheet = EcIdentityManager.signatureSheetFor(data.owner, 60000, data.id);
				if (signatureSheet.length() == 2 && me.adminKeys != null) {
					signatureSheet = EcIdentityManager.signatureSheetFor(me.adminKeys, 60000, data.id);
					EcRemote._delete(targetUrl, signatureSheet, success, failure);
				} else
					EcRemote._delete(targetUrl, signatureSheet, success, failure);
			}
		} else {
			EcRemote._delete(targetUrl, "[]", success, failure);
		}
	}

	/**
	 * Retrieves data from the server and caches it for use later during the
	 * application. This should be called before the data is needed if possible,
	 * so loading displays can be faster.
	 *
	 * @param {String[]}  urls List of Data ID Urls that should be precached
	 * @param {Callback0} success Callback triggered once all of the data has
	 *                    been retrieved
	 * @memberOf EcRepository
	 * @method precache
	 */
	public void precache(final Array<String> urls, final Callback0 success) {
		if (urls == null || urls.$length() == 0) {
			if (success != null) {
				success.$invoke();
			}
			return;
		}

		final Array<String> cacheUrls = new Array<String>();
		for (int i = 0; i < urls.$length(); i++) {
			String url = urls.$get(i);
			if (JSObjectAdapter.$get(cache, url) != null) {
			} else if (url.startsWith(selectedServer)) {
				cacheUrls.push(url.replace(selectedServer, "").replace("custom/", ""));
			} else {
				cacheUrls.push("data/" + EcCrypto.md5(url));
			}
		}
		if (cacheUrls.$length() == 0) {
			if (success != null) {
				success.$invoke();
			}
			return;
		}
		final FormData fd = new FormData();
		fd.append("data", Global.JSON.stringify(cacheUrls));
		final EcRepository me = this;
		if (unsigned) {
			precachePost(success, cacheUrls, fd, me);
		} else {
			EcIdentityManager.signatureSheetAsync(60000, selectedServer, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					fd.append("signatureSheet", p1);
					me.precachePost(success, cacheUrls, fd, me);
				}
			}, null);
		}
	}

	/**
	 * Retrieves data from the server and caches it for use later during the
	 * application. This should be called before the data is needed if possible,
	 * so loading displays can be faster.
	 *
	 * @param {String[]}  urls List of Data ID Urls that should be precached
	 * @param {Callback0} success Callback triggered once all of the data has
	 *                    been retrieved
	 * @memberOf EcRepository
	 * @method precachePost
	 */
	private void precachePost(final Callback0 success, final Array<String> cacheUrls, FormData fd, EcRepository me) {
		EcRemote.postExpectingObject(me.selectedServer, "sky/repo/multiGet", fd, new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				Array<EcRemoteLinkedData> results = (Array<EcRemoteLinkedData>) p1;
				for (int i = 0; i < results.$length(); i++) {
					EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
					d.copyFrom(results.$get(i));
					results.$set(i, d);
					if (caching) {
						if (!shouldTryUrl(d.id)) {
							String md5 = EcCrypto.md5(d.id);
							for (int j = 0; j < cacheUrls.$length(); j++) {
								String url = cacheUrls.$get(j);
								if (url.indexOf(md5) != -1) {
									JSObjectAdapter.$put(cache, url, d);
									break;
								}
							}
						}
						JSObjectAdapter.$put(cache, d.shortId(), d);
						JSObjectAdapter.$put(cache, d.id, d);
					}
				}
				if (success != null) {
					success.$invoke();
				}
			}
		}, null);
	}

	/**
	 * Gets a JSON-LD object from the place designated by the URI.
	 * <p>
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 *
	 * @param {String}                               url URL of the remote object.
	 * @param {Callback1<EcRemoteLinkedData>}success Event to call upon
	 *                                               successful retrieval.
	 * @param {Callback1<String>}                    failure Event to call upon spectacular
	 *                                               failure.
	 * @memberOf EcRepository
	 * @method get
	 * @static
	 */
	public void multiget(final Array<String> urls, final Callback1<Array<EcRemoteLinkedData>> success, final Callback1<String> failure, final Callback1<Array<EcRemoteLinkedData>> cachedValues) {
		if (urls == null || urls.$length() == 0) {
			if (failure != null) {
				failure.$invoke("");
			}
			return;
		}

		if (caching) {
			Array<EcRemoteLinkedData> cachedVals = JSCollections.$array();

			for (int i = 0; i < urls.$length(); i++) {
				if (JSObjectAdapter.$get(cache, urls.$get(i)) != null) {
					cachedVals.push((EcRemoteLinkedData) JSObjectAdapter.$get(cache, urls.$get(i)));
				}
			}
			if (cachedValues != null)
				cachedValues.$invoke(cachedVals);
		}

		Array<String> onServer = new Array<String>();
		for (int i = 0; i < urls.$length(); i++) {
			String url = urls.$get(i);
			if (url.startsWith(selectedServer)) {
				onServer.push(url.replace(selectedServer, "").replace("custom/", ""));
			}
		}

		final FormData fd = new FormData();
		fd.append("data", Global.JSON.stringify(onServer));
		final EcRepository me = this;
		if (unsigned == true)
			EcRemote.postExpectingObject(me.selectedServer, "sky/repo/multiGet", fd, new Callback1<Object>() {
				@Override
				public void $invoke(Object p1) {
					Array<EcRemoteLinkedData> results = (Array<EcRemoteLinkedData>) p1;
					for (int i = 0; i < results.$length(); i++) {
						EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
						d.copyFrom(results.$get(i));
						results.$set(i, d);
						if (caching) {
							JSObjectAdapter.$put(cache, d.shortId(), d);
							JSObjectAdapter.$put(cache, d.id, d);
						}
					}
					if (success != null) {
						success.$invoke(results);
					}
				}
			}, failure);
		else
			EcIdentityManager.signatureSheetAsync(60000, selectedServer, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					fd.append("signatureSheet", p1);
					EcRemote.postExpectingObject(me.selectedServer, "sky/repo/multiGet", fd, new Callback1<Object>() {
						@Override
						public void $invoke(Object p1) {
							Array<EcRemoteLinkedData> results = (Array<EcRemoteLinkedData>) p1;
							for (int i = 0; i < results.$length(); i++) {
								EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
								d.copyFrom(results.$get(i));
								results.$set(i, d);
								if (caching) {
									JSObjectAdapter.$put(cache, d.shortId(), d);
									JSObjectAdapter.$put(cache, d.id, d);
								}
							}
							if (success != null) {
								success.$invoke(results);
							}
						}
					}, failure);
				}
			}, failure);

	}

	/**
	 * Search a repository for JSON-LD compatible data.
	 * <p>
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 *
	 * @param {String}                          query ElasticSearch compatible query string, similar to
	 *                                          Google query strings.
	 * @param {Callback1<EcRemoteLinkedData>}   eachSuccess Success event for each
	 *                                          found object.
	 * @param {Callback1<EcRemoteLinkedData[]>} success Success event, called
	 *                                          after eachSuccess.
	 * @param {Callback1<String>}               failure Failure event.
	 * @memberOf EcRepository
	 * @method search
	 */
	public void search(String query, final Callback1<EcRemoteLinkedData> eachSuccess, final Callback1<Array<EcRemoteLinkedData>> success,
	                   final Callback1<String> failure) {
		searchWithParams(query, null, eachSuccess, success, failure);
	}

	/**
	 * Search a repository for JSON-LD compatible data synchronously.
	 * <p>
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 *
	 * @param {String} query ElasticSearch compatible query string, similar to
	 *                 Google query strings.
	 * @returns EcRemoteLinkedData[]
	 * @memberOf EcRepository
	 * @method search
	 */
	public Array<EcRemoteLinkedData> searchBlocking(String query) {
		return searchWithParamsBlocking(query, null);
	}

	/**
	 * Search a repository for JSON-LD compatible data.
	 * <p>
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 *
	 * @param {String}                          query ElasticSearch compatible query string, similar to
	 *                                          Google query strings.
	 * @param {Object}                          paramObj Additional parameters that can be used to tailor
	 *                                          the search.
	 * @param {Callback1<EcRemoteLinkedData>}   eachSuccess Success event for each
	 *                                          found object.
	 * @param {Callback1<EcRemoteLinkedData[]>} success Success event, called
	 *                                          after eachSuccess.
	 * @param {Callback1<String>}               failure Failure event.
	 * @memberOf EcRepository
	 * @method searchWithParams
	 */
	public void searchWithParams(final String originalQuery, final Object originalParamObj, final Callback1<EcRemoteLinkedData> eachSuccess,
	                             final Callback1<Array<EcRemoteLinkedData>> success, final Callback1<String> failure) {

		if (EcRemote.async == false) {
			Array<EcRemoteLinkedData> result = searchWithParamsBlocking(originalQuery, originalParamObj);
			if (result == null) {
				if (failure != null)
					failure.$invoke("Search failed.");
			} else {
				for (int i = 0; i < result.$length(); i++)
					if (eachSuccess != null)
						eachSuccess.$invoke(result.$get(i));
				if (success != null)
					success.$invoke(result);
			}
			return;
		}
		String query = originalQuery;
		Object paramObj = originalParamObj;
		if (paramObj == null) {
			paramObj = new Object();
		}

		Object params = new Object();
		Map<String, Object> paramProps = JSObjectAdapter.$properties(params);
		query = searchParamProps(query, paramObj, paramProps);

		if (JSObjectAdapter.$get(paramObj, "fields") != null) {
			paramProps.$put("fields", JSObjectAdapter.$get(paramObj, "fields"));
		}

		final String cacheKey;
		if (cachingSearch) {
			cacheKey = JSGlobal.JSON.stringify(paramProps) + query;
			if (JSObjectAdapter.$get(cache, cacheKey) != null) {
				handleSearchResults((Array<EcRemoteLinkedData>) JSObjectAdapter.$get(cache, cacheKey), eachSuccess, success, failure);
				return;
			}
			final EcRepository me = this;
			if (EcRemote.async) {
				if (JSObjectAdapter.$get(fetching, cacheKey) != null) {
					if ((Double) JSObjectAdapter.$get(fetching, cacheKey) > new Date().getTime()) {
						Global.setTimeout(new Callback0() {
							@Override
							public void $invoke() {
								me.searchWithParams(originalQuery, originalParamObj, eachSuccess, success, failure);
							}
						}, 100);
						return;
					}
				}
				JSObjectAdapter.$put(fetching, cacheKey, new Date().getTime() + 60000);
			}
		} else {
			cacheKey = null;
		}

		final FormData fd = new FormData();
		fd.append("data", query);
		if (params != null) {
			fd.append("searchParams", Global.JSON.stringify(params));
		}
		final EcRepository me = this;
		if (unsigned == true || (Boolean) JSObjectAdapter.$get(paramObj, "unsigned") == true) {
			fd.append("signatureSheet", "[]");
			EcRemote.postExpectingObject(me.selectedServer, "sky/repo/search", fd, new Callback1<Object>() {
				@Override
				public void $invoke(Object p1) {
					if (cachingSearch) {
						JSObjectAdapter.$put(cache, cacheKey, p1);
					}
					if (cacheKey != null) {
						JSObjectAdapter.$properties(fetching).$delete(cacheKey);
					}

					me.handleSearchResults((Array<EcRemoteLinkedData>) p1, eachSuccess, success, failure);
				}
			}, new Callback1<String>() {

				@Override
				public void $invoke(String p1) {
					if (cacheKey != null) {
						JSObjectAdapter.$properties(fetching).$delete(cacheKey);
					}
					if (failure != null) {
						failure.$invoke(p1);
					}
				}
			});
		} else
			EcIdentityManager.signatureSheetAsync(60000, selectedServer, new Callback1<String>() {
				@Override
				public void $invoke(String signatureSheet) {
					fd.append("signatureSheet", signatureSheet);
					EcRemote.postExpectingObject(me.selectedServer, "sky/repo/search", fd, new Callback1<Object>() {
						@Override
						public void $invoke(Object p1) {
							if (cachingSearch) {
								JSObjectAdapter.$put(cache, cacheKey, p1);
							}
							if (cacheKey != null) {
								JSObjectAdapter.$properties(fetching).$delete(cacheKey);
							}

							me.handleSearchResults((Array<EcRemoteLinkedData>) p1, eachSuccess, success, failure);
						}
					}, new Callback1<String>() {

						@Override
						public void $invoke(String p1) {
							if (cacheKey != null) {
								JSObjectAdapter.$properties(fetching).$delete(cacheKey);
							}
							if (failure != null) {
								failure.$invoke(p1);
							}
						}
					});
				}
			}, failure);
	}

	/**
	 * Search a repository for JSON-LD compatible data synchronously.
	 * <p>
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 *
	 * @param {String} query ElasticSearch compatible query string, similar to
	 *                 Google query strings.
	 * @param {Object} paramObj Additional parameters that can be used to tailor
	 *                 the search.
	 * @returns EcRemoteLinkedData[]
	 * @memberOf EcRepository
	 * @method searchWithParams
	 */
	public Array<EcRemoteLinkedData> searchWithParamsBlocking(final String originalQuery, final Object originalParamObj) {
		String query = originalQuery;
		Object paramObj = originalParamObj;
		if (paramObj == null) {
			paramObj = new Object();
		}
		Object params = new Object();
		Map<String, Object> paramProps = JSObjectAdapter.$properties(params);
		query = searchParamProps(query, paramObj, paramProps);

		if (JSObjectAdapter.$get(paramObj, "fields") != null) {
			paramProps.$put("fields", JSObjectAdapter.$get(paramObj, "fields"));
		}

		boolean oldAsync = EcRemote.async;
		EcRemote.async = false;

		final String cacheKey;
		cacheKey = JSGlobal.JSON.stringify(paramProps) + query;
		if (cachingSearch) {
			if (JSObjectAdapter.$get(cache, cacheKey) != null) {
				return handleSearchResults((Array<EcRemoteLinkedData>) JSObjectAdapter.$get(cache, cacheKey), null, null, null);
			}
		}

		final FormData fd = new FormData();
		fd.append("data", query);

		if (params != null) {
			fd.append("searchParams", Global.JSON.stringify(params));
		}
		final EcRepository me = this;
		if (unsigned == true || (Boolean) JSObjectAdapter.$get(paramObj, "unsigned") == true) {
			fd.append("signatureSheet", "[]");
			EcRemote.postExpectingObject(me.selectedServer, "sky/repo/search", fd, new Callback1<Object>() {
				@Override
				public void $invoke(Object p1) {
					JSObjectAdapter.$put(cache, cacheKey, p1);
					if (cacheKey != null) {
						JSObjectAdapter.$properties(fetching).$delete(cacheKey);
					}
				}
			}, new Callback1<String>() {

				@Override
				public void $invoke(String p1) {
					if (cacheKey != null) {
						JSObjectAdapter.$properties(fetching).$delete(cacheKey);
					}
					JSObjectAdapter.$put(cache, cacheKey, null);
				}
			});
		} else {
			String signatureSheet;
			signatureSheet = EcIdentityManager.signatureSheet(60000, selectedServer);
			fd.append("signatureSheet", signatureSheet);
			EcRemote.postExpectingObject(me.selectedServer, "sky/repo/search", fd, new Callback1<Object>() {
				@Override
				public void $invoke(Object p1) {
					JSObjectAdapter.$put(cache, cacheKey, p1);
					if (cacheKey != null) {
						JSObjectAdapter.$properties(fetching).$delete(cacheKey);
					}
				}
			}, new Callback1<String>() {

				@Override
				public void $invoke(String p1) {
					if (cacheKey != null) {
						JSObjectAdapter.$properties(fetching).$delete(cacheKey);
					}
					JSObjectAdapter.$put(cache, cacheKey, null);
				}
			});
		}

		Array<EcRemoteLinkedData> result = handleSearchResults((Array<EcRemoteLinkedData>) JSObjectAdapter.$get(cache, cacheKey), null, null, null);
		if (!cachingSearch) {
			JSObjectAdapter.$properties(cache).$delete(cacheKey);
		}
		EcRemote.async = oldAsync;
		return result;
	}

	private String searchParamProps(String query, Object paramObj, Map<String, Object> paramProps) {
		if (JSObjectAdapter.$get(paramObj, "start") != null) {
			paramProps.$put("start", JSObjectAdapter.$get(paramObj, "start"));
		}
		if (JSObjectAdapter.$get(paramObj, "size") != null) {
			paramProps.$put("size", JSObjectAdapter.$get(paramObj, "size"));
		}
		if (JSObjectAdapter.$get(paramObj, "types") != null) {
			paramProps.$put("types", JSObjectAdapter.$get(paramObj, "types"));
		}
		if (JSObjectAdapter.$get(paramObj, "sort") != null) {
			paramProps.$put("sort", JSObjectAdapter.$get(paramObj, "sort"));
		}
		if (JSObjectAdapter.$get(paramObj, "track_scores") != null) {
			paramProps.$put("track_scores", JSObjectAdapter.$get(paramObj, "track_scores"));
		}

		if (JSObjectAdapter.$get(paramObj, "ownership") != null) {
			String ownership = (String) JSObjectAdapter.$get(paramObj, "ownership");
			if (!query.startsWith("(") || !query.endsWith(")")) {
				query = "(" + query + ")";
			}

			if (ownership == "public") {
				query += " AND (_missing_:@owner)";
			} else if (ownership == "owned") {
				query += " AND (_exists_:@owner)";
			} else if (ownership == "me") {
				query += " AND (";
				for (int i = 0; i < EcIdentityManager.ids.$length(); i++) {
					if (i != 0) {
						query += " OR ";
					}
					EcIdentity id = EcIdentityManager.ids.$get(i);

					query += "@owner:\"" + id.ppk.toPk().toPem() + "\"";
				}

				query += ")";
			}
		}
		return query;
	}

	/**
	 * Searches known repository endpoints to set the server configuration for
	 * this repositories instance
	 *
	 * @memberOf EcRepository
	 * @method autoDetectRepository
	 */
	public void autoDetectRepositoryAsync(final Callback0 success, final Callback1 failure) {
		final Array<String> protocols = new Array<String>();
		if (Global.window != null) {
			if (Global.window.location != null) {
				if (Global.window.location.protocol == "https:") {
					protocols.push("https:");
				}
			}
		}
		if (Global.window != null) {
			if (Global.window.location != null) {
				if (Global.window.location.protocol == "http:") {
					protocols.push("http:");
					protocols.push("https:");
				}
			}
		}
		if (protocols.$length() == 0) {
			protocols.push("https:");
			protocols.push("http:");
		}
		final Array<String> hostnames = new Array<String>();
		final Array<String> servicePrefixes = new Array<String>();

		if (selectedServer != null) {
			Element e = Global.window.document.createElement("a");
			JSObjectAdapter.$put(e, "href", selectedServer);
			hostnames.push((String) JSObjectAdapter.$get(e, "host"));
			servicePrefixes.push((String) JSObjectAdapter.$get(e, "pathname"));
		} else {

			if (Global.window.location.host != null) {
				hostnames.push(Global.window.location.host, Global.window.location.host.replace(".", ".service."), Global.window.location.host + ":8080",
						Global.window.location.host.replace(".", ".service.") + ":8080");
			}

			if (Global.window.location.hostname != null) {
				hostnames.push(Global.window.location.hostname, Global.window.location.hostname.replace(".", ".service."),
						Global.window.location.hostname + ":8080", Global.window.location.hostname.replace(".", ".service.") + ":8080");
			}
		}
		EcArray.removeDuplicates(hostnames);

		servicePrefixes.push("/" + Global.window.location.pathname.split("/")[1] + "/api/", "/", "/service/",
				"/api/");
		EcArray.removeDuplicates(servicePrefixes);
		final EcRepository me = this;
		me.autoDetectFound = false;
		for (int j = 0; j < hostnames.$length(); j++) {
			for (int k = 0; k < servicePrefixes.$length(); k++) {
				for (int i = 0; i < protocols.$length(); i++) {
					autoDetectRepositoryActualAsync(protocols.$get(i) + "//" + hostnames.$get(j) + servicePrefixes.$get(k).replaceAll("//", "/"), success, failure);
					Global.setTimeout(new Callback0() {
						@Override
						public void $invoke() {
							if (me.autoDetectFound == false) {
								//Search using old service endpoints.
								Array<String> servicePrefixes = new Array<String>();
								servicePrefixes.push("/" + Global.window.location.pathname.split("/")[1] + "/api/custom/", "/api/custom/");
								EcArray.removeDuplicates(servicePrefixes);
								for (int j = 0; j < hostnames.$length(); j++) {
									for (int k = 0; k < servicePrefixes.$length(); k++) {
										for (int i = 0; i < protocols.$length(); i++) {
											me.autoDetectRepositoryActualAsync(protocols.$get(i) + "//" + hostnames.$get(j) + servicePrefixes.$get(k).replaceAll("//", "/"), success, failure);
											Global.setTimeout(new Callback0() {
												@Override
												public void $invoke() {
													if (me.autoDetectFound == false)
														failure.$invoke("Could not find service.");
												}
											}, 5000);
										}
									}
								}
							}
						}
					}, 5000);

				}
			}
		}
	}

	/**
	 * Searches known repository endpoints to set the server configuration for
	 * this repositories instance
	 *
	 * @memberOf EcRepository
	 * @method autoDetectRepository
	 */
	public void autoDetectRepository() {
		EcRemote.async = false;
		Array<String> protocols = new Array<String>();
		if (Global.window != null) {
			if (Global.window.location != null) {
				if (Global.window.location.protocol == "https:") {
					protocols.push("https:");
				}
			}
		}
		if (Global.window != null) {
			if (Global.window.location != null) {
				if (Global.window.location.protocol == "http:") {
					protocols.push("http:");
					protocols.push("https:");
				}
			}
		}
		if (protocols.$length() == 0) {
			protocols.push("https:");
			protocols.push("http:");
		}
		Array<String> hostnames = new Array<String>();
		Array<String> servicePrefixes = new Array<String>();

		if (selectedServer != null && Global.window != null && Global.window.document != null) {
			Element e = Global.window.document.createElement("a");
			if (e != null) {
				JSObjectAdapter.$put(e, "href", selectedServer);
				hostnames.push((String) JSObjectAdapter.$get(e, "host"));
				servicePrefixes.push((String) JSObjectAdapter.$get(e, "pathname"));
			}
		} else if (Global.window != null && Global.window.location != null) {
			if (Global.window.location.host != null) {
				hostnames.push(Global.window.location.host, Global.window.location.host.replace(".", ".service."), Global.window.location.host + ":8080",
						Global.window.location.host.replace(".", ".service.") + ":8080");
			}

			if (Global.window.location.hostname != null) {
				hostnames.push(Global.window.location.hostname, Global.window.location.hostname.replace(".", ".service."),
						Global.window.location.hostname + ":8080", Global.window.location.hostname.replace(".", ".service.") + ":8080");
			}
		}

		if (Global.window != null) {
			if (Global.window.location != null) {
				servicePrefixes.push("/" + Global.window.location.pathname.split("/")[1] + "/api/");
				servicePrefixes.push( "/" + Global.window.location.pathname.split("/")[1] + "/api/custom/");
			}
		}

		if (hostnames.$length() == 0)
		{
			hostnames.push("localhost","localhost:8080");
		}

		servicePrefixes.push("/");
		servicePrefixes.push("/service/");
		servicePrefixes.push("/api/");
		servicePrefixes.push("/api/custom/");
		for (int j = 0; j < hostnames.$length(); j++) {
			for (int k = 0; k < servicePrefixes.$length(); k++) {
				for (int i = 0; i < protocols.$length(); i++) {
					if (autoDetectRepositoryActual(protocols.$get(i) + "//" + hostnames.$get(j) + servicePrefixes.$get(k).replaceAll("//", "/"))) {
						EcRemote.async = true;
						return;
					}
				}
			}
		}
		EcRemote.async = true;
	}

	/**
	 * Handles the actual detection of repository endpoint /ping service
	 *
	 * @param {String} guess The server prefix
	 * @return {boolean} Whether the detection successfully found the endpoint
	 * @memberOf EcRepository
	 * @method autoDetectRepositoryAsync
	 * @private
	 */
	private boolean autoDetectRepositoryActualAsync(final String guess, final Callback0 success, Callback1 failure) {
		final EcRepository me = this;
		Callback1<Object> successCheck = new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				if (p1 != null) {
					if (JSObjectAdapter.$get(p1, "ping") == "pong") {
						if (me.autoDetectFound == false) {
							me.selectedServer = guess;
							me.autoDetectFound = true;
							success.$invoke();
						}
					}
				}
			}
		};
		Callback1<String> failureCheck = new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				if (p1 != null) {
					if (!(p1 == "")) {
						try {
							if (p1.indexOf("pong") != -1) {
								if (me.autoDetectFound == false) {
									me.selectedServer = guess;
									me.autoDetectFound = true;
									success.$invoke();
								}
							}
						} catch (Exception ex) {
						}
					}
				}
			}
		};
		if (guess != null && guess != "") {
			try {
				EcRemote.getExpectingObject(guess, "ping", successCheck, failureCheck);
			} catch (Exception ex) {

			}
		}
		return autoDetectFound;
	}

	/**
	 * Handles the actual detection of repository endpoint /ping service
	 *
	 * @param {String} guess The server prefix
	 * @return {boolean} Whether the detection successfully found the endpoint
	 * @memberOf EcRepository
	 * @method autoDetectRepositoryActual
	 * @private
	 */
	private boolean autoDetectRepositoryActual(final String guess) {
		int oldTimeout = EcRemote.timeout;
		EcRemote.timeout = 500;
		final EcRepository me = this;
		Callback1<Object> successCheck = new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				if (p1 != null) {
					if (JSObjectAdapter.$get(p1, "ping") == "pong") {
						me.selectedServer = guess;
						me.autoDetectFound = true;
					}
				}
			}
		};
		Callback1<String> failureCheck = new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				if (p1 != null) {
					if (p1 != "") {
						try {
							if (p1.indexOf("pong") != -1) {
								me.selectedServer = guess;
								me.autoDetectFound = true;
							}
						} catch (Exception ex) {
						}
					}
				}
			}
		};
		if (guess != null && guess != "") {
			try {
				EcRemote.getExpectingObject(guess, "ping", successCheck, failureCheck);
			} catch (Exception ex) {

			}
		}
		EcRemote.timeout = oldTimeout;
		return autoDetectFound;
	}

	/**
	 * Lists all types visible to the current user in the repository
	 * <p>
	 * Uses a signature sheet gathered from {@link EcIdentityManager}.
	 *
	 * @param {Callback1<Object[]>} success Success event
	 * @param {Callback1<String>}   failure Failure event.
	 * @memberOf EcRepository
	 * @method listTypes
	 */
	public void listTypes(final Callback1<Array<Object>> success, final Callback1<String> failure) {
		FormData fd = new FormData();
		fd.append("signatureSheet", EcIdentityManager.signatureSheet(60000, selectedServer));
		EcRemote.postExpectingObject(selectedServer, "sky/repo/types", fd, new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				Array<Object> results = (Array<Object>) p1;

				if (success != null) {
					success.$invoke(results);
				}
			}
		}, failure);
	}

	/**
	 * Backs up the skyrepo elasticsearch database to the server backup directory
	 *
	 * @param {String}            serverSecret Secret string stored on the server to authenticate administrative rights
	 * @param {Callback1<Object>} success Success event
	 * @param {Callback1<String>} failure Failure event.
	 * @memberOf EcRepository
	 * @method backup
	 */
	public void backup(String serverSecret, Callback1<Object> success, Callback1<String> failure) {
		EcRemote.getExpectingObject(selectedServer, "util/backup?secret=" + serverSecret, success, failure);
	}

	/**
	 * Restores the skyrepo elasticsearch backup from the server backup directory
	 *
	 * @param {String}            serverSecret Secret string stored on the server to authenticate administrative rights
	 * @param {Callback1<Object>} success Success event
	 * @param {Callback1<String>} failure Failure event.
	 * @memberOf EcRepository
	 * @method restoreBackup
	 */
	public void restoreBackup(String serverSecret, Callback1<Object> success, Callback1<String> failure) {
		EcRemote.getExpectingObject(selectedServer, "util/restore?secret=" + serverSecret, success, failure);
	}

	/**
	 * Wipes all data from the the skyrepo elasticsearch, can only be restored by using backup restore
	 *
	 * @param {String}            serverSecret Secret string stored on the server to authenticate administrative rights
	 * @param {Callback1<Object>} success Success event
	 * @param {Callback1<String>} failure Failure event.
	 * @memberOf EcRepository
	 * @method wipe
	 */
	public void wipe(String serverSecret, Callback1<Object> success, Callback1<String> failure) {
		EcRemote.getExpectingObject(selectedServer, "util/purge?secret=" + serverSecret, success, failure);
	}

	/**
	 * Handles the search results in search by params, before returning them
	 * with the callback passed into search method
	 *
	 * @param {EcRemoteLinkedData[]}            results Results to handle before returning
	 * @param {Callback1<EcRemoteLinkedData>}   eachSuccess Callback function to
	 *                                          trigger for each search result
	 * @param {Callback1<EcRemoteLinkedData[]>} success Callback function to
	 *                                          trigger with all search results
	 * @param failure
	 * @memberOf EcRepository
	 * @method handleSearchResults
	 * @private
	 */
	private Array<EcRemoteLinkedData> handleSearchResults(Array<EcRemoteLinkedData> results, final Callback1<EcRemoteLinkedData> eachSuccess,
	                                                      final Callback1<Array<EcRemoteLinkedData>> success, Callback1<String> failure) {
		if (results == null) {
			if (failure != null)
				failure.$invoke("Error in search. See HTTP request for more details.");
			return null;
		}
		for (int i = 0; i < results.$length(); i++) {
			EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
			d.copyFrom(results.$get(i));
			results.$set(i, d);
			if (caching) {
				JSObjectAdapter.$put(cache, d.shortId(), d);
				JSObjectAdapter.$put(cache, d.id, d);
			}
			if (eachSuccess != null) {
				eachSuccess.$invoke(results.$get(i));
			}
		}

		if (success != null) {
			success.$invoke(results);
		}
		return results;
	}

	/**
	 * Fetches the admin keys from the server to compare for check if current
	 * user is an admin user
	 *
	 * @param {Callback1<String[]>} success
	 *                              Callback triggered when the admin keys are successfully returned,
	 *                              returns an array of the admin public keys
	 * @param {Callback1<String>}   failure
	 *                              Callback triggered if error occurs fetching admin keys
	 * @memberOf EcRemoteIdentityManager
	 * @method fetchServerAdminKeys
	 */
	public void fetchServerAdminKeys(final Callback1<Array<String>> success, final Callback1<String> failure) {
		String service;
		if (selectedServer.endsWith("/")) {
			service = "sky/admin";
		} else {
			service = "/sky/admin";
		}
		final EcRepository me = this;
		EcRemote.getExpectingObject(selectedServer, service, new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				Array<String> ary = (Array<String>) p1;
				me.adminKeys = new Array();
				for (int i = 0; i < ary.$length(); i++) {
					me.adminKeys.push(ary.$get(i));
				}
				success.$invoke(ary);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				failure.$invoke("");
			}
		});
	}
}
