package org.cassproject.ebac.identity.remote;

import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

public interface RemoteIdentityManagerInterface {
	void configure(String usernameSalt, int usernameIterations, int usernameWidth, String passwordSalt, int passwordIterations, int passwordWidth,
	               String secretSalt, int secretIterations);

	void configureFromServer(Callback1<Object> success, Callback1<String> failure);

	void clear();

	void setDefaultIdentityManagementServer(String server);

	void startLogin(String username, String password);

	boolean changePassword(String username, String oldPassword, String newPassword);

	void fetch(Callback1<Object> success, Callback1<String> failure);

	void commit(Callback1<String> success, Callback1<String> failure, Function0<String> padGenerationCallback);

	void create(Callback1<String> success, Callback1<String> failure, Function0<String> padGenerationCallback);

	void fetchServerAdminKeys(Callback1<Array<String>> success, Callback1<String> failure);
}
