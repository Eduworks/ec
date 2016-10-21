package org.schema;

import org.stjs.javascript.Date;

public class Demand extends Thing
{
	public Demand()
	{
		context = "http://schema.org/";
		type = "Demand";
	}

	Thing acceptedPaymentMethod;
	// QuantitativeValue advanceBookingRequirement;
	Thing areaServed;
	// ItemAvailability availability;
	Date availabilityEnds;
	Date availabilityStarts;
	// Place availableAtOrFrom;
	// DeliveryMethod availableDeliveryMethod;
	// BusinessFunction businessFunction;
	// QuantitativeValue deliveryLeadTime;
	// BusinessEntityType eligibleCustomerType;
	// QuantitativeValue eligibleDuration;
	// QuantitativeValue eligibleQuantity;
	Thing eligibleTransactionVolume;
	String gtin12;
	String gtin13;
	String gtin14;
	String gtin8;
	// TypeAndQuantityNode includesObject;
	Thing inventoryLevel;
	// OfferItemCondition itemCondition;
	Service itemOffered;
	String mpn;
	// PriceSpecification priceSpecification;
	Thing seller;
	String serialNumber;
	String sku;
	Date validFrom;
	Date validThrough;
	// WarrantyPromise warranty;

}
