package org.cassproject.schema.cass.competency;

import org.cassproject.schema.general.EcRemoteLinkedData;

public abstract class Reference extends EcRemoteLinkedData
{
	public Reference(String schema, String type)
	{
		super(schema, type);
	}
}
