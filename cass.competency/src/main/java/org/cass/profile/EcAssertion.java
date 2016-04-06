package org.cass.profile;

import org.cassproject.ebac.identity.EcContact;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.schema.cass.profile.Assertion;
import org.stjs.javascript.JSObjectAdapter;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.schema.ebac.EbacEncryptedValue;

import org.stjs.javascript.Array;

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
		EcContact contact = EcIdentityManager.getContact(getSubject());
		if (contact == null || contact.displayName == null)
			return "Unknown Subject";
		return contact.displayName;
	}

	public String getAgentName()
	{
		if (agent == null)
			return "Nobody";
		EcContact contact = EcIdentityManager.getContact(getAgent());
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
	

	/**
	 * Sets the subject of an assertion. Makes a few assumptions:
	 * Owners of the object should be able to see and change the encrypted value.
	 * Owners and readers of the object should be persisted.
	 * @param pk
	 */
	public void setSubject(EcPk pk)
	{
		Array<String> owners = new Array<String>();
		Array<String> readers = new Array<String>();
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
}
