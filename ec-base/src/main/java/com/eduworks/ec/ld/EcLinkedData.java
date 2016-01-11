package com.eduworks.ec.ld;

public class EcLinkedData
{
	public String type;
	public String id;
	public String schema;
	
	public EcLinkedData(String schema, String type)
	{
		this.schema = schema;
		this.type = type;
	}
	
	public String toJson()
	{
		return null;
	}
	
}
