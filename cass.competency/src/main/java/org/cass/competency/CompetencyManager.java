package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.functions.Callback1;

public class CompetencyManager
{
	public static void get(String id, final Callback1<EcCompetency> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				if (success == null)
					return;
				EcCompetency c = new EcCompetency();
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
