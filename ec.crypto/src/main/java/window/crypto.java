package window;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("window")
@STJSBridge()
public class crypto {
	public static SubtleCrypto subtle;

}
