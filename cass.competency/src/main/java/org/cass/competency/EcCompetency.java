package org.cass.competency;

import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Competency;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;

/**
 * Helper class that immediately reflects changes into its remote repository.
 * @author fritz.ray@eduworks.com
 *
 */
public class EcCompetency extends Competency
{
	public static String RELATIONSHIP_TYPE_REQUIRES = "requires";
	public static String RELATIONSHIP_TYPE_DESIRES = "desires";
	public static String RELATIONSHIP_TYPE_IS_ENABLED_BY = "isEnabledBy";
	public static String RELATIONSHIP_TYPE_IS_RELATED_TO = "isRelatedTo";
	public static String RELATIONSHIP_TYPE_IS_EQUIVALENT_TO = "isEquivalentTo";

	public static String RELATIONSHIP_TYPE_LEVEL_GREATER_THAN = "greaterThan";
	public static String RELATIONSHIP_TYPE_LEVEL_IS_EQUIVALENT_TO = "isEquivalentTo";
	public static String RELATIONSHIP_TYPE_LEVEL_OVERLAPS = "overlaps";

	public void addAlignment(EcCompetency target, final String alignmentType, final EcPpk owner, final String server)
	{
		final EcAlignment a = new EcAlignment();
		a.generateId(server);
		a.source = id;
		a.target = target.id;
		a.relationType = alignmentType;
		a.addOwner(owner.toPk());

	}

	public void relationships(EcRepository repo, final Callback1<EcAlignment> success, final Callback1<String> failure)
	{
		repo.search("type:\"" + EcAlignment.myType + "\" AND (source:\"" + id + "\" OR destination:\"" + id + "\")", new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcAlignment a = new EcAlignment();
				a.copyFrom(p1);
				success.$invoke(a);
			}
		}, null, failure);
	}

	public void addLevel(String name, String description, final EcPpk owner, final String server)
	{
		final EcLevel l = new EcLevel();
		l.generateId(server);
		l.competency = id;
		l.description = description;
		l.name = name;
		l.addOwner(owner.toPk());
	}

	public void levels(EcRepository repo, final Callback1<EcLevel> success, final Callback1<String> failure, final Callback1<Array<EcLevel>> successAll)
	{
	
		repo.search("@type:\"" + EcLevel.myType + "\" AND ( competency:\"" + id + "\" OR competency:\""+shortId()+"\")", new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				if(success != null)
				{
					EcLevel a = new EcLevel();
					a.copyFrom(p1);
					success.$invoke(a);
				}
			}
		}, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(successAll != null)
				{
					Array<EcLevel> levels = JSCollections.$array();
					
					for(int i = 0; i < p1.$length(); i++){
						EcLevel a = new EcLevel();
						a.copyFrom(p1.$get(i));
						levels.$set(i, a);
					}
					
					successAll.$invoke(levels);
				}
			}
			
		}, failure);
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public void setScope(String scope)
	{
		this.scope = scope;
	}
}
