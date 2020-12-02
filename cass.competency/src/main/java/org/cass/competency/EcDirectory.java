package org.cass.competency;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Directory;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

/**
 * Implementation of a Directory object with methods for interacting with CASS
 * services on a server.
 *
 * @author kristin.wood@eduworks.com
 * @module org.cassproject
 * @class EcDirectory
 * @constructor
 * @extends Directory
 */

public class EcDirectory extends Directory {
    public static Object template;

    public EcDirectory() {
        Map<String, Object> me = JSObjectAdapter.$properties(this);
        if (template != null) {
            Map<String, Object> you = JSObjectAdapter.$properties(template);
            for (String key : you) {
                if (JSGlobal.typeof(you.$get(key)) != "function")
                    me.$put(key.replace("@", ""), you.$get(key));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return isId(((EcDirectory)obj).id);
    }

    /**
     * Retrieves a directory from the server, specified by the ID
     *
     * @param {String}                 id
     *                                 ID of the directory to retrieve
     * @param {Callback1<EcDirectory>} success
     *                                 Callback triggered after successfully retrieving the directory,
     *                                 returns the retrieved directory
     * @param {Callback1<String>}      failure
     *                                 Callback triggered if an error occurs while retrieving the directory
     * @memberOf EcDirectory
     * @method get
     * @static
     */
    public static void get(String id, final Callback1<EcDirectory> success, final Callback1<String> failure) {
        EcRepository.getAs(id,new EcDirectory(),success,failure);
    }

    /**
     * Retrieves a directory from the server in a blocking fashion, specified by the ID
     *
     * @param {String}                 id
     *                                 ID of the directory to retrieve
     * @param {Callback1<EcDirectory>} success
     *                                 Callback triggered after successfully retrieving the directory,
     *                                 returns the retrieved directory
     * @param {Callback1<String>}      failure
     *                                 Callback triggered if an error occurs while retrieving the directory
     * @memberOf EcDirectory
     * @method getBlocking
     * @static
     */
    public static EcDirectory getBlocking(String id) {
        return EcRepository.getBlockingAs(id,new EcDirectory());
    }

    /**
     * Searches the repository given for directories using the query passed in
     *
     * @param {EcRepository}                 repo
     *                                       Repository to search for directories
     * @param {String}                       query
     *                                       Query string used to search for a directory
     * @param {Callback1<Array<EcDirectory>} success
     *                                       Callback triggered when the search successfully returns,
     *                                       returns search results
     * @param {Callback1<String>}            failure
     *                                       Callback triggered if an error occurs while searching
     * @param {Object}                       paramObj
     *                                       Parameter object for search
     * @memberOf EcDirectory
     * @method search
     * @static
     */
    public static void search(EcRepository repo, String query, final Callback1<Array<EcDirectory>> success, Callback1<String> failure, Object paramObj) {
        EcRepository.searchAs(repo, query, new Function0() {
            @Override
            public Object $invoke() {
                return new EcDirectory();
            }
        },(Callback1<Array>)(Object)success,failure,paramObj);
    }

    /**
     * Saves this directory's details on the server specified by its ID or repo
     *
     * @param {Callback1<String>} success
     *                            Callback triggered after successfully saving the directory
     * @param {Callback1<String>} failure
     *                            Callback triggered if error occurs while saving the directory
     * @param {EcRepository}      repo
     *                            Repository to save the item to
     * @memberOf EcDirectory
     * @method save
     */
    public void save(Callback1<String> success, Callback1<String> failure, EcRepository repo) {
        if (this.name == null || this.name == "") {
            String msg = "Directory Name Cannot be Empty";

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
    /**
     * Deletes this directory from the server specified by its ID
     *
     * @param {Callback1<String>} success
     *                            Callback triggered if successfully deleted directory
     * @param {Callback1<String>} failure
     *                            Callback triggered if error occurs when deleting the directory
     * @memberOf EcDirectory
     * @method _delete
     */
    public void _delete(Callback1<String> success, Callback1<String> failure) {
        EcRepository.DELETE(this, success, failure);
    }
}
