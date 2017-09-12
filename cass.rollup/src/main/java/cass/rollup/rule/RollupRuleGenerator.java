package cass.rollup.rule;

import cass.rollup.InquiryPacket;
import org.cass.competency.EcAlignment;
import org.stjs.javascript.functions.Callback1;

public class RollupRuleGenerator
{
	public Callback1<String> failure;
	public Callback1<String> success;
	private String rule;
	private String outerRule;
	private InquiryPacket ip;

	public RollupRuleGenerator(InquiryPacket ip)
	{
		this.ip = ip;
		rule = "";
		outerRule = "";
	}

	public void go()
	{
		final RollupRuleGenerator me = this;
		if (ip.getContext().relation == null)
			success.$invoke(null);
		else
			for (int i = 0; i < ip.getContext().relation.$length(); i++)
			{
				ip.numberOfQueriesRunning++;
				EcAlignment.get(ip.getContext().relation.$get(i), new Callback1<EcAlignment>()
				{
					@Override
					public void $invoke(EcAlignment p1)
					{
						me.ip.numberOfQueriesRunning--;
						if (!p1.source.equals(me.ip.competency) && !p1.target.equals(me.ip.competency))
							return;
						if (p1.source.equals(me.ip.competency))
						{
							if (p1.relationType.equals(EcAlignment.REQUIRES))
							{
								if (me.rule != null && me.rule != "")
									me.rule += " AND ";
								me.rule += "[notNegative competency:\"" + p1.target + "\"]";
							}
							if (p1.relationType.equals(EcAlignment.NARROWS))
							{
								if (me.outerRule != null && me.outerRule != "")
									me.outerRule += " OR ";
								me.outerRule += "[competency:\"" + p1.target + "\"]";
							}
						}
					}
				}, new Callback1<String>()
				{
					@Override
					public void $invoke(String p1)
					{
						me.ip.numberOfQueriesRunning--;
					}
				});
			}
	}
}
