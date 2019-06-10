package org.cassproject.schema.cass.profile;

import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.schema.ebac.EbacEncryptedSecret;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.schema.cass.Cass;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Container for storing assertions and the secrets used to decrypt those assertions.
 *
 * @author fritz.ray@eduworks.com
 * @class AssertionEnvelope
 * @extends CreativeWork
 * @module org.cassproject
 */
public class AssertionEnvelope extends CreativeWork {
	private static final String TYPE_0_5 = "http://schema.cassproject.org/0.4/AssertionEnvelope";
	public static final String myType = TYPE_0_5;

	public AssertionEnvelope() {
		setContextAndType(Cass.context_0_6, myType);
	}

	/***
	 * List of assertions to pack in the envelope.
	 *
	 * @property assertion
	 * @type Assertion[]
	 */
	public Array<Assertion> assertion;

	/***
	 * List of secrets found in assertions to the objects necessary to decrypt the assertion data.
	 *
	 * @property codebook
	 * @type AssertionCodebook[]
	 */
	public Array<AssertionCodebook> codebook;

	public int length() {
		if (assertion != null)
			return assertion.$length();
		return 0;
	}

    /***
     * Removes an assertion from the envelope
     * @param assertionShortIdToRemove
     * @method removeAssertionByShortId
     */
	public void removeAssertionByShortId(String assertionShortIdToRemove) {
        if (assertion != null) {
            for (int i=0;i<assertion.$length();i++) {
                if (getAssertion(i).shortId().equals(assertionShortIdToRemove)) {
                    assertion.splice(i, 1);
                    break;
                }
            }
        }
        if (codebook != null) {
            for (int i=0;i<codebook.$length();i++) {
                if (codebook.$get(i).assertionShortId.equals(assertionShortIdToRemove)) {
                    codebook.splice(i, 1);
                    break;
                }
            }
        }
    }

	/***
	 * Returns the assertion indexed at position @index.
	 * @param index
	 * @method getAssertion
	 * @return
	 */
	public Assertion getAssertion(int index) {
		if (assertion != null)
			if (index < assertion.$length()) {
				if (Assertion.codebooks == null)
					Assertion.codebooks = new Object();
				Assertion a = new Assertion();
				a.copyFrom(assertion.$get(index));
				JSObjectAdapter.$put(Assertion.codebooks,a.id,codebook.$get(index));
				return a;
			}
		return null;
	}

	/***
	 * Adds the assertion to the envelope and adds the keys necessary to decode the assertion to the envelope.
	 * @param a Assertion to add.
	 * @method addAssertion
	 */
	public void addAssertion(Assertion a) {
		AssertionEnvelope me = this;

		final AssertionCodebook ac = new AssertionCodebook();
		if (assertion == null)
			assertion = new Array<>();
		assertion.push(a);
		if (codebook == null)
			codebook = new Array<>();
		codebook.push(ac);
		if (a.shortId() != null)
			ac.assertionShortId = a.shortId();

		if (a.agent != null)
			ac.agent = a.agent.decryptSecret();
		if (a.subject != null)
			ac.subject = a.subject.decryptSecret();
		if (a.assertionDate != null)
			ac.assertionDate = a.assertionDate.decryptSecret();
		if (a.expirationDate != null)
			ac.expirationDate = a.expirationDate.decryptSecret();
		if (a.decayFunction != null)
			ac.decayFunction = a.decayFunction.decryptSecret();
		if (a.negative != null)
			ac.negative = a.negative.decryptSecret();
		if (a.evidence != null)
			for (int i = 0; i < a.evidence.$length(); i++) {
				if (ac.evidence == null)
					ac.evidence = new Array<EbacEncryptedSecret>();
				EcEncryptedValue ecEncryptedValue = a.evidence.$get(i);
				ac.evidence.push(ecEncryptedValue.decryptSecret());
			}
	}

