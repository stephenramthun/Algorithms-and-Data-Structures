package com.stephenramthun.datastructures;

import java.util.HashMap;
import java.util.Collection;

/**
 * A Vertex helper class for Graph data structures.
 *
 * @author Stephen Ramthun
 */

public class Vertex<V extends Comparable> implements Comparable {
    V value;
    int inDegree;
    HashMap<Vertex, Double> edges;
    double distance;
    Vertex previous;

    public Vertex(V value) {
        this.value    = value;
        this.edges    = new HashMap<>();
        this.inDegree = 0;
        this.distance = 0;
        this.previous = null;
    }

    /**
     * Adds an edge from this Vertex to another.
     * @param v     Vertex to add as an edge.
     */
    public void addEdge(Vertex v, double distance) {
        edges.put(v, distance);
    }

    /**
     * Removes aan edge from this Vertex.
     * @param v     Vertex to remove as an edge.
     */
    public void removeEdge(Vertex v) {
        if (edges.containsKey(v)) {
            edges.remove(v);
        }
    }

    /**
     * Checks if this Vertex has an edge connecting it to a specified Vertex.
     * @param v     Vertex to check if there is an edge to from this one.
     * @return      True if the edge exists.
     */
    public boolean hasEdge(Vertex v) {
        return edges.containsKey(v);
    }

    /**
     * Returns the number of edges pointing to this one.
     * @return  The number of edges pointing to this one.
     */
    public int getInDegree() {
        return inDegree;
    }

    /**
     * Decrements the in-degree of this Vertex. Used in graph algorithms, e.g.
     * finding a topological ordering of the vertices in a graph.
     */
    public void decrementInDegree() {
        inDegree--;
    }

    /**
     * Increments the in-degree of this Vertex. Used in graph algorithms, e.g.
     * finding a topological ordering of the vertices in a graph.
     */
    public void incementInDegree() {
        inDegree++;
    }

    /**
     * Sets the indegree of this Vertex to 0.
     */
    public void resetInDegree() {
        inDegree = 0;
    }

    /**
     * Return the value held by this Vertex.
     * @return  The value held by this Vertex.
     */
    public V getValue() {
        return value;
    }

    /**
     * Returns the map of edges from this Vertex with distances.
     * @return  The map of edges from this Vertex with distances.
     */
    public HashMap<Vertex, Double> getEdges() {
        return edges;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(Object v) {
        Vertex vertex = (Vertex)v;

        if (this.distance < vertex.distance) return -1;
        if (this.distance > vertex.distance) return 1;
        return 0;
    }
}
