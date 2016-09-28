package com.eduworks.ec.graph;

public class Triple<S1, S2, S3>
{
	public S1 source;
	public S2 destination;
	public S3 edge;
	
	@Override
	public boolean equals(Object obj)
	{
		if (super.equals(obj)) return true;
		if (obj instanceof Triple)
		{
			Triple t = (Triple) obj;
			if (source.equals(t.source) && destination.equals(t.destination) && edge.equals(t.edge) )
				return true;
		}
		return false;
	}
}
