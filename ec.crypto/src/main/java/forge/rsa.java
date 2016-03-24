package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Callback2;

@Namespace("forge.pki")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class rsa
{

	public static pk setPublicKey(int n, int e)
	{
		return null;
	}

	public static keypair generateKeyPair(Object o, Callback2<String, keypair> callback2)
	{
		return null;
	}
	
}
