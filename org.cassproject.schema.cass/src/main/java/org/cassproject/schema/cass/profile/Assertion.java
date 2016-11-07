package org.cassproject.schema.cass.profile;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.schema.cass.Cass;
import org.schema.Intangible;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * A claim of competence in CASS is called an Assertion. It states with some confidence that an individual has mastered a competency at a given level, provides evidence of such mastery, and records data such as the time of assertion and the party making the assertion.
 * @author fritz.ray@eduworks.com
 * @class Assertion
 * @module org.cassproject
 *
 */
public class Assertion extends Intangible
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/assertion";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/assertion";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/Assertion";
	public static final String myType = TYPE_0_3;

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
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
