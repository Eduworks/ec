package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class pkcs5
{
	public static payload pbkdf2(String username, String usernameSalt, int usernameIterations, int usernameWidth)
	{
		return null;
	}
}
