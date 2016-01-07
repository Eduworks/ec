package com.eduworks.ec.crypto;

public class EcPk
{
	public static EcPk fromPem(String pem)
	{
		EcPk pk = new EcPk();
		pk.pem = pem;
		return pk;
	}

	private String pem;

	protected EcPk()
	{
	}

	protected String toPem()
	{
		return pem;
	}

}
