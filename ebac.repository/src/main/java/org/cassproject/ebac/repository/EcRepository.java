package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.dom.Document;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

/**
 * Repository object used to interact with the CASS Repository web services.
 * Should be used for all CRUD and search operations
 *
 * @module com.eduworks.ec
 * @class EcRepository
 *
 * @author fritz.ray@eduworks.com
 */
public class EcRepository
{

    public String selectedServer = null;
    public static boolean caching = false;
    public static boolean cachingSearch = false;
    public static Object cache = new Object();
    public static Object fetching = new Object();

    /**
     * Retrieves data from the server and caches it for use later during the
     * application. This should be called before the data is needed if possible,
     * so loading displays can be faster.
     *
     * @memberOf EcRepository
     * @method precache
     * @param {String[]} urls List of Data ID Urls that should be precached
     * @param {Callback0} success Callback triggered once all of the data has
     * been retrieved
     */
    public void precache(Array<String> urls, final Callback0 success)
    {
        if (urls == null || urls.$length() == 0)
        {
            if (success != null)
            {
                success.$invoke();
            }
            return;
        }

        Array<String> cacheUrls = new Array<String>();
        for (int i = 0; i < urls.$length(); i++)
        {
            String url = urls.$get(i);
            if (url.startsWith(selectedServer) && JSObjectAdapter.$get(cache, url) == null)
            {
                cacheUrls.push(url.replace(selectedServer, ""));
            }
        }
        if (cacheUrls.$length() == 0)
        {
            if (success != null)
            {
                success.$invoke();
            }
            return;
        }
        final FormData fd = new FormData();
        fd.append("data", Global.JSON.stringify(cacheUrls));
        final EcRepository me = this;
        EcIdentityManager.signatureSheetAsync(60000, selectedServer, new Callback1<String>()
        {
            @Override
            public void $invoke(String p1)
            {
                fd.append("signatureSheet", p1);
                EcRemote.postExpectingObject(me.selectedServer, "sky/repo/multiGet", fd, new Callback1<Object>()
                {
                    @Override
                    public void $invoke(Object p1)
                    {
                        Array<EcRemoteLinkedData> results = (Array<EcRemoteLinkedData>) p1;
                        for (int i = 0; i < results.$length(); i++)
                        {
                            EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
                            d.copyFrom(results.$get(i));
                            results.$set(i, d);
                            if (caching)
                            {
                                JSObjectAdapter.$put(cache, d.shortId(), d);
                                JSObjectAdapter.$put(cache, d.id, d);
                            }
                        }
                        if (success != null)
                        {
                            success.$invoke();
                        }
                    }
                }, null);
            }
        });
    }

