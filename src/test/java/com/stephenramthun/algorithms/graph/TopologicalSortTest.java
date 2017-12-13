package com.stephenramthun.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TopologicalSortTest {

    @Test
    void testTopSort() {
        int n = 10;
        int expectedSize = n;
        Integer[] values = new Integer[n];

        for (int i = 0; i < n; i++) {
            values[i] = i;
        }

        Graph<Integer> graph = new Graph<Integer>(values);
    }
}
