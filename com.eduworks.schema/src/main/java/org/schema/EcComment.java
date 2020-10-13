package org.schema;

import org.cass.competency.EcFramework;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Function0;

public class EcComment extends Comment {

    /**
     * Retrieves a comment from it's server asynchronously
     *
     * @param {String}            id
     *                            ID of the comment to retrieve from the server
     * @param {Callback1<String>} success
     *                            Callback triggered after retrieving the comment,
     *                            returns the comment retrieved
     * @param {Callback1<String>} failure
     *                            Callback triggered if error retrieving comment
     * @memberOf EcComment
     * @method get
     * @static
     */
    public static void get(String id, final Callback1<EcComment> success, final Callback2<String, Integer> failure) {
        EcRepository.getAs(id,new EcComment(),success,failure);
    }

    /**
     * Retrieves an comment from it's server synchronously, the call
     * blocks until it is successful or an error occurs
     *
     * @param {String} id
     *                 ID of the comment to retrieve
     * @return EcComment
     * The concept retrieved
     * @memberOf EcComment
     * @method getBlocking
     * @static
     */
    public static EcComment getBlocking(String id) {
        return EcRepository.getBlockingAs(id,new EcComment());
    }

    /**
     * Searches a repository for comments that match the search query
     *
     * @param {EcRepository}                repo Repository to search using the query
     * @param {String}                      query Query string to pass to the search web service
     * @param {Callback1<Array<EcComment>>  success Callback triggered after
     *                                      completing the search, returns the results
     * @param {Callback1<String>}           failure Callback triggered if error searching
     * @param {Object}                      paramObj Parameter object for search
     * @memberOf EcComment
     * @method search
     * @static
     */
    public static void search(EcRepository repo, String query, final Callback1<Array<EcComment>> success, Callback2<String, Integer> failure, Object paramObj) {
        EcRepository.searchAs(repo, query, new Function0() {
            @Override
            public Object $invoke() {
                return new EcComment();
            }
        },(Callback1<Array>)(Object)success,failure,paramObj);
    }

    /**
     * Sets the comment's subject as follows:
     *  Comment.isBasedOn: framework.shortId to provide a framework context to the comment
     *  Comment.about: aboutObj.shortId to provide an about/subject to the comment
     *
     * @param {EcFramework}         framework Framework which contains the id to set to the comment's isBasedOn
     * @param {EcRemoteLinkedData}  aboutObj Object which contains the id to set to the comment's about
     * @method setSubject
     */
    public void setSubject(EcFramework framework, EcRemoteLinkedData aboutObj) {
        if (framework != null) {
            JSObjectAdapter.$put(this, "isBasedOn", framework.shortId());
        }
        if (aboutObj != null) {
            JSObjectAdapter.$put(this, "about", aboutObj.shortId());
        }
    }

    /**
     * Sets the comment's subject as follows:
     *  Comment.isBasedOn: frameworkId to provide a framework context to the comment
     *  Comment.about: aboutId to provide an about/subject to the comment
     *
     * @param {String}  frameworkId Framework ID to set to the comment's isBasedOn
     * @param {String}  aboutId Object ID to set to the comment's about
     * @method setSubjectIds
     */
    public void setSubjectIds(String frameworkId, String aboutId) {
        if (frameworkId != null) {
            JSObjectAdapter.$put(this, "isBasedOn", frameworkId);
        }
        if (aboutId != null) {
            JSObjectAdapter.$put(this, "about", aboutId);
        }
    }

    /**
     * Sets the comment's creator to the ID of the given person object
     * @param {EcPerson}  person Person which contains the id to set to the comment's creator
     * @method setCreator
     */
    public void setCreator(EcPerson creatorObj) {
        if (creatorObj != null) {
            JSObjectAdapter.$put(this, "creator", creatorObj.shortId());
        }
    }

    /**
     * Sets the comment's creator to the given person ID
     * @param {String}  creatorId ID of the person to set to the comment's creator
     * @method setCreatorId
     */
    public void setCreatorId(String creatorId) {
        if (creatorId != null) {
            JSObjectAdapter.$put(this, "creator", creatorId);
        }
    }

    /**
     * Sets the comment's dateCreated to the given time in milliseconds
     * @param {String}  longDateString The time in milliseconds to set to the comment's dateCreated
     * @method setDateCreated
     */
    public void setDateCreated(String longDateString) {
        if (longDateString != null) {
            JSObjectAdapter.$put(this, "dateCreated", longDateString);
        }
    }

}
