package org.schema;

public class Service extends Thing
{
	public Service()
	{
		context = "http://schema.org/";
		type = "Service";
	}

	// AggregateRating aggregateRating ;
	Thing areaServed;
	// Audience audience ;
	// ServiceChannel availableChannel ;
	String award;
	Organization brand;
	Thing category;
	// OfferCatalog hasOfferCatalog ;
	// OpeningHoursSpecification hoursAvailable ;
	Thing isRelatedTo;
	Thing isSimilarTo;
	Thing logo;
	// Offer offers ;
	Person provider;
	String providerMobility;
	// Review review ;
	Thing serviceOutput;
	String serviceType;
}
