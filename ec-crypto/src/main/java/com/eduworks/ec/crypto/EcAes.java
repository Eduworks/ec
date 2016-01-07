package com.eduworks.ec.crypto;

public abstract class EcAes
{
	public abstract String encrypt(String text, String secret, String iv);
	public abstract String decrypt(String text, String secret, String iv);
}
