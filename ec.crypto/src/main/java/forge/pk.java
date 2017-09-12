package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge()
public class pk {
	public int n;
	public int e;

	public payload encrypt(String payload, String algorithm) {
		return null;
	}

	public Boolean verify(bytes bytes, payload decode64) {
		return null;
	}
}
