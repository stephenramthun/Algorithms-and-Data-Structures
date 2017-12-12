package com.stephenramthun.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Implementation of a generic Graph data structure.
 * Supports both directed/non-directed and weighted/unweighted graphs.
 *
 * @author Stephen Ramthun
 */

public class Graph<V extends Comparable> {

    private boolean directed;
    private boolean weighted;
    private HashMap<V, Vertex> vertices;

    public Graph(int n) {
        this.vertices = new HashMap<>(n);
        this.directed = false;
        this.weighted = false;
    }

    @SuppressWarnings("unchecked")
    public Graph(V[] values) {
        vertices = new HashMap<>();

        for (V value : values) {
            Vertex v = new Vertex(value);
            vertices.put(value, v);
        }

        this.directed = false;
        this.weighted = false;
    }

    public boolean contains(V value) {
        return vertices.get(value) != null;
    }

    @SuppressWarnings("unchecked")
    public boolean add(V value) {
        if (contains(value)) {
            return false;
        }

        Vertex v = new Vertex(value);
        vertices.put(value, v);
        return true;
    }

    public boolean addEdge(V v1, V v2) {
        if (!contains(v1) || !contains(v2)) {
            return false;
        }

        Vertex vertex1 = vertices.get(v1);
        Vertex vertex2 = vertices.get(v2);

        vertex1.addEdge(vertex2);

        if (!directed) {
            vertex2.addEdge(vertex1);
        }

        return true;
    }

    public boolean hasEdge(V v1, V v2) {
        return false;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public void setWeighted(boolean weighted) {
        this.weighted = weighted;
    }

    public int size() {
        return vertices.size();
    }


    class Vertex<V> {
        V value;
        HashSet<Vertex> edges;

        Vertex(V value) {
            this.value = value;
            this.edges = new HashSet<>();
        }

        void addEdge(Vertex v) {
            edges.add(v);
        }
    }
}
