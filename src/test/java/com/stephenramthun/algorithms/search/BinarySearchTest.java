package com.stephenramthun.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void testSearch() {
        int[] array = new int[] {1, 2, 3, 5, 10, 15, 18, 22, 50, 100, 1000, 4567};

        for (int i = 0; i < array.length; i++) {
            assertTrue(BinarySearch.contains(array, array[i]));
        }

        assertFalse(BinarySearch.contains(array, -1));
        assertFalse(BinarySearch.contains(array, 101));
    }
}
