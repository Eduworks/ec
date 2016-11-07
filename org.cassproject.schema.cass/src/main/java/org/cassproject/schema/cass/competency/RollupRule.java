package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Intangible;
import org.stjs.javascript.Array;

/**
 * A segment of script that defines in a domain specific language how competence is transferred from one competency to another.
 * 
 * @author fritz.ray@eduworks.com
 * 
 *
 */
public class RollupRule extends Intangible
{
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/rollupRule";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/RollupRule";
	public static final String myType = TYPE_0_3;

	public RollupRule()
	{
		setContextAndType(Cass.context, myType);
	}

	/**
	 * The rollup rule encoded as source code that is understandable to the assertion processor.
	 * @property rule
	 * @type string
	 */
	public String rule;
	/**
	 * Specifies the URL of the competency that the rollup rule pertains to.
	 * @property competency
	 * @type string
	 */
	public String competency;

	@Override
	protected void upgrade()
	{
		super.upgrade();
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
		return a;
	}
}
