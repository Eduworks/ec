package org.schema;

import org.stjs.javascript.Date;

/**
 * Schema.org/Person.
 * @author schema.org
 * @class Person
 */
public class Person extends Thing
{
	public Person()
	{
		context = "http://schema.org/";
		type = "Person";
	}

	public String additionalName;
	public String address;
	public Organization affiliation;
	public Organization alumniOf;
	public String award;
	public Date birthDate;
	public Object birthPlace;
	public Object brand;
	public Person children;
	public Person colleague;
	public Object contactPoint;
	public Date deathdate;
	public Object deathPlace;
	public String duns;
	public String email;
	public String familyName;
	public String faxNumber;
	public Person follows;
	public String gender;
	public String givenName;
	public String globalLocationNumber;
	public Object hasOfferCatalog;
	public Object hasPOS;
	public Object height;
	public Object homeLocation;
	public String honorificPrefix;
	public String honorificSuffix;
	public String isicV4;
	public String jobTitle;
	public Person knows;
	public Object makesOffer;
	public Object memberOf;
	public String naics;
	public Object nationality;
	public Object netWorth;
	public Object owns;
	public Person parent;
	public Object performerIn;
	public Person relatedTo;
	public Demand seeks;
	public Person sibling;
	public Person spouse;
	public String taxID;
	public String telephone;
	public String vatID;
	public Object weight;
	public Object workLocation;
	public Organization worksFor;
}
