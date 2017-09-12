package org.cassproject.ebac.identity;

import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.crypto.EcRsaOaepAsync;
import com.eduworks.schema.ebac.EbacSignature;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Manages identities and contacts, provides hooks to respond to identity and
 * contact events, and builds signatures and signature sheets for authorizing
 * movement of data. Also provides helper functions for identity management and
 * reads the users contacts on application start with a static constructor that
 * pulls them out of any temporary storage
 *
 * @module com.eduworks.ec
 * @class EcIdentityManager
 * @static
 *
 * @author fritz.ray@eduworks.com
 */
public class EcIdentityManager
{
	
	static boolean async = true;

    public static void main(String[] args)
    {
        readContacts();
    }

    /**
     * The current user's owned identities (keys+displayName)
     *
     * @property ids
     * @type EcIdentity[]
     * @static
     */
    public static Array<EcIdentity> ids = new Array<EcIdentity>();

    /**
     * Contacts (Keys that we do not own)
     *
     * @property contacts
     * @type EcContact[]
     * @static
     */
    public static Array<EcContact> contacts = new Array<EcContact>();

    /**
     * Identity change hook.
     *
     * @property onIdentityChanged
     * @type Callback1<EcIdentity>
     * @static
     */
    public static Callback1<EcIdentity> onIdentityChanged = null;

    /**
     * Contacts change hook.
     *
     * @property onContactChanged
     * @type Callback1<EcIdentity>
     * @static
     */
    public static Callback1<EcContact> onContactChanged = null;

    /**
     * Trigger for the onIdentityChanged hook
     *
     * @memberOf EcIdentityManager
     * @method identityChanged
     * @static
     * @param {EcIdentity} identity Identity that has changed
     */
    public static void identityChanged(EcIdentity identity)
    {
        if (onIdentityChanged != null)
        {
            onIdentityChanged.$invoke(identity);
        }
    }

    /**
     * Trigger for the onContactChanged hook
     *
     * @memberOf EcIdentityManager
     * @method contactChanged
     * @static
     * @param {EcContact} contact Contact that has changed
     */
    public static void contactChanged(EcContact contact)
    {
        if (onContactChanged != null)
        {
            onContactChanged.$invoke(contact);
        }
        saveContacts();
    }

    /**
     * Reads contact data from localstorage.
     *
     * @memberOf EcIdentityManager
     * @method readContacts
     * @static
     */
    public static void readContacts()
    {
        Object localStore = Global.localStorage.$get("contacts");
        if (localStore == null)
        {
            return;
        }
        Array<Object> c = (Array<Object>) JSGlobal.JSON.parse((String) localStore);
        for (int i = 0; i < c.$length(); i++)
        {
            EcContact contact = new EcContact();
            Object o = c.$get(i);
            Map<String, Object> props = JSObjectAdapter.$properties(o);
            contact.displayName = (String) props.$get("displayName");
            contact.pk = EcPk.fromPem((String) props.$get("pk"));
            contact.source = (String) props.$get("source");

            boolean cont = false;
            for (int j = 0; j < contacts.$length(); j++)
            {
                if (contacts.$get(j).pk.toPem() == contact.pk.toPem())
                {
                    cont = true;
                }
            }
            if (cont)
            {
                continue;
            }

            contacts.push(contact);
        }
    }

    /**
     * Writes contact data to localstorage.
     *
     * @memberOf EcIdentityManager
     * @method saveContacts
     * @static
     */
    private static void saveContacts()
    {
        Array<Object> c = new Array<Object>();
        for (int i = 0; i < contacts.$length(); i++)
        {
            Object o = new Object();
            Map<String, Object> props = JSObjectAdapter.$properties(o);
            EcContact contact = contacts.$get(i);
            props.$put("displayName", contact.displayName);
            props.$put("pk", contact.pk.toPem());
            props.$put("source", contact.source);
            c.push(o);
        }
        Global.localStorage.$put("contacts", JSGlobal.JSON.stringify(c));
    }

