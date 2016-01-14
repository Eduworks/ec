package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class ppk
{
	public int n;
	public int e;

	public String decode(payload payload, String algorithm)
	{
		return null;
	}

	public payload sign(sha1 sha1)
	{
		return null;
	}
}
