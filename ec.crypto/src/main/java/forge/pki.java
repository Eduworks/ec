package forge;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

import com.eduworks.ec.blob.ArrayBuffer;

@Namespace("forge")
@STJSBridge()
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
		return null;
	}

	public static String privateKeyInfoToPem(ArrayBuffer ppk)
	{
		return null;
	}

	public static ArrayBuffer wrapRsaPrivateKey(ppk ppk)
	{
		return null;
	}

	public static ppk privateKeyToAsn1(ppk ppk)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static String publicKeyToRSAPublicKey(pk pk)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static String publicKeyToRSAPublicKeyPem(forge.pk pk)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
