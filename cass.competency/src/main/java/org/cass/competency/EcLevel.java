package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Level;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;

/**
 * Helper class that immediately reflects changes into its remote repository.
 * @author fritz.ray@eduworks.com
 *
 */
public class EcLevel extends Level
{
	public void addRelationship(EcLevel level, EcLevel targetLevel, String alignmentType, final EcPpk identity, final String server,
			final Callback1<EcAlignment> success, final Callback1<String> failure)
	{
		final EcAlignment a = new EcAlignment();
		a.source = id;
		a.destination = targetLevel.id;
		a.alignmentType = alignmentType;
		a.addOwner(identity.toPk());
		a.generateId(server);
		a.signWith(identity);
		EcRepository.save(a, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				success.$invoke(a);
			}
		}, failure);
	}
}
