package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class cipher
{

	public static cipher createCipher(String algorithm, String secret)
	{
		return null;
	}

	public cipheroutput output;

	public void update(payload createBuffer)
	{
	}

	public void start(Object aesParameters)
	{
	}

	public void finish()
	{
	}

	public static cipher createDecipher(String string, String secret)
	{
		return null;
	}

}
