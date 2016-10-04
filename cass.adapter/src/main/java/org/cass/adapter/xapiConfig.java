package org.cass.adapter;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

public class xapiConfig extends EcLinkedData {

	public boolean enabled;
	
	public String xapiAuth;
	
	public String xapiEndpoint;
	public String xapiHostName;
	
	public xapiConfig() {
		super(null, null);
	}
	
	public void save(String serverUrl, Callback1<Object> success, Callback1<String> failure){
		FormData fd = new FormData();
		fd.append("config", Global.JSON.stringify(this));
		
		EcRemote.postExpectingObject(serverUrl, "adapter/xapi/config/set", fd, success, failure);
	}
	
	public static void get(String serverUrl, Callback1<Object> success, Callback1<String> failure){
		EcRemote.getExpectingObject(serverUrl, "adapter/xapi/config/get", success, failure);
	}

}
