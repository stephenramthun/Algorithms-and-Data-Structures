package com.stephenramthun.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.stephenramthun.datastructures.Graph;
import com.stephenramthun.datastructures.Vertex;

class DijkstraTest {

    @Test
    void testRun() {
        int n = 8;
        Integer[] values = new Integer[n];

        for (int i = 0; i < n; i++) {
            values[i] = i + 1;
        }

        Graph<Integer> graph = new Graph<Integer>(values);
        graph.addEdge(1, 5, 5.0);
        graph.addEdge(1, 2, 10.0);
        graph.addEdge(5, 2, 2.0);
        graph.addEdge(2, 6, 3.0);
        graph.addEdge(2, 7, 2.0);
        graph.addEdge(2, 3, 1.0);
        graph.addEdge(3, 8, 4.0);
        graph.addEdge(3, 4, 1.0);
        graph.addEdge(7, 3, 3.0);

        Vertex source = graph.getVertex(1);
        assertNotNull(source);

        Dijkstra.run(graph, source);

        Vertex v = graph.getVertex(1);
        assertEquals(0, v.getDistance());
        assertNull(v.getPrevious());

        v = graph.getVertex(2);
        assertEquals(7, v.getDistance());
        assertEquals(5, (int)v.getPrevious().getValue());

        v = graph.getVertex(3);
        assertEquals(8, v.getDistance());
        assertEquals(2, (int)v.getPrevious().getValue());

        v = graph.getVertex(4);
        assertEquals(9, v.getDistance());
        assertEquals(3, (int)v.getPrevious().getValue());

        v = graph.getVertex(5);
        assertEquals(5, v.getDistance());
        assertEquals(1, (int)v.getPrevious().getValue());

        v = graph.getVertex(6);
        assertEquals(10, v.getDistance());
        assertEquals(2, (int)v.getPrevious().getValue());

        v = graph.getVertex(7);
        assertEquals(9, v.getDistance());
        assertEquals(2, (int)v.getPrevious().getValue());

        v = graph.getVertex(8);
        assertEquals(12, v.getDistance());
        assertEquals(3, (int)v.getPrevious().getValue());
    }
}
