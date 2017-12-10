package com.stephenramthun.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BinarySearchTest {

    @Test
    void testSearch() {
        int[] array = {1, 2, 3, 5, 10, 15, 18, 22, 50, 100, 1000, 4567};

        for (int i = 0; i < array.length; i++) {
            assertTrue(BinarySearch.contains(array, array[i]));
        }

        assertFalse(BinarySearch.contains(array, -1));
        assertFalse(BinarySearch.contains(array, 101));

        String[] strings = {"Thanos", "Vader", "Darkseid", "Sauron", "Khan"};
        Arrays.sort(strings);

        for (int i = 0; i < strings.length; i++) {
            assertTrue(BinarySearch.contains(strings, strings[i]));
        }

        assertFalse(BinarySearch.contains(strings, "Gandalf"));
        assertFalse(BinarySearch.contains(strings, "Starlord"));
    }
}
