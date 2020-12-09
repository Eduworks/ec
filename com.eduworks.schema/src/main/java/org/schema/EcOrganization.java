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
import org.stjs.javascript.functions.Function0;

public class EcOrganization extends Organization {

    /**
     * Encrypted organization ppk Keys.  Most current key
     *
     * @property orgPpk
     * @type EcEncryptedValue<PPK PEM>
     */
    protected Array<EcEncryptedValue> orgPpk;

    /**
     * Retrieves an organization from it's server asynchronously
     *
     * @param {String}            id
     *                            ID of the concept to retrieve from the server
     * @param {Callback1<String>} success
     *                            Callback triggered after retrieving the organization,
     *                            returns the organization retrieved
     * @param {Callback1<String>} failure
     *                            Callback triggered if error retrieving organization
     * @memberOf EcOrganization
     * @method get
     * @static
     */
    public static void get(String id, final Callback1<EcOrganization> success, final Callback1<String> failure) {
        EcRepository.getAs(id,new EcOrganization(),success,failure);
    }

    /**
     * Retrieves an organization from it's server synchronously, the call
     * blocks until it is successful or an error occurs
     *
     * @param {String} id
     *                 ID of the organization to retrieve
     * @return EcOrganization
     * The concept retrieved
     * @memberOf EcOrganization
     * @method getBlocking
     * @static
     */
    public static EcOrganization getBlocking(String id) {
        return EcRepository.getBlockingAs(id,new EcOrganization());
    }

    /**
     * Searches a repository for organizations that match the search query
     *
     * @param {EcRepository}                    repo Repository to search using the query
     * @param {String}                          query Query string to pass to the search web service
     * @param {Callback1<Array<EcOrganization>> success Callback triggered after
     *                                          completing the search, returns the results
     * @param {Callback1<String>}               failure Callback triggered if error searching
     * @param {Object}                          paramObj Parameter object for search
     * @memberOf EcOrganization
     * @method search
     * @static
     */
    public static void search(EcRepository repo, String query, final Callback1<Array<EcOrganization>> success, Callback1<String> failure, Object paramObj) {
        EcRepository.searchAs(repo, query, new Function0() {
            @Override
            public Object $invoke() {
                return new EcOrganization();
            }
        },(Callback1<Array>)(Object)success,failure,paramObj);
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
        Array<String> empAry = (Array<String>) (Object) employee;
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

    /**
     * Moves old key field to new key field array
     *
     * @method moveKeyField
     */
    private void moveKeyField() {
        EcEncryptedValue ev = (EcEncryptedValue) JSObjectAdapter.$get(this, "https://schema.cassproject.org/0.3/ppk");
        if (ev != null) {
            if (orgPpk == null) JSObjectAdapter.$put(this, "orgPpk", new Array<EcEncryptedValue>());
            orgPpk.push(ev);
            JSObjectAdapter.$properties(this).$delete("https://schema.cassproject.org/0.3/ppk");
        }
    }

    @Override
    protected void upgrade() {
        super.upgrade();
        movePersonMembersToEmployee();
        moveKeyField();
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
