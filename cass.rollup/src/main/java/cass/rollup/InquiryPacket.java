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
	public Array<EcPk> subject;
	public EcCompetency competency;
	public EcFramework context;
	public Callback1<InquiryPacket> success;
	public EcCallbackReturn1<String> ask;
	public Callback1<String> failure;
	public EcLevel level;
	
	public Array<InquiryPacket> equivalentPackets;
	public Array<InquiryPacket> subPackets;
	
	public double dateCreated; 
	
	public boolean checkedAssertionsAboutCompetency = false;
	public boolean checkedRollupRulesAboutCompetency = false;
	public boolean foundRollupRuleAboutCompetency = false;
	public boolean checkedDefaultRuleAboutCompetency = false;
	
	public int queriesRunning;
	public String log;
	public Array<EcAssertion> positive;
	public Array<EcAssertion> negative;
	
	public Boolean status;
	public Boolean finished;
	
	public InquiryPacket(Array<EcPk> subject2, EcCompetency competency2, EcLevel level2, EcFramework context2, Callback1<InquiryPacket> success2, Callback1<String> failure2)
	{
		positive = new Array<EcAssertion>();
		negative = new Array<EcAssertion>();
		equivalentPackets = new Array<InquiryPacket>();
		subPackets = new Array<InquiryPacket>();
		dateCreated = new Date().getTime();
		subject = subject2;
		competency = competency2;
		level = level2;
		context = context2;
		success = success2;
		failure = failure2;
		log = "";
	}

	public EcFramework getContext()
	{
		return context;		
	}

}
