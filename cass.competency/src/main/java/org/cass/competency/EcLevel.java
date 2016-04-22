package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Level;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;

/**
 * @author fritz.ray@eduworks.com
 */
public class EcLevel extends Level
{
	public void addRelationship(EcLevel level, EcLevel targetLevel, String alignmentType, final EcPpk identity, final String server	)
	{
		final EcAlignment a = new EcAlignment();
		a.source = id;
		a.target = targetLevel.id;
		a.relationType = alignmentType;
		a.addOwner(identity.toPk());
		a.generateId(server);
		a.signWith(identity);
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public static void get(String id, final Callback1<EcLevel> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				if (success == null)
					return;
				if (!p1.isA(EcLevel.myType))
				{
					if (failure != null)
						failure.$invoke("Resultant object is not a level.");
					return;
				}
				EcLevel c = new EcLevel();
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
