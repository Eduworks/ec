package com.eduworks.ec.remote;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Interface to functions from com.eduworks.ew, presuming the javascript is being run in an EW environment.
 *
 * To use, first detect if you are in an com.eduworks.ew environment by seeing if httpStatus exists (!= null)
 * Then, you can use the methods below. the methods listed below invoke EW Crunchers.
 *
 * @author fritz.ray@eduworks.com
 * @class EcLevrHttp
 */
@GlobalScope
@STJSBridge()
public class EcLevrHttp {

	/**
	 * @static
	 * @method ewExists
	 * @return True if in a com.eduworks.ew environment.
	 */
	public static boolean ewExists(){return httpStatus != null;}

	/***
	 * Method handle for httpStatus. Use .call if necessary to invoke.
	 */
	public static Object httpStatus;

	/***
	 * HTTP Post method from com.eduworks.ew package. Blocking method.
	 * @param {String} data Payload for HTTP Post. Form Data is allowed. See EcRemote.postInner() for usage example.
	 * @param {String} url HTTP Endpoint to communicate with.
	 * @param {String} contentType Content type of the data, if not Form Data.
	 * @param {String} multipart Multipart flag, "true" or "false" -- not sure why this is a string.
	 * @param {String} name Name of the boundary being used in a multipart post.
	 * @return {Object} Result from the HTTP Post. May be JSON or a String or a file, depending on the response.
	 * @static
	 * @method httpPost
	 */
	public static Object httpPost(Object data, String url, String contentType, String multipart, String name) {
		return null;
	}

	/***
	 * HTTP Get method from com.eduworks.ew package. Blocking method.
	 * @param {String} url HTTP Endpoint to communicate with.
	 * @return {Object} Result from the HTTP Get. May be JSON or a String or a file, depending on the response.
	 * @static
	 * @method httpGet
	 */
	public static Object httpGet(String url) {
		return null;
	}

	/***
	 * HTTP Delete method from com.eduworks.ew package. Blocking method.
	 * @param {String} url HTTP Endpoint to communicate with.
	 * @param {String} contentType Content type? Set to null.
	 * @param {String} name Name? Why? Set to null.
	 * @param {String} authToken Basic Auth token
	 * @param {Object} headers Key value pairs of headers to send.
	 * @return {String} Response from server.
	 * @static
	 * @method httpDelete
	 */
	public static String httpDelete(String url, String contentType, String name, String authToken, Object headers) {
		return null;
	}
}
