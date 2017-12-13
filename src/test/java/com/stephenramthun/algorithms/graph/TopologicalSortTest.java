package com.stephenramthun.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.stephenramthun.datastructures.Graph;
import com.stephenramthun.datastructures.LinkedList;
import com.stephenramthun.datastructures.Vertex;

class TopologicalSortTest {

    @Test
    void testTopSort() {
        int n = 8;
        Integer[] values = new Integer[n];

        for (int i = 0; i < n; i++) {
            values[i] = i + 1;
        }

        Graph<Integer> graph = new Graph<Integer>(values);
        graph.setDirected(true);
        graph.addEdge(1, 5);
        graph.addEdge(1, 2);
        graph.addEdge(5, 2);
        graph.addEdge(2, 6);
        graph.addEdge(2, 7);
        graph.addEdge(2, 3);
        graph.addEdge(3, 8);
        graph.addEdge(3, 4);

        // Should be cycle free, e.g. possible to make topological ordering.
        LinkedList<Vertex> topSort = TopologicalSort.sort(graph);
        assertNotNull(topSort);
        assertEquals(topSort.size(), graph.size());

        // Adding cycle.
        graph.addEdge(5, 1);
        topSort = TopologicalSort.sort(graph);
        assertNull(topSort);
    }
}
