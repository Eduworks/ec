package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class pki
{

	public static pk publicKeyFromPem(String pem)
	{
		return null;
	}
	public static ppk privateKeyFromPem(String pem)
	{
		return null;
	}

	public static String publicKeyToPem(pk pk)
	{
		return null;
	}
	public static String privateKeyToPem(ppk ppk)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
