package org.cassproject.schema.cass.profile;

import com.eduworks.ec.crypto.EcPk;
import org.cassproject.ebac.identity.EcContact;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.schema.cass.Cass;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;

/**
 * A claim of competence in CASS is called an Assertion. It states with some confidence that an individual has mastered a competency at a given level, provides evidence of such mastery, and records data such as the time of assertion and the party making the assertion.
 * @author fritz.ray@eduworks.com
 * @class Assertion
 * @module org.cassproject
 * @extends CreativeWork
 */
public class Assertion extends CreativeWork
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/assertion";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/assertion";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/Assertion";
	private static final String TYPE_0_4 = "http://schema.cassproject.org/0.3/Assertion";
	public static final String myType = TYPE_0_4;

	public Assertion()
	{
		setContextAndType(Cass.context, myType);
	}

	/**
	 * URL of the competency.
	 * @property competency
	 * @type string(URL)
	 */
	public String competency;
	/**
	 * URL of the framework within which the assertion is restricted.
	 * @property framework
	 * @type string(URL)
	 */
	public String framework;
	/**
	 * URL of the level, or null if 'held with no performance expectations'.
	 * @property level
	 * @type string
	 */
	public String level;
	/**
	 * Public Key in PEM format of the recipient of the assertion.
	 * @property subject
	 * @type EcEncryptedValue<Public Key PEM>
	 */
	protected EcEncryptedValue subject;
	/**
	 * Public Key in PEM format of the identity making the assertion.
	 * @property agent
	 * @type EcEncryptedValue<Public Key PEM>
	 */
	protected EcEncryptedValue agent;
	/**
	 * Encrypted evidence. May be a string, URL or schema.org/Thing.
	 * @property evidence
	 * @type EcEncryptedValue<string | URL | Thing>[]
	 */
	protected Array<EcEncryptedValue> evidence;
	/**
	 * Confidence with which the assertion was made. 
	 * Confidence has many interpretations, one possibility is the probability that the individual could demonstrate the competency again.
	 * @property confidence
	 * @type float [0,1]
	 */
	public Double confidence;
	/**
	 * Time that the assertion was made in milliseconds since the Unix Epoch.
	 * @property assertionDate
	 * @type EcEncryptedValue<long>
	 */
	protected EcEncryptedValue assertionDate;
	/**
	 * Time that the assertion expires, specified in milliseconds since the Unix Epoch.
	 * @property expirationDate
	 * @type EcEncryptedValue<long>
	 */
	protected EcEncryptedValue expirationDate;
	/**
	 * Describes the slope of the line from the initial confidence at the assertion date and the expiration date. t is a number between [0,1] representing the percentage of time that has elapsed. Examples include t^2 and ln(t).
	 * @property decayFunction
	 * @type EcEncryptedValue<string>
	 */
	protected EcEncryptedValue decayFunction;
	/**
	 * True if the assertion is a claim that the subject cannot demonstrate the competency.
	 * @property negative
	 * @type EcEncryptedValue<boolean>
	 */
	protected EcEncryptedValue negative;


	public EcPk getSubject()
	{
		return EcPk.fromPem((String)(Object)subject);
	}

	public void getSubjectAsync(final Callback1<EcPk> success, final Callback1<String> failure)
	{
		success.$invoke(EcPk.fromPem((String)(Object)subject));
	}

	public EcPk getAgent()
	{
		return EcPk.fromPem((String)(Object)agent);
	}

	public void getAgentAsync(final Callback1<EcPk> success, final Callback1<String> failure)
	{
		success.$invoke(EcPk.fromPem((String)(Object)agent));
	}

	public String getSubjectName()
	{
		if (subject == null)
			return "Nobody";
		EcPk subjectPk = getSubject();
		EcIdentity identity = EcIdentityManager.getIdentity(subjectPk);
		if (identity != null && identity.displayName != null)
			return identity.displayName + " (You)";
		EcContact contact = EcIdentityManager.getContact(subjectPk);
		if (contact == null || contact.displayName == null)
			return "Unknown Subject";
		return contact.displayName;
	}

	public void getSubjectNameAsync(final Callback1<String> success, final Callback1<String> failure)
	{
		if (subject == null)
		{
			success.$invoke("Nobody");
			return;
		}
		getSubjectAsync(new Callback1<EcPk>()
		{
			@Override
			public void $invoke(EcPk subjectPk)
			{
				EcIdentity identity = EcIdentityManager.getIdentity(subjectPk);
				if (identity != null && identity.displayName != null)
				{
					success.$invoke(identity.displayName + " (You)");
					return;
				}
				EcContact contact = EcIdentityManager.getContact(subjectPk);
				if (contact == null || contact.displayName == null)
				{
					success.$invoke("Unknown Subject");
					return;
				}
				success.$invoke(contact.displayName);
			}
		}, failure);
	}

	public String getAgentName()
	{
		if (agent == null)
			return "Nobody";
		EcPk agentPk = getAgent();
		EcIdentity identity = EcIdentityManager.getIdentity(agentPk);
		if (identity != null && identity.displayName != null)
			return identity.displayName + " (You)";
		EcContact contact = EcIdentityManager.getContact(agentPk);
		if (contact == null || contact.displayName == null)
			return "Unknown Agent";
		return contact.displayName;
	}

	public void getAgentNameAsync(final Callback1<String> success, final Callback1<String> failure)
	{
		if (subject == null)
		{
			success.$invoke("Nobody");
			return;
		}
		getAgentAsync(new Callback1<EcPk>()
		{
			@Override
			public void $invoke(EcPk subjectPk)
			{
				EcIdentity identity = EcIdentityManager.getIdentity(subjectPk);
				if (identity != null && identity.displayName != null)
				{
					success.$invoke(identity.displayName + " (You)");
					return;
				}
				EcContact contact = EcIdentityManager.getContact(subjectPk);
				if (contact == null || contact.displayName == null)
				{
					success.$invoke("Unknown Agent");
					return;
				}
				success.$invoke(contact.displayName);
			}
		}, failure);
	}

	public Long getAssertionDate()
	{
		return (Long)(Object)assertionDate;
	}

	public void getAssertionDateAsync(final Callback1<Long> success, final Callback1<String> failure)
	{
		success.$invoke((Long)(Object)assertionDate);
	}

	public Long getExpirationDate()
	{
		return (Long)(Object)expirationDate;
	}

	public void getExpirationDateAsync(final Callback1<Long> success, final Callback1<String> failure)
	{
		success.$invoke((Long)(Object)expirationDate);
	}

	public int getEvidenceCount()
	{
		if (evidence == null)
			return 0;
		return evidence.$length();
	}

	public String getEvidence(int index)
	{
		return (String)(Object)evidence.$get(index);
	}

	public void getEvidenceAsync(int index, final Callback1<String> success, final Callback1<String> failure)
	{
		success.$invoke((String)(Object)evidence.$get(index));
	}

	public String getDecayFunction()
	{
		return (String)(Object)decayFunction;
	}

	public void getDecayFunctionAsync(final Callback1<String> success, final Callback1<String> failure)
	{
		success.$invoke((String)(Object)decayFunction);
	}

	public Boolean getNegative()
	{
		return "true".equals(negative);
	}

	public void getNegativeAsync(final Callback1<Boolean> success, final Callback1<String> failure)
	{
		success.$invoke("true".equals(negative));
	}

	/**
	 * Sets the subject of an assertion. Makes a few assumptions: Owners of the
	 * object should be able to see and change the encrypted value. Owners and
	 * readers of the object should be persisted.
	 *
	 * @param pk
	 */
	public void setSubject(EcPk pk)
	{
		Array<String> owners = new Array<String>();
		Array<String> readers = reader;
		if (readers == null)
			readers = new Array<String>();
		if (subject != null)
		{
			if (subject.owner != null)
				owners.concat(subject.owner);
			if (subject.reader != null)
				readers.concat(subject.reader);
		}
		if (owner != null)
			owners = owners.concat(owner);
		readers.push(pk.toPem());
		subject = (EcEncryptedValue)(Object)pk.toPem();
	}

	public void setAgent(EcPk pk)
	{
		agent = (EcEncryptedValue)(Object)pk.toPem();
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
		evidence = (Array)evidences;
	}

	public void setAssertionDate(Long assertionDateMs)
	{
		assertionDate = (EcEncryptedValue)(Object)assertionDateMs;
	}

	public void setExpirationDate(Long expirationDateMs)
	{
		expirationDate = (EcEncryptedValue)(Object)expirationDateMs;
	}

	public void setDecayFunction(String decayFunctionText)
	{
		decayFunction = (EcEncryptedValue)(Object)decayFunctionText;
	}

	public void setNegative(Boolean negativeB)
	{
		negative = (EcEncryptedValue)(Object)negativeB;
	}


	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (TYPE_0_1.equals(type))
		{
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(Cass.context_0_2, TYPE_0_2);
		}
		if (TYPE_0_2.equals(getFullType()))
		{
			setContextAndType(Cass.context_0_3, TYPE_0_3);
		}
		if (TYPE_0_3.equals(getFullType()))
		{
			setContextAndType(Cass.context_0_4, TYPE_0_4);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_4);
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
