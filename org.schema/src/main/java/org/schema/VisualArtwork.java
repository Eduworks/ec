package org.schema;

/**
 * Schema.org/VisualArtwork
 * A work of art that is primarily visual in character.
 *
 * @author schema.org
 * @class VisualArtwork
 * @module org.schema
 * @extends CreativeWork
 */
public class VisualArtwork extends CreativeWork {
	/**
	 * Schema.org/artMedium
	 * The material used. (e.g. Oil, Watercolour, Acrylic, Linoprint, Marble, Cyanotype, Digital, Lithograph, DryPoint, Intaglio, Pastel, Woodcut, Pencil, Mixed Media, etc.)
	 *
	 * @property artMedium
	 * @type schema, URL | schema,Text
	 */
	public Object artMedium;
	/**
	 * Schema.org/height
	 * The height of the item.
	 *
	 * @property height
	 * @type schema, Distance | schema,QuantitativeValue
	 */
	public Object height;
	/**
	 * Schema.org/artform
	 * e.g. Painting, Drawing, Sculpture, Print, Photograph, Assemblage, Collage, etc.
	 *
	 * @property artform
	 * @type schema, URL | schema,Text
	 */
	public Object artform;
	/**
	 * Schema.org/depth
	 * The depth of the item.
	 *
	 * @property depth
	 * @type schema, Distance | schema,QuantitativeValue
	 */
	public Object depth;
	/**
	 * Schema.org/surface
	 * A material used as a surface in some artwork, e.g. Canvas, Paper, Wood, Board, etc.
	 *
	 * @property surface
	 * @type schema, URL | schema,Text
	 */
	public Object surface;
	/**
	 * Schema.org/width
	 * The width of the item.
	 *
	 * @property width
	 * @type schema, Distance | schema,QuantitativeValue
	 */
	public Object width;
	/**
	 * Schema.org/artEdition
	 * The number of copies when multiple copies of a piece of artwork are produced - e.g. for a limited edition of 20 prints, 'artEdition' refers to the total number of copies (in this example "20").
	 *
	 * @property artEdition
	 * @type schema, Integer | schema,Text
	 */
	public Object artEdition;
	/**
	 * Schema.org/artworkSurface
	 * The supporting materials for the artwork, e.g. Canvas, Paper, Wood, Board, etc.
	 *
	 * @property artworkSurface
	 * @type schema, URL | schema,Text
	 */
	public Object artworkSurface;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public VisualArtwork() {
		context = "http://schema.org/";
		type = "VisualArtwork";
	}

}