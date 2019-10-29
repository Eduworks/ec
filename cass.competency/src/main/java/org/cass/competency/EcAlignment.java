package org.cass.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.Cass;
import org.cassproject.schema.cass.competency.Relation;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

/**
 * Implementation of an alignment object with methods for interacting with CASS
 * services on a server.
 *
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 * <p>
 * TODO: Test case where an absent relation is in the framework.
 * @module org.cassproject
 * @class EcAlignment
 * @constructor
 * @extends Relation
 */
public class EcAlignment extends Relation {

    @Override
    public boolean equals(Object obj) {
        if (((EcAlignment) obj).id == null)
            return (((EcAlignment) obj).source == source && ((EcAlignment) obj).target == target && ((EcAlignment) obj).relationType == relationType);
        return isId(((EcAlignment) obj).id);
    }

    /**
     * Retrieves the alignment specified with the ID from the server
     *
     * @param {String}                 id
     *                                 ID of the alignment to retrieve
     * @param {Callback1<EcAlignment>} success
     *                                 Callback triggered on successfully retrieving the alignment,
     *                                 returns the alignment
     * @param {Callback1<String>}      [failure]
     *                                 Callback triggered if error while retrieving alignment
     * @memberOf EcAlignment
     * @method get
     * @static
     */
    public static void get(String id, final Callback1<EcAlignment> success, final Callback1<String> failure) {
        EcRepository.getAs(id,new EcAlignment(),success,failure);
    }

    /**
     * Retrieves an alignment from it's server synchronously, the call
     * blocks until it is successful or an error occurs
     *
     * @param {String} id
     *                 ID of the alignment to retrieve
     * @return EcAlignment
     * The alignment retrieved
     * @memberOf EcAlignment
     * @method getBlocking
     * @static
     */
    public static EcAlignment getBlocking(String id) {
        return EcRepository.getBlockingAs(id,new EcAlignment());
    }

    /**
     * Searches the repository using the query and optional parameters provided
     *
     * @param {EcRepository}                  repo
     *                                        Repository to search using the query provided
     * @param {String}                        query
     *                                        The query to send to the search
     * @param {Callback1<Array<EcAlignment>>} success
     *                                        Callback triggered on successful search return
     * @param {Callback1<String>}             [failure]
     *                                        Callback triggered if error searching
     * @param {Object}                        [paramObj]
     *                                        Parameters to include in the search
     * @memberOf EcAlignment
     * @method search
     * @static
     */
    public static void search(EcRepository repo, String query, final Callback1<Array<EcAlignment>> success, final Callback1<String> failure, Object paramObj) {
        EcRepository.searchAs(repo, query, new Function0() {
            @Override
            public Object $invoke() {
                return new EcAlignment();
            }
        },(Callback1<Array>)(Object)success,failure,paramObj);
    }

    /**
     * Searches the repository for alignments with a specific ID in the source field
     *
     * @param {EcRepository}                  repo
     *                                        Repository to search for alignments with the source specified
     * @param {String}                        sourceId
     *                                        ID in the source field of the alignments to find
     * @param {Callback1<Array<EcAlignment>>} success
     *                                        Callback triggered on successful search return
     * @param {Callback1<String>}             [failure]
     *                                        Callback triggered if error searching
     * @param {Object}                        [paramObj]
     *                                        Parameters to include in the search
     * @memberOf EcAlignment
     * @method searchBySource
     * @static
     */
    public static void searchBySource(EcRepository repo, final String sourceId, final Callback1<Array<EcAlignment>> success, Callback1<String> failure, Object paramObj) {
        String query = "";
        final String noVersion = EcRemoteLinkedData.trimVersionFromUrl(sourceId);
        if (noVersion == sourceId) {
            query += "source:\"" + sourceId + "\"";
        } else {
            query += "source:\"" + sourceId + "\" OR source:\"" + noVersion + "\"";
        }
        search(repo,query,success,failure,paramObj);
    }

