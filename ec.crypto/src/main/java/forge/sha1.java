package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge.md")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class sha1
{
	public static sha1 create()
	{
		return null;
	}
	public void update(String text,String encoding){}
	public payload digest()
	{
		return null;
	}
}
