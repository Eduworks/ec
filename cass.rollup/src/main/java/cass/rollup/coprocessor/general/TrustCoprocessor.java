package cass.rollup.coprocessor.general;

import cass.rollup.InquiryPacket;
import cass.rollup.coprocessor.AssertionCoprocessor;
import com.eduworks.ec.array.EcObject;
import com.eduworks.ec.crypto.EcPk;
import org.cass.profile.EcAssertion;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback0;

public class TrustCoprocessor extends AssertionCoprocessor {

    public EcPk agent;
    public double multiplier = 1.0;
    public boolean removeNoConfidence = false;

    public void mutateAssertions(InquiryPacket ip, Array<String> listOfCompetencies, Callback0 success) {
        Array<String> keys = EcObject.keys(this.assertionProcessor.assertions);
        for (int keyIndex = 0; keyIndex < keys.$length(); keyIndex++) {
            Array<EcAssertion> ary = (Array) JSObjectAdapter.$get(this.assertionProcessor.assertions, keys.$get(keyIndex));
            for (int i = 0; i < ary.$length(); i++) {
                EcAssertion a = ary.$get(i);
                if (a.getAgent().toPem() == agent.toPem()) {
                    a.confidence = a.confidence * multiplier;
                    if (removeNoConfidence && a.confidence == 0.0)
                        ary.splice(i--, 1);
                }
            }
        }
        success.$invoke();
    }
}
