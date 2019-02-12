package org.schema;

import com.eduworks.ec.array.EcArray;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
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
     * Adds the given person's id to the employee list
     *
     * @param {EcPerson}          person Person to add to the Organization's employee list
     * @method addEmployee
     */
    public void addEmployee(EcPerson person) {
        if (employee == null) JSObjectAdapter.$put(this, "employee", new Array<String>());
        if (!EcArray.isArray(employee)) throw new RuntimeException("Employee is not Array");
        Array<String> ary = (Array<String>) (Object) employee;
        String psid = person.shortId();
        for (int i=0;i<ary.$length();i++) {
            if (ary.$get(i) == psid) return;
        }
        ary.push(psid);
    }

    /**
     * Removes the person id from the employee list
     *
     * @param {String}          id Person id to be removed from Organization's employee list
     * @method removeEmployeeById
     */
    public void removeEmployeeById(String id) {
        if (employee == null) return;
        if (!EcArray.isArray(employee))throw new RuntimeException("Employee is not Array");
        Array<String> ary = (Array<String>) (Object) employee;
        for (int i = 0; i < ary.$length(); i++) {
            if (EcRemoteLinkedData.trimVersionFromUrl(ary.$get(i)) == EcRemoteLinkedData.trimVersionFromUrl(id)) {
                ary.splice(i, 1);
            }
        }
    }

    /**
     * Moves all Person type Member to Employee
     *
     * @method movePersonMembersToEmployee
     */
    private void movePersonMembersToEmployee() {
        if (member == null) return;
        if (employee == null) JSObjectAdapter.$put(this, "employee", new Array<String>());
        if (!EcArray.isArray(employee) || !EcArray.isArray(member)) return;
        Array<String> membAry = (Array<String>) (Object) member;
        Array<String> empAry = (Array<String>) (Object) member;
        Map<String, Object> me = JSObjectAdapter.$properties(this);
        for (int i = 0; i < membAry.$length(); i++) {
            String id = membAry.$get(i);
            if (id.toLowerCase().indexOf("person") > -1) {
                if (empAry.indexOf(id) <= -1) {
                    empAry.push(id);
                }
                membAry.splice(i, 1);
            }
        }
    }

    @Override
    protected void upgrade() {
        super.upgrade();
        movePersonMembersToEmployee();
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
