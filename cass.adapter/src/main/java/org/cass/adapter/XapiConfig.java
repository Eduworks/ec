package org.cass.adapter;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

public class XapiConfig extends EcLinkedData {

	public boolean enabled;
	
	public String xapiAuth;
	
	public String xapiEndpoint;
	public String xapiHostName;
	
	public XapiConfig() {
		super(null, null);
	}
	
	public void save(final String serverUrl, final Callback1<Object> success, final Callback1<String> failure){		
		final FormData fd = new FormData();
		fd.append("config", Global.JSON.stringify(this));
		EcIdentityManager.signatureSheetAsync(60000, serverUrl, new Callback1<String>()
		{
			@Override
			public void $invoke(String signatureSheet)
			{
				fd.append("signatureSheet", signatureSheet);
				EcRemote.postExpectingObject(serverUrl, "adapter/xapi/config/set", fd, success, failure);
			}
		});
		
	}
	
	public static void get(final String serverUrl, final Callback1<Object> success, final Callback1<String> failure){
		final FormData fd = new FormData();
		EcIdentityManager.signatureSheetAsync(60000, serverUrl,new Callback1<String>()
		{
			@Override
			public void $invoke(String signatureSheet)
			{
				fd.append("signatureSheet", signatureSheet);
				EcRemote.postExpectingObject(serverUrl, "adapter/xapi/config/get", fd, success, failure);
			}
		});
	}

}
