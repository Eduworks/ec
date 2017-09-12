package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge()
public class keypair {
	public pk publicKey;
	public ppk privateKey;
}
