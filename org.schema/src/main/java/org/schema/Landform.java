package org.schema;

/**
 * Schema.org/Landform
 * A landform or physical feature.  Landform elements include mountains, plains, lakes, rivers, seascape and oceanic waterbody interface features such as bays, peninsulas, seas and so forth, including sub-aqueous terrain features such as submersed mountain ranges, volcanoes, and the great ocean basins.
 *
 * @author schema.org
 * @class Landform
 * @module org.schema
 * @extends Place
 */
public class Landform extends Place {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Landform() {
		context = "http://schema.org/";
		type = "Landform";
	}

}