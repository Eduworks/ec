package cass.rollup.ctdl;

import cass.rollup.subprocessor.CredentialCompetencyLocator;
import com.eduworks.ec.remote.EcRemote;
import org.credentialengine.CredentialAlignmentObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
public class CtdlProcessingTest {

    /*
    EXAMPLES*************************************************************************

    certificate with requires with ConditionProfile with targetAssessment
        https://army.cass.eduworks.us/api/custom/data/ce-7473c35e-8ef3-45f5-8bb3-112bf27b2537

    certificate with requires with ConditionProfile with targetLearningOpportunity
        https://army.cass.eduworks.us/api/custom/data/ce-B931CF19-875A-42D5-809F-7A016F86BE5B

    certificate with requires with ConditionProfile with MULTIPLE targetAssessment
        https://army.cass.eduworks.us/api/custom/data/ce-f46d9f10-f458-4038-a867-194a58983802

    certificate with requires with ConditionProfile with targetAssessment AND targetLearningOpportunity
        https://army.cass.eduworks.us/api/custom/data/ce-76830FCD-3E4E-42F3-97D2-BF1A5533EEF6
        https://army.cass.eduworks.us/api/custom/data/ce-25F2621F-2A2B-4D93-9E86-7D7D8E02A2DB

    certificate with requires with ConditionProfile with no targetAssessment or targetLearningOpportunity
        https://army.cass.eduworks.us/api/custom/data/ce-C57948C2-6636-4ED3-9B51-BC5A9EC56D88
        https://army.cass.eduworks.us/api/custom/data/ce-83698963-1a06-4a00-810f-9b9da9348877

    certificate with MULTIPLE requires - one of the requires has MULTIPLE targetAssessment and MULTIPLE targetLearningOpportunity - one has a targetCredential
        https://army.cass.eduworks.us/api/custom/data/urn:ctid:14525AEA-57C5-4F5A-8F1C-BDC95C7F8B9C
     */

	//private static final String CREDENTIAL_LOCATOR = "https://army.cass.eduworks.us/api/custom/data/ce-f46d9f10-f458-4038-a867-194a58983802";
	private static final String CREDENTIAL_LOCATOR = "https://army.cass.eduworks.us/api/custom/data/ce-C57948C2-6636-4ED3-9B51-BC5A9EC56D88";
	//private static final String CREDENTIAL_LOCATOR = "https://army.cass.eduworks.us/api/custom/data/urn:ctid:14525AEA-57C5-4F5A-8F1C-BDC95C7F8B9C";

	private static final String RESOURCE_LOCATOR_URL = "https://army.cass.eduworks.us/api/data/";
	private static final boolean STRIP_ID = true; //tries to get the proper ID from a foreign URL see https://army.cass.eduworks.us/api/custom/data/urn:ctid:14525AEA-57C5-4F5A-8F1C-BDC95C7F8B9C

	private CredentialCompetencyLocator buildAndConfigureLocator() {
		EcRemote.async = false;
		final CredentialCompetencyLocator ccl = new CredentialCompetencyLocator();
		ccl.credentialLocator = CREDENTIAL_LOCATOR;
		ccl.stripId = STRIP_ID;
		ccl.success = new Callback1<Array<CredentialAlignmentObject>>() {
			@Override
			public void $invoke(Array<CredentialAlignmentObject> ca) {
				Global.console.log("CredentialCompetencyLocator success :)");
				Global.console.log("Object: " + ca);
				Global.console.log("CredentialCompetencyLocator log: ");
				for (int i = 0; i < ccl.logBuffer.$length(); i++) {
					Global.console.log("   " + ccl.logBuffer.$get(i));
				}

				Global.console.log("******************FINAL Competency List(" + ca.$length() + "): ");
				for (int j = 0; j < ca.$length(); j++) {
					Global.console.log("   framework:" + ca.$get(j).framework);
					Global.console.log("   competency:" + ca.$get(j).targetNode);
				}
				Assert.assertSame(true, true);
			}
		};
		ccl.failure = new Callback1<String>() {
			@Override
			public void $invoke(String er) {
				Global.console.log("CompetencyGraphBuilder failed : " + er);
				Global.console.log("CredentialCompetencyLocator log: ");
				for (int i = 0; i < ccl.logBuffer.$length(); i++) {
					Global.console.log("   " + ccl.logBuffer.$get(i));
				}
				Assert.fail();
			}
		};
		return ccl;

	}

	@Test
	public void basicCtdlTest() {
		Global.console.log("Start basicCtdlTest");
		CredentialCompetencyLocator ccl = buildAndConfigureLocator();
		ccl.locateCompetencies();
	}

}
