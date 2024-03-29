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
import org.stjs.javascript.functions.Function0;

/**
 * The sequence that assertions should be built as such: 1. Generate the ID. 2.
 * Add the owner. 3. Set the subject. 4. Set the agent. Further functions may be
 * called afterwards in any order. WARNING: The modifications of ownership and
 * readership do not "just work".
 *
 * @author fritz.ray@eduworks.com
 */
public class EcAssertion extends Assertion {

	@Override
	public boolean equals(Object obj) {
		return isId(((EcAssertion)obj).id);
	}

	public static void get(String id, final Callback1<EcAssertion> success, final Callback1<String> failure) {
		EcRepository.getAs(id,new EcAssertion(),success,failure);
	}

	public static EcAssertion getBlocking(String id) {
		return EcRepository.getBlockingAs(id,new EcAssertion());
	}

	public static void search(EcRepository repo, String query, final Callback1<Array<EcAssertion>> success, Callback1<String> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcAssertion();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
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

	public void setSubjectAsync(EcPk pk, final Callback0 success, Callback1<String> failure) {
		final EcAssertion me = this;
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
		EcEncryptedValue.encryptValueAsync(pk.toPem(), id, owners, readers, new Callback1<EcEncryptedValue>() {
			@Override
			public void $invoke(EcEncryptedValue subject) {
				me.subject = subject;
				success.$invoke();
			}
		}, failure);
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

	public void setAgentAsync(EcPk pk, final Callback0 success, Callback1<String> failure) {
		final EcAssertion me = this;
		EcEncryptedValue.encryptValueAsync(pk.toPem(), id, subject.owner, subject.reader, new Callback1<EcEncryptedValue>() {
			@Override
			public void $invoke(EcEncryptedValue agent) {
				me.agent = agent;
				success.$invoke();
			}
		}, failure);
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
						EcIdentity identity = EcIdentityManager.getIdentity(pk);
						if (identity != null && identity.displayName != null) {
							success.$invoke(identity.displayName + " (You)");
							return;
						}
						EcContact contact = EcIdentityManager.getContact(pk);
						if (contact != null && contact.displayName != null) {
							success.$invoke(contact.displayName);
							return;
						}
						success.$invoke(dflt);
					}
				});
			}
		};
	}

	public static String getNameByPkBlocking(EcPk agentPk) {
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
		EcIdentity identity = EcIdentityManager.getIdentity(agentPk);
		if (identity != null && identity.displayName != null)
			return identity.displayName + " (You)";
		EcContact contact = EcIdentityManager.getContact(agentPk);
		if (contact != null && contact.displayName != null)
			return contact.displayName;
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

	public void setAssertionDateAsync(Long assertionDateMs, final Callback0 success, Callback1<String> failure) {
		final EcAssertion me = this;
		EcEncryptedValue.encryptValueAsync(assertionDateMs.toString(), id, subject.owner, subject.reader, new Callback1<EcEncryptedValue>() {
			@Override
			public void $invoke(EcEncryptedValue assertionDate) {
				me.assertionDate = assertionDate;
				success.$invoke();
			}
		}, failure);
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

	public void setExpirationDateAsync(Long expirationDateMs, final Callback0 success, Callback1<String> failure) {
		final EcAssertion me = this;
		EcEncryptedValue.encryptValueAsync(expirationDateMs.toString(), id, subject.owner, subject.reader, new Callback1<EcEncryptedValue>() {
			@Override
			public void $invoke(EcEncryptedValue expirationDate) {
				me.expirationDate = expirationDate;
				success.$invoke();
			}
		}, failure);
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

	public void getEvidencesAsync(final Callback1<Array<String>> success, final Callback1<String> failure){
		final Array<String> results = new Array<>();
		if (evidence != null)
		new EcAsyncHelper<EcEncryptedValue>().each(evidence, new Callback2<EcEncryptedValue, Callback0>() {
			@Override
			public void $invoke(EcEncryptedValue e, final Callback0 callback0) {
				e.decryptIntoStringAsync(new Callback1<String>() {
					@Override
					public void $invoke(String str) {
						results.push(str);
						callback0.$invoke();
					}
				},(Callback1)callback0);
			}
		}, new Callback1<Array<EcEncryptedValue>>() {
			@Override
			public void $invoke(Array<EcEncryptedValue> strings) {
				success.$invoke(results);
			}
		});
		else
			success.$invoke(results);
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
	public void setDecayFunctionAsync(String decayFunctionText, final Callback0 success, Callback1<String> failure) {
		final EcAssertion me = this;
		EcEncryptedValue.encryptValueAsync(decayFunctionText, id, subject.owner, subject.reader, new Callback1<EcEncryptedValue>() {
			@Override
			public void $invoke(EcEncryptedValue decayFunction) {
				me.decayFunction = decayFunction;
				success.$invoke();
			}
		}, failure);
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

	public void setNegativeAsync(Boolean negativeB, final Callback0 success, Callback1<String> failure) {
		final EcAssertion me = this;
		EcEncryptedValue.encryptValueAsync(negativeB.toString(), id, subject.owner, subject.reader, new Callback1<EcEncryptedValue>() {
			@Override
			public void $invoke(EcEncryptedValue negative) {
				me.negative = negative;
				success.$invoke();
			}
		}, failure);
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

	public void setEvidenceAsync(Array<String> evidences, final Callback0 success, Callback1<String> failure) {
		final EcAssertion me = this;
		final Array<EcEncryptedValue> encryptedValues = new Array<EcEncryptedValue>();
		new EcAsyncHelper<String>().each(evidences, new Callback2<String, Callback0>() {
			@Override
			public void $invoke(String s, final Callback0 callback0) {
				EcEncryptedValue.encryptValueAsync(s, me.id, me.subject.owner, me.subject.reader, new Callback1<EcEncryptedValue>() {
					@Override
					public void $invoke(EcEncryptedValue ecEncryptedValue) {
						encryptedValues.push(ecEncryptedValue);
						callback0.$invoke();
					}
				},(Callback1)callback0);
			}
		}, new Callback1<Array<String>>() {
			@Override
			public void $invoke(Array<String> strings) {
				me.evidence = encryptedValues;
				success.$invoke();
			}
		});
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

	public void addReaderAsync(final EcPk newReader, final Callback0 success, final Callback1<String> failure) {
		Array<EcEncryptedValue> ary = new Array<>();

		if (agent != null) {
			ary.push(agent);
		}
		if (assertionDate != null) {
			ary.push(assertionDate);
		}
		if (decayFunction != null) {
			ary.push(decayFunction);
		}
		if (evidence != null)
			for (int i = 0; i < evidence.$length(); i++) {
				ary.push(evidence.$get(i));
			}
		if (expirationDate != null) {
			ary.push(expirationDate);
		}
		if (negative != null) {
			ary.push(negative);
		}
		if (subject != null) {
			ary.push(subject);
		}
		super.addReader(newReader);
		final EcAsyncHelper<EcEncryptedValue> eah = new EcAsyncHelper<>();
		eah.each(ary, new Callback2<EcEncryptedValue, Callback0>() {
			@Override
			public void $invoke(EcEncryptedValue ecEncryptedValue, Callback0 callback0) {
				ecEncryptedValue.addReaderAsync(newReader, callback0, new Callback1<String>() {
					@Override
					public void $invoke(String s) {
						if (!eah.isStopped()) {
							eah.stop();
							failure.$invoke("Failed to add reader to an assertion.");
						}
					}
				});
			}
		}, new Callback1<Array<EcEncryptedValue>>() {
			@Override
			public void $invoke(Array<EcEncryptedValue> strings) {
				success.$invoke();
			}
		});
	}

	public void removeReaderAsync(final EcPk oldReader, final Callback0 success, final Callback1<String> failure) {
		Array<EcEncryptedValue> ary = new Array<>();

		if (agent != null) {
			ary.push(agent);
		}
		if (assertionDate != null) {
			ary.push(assertionDate);
		}
		if (decayFunction != null) {
			ary.push(decayFunction);
		}
		if (evidence != null)
			for (int i = 0; i < evidence.$length(); i++) {
				ary.push(evidence.$get(i));
			}
		if (expirationDate != null) {
			ary.push(expirationDate);
		}
		if (negative != null) {
			ary.push(negative);
		}
		if (subject != null) {
			ary.push(subject);
		}
		super.removeReader(oldReader);
		final EcAsyncHelper<EcEncryptedValue> eah = new EcAsyncHelper<>();
		eah.each(ary, new Callback2<EcEncryptedValue, Callback0>() {
			@Override
			public void $invoke(EcEncryptedValue ecEncryptedValue, Callback0 callback0) {
				ecEncryptedValue.removeReaderAsync(oldReader, callback0, new Callback1<String>() {
					@Override
					public void $invoke(String s) {
						if (!eah.isStopped()) {
							eah.stop();
							failure.$invoke("Failed to remove reader to an assertion.");
						}
					}
				});
			}
		}, new Callback1<Array<EcEncryptedValue>>() {
			@Override
			public void $invoke(Array<EcEncryptedValue> strings) {
				success.$invoke();
			}
		});
	}

	public String getSearchStringByTypeAndCompetency(EcCompetency competency) {
		return "(" + getSearchStringByType() + " AND competency:\"" + competency.shortId() + "\")";
	}
}