    /**
     * Gets a JSON-LD object from the place designated by the URI.
     *
     * Uses a signature sheet gathered from {@link EcIdentityManager}.
     *
     * @memberOf EcRepository
     * @method get
     * @static
     * @param {String} url URL of the remote object.
     * @param {Callback1<EcRemoteLinkedData>}success Event to call upon
     * successful retrieval.
     * @param {Callback1<String>} failure Event to call upon spectacular
     * failure.
     */
    public static void get(final String url, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure)
    {
        if (caching)
        {
            if (JSObjectAdapter.$get(cache, url) != null)
            {
                if (EcRemote.async)
                {
                    Global.setTimeout(new Callback0()
                    {
                        @Override
                        public void $invoke()
                        {
                            success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, url));
                        }
                    }, 0);
                }
                else
                {
                    success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, url));
                }
                return;
            }
            if (EcRemote.async)
            {
                if (JSObjectAdapter.$get(fetching, url) != null)
                {
                    if ((Double) JSObjectAdapter.$get(fetching, url) > new Date().getTime())
                    {
                        Global.setTimeout(new Callback0()
                        {
                            @Override
                            public void $invoke()
                            {
                                get(url, success, failure);
                            }
                        }, 100);
                        return;
                    }
                }
                JSObjectAdapter.$put(fetching, url, new Date().getTime() + 60000);
            }
        }
        final FormData fd = new FormData();
        EcIdentityManager.signatureSheetAsync(60000, url, new Callback1<String>()
        {
            @Override
            public void $invoke(String p1)
            {
                if (JSObjectAdapter.$get(cache, url) != null)
                {
                    JSObjectAdapter.$properties(fetching).$delete(url);
                    success.$invoke((EcRemoteLinkedData) JSObjectAdapter.$get(cache, url));
                    return;
                }
                fd.append("signatureSheet", p1);
                EcRemote.postExpectingObject(url, null, fd, new Callback1<Object>()
                {
                    @Override
                    public void $invoke(Object p1)
                    {
                        JSObjectAdapter.$properties(fetching).$delete(url);
                        EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
                        d.copyFrom(p1);
                        if (d.getFullType() == null)
                        {
                            if (failure != null)
                            {
                                failure.$invoke(Global.JSON.stringify(p1));
                            }
                            return;
                        }
                        if (caching)
                        {
                            JSObjectAdapter.$put(cache, d.id, d);
                            JSObjectAdapter.$put(cache, d.shortId(), d);
                        }
                        success.$invoke(d);
                    }
                }, new Callback1<String>()
                {

                    @Override
                    public void $invoke(String p1)
                    {
                        JSObjectAdapter.$properties(fetching).$delete(url);
                        if (failure != null)
                        {
                            failure.$invoke(p1);
                        }
                    }
                });
            }
        });
    }

    /**
     * Retrieves a piece of data synchronously from the server, blocking until
     * it is returned
     *
     * @memberOf EcRepository
     * @method getBlocking
     * @static
     * @param {String} url URL ID of the data to be retrieved
     * @return {EcRemoteLinkedData} Data retrieved, corresponding to the ID
     */
    public static EcRemoteLinkedData getBlocking(final String url)
    {
        if (caching)
        {
            if (JSObjectAdapter.$get(cache, url) != null)
            {
                return (EcRemoteLinkedData) JSObjectAdapter.$get(cache, url);
            }
        }
        final FormData fd = new FormData();
        String p1 = EcIdentityManager.signatureSheet(60000, url);
        fd.append("signatureSheet", p1);
        boolean oldAsync = EcRemote.async;
        EcRemote.async = false;
        EcRemote.postExpectingObject(url, null, fd, new Callback1<Object>()
        {
            @Override
            public void $invoke(Object p1)
            {
                EcRemoteLinkedData d = new EcRemoteLinkedData("", "");
                d.copyFrom(p1);
                if (d.getFullType() == null)
                {
                    return;
                }
                JSObjectAdapter.$put(cache, url, d);
            }
        }, null);
        EcRemote.async = oldAsync;
        EcRemoteLinkedData result = (EcRemoteLinkedData) JSObjectAdapter.$get(cache, url);
        if (!caching)
        {
            JSObjectAdapter.$put(cache, url, null);
        }
        return result;
    }

    /**
     * Gets a JSON-LD object from the place designated by the URI.
     *
     * Uses a signature sheet gathered from {@link EcIdentityManager}.
     *
     * @memberOf EcRepository
     * @method get
     * @static
     * @param {String} url URL of the remote object.
     * @param {Callback1<EcRemoteLinkedData>}success Event to call upon
     * successful retrieval.
     * @param {Callback1<String>} failure Event to call upon spectacular
     * failure.
     */
    public void multiget(final Array<String> urls, final Callback1<Array<EcRemoteLinkedData>> success, final Callback1<String> failure, final Callback1<Array<EcRemoteLinkedData>> cachedValues)
    {
    	if (urls == null || urls.$length() == 0)
        {
            if (failure != null)
            {
                failure.$invoke("");
            }
            return;
        }
    	
        if (caching)
        {
        	Array<EcRemoteLinkedData> cachedVals = JSCollections.$array();
        	
        	for(int i = 0; i < urls.$length(); i++){
        		if (JSObjectAdapter.$get(cache, urls.$get(i)) != null)
                {
        			cachedVals.push((EcRemoteLinkedData)JSObjectAdapter.$get(cache, urls.$get(i)));
                }
        		
        		if(cachedValues != null)
        			cachedValues.$invoke(cachedVals);
        	}
        }
        
        Array<String> onServer = new Array<String>();
        for (int i = 0; i < urls.$length(); i++)
        {
            String url = urls.$get(i);
            if (url.startsWith(selectedServer))
            {
                onServer.push(url.replace(selectedServer, ""));
            }
        }
        
        final FormData fd = new FormData();
        fd.append("data", Global.JSON.stringify(onServer));
        final EcRepository me = this;
        EcIdentityManager.signatureSheetAsync(60000, selectedServer, new Callback1<String>()
        {
            @Override
            public void $invoke(String p1)
            {
                fd.append("signatureSheet", p1);
                EcRemote.postExpectingObject(me.selectedServer, "sky/repo/multiGet", fd, new Callback1<Object>()
                {
                    @Override
                    public void $invoke(Object p1)
                    {
                        Array<EcRemoteLinkedData> results = (Array<EcRemoteLinkedData>) p1;
                        for (int i = 0; i < results.$length(); i++)
                        {
                            EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
                            d.copyFrom(results.$get(i));
                            results.$set(i, d);
                            if (caching)
                            {
                                JSObjectAdapter.$put(cache, d.shortId(), d);
                                JSObjectAdapter.$put(cache, d.id, d);
                            }
                        }
                        if (success != null)
                        {
                            success.$invoke(results);
                        }
                    }
                }, failure);
            }
        });
      
    }
    
    /**
     * Search a repository for JSON-LD compatible data.
     *
     * Uses a signature sheet gathered from {@link EcIdentityManager}.
     *
     * @memberOf EcRepository
     * @method search
     * @param {String} query ElasticSearch compatible query string, similar to
     * Google query strings.
     * @param {Callback1<EcRemoteLinkedData>} eachSuccess Success event for each
     * found object.
     * @param {Callback1<EcRemoteLinkedData[]>} success Success event, called
     * after eachSuccess.
     * @param {Callback1<String>} failure Failure event.
     */
    public void search(String query, final Callback1<EcRemoteLinkedData> eachSuccess, final Callback1<Array<EcRemoteLinkedData>> success,
            final Callback1<String> failure)
    {
        searchWithParams(query, null, eachSuccess, success, failure);
    }

    /**
     * Search a repository for JSON-LD compatible data.
     *
     * Uses a signature sheet gathered from {@link EcIdentityManager}.
     *
     * @memberOf EcRepository
     * @method searchWithParams
     * @param {String} query ElasticSearch compatible query string, similar to
     * Google query strings.
     * @param {Object} paramObj Additional parameters that can be used to tailor
     * the search.
     * @param size
     * @param start
     * @param {Callback1<EcRemoteLinkedData>} eachSuccess Success event for each
     * found object.
     * @param {Callback1<EcRemoteLinkedData[]>} success Success event, called
     * after eachSuccess.
     * @param {Callback1<String>} failure Failure event.
     */
    public void searchWithParams(final String originalQuery, final Object originalParamObj, final Callback1<EcRemoteLinkedData> eachSuccess,
            final Callback1<Array<EcRemoteLinkedData>> success, final Callback1<String> failure)
    {
        String query = originalQuery;
        Object paramObj = originalParamObj;
        if (paramObj == null)
        {
            paramObj = new Object();
        }

        Object params = new Object();
        Map<String, Object> paramProps = JSObjectAdapter.$properties(params);
        if (JSObjectAdapter.$get(paramObj, "start") != null)
        {
            paramProps.$put("start", JSObjectAdapter.$get(paramObj, "start"));
        }
        if (JSObjectAdapter.$get(paramObj, "size") != null)
        {
            paramProps.$put("size", JSObjectAdapter.$get(paramObj, "size"));
        }
        if (JSObjectAdapter.$get(paramObj, "types") != null)
        {
            paramProps.$put("types", JSObjectAdapter.$get(paramObj, "types"));
        }

        if (JSObjectAdapter.$get(paramObj, "ownership") != null)
        {
            String ownership = (String) JSObjectAdapter.$get(paramObj, "ownership");
            if (!query.startsWith("(") || !query.endsWith(")"))
            {
                query = "(" + query + ")";
            }

            if (ownership.equals("public"))
            {
                query += " AND (_missing_:@owner)";
            }
            else if (ownership.equals("owned"))
            {
                query += " AND (_exists_:@owner)";
            }
            else if (ownership.equals("me"))
            {
                query += " AND (";
                for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
                {
                    if (i != 0)
                    {
                        query += " OR ";
                    }
                    EcIdentity id = EcIdentityManager.ids.$get(i);

                    query += "@owner:\"" + id.ppk.toPk().toPem() + "\"";
                }

                query += ")";
            }
        }

        if (JSObjectAdapter.$get(paramObj, "fields") != null)
        {
            paramProps.$put("fields", JSObjectAdapter.$get(paramObj, "fields"));
        }

        final String cacheKey;
        if (cachingSearch)
        {
            cacheKey = JSGlobal.JSON.stringify(paramProps) + query;
            if (JSObjectAdapter.$get(cache, cacheKey) != null)
            {
                handleSearchResults((Array<EcRemoteLinkedData>) JSObjectAdapter.$get(cache, cacheKey), eachSuccess, success);
                return;
            }
            final EcRepository me = this;
            if (EcRemote.async)
            {
                if (JSObjectAdapter.$get(fetching, cacheKey) != null)
                {
                    if ((Double) JSObjectAdapter.$get(fetching, cacheKey) > new Date().getTime())
                    {
                        Global.setTimeout(new Callback0()
                        {
                            @Override
                            public void $invoke()
                            {
                                me.searchWithParams(originalQuery, originalParamObj, eachSuccess, success, failure);
                            }
                        }, 100);
                        return;
                    }
                }
                JSObjectAdapter.$put(fetching, cacheKey, new Date().getTime() + 60000);
            }
        }
        else
        {
            cacheKey = null;
        }

        final FormData fd = new FormData();
        fd.append("data", query);
        if (params != null)
        {
            fd.append("searchParams", Global.JSON.stringify(params));
        }
        final EcRepository me = this;
        EcIdentityManager.signatureSheetAsync(60000, selectedServer, new Callback1<String>()
        {
            @Override
            public void $invoke(String signatureSheet)
            {
                fd.append("signatureSheet", signatureSheet);
                EcRemote.postExpectingObject(me.selectedServer, "sky/repo/search", fd, new Callback1<Object>()
                {
                    @Override
                    public void $invoke(Object p1)
                    {
                        if (cachingSearch)
                        {
                            JSObjectAdapter.$put(cache, cacheKey, p1);
                        }
                        if (cacheKey != null)
                        {
                            JSObjectAdapter.$properties(fetching).$delete(cacheKey);
                        }

                        me.handleSearchResults((Array<EcRemoteLinkedData>) p1, eachSuccess, success);
                    }
                }, new Callback1<String>()
                {

                    @Override
                    public void $invoke(String p1)
                    {
                        if (cacheKey != null)
                        {
                            JSObjectAdapter.$properties(fetching).$delete(cacheKey);
                        }
                        if (failure != null)
                        {
                            failure.$invoke(p1);
                        }
                    }
                });
            }
        });
    }

    /**
     * Searches known repository endpoints to set the server configuration for
     * this repositories instance
     *
     * @memberOf EcRepository
     * @method autoDetectRepository
     */
    public void autoDetectRepository()
    {
        EcRemote.async = false;
        Array<String> protocols = new Array<String>();
        if (Global.window != null)
        {
            if (Global.window.location != null)
            {
                if (Global.window.location.protocol == "https:")
                {
                    protocols.push("https:");
                }
            }
        }
        if (Global.window != null)
        {
            if (Global.window.location != null)
            {
                if (Global.window.location.protocol == "http:")
                {
                    protocols.push("http:");
                    protocols.push("https:");
                }
            }
        }
        if (protocols.$length() == 0)
        {
            protocols.push("https:");
            protocols.push("http:");
        }
        Array<String> hostnames = new Array<String>();
        Array<String> servicePrefixes = new Array<String>();

        if (selectedServer != null)
        {
            Element e = Global.window.document.createElement("a");
            JSObjectAdapter.$put(e,"href",selectedServer);
            hostnames.push((String)JSObjectAdapter.$get(e,"host"));
            servicePrefixes.push((String)JSObjectAdapter.$get(e,"pathname"));
        }

        if (Global.window.location.host != null)
        {
            hostnames.push(Global.window.location.host, Global.window.location.host.replace(".", ".service."), Global.window.location.host + ":8080",
                    Global.window.location.host.replace(".", ".service.") + ":8080");
        }

        if (Global.window.location.hostname != null)
        {
            hostnames.push(Global.window.location.hostname, Global.window.location.hostname.replace(".", ".service."),
                    Global.window.location.hostname + ":8080", Global.window.location.hostname.replace(".", ".service.") + ":8080");
        }

        hostnames.push("localhost", "localhost" + ":8080", "localhost" + ":9722");

        servicePrefixes.push("/" + Global.window.location.pathname.split("/")[1] + "/api/custom/", "/", "/service/",
                "/api/custom/");
        for (int j = 0; j < hostnames.$length(); j++)
        {
            for (int k = 0; k < servicePrefixes.$length(); k++)
            {
                for (int i = 0; i < protocols.$length(); i++)
                {
                    if (autoDetectRepositoryActual(protocols.$get(i) + "//" + hostnames.$get(j) + servicePrefixes.$get(k).replaceAll("//", "/")))
                    {
                        EcRemote.async = true;
                        return;
                    }
                }
            }
        }
        EcRemote.async = true;
    }

    public boolean autoDetectFound = false;

    /**
     * Handles the actual detection of repository endpoint /ping service
     *
     * @memberOf EcRepository
     * @method autoDetectRepository
     * @private
     * @param {String} guess The server prefix
     * @return {boolean} Whether the detection successfully found the endpoint
     */
    private boolean autoDetectRepositoryActual(final String guess)
    {
        final EcRepository me = this;
        Callback1<Object> successCheck = new Callback1<Object>()
        {
            @Override
            public void $invoke(Object p1)
            {
                if (p1 != null)
                {
                    if (JSObjectAdapter.$get(p1, "ping").equals("pong"))
                    {
                        me.selectedServer = guess;
                        me.autoDetectFound = true;
                    }
                }
            }
        };
        Callback1<String> failureCheck = new Callback1<String>()
        {
            @Override
            public void $invoke(String p1)
            {
                if (p1 != null)
                {
                    if (!p1.equals(""))
                    {
                        if (p1.contains("pong"))
                        {
                            me.selectedServer = guess;
                            me.autoDetectFound = true;
                        }
                    }
                }
            }
        };
        if (guess != null && guess.equals("") == false)
        {
            try
            {
                EcRemote.getExpectingObject(guess, "ping", successCheck, failureCheck);
            }
            catch (Exception ex)
            {

            }
        }
        return autoDetectFound;
    }

    /**
     * Lists all types visible to the current user in the repository
     *
     * Uses a signature sheet gathered from {@link EcIdentityManager}.
     *
     * @memberOf EcRepository
     * @method listTypes
     * @param {Callback1<Object[]>} success Success event
     * @param {Callback1<String>} failure Failure event.
     */
    public void listTypes(final Callback1<Array<Object>> success, final Callback1<String> failure)
    {
        FormData fd = new FormData();
        fd.append("signatureSheet", EcIdentityManager.signatureSheet(60000, selectedServer));
        EcRemote.postExpectingObject(selectedServer, "sky/repo/types", fd, new Callback1<Object>()
        {
            @Override
            public void $invoke(Object p1)
            {
                Array<Object> results = (Array<Object>) p1;

                if (success != null)
                {
                    success.$invoke(results);
                }
            }
        }, failure);
    }

    /**
     * Handles the search results in search by params, before returning them
     * with the callback passed into search method
     *
     * @memberOf EcRepository
     * @method handleSearchResults
     * @private
     * @param {EcRemoteLinkedData[]} results Results to handle before returning
     * @param {Callback1<EcRemoteLinkedData>} eachSuccess Callback function to
     * trigger for each search result
     * @param {Callback1<EcRemoteLinkedData[]>} success Callback function to
     * trigger with all search results
     */
    private void handleSearchResults(Array<EcRemoteLinkedData> results, final Callback1<EcRemoteLinkedData> eachSuccess,
            final Callback1<Array<EcRemoteLinkedData>> success)
    {
        for (int i = 0; i < results.$length(); i++)
        {
            EcRemoteLinkedData d = new EcRemoteLinkedData(null, null);
            d.copyFrom(results.$get(i));
            results.$set(i, d);
            if (caching)
            {
                JSObjectAdapter.$put(cache, d.shortId(), d);
            }
            if (eachSuccess != null)
            {
                eachSuccess.$invoke(results.$get(i));
            }
        }

        if (success != null)
        {
            success.$invoke(results);
        }
    }

    /**
     * Escapes a search query
     *
     * @memberOf EcRepository
     * @method escapeSearch
     * @static
     * @param {String} query Query string to escape
     * @return {String} Escaped query string
     */
    public static String escapeSearch(String query)
    {
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
     *
     * Uses a signature sheet informed by the owner field of the data.
     *
     * @memberOf EcRepository
     * @method save
     * @static
     * @param {EcRemoteLinkedData} data Data to save to the location designated
     * by its id.
     * @param {Callback1<String>} success Callback triggered on successful save
     * @param {Callback1<String>} failure Callback triggered if error during
     * save
     */
    public static void save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
    {
        Global.console.warn("Using EcRepository 'save' method, if this is intentional consider calling '_save'");
        _save(data, success, failure);
    }

    /**
     * Attempts to save a piece of data. Does some checks before saving to
     * ensure the data is valid. This version does not send a console warning,
     *
     * Uses a signature sheet informed by the owner field of the data.
     *
     * @memberOf EcRepository
     * @method _save
     * @static
     * @param {EcRemoteLinkedData} data Data to save to the location designated
     * by its id.
     * @param {Callback1<String>} success Callback triggered on successful save
     * @param {Callback1<String>} failure Callback triggered if error during
     * save
     */
    public static void _save(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
    {
        if (data.invalid())
        {
            String msg = "Cannot save data. It is missing a vital component.";
            if (failure != null)
            {
                failure.$invoke(msg);
            }
            else
            {
                Global.console.error(msg);
            }
            return;
        }

        if (data.reader != null && data.reader.$length() == 0)
        {
            JSObjectAdapter.$properties(data).$delete("reader");
        }

        if (data.owner != null && data.owner.$length() == 0)
        {
            JSObjectAdapter.$properties(data).$delete("owner");
        }

        if (EcEncryptedValue.encryptOnSave(data.id, null))
        {
            EcEncryptedValue encrypted = EcEncryptedValue.toEncryptedValue(data, false);
            EcIdentityManager.sign(data);
            _saveWithoutSigning(data, success, failure);
        }
        else
        {
            EcIdentityManager.sign(data);
            _saveWithoutSigning(data, success, failure);
        }
    }

    /**
     * Attempts to save a piece of data without signing it.
     *
     * Uses a signature sheet informed by the owner field of the data.
     *
     * @memberOf EcRepository
     * @method _saveWithoutSigning
     * @static
     * @param {EcRemoteLinkedData} data Data to save to the location designated
     * by its id.
     * @param {Callback1<String>} success Callback triggered on successful save
     * @param {Callback1<String>} failure Callback triggered if error during
     * save
     */
    private static void _saveWithoutSigning(final EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
    {

        if (caching)
        {
            JSObjectAdapter.$properties(cache).$delete(data.id);
            JSObjectAdapter.$properties(cache).$delete(data.shortId());
        }
        if (data.invalid())
        {
            failure.$invoke("Data is malformed.");
            return;
        }

        data.updateTimestamp();

        final FormData fd = new FormData();
        fd.append("data", data.toJson());
        if (data.owner != null && data.owner.$length() > 0)
        {
            EcIdentityManager.signatureSheetForAsync(data.owner, 60000, data.id, new Callback1<String>()
            {
                @Override
                public void $invoke(String arg0)
                {
                    fd.append("signatureSheet", arg0);
                    EcRemote.postExpectingString(data.id, "", fd, success, failure);
                }
            });
        }
        else
        {
            EcIdentityManager.signatureSheetAsync(60000, data.id, new Callback1<String>()
            {
                @Override
                public void $invoke(String arg0)
                {
                    fd.append("signatureSheet", arg0);
                    EcRemote.postExpectingString(data.id, "", fd, success, failure);
                }
            });
        }

    }

    /**
     * Attempts to delete a piece of data.
     *
     * Uses a signature sheet informed by the owner field of the data.
     *
     * @memberOf EcRepository
     * @method _delete
     * @static
     * @param {EcRemoteLinkedData} data Data to save to the location designated
     * by its id.
     * @param {Callback1<String>} success Callback triggered on successful
     * delete
     * @param {Callback1<String>} failure Callback triggered if error during
     * delete
     */
    public static void _delete(EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
    {
        DELETE(data, success, failure);
    }

    /**
     * Attempts to delete a piece of data.
     *
     * Uses a signature sheet informed by the owner field of the data.
     *
     * @memberOf EcRepository
     * @method DELETE
     * @static
     * @param {EcRemoteLinkedData} data Data to save to the location designated
     * by its id.
     * @param {Callback1<String>} success Callback triggered on successful
     * delete
     * @param {Callback1<String>} failure Callback triggered if error during
     * delete
     */
    public static void DELETE(final EcRemoteLinkedData data, final Callback1<String> success, final Callback1<String> failure)
    {
        if (caching)
        {
            JSObjectAdapter.$properties(cache).$delete(data.id);
            JSObjectAdapter.$properties(cache).$delete(data.shortId());
        }
        EcIdentityManager.signatureSheetAsync(60000, data.id, new Callback1<String>()
        {
            @Override
            public void $invoke(String signatureSheet)
            {
                EcRemote._delete(data.shortId(), signatureSheet, success, failure);
            }
        });
    }
}
