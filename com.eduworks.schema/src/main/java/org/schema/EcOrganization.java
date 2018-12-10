package org.schema;

import com.eduworks.ec.array.EcArray;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

public class EcOrganization extends Organization {

    /**
     * Searches a repository for organizations that match the search query
     *
     * @param {EcRepository}          repo Repository to search using the query
     * @param {String}                query Query string to pass to the search web service
     * @param {Callback1<Array<Quiz>> success Callback triggered after
     *                                completing the search, returns the results
     * @param {Callback1<String>}     failure Callback triggered if error searching
     * @param {Object}                paramObj Parameter object for search
     * @memberOf EcOrganization
     * @method search
     * @static
     */
    public static void search(EcRepository repo, String query, final Callback1<Array<EcOrganization>> success, Callback1<String> failure, Object paramObj) {
        String queryAdd = "";
        queryAdd = new Organization().getSearchStringByType();

        if (query == null || query == "") query = queryAdd;
        else query = "(" + query + ") AND " + queryAdd;

        repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {
            @Override
            public void $invoke(Array<EcRemoteLinkedData> p1) {
                if (success != null) {
                    Array<EcOrganization> ret = JSCollections.$array();
                    for (int i = 0; i < p1.$length(); i++) {
                        EcOrganization comp = new EcOrganization();
                        if (p1.$get(i).isAny(comp.getTypes())) {
                            comp.copyFrom(p1.$get(i));
                        }
                        else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
                            EcEncryptedValue val = new EcEncryptedValue();
                            val.copyFrom(p1.$get(i));
                            if (val.isAnEncrypted(new EcOrganization().getFullType())) {
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
     * Adds the given person's id to the member list
     *
     * @param {EcPerson}          person Person to add to the Organization's member list
     * @method addMember
     */
    public void addMember(EcPerson person) {
        if (member == null) JSObjectAdapter.$put(this, "member", new Array<String>());
        if (!EcArray.isArray(member)) throw new RuntimeException("Member is not Array");
        Array<String> ary = (Array<String>) (Object) member;
        String psid = person.shortId();
        for (int i=0;i<ary.$length();i++) {
            if (ary.$get(i) == psid) return;
        }
        ary.push(psid);
    }

    /**
     * Removes the person id from the member list
     *
     * @param {String}          id Person id to be removed from Organization's member list
     * @method removeMemberById
     */
    public void removeMemberById(String id) {
        if (member == null) return;
        if (!EcArray.isArray(member))throw new RuntimeException("Member is not Array");
        Array<String> ary = (Array<String>) (Object) member;
        for (int i = 0; i < ary.$length(); i++) {
            if (EcRemoteLinkedData.trimVersionFromUrl(ary.$get(i)) == EcRemoteLinkedData.trimVersionFromUrl(id)) {
                ary.splice(i, 1);
            }
        }
    }

    /**
     * Attempts to find and return the organization's fingerprint from the id.
     *
     * @return {String}
     * @method getFingerprintFromId
     */
    public String getFingerprintFromId() {
        return getGuid();
    }

    /**
     * Attempts to find and return the organization's fingerprint from the id.
     *
     * @return {String}
     * @method getFingerprintFromId
     */
    public String getFingerprint() {
        return getGuid();
    }

}
