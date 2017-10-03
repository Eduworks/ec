package com.eduworks.schema.pebl.eXtension;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.*;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

/**
 * @author debbie.brown@eduworks.com
 */

public class ExtInstitution extends Organization {
	// Type constants
	public static String EMPLOYEE_TYPE_ADMINISTRATOR = "administrator";
	public static String EMPLOYEE_TYPE_ASSISTANT = "assistant";
	public static String EMPLOYEE_TYPE_IT = "IT";
	/**
	 * ExtInstitution objects use the following elements from schema.org/Organization:
	 * - id
	 * - context
	 * - type
	 * - url
	 * - name
	 * - description
	 * - sameAs
	 * - address
	 * - telephone
	 * - faxNumber
	 * - areaServed (ECOP Region)
	 * - member (for administrators)
	 * - employee (for assistant)
	 * - contactPoint (for IT poc)
	 * - logo
	 */

	// legacy eXtension data not mapped to schema.org structure yet -- simply copied over during import for now
	public String legacyId;
	public String locationState;
	public String memberCount;
	public String communityLink;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ExtInstitution() {
		context = "http://schema.eduworks.com/pebleXtension/0.1/";
		type = "Institution";
	}

	/**
	 * Retrieves the institution specified with the ID from the server
	 *
	 * @param {String}                    id
	 *                                    ID of the institution to retrieve
	 * @param {Callback1<ExtInstitution>} success
	 *                                    Callback triggered on successfully retrieving the institution,
	 *                                    returns the institution
	 * @param {Callback1<String>}         [failure]
	 *                                    Callback triggered if error while retrieving institution
	 * @memberOf ExtInstitution
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<ExtInstitution> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				if (p1 instanceof ExtInstitution)
					if (success != null) {
						success.$invoke((ExtInstitution) p1);
						return;
					}

				ExtInstitution institution = new ExtInstitution();

				if (p1.isA(EcEncryptedValue.myType)) {
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
				}
				if (p1.isAny(institution.getTypes())) {
					institution.copyFrom(p1);
					if (EcRepository.caching) {
						JSObjectAdapter.$put(EcRepository.cache, institution.shortId(), institution);
						JSObjectAdapter.$put(EcRepository.cache, institution.id, institution);
					}
					if (success != null)
						success.$invoke(institution);
				} else {
					String msg = "Resultant object is not a institution.";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}

			}
		}, failure);
	}

	/**
	 * Retrieves a institution from the server synchronously, the call
	 * blocks until it is successful or an error occurs
	 *
	 * @param {String} id
	 *                 ID of the institution to retrieve
	 * @return ExtInstitution
	 * The institution retrieved
	 * @memberOf ExtInstitution
	 * @method getBlocking
	 * @static
	 */
	public static ExtInstitution getBlocking(String id) {
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
		if (p1 instanceof ExtInstitution)
			return (ExtInstitution) p1;

		ExtInstitution institution = new ExtInstitution();

		if (p1.isA(EcEncryptedValue.myType)) {
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(institution.getTypes())) {
			institution.copyFrom(p1);
			if (EcRepository.caching) {
				JSObjectAdapter.$put(EcRepository.cache, institution.shortId(), institution);
				JSObjectAdapter.$put(EcRepository.cache, institution.id, institution);
			}
			return institution;
		} else {
			String msg = "Retrieved object was not a institution";
			Global.console.error(msg);
			return null;
		}
	}

	/**
	 * Searches the repository using the query and optional parameters provided
	 *
	 * @param {EcRepository}                     repo
	 *                                           Repository to search using the query provided
	 * @param {String}                           query
	 *                                           The query to send to the search
	 * @param {Callback1<Array<ExtInstitution>>} success
	 *                                           Callback triggered on successful search return
	 * @param {Callback1<String>}                [failure]
	 *                                           Callback triggered if error searching
	 * @param {Object}                           [paramObj]
	 *                                           Parameters to include in the search
	 * @param start
	 * @param size
	 * @memberOf ExtInstitution
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<ExtInstitution>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = new ExtInstitution().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
//			query = "(" + query + ") AND educationalUse:\""+edUse+"\" AND " + queryAdd;
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<ExtInstitution> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {
						ExtInstitution institution = new ExtInstitution();
//						if(p1.$get(i).isAny(institution.getTypes())){
						institution.copyFrom(p1.$get(i));
//						}
//						else if(p1.$get(i).isA(EcEncryptedValue.myType)){
//							EcEncryptedValue val = new EcEncryptedValue();
//							val.copyFrom(p1.$get(i));
//							if(val.isAnEncrypted(ExtInstitution.myType)){
//								EcRemoteLinkedData obj = val.decryptIntoObject();
//								institution.copyFrom(obj);
//							}
//						}

						ret.$set(i, institution);
					}

					success.$invoke(ret);
				}
			}

		}, failure);
	}

	/**
	 * Saves this institution on the server corresponding to its ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully saving the ExtInstitution
	 * @param {Callback1<String>} [failure]
	 *                            Callback triggered if error while saving ExtInstitution
	 * @return {ExtInstitution}
	 * @memberOf ExtInstitution
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
		if (getName() == null || getName() == "") {
			String msg = "Name cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return null;
		}
		if (getWebPage() == null || getWebPage() == "") {
			String msg = "Official web page cannot be missing";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return null;
		}

		EcRepository.save(this, success, failure);
		return "Institution " + getId() + " saved.";
	}

	/**
	 * Deletes the institution from the server corresponding to its ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully deleting the institution
	 * @param {Callback1<String>} [failure]
	 *                            Callback triggered if error while deleting institution
	 * @memberOf ExtInstitution
	 * @method _delete
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure) {
		EcRepository.DELETE(this, success, failure);
	}
	
	/**
	 * Returns the ID of the Institution
	 *
	 * @return {String}
	 * ID of institution
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the ID of the Institution
	 *
	 * @param {String} id
	 *                 ID of the Institution
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the legacyId of the Institution
	 *
	 * @return {String}
	 * legacyId of institution
	 */
	public String getLegacyId() {
		return legacyId;
	}