    /**
     * Reads contact data from localstorage.
     *
     * @memberOf EcIdentityManager
     * @method readIdentities
     * @static
     */
    public static void readIdentities()
    {
        Object localStore = Global.localStorage.$get("identities");
        if (localStore == null)
        {
            return;
        }
        Array<Object> c = (Array<Object>) JSGlobal.JSON.parse((String) localStore);
        for (int i = 0; i < c.$length(); i++)
        {
            EcIdentity identity = new EcIdentity();
            Object o = c.$get(i);
            Map<String, Object> props = JSObjectAdapter.$properties(o);
            identity.displayName = (String) props.$get("displayName");
            identity.ppk = EcPpk.fromPem((String) props.$get("ppk"));
            identity.source = (String) props.$get("source");

            boolean cont = false;
            for (int j = 0; j < ids.$length(); j++)
            {
                if (ids.$get(j).ppk.toPem() == identity.ppk.toPem())
                {
                    cont = true;
                }
            }
            if (cont)
            {
                continue;
            }

            ids.push(identity);
        }
    }

    /**
     * Writes contact data to localstorage.
     *
     * @memberOf EcIdentityManager
     * @method saveIdentities
     * @static
     */
    public static void saveIdentities()
    {
        Array<Object> c = new Array<Object>();
        for (int i = 0; i < ids.$length(); i++)
        {
            Object o = new Object();
            Map<String, Object> props = JSObjectAdapter.$properties(o);
            EcIdentity identity = ids.$get(i);
            props.$put("displayName", identity.displayName);
            props.$put("ppk", identity.ppk.toPem());
            props.$put("source", identity.source);
            c.push(o);
        }
        Global.localStorage.$put("identities", JSGlobal.JSON.stringify(c));
    }

    /**
     * Clears contacts from the local storage
     *
     * @memberOf EcIdentityManager
     * @method clearContacts
     * @static
     */
    public static void clearContacts()
    {
        Global.localStorage.$delete("contacts");
        contacts = new Array<EcContact>();
    }

    /**
     * Clears identities from the local storage
     *
     * @memberOf EcIdentityManager
     * @method clearIdentities
     * @static
     */
    public static void clearIdentities()
    {
        Global.localStorage.$delete("identities");
        ids = new Array<EcIdentity>();
    }

    /**
     * Adds an identity to the identity manager. Checks for duplicates. Triggers
     * events.
     *
     * @memberOf EcIdentityManager
     * @method addIdentity
     * @static
     * @param {EcIdentity} identity Identity to add.
     */
    public static void addIdentity(EcIdentity identity)
    {
        for (int i = 0; i < ids.$length(); i++)
        {
            if (ids.$get(i).equals(identity))
            {
                return;
            }
        }
        ids.push(identity);
        identityChanged(identity);
    }

    /**
     * Adds an identity to the identity manager. Checks for duplicates. Does not trigger
     * events.
     *
     * @memberOf EcIdentityManager
     * @method addIdentityQuietly
     * @static
     * @param {EcIdentity} identity Identity to add.
     */
    public static void addIdentityQuietly(EcIdentity identity)
    {
        for (int i = 0; i < ids.$length(); i++)
        {
            if (ids.$get(i).equals(identity))
            {
                return;
            }
        }
        ids.push(identity);
    }

    /**
     * Adds a contact to the identity manager. Checks for duplicates. Triggers
     * events.
     *
     * @memberOf EcIdentityManager
     * @method addContact
     * @static
     * @param {EcContact} contact Contact to add.
     */
    public static void addContact(EcContact contact)
    {
        for (int i = 0; i < ids.$length(); i++)
        {
            if (ids.$get(i).ppk.toPk().toPem().equals(contact.pk.toPem()))
            {
                ids.$get(i).displayName = contact.displayName;
                identityChanged(ids.$get(i));
            }
        }

        for (int i = 0; i < contacts.$length(); i++)
        {
            if (contacts.$get(i).pk.toPem().equals(contact.pk.toPem()))
            {
                contacts.$get(i).displayName = contact.displayName;
                contactChanged( contacts.$get(i));
            }
        }

        for (int i = 0; i < contacts.$length(); i++)
        {
            if (contacts.$get(i).equals(contact))
            {
                return;
            }
        }

        contacts.push(contact);
        contactChanged(contact);
    }

