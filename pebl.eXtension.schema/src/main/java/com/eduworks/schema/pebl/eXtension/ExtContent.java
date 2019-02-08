package com.eduworks.schema.pebl.eXtension;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.Organization;
import org.schema.Person;
import org.schema.CreativeWork;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;

/**
 * @author debbie.brown@eduworks.com
 */

public class ExtContent extends CreativeWork {


	// legacy eXtension data not mapped to schema.org structure yet -- simply copied over during import for now
	public String legacyId;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ExtContent() {
		context = "http://schema.eduworks.com/pebleXtension/0.1/";
		type = "Content";
	}

	/**
	 * Retrieves the content specified with the ID from the server
	 *
	 * @param {String}               id
	 *                               ID of the content to retrieve
	 * @param {Callback1<ExtContent>} success
	 *                               Callback triggered on successfully retrieving the content,
	 *                               returns the content
	 * @param {Callback1<String>}    [failure]
	 *                               Callback triggered if error while retrieving content
	 * @memberOf ExtContent
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<ExtContent> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				if (p1 instanceof ExtContent)
					if (success != null) {
						success.$invoke((ExtContent) p1);
						return;
					}

				ExtContent content = new ExtContent();

				if (p1.isA(EcEncryptedValue.myType)) {
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
				}
				if (p1.isAny(content.getTypes())) {
					content.copyFrom(p1);
					if (EcRepository.caching) {
						JSObjectAdapter.$put(EcRepository.cache, content.shortId(), content);
						JSObjectAdapter.$put(EcRepository.cache, content.id, content);
					}
					if (success != null)
						success.$invoke(content);
				} else {
					String msg = "Resultant object is not a content.";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}

			}
		}, failure);
	}

	/**
	 * Retrieves a content from the server synchronously, the call
	 * blocks until it is successful or an error occurs
	 *
	 * @param {String} id
	 *                 ID of the content to retrieve
	 * @return ExtContent
	 * The content retrieved
	 * @memberOf ExtContent
	 * @method getBlocking
	 * @static
	 */
	public static ExtContent getBlocking(String id) {
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
		if (p1 instanceof ExtContent)
			return (ExtContent) p1;

		ExtContent content = new ExtContent();

		if (p1.isA(EcEncryptedValue.myType)) {
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(content.getTypes())) {
			content.copyFrom(p1);
			if (EcRepository.caching) {
				JSObjectAdapter.$put(EcRepository.cache, content.shortId(), content);
				JSObjectAdapter.$put(EcRepository.cache, content.id, content);
			}
			return content;
		} else {
			String msg = "Retrieved object was not a content";
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
	 * @param {Callback1<Array<ExtContent>>} success
	 *                                      Callback triggered on successful search return
	 * @param {Callback1<String>}           [failure]
	 *                                      Callback triggered if error searching
	 * @param {Object}                      [paramObj]
	 *                                      Parameters to include in the search
	 * @param start
	 * @param size
	 * @memberOf ExtContent
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<ExtContent>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = new ExtContent().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
//			query = "(" + query + ") AND educationalUse:\""+edUse+"\" AND " + queryAdd;
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<ExtContent> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {
						ExtContent content = new ExtContent();
//						if(p1.$get(i).isAny(content.getTypes())){
						content.copyFrom(p1.$get(i));
//						}
//						else if(p1.$get(i).isA(EcEncryptedValue.myType)){
//							EcEncryptedValue val = new EcEncryptedValue();
//							val.copyFrom(p1.$get(i));
//							if(val.isAnEncrypted(ExtContent.myType)){
//								EcRemoteLinkedData obj = val.decryptIntoObject();
//								content.copyFrom(obj);
//							}
//						}

						ret.$set(i, content);
					}

					success.$invoke(ret);
				}
			}

		}, failure);
	}

	/**
	 * Saves this content on the server corresponding to its ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully saving the ExtContent
	 * @param {Callback1<String>} [failure]
	 *                            Callback triggered if error while saving ExtContent
	 * @return {ExtContent}
	 * @memberOf ExtContent
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
		if (getDescription() == null || getDescription() == "") {
			String msg = "Description cannot be missing";
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
		if (getInstitution() == null || getInstitution().name == null || getInstitution().name == "") {
			String msg = "Institution name cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return null;
		}

		EcRepository.save(this, success, failure);
		return "Content " + getId() + " saved.";
	}

	/**
	 * Deletes the content from the server corresponding to its ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully deleting the content
	 * @param {Callback1<String>} [failure]
	 *                            Callback triggered if error while deleting content
	 * @memberOf ExtContent
	 * @method _delete
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure) {
		EcRepository.DELETE(this, success, failure);
	}

	/**
	 * Returns the ID of the content
	 *
	 * @return {String}
	 * ID of content
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the ID of the content
	 *
	 * @param {String} id
	 *                 ID of the content
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the legacyId of the content
	 *
	 * @return {String}
	 * legacyId of content
	 */
	public String getLegacyId() {
		return legacyId;
	}

	/**
	 * Sets the legacyId of the content
	 *
	 * @param {String} id
	 *                 legacyId of the content
	 */
	public void setLegacyId(String id) {
		this.legacyId = id;
	}

	/**
	 * Returns the author of the content
	 *
	 * @return {Person}
	 * author of content
	 */
	public Person getAuthor() {
		return (Person) author;
	}

	/**
	 * Sets the author of the content
	 *
	 * @param {Person} creator
	 */
	public void setAuthor(Person creator) {
		this.author = creator;
	}

	/**
	 * Returns the title of the content
	 *
	 * @return {String}
	 * title of content
	 */
	public String getTitle() {
		return name;
	}

	/**
	 * Sets the title of the content
	 *
	 * @param {String} title
	 *                 title of the content
	 */
	public void setTitle(String title) {
		this.name = title;
	}

	/**
	 * Returns the description of the content
	 *
	 * @return {String}
	 * description of content
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the content
	 *
	 * @param {String} description
	 *                 description of the content
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the genre/category of the content
	 *
	 * @return {String}
	 * genre of content
	 */
	public String getCategory() {
		return (String) genre;
	}

	/**
	 * Sets the genre/category of the content
	 *
	 * @param {String} name
	 *                 category of the content
	 */
	public void setCategory(String name) {
		this.genre = name;
	}

	/**
	 * Returns the institution of the content
	 *
	 * @return {Organization}
	 * publisher of content
	 */
	public Person getInstitution() {
		return publisher;
	}

	/**
	 * Sets the institution of the content
	 *
	 * @param {Organization} institution
	 *                       institution of the content
	 */
	public void setInstitution(Person institution) {
		this.publisher = institution;
	}

	/**
	 * Returns the content's launch URL
	 *
	 * @return {String}
	 * launch url of content
	 */
	public String getLaunchURL() {
		return sameAs;
	}

	/**
	 * Sets the web page URL of the content
	 *
	 * @param {String} page
	 *                 Launch url of the content
	 */
	public void setLaunchURL(String page) {
		this.sameAs = page;
	}

	/**
	 * Returns the content object URL
	 *
	 * @return {String}
	 * url of content object
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the content object URL
	 *
	 * @param {String} url
	 *                 url of the content object
	 */
	public void setUrl(String url) {
		this.url = url;
	}


}
