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
import org.stjs.javascript.functions.Function0;

public class EcPerson extends Person {

    public static void getByPk(EcRepository repo, EcPk pk, final Callback1<EcPerson> success, final Callback1<String> failure)
    {
        get(repo.selectedServer+(repo.selectedServer.endsWith("/") ? "" : "/")+"data/"+pk.fingerprint(),success,failure);
    }

    public static EcPerson getByPkBlocking(EcRepository repo, EcPk pk)
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
        EcRepository.getAs(id,new EcPerson(),success,failure);
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
        return EcRepository.getBlockingAs(id,new EcPerson());
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
        EcRepository.searchAs(repo, query, new Function0() {
            @Override
            public Object $invoke() {
                return new EcPerson();
            }
        },(Callback1<Array>)(Object)success,failure,paramObj);
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
