package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;

public class RollupRule extends Thing
{
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/rollupRule";
	public static final String myType = TYPE_0_2;

	public RollupRule()
	{
		setContextAndType(Cass.context,myType);
	}

	public String rule;
	public String competency;
	public String language;

	@Override
	protected void upgrade()
	{
		super.upgrade();
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_2);
		return a;
	}

}
