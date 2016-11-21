package org.cass.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.RollupRule;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

/**
 * Implementation of a Rollup Rule object with methods for interacting with CASS
 * services on a server.
 * 
 * @module org.cassproject
 * @class EcRollupRule
 * @constructor
 * @extends RollupRule
 * 
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 */
public class EcRollupRule extends RollupRule
{
	/**
	 * Method for setting a rollup rule name
	 * 
	 * @memberOf EcRollupRule
	 * @method setName
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Method for setting a rollup rule description
	 * 
	 * @memberOf EcRollupRule
	 * @method setDescription
	 * @param {String} description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * Saves this rollup rules details on the server specified by its ID
	 * 
	 * @memberOf EcRollupRule
	 * @method save
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successful save of rollup rule
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error saving rollup rule
	 */
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
		
		EcRepository._save(this, success, failure);
	}
	
	/**
	 * Deletes this rollup rule from the server specified by it's ID
	 * 
	 * @memberOf EcRollupRule
	 * @method _delete
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successful deleting the rollup rle
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error deleting the rollup rule
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure){
		EcRepository.DELETE(this, success, failure);
	}
	
	/** 
	 * Retrieves a rollup rule from the server
	 * 
	 * @memberOf EcRollupRule
	 * @method get
	 * @static
	 * @param {String} id
	 * 			ID of the rollup rule to retrieve
	 * @param {Callback1<EcRollupRule>} success
	 * 			Callback triggered on successful retrieving rollup rule, 
	 * 			returns the rollup rule
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error retrieving rollup rule
	 */
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
