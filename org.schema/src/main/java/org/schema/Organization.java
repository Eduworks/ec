package org.schema;

import org.stjs.javascript.Array;
import org.stjs.javascript.Date;

public class Organization extends Thing {
	
	public Organization()
	{
		context = "http://schema.org/";
		type = "http://schema.org/Organization";
	}
	public String address;
	public Thing aggregateRating;
	public Person alumni;
	public String areaServed;
	public String award;
	public Object brand;
	public Object contactPoint;
	public Organization department;
	public Date dissolutionDate;
	public String duns;
	public String email;
	public Person employee;
	public Object event;
	public String faxNumber;
	public Person founder;
	public Date foundingDate;
	public Object foundingLocation;
	public String globalLocationNumber;
	public Object hasOfferCatalog;
	public Object hasPOS;
	public String isicV4;
	public String legalName;
	public String location;
	public Object logo;
	public Object makesOffer;
	public Thing member;
	public Organization memberOf;
	public String naics;
	public Object numberOfEmployees;
	public Object owns;
	public Organization parentOrganization;
	public Object review;
	public Object seeks;
	public Organization subOrganization;
	public String taxID;
	public String telephone;
	public String vatID;
}
