package com.eduworks.ec.crypto;

import forge.payload;
import forge.util;

public class EcAesParameters
{
	public EcAesParameters (String iv){
		this.iv = util.decode64(iv);
	}
	payload iv;
}
