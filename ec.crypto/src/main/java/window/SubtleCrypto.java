package window;

import org.stjs.javascript.Array;
import org.stjs.javascript.jquery.Promise;

import com.eduworks.ec.blob.ArrayBuffer;

public class SubtleCrypto
{
	public Promise encrypt(AlgorithmIdentifier algorithm, CryptoKey key, ArrayBuffer data){return null;}

	public Promise decrypt(AlgorithmIdentifier algorithm, CryptoKey key, ArrayBuffer data){return null;}

	public Promise sign(AlgorithmIdentifier algorithm, CryptoKey key, ArrayBuffer data){return null;}

	public Promise verify(AlgorithmIdentifier algorithm, CryptoKey key, ArrayBuffer signature, ArrayBuffer data){return null;}

	//public Promise digest(AlgorithmIdentifier algorithm, ArrayBuffer data){return null;}

	public Promise generateKey(AlgorithmIdentifier algorithm, boolean extractable, Array<String> keyUsages){return null;}

	//public Promise deriveKey(AlgorithmIdentifier algorithm, ArrayBuffer baseKey, AlgorithmIdentifier derivedKeyType, boolean extractable,
	//		sequence<KeyUsage> keyUsages){return null;}

	public Promise deriveBits(AlgorithmIdentifier algorithm,
			CryptoKey baseKey,
		                          long length){return null;}

	public Promise importKey(String format,
		                         ArrayBuffer keyData,
		                         AlgorithmIdentifier algorithm,
		                         boolean extractable,
		                         Array<String> keyUsages){return null;}
//
//	public Promise exportKey(KeyFormat format, ArrayBuffer key){return null;}
//
//	public Promise wrapKey(KeyFormat format, ArrayBuffer key, ArrayBuffer wrappingKey, AlgorithmIdentifier wrapAlgorithm){return null;}
//
//	public Promise unwrapKey(KeyFormat format, ArrayBuffer wrappedKey, ArrayBuffer unwrappingKey, AlgorithmIdentifier unwrapAlgorithm,
//			AlgorithmIdentifier unwrappedKeyAlgorithm, boolean extractable, sequence<KeyUsage> keyUsages){return null;}
}
