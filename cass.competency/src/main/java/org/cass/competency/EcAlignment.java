package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Relation;
import org.stjs.javascript.Global;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.functions.Callback1;

/**
 * TODO: Test case where an absent relation is in the framework.
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
	
	public void save(Callback1<String> success, Callback1<String> failure){
		if(source == null || source == ""){
			String msg = "Source Competency cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(target == null || target == ""){
			String msg = "Target Competency cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(relationType == null || relationType == ""){
			String msg = "Relation Type cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		EcRepository._save(this, success, failure);
	}
	
	public void _delete(Callback1<String> success, Callback1<String> failure){
		EcRepository.DELETE(this, success, failure);
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
