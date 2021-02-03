package com.eduworks.ec.remote;

import org.stjs.javascript.*;
import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback3;

import static org.stjs.javascript.JSGlobal.JSON;

/**
 * Wrapper to handle all remote web service invocations.
 *
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 * @class EcRemote
 * @module com.eduworks.ec
 */
public class EcRemote {

    /**
     * Turn this property off to cause all remote web service calls to be
     * synchronous. Can be useful for test scripts, blocking calls, etc.
     *
     * @property async
     * @static
     * @type boolean
     */
    public static boolean async = true;

    /**
     * Timeout for AJAX requests
     *
     * @property async
     * @static
     * @type boolean
     */
    public static int timeout = 60 * 1000 * 5;

    /**
     * POSTs a request to a remote endpoint. Composed of a server endpoint (root
     * URL) and a service (service path). Sends form data as a multi-part mime
     * request.
     *
     * @param {string}           server Protocol, hostname and path to the remote handler.
     * @param {string}           service Path to service to invoke.
     * @param {FormData}         fd Form data to send as multi-part mime.
     * @param {function(object)} success Method that is invoked if the server
     *                           responds with a success (per jQuery ajax)
     * @param {function(string)} failure Method that is invoked if the server
     *                           responds with an error (per jQuery ajax) or a non-200/300.
     * @method postExpectingObject
     * @static
     */
    public static void postExpectingObject(String server, String service, FormData fd, final Callback1<Object> success, final Callback1<String> failure) {
        postInner(server, service, fd, null, getSuccessJSONCallback(success, failure), failure);
    }

    /**
     * POSTs a request to a remote endpoint. Composed of a server endpoint (root
     * URL) and a service (service path). Sends form data as a multi-part mime
     * request.
     *
     * @param {string}           server Protocol, hostname and path to the remote handler.
     * @param {string}           service Path to service to invoke.
     * @param {FormData}         fd Form data to send as multi-part mime.
     * @param {function(string)} success Method that is invoked if the server
     *                           responds with a success (per jQuery ajax)
     * @param {function(string)} failure Method that is invoked if the server
     *                           responds with an error (per jQuery ajax) or a non-200/300.
     * @method postExpectingString
     * @static
     */
    public static void postExpectingString(String server, String service, FormData fd, final Callback1<String> success, final Callback1<String> failure) {
        postInner(server, service, fd, null, success, failure);
    }

    /**
     * POSTs a request to a remote endpoint. Composed of a server endpoint (root
     * URL) and a service (service path). Sends form data as a multi-part mime
     * request. Includes headers.
     *
     * @param {string}           server Protocol, hostname and path to the remote handler.
     * @param {string}           service Path to service to invoke.
     * @param {FormData}         fd Form data to send as multi-part mime.
     * @param {Object}           headers Headers to attach to the HTTP post.
     * @param {function(string)} success Method that is invoked if the server
     *                           responds with a success (per jQuery ajax)
     * @param {function(string)} failure Method that is invoked if the server
     *                           responds with an error (per jQuery ajax) or a non-200/300.
     * @method postWithHeadersExpectingString
     * @static
     */
    public static void postWithHeadersExpectingString(String server, String service, FormData fd, Map<String, String> headers,
                                                      final Callback1<String> success, final Callback1<String> failure) {
        postInner(server, service, fd, headers, success, failure);
    }


