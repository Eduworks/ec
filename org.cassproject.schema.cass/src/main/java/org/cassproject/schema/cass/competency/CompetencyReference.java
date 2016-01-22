package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

public class CompetencyReference extends Reference
{
	public CompetencyReference(String schema, String type)
	{
		super(Cass.schema, Competency.myType);
	}
	public void copyFrom(Object that)
	{
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		Map<String, Object> you = JSObjectAdapter.$properties(that);
		for (String key : you)
		{
			if (isAtProperty(key))
			if (me.$get(key) == null)
				me.$put(key.replace("@",""),you.$get(key));
		}
	}
}
