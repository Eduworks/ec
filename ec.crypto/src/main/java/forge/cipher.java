package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge()
public class cipher {

	public cipheroutput output;

	public static cipher createCipher(String algorithm, payload secret) {
		return null;
	}

	public static cipher createDecipher(String string, payload secret) {
		return null;
	}

	public void update(payload createBuffer) {
	}

	public void start(Object aesParameters) {
	}

	public void finish() {
	}

}