	/**
	 * Sets the legacyId of the Institution
	 *
	 * @param {String} id
	 *                 legacyId of the Institution
	 */
	public void setLegacyId(String id) {
		this.legacyId = id;
	}

	/**
	 * Returns the name of the Institution
	 *
	 * @return {String}
	 * name of institution
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the first name of the Institution
	 *
	 * @param {String} name
	 *                 first name of the Institution
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the alternate name of the Institution
	 *
	 * @return {String}
	 * alternate name of institution
	 */
	public String getAlternateName() {
		return alternateName;
	}

	/**
	 * Sets the alternate name of the Institution
	 *
	 * @param {String} name
	 *                 alternate name of the Institution
	 */
	public void setAlternateName(String name) {
		this.alternateName = name;
	}

	/**
	 * Returns the telephone of the Institution
	 *
	 * @return {String}
	 * telephone of institution
	 */
	public String getPhone() {
		return telephone;
	}

	/**
	 * Sets the telephone number of the Institution
	 *
	 * @param {String} phone
	 *                 telephone of the Institution
	 */
	public void setPhone(String phone) {
		this.telephone = phone;
	}

	/**
	 * Returns the fax of the Institution
	 *
	 * @return {String}
	 * fax of institution
	 */
	public String getFax() {
		return faxNumber;
	}

	/**
	 * Sets the fax number of the Institution
	 *
	 * @param {String} fax
	 *                 fax of the Institution
	 */
	public void setFax(String fax) {
		this.faxNumber = fax;
	}

	/**
	 * Returns the description of the Institution
	 *
	 * @return {String}
	 * description of institution
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the Institution
	 *
	 * @param {String} desc
	 *                 description of the Institution
	 */
	public void setDescription(String desc) {
		this.description = desc;
	}

	/**
	 * Returns the institution's web page
	 *
	 * @return {String}
	 * web page url of institution
	 */
	public String getWebPage() {
		return sameAs;
	}

	/**
	 * Sets the web page URL of the Institution
	 *
	 * @param {String} page
	 *                 web page url of the Institution
	 */
	public void setWebPage(String page) {
		this.sameAs = page;
	}

	/**
	 * Returns the institution's people community link
	 *
	 * @return {String}
	 * people community link of institution
	 */
	public String getCommunityLink() {
		return communityLink;
	}

	/**
	 * Sets the people community link of the Institution
	 *
	 * @param {String} page
	 *                 people community link of the Institution
	 */
	public void setCommunityLink(String page) {
		this.communityLink = page;
	}

	/**
	 * Returns the institution object URL
	 *
	 * @return {String}
	 * url of institution object
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the institution object URL
	 *
	 * @param {String} url
	 *                 url of the Institution object
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns the institution's location state
	 *
	 * @return {String}
	 * location state of institution
	 */
	public String getLocationState() {
		return locationState;
	}

	/**
	 * Sets the location state of the Institution
	 *
	 * @param {String} state
	 *                 location state of the Institution
	 */
	public void setLocationState(String state) {
		this.locationState = state;
	}

	/**
	 * Returns the thumbnail image URL of the institution
	 *
	 * @return {ImageObject}
	 * image url of institution
	 */
	public ImageObject getImage() {
		return (ImageObject) logo;
	}

	/**
	 * Sets the thumbnail image URL of the institution
	 *
	 * @param {ImageObject} image
	 *                      image object of the institution
	 */
	public void setImage(ImageObject image) {
		this.logo = image;
	}

	/**
	 * Returns the institution's region
	 *
	 * @return {String}
	 * region of institution
	 */
	public String getRegion() {
		return areaServed.toString();
	}

	/**
	 * Sets the region of the Institution
	 *
	 * @param {String} region
	 *                 region of the Institution
	 */
	public void setRegion(String region) {
		this.areaServed = region;
	}

	/**
	 * Returns the institution's number of members
	 *
	 * @return {}
	 * number of members at institution
	 */
	public String getMemberCount() {
		return memberCount;
	}

