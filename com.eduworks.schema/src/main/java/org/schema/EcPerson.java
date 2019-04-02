package org.schema;

import com.eduworks.ec.crypto.EcPk;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

public class EcPerson extends Person {

    public static void getByPk(EcRepository repo, EcPk pk, final Callback1<EcPerson> success, final Callback1<String> failure)
    {
        get(repo.selectedServer+(repo.selectedServer.endsWith("/") ? "" : "/")+"data/"+pk.fingerprint(),success,failure);
    }

    public static EcPerson getByPkBlocking(EcRepository repo, EcPk pk, final Callback1<EcPerson> success, final Callback1<String> failure)
    {
        return getBlocking(repo.selectedServer+(repo.selectedServer.endsWith("/") ? "" : "/")+"data/"+pk.fingerprint());
    }

    @Override
    public boolean equals(Object obj) {
        return isId(((EcPerson)obj).id);
    }
    /**
     * Retrieves a person from it's server asynchronously
     *
     * @param {String}            id
     *                            ID of the competency to retrieve from the server
     * @param {Callback1<String>} success
     *                            Callback triggered after retrieving the person,
     *                            returns the person retrieved
     * @param {Callback1<String>} failure
     *                            Callback triggered if error retrieving person
     * @memberOf EcPerson
     * @method get
     * @static
     */
    public static void get(String id, final Callback1<EcPerson> success, final Callback1<String> failure) {
        EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
            @Override
            public void $invoke(EcRemoteLinkedData p1) {
                if (p1 instanceof EcPerson)
                    if (success != null) {
                        success.$invoke((EcPerson) p1);
                        return;
                    }

                EcPerson person = new EcPerson();

                if (p1.isA(EcEncryptedValue.myType)) {
                    EcEncryptedValue encrypted = new EcEncryptedValue();
                    encrypted.copyFrom(p1);
                    p1 = encrypted.decryptIntoObject();

                    EcEncryptedValue.encryptOnSave(p1.id, true);

                }
                if (p1.isAny(person.getTypes())) {
                    person.copyFrom(p1);
                    if (EcRepository.caching) {
                        JSObjectAdapter.$put(EcRepository.cache, person.shortId(), person);
                        JSObjectAdapter.$put(EcRepository.cache, person.id, person);
                    }
                    if (success != null)
                        success.$invoke(person);
                } else {
                    String msg = "Retrieved object was not a person";
                    if (failure != null)
                        failure.$invoke(msg);
                    else
                        Global.console.error(msg);
                }
            }
        }, failure);
    }

    /**
     * Retrieves a person from it's server synchronously, the call
     * blocks until it is successful or an error occurs
     *
     * @param {String} id
     *                 ID of the person to retrieve
     * @return EcPerson
     * The person retrieved
     * @memberOf EcPerson
     * @method getBlocking
     * @static
     */
    public static EcPerson getBlocking(String id) {
        EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
        if (p1 == null)
            return null;
        EcPerson person = new EcPerson();

        if (p1.isA(EcEncryptedValue.myType)) {
            EcEncryptedValue encrypted = new EcEncryptedValue();
            encrypted.copyFrom(p1);
            p1 = encrypted.decryptIntoObject();

            EcEncryptedValue.encryptOnSave(p1.id, true);
        }
        if (p1.isAny(person.getTypes())) {
            person.copyFrom(p1);
            return person;
        } else {
            String msg = "Retrieved object was not a person";
            Global.console.error(msg);
            return null;
        }
    }

    /**
     * Searches a repository for persons that match the search query
     *
     * @param {EcRepository}          repo Repository to search using the query
     * @param {String}                query Query string to pass to the search web service
     * @param {Callback1<Array<Quiz>> success Callback triggered after
     *                                completing the search, returns the results
     * @param {Callback1<String>}     failure Callback triggered if error searching
     * @param {Object}                paramObj Parameter object for search
     * @memberOf EcPerson
     * @method search
     * @static
     */
    public static void search(EcRepository repo, String query, final Callback1<Array<EcPerson>> success, Callback1<String> failure, Object paramObj) {
        String queryAdd = "";
        queryAdd = new Person().getSearchStringByType();

        if (query == null || query == "") query = queryAdd;
        else query = "(" + query + ") AND " + queryAdd;

        repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {
            @Override
            public void $invoke(Array<EcRemoteLinkedData> p1) {
                if (success != null) {
                    Array<EcPerson> ret = JSCollections.$array();
                    for (int i = 0; i < p1.$length(); i++) {
                        EcPerson comp = new EcPerson();
                        if (p1.$get(i).isAny(comp.getTypes())) {
                            comp.copyFrom(p1.$get(i));
                        }
                        else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
                            EcEncryptedValue val = new EcEncryptedValue();
                            val.copyFrom(p1.$get(i));
                            if (val.isAnEncrypted(new EcPerson().getFullType())) {
                                EcRemoteLinkedData obj = val.decryptIntoObject();
                                comp.copyFrom(obj);
                                EcEncryptedValue.encryptOnSave(comp.id, true);
                            }
                        }
                        ret.$set(i, comp);
                    }
                    success.$invoke(ret);
                }
            }
        }, failure);
    }

    /**
     * Attempts to find and return the person's fingerprint from the id.
     *
     * @return {String}
     * @method getFingerprintFromId
     */
    public String getFingerprintFromId() {
        return getGuid();
    }

    /**
     * Attempts to find and return the person's fingerprint from the id.
     *
     * @return {String}
     * @method getFingerprintFromId
     */
    public String getFingerprint() {
        return getGuid();
    }

}
