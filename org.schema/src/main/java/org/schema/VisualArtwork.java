package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/VisualArtwork
 * A work of art that is primarily visual in character.
 * @author schema.org
 * @module schema.org
 * @class VisualArtwork
 * @extends CreativeWork
 */
public class VisualArtwork extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VisualArtwork()
	{
		context="http://schema.org/";
		type="VisualArtwork";
	}

	/**
	 * Schema.org/depth
	 * The depth of the item.
	 * @property depth
	 * @type schema,QuantitativeValue | schema,Distance	 */
	public Object depth;

	/**
	 * Schema.org/artMedium
	 * The material used. (e.g. Oil, Watercolour, Acrylic, Linoprint, Marble, Cyanotype, Digital, Lithograph, DryPoint, Intaglio, Pastel, Woodcut, Pencil, Mixed Media, etc.)
	 * @property artMedium
	 * @type schema,Text | schema,URL	 */
	public Object artMedium;

	/**
	 * Schema.org/surface
	 * e.g. Canvas, Paper, Wood, Board, etc.
	 * @property surface
	 * @type schema,Text | schema,URL	 */
	public Object surface;

	/**
	 * Schema.org/artform
	 * e.g. Painting, Drawing, Sculpture, Print, Photograph, Assemblage, Collage, etc.
	 * @property artform
	 * @type schema,Text | schema,URL	 */
	public Object artform;

	/**
	 * Schema.org/material
	 * e.g. Oil, Watercolour, Acrylic, Linoprint, Marble, Cyanotype, Digital, Lithograph, DryPoint, Intaglio, Pastel, Woodcut, Pencil, Mixed Media, etc.
	 * @property material
	 * @type schema,Text | schema,URL	 */
	public Object material;

	/**
	 * Schema.org/width
	 * The width of the item.
	 * @property width
	 * @type schema,QuantitativeValue | schema,Distance	 */
	public Object width;

	/**
	 * Schema.org/artEdition
	 * The number of copies when multiple copies of a piece of artwork are produced - e.g. for a limited edition of 20 prints, 'artEdition' refers to the total number of copies (in this example "20").
	 * @property artEdition
	 * @type schema,Text | schema,Integer	 */
	public Object artEdition;

	/**
	 * Schema.org/artworkSurface
	 * The supporting materials for the artwork, e.g. Canvas, Paper, Wood, Board, etc.
	 * @property artworkSurface
	 * @type schema,Text | schema,URL	 */
	public Object artworkSurface;

	/**
	 * Schema.org/height
	 * The height of the item.
	 * @property height
	 * @type schema,QuantitativeValue | schema,Distance	 */
	public Object height;

}