	/***
	 * Adds the assertion to the envelope and adds the keys necessary to decode the assertion to the envelope.
	 * @param a Assertion to add.
	 * @param success Event to call when success occurs.
	 * @param failure Event to call when failure occurs.
	 * @method addAssertionAsync
	 */
	public void addAssertionAsync(final Assertion a, final Callback0 success, final Callback1<String> failure) {
		AssertionEnvelope me = this;

		final AssertionCodebook ac = new AssertionCodebook();
		if (assertion == null)
			assertion = new Array<>();
		assertion.push(a);
		if (codebook == null)
			codebook = new Array<>();
		codebook.push(ac);

		Array<Callback1<Callback0>> thingsToRun = new Array<>();
		EcAsyncHelper<Callback1<Callback0>> eah = new EcAsyncHelper<>();

		if (a.agent != null)
			thingsToRun.push(new Callback1<Callback0>() {
				@Override
				public void $invoke(final Callback0 finished) {
					a.agent.decryptSecretAsync(new Callback1<EbacEncryptedSecret>() {
						@Override
						public void $invoke(EbacEncryptedSecret secret) {
							ac.agent = secret;
							finished.$invoke();
						}
					}, failure);
				}
			});

		if (a.subject != null)
			thingsToRun.push(new Callback1<Callback0>() {
				@Override
				public void $invoke(final Callback0 finished) {
					a.subject.decryptSecretAsync(new Callback1<EbacEncryptedSecret>() {
						@Override
						public void $invoke(EbacEncryptedSecret secret) {
							ac.subject = secret;
							finished.$invoke();
						}
					}, failure);
				}
			});

		if (a.assertionDate != null)
			thingsToRun.push(new Callback1<Callback0>() {
				@Override
				public void $invoke(final Callback0 finished) {
					a.assertionDate.decryptSecretAsync(new Callback1<EbacEncryptedSecret>() {
						@Override
						public void $invoke(EbacEncryptedSecret secret) {
							ac.assertionDate = secret;
							finished.$invoke();
						}
					}, failure);
				}
			});
		if (a.expirationDate != null)
			thingsToRun.push(new Callback1<Callback0>() {
				@Override
				public void $invoke(final Callback0 finished) {
					a.expirationDate.decryptSecretAsync(new Callback1<EbacEncryptedSecret>() {
						@Override
						public void $invoke(EbacEncryptedSecret secret) {
							ac.expirationDate = secret;
							finished.$invoke();
						}
					}, failure);

				}
			});
		if (a.decayFunction != null)
			thingsToRun.push(new Callback1<Callback0>() {
				@Override
				public void $invoke(final Callback0 finished) {
					a.decayFunction.decryptSecretAsync(new Callback1<EbacEncryptedSecret>() {
						@Override
						public void $invoke(EbacEncryptedSecret secret) {
							ac.decayFunction = secret;
							finished.$invoke();
						}
					}, failure);
				}
			});
		if (a.negative != null)
			thingsToRun.push(new Callback1<Callback0>() {
				@Override
				public void $invoke(final Callback0 finished) {
					a.negative.decryptSecretAsync(new Callback1<EbacEncryptedSecret>() {
						@Override
						public void $invoke(EbacEncryptedSecret secret) {
							ac.negative = secret;
							finished.$invoke();
						}
					}, failure);
				}
			});
		if (a.evidence != null)
			thingsToRun.push(new Callback1<Callback0>() {
				@Override
				public void $invoke(final Callback0 finished) {
					EcAsyncHelper<EcEncryptedValue> eah = new EcAsyncHelper<>();
					eah.each(a.evidence, new Callback2<EcEncryptedValue, Callback0>() {
						@Override
						public void $invoke(EcEncryptedValue ecEncryptedValue, final Callback0 callback0) {
							ecEncryptedValue.decryptSecretAsync(new Callback1<EbacEncryptedSecret>() {
								@Override
								public void $invoke(EbacEncryptedSecret ebacEncryptedSecret) {
									if (ebacEncryptedSecret != null) {
										if (ac.evidence == null)
											ac.evidence = new Array<EbacEncryptedSecret>();
										ac.evidence.push(ebacEncryptedSecret);
									}
									callback0.$invoke();
								}
							}, failure);
						}
					}, new Callback1<Array<EcEncryptedValue>>() {
						@Override
						public void $invoke(Array<EcEncryptedValue> strings) {
							finished.$invoke();
						}
					});
				}
			});
		eah.each(thingsToRun, new Callback2<Callback1<Callback0>, Callback0>() {
			@Override
			public void $invoke(Callback1<Callback0> theThingToDo, Callback0 callback0) {
				theThingToDo.$invoke(callback0);
			}
		}, new Callback1<Array<Callback1<Callback0>>>() {
			@Override
			public void $invoke(Array<Callback1<Callback0>> strings) {
				success.$invoke();
			}
		});
	}

	/***
	 * Validates that all assertions have not been tampered with (are authentic).
	 * Does not validate the sources of assertions.
	 * @return True IFF assertions are authentic.
	 * @method validate
	 */
	public boolean validate() {
		if (assertion != null)
			for (int i = 0; i < assertion.$length(); i++)
				if (assertion.$get(i).invalid())
					return false;
		return true;
	}


}
