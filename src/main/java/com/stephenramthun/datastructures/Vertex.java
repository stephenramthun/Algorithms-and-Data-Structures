package com.stephenramthun.datastructures;

import java.util.HashSet;

public class Vertex<V> {
    private V value;
    private HashSet<Vertex> edges;

    public Vertex(V value) {
        this.value = value;
        this.edges = new HashSet<>();
    }

    public void addEdge(Vertex v) {
        edges.add(v);
    }

    public boolean hasEdge(Vertex v) {
        return edges.contains(v);
    }
}
