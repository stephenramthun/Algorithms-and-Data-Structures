package com.stephenramthun.datastructures;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void testInit() {
        int value;
        int n = 10;
        int expectedSize = 0;
        Graph<Integer> graph = new Graph<>(n);

        assertEquals(expectedSize, graph.size());

        Integer[] values = new Integer[n];

        for (int i = 0; i < n; i++) {
            values[i] = i;
        }

        graph = new Graph<Integer>(values);
        expectedSize = n;

        assertEquals(expectedSize, graph.size());

        for (int i = 0; i < n; i++) {
            assertTrue(graph.contains(i));
        }
    }

    @Test
    void testAddVertex() {
        int value;
        int n = 10;
        int expectedSize = 0;
        Graph<Integer> graph = new Graph<>(n);

        assertEquals(expectedSize, graph.size());

        value = 10;
        expectedSize++;
        graph.add(value);
        assertEquals(expectedSize, graph.size());
        assertTrue(graph.contains(value));

        value = 11;
        expectedSize++;
        graph.add(value);
        assertEquals(expectedSize, graph.size());
        assertTrue(graph.contains(value));

        value = 110;
        expectedSize++;
        graph.add(value);
        assertEquals(expectedSize, graph.size());
        assertTrue(graph.contains(value));

        value = 111;
        expectedSize++;
        graph.add(value);
        assertEquals(expectedSize, graph.size());
        assertTrue(graph.contains(value));

        assertFalse(graph.contains(-1));
        assertFalse(graph.contains(292929));
        assertFalse(graph.contains(0));
        assertFalse(graph.contains(Integer.MAX_VALUE));
    }

    @Test
    void testAddEdge() {
        int n = 10;
        int expectedSize = n;
        Integer[] values = new Integer[n];

        for (int i = 0; i < n; i++) {
            values[i] = i;
        }

        Graph<Integer> graph = new Graph<Integer>(values);
        assertEquals(expectedSize, graph.size());

        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(4, 5);
        graph.addEdge(3, 3);
        graph.addEdge(8, 4);
        graph.addEdge(9, 2);
        graph.addEdge(1, 7);
        graph.addEdge(6, 5);

        assertTrue(graph.hasEdge(1, 2));
        assertTrue(graph.hasEdge(2, 1));
        assertTrue(graph.hasEdge(4, 5));
        assertTrue(graph.hasEdge(5, 4));
        assertTrue(graph.hasEdge(3, 3));
        assertTrue(graph.hasEdge(8, 4));
        assertTrue(graph.hasEdge(4, 8));
        assertTrue(graph.hasEdge(9, 2));
        assertTrue(graph.hasEdge(2, 9));
        assertTrue(graph.hasEdge(1, 7));
        assertTrue(graph.hasEdge(7, 1));
        assertTrue(graph.hasEdge(6, 5));
        assertTrue(graph.hasEdge(5, 6));

        graph = new Graph<Integer>(values);
        graph.setDirected(true);

        graph.addEdge(1, 2);
        graph.addEdge(4, 5);
        graph.addEdge(3, 3);
        graph.addEdge(8, 4);
        graph.addEdge(9, 2);
        graph.addEdge(1, 7);
        graph.addEdge(6, 5);

        assertTrue(graph.hasEdge(1, 2));
        assertFalse(graph.hasEdge(2, 1));
        assertTrue(graph.hasEdge(4, 5));
        assertFalse(graph.hasEdge(5, 4));
        assertTrue(graph.hasEdge(3, 3));
        assertTrue(graph.hasEdge(8, 4));
        assertFalse(graph.hasEdge(4, 8));
        assertTrue(graph.hasEdge(9, 2));
        assertFalse(graph.hasEdge(2, 9));
        assertTrue(graph.hasEdge(1, 7));
        assertFalse(graph.hasEdge(7, 1));
        assertTrue(graph.hasEdge(6, 5));
        assertFalse(graph.hasEdge(5, 6));
    }

    @Test
    void testRemoval() {
        int n = 10;
        int expectedSize = n;
        Integer[] values = new Integer[n];

        for (int i = 0; i < n; i++) {
            values[i] = i;
        }

        Graph<Integer> graph = new Graph<Integer>(values);
        assertEquals(expectedSize, graph.size());

        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(4, 5);
        graph.addEdge(3, 3);
        graph.addEdge(8, 4);
        graph.addEdge(9, 2);
        graph.addEdge(1, 7);
        graph.addEdge(6, 5);

        // Remove edges
        graph.removeEdge(1, 2);
        graph.removeEdge(4, 5);
        graph.removeEdge(3, 3);
        graph.removeEdge(8, 4);
        graph.removeEdge(9, 2);
        graph.removeEdge(1, 7);
        graph.removeEdge(6, 5);

        assertFalse(graph.hasEdge(1, 2));
        assertFalse(graph.hasEdge(4, 5));
        assertFalse(graph.hasEdge(3, 3));
        assertFalse(graph.hasEdge(8, 4));
        assertFalse(graph.hasEdge(9, 2));
        assertFalse(graph.hasEdge(1, 7));
        assertFalse(graph.hasEdge(6, 5));

        // Remove vertices
        for (int i = 0; i < n; i++) {
            graph.remove(i);
            assertEquals(--expectedSize, graph.size());
            assertFalse(graph.contains(i));
        }

        assertEquals(0, graph.size());
    }
}
