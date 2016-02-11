package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Relation;
import org.stjs.javascript.functions.Callback1;

/**
 * Helper class that immediately reflects changes into its remote repository.
 * @author fritz.ray@eduworks.com
 *
 */
public class EcAlignment extends Relation
{

	public void setName(String name, Callback1<String> success, Callback1<String> failure)
	{
		this.name = name;
		EcRepository.save(this, success, failure);
	}
	public void setDescription(String description, Callback1<String> success, Callback1<String> failure)
	{
		this.description = description;
		EcRepository.save(this, success, failure);
	}
}
