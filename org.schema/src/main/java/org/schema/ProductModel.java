package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ProductModel
 * A datasheet or vendor specification of a product (in the sense of a prototypical description).
 * @author schema.org
 * @class ProductModel
 * @module org.schema
 * @extends Product
 */
public class ProductModel extends Product
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ProductModel()
	{
		context="http://schema.org/";
		type="ProductModel";
	}

	/**
	 * Schema.org/successorOf
	 * A pointer from a newer variant of a product  to its previous, often discontinued predecessor.
	 * @property successorOf
	 * @type ProductModel
	 */
	public ProductModel successorOf;

	/**
	 * Schema.org/isVariantOf
	 * A pointer to a base product from which this product is a variant. It is safe to infer that the variant inherits all product features from the base model, unless defined locally. This is not transitive.
	 * @property isVariantOf
	 * @type ProductModel
	 */
	public ProductModel isVariantOf;

	/**
	 * Schema.org/predecessorOf
	 * A pointer from a previous, often discontinued variant of the product to its newer variant.
	 * @property predecessorOf
	 * @type ProductModel
	 */
	public ProductModel predecessorOf;

}