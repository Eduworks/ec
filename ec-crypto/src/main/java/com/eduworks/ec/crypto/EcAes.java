package com.eduworks.ec.crypto;
import forge.random;
import forge.util;

/***
 * AES encryption tasks common across all variants of AES. 
 * @author fray
 *
 */
public class EcAes
{
	/***
	 * Generates a random Initialization Vector of length @i
	 * @param i Length of initialization Vector
	 * @return String representing the new Initialization Vector in Base64 Encoding.
	 */
	public static String newIv(int i)
	{
		return util.encode64(random.getBytesSync(i));
	}
}
