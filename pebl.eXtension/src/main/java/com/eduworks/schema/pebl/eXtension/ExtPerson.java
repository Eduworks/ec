package com.eduworks.schema.pebl.eXtension;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.Person;
import org.schema.Organization;
import org.schema.ImageObject;
import org.schema.PostalAddress;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

/**
 * @author debbie.brown@eduworks.com
 */
public class ExtPerson extends Person {

	// legacy eXtension data not mapped to schema.org structure yet -- simply copied over during import for now
	public String legacyId; 		
	public String agreementStatus; 
	public String addressRegion;            // for State
	public String addressLocality;          // for county
	public String lastActiveAt;
	public String communities;
	public Array<String> positionLabels = null;    // for position label format (legacy & UI)
	public Array<String> positionUrls = null;      // for position URL, JSON-LD representation

	
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ExtPerson()
	{
		context="http://schema.eduworks.com/pebleXtension/0.1/";
		type="Person";
	}

	/**
	 * Returns the legacyId of the Person
	 * 
	 * @return {String} 
	 * 			legacyId of person
	 */
	public String getLegacyId(){
		return legacyId;
	}
	
	/**
	 * Sets the legacyId of the Person
	 * 
	 * @param {String} id
	 * 			legacyId of the Person
	 */
	public void setLegacyId(String id){
		this.legacyId = id;
	}

	/**
	 * Returns the first name of the Person
	 * 
	 * @return {String} 
	 * 			first name of person
	 */
	public String getFirstName(){
		return givenName;
	}
	
	/**
	 * Sets the first name of the Person
	 * 
	 * @param {String} name
	 * 			first name of the Person
	 */
	public void setFirstName(String name){
		this.givenName = name;
	}

	/**
	 * Returns the last name of the Person
	 * 
	 * @return {String} 
	 * 			last name of person
	 */
	public String getLastName(){
		return familyName;
	}
	
	/**
	 * Sets the last name of the Person
	 * 
	 * @param {String} name
	 * 			last name of the Person
	 */
	public void setLastName(String name){
		this.familyName = name;
	}
	
	/**
	 * Returns the alternate name of the Person
	 * 
	 * @return {String} 
	 * 			username of person
	 */
	public String getUserName(){
		return alternateName;
	}
	
	/**
	 * Sets the alternate name of the Person
	 * 
	 * @param {String} name
	 * 			username of the Person
	 */
	public void setUserName(String name){
		this.alternateName = name;
	}
	
	/**
	 * Returns the job title of the Person
	 * 
	 * @return {String} 
	 * 			job title of person
	 */
	public String getJobTitle(){
		return jobTitle;
	}
	
	/**
	 * Sets the job title of the Person
	 * 
	 * @param {String} title
	 * 			job title of the Person
	 */
	public void setJobTitle(String title){
		this.jobTitle = title;
	}
	
	/**
	 * Returns the email of the Person
	 * 
	 * @return {String} 
	 * 			email of person
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * Sets the email of the Person
	 * 
	 * @param {String} email
	 * 			email of the Person
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
	/**
	 * Returns the telephone of the Person
	 * 
	 * @return {String} 
	 * 			telephone of person
	 */
	public String getPhone(){
		return telephone;
	}
	
	/**
	 * Sets the telephone number of the Person
	 * 
	 * @param {String} phone
	 * 			telephone of the Person
	 */
	public void setPhone(String phone){
		this.telephone = phone;
	}
	
	/**
	 * Returns the bio of the Person
	 * 
	 * @return {String} 
	 * 			bio of person
	 */
	public String getBio(){
		return description;
	}
	
	/**
	 * Sets the bio of the Person
	 * 
	 * @param {String} bio
	 * 			bio of the Person
	 */
	public void setBio(String bio){
		this.description = bio;
	}
	
	/**
	 * Returns the awards of the Person
	 * 
	 * @return {String} 
	 * 			awards of person
	 */
	public String getAwards(){
		return award;
	}
	
