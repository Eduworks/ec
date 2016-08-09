package cass.rollup;

import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.competency.EcLevel;
import org.cass.profile.EcAssertion;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallbackReturn1;
import com.eduworks.ec.crypto.EcPk;

public class InquiryPacket
{
   
   public enum IPType {COMPETENCY, ROLLUPRULE, COMBINATOR_AND, COMBINATOR_OR}
   
	public Array<EcPk> subject;
	public EcCompetency competency;
	public EcFramework context;
	public Callback1<InquiryPacket> success;
	public EcCallbackReturn1<String> ask;
	public Callback1<String> failure;
	public EcLevel level;
	
	public Array<InquiryPacket> equivalentPackets;
	//public Array<InquiryPacket> narrowsPackets;
	//public Array<InquiryPacket> requiresPackets;
	public Array<InquiryPacket> subPackets;
	
	public double dateCreated; 
	
	public boolean hasCheckedAssertionsForCompetency = false;
	public boolean hasCheckedRollupRulesForCompetency = false;
	public boolean hasCheckedRelationshipsForCompetency = false;
	//public boolean hasCheckedEquivalenciesForCompetency = false;
	
	
	//public boolean hasFoundRollupRuleForCompetency = false;
	
	public int numberOfQueriesRunning;
	public String log;
	public Array<EcAssertion> positive;
	public Array<EcAssertion> negative;
	
	public Boolean status;
	public Boolean finished = false;
	
	public IPType type;
	
	public String rule;
	
	public InquiryPacket(Array<EcPk> subject, EcCompetency competency, EcLevel level, EcFramework context, 
	                     Callback1<InquiryPacket> success, Callback1<String> failure, String rule, IPType type)
	{
		positive = new Array<EcAssertion>();
		negative = new Array<EcAssertion>();
		equivalentPackets = new Array<InquiryPacket>();
		subPackets = new Array<InquiryPacket>();
		dateCreated = new Date().getTime();
		this.subject = subject;
		this.competency = competency;
		this.level = level;
		this.context = context;
		this.success = success;
		this.failure = failure;
		this.rule = rule;
		this.type = type;
		log = "";
	}

	public EcFramework getContext()
	{
		return context;		
	}

}
