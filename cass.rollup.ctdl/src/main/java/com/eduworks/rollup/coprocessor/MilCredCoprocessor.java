package com.eduworks.rollup.coprocessor;

import cass.rollup.InquiryPacket;
import cass.rollup.coprocessor.AssertionCoprocessor;
import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.array.EcObject;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.profile.Assertion;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.AchieveAction;
import org.schema.Action;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Created by fray on 5/30/17.
 */
public class MilCredCoprocessor extends AssertionCoprocessor {

	public Object assertedBy = null;
	public Object assertions = null;
	public Array<String> nextSearch = null;

	@Override
	public void collectAssertions(final InquiryPacket ip, final Array<String> listOfCompetencies, final Callback1<Array<EcAssertion>> success) {
		//Collect things that assert things in listOfCompetencies
		//Recurse, detecting cycles
		//For each of those things that have an AssertAction or equivalent,
		//  add that thing to the evidence when creating an assertion.
		assertedBy = new Object();
		assertions = new Object();
		final MilCredCoprocessor me = this;
		rabbitHole(0, ip, listOfCompetencies, new Callback0() {
			@Override
			public void $invoke() {
				me.findAssertions(ip,new Callback0(){
					@Override
					public void $invoke() {
						me.generateAssertions(ip,listOfCompetencies,success);
					}
				});
			}
		});
	}

	private int getAssertedByCount(){
		int count = 0;
		Array<String> keys = EcObject.keys(assertedBy);

		for (int i = 0;i < keys.$length();i++)
			count += ((Array<String>)JSObjectAdapter.$get(assertedBy,keys.$get(i))).$length();
		return count;
	}

	private void generateAssertions(final InquiryPacket ip, final Array<String> listOfCompetencies, final Callback1<Array<EcAssertion>> success)
	{
		Array<EcAssertion> assertions = new Array<EcAssertion>();
		for (int i = 0;i < listOfCompetencies.$length();i++)
		{
			Array<String> evidences = new Array<>();
			addEvidenceOfDependenciesToArray(listOfCompetencies.$get(i),evidences);
			if (evidences.$length() == 0)
				continue;
			EcAssertion a = new EcAssertion();
			a.generateId("internal");
			for (int j = 0;j < ip.subject.$length();j++)
				a.addOwner(ip.subject.$get(j));
			a.setSubject(ip.subject.$get(0));
			a.setCompetency(listOfCompetencies.$get(i));
			a.setEvidence(evidences);
			a.setConfidence(1.0);
			assertions.push(a);
		}
		success.$invoke(assertions);
	}

	private void addEvidenceOfDependenciesToArray(String s, Array<String> evidences) {
		if (JSObjectAdapter.$get(assertions,s) != null)
		{
			for (int i = 0;i < ((Array<Action>)JSObjectAdapter.$get(assertions,s)).$length();i++)
				evidences.push(((Array<Action>)JSObjectAdapter.$get(assertions,s)).$get(i).shortId());
		}
		if (JSObjectAdapter.$get(assertedBy,s) != null)
		{
			for (int i = 0;i < ((Array<String>)JSObjectAdapter.$get(assertedBy,s)).$length();i++)
				addEvidenceOfDependenciesToArray(((Array<String>)JSObjectAdapter.$get(assertedBy,s)).$get(i),evidences);
		}
	}

	private void findAssertions(final InquiryPacket ip, final Callback0 success)
	{
		final MilCredCoprocessor me = this;
		me.assertionProcessor.log(ip, "Querying repositories for AchieveActions");
		final Array<String> evidence = new Array<String>();
		Array<String> keys = EcObject.keys(assertedBy);
		for (int i = 0; i < keys.$length(); i++)
			for (int j = 0; j < ((Array<String>)JSObjectAdapter.$get(assertedBy,keys.$get(i))).$length(); j++)
				evidence.push(((Array<String>)JSObjectAdapter.$get(assertedBy,keys.$get(i))).$get(j));
		if (evidence.$length() == 0){
			success.$invoke();
			return;
		}
		EcAsyncHelper<EcRepository> eah = new EcAsyncHelper();
		eah.each(me.assertionProcessor.repositories, new Callback2<EcRepository, Callback0>() {
			@Override
			public void $invoke(EcRepository currentRepository, final Callback0 callback0) {
				String searchQuery = me.buildAssertionSearchQuery(ip, evidence);
				me.assertionProcessor.log(ip, "Querying repositories for AchieveActions regarding " + evidence.$length() + " evidences: " + searchQuery);
				Object params = new Object();
				JSObjectAdapter.$put(params, "size", 5000);
				currentRepository.searchWithParams(searchQuery, params, null, new Callback1<Array<EcRemoteLinkedData>>() {
					public void $invoke(Array<EcRemoteLinkedData> p1) {
						me.assertionProcessor.log(ip, p1.$length() + " AchieveActions found.");
						for (int i = 0; i < p1.$length(); i++) {
							AchieveAction a = new AchieveAction();
							a.copyFrom(p1.$get(i));
							String thingy = EcRemoteLinkedData.trimVersionFromUrl((String)(Object)a.object);
							if (((Array<Action>)JSObjectAdapter.$get(me.assertions,thingy) == null))
								JSObjectAdapter.$put(me.assertions,thingy, new Array<Action>());
							Array<Action> as = (Array<Action>) JSObjectAdapter.$get(me.assertions, thingy);
							EcArray.setAdd(as,a);
						}
						callback0.$invoke();
					}
				}, new Callback1<String>() {
					public void $invoke(String p1) {
						callback0.$invoke();
					}
				});
			}
		}, new Callback1<Array<EcRepository>>() {
			@Override
			public void $invoke(Array<EcRepository> strings) {
				success.$invoke();
			}
		});
	}