	/**
	 * Sets the member count for the Institution
	 *
	 * @param {String} count
	 *                 member count at the Institution
	 */
	public void setMemberCount(String count) {

		this.memberCount = count;
	}

	/**
	 * Returns the assistant POC of the Institution
	 *
	 * @return {Person}
	 * assistant poc of institution
	 */
	public Person getAssistantPOC() {
		return (Person) employee;
	}

	/**
	 * Sets assistant POC for the Institution
	 *
	 * @param {Person} poc
	 *                 assistant POC at the Institution
	 */
	public void setAssistantPOC(Person poc) {

		this.employee = poc;
	}

	/**
	 * Returns the administrative POC of the Institution
	 *
	 * @return {Person}
	 * administrative poc of institution
	 */
	public Person getAdminPOC() {
		return (Person) member;
	}

	/**
	 * Sets administrative POC for the Institution
	 *
	 * @param {Person} poc
	 *                 administrativePOC at the Institution
	 */
	public void setAdminPOC(Person poc) {
		this.member = poc;
	}

	/**
	 * Returns the IT POC of the Institution
	 *
	 * @return {ContactPoint}
	 * IT poc of institution
	 */
	public ContactPoint getITPOC() {
		return (ContactPoint) contactPoint;
	}

	/**
	 * Sets IT POC for the Institution
	 *
	 * @param {ContactPoint} poc
	 *                       IT POC at the Institution
	 */
	public void setITPOC(ContactPoint poc) {

		this.contactPoint = poc;
	}

	/**
	 * Adds a POC for the institution from raw contact information
	 *
	 * @param {String} type
	 * @param {String} name
	 * @param {String} title
	 * @param {String} email
	 * @param {String} phone
	 * @param {String} fax
	 * @param {String} addr1
	 * @param {String} addr2
	 * @param {String} addrCityState
	 * @param {String} addrZip
	 */
	public void addPOC(String type, String name, String title, String email, String phone, String fax, String addr1, String addr2, String addr3, String addrCityState, String addrZip) {
		PostalAddress addr = new PostalAddress();
		if (addr1 != null && addr1 != "" && addr2 != null && addr2 != "" && addr3 != null && addr3 != "") {
			// If the POC provided three address lines, assume that the first is a name
			addr.name = addr1.trim();
			addr.streetAddress = addr2.trim() + ", " + addr3.trim();
		} else if (addr1 != null && addr1 != "" && addr2 != null && addr2 != "") {
			addr.streetAddress = addr1.trim() + ", " + addr2.trim();
		} else if (addr1 != null && addr1 != "") {
			addr.streetAddress = addr1.trim();
		}
		if (addrCityState != null && addrCityState != "") {
			addr.addressLocality = addrCityState.substring(0, addrCityState.indexOf(",")).trim();
			addr.addressRegion = addrCityState.substring(addrCityState.indexOf(",") + 1).trim();
		}
		if (addrZip != null && addrZip != "")
			addr.postalCode = addrZip.trim();

		if (type.equals(EMPLOYEE_TYPE_ADMINISTRATOR) || type.equals(EMPLOYEE_TYPE_ASSISTANT)) {
			Person poc = new Person();
			if (name != null && name != "")
				poc.name = name.trim();
			if (title != null && title != "")
				poc.jobTitle = title.trim();
			if (phone != null && phone != "")
				poc.telephone = phone.trim();
			if (fax != null && fax != "")
				poc.faxNumber = fax.trim();
			if (email != null && email != "")
				poc.email = email.trim();
			if ((addr1 != null && addr1 != "") || (addr2 != null && addr2 != "") || (addr3 != null && addr3 != "") ||
					(addrCityState != null && addrCityState != "") || (addrZip != null && addrZip != ""))
				poc.address = addr;
			// Global.console.log(JSGlobal.JSON.stringify(poc));
			if (type.equals(EMPLOYEE_TYPE_ADMINISTRATOR))
				setAdminPOC(poc);
			else if (type.equals(EMPLOYEE_TYPE_ASSISTANT))
				setAssistantPOC(poc);
		} else if (type.equals(EMPLOYEE_TYPE_IT)) {
			ContactPoint poc = new ContactPoint();
			if (name != null && name != "")
				poc.name = name.trim();
			if (title != null && title != "")
				poc.contactType = title.trim();
			if (phone != null && phone != "")
				poc.telephone = phone.trim();
			if (fax != null && fax != "")
				poc.faxNumber = fax.trim();
			if (email != null && email != "")
				poc.email = email.trim();
			if ((addr1 != null && addr1 != "") && (addr2 != null && addr2 != ""))
				poc.sameAs = addr1.trim() + ", " + addr2;
			else if (addr1 != null && addr1 != "")
				poc.sameAs = addr1.trim();
			else if (addr2 != null && addr2 != "")
				poc.sameAs = addr2.trim();
			// Global.console.log(JSGlobal.JSON.stringify(poc));
			setITPOC(poc);
		}

	}

}
