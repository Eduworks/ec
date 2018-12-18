package org.cass.profile;

import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.crypto.EcPk;
import org.cass.competency.EcCompetency;
import org.cassproject.ebac.identity.EcContact;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.profile.Assertion;
import org.cassproject.schema.cass.profile.AssertionCodebook;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.Thing;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * The sequence that assertions should be built as such: 1. Generate the ID. 2.
 * Add the owner. 3. Set the subject. 4. Set the agent. Further functions may be
 * called afterwards in any order. WARNING: The modifications of ownership and
 * readership do not "just work".
 *
 * @author fritz.ray@eduworks.com
 */
public class EcAssertion extends Assertion {
	public static void get(String id, final Callback1<EcAssertion> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcAssertion assertion = new EcAssertion();
				if (p1.isAny(assertion.getTypes())) {
					assertion.copyFrom(p1);

					if (success != null)
						success.$invoke(assertion);
				} else {
					String msg = "Retrieved object was not an assertion";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}
			}
		}, failure);
	}

	public static void search(EcRepository repo, String query, final Callback1<Array<EcAssertion>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = new EcAssertion().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<EcAssertion> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {
						EcAssertion assertion = new EcAssertion();
						assertion.copyFrom(p1.$get(i));
						ret.$set(i, assertion);
					}

					success.$invoke(ret);
				}
			}

		}, failure);
	}

	public EcPk getSubject() {
		if (subject == null)
			return null;

		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(subject);

		AssertionCodebook codebook = Assertion.getCodebook(this);
		String decryptedString;
		if (codebook != null)
			decryptedString = v.decryptIntoStringUsingSecret(codebook.subject);
		else {
			decryptedString = v.decryptIntoString();
		}
		if (decryptedString == null)
			return null;
		return EcPk.fromPem(decryptedString);
	}

	/**
	 * Sets the subject of an assertion. Makes a few assumptions: Owners of the
	 * object should be able to see and change the encrypted value. Owners and
	 * readers of the object should be persisted.
	 *
	 * @param pk
	 */
	public void setSubject(EcPk pk) {
		Array<String> owners = new Array<String>();
		Array<String> readers = null;

		if (reader == null)
			readers = new Array<String>();
		else
			readers = (Array) Global.JSON.parse(Global.JSON.stringify(reader));

		if (subject != null) {
			if (subject.owner != null)
				owners.concat(subject.owner);
			if (subject.reader != null)
				readers.concat(subject.reader);
		}

		if (owner != null)
			owners = owners.concat(owner);

		readers.push(pk.toPem());
		subject = EcEncryptedValue.encryptValue(pk.toPem(), id, owners, readers);
	}

	public void getSubjectAsync(final Callback1<EcPk> success, final Callback1<String> failure) {
		if (subject == null) {
			success.$invoke(null);
			return;
		}
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(subject);
		Callback1<String> decrypted = new Callback1<String>() {
			@Override
			public void $invoke(String decryptedString) {
				if (decryptedString == null)
					failure.$invoke("Could not decrypt subject.");
				else
					success.$invoke(EcPk.fromPem(decryptedString));
			}
		};
		AssertionCodebook codebook = Assertion.getCodebook(this);
		if (codebook != null)
			v.decryptIntoStringUsingSecretAsync(codebook.subject, decrypted, failure);
		else
			v.decryptIntoStringAsync(decrypted, failure);
	}

	public EcPk getAgent() {
		if (agent == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(agent);
		AssertionCodebook codebook = Assertion.getCodebook(this);
		String decryptedString;
		if (codebook != null)
			decryptedString = v.decryptIntoStringUsingSecret(codebook.agent);
		else {
			decryptedString = v.decryptIntoString();
		}
		if (decryptedString == null)
			return null;
		return EcPk.fromPem(decryptedString);
	}

	public void setAgent(EcPk pk) {
		agent = EcEncryptedValue.encryptValue(pk.toPem(), id, subject.owner, subject.reader);
	}

	public void getAgentAsync(final Callback1<EcPk> success, final Callback1<String> failure) {
		if (agent == null) {
			success.$invoke(null);
			return;
		}
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(agent);
		Callback1<String> decrypted = new Callback1<String>() {
			@Override
			public void $invoke(String decryptedString) {
				if (decryptedString == null)
					failure.$invoke("Could not decrypt agent.");
				else
					success.$invoke(EcPk.fromPem(decryptedString));
			}
		};
		AssertionCodebook codebook = Assertion.getCodebook(this);
		if (codebook != null)
			v.decryptIntoStringUsingSecretAsync(codebook.agent, decrypted, failure);
		else
			v.decryptIntoStringAsync(decrypted, failure);
	}

	public String getSubjectName() {
		if (subject == null)
			return "Nobody";
		EcPk subjectPk = getSubject();
		String name = getNameByPkBlocking(subjectPk);
		if (name != null)
			return name;
		return "Unknown Subject";
	}

	public void getSubjectNameAsync(final Callback1<String> success, final Callback1<String> failure) {
		if (subject == null) {
			success.$invoke("Nobody");
			return;
		}
		getSubjectAsync(getNameByPk(success, failure, "Unknown Subject"), failure);
	}

	public String getAgentName() {
		if (agent == null)
			return "Nobody";
		EcPk agentPk = getAgent();
		String name = getNameByPkBlocking(agentPk);
		if (name != null)
			return name;
		return "Unknown Agent";
	}

	public void getAgentNameAsync(final Callback1<String> success, final Callback1<String> failure) {
		if (subject == null) {
			success.$invoke("Nobody");
			return;
		}
		getAgentAsync(getNameByPk(success, failure, "Unknown Agent"), failure);
	}

	public static Callback1<EcPk> getNameByPk(final Callback1<String> success, final Callback1<String> failure, final String dflt) {
		return new Callback1<EcPk>() {
			@Override
			public void $invoke(final EcPk pk) {
				EcIdentity identity = EcIdentityManager.getIdentity(pk);
				if (identity != null && identity.displayName != null)
					if (identity.displayName != "You" && identity.displayName.indexOf("Alias") != -1) {
						success.$invoke(identity.displayName + " (You)");
						return;
					}
				EcContact contact = EcIdentityManager.getContact(pk);
				if (contact != null && contact.displayName != null)
					if (contact.displayName != "You" && contact.displayName.indexOf("Alias") != -1) {
						success.$invoke(contact.displayName);
						return;
					}
				final EcAsyncHelper<EcRepository> repoHelper = new EcAsyncHelper<>();
				repoHelper.each(EcRepository.repos, new Callback2<EcRepository, Callback0>() {
					@Override
					public void $invoke(EcRepository ecRepository, final Callback0 callback0) {
						String url = ecRepository.selectedServer;
						if (url == null) {
							callback0.$invoke();
							return;
						}
						if (url.endsWith("/") == false)
							url += "/";
						url += "data/" + pk.fingerprint();
						EcRepository.get(url, new Callback1<EcRemoteLinkedData>() {
							@Override
							public void $invoke(EcRemoteLinkedData personOrOrganization) {
								EcEncryptedValue e = new EcEncryptedValue();
								if (personOrOrganization.isAny(e.getTypes())) {
									e.copyFrom(personOrOrganization);
									e.decryptIntoObjectAsync(new Callback1<EcRemoteLinkedData>() {
										@Override
										public void $invoke(EcRemoteLinkedData decryptedPersonOrOrganization) {
											String name = Thing.getDisplayStringFrom(JSObjectAdapter.$get(decryptedPersonOrOrganization, "name"));
											if (name != null && repoHelper.counter != -1) {
												success.$invoke(name);
												repoHelper.stop();
											} else {
												callback0.$invoke();
												return;
											}
										}
									}, new Callback1<String>() {
										@Override
										public void $invoke(String s) {
											callback0.$invoke();
										}
									});
								} else {
									String name = Thing.getDisplayStringFrom(JSObjectAdapter.$get(personOrOrganization, "name"));
									if (name != null && repoHelper.counter != -1) {
										success.$invoke(name);
										repoHelper.stop();
									} else {
										callback0.$invoke();
										return;
									}
								}
							}
						}, new Callback1<String>() {
							@Override
							public void $invoke(String s) {
								callback0.$invoke();
							}
						});
					}
				}, new Callback1<Array<EcRepository>>() {
					@Override
					public void $invoke(Array<EcRepository> strings) {
						success.$invoke(dflt);
					}
				});
			}
		};
	}

	public static String getNameByPkBlocking(EcPk agentPk) {
		EcIdentity identity = EcIdentityManager.getIdentity(agentPk);
		if (identity != null && identity.displayName != null)
			if (identity.displayName != "You" && identity.displayName.indexOf("Alias") != -1)
				return identity.displayName + " (You)";
		EcContact contact = EcIdentityManager.getContact(agentPk);
		if (contact != null && contact.displayName != null)
			if (contact.displayName != "You" && contact.displayName.indexOf("Alias") != -1)
				return contact.displayName;
		for (int i = 0; i < EcRepository.repos.$length(); i++) {
			String url = EcRepository.repos.$get(i).selectedServer;
			if (url == null) continue;
			if (url.endsWith("/") == false)
				url += "/";
			url += "data/" + agentPk.fingerprint();
			EcRemoteLinkedData personOrOrganization = EcRepository.getBlocking(url);
			if (personOrOrganization == null) continue;
			EcEncryptedValue e = new EcEncryptedValue();
			if (personOrOrganization.isAny(e.getTypes())) {
				e.copyFrom(personOrOrganization);
				EcRemoteLinkedData decryptedPersonOrOrganization = e.decryptIntoObject();
				if (decryptedPersonOrOrganization != null)
					personOrOrganization = decryptedPersonOrOrganization;
			}
			String name = Thing.getDisplayStringFrom(JSObjectAdapter.$get(personOrOrganization, "name"));
			if (name != null)
				return name;
		}
		return null;
	}

	public Long getAssertionDate() {
		if (assertionDate == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(assertionDate);
		AssertionCodebook codebook = Assertion.getCodebook(this);
		String decryptedString;
		if (codebook != null)
			decryptedString = v.decryptIntoStringUsingSecret(codebook.assertionDate);
		else {
			decryptedString = v.decryptIntoString();
		}
		if (decryptedString == null)
			return null;
		return Long.parseLong(decryptedString);
	}

	public void setAssertionDate(Long assertionDateMs) {
		assertionDate = EcEncryptedValue.encryptValue(assertionDateMs.toString(), id, subject.owner, subject.reader);
	}

	public void getAssertionDateAsync(final Callback1<Long> success, final Callback1<String> failure) {
		if (assertionDate == null) {
			success.$invoke(null);
			return;
		}
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(assertionDate);
		Callback1<String> decrypted = new Callback1<String>() {
			@Override
			public void $invoke(String decryptedString) {
				if (decryptedString == null)
					failure.$invoke("Could not decrypt assertion date.");
				else
					success.$invoke(Long.parseLong(decryptedString));
			}
		};
		AssertionCodebook codebook = Assertion.getCodebook(this);
		if (codebook != null)
			v.decryptIntoStringUsingSecretAsync(codebook.assertionDate, decrypted, failure);
		else
			v.decryptIntoStringAsync(decrypted, failure);
	}

	public Long getExpirationDate() {
		if (expirationDate == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		AssertionCodebook codebook = Assertion.getCodebook(this);
		String decryptedString;
		v.copyFrom(expirationDate);
		if (codebook != null)
			decryptedString = v.decryptIntoStringUsingSecret(codebook.expirationDate);
		else {
			decryptedString = v.decryptIntoString();
		}
		if (decryptedString == null)
			return null;
		return Long.parseLong(decryptedString);
	}

	public void setExpirationDate(Long expirationDateMs) {
		expirationDate = EcEncryptedValue.encryptValue(expirationDateMs.toString(), id, subject.owner, subject.reader);
	}

	public void getExpirationDateAsync(final Callback1<Long> success, final Callback1<String> failure) {
		if (expirationDate == null) {
			success.$invoke(null);
			return;
		}
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(expirationDate);
		Callback1<String> decrypted = new Callback1<String>() {
			@Override
			public void $invoke(String decryptedString) {
				if (decryptedString == null)
					failure.$invoke("Could not decrypt expiration date.");
				else
					success.$invoke(Long.parseLong(decryptedString));
			}
		};
		AssertionCodebook codebook = Assertion.getCodebook(this);
		if (codebook != null)
			v.decryptIntoStringUsingSecretAsync(codebook.expirationDate, decrypted, failure);
		else
			v.decryptIntoStringAsync(decrypted, failure);
	}

	public int getEvidenceCount() {
		if (evidence == null)
			return 0;
		return evidence.$length();
	}

	public String getEvidence(int index) {
		if (evidence == null)
			return null;

		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(evidence.$get(index));
		AssertionCodebook codebook = Assertion.getCodebook(this);
		String decryptedString;
		if (codebook != null)
			decryptedString = v.decryptIntoStringUsingSecret(codebook.evidence.$get(index));
		else {
			decryptedString = v.decryptIntoString();
		}
		return decryptedString;
	}

	public void getEvidenceAsync(int index, final Callback1<String> success, final Callback1<String> failure) {
		if (evidence.$get(index) == null) {
			success.$invoke(null);
			return;
		}
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(evidence.$get(index));
		Callback1<String> decrypted = new Callback1<String>() {
			@Override
			public void $invoke(String decryptedString) {
				if (decryptedString == null)
					failure.$invoke("Could not decrypt evidence.");
				else
					success.$invoke(decryptedString);
			}
		};
		AssertionCodebook codebook = Assertion.getCodebook(this);
		if (codebook != null)
			v.decryptIntoStringUsingSecretAsync(codebook.evidence.$get(index), decrypted, failure);
		else
			v.decryptIntoStringAsync(decrypted, failure);
	}

	public String getDecayFunction() {
		if (decayFunction == null)
			return null;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(decayFunction);
		AssertionCodebook codebook = Assertion.getCodebook(this);
		String decryptedString;
		if (codebook != null)
			decryptedString = v.decryptIntoStringUsingSecret(codebook.decayFunction);
		else {
			decryptedString = v.decryptIntoString();
		}
		if (decryptedString == null)
			return null;
		return decryptedString;
	}

	public void setDecayFunction(String decayFunctionText) {
		decayFunction = EcEncryptedValue.encryptValue(decayFunctionText.toString(), id, subject.owner, subject.reader);
	}

	public void getDecayFunctionAsync(final Callback1<String> success, final Callback1<String> failure) {
		if (decayFunction == null) {
			success.$invoke(null);
			return;
		}
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(decayFunction);
		Callback1<String> decrypted = new Callback1<String>() {
			@Override
			public void $invoke(String decryptedString) {
				if (decryptedString == null)
					failure.$invoke("Could not decrypt decay function.");
				else
					success.$invoke(decryptedString);
			}
		};
		AssertionCodebook codebook = Assertion.getCodebook(this);
		if (codebook != null)
			v.decryptIntoStringUsingSecretAsync(codebook.decayFunction, decrypted, failure);
		else
			v.decryptIntoStringAsync(decrypted, failure);
	}

	public Boolean getNegative() {
		if (negative == null)
			return false;
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(negative);
		AssertionCodebook codebook = Assertion.getCodebook(this);
		String decryptedString;
		if (codebook != null)
			decryptedString = v.decryptIntoStringUsingSecret(codebook.negative);
		else {
			decryptedString = v.decryptIntoString();
		}
		if (decryptedString != null)
			decryptedString.toLowerCase();
		return "true".equals(decryptedString);
	}

	public void setNegative(Boolean negativeB) {
		negative = EcEncryptedValue.encryptValue(negativeB.toString(), id, subject.owner, subject.reader);
	}

	public void getNegativeAsync(final Callback1<Boolean> success, final Callback1<String> failure) {
		if (negative == null) {
			success.$invoke(null);
			return;
		}
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(negative);
		Callback1<String> decrypted = new Callback1<String>() {
			@Override
			public void $invoke(String decryptedString) {
				if (decryptedString == null)
					if (decryptedString == null) {
						failure.$invoke("Could not decrypt negative.");
						return;
					}
				if (decryptedString != null)
					decryptedString.toLowerCase();
				success.$invoke("true".equals(decryptedString));
			}
		};
		AssertionCodebook codebook = Assertion.getCodebook(this);
		if (codebook != null)
			v.decryptIntoStringUsingSecretAsync(codebook.negative, decrypted, failure);
		else
			v.decryptIntoStringAsync(decrypted, failure);
	}

	public void setCompetency(String competencyUrl) {
		competency = competencyUrl;
	}

	public void setLevel(String levelUrl) {
		level = levelUrl;
	}

	public void setConfidence(Double confidenceZeroToOne) {
		confidence = confidenceZeroToOne;
	}

	public void setEvidence(Array<String> evidences) {
		Array<EcEncryptedValue> encryptedValues = new Array<EcEncryptedValue>();
		for (int i = 0; i < evidences.$length(); i++)
			encryptedValues.push(EcEncryptedValue.encryptValue(evidences.$get(i), id, subject.owner, subject.reader));
		evidence = encryptedValues;
	}

	public void save(Callback1<String> success, Callback1<String> failure, EcRepository repo) {
		if (competency == null || competency == "") {
			String msg = "Failing to save: Competency cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		if (subject == null) {
			String msg = "Failing to save: Subject cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		if (agent == null) {
			String msg = "Failing to save: Agent cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		if (confidence == null) {
			String msg = "Failing to save: Confidence cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		if (assertionDate == null) {
			String msg = "Failing to save: Assertion Date cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		if (decayFunction == null) {
			String msg = "Failing to save: Decay Function cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		if (repo == null)
			EcRepository.save(this, success, failure);
		else
			repo.saveTo(this, success, failure);
	}

	@Override
	public void addReader(EcPk newReader) {
		if (agent != null) {
			agent.addReader(newReader);
		}
		if (assertionDate != null) {
			assertionDate.addReader(newReader);
		}
		if (decayFunction != null) {
			decayFunction.addReader(newReader);
		}
		if (evidence != null)
			for (int i = 0; i < evidence.$length(); i++) {
				evidence.$get(i).addReader(newReader);
			}
		if (expirationDate != null) {
			expirationDate.addReader(newReader);
		}
		if (negative != null) {
			negative.addReader(newReader);
		}
		if (subject != null) {
			subject.addReader(newReader);
		}
		super.addReader(newReader);
	}

	@Override
	public void removeReader(EcPk newReader) {
		if (agent != null) {
			agent.removeReader(newReader);
		}
		if (assertionDate != null) {
			assertionDate.removeReader(newReader);
		}
		if (decayFunction != null) {
			decayFunction.removeReader(newReader);
		}
		if (evidence != null)
			for (int i = 0; i < evidence.$length(); i++) {
				evidence.$get(i).removeReader(newReader);
			}
		if (expirationDate != null) {
			expirationDate.removeReader(newReader);
		}
		if (negative != null) {
			negative.removeReader(newReader);
		}
		if (subject != null) {
			subject.removeReader(newReader);
		}
		super.removeReader(newReader);
	}

	public String getSearchStringByTypeAndCompetency(EcCompetency competency) {
		return "(" + getSearchStringByType() + " AND competency:\"" + competency.shortId() + "\")";
	}
}
