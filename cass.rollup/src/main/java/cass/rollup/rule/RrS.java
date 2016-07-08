package cass.rollup.rule;

import org.stjs.javascript.Array;

public class RrS
{
	Array<RrToken> token;
	Array<RrQuery> query;

	public RrS()
	{
		token = new Array<RrToken>();
		query = new Array<RrQuery>();
	}

	public void addToken(RrToken rrToken)
	{
		token.push(rrToken);
	}

	public void addQuery(RrQuery rrQuery)
	{
		query.push(rrQuery);
	}

}