    /**
     * Adds a contact to the identity manager. Checks for duplicates. Does not trigger
     * events.
     *
     * @memberOf EcIdentityManager
     * @method addContactQuietly
     * @static
     * @param {EcContact} contact Contact to add.
     */
    public static void addContactQuietly(EcContact contact)
    {
        for (int i = 0; i < ids.$length(); i++)
        {
            if (ids.$get(i).ppk.toPk().toPem().equals(contact.pk.toPem()))
            {
                ids.$get(i).displayName = contact.displayName;
            }
        }

        for (int i = 0; i < contacts.$length(); i++)
        {
            if (contacts.$get(i).pk.toPem().equals(contact.pk.toPem()))
            {
                contacts.$get(i).displayName = contact.displayName;
            }
        }

        for (int i = 0; i < contacts.$length(); i++)
        {
            if (contacts.$get(i).equals(contact))
            {
                return;
            }
        }

        contacts.push(contact);
    }

    /**
     * Create a signature sheet, authorizing movement of data outside of our
     * control.
     *
     * @memberOf EcIdentityManager
     * @method signatureSheetFor
     * @static
     * @param {String[]} identityPksinPem Which identities to create signatures
     * for.
     * @param {long} duration Length of time in milliseconds to authorize
     * control.
     * @param {String} server Server that we are authorizing.
     * @return {String} JSON Array containing signatures.
     */
    public static String signatureSheetFor(Array<String> identityPksinPem, long duration, String server)
    {
        Array<Object> signatures = new Array<Object>();
        for (int j = 0; j < ids.$length(); j++)
        {
            EcPpk ppk = ids.$get(j).ppk;
            EcPk pk = ppk.toPk();
            if (identityPksinPem != null)
            {
                for (int i = 0; i < identityPksinPem.$length(); i++)
                {
                    EcPk ownerPpk = EcPk.fromPem(identityPksinPem.$get(i).trim());
                    if (pk.equals(ownerPpk))
                    {
                        signatures.push(createSignature(duration, server, ppk).atIfy());
                    }
                }
            }
        }
        return JSGlobal.JSON.stringify(signatures);
    }

    /**
     * Asynchronous version of creating a signature sheet for a list of
     * identities
     *
     * @memberOf EcIdentityManager
     * @method signatureSheetForAsync
     * @static
     * @param {String[]} identityPksinPem Which identities to create signatures
     * for.
     * @param {long} duration Length of time in milliseconds to authorize
     * control.
     * @param {String} server Server that we are authorizing.
     * @param {Callback1<String>} success Callback triggered once the signature
     * sheet has been created, returns the signature sheet
     */
    public static void signatureSheetForAsync(final Array<String> identityPksinPem, final long duration, final String server, final Callback1<String> success)
    {
        final Array<Object> signatures = new Array<Object>();
        new EcAsyncHelper<EcIdentity>().each(ids, new Callback2<EcIdentity, Callback0>()
        {
            @Override
            public void $invoke(EcIdentity p1, final Callback0 incrementalSuccess)
            {
                EcPpk ppk = p1.ppk;
                EcPk pk = ppk.toPk();
                boolean found = false;
                if (identityPksinPem != null)
                {
                    for (int j = 0; j < identityPksinPem.$length(); j++)
                    {
                        EcPk ownerPpk = EcPk.fromPem(identityPksinPem.$get(j).trim());
                        if (pk.equals(ownerPpk))
                        {
                            found = true;
                            createSignatureAsync(duration, server, ppk, new Callback1<EbacSignature>()
                            {
                                @Override
                                public void $invoke(EbacSignature p1)
                                {
                                    signatures.push(p1.atIfy());
                                    incrementalSuccess.$invoke();
                                }
                            });
                        }
                    }
                }
                if (!found)
                {
                    incrementalSuccess.$invoke();
                }
            }
        }, new Callback1<Array<EcIdentity>>()
        {
            @Override
            public void $invoke(Array<EcIdentity> pks)
            {
                success.$invoke(JSGlobal.JSON.stringify(signatures));
            }
        });
    }

    public static boolean signatureSheetCaching = false;
    public static Object signatureSheetCache = new Object();

