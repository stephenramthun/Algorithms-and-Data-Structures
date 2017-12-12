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
    void testAdd() {
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
}
