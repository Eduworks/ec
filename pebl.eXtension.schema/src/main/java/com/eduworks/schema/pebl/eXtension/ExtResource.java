package com.eduworks.schema.pebl.eXtension;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.Organization;
import org.schema.Person;
import org.schema.CreativeWork;
import org.schema.Product;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;

/**
 * @author debbie.brown@eduworks.com
 */

public class ExtResource extends CreativeWork {


	// legacy eXtension data not mapped to schema.org structure yet -- simply copied over during import for now
	public String legacyId;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ExtResource() {
		context = "http://schema.eduworks.com/pebleXtension/0.1/";
		type = "Resource";
	}

	/**
	 * Retrieves the resource specified with the ID from the server
	 *
	 * @param {String}               id
	 *                               ID of the resource to retrieve
	 * @param {Callback1<ExtResource>} success
	 *                               Callback triggered on successfully retrieving the resource,
	 *                               returns the resource
	 * @param {Callback1<String>}    [failure]
	 *                               Callback triggered if error while retrieving resource
	 * @memberOf ExtResource
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<ExtResource> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
                                @Override
                                public void $invoke(EcRemoteLinkedData p1) {
                                        if (p1 instanceof ExtResource)
                                                if (success != null) {
                                                        success.$invoke((ExtResource) p1);
                                                        return;
                                                }

                                        ExtResource resource = new ExtResource();

                                        if (p1.isA(EcEncryptedValue.myType)) {
                                                EcEncryptedValue encrypted = new EcEncryptedValue();
                                                encrypted.copyFrom(p1);
                                                p1 = encrypted.decryptIntoObject();
                                        }
                                        if (p1.isAny(resource.getTypes())) {
                                                resource.copyFrom(p1);
                                                if (EcRepository.caching) {
                                                        JSObjectAdapter.$put(EcRepository.cache, resource.shortId(), resource);
                                                        JSObjectAdapter.$put(EcRepository.cache, resource.id, resource);
                                                }
                                                if (success != null)
                                                        success.$invoke(resource);
                                        } else {
                                                String msg = "Resultant object is not a resource.";
                                                if (failure != null)
                                                        failure.$invoke(msg);
                                                else
                                                        Global.console.error(msg);
                                        }

                                }
                        }, failure);
	}

	/**
	 * Retrieves a resource from the server synchronously, the call
	 * blocks until it is successful or an error occurs
	 *
	 * @param {String} id
	 *                 ID of the resource to retrieve
	 * @return ExtResource
	 * The resource retrieved
	 * @memberOf ExtResource
	 * @method getBlocking
	 * @static
	 */
	public static ExtResource getBlocking(String id) {
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
		if (p1 instanceof ExtResource)
			return (ExtResource) p1;

		ExtResource resource = new ExtResource();

		if (p1.isA(EcEncryptedValue.myType)) {
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(resource.getTypes())) {
			resource.copyFrom(p1);
			if (EcRepository.caching) {
				JSObjectAdapter.$put(EcRepository.cache, resource.shortId(), resource);
				JSObjectAdapter.$put(EcRepository.cache, resource.id, resource);
			}
			return resource;
		} else {
			String msg = "Retrieved object was not a resource";
			Global.console.error(msg);
			return null;
		}
	}

	/**
	 * Searches the repository using the query and optional parameters provided
	 *
	 * @param {EcRepository}                repo
	 *                                      Repository to search using the query provided
	 * @param {String}                      query
	 *                                      The query to send to the search
	 * @param {Callback1<Array<ExtResource>>} success
	 *                                      Callback triggered on successful search return
	 * @param {Callback1<String>}           [failure]
	 *                                      Callback triggered if error searching
	 * @param {Object}                      [paramObj]
	 *                                      Parameters to include in the search
	 * @param start
	 * @param size
	 * @memberOf ExtResource
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<ExtResource>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = new ExtResource().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
                        //			query = "(" + query + ") AND educationalUse:\""+edUse+"\" AND " + queryAdd;
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {

                                @Override
                                public void $invoke(Array<EcRemoteLinkedData> p1) {
                                        if (success != null) {
                                                Array<ExtResource> ret = JSCollections.$array();
                                                for (int i = 0; i < p1.$length(); i++) {
                                                        ExtResource resource = new ExtResource();
                                                        //						if(p1.$get(i).isAny(resource.getTypes())){
                                                        resource.copyFrom(p1.$get(i));
                                                        //						}
                                                        //						else if(p1.$get(i).isA(EcEncryptedValue.myType)){
                                                        //							EcEncryptedValue val = new EcEncryptedValue();
                                                        //							val.copyFrom(p1.$get(i));
                                                        //							if(val.isAnEncrypted(ExtResource.myType)){
                                                        //								EcRemoteLinkedData obj = val.decryptIntoObject();
                                                        //								resource.copyFrom(obj);
                                                        //							}
                                                        //						}

                                                        ret.$set(i, resource);
                                                }

                                                success.$invoke(ret);
                                        }
                                }

                        }, failure);
	}

	/**
	 * Saves this resource on the server corresponding to its ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully saving the ExtResource
	 * @param {Callback1<String>} [failure]
	 *                            Callback triggered if error while saving ExtResource
	 * @return {ExtResource}
	 * @memberOf ExtResource
	 * @method save
	 */
	public String save(Callback1<String> success, Callback1<String> failure) {
		if (getId() == null || getId() == "") {
			String msg = "ID cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return null;
		}
		if (getTitle() == null || getTitle() == "") {
			String msg = "Title cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return null;
		}
		if (getLaunchURL() == null || getLaunchURL() == "") {
			String msg = "Launch URL cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return null;
		}

		EcRepository.save(this, success, failure);
		return "Resource " + getId() + " saved.";
	}

