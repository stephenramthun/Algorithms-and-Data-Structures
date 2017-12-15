package com.stephenramthun.datastructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a generic Graph data structure.
 * Supports both directed/non-directed and weighted/unweighted graphs.
 * The graph is initialized as a non-directed, unweighted graph as default, and
 * does not support vertices with values equal to each other. Each vertex must
 * contain a unique value.
 *
 * @author Stephen Ramthun
 */

public class Graph<V extends Comparable> {

    private boolean directed;
    private boolean weighted;
    private HashMap<V, Vertex> vertices;

    /**
     * Constructs a graph with initial capacity of n.
     * @param n     Initial capacity of the graph.
     */
    public Graph(int n) {
        this.vertices = new HashMap<>(n);
        this.directed = false;
        this.weighted = false;
    }

    /**
     * Constructs a graph with values in given array.
     * @param values    Array of values to use in initialization of graph.
     */
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

    /**
     * Returns a given values corresponding Vertex, if it exists.
     * @param value     Value with corresponding Vertex.
     * @return          Vertex associated with given value, if it exists.
     *                  Returns null if not.
     */
    public Vertex getVertex(V value) {
        if (contains(value)) {
            return vertices.get(value);
        }

        return null;
    }

    /**
     * Checks if graph contains given value.
     * @param value     Value to check that graph contains.
     * @return          True if graph contains the value.
     */
    public boolean contains(V value) {
        return vertices.containsKey(value);
    }

    /**
     * Adds given value to the graph as a vertex.
     * @param value     Value to add to the graph.
     * @return          True if value is not already present in graph.
     */
    @SuppressWarnings("unchecked")
    public boolean add(V value) {
        if (contains(value)) {
            return false;
        }

        Vertex v = new Vertex(value);
        vertices.put(value, v);
        return true;
    }

    /**
     * Removes vertex corresponding to the given value from the graph.
     * @param value     Value of the vertex to remove.
     */
    public void remove(V value) {
        if (!contains(value)) {
            return;
        }

        Vertex vertex = vertices.get(value);

        for (Map.Entry<V, Vertex> pair : vertices.entrySet()) {
            Vertex v = (Vertex)pair.getValue();
            v.removeEdge(vertex);
        }

        vertices.remove(value);
    }

    public boolean addEdge(V v1, V v2) {
        return addEdge(v1, v2, 1.0);
    }

    /**
     * Adds an edge between two vertices in the graph corresponding to the given
     * values. If the graph is undirected the edge is added to both vertices,
     * otherwise the edge is a directed edge from v1 to v2.
     * @param v1    The out-vertex of the edge.
     * @param v2    The in-vertex of the edge.
     * @return      True if both v1 and v2 exists in the graph and we therefore
     *              were able to successfully add the edge.
     */
    public boolean addEdge(V v1, V v2, double distance) {
        if (!contains(v1) || !contains(v2)) {
            return false;
        }

        Vertex vertex1 = vertices.get(v1);
        Vertex vertex2 = vertices.get(v2);

        vertex1.addEdge(vertex2, distance);

        if (!directed) {
            vertex2.addEdge(vertex1, distance);
        }

        return true;
    }

    /**
     * Removes an edge between two vertices if it exists.
     * @param v1    The out-vertex of the edge.
     * @param v2    The in-vertex of the edge.
     */
    public void removeEdge(V v1, V v2) {
        if (!contains(v1) || !contains(v2)) {
            return;
        }

        Vertex vertex1 = vertices.get(v1);
        Vertex vertex2 = vertices.get(v2);

        vertex1.removeEdge(vertex2);

        if (!directed) {
            vertex2.removeEdge(vertex1);
        }
    }

    /**
     * Checks if the graph has an edge between two vertices.
     * @param v1    The out-vertex of the edge.
     * @param v2    The in-vertex of the edge.
     * @return      True if the graph contains an edge between the vertices
     *              corresponding to v1 and v2.
     */
    public boolean hasEdge(V v1, V v2) {
        if (!contains(v1) || !contains(v2)) {
            return false;
        }

        Vertex vertex1 = vertices.get(v1);
        Vertex vertex2 = vertices.get(v2);

        return vertex1.hasEdge(vertex2);
    }

    /**
     * Checks if graph is directed.
     * @return  True if the graph is directed.
     */
    public boolean isDirected() {
        return directed;
    }

    /**
     * Checks if the edges of the graph are weighted.
     * @return  True if the edges are weighted.
     */
    public boolean isWeighted() {
        return weighted;
    }

    /**
     * Decides whether the graph should be directed.
     * @param directed  Flag deciding if the graph should be directed.
     */
    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    /**
     * Decides whether the edges in the graph should be weighted.
     * @param weighted  Flag deciding if the edges in the graph should be
     *                  weighted.
     */
    public void setWeighted(boolean weighted) {
        this.weighted = weighted;
    }

    /**
     * Returns the number of vertices in the graph.
     * @return  The number of vertices in the graph.
     */
    public int size() {
        return vertices.size();
    }

    /**
     * Returns a Collection of the vertices in the graph.
     * @return  A Collection of the vertices in the graph.
     */
    public Collection<Vertex> getVertices() {
        return vertices.values();
    }

    /**
     * Calculates the in-degree for each vertex in the graph. The result is
     * stored in a local variable in each vertex.
     */
    public void calculateInDegrees() {
        Collection vertices = getVertices();

        for (Object o : vertices) {
            Vertex v = (Vertex)o;
            v.resetInDegree();
        }

        for (Object o : vertices) {
            Vertex v = (Vertex)o;

            for (Object e : v.getEdges().keySet()) {
                Vertex edge = (Vertex)e;
                edge.incementInDegree();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Graph with " + size() + " vertices:\n");

        for (Map.Entry<V, Vertex> entry : vertices.entrySet()) {
            Vertex vertex = (Vertex)entry.getValue();
            sb.append("\t" + vertex + "\n");
        }

        return sb.toString();
    }
}