    /**
     * Searches the repository for alignments with one of an array of IDs in the source field
     *
     * @param {EcRepository}                  repo
     *                                        Repository to search for alignments with the source specified
     * @param {String}                        sourceId
     *                                        ID in the source field of the alignments to find
     * @param {Callback1<Array<EcAlignment>>} success
     *                                        Callback triggered on successful search return
     * @param {Callback1<String>}             [failure]
     *                                        Callback triggered if error searching
     * @param {Object}                        [paramObj]
     *                                        Parameters to include in the search
     * @memberOf EcAlignment
     * @method searchBySource
     * @static
     */
    public static void searchBySources(EcRepository repo, final Array<String> sourceIds, final Callback1<Array<EcAlignment>> success, Callback1<String> failure, Object paramObj) {
        String query = "";
        query = "(source:";

        Array<String> noVersions = JSCollections.$array();
        for (int i = 0; i < sourceIds.$length(); i++) {
            String sourceId = sourceIds.$get(i);
            if (i != 0)
                query += " OR ";

            String noVersion = EcRemoteLinkedData.trimVersionFromUrl(sourceId);
            if (noVersion == sourceId) {
                query += "\"" + sourceId + "\"";
            } else {
                query += "\"" + sourceId + "\" OR source:\"" + noVersion + "\"";
            }
            noVersions.push(noVersion);
        }

        query += ")";
        search(repo,query,success,failure,paramObj);
    }

    /**
     * Searches the repository for alignments with a specific ID in the target field
     *
     * @param {EcRepository}                  repo
     *                                        Repository to search for alignments with the source specified
     * @param {String}                        competencyId
     *                                        ID in the target field of the alignments to find
     * @param {Callback1<Array<EcAlignment>>} success
     *                                        Callback triggered on successful search return
     * @param {Callback1<String>}             [failure]
     *                                        Callback triggered if error searching
     * @param {Object}                        [paramObj]
     *                                        Parameters to include in the search
     * @memberOf EcAlignment
     * @method searchByCompetency
     * @static
     */
    public static void searchByCompetency(EcRepository repo, final String competencyId, final Callback1<Array<EcAlignment>> success, Callback1<String> failure, Object paramObj) {
        String query = "";
        final String noVersion = EcRemoteLinkedData.trimVersionFromUrl(competencyId);
        if (noVersion == competencyId) {
            query += " AND (source:\"" + competencyId + "\" OR target:\"" + competencyId + "\")";
        } else {
            query += " AND (source:\"" + competencyId + "\" OR source:\"" + noVersion + "\" OR target:\"" + competencyId + "\" OR target:\"" + noVersion + "\")";
        }
        search(repo,query,success,failure,paramObj);
    }

    /**
     * Setter for alignment name
     *
     * @param {String} name
     *                 name to give this alignment
     * @memberOf EcAlignment
     * @method setName
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for alignment description
     *
     * @param {String} description
     *                 description to give this alignment
     * @memberOf EcAlignment
     * @method setDescription
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Saves this alignment details on the server corresponding to its ID
     *
     * @param {Callback1<String>} success
     *                            Callback triggered on successfully saving the alignment
     * @param {Callback1<String>} [failure]
     *                            Callback triggered if error while saving alignment
     * @memberOf EcAlignment
     * @method save
     */
    public void save(Callback1<String> success, Callback1<String> failure, EcRepository repo) {
        if (source == null || source == "") {
            String msg = "Source Competency cannot be missing";
            if (failure != null)
                failure.$invoke(msg);
            else
                Global.console.error(msg);
            return;
        }

        if (target == null || target == "") {
            String msg = "Target Competency cannot be missing";
            if (failure != null)
                failure.$invoke(msg);
            else
                Global.console.error(msg);
            return;
        }

        if (relationType == null || relationType == "") {
            String msg = "Relation Type cannot be missing";
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
     * Deletes the alignment from the server corresponding to its ID
     *
     * @param {Callback1<String>} success
     *                            Callback triggered on successfully deleting the alignment
     * @param {Callback1<String>} [failure]
     *                            Callback triggered if error while deleting alignment
     * @memberOf EcAlignment
     * @method _delete
     */
    public void _delete(Callback1<String> success, Callback1<String> failure) {
        EcRepository.DELETE(this, success, failure);
    }

}