	/**
	 * Sets the awards of the Person
	 * 
	 * @param {String} awards
	 * 			awards of the Person
	 */
	public void setAwards(String awards){
		this.award = awards;
	}
	
	/**
	 * Returns the institution of the Person
	 * 
	 * @return {Organization} 
	 * 			affiliation of person
	 */
	public Organization getInstitution(){
		return affiliation;
	}
	
	/**
	 * Sets the institution of the Person
	 * 
	 * @param {Organization} affiliation
	 * 			affiliation of the Person
	 */
	public void setInstitution(Organization affiliation){
		this.affiliation = affiliation;
	}
	
	/**
	 * Returns the person's location state
	 * 
	 * @return {String} 
	 * 			location state of person
	 */
	public String getLocationState(){
		return addressRegion;
	}
	
	/**
	 * Sets the location state of the Person
	 * 
	 * @param {String} state
	 * 			location state of the Person
	 */
	public void setLocationState(String state){
		this.addressRegion = state;
	}
	
	/**
	 * Returns the person's location county
	 * 
	 * @return {String} 
	 * 			location county of person
	 */
	public String getLocationCounty(){
		return addressLocality;
	}
	
	/**
	 * Sets the location county of the Person
	 * 
	 * @param {String} county
	 * 			location county of the Person
	 */
	public void setLocationCounty(String county){
		this.addressLocality = county;
	}
	
	/**
	 * Returns the thumbnail image URL of the Person
	 * 
	 * @return {ImageObject} 
	 * 			image url of person
	 */
	public ImageObject getImage(){
		return (ImageObject)image;
	}
	
	/**
	 * Sets the thumbnail image URL of the Person
	 * 
	 * @param {ImageObject} image
	 * 			image object of the Person
	 */
	public void setImage(ImageObject image){
		this.image = image;
	}
	
	/**
	 * Returns the person's web page
	 * 
	 * @return {String} 
	 * 			web page url of person
	 */
	public String getWebPage(){
		return sameAs;
	}
	
	/**
	 * Sets the web page URL of the Person
	 * 
	 * @param {String} page
	 * 			web page url of the Person
	 */
	public void setWebPage(String page){
		this.sameAs = page;
	}
	
	/**
	 * Returns the person object URL
	 * 
	 * @return {String} 
	 * 			url of person object
	 */
	public String getUrl(){
		return url;
	}
	
	/**
	 * Sets the person object URL
	 * 
	 * @param {String} url
	 * 			url of the Person object
	 */
	public void setUrl(String url){
		this.url = url;
	}
	
	/**
	 * Returns the person's position in URL form
	 * 
	 * @return {String} 
	 * 			URL of person's position
	 */
	public String getPosition(){
		return additionalType;
	}
	
	/**
	 * Sets the person's position URL.
	 * Validates url as an actual URL, and if not then looks for it in the positionLabels list. (Actual URLs saved as is)
	 * 
	 * @param {String} url
	 * 			url of the Person object
	 */
	public void setPosition(String url){
		if (url.indexOf("http://") < 0) 
			this.additionalType = url;
		else {
			initPositions();
			boolean found = false;
			for(int i=0; i<positionLabels.$length(); i++)
				if (positionLabels.$get(i).equals(url)) {
					this.additionalType = positionUrls.$get(i);
					found = true;
				}
			if (!found) 
				Global.console.log("error: "+url+" not a supported position");
		}
	}
	
	/**
	 * Returns position label corresponding to the URL form
	 * 
	 * @param url
	 *        URL of the person's position
	 * @return {String}
	 */
	public String getPositionLabel(String url){
		initPositions();
		if (url != null && url.length() > 0) {
			for(int i=0; i<positionUrls.$length(); i++)
				if (positionUrls.$get(i).equals(url))
					return positionLabels.$get(i);
			return "Position \""+url+"\" not found.";
		}
		else
			return "";
	}
	
	/**
	 * Returns position URL corresponding to the label form
	 * 
	 * @param type
	 *        type label of the person's position
	 * @return {String}
	 */
	public String getPositionUrl(String type){
		initPositions();
		if (type != null && type.length() > 0) {
			for(int i=0; i<positionLabels.$length(); i++)
				if (positionLabels.$get(i).equals(type))
					return positionUrls.$get(i);
			return "Position \""+type+"\" not found.";
		}
		else
			return "";
	}
	
