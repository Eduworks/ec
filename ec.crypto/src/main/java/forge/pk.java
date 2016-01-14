package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class pk
{
	public int n;
	public int e;
	public payload encrypt(String payload, String algorithm)
	{
		return null;
	}
}
