package org.cassproject.ebac.repository;

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
	public static void get(final String url, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure) {
		if (caching) {
			if (JSObjectAdapter.$get(cache, url) != null) {
				if (EcRemote.async) {
					Task.immediate(new Callback0() {
						@Override
						public void $invoke() {
							success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, url));
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
								get(url, success, failure);
							}
						}, 100);
						return;
					}
				}
				JSObjectAdapter.$put(fetching, url, new Date().getTime() + 60000);
			}
		}
		if (!shouldTryUrl(url)) {
			EcRepository.find(url, "Could not locate object. May be due to EcRepository.alwaysTryUrl flag.", new Object(), 0, success, failure);
			return;
		}
		final FormData fd = new FormData();
		if (unsigned) {
			EcRemote.postExpectingObject(url, null, fd, new Callback1<Object>() {
				@Override
				public void $invoke(Object p1) {
					JSObjectAdapter.$properties(fetching).$delete(url);
					EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
					d.copyFrom(p1);
					if (d.getFullType() == null) {
						EcRepository.find(url, Global.JSON.stringify(p1), new Object(), 0, success, failure);
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
					EcRepository.find(url, p1, new Object(), 0, success, failure);
				}
			});
		} else
			EcIdentityManager.signatureSheetAsync(60000, url, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					if (JSObjectAdapter.$get(cache, url) != null) {
						JSObjectAdapter.$properties(fetching).$delete(url);
						success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, url));
						return;
					}
					fd.append("signatureSheet", p1);
					EcRemote.postExpectingObject(url, null, fd, new Callback1<Object>() {
						@Override
						public void $invoke(Object p1) {
							JSObjectAdapter.$properties(fetching).$delete(url);
							EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
							d.copyFrom(p1);
							if (d.getFullType() == null) {
								EcRepository.find(url, Global.JSON.stringify(p1), new Object(), 0, success, failure);
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
							EcRepository.find(url, p1, new Object(), 0, success, failure);
						}
					});
				}
			});
	}

	private static boolean shouldTryUrl(String url) {
		if (url == null)
			return false;
		if (alwaysTryUrl)
			return true;
		if (repos.$length() == 0)
			return true;
		if (url.contains("/api/") || url.contains("/data/"))
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
							success.$invoke(strings.$get(i));
						}
					}
				}
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String s) {
				find(url, error, history, i + 1, success, failure);
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
	public static EcRemoteLinkedData getBlocking(final String url) {
		if (url == null)
			return null;
		if (caching) {
			if (JSObjectAdapter.$get(cache, url) != null) {
				return (EcRemoteLinkedData) JSObjectAdapter.$get(cache, url);
			}
		}
		if (!shouldTryUrl(url)) {
			return EcRepository.findBlocking(url, "Could not locate object. May be due to EcRepository.alwaysTryUrl flag.", new Object(), 0);
		}
		final FormData fd = new FormData();
		String p1 = null;

		if (unsigned == false) {
			p1 = EcIdentityManager.signatureSheet(60000, url);
			fd.append("signatureSheet", p1);
		}
		boolean oldAsync = EcRemote.async;
		EcRemote.async = false;
		EcRemote.postExpectingObject(url, null, fd, new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
				d.copyFrom(p1);
				if (d.getFullType() == null) {
					EcRepository.findBlocking(url, Global.JSON.stringify(p1), new Object(), 0);
					return;
				}
				JSObjectAdapter.$put(cache, url, d);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String s) {
				JSObjectAdapter.$put(cache, url, EcRepository.findBlocking(url, s, new Object(), 0));
			}
		});
		EcRemote.async = oldAsync;
		EcRemoteLinkedData result = (EcRemoteLinkedData) JSObjectAdapter.$get(cache, url);
		if (!caching) {
			JSObjectAdapter.$put(cache, url, null);
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
	 * Attempts to save a piece of data. Does some checks before saving to
	 * ensure the data is valid. Warns the developer that they are using the
	 * repository save function rather than an object specific version, this can
	 * be avoided by calling _save
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
		_save(data, success, failure);
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
	public static void _save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) {
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
			_saveWithoutSigning(data, success, failure);
		} else {
			EcIdentityManager.sign(data);
			_saveWithoutSigning(data, success, failure);
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
	private static void _saveWithoutSigning(final EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure) {

		if (caching) {
			JSObjectAdapter.$properties(cache).$delete(data.id);
			JSObjectAdapter.$properties(cache).$delete(data.shortId());
		}
		if (data.invalid()) {
			failure.$invoke("Data is malformed.");
			return;
		}

		data.updateTimestamp();

		final FormData fd = new FormData();
		fd.append("data", data.toJson());
		if (EcRemote.async == false) {
			if (data.owner != null && data.owner.$length() > 0) {
				String arg0 = EcIdentityManager.signatureSheetFor(data.owner, 60000, data.id);
				fd.append("signatureSheet", arg0);
				EcRemote.postExpectingString(data.id, "", fd, success, failure);
			} else {
				String arg0 = EcIdentityManager.signatureSheet(60000, data.id);
				fd.append("signatureSheet", arg0);
				EcRemote.postExpectingString(data.id, "", fd, success, failure);
			}
		} else if (data.owner != null && data.owner.$length() > 0) {
			EcIdentityManager.signatureSheetForAsync(data.owner, 60000, data.id, new Callback1<String>() {
				@Override
				public void $invoke(String arg0) {
					fd.append("signatureSheet", arg0);
					EcRemote.postExpectingString(data.id, "", fd, success, failure);
				}
			});
		} else {
			EcIdentityManager.signatureSheetAsync(60000, data.id, new Callback1<String>() {
				@Override
				public void $invoke(String arg0) {
					fd.append("signatureSheet", arg0);
					EcRemote.postExpectingString(data.id, "", fd, success, failure);
				}
			});
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
		EcIdentityManager.signatureSheetForAsync(data.owner, 60000, data.id, new Callback1<String>() {
			@Override
			public void $invoke(String signatureSheet) {
				EcRemote._delete(data.shortId(), signatureSheet, success, failure);
			}
		});
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
	public void precache(Array<String> urls, final Callback0 success) {
		if (urls == null || urls.$length() == 0) {
			if (success != null) {
				success.$invoke();
			}
			return;
		}

		Array<String> cacheUrls = new Array<String>();
		for (int i = 0; i < urls.$length(); i++) {
			String url = urls.$get(i);
			if (url.startsWith(selectedServer) && JSObjectAdapter.$get(cache, url) == null) {
				cacheUrls.push(url.replace(selectedServer, "").replace("custom/", ""));
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
						success.$invoke();
					}
				}
			}, null);
		} else
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
								success.$invoke();
							}
						}
					}, null);
				}
			});
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
			});

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
	 * @param size
	 * @param start
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
				handleSearchResults((Array<EcRemoteLinkedData>) JSObjectAdapter.$get(cache, cacheKey), eachSuccess, success);
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

					me.handleSearchResults((Array<EcRemoteLinkedData>) p1, eachSuccess, success);
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

							me.handleSearchResults((Array<EcRemoteLinkedData>) p1, eachSuccess, success);
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
			});
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
	 * @param size
	 * @param start
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
				return handleSearchResults((Array<EcRemoteLinkedData>) JSObjectAdapter.$get(cache, cacheKey), null, null);
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

		Array<EcRemoteLinkedData> result = handleSearchResults((Array<EcRemoteLinkedData>) JSObjectAdapter.$get(cache, cacheKey), null, null);
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

		if (JSObjectAdapter.$get(paramObj, "ownership") != null) {
			String ownership = (String) JSObjectAdapter.$get(paramObj, "ownership");
			if (!query.startsWith("(") || !query.endsWith(")")) {
				query = "(" + query + ")";
			}

			if (ownership.equals("public")) {
				query += " AND (_missing_:@owner)";
			} else if (ownership.equals("owned")) {
				query += " AND (_exists_:@owner)";
			} else if (ownership.equals("me")) {
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
	public void autoDetectRepositoryAsync(Callback0 success, final Callback1 failure) {
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

		servicePrefixes.push("/" + Global.window.location.pathname.split("/")[1] + "/api/", "/" + Global.window.location.pathname.split("/")[1] + "/api/custom/", "/", "/service/",
				"/api/", "/api/custom/");
		final EcRepository me = this;
		me.autoDetectFound = false;
		for (int j = 0; j < hostnames.$length(); j++) {
			for (int k = 0; k < servicePrefixes.$length(); k++) {
				for (int i = 0; i < protocols.$length(); i++) {
					autoDetectRepositoryActualAsync(protocols.$get(i) + "//" + hostnames.$get(j) + servicePrefixes.$get(k).replaceAll("//", "/"), success, failure);
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

		servicePrefixes.push("/" + Global.window.location.pathname.split("/")[1] + "/api/", "/" + Global.window.location.pathname.split("/")[1] + "/api/custom/", "/", "/service/",
				"/api/", "/api/custom/");
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
					if (JSObjectAdapter.$get(p1, "ping").equals("pong")) {
						me.selectedServer = guess;
						me.autoDetectFound = true;
						success.$invoke();
					}
				}
			}
		};
		Callback1<String> failureCheck = new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				if (p1 != null) {
					if (!p1.equals("")) {
						if (p1.contains("pong")) {
							me.selectedServer = guess;
							me.autoDetectFound = true;
							success.$invoke();
						}
					}
				}
			}
		};
		if (guess != null && guess.equals("") == false) {
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
					if (JSObjectAdapter.$get(p1, "ping").equals("pong")) {
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
					if (!p1.equals("")) {
						if (p1.contains("pong")) {
							me.selectedServer = guess;
							me.autoDetectFound = true;
						}
					}
				}
			}
		};
		if (guess != null && guess.equals("") == false) {
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
		EcRemote.getExpectingObject(selectedServer, "skyrepo/util/backup?secret=" + serverSecret, success, failure);
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
		EcRemote.getExpectingObject(selectedServer, "skyrepo/util/restore?secret=" + serverSecret, success, failure);
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
		EcRemote.getExpectingObject(selectedServer, "skyrepo/util/purge?secret=" + serverSecret, success, failure);
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
	 * @memberOf EcRepository
	 * @method handleSearchResults
	 * @private
	 */
	private Array<EcRemoteLinkedData> handleSearchResults(Array<EcRemoteLinkedData> results, final Callback1<EcRemoteLinkedData> eachSuccess,
	                                                      final Callback1<Array<EcRemoteLinkedData>> success) {
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

		EcRemote.getExpectingObject(selectedServer, service, new Callback1<Object>() {
			@Override
			public void $invoke(Object p1) {
				success.$invoke((Array<String>) p1);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				failure.$invoke("");
			}
		});
	}
}
