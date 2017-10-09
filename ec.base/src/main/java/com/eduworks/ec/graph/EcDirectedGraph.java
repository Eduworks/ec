package com.eduworks.ec.graph;

import com.eduworks.ec.array.EcArray;
import org.stjs.javascript.Array;

/**
 * A directed implementation of {{#crossLink "Graph"}}Graph{{/crossLink}}. Edges have types. Two vertices may have many edges between them.
 *
 * @param <V>
 * @param <E>
 * @author fray
 * @class EcDirectedGraph
 * @module com.eduworks.ec
 * @extends Graph
 */
public abstract class EcDirectedGraph<V, E> implements Graph<V, E> {
	Array<Triple<V, V, E>> edges;
	Array<V> verticies;

	@Override
	public Array<E> getEdges() {
		Array<E> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++)
			results.$set(i, edges.$get(i).edge);
		return results;
	}

	@Override
	public Array<V> getVertices() {
		Array<V> results = new Array<>();
		for (int i = 0; i < verticies.$length(); i++)
			results.$set(i, verticies.$get(i));
		return results;
	}

	@Override
	public boolean containsVertex(V vertex) {
		for (int i = 0; i < verticies.$length(); i++)
			if (vertex == verticies.$get(i))
				return true;
		return false;
	}

	@Override
	public boolean containsEdge(E edge) {
		for (int i = 0; i < edges.$length(); i++)
			if (edge == edges.$get(i).edge)
				return true;
		return false;
	}

	@Override
	public int getEdgeCount() {
		return edges.$length();
	}

	@Override
	public int getVertexCount() {
		return verticies.$length();
	}

	@Override
	public Array<V> getNeighbors(V vertex) {
		Array<V> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (vertex == edges.$get(i).source)
				results.push(edges.$get(i).destination);
			else if (vertex == edges.$get(i).destination)
				results.push(edges.$get(i).source);
		}
		EcArray.removeDuplicates(results);
		return results;
	}

	@Override
	public Array<E> getIncidentEdges(V vertex) {
		Array<E> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (vertex == edges.$get(i).source)
				results.push(edges.$get(i).edge);
			else if (vertex == edges.$get(i).destination)
				results.push(edges.$get(i).edge);
		}
		EcArray.removeDuplicates(results);
		return results;
	}

	@Override
	public Array<V> getIncidentVertices(E edge) {
		Array<V> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (edge == edges.$get(i).edge) {
				results.push(edges.$get(i).source);
				results.push(edges.$get(i).destination);
			}
		}
		EcArray.removeDuplicates(results);
		return results;
	}

	@Override
	public E findEdge(V v1, V v2) {
		for (int i = 0; i < edges.$length(); i++) {
			if (v1 == edges.$get(i).source && v2 == edges.$get(i).destination)
				return edges.$get(i).edge;
			if (v1 == edges.$get(i).destination && v2 == edges.$get(i).source)
				return edges.$get(i).edge;
		}
		return null;
	}

	@Override
	public Array<E> findEdgeSet(V v1, V v2) {
		Array<E> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (v1 == edges.$get(i).source && v2 == edges.$get(i).destination)
				results.push(edges.$get(i).edge);
			if (v1 == edges.$get(i).destination && v2 == edges.$get(i).source)
				results.push(edges.$get(i).edge);
		}
		return results;
	}

	@Override
	public boolean addVertex(V vertex) {
		if (verticies.indexOf(vertex) != -1)
			return false;
		verticies.push(vertex);
		return true;
	}

	@Override
	public boolean removeVertex(V vertex) {
		int indexOf = verticies.indexOf(vertex);
		if (indexOf != -1) {
			for (int i = 0; i < edges.$length(); i++) {
				if (edges.$get(i).source == vertex || edges.$get(i).destination == vertex) {
					edges.splice(i, 1);
					i--;
				}
			}
			verticies.splice(indexOf, 1);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEdge(E edge) {
		boolean success = false;
		for (int i = 0; i < edges.$length(); i++) {
			if (edges.$get(i).edge==edge) {
				edges.splice(i, 1);
				i--;
				success = true;
			}
		}
		return success;
	}

	@Override
	public boolean isNeighbor(V v1, V v2) {
		for (int i = 0; i < edges.$length(); i++) {
			if (v1==edges.$get(i).source && v2==edges.$get(i).destination)
				return true;
			else if (v1==edges.$get(i).destination && v2==edges.$get(i).source)
				return true;
		}
		return false;
	}

	@Override
	public boolean isIncident(V vertex, E edge) {
		for (int i = 0; i < edges.$length(); i++) {
			if ((vertex==edges.$get(i).source || vertex==edges.$get(i).destination) && edge==edges.$get(i).edge)
				return true;
		}
		return false;
	}

	@Override
	public int degree(V vertex) {
		int count = 0;
		for (int i = 0; i < edges.$length(); i++) {
			if (vertex==edges.$get(i).source || vertex==edges.$get(i).destination)
				count++;
		}
		return count;
	}

	@Override
	public int getNeighborCount(V vertex) {
		return getNeighbors(vertex).$length();
	}

	@Override
	public int getIncidentCount(E edge) {
		return getIncidentVertices(edge).$length();
	}

	@Override
	public abstract String getEdgeType(E edge);

	@Override
	public abstract String getDefaultEdgeType();

	@Override
	public Array<E> getEdgesOfType(String edge_type) {
		Array<E> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (getEdgeType(edges.$get(i).edge) == edge_type)
				results.push(edges.$get(i).edge);
		}
		return results;
	}

	@Override
	public int getEdgeCountOfType(String edge_type) {
		return getEdgesOfType(edge_type).$length();
	}

	@Override
	public Array<E> getInEdges(V vertex) {
		Array<E> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (vertex==edges.$get(i).destination)
				results.push(edges.$get(i).edge);
		}
		EcArray.removeDuplicates(results);
		return results;
	}

	@Override
	public Array<E> getOutEdges(V vertex) {
		Array<E> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (vertex==edges.$get(i).source)
				results.push(edges.$get(i).edge);
		}
		EcArray.removeDuplicates(results);
		return results;
	}

	@Override
	public int inDegree(V vertex) {
		return getInEdges(vertex).$length();
	}

	@Override
	public int outDegree(V vertex) {
		return getOutEdges(vertex).$length();
	}

	@Override
	public V getSource(E directed_edge) {
		for (int i = 0; i < edges.$length(); i++) {
			if (directed_edge==edges.$get(i).edge)
				return edges.$get(i).source;
		}
		return null;
	}

	@Override
	public V getDest(E directed_edge) {
		for (int i = 0; i < edges.$length(); i++) {
			if (directed_edge==edges.$get(i).edge)
				return edges.$get(i).destination;
		}
		return null;
	}

	@Override
	public Array<V> getPredecessors(V vertex) {
		Array<V> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (vertex==edges.$get(i).destination)
				results.push(edges.$get(i).source);
		}
		EcArray.removeDuplicates(results);
		return results;
	}

	@Override
	public Array<V> getSuccessors(V vertex) {
		Array<V> results = new Array<>();
		for (int i = 0; i < edges.$length(); i++) {
			if (vertex==edges.$get(i).source)
				results.push(edges.$get(i).destination);
		}
		EcArray.removeDuplicates(results);
		return results;
	}

	@Override
	public boolean isPredecessor(V v1, V v2) {
		for (int i = 0; i < edges.$length(); i++) {
			if (v1==edges.$get(i).destination)
				if (v2==edges.$get(i).source)
					return true;
		}
		return false;
	}

	@Override
	public boolean isSuccessor(V v1, V v2) {
		for (int i = 0; i < edges.$length(); i++) {
			if (v2==edges.$get(i).destination)
				if (v1==edges.$get(i).source)
					return true;
		}
		return false;
	}

	@Override
	public int getPredecessorCount(V vertex) {
		return getPredecessors(vertex).$length();
	}

	@Override
	public int getSuccessorCount(V vertex) {
		return getSuccessors(vertex).$length();
	}

	@Override
	public boolean isSource(V vertex, E edge) {
		for (int i = 0; i < edges.$length(); i++) {
			if (edge==edges.$get(i).edge)
				if (vertex==edges.$get(i).source)
					return true;
		}
		return false;
	}

	@Override
	public boolean isDest(V vertex, E edge) {
		for (int i = 0; i < edges.$length(); i++) {
			if (edge==edges.$get(i).edge)
				if (vertex==edges.$get(i).destination)
					return true;
		}
		return false;
	}

	@Override
	public boolean addEdge(E e, V v1, V v2) {
		addVertex(v1);
		addVertex(v2);

		Triple<V, V, E> t = new Triple<>();
		t.source = v1;
		t.destination = v2;
		t.edge = e;

		if (edges.indexOf(t) != -1)
			return false;

		edges.push(t);
		return true;
	}

	@Override
	public V getOpposite(V vertex, E edge) {
		for (int i = 0; i < edges.$length(); i++) {
			if (edge==edges.$get(i).edge)
				if (vertex==edges.$get(i).destination)
					return edges.$get(i).source;
				else if (vertex==edges.$get(i).source)
					return edges.$get(i).destination;
		}
		return null;
	}

}
