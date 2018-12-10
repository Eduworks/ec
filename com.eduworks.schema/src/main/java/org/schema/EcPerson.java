package org.schema;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;

public class EcPerson extends Person {

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