    private static void postInner(String server, String service, FormData fd, Map<String, String> headers,
                                  final Callback1<String> successCallback, final Callback1<String> failureCallback) {
        String url = server;
        if (!url.endsWith("/") && service != null && !"".equals(service)) {
            url += "/";
        }
        if (service != null) {
            url += service;
        }

        url = upgradeHttpToHttps(url);

        XMLHttpRequest xhr = null;

        String theBoundary = null;
        // Node JS serialization check.
        if (JSObjectAdapter.$get(fd, "_streams") != null) {
            // We're in node. Serialize the 'form-data' object by hand.
            Array<String> chunks = (Array<String>) JSObjectAdapter.$get(fd, "_streams");
            String all = "";
            for (int i = 0; i < chunks.$length(); i++) {
                if (JSGlobal.typeof(chunks.$get(i)) == "function") {
                    all = all + "\r\n";
                } else {
                    all = all + chunks.$get(i);
                }
            }
            all = all + "\r\n" + "\r\n" + "--" + JSObjectAdapter.$get(fd, "_boundary") + "--";
            theBoundary = (String) JSObjectAdapter.$get(fd, "_boundary");
            if (Global.typeof(EcLevrHttp.httpStatus) == "undefined")
                xhr.setRequestHeader("Content-Type", "multipart/form-data; boundary=" + JSObjectAdapter.$get(fd, "_boundary"));
            fd = (FormData) (Object) all;
        } else {
            // We're in a browser.rhin
//			p.mimeType = "multipart/form-data";
//			p.data = fd;
//			if (headers != null && headers != JSGlobal.undefined)
//				p.headers = headers;
        }
        if (Global.typeof(EcNodeJs.isNodeJs) != "undefined" && EcRemote.async)
        {
            if (headers == null) headers = (Map<String,String>)new Object();
            JSObjectAdapter.$put(headers,"Content-Type","multipart/form-data; boundary=" + theBoundary);
            Object requestObject = new Object();
            JSObjectAdapter.$put(requestObject,"method","POST");
            JSObjectAdapter.$put(requestObject,"url",url);
            JSObjectAdapter.$put(requestObject,"headers",headers);
            JSObjectAdapter.$put(requestObject,"body",fd);
            EcNodeJs.request(requestObject,new Callback3<String,Object,String>(){
                @Override
                public void $invoke(String error, Object response, String body) {
                    if (failureCallback != null && error != null) failureCallback.$invoke(error);
                    else if (failureCallback != null && JSObjectAdapter.$get(response,"statusCode") != (Object)200)
                        failureCallback.$invoke(body);
                    else if (successCallback != null)
                        successCallback.$invoke(body);
                }
            });
            return;
        }

        if (Global.typeof(EcLevrHttp.httpStatus) == "undefined") {
            xhr = new XMLHttpRequest();
            xhr.open("POST", url, async);

            final XMLHttpRequest xhrx = xhr;
            xhr.onreadystatechange = new Callback0() {
                @Override
                public void $invoke() {
                    if (xhrx.readyState == 4 && xhrx.status == 200) {
                        if (successCallback != null)
                            successCallback.$invoke(xhrx.responseText);
                    } else if (xhrx.readyState == 4) {
                        if (failureCallback != null)
                            failureCallback.$invoke(xhrx.responseText);
                    }
                }
            };
        }

        if (xhr != null)
            if (async)
                JSObjectAdapter.$put(xhr, "timeout", timeout);
//		JSObjectAdapter.$put(xhr, "withCredentials", true);

        if (Global.typeof(EcLevrHttp.httpStatus) != "undefined") {
            String result = JSON.stringify(EcLevrHttp.httpPost(fd, url, "multipart/form-data; boundary=" + theBoundary, "false", theBoundary));
            if (successCallback != null)
                successCallback.$invoke(result);
        } else {
            xhr.send((String) (Object) fd);
        }
    }

    /**
     * GETs something from a remote endpoint. Composed of a server endpoint
     * (root URL) and a service (service path).
     *
     * @param {string}           server Protocol, hostname and path to the remote handler.
     * @param {string}           service Path to service to invoke.
     * @param {function(object)} success Method that is invoked if the server
     *                           responds with a success (per jQuery ajax)
     * @param {function(string)} failure Method that is invoked if the server
     *                           responds with an error (per jQuery ajax) or a non-200/300.
     * @method getExpectingObject
     * @static
     */
    public static void getExpectingObject(String server, String service, final Callback1<Object> success, final Callback1<String> failure) {
        getExpectingString(server, service, getSuccessJSONCallback(success, failure), failure);
    }

    /**
     * GETs something from a remote endpoint. Composed of a server endpoint
     * (root URL) and a service (service path).
     *
     * @param {string}           server Protocol, hostname and path to the remote handler.
     * @param {string}           service Path to service to invoke.
     * @param {function(object)} success Method that is invoked if the server
     *                           responds with a success (per jQuery ajax)
     * @param {function(string)} failure Method that is invoked if the server
     *                           responds with an error (per jQuery ajax) or a non-200/300.
     * @method getExpectingString
     * @static
     */
    public static void getExpectingString(String server, String service, final Callback1<String> success, final Callback1<String> failure) {
        String url = urlAppend(server, service);

        url = upgradeHttpToHttps(url);

        XMLHttpRequest xhr = null;

        if (Global.typeof(EcLevrHttp.httpStatus) == "undefined") {
            xhr = new XMLHttpRequest();

            xhr.open("GET", url, async);
            final XMLHttpRequest xhrx = xhr;
            xhr.onreadystatechange = new Callback0() {
                @Override
                public void $invoke() {
                    if (xhrx.readyState == 4 && xhrx.status == 200)
                        if (success != null)
                        success.$invoke(xhrx.responseText);
                    else if (xhrx.readyState == 4)
                        if (failure != null)
                        failure.$invoke(xhrx.responseText);
                }
            };
            xhr.onerror = new Callback1<DOMEvent>() {
                @Override
                public void $invoke(DOMEvent e) {
                    if (failure != null) {
                        failure.$invoke(null);
                    }
                }
            };
        }

        if (Global.typeof(EcNodeJs.isNodeJs) != "undefined" && EcRemote.async)
        {
            Object requestObject = new Object();
            JSObjectAdapter.$put(requestObject,"method","GET");
            JSObjectAdapter.$put(requestObject,"url",url);
            EcNodeJs.request(requestObject,new Callback3<String,Object,String>(){
                @Override
                public void $invoke(String error, Object response, String body) {
                    if (failure != null && error != null) failure.$invoke(error);
                    else if (failure != null && JSObjectAdapter.$get(response,"statusCode") != (Object)200)
                        failure.$invoke(body);
                    else if (success != null)
                        success.$invoke(body);
                }
            });
            return;
        }

        if (xhr != null) {
            if (async)
                JSObjectAdapter.$put(xhr, "timeout", timeout);
        }
//		JSObjectAdapter.$put(xhr, "withCredentials", true);

        if (Global.typeof(EcLevrHttp.httpStatus) != "undefined") {
            if (success != null)
            success.$invoke(JSON.stringify(EcLevrHttp.httpGet(url)));
        } else {
            xhr.send();
        }
    }

