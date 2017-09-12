package org.schema;

/**
 * Schema.org/Corporation
 * Organization: A business corporation.
 *
 * @author schema.org
 * @class Corporation
 * @module org.schema
 * @extends Organization
 */
public class Corporation extends Organization {
	/**
	 * Schema.org/tickerSymbol
	 * The exchange traded instrument associated with a Corporation object. The tickerSymbol is expressed as an exchange and an instrument name separated by a space character. For the exchange component of the tickerSymbol attribute, we reccommend using the controlled vocaulary of Market Identifier Codes (MIC) specified in ISO15022.
	 *
	 * @property tickerSymbol
	 * @type Text
	 */
	public String tickerSymbol;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Corporation() {
		context = "http://schema.org/";
		type = "Corporation";
	}

}