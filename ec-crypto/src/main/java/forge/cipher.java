package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("forge")
@STJSBridge(sources = { "forge/forge.bundle.js" })
public class cipher
{

	public static cipher createCipher(String algorithm, String secret)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public cipheroutput output;

	public void update(payload createBuffer)
	{
		// TODO Auto-generated method stub
		
	}

	public void start(Object aesParameters)
	{
		
	}

	public void finish()
	{
		// TODO Auto-generated method stub
		
	}

	public static cipher createDecipher(String string, String secret)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
