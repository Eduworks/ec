package org.schema;

import org.stjs.javascript.Date;

public class CreativeWork extends Thing {
	
	public CreativeWork()
	{
		context = "http://schema.org/";
		type = "http://schema.org/CreativeWork";
	}
	public Thing about;
	public String accessibilityAPI;
	public String accessibilityControl;
	public String accessibilityFeature;
	public String accessibilityHazard;
	public Person accountablePerson;
	public Object aggregateRating;
	public String alternativeHeadline;
	public Object associatedMedia;
	public Object audience;
	public Object audio;
	public Thing author; // Person or Organization
	public String award;
	public Person character;
	public Object citation;
	public Object comment;
	public Integer commentCount;
	public Object contentLocation;
	public String contentRating;
	public Thing contributor; // Person or Organization
	public Thing copyrightHolder; // Person or Organization
	public Integer copyrightYear;
	public Thing creator; // Person or Organization
	public Date dateCreated;
	public Date dateModified;
	public Date datePublished;
	public String discussionUrl;
	public Person editor;
	public AlignmentObject educationalAlignment;
	public String educationalUse;
	public Object encoding;
	public CreativeWork exampleOfWork;
	public String fileFormat; // mimeType
	public String genre;
	public CreativeWork hasPart;
	public String headline;
	public String inLanguage;
	public Object interactionStatistic;
	public String interactivityType; // 'active', 'expositive' or 'mixed'
	public String isBasedOnUrl;
	public Boolean isFamilyFriendly;
	public CreativeWork isPartOf;
	public String keywords;
	public String learningResourceType;
	public Object license; // URL or CreativeWork
	public Object locationCreated;
	public Thing mainEntity;
	public Thing mentions;
	public Object offers;
	public Object position; // String or Integer
	public Thing producer; // Person or Organization
	public Thing provider; // Person or Organization
	public Object publication;
	public Thing publisher; // Person or Organization
	public String publishingPrinciples;
	public Object recordedAt;
	public Object releasedEvent;
	public Object review;
	public String schemaVersion;
	public Organization sourceOrganization;
	public String text;
	public String thumbnailUrl;
	public Object timeRequired;
	public Thing translator; // Person or Organization
	public String typicalAgeRange;
	public Integer version;
	public Object video;
	public CreativeWork workExample;
}
