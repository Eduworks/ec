package org.cassproject.schema.ebac;

import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.remote.EcRemote;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.identity.EcRekeyRequest;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import static org.stjs.javascript.Global.console;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"/forge/forge.bundle.js"})
public class EcRekeyTest
{
	public static String server = "http://localhost/api/";

	@Before
	public void begin()
	{
		EcRemote.async = false;
		oldKey = EcPpk.generateKey().toPem();
		newerKey = EcPpk.generateKey().toPem();
		newestKey = EcPpk.generateKey().toPem();
	}

	public static String oldKey = null;
	public static String newerKey = null;
	public static String newestKey = null;

	@Test
	public void basicInMemoryForwardingTest()
	{
		EcRemote.async = false;
		EcRemoteLinkedData.forwardingTable = new Object();
		EcRemoteLinkedData rld = new EcRemoteLinkedData("https://cass.test", "TestObject");
		rld.addOwner(EcPpk.fromPem(oldKey).toPk());
		String oldestData = rld.toJson();
		EcRemoteLinkedData.forwardKey(EcPpk.fromPem(oldKey).toPk().toPem(), EcPpk.fromPem(newerKey).toPk().toPem()); //Tests single forward
		rld.copyFrom(JSGlobal.JSON.parse(rld.toJson()));
		Assert.assertEquals(rld.owner.$get(0), EcPpk.fromPem(newerKey).toPk().toPem());
		EcRemoteLinkedData.forwardKey(EcPpk.fromPem(newerKey).toPk().toPem(), EcPpk.fromPem(newestKey).toPk().toPem()); //Tests a second forward
		rld.copyFrom(JSGlobal.JSON.parse(rld.toJson()));
		Assert.assertEquals(rld.owner.$get(0), EcPpk.fromPem(newestKey).toPk().toPem());
		rld.copyFrom(JSGlobal.JSON.parse(oldestData)); //Tests a double forward
		Assert.assertEquals(rld.owner.$get(0), EcPpk.fromPem(newestKey).toPk().toPem());
	}

	@Test
	public void basicRekeyRecordForwardingTest()
	{
		EcIdentityManager.ids.$set(0,new EcIdentity());
		EcIdentityManager.ids.$get(0).ppk = EcPpk.fromPem(newerKey);
		EcRemote.async = false;
		EcRemoteLinkedData.forwardingTable = new Object();
		EcRekeyRequest err = EcRekeyRequest.generateRekeyRequest(server, EcPpk.fromPem(oldKey), EcPpk.fromPem(newerKey));
		EcRepository.save(err, new Callback1<String>()
		{
			@Override
			public void $invoke(String s)
			{
				EcIdentityManager.clearIdentities();
				EcRepository repo = new EcRepository();
				repo.init(server, new Callback0()
				{
					@Override
					public void $invoke()
					{
						EcRemoteLinkedData rld = new EcRemoteLinkedData("https://cass.test", "TestObject");
						rld.addOwner(EcPpk.fromPem(oldKey).toPk());
						rld.copyFrom(JSGlobal.JSON.parse(rld.toJson()));
						Assert.assertEquals(rld.owner.$get(0), EcPpk.fromPem(newerKey).toPk().toPem());
					}
				}, new Callback1<String>()
				{
					@Override
					public void $invoke(String s)
					{
						Assert.fail("Could not init server. " + s);
					}
				});
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String s)
			{
				Assert.fail("Could not save EcRekeyRequest to server. " + s);
			}
		});
	}

