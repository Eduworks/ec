package org.cass.competency;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Directory;
import org.cassproject.schema.general.EcRemoteLinkedData;
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
    public static String levelMetadata;
    public static EcEncryptedValue ownerKey;
    public static EcEncryptedValue readerKey;

    public EcDirectory() {
        Map<String, Object> me = JSObjectAdapter.$properties(this);
        if (template != null) {
            Map<String, Object> you = JSObjectAdapter.$properties(template);
            for (String key : you) {
                if (JSGlobal.typeof(you.$get(key)) != "function")
                    me.$put(key.replace("@", ""), you.$get(key));
            }
        }
        // Defaults to root directory on creation
        setAsRootDirectory();
        ownerKey = null;
        readerKey = null;
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
     * Adds the framework ID specified to the directory's list of framework IDs
     *
     * @param {String} id
     *                 ID of the framework to add
     * @memberOf EcDirectory
     * @method addFramework
     */
    public void addFramework(String id) {
        id = trimVersionFromUrl(id);
        if (framework == null)
            framework = new Array<String>();
        for (int i = 0; i < framework.$length(); i++)
            if (trimVersionFromUrl(framework.$get(i)).equals(id))
                return;
        framework.push(id);
        EcFramework frameworkObj = EcFramework.getBlocking(id);
        // add key to framework and all subobjects
    }

    /**
     * Adds the resource ID specified to the directory's list of resource IDs
     *
     * @param {String} id
     *                 ID of the resource to add
     * @param {EcRepository} repo
     *                 Repository to save the resource to
     * @memberOf EcDirectory
     * @method addResource
     */
    public void addResource(String id, EcRepository repo) {
        id = trimVersionFromUrl(id);
        if (resource == null)
            resource = new Array<String>();
        for (int i = 0; i < resource.$length(); i++)
            if (trimVersionFromUrl(resource.$get(i)).equals(id))
                return;
        resource.push(id);
        EcRemoteLinkedData resourceObj = EcRepository.getBlocking(id);
        if (ownerKey != null) {
            EcEncryptedValue ev = new EcEncryptedValue();
            ev.copyFrom(ownerKey);
            String pem = ev.decryptIntoString();
            EcPk pk = EcPk.fromPem(pem);
            resourceObj.addOwner(pk);
        }
        if (readerKey != null) {
            EcEncryptedValue ev = new EcEncryptedValue();
            ev.copyFrom(readerKey);
            String pem = ev.decryptIntoString();
            EcPk pk = EcPk.fromPem(pem);
            resourceObj.addReader(pk);
        }
        repo.saveTo(resourceObj, null, null);
    }

    /**
     * Adds the subdirectory ID specified to the directory's list of subdirectory IDs
     *
     * @param {String} id
     *                 ID of the subdirectory to add
     * @memberOf EcDirectory
     * @method addSubdirectory
     */
    public void addSubdirectory(String id) {
        id = trimVersionFromUrl(id);
        if (subdirectory == null)
            subdirectory = new Array<String>();
        for (int i = 0; i < subdirectory.$length(); i++)
            if (trimVersionFromUrl(subdirectory.$get(i)).equals(id))
                return;
        subdirectory.push(id);
    }

    /**
     * Removes a framework ID from the directory's list of frameworks
     *
     * @param {String} id
     *                 ID to remove from the directory's framework list
     * @memberOf EcDirectory
     * @method removeFramework
     */
    public void removeFramework(String id) {
        id = trimVersionFromUrl(id);
        if (framework == null)
            framework = new Array<String>();
        for (int i = 0; i < framework.$length(); i++)
            if (trimVersionFromUrl(framework.$get(i)).equals(id))
                framework.splice(i, 1);
    }

    /**
     * Removes a resource ID from the directory's list of resources
     *
     * @param {String} id
     *                 ID to remove from the directory's resource list
     * @memberOf EcDirectory
     * @method removeResource
     */
    public void removeResource(String id) {
        id = trimVersionFromUrl(id);
        if (resource == null)
            resource = new Array<String>();
        for (int i = 0; i < resource.$length(); i++)
            if (trimVersionFromUrl(resource.$get(i)).equals(id))
                resource.splice(i, 1);
    }

    /**
     * Removes a subdirectory ID from the directory's list of subdirectories
     *
     * @param {String} id
     *                 ID to remove from the directory's subdirectory list
     * @memberOf EcDirectory
     * @method removeSubdirectory
     */
    public void removeSubdirectory(String id) {
        id = trimVersionFromUrl(id);
        if (subdirectory == null)
            subdirectory = new Array<String>();
        for (int i = 0; i < subdirectory.$length(); i++)
            if (trimVersionFromUrl(subdirectory.$get(i)).equals(id))
                subdirectory.splice(i, 1);
    }

    /**
     * Sets a directory's levelMetadata field to "root". Enables finding root directories for display in a UI
     *
     * @memberOf EcDirectory
     * @method setAsRootDirectory
     */
    public void setAsRootDirectory() {
        levelMetadata = "root";
    }

    /**
     * Sets a directory's levelMetadata field to "sub".
     *
     * @memberOf EcDirectory
     * @method setAsRootDirectory
     */
    public void setAsSubdirectory() {
        levelMetadata = "sub";
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

    public void addOwner(EcPk newOwner) {
        super.addOwner(newOwner);
        if (ownerKey == null) {
            EcPpk newOwnerPpk = EcPpk.generateKey();
            ownerKey = EcEncryptedValue.encryptValue(newOwnerPpk.toPem(), "ownerKey", owner, null);
        } else {
            EcEncryptedValue ownerPpk = new EcEncryptedValue();
            ownerPpk.copyFrom(ownerKey);
            String currentPpkPem = ownerPpk.decryptIntoString();
            ownerKey = EcEncryptedValue.encryptValue(currentPpkPem, "ownerKey", owner, null);
        }
    }

    public void addReader(EcPk newReader) {
        super.addReader(newReader);
        if (readerKey == null) {
            EcPpk newReaderPpk = EcPpk.generateKey();
            readerKey = EcEncryptedValue.encryptValue(newReaderPpk.toPem(), "readerKey", owner, reader);
        } else {
            EcEncryptedValue readerPpk = new EcEncryptedValue();
            readerPpk.copyFrom(readerKey);
            String currentPpkPem = readerPpk.decryptIntoString();
            readerKey = EcEncryptedValue.encryptValue(currentPpkPem, "readerKey", owner, reader);
        }
    }

    public void removeOwner(EcPk oldOwner) {
        super.removeOwner(oldOwner);
        if (owner != null) {
            EcEncryptedValue ownerPpk = new EcEncryptedValue();
            ownerPpk.copyFrom(ownerKey);
            String currentPpkPem = ownerPpk.decryptIntoString();
            ownerKey = EcEncryptedValue.encryptValue(currentPpkPem, "ownerKey", owner, null);
        } else {
            ownerKey = null;
            // remove key from all subobjects?
        }
    }

    public void removeReader(EcPk oldReader) {
        super.removeReader(oldReader);
        if (reader != null) {
            EcEncryptedValue readerPpk = new EcEncryptedValue();
            readerPpk.copyFrom(readerKey);
            String currentPpkPem = readerPpk.decryptIntoString();
            readerKey = EcEncryptedValue.encryptValue(currentPpkPem, "readerKey", owner, reader);
        } else {
            readerKey = null;
            // remove key from all subobjects?
        }
    }
    // add and remove keys from frameworks etc when adding to directory?
    // keys on add/remove owner/reader?
    // async methods
    // tests?
}
