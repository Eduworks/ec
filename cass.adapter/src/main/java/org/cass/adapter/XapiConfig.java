package org.cass.adapter;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

/**
 * Object that holds the xAPI Adapter configuration values returned
 * from the server and provides methods for saving new config values
 *
 * @author devlin.junker@eduworks.com
 * @module org.cassproject
 * @class XapiConfig
 * @constructor
 */
public class XapiConfig extends EcLinkedData {

	public boolean enabled;

	public String xapiAuth;

	public String xapiEndpoint;
	public String xapiHostName;

	public XapiConfig() {
		super(null, null);
	}

	/**
	 * Retrieves the adapter configuration values from the server
	 *
	 * @param serverUrl URL of server to save configuration values to
	 * @param success   Callback triggered on successfully retrieving config values to server
	 * @param failure   Callback triggered if an error occurs while getting the config values
	 * @memberOf XapiConfig
	 * @method get
	 * @static
	 */
	public static void get(final String serverUrl, final Callback1<Object> success, final Callback1<String> failure) {
		final FormData fd = new FormData();
		EcIdentityManager.signatureSheetAsync(60000, serverUrl, new Callback1<String>() {
			@Override
			public void $invoke(String signatureSheet) {
				fd.append("signatureSheet", signatureSheet);
				EcRemote.postExpectingObject(serverUrl, "adapter/xapi/config/get", fd, success, failure);
			}
		},failure);
	}

	/**
	 * Saves this config Objects configuration values to the server specified
	 *
	 * @param serverUrl URL of server to save configuration values to
	 * @param success   Callback triggered on successfully saving config values to server
	 * @param failure   Callback triggered if an error occurs while saving the config values
	 * @memberOf XapiConfig
	 * @method save
	 */
	public void save(final String serverUrl, final Callback1<Object> success, final Callback1<String> failure) {
		final FormData fd = new FormData();
		fd.append("config", Global.JSON.stringify(this));
		EcIdentityManager.signatureSheetAsync(60000, serverUrl, new Callback1<String>() {
			@Override
			public void $invoke(String signatureSheet) {
				fd.append("signatureSheet", signatureSheet);
				EcRemote.postExpectingObject(serverUrl, "adapter/xapi/config/set", fd, success, failure);
			}
		},failure);

	}

}
