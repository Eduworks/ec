package org.cass.profile;

import org.cass.competency.EcCompetency;
import org.cassproject.ebac.identity.EcContact;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.profile.Assertion;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPk;

/**
 * The sequence that assertions should be built as such:
 * 1. Generate the ID.
 * 2. Add the owner.
 * 3. Set the subject.
 * 4. Set the agent.
 * Further functions may be called afterwards in any order.
 * WARNING: The modifications of ownership and readership do not "just work".
 * @author fritz.ray@eduworks.com
 */
public class EcAssertion extends Assertion
{
	public EcPk getSubject()
	{
		if (subject == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(subject);
		String decryptedString = v.decryptIntoString();
		if (decryptedString == null)
			return null;
		return EcPk.fromPem(decryptedString);
	}

	public EcPk getAgent()
	{
		if (agent == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(agent);
		String decryptedString = v.decryptIntoString();
		if (decryptedString == null)
			return null;
		return EcPk.fromPem(decryptedString);
	}

	public String getSubjectName()
	{
		if (subject == null)
			return "Nobody";
		EcPk subjectPk = getSubject();
		EcIdentity identity = EcIdentityManager.getIdentity(subjectPk);
		if (identity != null && identity.displayName != null)
			return identity.displayName+" (You)";
		EcContact contact = EcIdentityManager.getContact(subjectPk);
		if (contact == null || contact.displayName == null)
			return "Unknown Subject";
		return contact.displayName;
	}

	public String getAgentName()
	{
		if (agent == null)
			return "Nobody";
		EcPk agentPk = getAgent();
		EcIdentity identity = EcIdentityManager.getIdentity(agentPk);
		if (identity != null && identity.displayName != null)
			return identity.displayName+" (You)";
		EcContact contact = EcIdentityManager.getContact(agentPk);
		if (contact == null || contact.displayName == null)
			return "Unknown Agent";
		return contact.displayName;
	}

	public Long getAssertionDate()
	{
		if (assertionDate == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(assertionDate);
		String decryptedString = v.decryptIntoString();
		if (decryptedString == null)
			return null;
		return Long.parseLong(decryptedString);
	}

	public Long getExpirationDate()
	{
		if (expirationDate == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(expirationDate);
		String decryptedString = v.decryptIntoString();
		if (decryptedString == null)
			return null;
		return Long.parseLong(decryptedString);
	}

	public int getEvidenceCount()
	{
		if (evidence == null)
			return 0;
		return evidence.$length();
	}
	
	public String getEvidence(int index)
	{
		if (evidence == null)
			return null;

		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(evidence.$get(index));
		String decryptedString = v.decryptIntoString();
		return decryptedString;
	}

	public String getDecayFunction()
	{
		if (decayFunction == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(decayFunction);
		String decryptedString = v.decryptIntoString();
		if (decryptedString == null)
			return null;
		return decryptedString;
	}

	public Boolean getNegative()
	{
		if (negative == null)
			return false;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(negative);
		String decryptedString = v.decryptIntoString();
		if (decryptedString != null)
			decryptedString.toLowerCase();
		return "true".equals(decryptedString);
	}

	/**
	 * Sets the subject of an assertion. Makes a few assumptions:
	 * Owners of the object should be able to see and change the encrypted value.
	 * Owners and readers of the object should be persisted.
	 * @param pk
	 */
	public void setSubject(EcPk pk)
	{
		Array<String> owners = new Array<String>();
		Array<String> readers = reader;
		if(readers == null)
			readers = new Array<String>();
		if (subject != null)
		{
			owners.concat(subject.owner);
			readers.concat(subject.reader);
		}
		owners = owners.concat(owner);
		readers.push(pk.toPem());
		subject = EcEncryptedValue.encryptValue(pk.toPem(), id, "subject", owners, readers);
	}
	
	public void setAgent(EcPk pk)
	{
		agent = EcEncryptedValue.encryptValue(pk.toPem(), id, "agent", subject.owner, subject.reader);
	}
	
	public void setCompetency(String competencyUrl)
	{
		competency = competencyUrl;
	}
	
	public void setLevel(String levelUrl)
	{
		level = levelUrl;
	}
	
	public void setConfidence(Double confidenceZeroToOne)
	{
		confidence = confidenceZeroToOne;
	}
	
	public void setEvidence(Array<String> evidences)
	{
		Array<EcEncryptedValue> encryptedValues = new Array<EcEncryptedValue>();
		for (int i = 0;i < evidences.$length();i++)
			encryptedValues.push(EcEncryptedValue.encryptValue(evidences.$get(i), id, "evidence", subject.owner, subject.reader));
		evidence = encryptedValues;
	}
	
	public void setAssertionDate(Long assertionDateMs)
	{
		assertionDate = EcEncryptedValue.encryptValue(assertionDateMs.toString(), id, "assertionDate", subject.owner, subject.reader);
	}
	
	public void setExpirationDate(Long expirationDateMs)
	{
		expirationDate = EcEncryptedValue.encryptValue(expirationDateMs.toString(), id, "expirationDate", subject.owner, subject.reader);
	}

	public void setDecayFunction(String decayFunctionText)
	{
		decayFunction = EcEncryptedValue.encryptValue(decayFunctionText.toString(), id, "decayFunction", subject.owner, subject.reader);
	}

	public void setNegative(Boolean negativeB)
	{
		negative = EcEncryptedValue.encryptValue(negativeB.toString(), id, "negative", subject.owner, subject.reader);
	}
	
	public void save(Callback1<String> success, Callback1<String> failure){
		if(competency == null || competency == ""){
			String msg = "Failing to save: Competency cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(subject == null){
			String msg = "Failing to save: Subject cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(agent == null){
			String msg = "Failing to save: Agent cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(confidence == null){
			String msg = "Failing to save: Confidence cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(assertionDate == null){
			String msg = "Failing to save: Assertion Date cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		if(decayFunction == null){
			String msg = "Failing to save: Decay Function cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		EcRepository._save(this, success, failure);
	}
	
	public static void get(String id, final Callback1<EcAssertion> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
				if (success == null)
					return;
				if (!p1.isA(EcAssertion.myType))
				{
					if (failure != null)
						failure.$invoke("Resultant object is not an assertion.");
					return;
				}
				EcAssertion c = new EcAssertion();
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

	public String getSearchStringByTypeAndCompetency(EcCompetency competency)
	{
		return "("+getSearchStringByType() + " AND competency:\""+competency.shortId()+"\")";
	}
}
