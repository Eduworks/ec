package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;

public class RollupRule extends Thing
{
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/rollupRule";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/RollupRule";
	public static final String myType = TYPE_0_3;

	public RollupRule()
	{
		setContextAndType(Cass.context, myType);
	}

	public String rule;
	public String outcome;
	public String competency;
	public String mime;

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