	/**
	 * Initializes positions arrays so that it can translate legacy position types to JSONLD format
	 */
	public void initPositions()
	{
		// HashMap not supported by ST-JS conversion, so replicating the functionality with two arrays of strings.
		// NOTE: In future if new position types are added, the label and URL forms must be located at the same index.
		if (positionLabels == null || positionLabels.$length() < 1) {
			positionLabels = new Array<String>();
			positionLabels.$set(0, "Administrative assistant");
			positionLabels.$set(1, "Administrator");
			positionLabels.$set(2, "Area or regional educator");
			positionLabels.$set(3, "Communicator");
			positionLabels.$set(4, "County agent/educator");
			positionLabels.$set(5, "Faculty");
			positionLabels.$set(6, "Information technologist");
			positionLabels.$set(7, "Other");
			positionLabels.$set(8, "Professional/staff development");
			positionLabels.$set(9, "Program assistant");
			positionLabels.$set(10, "Master gardener");
			positionLabels.$set(11, "Specialist");
			positionLabels.$set(12, "Volunteer");
		}
		if (positionUrls == null || positionUrls.$length() < 1) {
			positionUrls = new Array<String>();
			positionUrls.$set(0, "http://schema.eduworks.com/pebleXtension/0.1/positionType/Administrative Assistant");
			positionUrls.$set(1, "http://schema.eduworks.com/pebleXtension/0.1/positionType/Administrator");
			positionUrls.$set(2, "http://schema.eduworks.com/pebleXtension/0.1/positionType/AreaOrRegionalEducator");
			positionUrls.$set(3, "http://schema.eduworks.com/pebleXtension/0.1/positionType/Communicator");
			positionUrls.$set(4, "http://schema.eduworks.com/pebleXtension/0.1/positionType/CountyAgentOrEducator");
			positionUrls.$set(5, "http://schema.eduworks.com/pebleXtension/0.1/positionType/Faculty");
			positionUrls.$set(6, "http://schema.eduworks.com/pebleXtension/0.1/positionType/InformationTechnologist");
			positionUrls.$set(7, "http://schema.eduworks.com/pebleXtension/0.1/positionType/Other");
			positionUrls.$set(8, "http://schema.eduworks.com/pebleXtension/0.1/positionType/ProfessionalOrStaffDevelopment");
			positionUrls.$set(9, "http://schema.eduworks.com/pebleXtension/0.1/positionType/ProgramAssistant");
			positionUrls.$set(10, "http://schema.eduworks.com/pebleXtension/0.1/positionType/MasterGardener");
			positionUrls.$set(11, "http://schema.eduworks.com/pebleXtension/0.1/positionType/Specialist");
			positionUrls.$set(12, "http://schema.eduworks.com/pebleXtension/0.1/positionType/Volunteer");
		}

	}
	

	
	/**
	 * Saves this person on the server corresponding to its ID 
	 * 
	 * @memberOf ExtPerson
	 * @method save
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successfully saving the ExtPerson
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error while saving ExtPerson
	 */
	public void save(Callback1<String> success, Callback1<String> failure){
		if(givenName == null || givenName == ""){
			String msg = "First name cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		if(familyName == null || familyName == ""){
			String msg = "Last name cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		if(url == null || url == ""){
			String msg = "Url cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		if(email == null || email == ""){
			String msg = "Email cannot be missing";
			if(failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		
		EcRepository._save(this, success, failure);
	}
	
	
	/**
	 * Deletes the person from the server corresponding to its ID
	 * 
	 * @memberOf ExtPerson
	 * @method _delete
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successfully deleting the person
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error while deleting person
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure){
		EcRepository.DELETE(this, success, failure);
	}
	
	/**
	 * Retrieves the person specified with the ID from the server
	 * 
	 * @memberOf ExtPerson
	 * @method get
	 * @static
	 * @param {String} id
	 * 			ID of the person to retrieve
	 * @param {Callback1<ExtPerson>} success
	 * 			Callback triggered on successfully retrieving the person,
	 * 			returns the person
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error while retrieving person
	 */
	public static void get(String id, final Callback1<ExtPerson> success, final Callback1<String> failure)
	{
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>()
		{
			@Override
			public void $invoke(EcRemoteLinkedData p1)
			{
                if (p1 instanceof ExtPerson)
                    if (success != null)
                    {
                        success.$invoke((ExtPerson) p1);
                        return;
                    }
                
                ExtPerson person = new ExtPerson();
				
				if (p1.isA(EcEncryptedValue.myType))
				{
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();
				}
				if (p1.isAny(person.getTypes()))
				{
					person.copyFrom(p1);
                    if (EcRepository.caching)
                    {
                        JSObjectAdapter.$put(EcRepository.cache,person.shortId(),person);
                        JSObjectAdapter.$put(EcRepository.cache,person.id,person);
                    }
					if(success != null)
						success.$invoke(person);
				}
				else
				{
					String msg = "Resultant object is not a person.";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}
				
			}
		}, failure);
	}
	
	/**
	 * Retrieves a person from the server synchronously, the call 
	 * blocks until it is successful or an error occurs
	 * 
	 * @memberOf ExtPerson
	 * @method getBlocking
	 * @static
	 * @param {String} id
	 * 			ID of the person to retrieve
	 * @return ExtPerson
	 * 			The person retrieved
	 */
	public static ExtPerson getBlocking(String id)
	{
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
                if (p1 instanceof ExtPerson)
                    return (ExtPerson) p1;

                ExtPerson person = new ExtPerson();

		if (p1.isA(EcEncryptedValue.myType))
		{
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(person.getTypes()))
		{
			person.copyFrom(p1);
                    if (EcRepository.caching)
                    {
                        JSObjectAdapter.$put(EcRepository.cache,person.shortId(),person);
                        JSObjectAdapter.$put(EcRepository.cache,person.id,person);
                    }
			return person;
		} 
        else
		{
			String msg = "Retrieved object was not a person";
			Global.console.error(msg);
			return null;
		}
	}
        
	/**
	 * Searches the repository using the query and optional parameters provided
	 * 
	 * @memberOf ExtPerson
	 * @method search
	 * @static
	 * @param {EcRepository} repo
	 * 			Repository to search using the query provided
	 * @param {String} query
	 * 			The query to send to the search
	 * @param {Callback1<Array<ExtPerson>>} success
	 * 			Callback triggered on successful search return
	 * @param {Callback1<String>} [failure]
	 * 			Callback triggered if error searching
	 * @param {Object} [paramObj]
	 * 			Parameters to include in the search
	 * 		@param start
	 * 		@param size
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<ExtPerson>> success, Callback1<String> failure, Object paramObj){
		String queryAdd = new ExtPerson().getSearchStringByType();
		
		if (query == null || query == "")
			query = queryAdd;
		else
//			query = "(" + query + ") AND educationalUse:\""+edUse+"\" AND " + queryAdd;
			query = "(" + query + ") AND " + queryAdd;
		
		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>(){

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if(success != null)
				{
					Array<ExtPerson> ret = JSCollections.$array();
					for(int i = 0; i < p1.$length(); i++){
						ExtPerson person = new ExtPerson();
//						if(p1.$get(i).isAny(person.getTypes())){
							person.copyFrom(p1.$get(i));
//						}
//						else if(p1.$get(i).isA(EcEncryptedValue.myType)){
//							EcEncryptedValue val = new EcEncryptedValue();
//							val.copyFrom(p1.$get(i));
//							if(val.isAnEncrypted(ExtPerson.myType)){
//								EcRemoteLinkedData obj = val.decryptIntoObject();
//								person.copyFrom(obj);
//							}
//						}
						
						ret.$set(i, person);
					}
					
					success.$invoke(ret);
				}
			}
			
		}, failure);
	}
}
