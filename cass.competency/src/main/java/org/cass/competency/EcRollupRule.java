package org.cass.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.RollupRule;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

/**
 * @author fritz.ray@eduworks.com
 */
public class EcRollupRule extends RollupRule
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
		if(rule == null || rule == ""){
			String msg = "RollupRule Rule cannot be empty";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(competency == null || competency == ""){
			String msg = "RollupRule's Competency cannot be empty";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if (privateEncrypted != null && privateEncrypted)
		{
			EcEncryptedValue encrypted = EcEncryptedValue.toEncryptedValue(this, false);
			EcRepository._save(encrypted, success, failure);
		} else
		{
			EcRepository._save(this, success, failure);
		}
	}
	
	public void _delete(Callback1<String> success, Callback1<String> failure, EcRepository repo){
		EcRepository.DELETE(this, success, failure);
	}
	
	public static void get(String id, final Callback1<EcRollupRule> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				if (success == null)
					return;
				if (!p1.isA(EcRollupRule.myType))
				{
					if (failure != null)
						failure.$invoke("Resultant object is not a level.");
					return;
				}
				EcRollupRule c = new EcRollupRule();
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
