package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Level;
<<<<<<< .mine
import org.stjs.javascript.Global;
=======
import org.cassproject.schema.general.EcRemoteLinkedData;
>>>>>>> .r178
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
	
	public void save(Callback1<String> success, Callback1<String> failure){
		if(name == null || name == ""){
			String msg = "Level name cannot be empty";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(competency == null || competency == ""){
			String msg = "Level's Competency cannot be empty";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		EcRepository._save(this, success, failure);
	}
	
	public void _delete(Callback1<String> success, Callback1<String> failure, EcRepository repo){
		EcRepository.DELETE(this, success, failure);
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
