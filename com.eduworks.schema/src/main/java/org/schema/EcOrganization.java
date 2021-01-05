package org.schema;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.crypto.EcPpk;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.identity.EcRekeyRequest;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

public class EcOrganization extends Organization {

    public static final String ORG_PPK_SET_KEY = "https://schema.cassproject.org/0.3/ppkSet";

    /**
     * Encrypted organization ppk Keys.
     * Encrypted value is an array of PPK PEMs with the most current key being the last item in the array
     *
     * @property orgPpkSet
     * @type EcEncryptedValue<PPK PEM>
     */
    //protected EcEncryptedValue orgPpkSet;

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
     * Adds the given person's id to the employee list
     *
     * @param {Array<EcPpk>} ppkList Person to add to the Organization's employee list
     *
     * @return String
     * A JSON array string containing the PEMs of the given PPKs
     *
     * @method ppkListToPemArrayString
     */
    private String ppkListToPemArrayString(Array<EcPpk> ppkList) {
        if (ppkList == null) return JSGlobal.JSON.stringify(new Array<>());
        else {
            Array<String> pemArray = new Array<>();
            for (int i=0;i<ppkList.$length();i++) {
                pemArray.push(ppkList.$get(i).toPem());
            }
            return JSGlobal.JSON.stringify(pemArray);
        }
    }

    /**
     * Add's a key to the organization
     *
     * @param {EcPpk}   newOrgPpk The key to add to the organization
     * @memberOf EcOrganization
     * @method addOrgKey
     */
    public void addOrgKey(EcPpk newOrgPpk) {
        Array<EcPpk> orgKeys = getOrgKeys();
        orgKeys.push(newOrgPpk);
        EcEncryptedValue newKeys = EcEncryptedValue.encryptValue(ppkListToPemArrayString(orgKeys), ORG_PPK_SET_KEY, owner, reader);
        JSObjectAdapter.$put(this, ORG_PPK_SET_KEY, newKeys);
    }

    /**
     * Performs a rekey operation and saves the organization details to the server
     *
     * @param {Callback1<String>} success
     *                            Callback triggered on successfully saving the competency
     * @param {Callback1<String>} failure
     *                            Callback triggered if error saving competency
     * @memberOf EcOrganization
     * @method rekeyAndSave
     */
    public void rekeyAndSave(final Callback1<String> success, final Callback1<String> failure, final EcRepository repo) {
        if (repo == null) {
            String msg = "Repository cannot be null for a rekey operation";
            if (failure != null)
                failure.$invoke(msg);
            else
                Global.console.error(msg);
            return;
        }
        else {
            EcPpk oldKey = getCurrentOrgKey();
            EcPpk newKey = EcPpk.generateKey();
            EcIdentity identity = new EcIdentity();
            identity.ppk = newKey;
            identity.displayName = "Organization Rekey New Key";
            EcIdentityManager.addIdentity(identity);
            final EcRekeyRequest rekeyRequest = EcRekeyRequest.generateRekeyRequest(repo.selectedServer, oldKey, newKey);
            addOrgKey(newKey);
            EcEncryptedValue newKeys = EcEncryptedValue.encryptValue(ppkListToPemArrayString(getOrgKeys()), ORG_PPK_SET_KEY, owner, reader);
            JSObjectAdapter.$put(this, ORG_PPK_SET_KEY, newKeys);
            repo.saveTo(this, new Callback1<String>() {
                @Override
                public void $invoke(String res) {
                    repo.saveTo(rekeyRequest,success,failure);
                }
            },failure);
        }
    }

    /**
     * Encrypts the org keys and saves the organization details to the server
     *
     * @param {Callback1<String>} success
     *                            Callback triggered on successfully saving the competency
     * @param {Callback1<String>} failure
     *                            Callback triggered if error saving competency
     * @memberOf EcOrganization
     * @method save
     */
    public void save(Callback1<String> success, Callback1<String> failure, EcRepository repo) {
        EcEncryptedValue newKeys = EcEncryptedValue.encryptValue(ppkListToPemArrayString(getOrgKeys()), ORG_PPK_SET_KEY, owner, reader);
        JSObjectAdapter.$put(this, ORG_PPK_SET_KEY, newKeys);
        if (repo == null)
            EcRepository.save(this, success, failure);
        else
            repo.saveTo(this,success,failure);
    }

    /**
     * Returns the current organization key
     *
     * @return EcPpk
     * The current organization key
     * @memberOf EcOrganization
     * @method getCurrentOrgKey
     */
    public EcPpk getCurrentOrgKey() {
        Array<EcPpk> orgKeys = getOrgKeys();
        if (orgKeys.$length() >= 1) {
            return orgKeys.$get(orgKeys.$length() - 1);
        }
        else return null;
    }

    /**
     * Returns the list of organization keys
     *
     * @return Array<EcPpk>
     * The Array of organization keys
     * @memberOf EcOrganization
     * @method getOrgKeys
     */
    public Array<EcPpk> getOrgKeys() {
        Array<EcPpk> orgKeys = new Array<>();
        Object o = JSObjectAdapter.$get(this, ORG_PPK_SET_KEY);
        if (o != null) {
            EcEncryptedValue ev = new EcEncryptedValue();
            ev.copyFrom(o);
            Array<String> orgKeysPPKPems = (Array<String>) JSGlobal.JSON.parse(ev.decryptIntoString());
            for (int i=0;i<orgKeysPPKPems.$length();i++) {
                orgKeys.push(EcPpk.fromPem(orgKeysPPKPems.$get(i)));
            }
        }
        return orgKeys;
    }

    /**
     * Moves old key field to new key field array
     *
     * @method moveKeyField
     */
    private void moveKeyField() {
        Object o = JSObjectAdapter.$get(this, "https://schema.cassproject.org/0.3/ppk");
        if (o != null) {
            EcEncryptedValue ev = new EcEncryptedValue();
            ev.copyFrom(o);
            String currentGroupPpkPem = ev.decryptIntoString();
            Array<String> keyArray = new Array<>();
            keyArray.push(currentGroupPpkPem);
            EcEncryptedValue newKey = EcEncryptedValue.encryptValue(JSGlobal.JSON.stringify(keyArray), ORG_PPK_SET_KEY, owner, reader);
            JSObjectAdapter.$put(this, ORG_PPK_SET_KEY, newKey);
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