    public static String urlAppend(String server, String service) {
        String url = server;
        if (!url.endsWith("/") && service != null && service.equals("")) {
            url += "/";
        }
        if (service != null) {
            url += service;
        }
        return url;
    }

    /**
     * DELETEs something at a remote endpoint. Composed of a server endpoint
     * (root URL) and a service (service path).
     *
     * @param {string}           server Protocol, hostname and path to the remote handler.
     * @param {string}           service Path to service to invoke.
     * @param {function(object)} success Method that is invoked if the server
     *                           responds with a success (per jQuery ajax)
     * @param {function(string)} failure Method that is invoked if the server
     *                           responds with an error (per jQuery ajax) or a non-200/300.
     * @method _delete
     * @static
     */
    public static void _delete(String url, String signatureSheet, final Callback1<String> success, final Callback1<String> failure) {
        url = upgradeHttpToHttps(url);

        XMLHttpRequest xhr = null;

        if (Global.typeof(EcLevrHttp.httpStatus) == "undefined") {
            xhr = new XMLHttpRequest();

            //		JSObjectAdapter.$put(xhr, "withCredentials", true);
            xhr.open("DELETE", url, async);
            final XMLHttpRequest xhrx = xhr;
            xhr.onreadystatechange = new Callback0() {
                @Override
                public void $invoke() {
                    if (xhrx.readyState == 4 && xhrx.status == 200) {
                        if (success != null)
                            success.$invoke(xhrx.responseText);
                    } else if (xhrx.readyState == 4) {
                        if (failure != null)
                            failure.$invoke(xhrx.responseText);
                    }
                }
            };
        }

        if (Global.typeof(EcNodeJs.isNodeJs) != "undefined" && EcRemote.async)
        {
            Object sso = new Object();
            JSObjectAdapter.$put(sso,"signatureSheet",signatureSheet);
            Object requestObject = new Object();
            JSObjectAdapter.$put(requestObject,"method","DELETE");
            JSObjectAdapter.$put(requestObject,"url",url);
            JSObjectAdapter.$put(requestObject,"headers",sso);
            EcNodeJs.request(requestObject,new Callback3<String,Object,String>(){
                @Override
                public void $invoke(String error, Object response, String body) {
                    if (failure != null && error != null) failure.$invoke(error);
                    else if (failure != null && JSObjectAdapter.$get(response,"statusCode") != (Object)200)
                        failure.$invoke(body);
                    else if (success != null)
                        success.$invoke(body);
                }
            });
            return;
        }

        if (xhr != null){
            if (async)
                JSObjectAdapter.$put(xhr, "timeout", timeout);
            xhr.setRequestHeader("signatureSheet", signatureSheet);
        }
        if (Global.typeof(EcLevrHttp.httpStatus) != "undefined") {
            if (success != null){
                Object sso = new Object();
                JSObjectAdapter.$put(sso,"signatureSheet",signatureSheet);
                success.$invoke(EcLevrHttp.httpDelete(url,null,null,null,sso));
            }
        } else {
            xhr.send();
        }
    }

    protected static String upgradeHttpToHttps(String url) {
        // Upgrade protocol to avoid mixed active content
        if (Global.window != null) {
            if (Global.window.location != null) {
                if (url.indexOf(Global.window.location.protocol) == -1) {
                    if (Global.window.location.protocol.startsWith("https")) {
                        if (!url.startsWith("https:")) {
                            url = url.replace("http:", "https:");
                        }
                    }
                }
            }
        }
        return url;
    }

    protected static Callback1<String> getSuccessJSONCallback(final Callback1<Object> success, final Callback1<String> failure) {
        return new Callback1<String>() {
            @Override
            public void $invoke(String s) {
                final Object o;
                try {
                    o = JSON.parse(s);
                } catch (Exception ex) {
                    if (ex == null)
                        failure.$invoke("An unspecified error occurred during a network request.");
                    else
                        failure.$invoke((String) (Object) ex);
                    return;
                }
                success.$invoke(o);
            }
        };
    }

}
