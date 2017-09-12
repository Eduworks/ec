package com.eduworks.ec.graph;

/**
 * Object to hold a triple, used in graph.
 *
 * @author fritz.ray@eduworks.com
 * @class Triple
 * @module com.eduworks.ec
 */
public class Triple<S1, S2, S3> {
	/**
	 * Source vertex.
	 *
	 * @property source
	 * @type any
	 */
	public S1 source;
	/**
	 * Destination vertex.
	 *
	 * @property destination
	 * @type any
	 */
	public S2 destination;
	/**
	 * Object to hold in the edge.
	 *
	 * @property edge
	 * @type any
	 */
	public S3 edge;

	/**
	 * Returns true IFF sources, destinations, and edges match.
	 *
	 * @param {Edge} obj
	 * @return {boolean} true IFF <see method definition>
	 * @method equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;
		if (obj instanceof Triple) {
			Triple t = (Triple) obj;
			if (source.equals(t.source) && destination.equals(t.destination) && edge.equals(t.edge))
				return true;
		}
		return false;
	}
}