    /**
     * Create a signature sheet for all identities, authorizing movement of data
     * outside of our control.
     *
     * @memberOf EcIdentityManager
     * @method signatureSheet
     * @static
     * @param {long} duration Length of time in milliseconds to authorize
     * control.
     * @param {String} server Server that we are authorizing.
     * @return {String} JSON Array containing signatures.
     */
    public static String signatureSheet(long duration, String server)
    {
        Array cache = null;
        if (signatureSheetCaching)
        {
            cache = (Array) JSObjectAdapter.$get(signatureSheetCache, server);
            if (cache != null)
            {
                if ((Long) cache.$get(0) > new Date().getTime() + duration)
                {
                    return (String) cache.$get(1);
                }
            }
            duration += 20000;
        }
        Array<Object> signatures = new Array<Object>();
        for (int j = 0; j < ids.$length(); j++)
        {
            EcPpk ppk = ids.$get(j).ppk;
            signatures.push(createSignature(duration, server, ppk).atIfy());
        }
        String stringified = JSGlobal.JSON.stringify(signatures);
        if (signatureSheetCaching)
        {
            cache = new Array();
            cache.$set(0, new Date().getTime() + duration);
            cache.$set(1, stringified);
            JSObjectAdapter.$put(signatureSheetCache, server, cache);
        }
        return stringified;
    }

    /**
     * Asynchronous version of creating a signature sheet for all identities
     *
     * @memberOf EcIdentityManager
     * @method signatureSheetAsync
     * @static
     * @param {long} duration Length of time in milliseconds to authorize
     * control.
     * @param {String} server Server that we are authorizing.
     * @param {Callback<String>} success Callback triggered once the signature
     * sheet has been created, returns the signature sheet
     */
    public static void signatureSheetAsync(long duration, final String server, final Callback1<String> success)
    {
    	if(!async){
    		String sheet = signatureSheet(duration, server);
    		if(success != null)
    			success.$invoke(sheet);
    		return;
    	}
    	
        final Array<Object> signatures = new Array<Object>();
        Array cache = null;
        if (signatureSheetCaching)
        {
            cache = (Array) JSObjectAdapter.$get(signatureSheetCache, server);
            if (cache != null)
            {
                if ((Long) cache.$get(0) > new Date().getTime() + duration)
                {
                    success.$invoke((String) cache.$get(1));
                    return;
                }
            }
            duration += 20000;
        }
        final long finalDuration = duration;
        new EcAsyncHelper<EcIdentity>().each(ids, new Callback2<EcIdentity, Callback0>()
        {
            @Override
            public void $invoke(EcIdentity p1, final Callback0 incrementalSuccess)
            {
                EcPpk ppk = p1.ppk;
                createSignatureAsync(finalDuration, server, ppk, new Callback1<EbacSignature>()
                {
                    @Override
                    public void $invoke(EbacSignature p1)
                    {
                        signatures.push(p1.atIfy());
                        incrementalSuccess.$invoke();
                    }
                });
            }
        }, new Callback1<Array<EcIdentity>>()
        {
            @Override
            public void $invoke(Array<EcIdentity> pks)
            {
                Array cache = null;
                String stringified = JSGlobal.JSON.stringify(signatures);
                if (signatureSheetCaching)
                {
                    cache = new Array();
                    cache.$set(0, new Date().getTime() + finalDuration);
                    cache.$set(1, stringified);
                    JSObjectAdapter.$put(signatureSheetCache, server, cache);
                }
                success.$invoke(stringified);
            }
        });
    }

    /**
     * Create a signature for a specific identity, authorizing movement of data
     * outside of our control.
     *
     * @memberOf EcIdentityManager
     * @method createSignature
     * @static
     * @param {long} duration Length of time in milliseconds to authorize
     * control.
     * @param {String} server Server that we are authorizing.
     * @param {EcPpk} ppk Key of the identity to create a signature for
     * @return {Ebac Signature} Signature created
     */
    private static EbacSignature createSignature(long duration, String server, EcPpk ppk)
    {
        EbacSignature s = new EbacSignature();
        s.owner = ppk.toPk().toPem();
        s.expiry = new Date().getTime() + duration;
        s.server = server;
        s.signature = EcRsaOaep.sign(ppk, s.toJson());
        return s;
    }

