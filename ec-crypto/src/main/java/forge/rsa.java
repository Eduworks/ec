package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge.pki")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class rsa
{

	public static pk setPublicKey(int n, int e)
	{
		return null;
	}
	
}
