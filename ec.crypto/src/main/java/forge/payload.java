package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge()
public class payload {

	public int length;

	public bytes bytes() {
		return null;
	}
	public String toHex() { return null;}

	public payload substring(int i, int len) {
		return null;
	}
}
