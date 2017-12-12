package com.stephenramthun.datastructures;

import java.util.HashSet;

public class Vertex<V extends Comparable> implements Comparable {
    V value;
    HashSet<Vertex> edges;

    public Vertex(V value) {
        this.value = value;
        this.edges = new HashSet<>();
    }

    public void addEdge(Vertex v) {
        edges.add(v);
    }

    public void removeEdge(Vertex v) {
        edges.remove(v);
    }

    public boolean hasEdge(Vertex v) {
        return edges.contains(v);
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(Object v) {
        Vertex vertex = (Vertex)v;
        return this.value.compareTo(vertex.value);
    }
}
