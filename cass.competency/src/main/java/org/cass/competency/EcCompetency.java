package org.cass.competency;

import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Competency;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPpk;

/**
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

	public EcAlignment addAlignment(EcCompetency target, final String alignmentType, final EcPpk owner, final String server, Callback1<String> success, Callback1<String> failure)
	{
		final EcAlignment a = new EcAlignment();
		a.generateId(server);
		a.source = shortId();
		a.target = target.shortId();
		a.relationType = alignmentType;
		a.addOwner(owner.toPk());

		EcRepository.save(a, success, failure);
		
		return a;
	}

	public void relationships(EcRepository repo, final Callback1<EcAlignment> eachSuccess, final Callback1<String> failure, final Callback1<Array<EcAlignment>> successAll)
	{
		repo.search("@type:\"" + EcAlignment.myType + "\" AND (source:\"" + id + "\" OR target:\"" + id + "\" OR source:\"" + shortId() + "\" OR target:\"" + shortId() + "\")", new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				EcAlignment a = new EcAlignment();
				a.copyFrom(p1);
				if(eachSuccess != null)
					eachSuccess.$invoke(a);
			}
		}, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(successAll != null)
				{
					Array<EcAlignment> rels = JSCollections.$array();
					
					for(int i = 0; i < p1.$length(); i++){
						EcAlignment a = new EcAlignment();
						a.copyFrom(p1.$get(i));
						rels.$set(i, a);
					}
					
					if(successAll != null)
						successAll.$invoke(rels);
				}
			}
			
		}, failure);
	}

	public EcLevel addLevel(String name, String description, final EcPpk owner, final String server, Callback1<String> success, Callback1<String> failure)
	{
		final EcLevel l = new EcLevel();
		l.generateId(server);
		l.competency = shortId();
		l.description = description;
		l.name = name;
		l.addOwner(owner.toPk());
		
		EcRepository.save(l, success, failure);
		
		return l;
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
					if(success != null)
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
					
					if(successAll != null)
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

	public void save(Callback1<String> success, Callback1<String> failure)
	{
		if(this.name == null || this.name == "")
		{
			String msg = "Competency Name can not be empty";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(privateEncrypted != null && privateEncrypted.booleanValue()){
			EcEncryptedValue encrypted = EcEncryptedValue.toEncryptedValue(this, false);
			EcRepository._save(encrypted, success, failure);
		}else{
			EcRepository._save(this, success, failure);
		}
	}
	
	public void _delete(final Callback1<String> success, final Callback1<String> failure, final EcRepository repo)
	{
		final EcCompetency me = this;
		EcRepository.DELETE(this, new Callback1<String>(){
			@Override
			public void $invoke(String p1) {
				if(repo != null)
				{
					me.relationships(repo, new Callback1<EcAlignment>() {
						@Override
						public void $invoke(EcAlignment p1) {
							for(int i = 0; i < EcIdentityManager.ids.$length(); i++){
								if(p1.canEdit(EcIdentityManager.ids.$get(i).ppk.toPk())){
									p1._delete(null, new Callback1<String>() {
										@Override
										public void $invoke(String p1) {
											if(failure != null)
												failure.$invoke("Unable to Delete Competency Relation");
											else
												Global.console.error("Unable to Delete Competency Relation");
										}
									});
									return;
								}
							}
						}
					}, failure, new Callback1<Array<EcAlignment>>(){
						@Override
						public void $invoke(Array<EcAlignment> p1) {
							if(success != null)
								success.$invoke("");
						}
					});
					
					me.levels(repo, new Callback1<EcLevel>(){

						@Override
						public void $invoke(EcLevel p1) {
							for(int i = 0; i < EcIdentityManager.ids.$length(); i++){
								if(p1.canEdit(EcIdentityManager.ids.$get(i).ppk.toPk())){
									p1._delete(null, new Callback1<String>() {
										@Override
										public void $invoke(String p1) {
											if(failure != null)
												failure.$invoke("Unable to Delete Competency Relation");
											else
												Global.console.error("Unable to Delete Competency Relation");
										}
									}, repo);
									return;
								}
							}
						}
						
					}, failure, new Callback1<Array<EcLevel>>(){
						@Override
						public void $invoke(Array<EcLevel> p1) {
							if(success != null)
								success.$invoke("");
						}
					});
				}
				else
				{
					if(success != null)
						success.$invoke(p1);
				}
			}
		}, failure);
	}

	public static void get(String id, final Callback1<EcCompetency> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				if (success == null)
					return;
				if (!p1.isA(EcCompetency.myType))
				{
					if (failure != null)
						failure.$invoke("Resultant object is not a competency.");
					return;
				}
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
