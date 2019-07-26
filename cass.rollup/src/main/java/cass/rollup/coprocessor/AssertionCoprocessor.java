package cass.rollup.coprocessor;

import cass.rollup.InquiryPacket;
import cass.rollup.processors.AssertionProcessor;
import org.cass.profile.EcAssertion;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

/**
 * Created by fray on 5/30/17.
 */
public class AssertionCoprocessor {

	public AssertionProcessor assertionProcessor;

	public void collectAssertions(InquiryPacket ip, Array<String> listOfCompetencies, Callback1<Array<EcAssertion>> success) {
		success.$invoke(new Array<EcAssertion>());
	}
	public void mutateAssertions(InquiryPacket ip, Array<String> listOfCompetencies, Callback0 success) {
		success.$invoke();
	}
}