	/**
	 * Deletes the resource from the server corresponding to its ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully deleting the resource
	 * @param {Callback1<String>} [failure]
	 *                            Callback triggered if error while deleting resource
	 * @memberOf ExtResource
	 * @method _delete
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure) {
		EcRepository.DELETE(this, success, failure);
	}

	/**
	 * Returns the ID of the resource
	 *
	 * @return {String}
	 * ID of resource
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the ID of the resource
	 *
	 * @param {String} id
	 *                 ID of the resource
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the legacyId of the resource
	 *
	 * @return {String}
	 * legacyId of resource
	 */
	public String getLegacyId() {
		return legacyId;
	}

	/**
	 * Sets the legacyId of the resource
	 *
	 * @param {String} id
	 *                 legacyId of the resource
	 */
	public void setLegacyId(String id) {
		this.legacyId = id;
	}

	/**
	 * Returns the author of the resource
	 *
	 * @return {Person}
	 * author of resource
	 */
	public Person getAuthor() {
		return (Person) author;
	}

	/**
	 * Sets the author of the resource
	 *
	 * @param {Person} creator
	 */
	public void setAuthor(Person creator) {
		this.author = creator;
	}

	/**
	 * Returns the title of the resource
	 *
	 * @return {String}
	 * title of resource
	 */
	public String getTitle() {
		return name;
	}

	/**
	 * Sets the title of the resource
	 *
	 * @param {String} title
	 *                 title of the resource
	 */
	public void setTitle(String title) {
		this.name = title;
	}

	/**
	 * Returns the description of the resource
	 *
	 * @return {String}
	 * description of resource
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the resource
	 *
	 * @param {String} description
	 *                 description of the resource
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the text of the resource
	 *
	 * @return {String}
	 * text of resource
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text of the resource
	 *
	 * @param {String} text
	 *                 text of the resource
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returns the genre/category of the resource
	 *
	 * @return {String}
	 * genre of resource
	 */
	public String getCategory() {
		return (String) genre;
	}

	/**
	 * Sets the genre/category of the resource
	 *
	 * @param {String} name
	 *                 category of the resource
	 */
	public void setCategory(String name) {
		this.genre = name;
	}

	/**
	 * Returns the additionalType of the resource
	 *
	 * @return {String}
	 * additionalType of resource
	 */
	public String getAdditionalType() {
		return (String) additionalType;
	}

	/**
	 * Sets the additionalType of the resource
	 *
	 * @param {String} name
	 *                 additionalType of the resource
	 */
	public void setAdditionalType(String name) {
		this.additionalType = name;
	}

	/**
	 * Returns the keywords of the resource
	 *
	 * @return {String}
	 * keywords of resource
	 */
	public String getKeywords() {
		return (String) keywords;
	}

	/**
	 * Sets the keywords of the resource
	 *
	 * @param {String} name
	 *                 keywords of the resource
	 */
	public void setKeywords(String name) {
		this.keywords = name;
	}

	/**
	 * Returns the institution of the resource
	 *
	 * @return {Person}
	 * publisher of resource
	 */
	public Person getInstitution() {
		return publisher;
	}

	/**
	 * Sets the institution of the resource
	 *
	 * @param {Organization} institution
	 *                       institution of the resource
	 */
	public void setInstitution(Person institution) {
		this.publisher = institution;
	}

	/**
	 * Returns the community of the resource
	 *
	 * @return {Organization}
	 * community of resource
	 */
	public Organization getCommunity() {
		return (Organization) sourceOrganization;
	}

	/**
	 * Sets the community of the resource
	 *
	 * @param {Organization} community
	 *                       community of the resource
	 */
	public void setCommunity(Organization community) {
		this.sourceOrganization = community;
	}

	/**
	 * Returns the resource's launch URL
	 *
	 * @return {String}
	 * launch url of resource
	 */
	public String getLaunchURL() {
		return sameAs;
	}

	/**
	 * Sets the launch URL of the resource
	 *
	 * @param {String} page
	 *                 Launch url of the resource
	 */
	public void setLaunchURL(String page) {
		this.sameAs = page;
	}

	/**
         *  Returns the resource's authoring URL
         *
         *  @return {Product}
         *  authoring url of resource
         */
	public Product getAuthoringURL() {
                return isBasedOn;
        }

        /**
         *  Sets the authoring URL of the resource
         *
         *  @param {String} page
         *                  Authoring url of the resource
         */
	public void setAuthoringURL(Product page) {
                this.isBasedOn = page;
        }

	/**
	 * Returns the resource object URL
	 *
	 * @return {String}
	 * url of resource object
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the resource object URL
	 *
	 * @param {String} url
	 *                 url of the resource object
	 */
	public void setUrl(String url) {
		this.url = url;
	}


}