	@Test
	public void basicRekeyRecordClientTest()
	{
		EcIdentityManager.ids.$set(0,new EcIdentity());
		EcIdentityManager.ids.$get(0).ppk = EcPpk.fromPem(newerKey);
		EcRemote.async = false;
		EcRemoteLinkedData.forwardingTable = new Object();
		EcRekeyRequest err = EcRekeyRequest.generateRekeyRequest(server, EcPpk.fromPem(oldKey), EcPpk.fromPem(newerKey));
		EcRepository.save(err, new Callback1<String>()
		{
			@Override
			public void $invoke(String s)
			{
				EcIdentityManager.clearIdentities();
				EcRepository repo = new EcRepository();
				repo.init(server, new Callback0()
				{
					@Override
					public void $invoke()
					{
						EcIdentityManager.ids.$set(0,new EcIdentity());
						EcIdentityManager.ids.$get(0).ppk = EcPpk.fromPem(oldKey);
						final EcRemoteLinkedData rld = new EcRemoteLinkedData("https://cass.test", "TestObject");
						rld.generateId(server);
						rld.addOwner(EcPpk.fromPem(oldKey).toPk());
						EcRepository.save(rld, new Callback1<String>()
						{
							@Override
							public void $invoke(String s)
							{
								EcIdentityManager.clearIdentities();
								EcRemoteLinkedData rld2 = EcRepository.getBlocking(rld.shortId());
								Assert.assertEquals(rld2.owner.$get(0), EcPpk.fromPem(newerKey).toPk().toPem());
							}
						}, new Callback1<String>()
						{
							@Override
							public void $invoke(String s)
							{
								Assert.fail("Could not save record that needs to be forwarded. " + s);
							}
						});
					}
				}, new Callback1<String>()
				{
					@Override
					public void $invoke(String s)
					{
						Assert.fail("Could not init server. " + s);
					}
				});
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String s)
			{
				Assert.fail("Could not save EcRekeyRequest to server. " + s);
			}
		});
	}

	@Test
	public void basicRekeyRecordServerTest()
	{
		EcIdentityManager.ids.$set(0,new EcIdentity());
		EcIdentityManager.ids.$get(0).ppk = EcPpk.fromPem(newerKey);
		EcRemote.async = false;
		EcRemoteLinkedData.forwardingTable = new Object();
		EcRekeyRequest err = EcRekeyRequest.generateRekeyRequest(server, EcPpk.fromPem(oldKey), EcPpk.fromPem(newerKey));
		EcRepository.save(err, new Callback1<String>()
		{
			@Override
			public void $invoke(String s)
			{
				EcIdentityManager.clearIdentities();
				EcRepository repo = new EcRepository();
				repo.init(server, new Callback0()
				{
					@Override
					public void $invoke()
					{
						EcIdentityManager.ids.$set(0,new EcIdentity());
						EcIdentityManager.ids.$get(0).ppk = EcPpk.fromPem(oldKey);
						final EcRemoteLinkedData rld = new EcRemoteLinkedData("https://cass.test", "TestObject");
						rld.generateId(server);
						rld.addOwner(EcPpk.fromPem(oldKey).toPk());
						EcEncryptedValue.encryptOnSave(rld.id,true);
						EcRepository.save(rld, new Callback1<String>()
						{
							@Override
							public void $invoke(String s)
							{
								EcIdentityManager.clearIdentities();
								EcIdentityManager.ids.$set(0,new EcIdentity());
								EcIdentityManager.ids.$get(0).ppk = EcPpk.fromPem(oldKey);
								EcRemoteLinkedData rld2 = EcRepository.getBlocking(rld.shortId());
								Assert.assertEquals("Could retreive object, shouldn't be able to.",rld2,null);

								EcIdentityManager.clearIdentities();
								EcIdentityManager.ids.$set(0,new EcIdentity());
								EcIdentityManager.ids.$get(0).ppk = EcPpk.fromPem(newerKey);
								rld2 = EcRepository.getBlocking(rld.shortId());
								Assert.assertEquals("Should not be able to decrypt object, can(?)", EcEncryptedValue.fromEncryptedValue(rld2),null);

								EcIdentityManager.ids.$set(1,new EcIdentity());
								EcIdentityManager.ids.$get(1).ppk = EcPpk.fromPem(oldKey);
								Assert.assertTrue("Should be able to decrypt object, can't", (rld2 = EcEncryptedValue.fromEncryptedValue(rld2)) != null);

								Assert.assertEquals(rld2.owner.$get(0), EcPpk.fromPem(newerKey).toPk().toPem());
							}
						}, new Callback1<String>()
						{
							@Override
							public void $invoke(String s)
							{
								Assert.fail("Could not save record that needs to be forwarded. " + s);
							}
						});
					}
				}, new Callback1<String>()
				{
					@Override
					public void $invoke(String s)
					{
						Assert.fail("Could not init server. " + s);
					}
				});
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String s)
			{
				Assert.fail("Could not save EcRekeyRequest to server. " + s);
			}
		});
	}
}