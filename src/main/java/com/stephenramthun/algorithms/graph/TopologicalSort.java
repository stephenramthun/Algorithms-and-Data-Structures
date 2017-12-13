package com.stephenramthun.algorithms.graph;

import com.stephenramthun.datastructures.Graph;
import com.stephenramthun.datastructures.Vertex;
import com.stephenramthun.datastructures.LinkedList;

import java.util.Collection;

/**
 * An algorithm for finding a topological ordering of the vertices in a graph.
 * Based on Kahn's Algorithm.
 *
 * @author Stephen Ramthun
 * @see <a href="https://en.wikipedia.org/wiki/Topological_sorting#Kahn.27s_algorithm">Kahn's Algorithm</a>
 */

public class TopologicalSort {

    /**
     * Finds a topological ordering of the vertices in a graph object and
     * returns this as an ordered List.
     * @param graph     The graph to find a topological ordering for.
     * @return          A List of vertices in the graph in topological ordering.
     *                  If no topological ordering is possible, e.g. if there is
     *                  a cycle in the graph, null is returned.
     * @see             LinkedList
     */
    public static LinkedList<Vertex> sort(Graph graph) {
        graph.calculateInDegrees();
        LinkedList<Vertex> work   = new LinkedList<>();
        LinkedList<Vertex> sorted = new LinkedList<>();
        Collection vertices       = graph.getVertices();

        for (Object v : vertices) {
            Vertex vertex = (Vertex)v;
            if (vertex.getInDegree() == 0) {
                work.add(vertex);
            }
        }

        while (!work.isEmpty()) {
            Vertex v = (Vertex)work.removeFirst();
            sorted.add(v);

            for (Object o : v.getEdges()) {
                Vertex edge = (Vertex)o;
                edge.decrementInDegree();

                if (edge.getInDegree() == 0) {
                    work.add(edge);
                }
            }
        }

        if (sorted.size() != vertices.size()) {
            // Graph contains cycle.
            return null;
        }

        return sorted;
    }
}
