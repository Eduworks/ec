package org.cass.adapter;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

public class MoodleConfig extends EcLinkedData {

	public boolean enabled;
	
	public String moodleEndpoint;
	public String moodleToken;
	
	public MoodleConfig() {
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
				EcRemote.postExpectingObject(serverUrl, "adapter/moodle/config/set", fd, success, failure);
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
				EcRemote.postExpectingObject(serverUrl, "adapter/moodle/config/get", fd, success, failure);
			}
		});
	}

}
