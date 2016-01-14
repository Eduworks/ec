package com.eduworks.ec.crypto;

public abstract class EcRsa
{
	public abstract String encrypt(EcPk pk, String text);
	public abstract String decrypt(EcPpk ppk, String text);
	public abstract String sign(EcPpk ppk, String text);
	public abstract Boolean verify(EcPk pk, String text, String signature);
}
