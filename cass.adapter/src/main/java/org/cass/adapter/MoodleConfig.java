package org.cass.adapter;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Object that holds the Moodle Adapter configuration values returned
 * from the server and provides methods for saving new config values
 *
 * @author devlin.junker@eduworks.com
 * @module org.cassproject
 * @class MoodleConfig
 * @constructor
 */
public class MoodleConfig extends EcLinkedData {

	public boolean enabled;

	public String moodleEndpoint;
	public String moodleToken;

	public MoodleConfig() {
		super(null, null);
	}

	/**
	 * Retrieves the Moodle adapter configuration values from the server
	 *
	 * @param {String}            serverUrl
	 *                            URL of server to save configuration values to
	 * @param {Callback1<Object>} success
	 *                            Callback triggered on successfully retrieving config values to server
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if an error occurs while getting the config values
	 * @memberOf MoodleConfig
	 * @method get
	 * @static
	 */
	public static void get(final String serverUrl, final Callback1<Object> success, final Callback2<String, Integer> failure) {
		final FormData fd = new FormData();
		long offset = EcRepository.setOffset(serverUrl);
		EcIdentityManager.signatureSheetAsync(60000 + offset, serverUrl, new Callback1<String>() {
			@Override
			public void $invoke(String signatureSheet) {
				fd.append("signatureSheet", signatureSheet);
				EcRemote.postExpectingObject(serverUrl, "adapter/moodle/config/get", fd, success, failure);
			}
		},failure);
	}

	/**
	 * Retrieves the Moodle adapter Encryption Key from the server to share frameworks with
	 *
	 * @param {String}            serverUrl
	 *                            URL of server to save configuration values to
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully retrieving config values to server
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if an error occurs while getting the config values
	 * @memberOf MoodleConfig
	 * @method get
	 * @static
	 */
	public static void getMoodleKey(final String serverUrl, final Callback1<String> success, final Callback2<String, Integer> failure) {
		final FormData fd = new FormData();
		long offset = EcRepository.setOffset(serverUrl);
		EcIdentityManager.signatureSheetAsync(60000 + offset, serverUrl, new Callback1<String>() {
			@Override
			public void $invoke(String signatureSheet) {
				fd.append("signatureSheet", signatureSheet);
				EcRemote.postExpectingString(serverUrl, "adapter/moodle/config/key", fd, success, failure);
			}
		},failure);
	}

	public static void syncCassToMoodle(final String serverUrl, Callback1<String> success, final Callback2<String, Integer> failure) {
		EcRemote.postExpectingString(serverUrl, "moodle/cassToMoodle", new FormData(), success, failure);
	}

	public static void syncMoodleToCass(final String serverUrl, Callback1<String> success, final Callback2<String, Integer> failure) {
		EcRemote.postExpectingString(serverUrl, "moodle/moodleToCass", new FormData(), success, failure);
	}

	/**
	 * Saves this config Objects configuration values to the server specified
	 *
	 * @param {String}            serverUrl
	 *                            URL of server to save configuration values to
	 * @param {Callback1<Object>} success
	 *                            Callback triggered on successfully saving config values to server
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if an error occurs while saving the config values
	 * @memberOf MoodleConfig
	 * @method save
	 */
	public void save(final String serverUrl, final Callback1<Object> success, final Callback2<String, Integer> failure) {
		final FormData fd = new FormData();
		fd.append("config", Global.JSON.stringify(this));
		long offset = EcRepository.setOffset(serverUrl);
		EcIdentityManager.signatureSheetAsync(60000 + offset, serverUrl, new Callback1<String>() {
			@Override
			public void $invoke(String signatureSheet) {
				fd.append("signatureSheet", signatureSheet);
				EcRemote.postExpectingObject(serverUrl, "adapter/moodle/config/set", fd, success, failure);
			}
		},failure);
	}

}