	private void rabbitHole(final int level, final InquiryPacket ip, final Array<String> listOfThingies, final Callback0 success) {
		final MilCredCoprocessor me = this;
		nextSearch = new Array<String>();
		EcAsyncHelper<EcRepository> eah = new EcAsyncHelper();
		eah.each(me.assertionProcessor.repositories, new Callback2<EcRepository, Callback0>() {
			@Override
			public void $invoke(EcRepository currentRepository, final Callback0 callback0) {
				String searchQuery = me.buildRelationsSearchQuery(ip, listOfThingies);
				me.assertionProcessor.log(ip, "Querying repositories for relations regarding " + listOfThingies.$length() + " objects: " + searchQuery);
				Object params = new Object();
				JSObjectAdapter.$put(params, "size", 5000);
				currentRepository.searchWithParams(searchQuery, params, null, new Callback1<Array<EcRemoteLinkedData>>() {
					public void $invoke(Array<EcRemoteLinkedData> p1) {
						me.assertionProcessor.log(ip, p1.$length() + " relations found.");

						for (int i = 0; i < p1.$length(); i++) {
							CreativeWork a = new CreativeWork();
							a.copyFrom(p1.$get(i));
							String thingy = EcRemoteLinkedData.trimVersionFromUrl(a.educationalAlignment.targetUrl);
							String assertedBy = EcRemoteLinkedData.trimVersionFromUrl(a.url);
							if (((Array<String>)JSObjectAdapter.$get(me.assertedBy,thingy) == null))
								JSObjectAdapter.$put(me.assertedBy,thingy, new Array<String>());
							Array<String> as = (Array<String>) JSObjectAdapter.$get(me.assertedBy, thingy);
							if (!EcArray.has(as,assertedBy)) {
								as.push(assertedBy);
								me.nextSearch.push(assertedBy);
							}
						}
						callback0.$invoke();
					}
				}, new Callback1<String>() {
					public void $invoke(String p1) {
						callback0.$invoke();
					}
				});
			}
		}, new Callback1<Array<EcRepository>>() {
			@Override
			public void $invoke(Array<EcRepository> strings) {
				if (me.nextSearch.$length() > 0)
					me.rabbitHole(level+1,ip,me.nextSearch,success);
				else
					success.$invoke();
			}
		});
	}

	protected String buildRelationsSearchQuery(InquiryPacket ip, Array<String> competencies) {
		String result = null;
		if (InquiryPacket.IPType.ROLLUPRULE.equals(ip.type)) {
			ip.failure.$invoke("NOT SUPPOSED TO BE HERE.");
			throw new RuntimeException("Collecting assertions when root node is a rollup rule. Not supported.");
		} else if (InquiryPacket.IPType.COMPETENCY.equals(ip.type)) {
			result = "educationalAlignment.alignmentType:\"*asserts\" AND (";
			for (int i = 0; i < competencies.$length(); i++) {
				if (i != 0)
					result += " OR ";
				result += "educationalAlignment.targetUrl:\"" + competencies.$get(i) + "\"";
			}
			result += ")";
		}
		if (result != null)
			return result;
		throw new RuntimeException("Trying to build a coprocessor rabbit hole search query on an unsupported type: " + ip.type);
	}
	protected String buildAssertionSearchQuery(InquiryPacket ip, Array<String> competencies) {
		String result = null;
		if (InquiryPacket.IPType.ROLLUPRULE.equals(ip.type)) {
			ip.failure.$invoke("NOT SUPPOSED TO BE HERE.");
			throw new RuntimeException("Collecting assertions when root node is a rollup rule. Not supported.");
		} else if (InquiryPacket.IPType.COMPETENCY.equals(ip.type)) {
			result = "@type:\"*AchieveAction\" AND (";
			for (int i = 0; i < competencies.$length(); i++) {
				if (i != 0)
					result += " OR ";
				result += "object:\"" + competencies.$get(i) + "\"";
			}
			result += ")";
		}
		for (int i = 0; i < ip.subject.$length(); i++)
			result += " AND (agent:\"" + ip.subject.$get(i).toPem() + "\")";
		if (result != null)
			return result;
		throw new RuntimeException("Trying to build a coprocessor achieveAction search query on an unsupported type: " + ip.type);
	}
}