    /**
     * Asynchronously create a signature for a specific identity
     *
     * @memberOf EcIdentityManager
     * @method createSignatureAsync
     * @static
     * @param {long} duration Length of time in milliseconds to authorize
     * control.
     * @param {String} server Server that we are authorizing.
     * @param {EcPpk} ppk Key of the identity to create a signature for
     * @param success Callback triggered once the signature sheet has been
     * created, returns the signature
     */
    private static void createSignatureAsync(long duration, String server, EcPpk ppk, final Callback1<EbacSignature> success)
    {
        final EbacSignature s = new EbacSignature();
        s.owner = ppk.toPk().toPem();
        s.expiry = new Date().getTime() + duration;
        s.server = server;
        EcRsaOaepAsync.sign(ppk, s.toJson(), new Callback1<String>()
        {
            @Override
            public void $invoke(String p1)
            {
                s.signature = p1;
                success.$invoke(s);
            }
        }, null);
    }

    /**
     * Get PPK from PK (if we have it)
     *
     * @memberOf EcIdentityManager
     * @method getPpk
     * @static
     * @param {EcPk} fromPem PK to use to look up PPK
     * @return {EcPpk} PPK or null.
     */
    public static EcPpk getPpk(EcPk fromPem)
    {
        String pem = fromPem.toPem();
        for (int i = 0; i < ids.$length(); i++)
        {
            if (pem.equals(ids.$get(i).ppk.toPk().toPem()))
            {
                return ids.$get(i).ppk;
            }
        }
        return null;
    }

    /**
     * Get Contact from PK (if we have it)
     *
     * @memberOf EcIdentityManager
     * @method getContact
     * @static
     * @param {EcPk} pk PK to use to look up PPK
     * @return {EcPpk} PPK or null.
     */
    public static EcContact getContact(EcPk pk)
    {
        for (int i = 0; i < contacts.$length(); i++)
        {
            if (pk.equals(contacts.$get(i).pk))
            {
                return contacts.$get(i);
            }
        }
        return null;
    }

    /**
     * Get Identity from PK (if we have it)
     *
     * @memberOf EcIdentityManager
     * @method getIdentity
     * @static
     * @param {EcPk} pk PK to use to look up PPK
     * @return {EcIdentity} identity or null.
     */
    public static EcIdentity getIdentity(EcPk pk)
    {
        for (int i = 0; i < ids.$length(); i++)
        {
            if (pk.equals(ids.$get(i).ppk.toPk()))
            {
                return ids.$get(i);
            }
        }
        return null;
    }

    /**
     * Sign a piece of data with all available keys that own that data.
     *
     * @memberOf EcIdentityManager
     * @method sign
     * @static
     * @param {EcRemoteLinkedData} d Data to sign.
     */
    public static void sign(EcRemoteLinkedData d)
    {
        // Validate object here using all signatures and remove any that don't
        // work.
        if (d.signature != null)
        {
            for (int i = 0; i < d.signature.$length();)
            {
                boolean works = false;
                String signature = d.signature.$get(i);
                if (d.owner != null)
                {
                    for (int j = 0; j < d.owner.$length(); j++)
                    {
                        String owner = d.owner.$get(j);
                        EcPk pk = EcPk.fromPem(owner);
                        try
                        {
                            if (EcRsaOaep.verify(pk, d.toSignableJson(), signature))
                            {
                                works = true;
                                break;
                            }
                        } catch (Exception ex)
                        {

                        }
                    }
                }
                if (!works)
                {
                    d.signature.splice(i);
                } else
                {
                    i++;
                }
            }

        }
        if (d.owner != null)
        {
            for (int i = 0; i < d.owner.$length(); i++)
            {
                EcPpk attempt = getPpk(EcPk.fromPem(d.owner.$get(i)));
                if (attempt != null)
                {
                    d.signWith(attempt);
                }
            }
        }
        if (d.signature != null && d.signature.$length() == 0)
        {
            JSObjectAdapter.$properties(d).$delete("signature");
        }
    }

    public static String myIdentitiesSearchString()
    {
        String searchString = "";
        for (int i = 0; i < ids.$length(); i++)
        {
            if (i > 0)
            {
                searchString += " OR ";
            }
            searchString += "@reader:\"" + ids.$get(i).ppk.toPk().toPem() + "\"";
            searchString += " OR ";
            searchString += "@owner:\"" + ids.$get(i).ppk.toPk().toPem() + "\"";
        }
        return searchString;
    }
}
