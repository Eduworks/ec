package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Relation;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.functions.Callback1;

/**
 * @author fritz.ray@eduworks.com
 *
 */
public class EcAlignment extends Relation
{

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public static void get(String id, final Callback1<EcAlignment> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				if (success == null)
					return;
				if (!p1.isA(EcAlignment.myType))
				{
					if (failure != null)
						failure.$invoke("Resultant object is not an alignment.");
					return;
				}
				EcAlignment c = new EcAlignment();
				c.copyFrom(p1);
				success.$invoke(c);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				if (failure != null)
					failure.$invoke(p1);
			}
		});
	}
}
