package com.stephenramthun.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BinarySearchTest {

    @Test
    void testSearch() {
        int[] array = {1, 2, 3, 5, 10, 15, 18, 22, 50, 100, 1000, 4567};

        for (int i = 0; i < array.length; i++) {
            assertNotEquals(-1, BinarySearch.contains(array, array[i]));
        }

        assertEquals(-1, BinarySearch.contains(array, -1));
        assertEquals(-1, BinarySearch.contains(array, 101));

        assertEquals(0, BinarySearch.contains(array, 1));
        assertEquals(5, BinarySearch.contains(array, 15));
        assertEquals(9, BinarySearch.contains(array, 100));
        assertEquals(11, BinarySearch.contains(array, 4567));

        String[] strings = {"Thanos", "Vader", "Darkseid", "Sauron", "Khan"};
        Arrays.sort(strings);

        for (int i = 0; i < strings.length; i++) {
            assertNotEquals(-1, BinarySearch.contains(strings, strings[i]));
        }

        assertEquals(-1, BinarySearch.contains(strings, "Gandalf"));
        assertEquals(-1, BinarySearch.contains(strings, "Starlord"));

        assertEquals(3, BinarySearch.contains(strings, "Thanos"));
        assertEquals(4, BinarySearch.contains(strings, "Vader"));
        assertEquals(0, BinarySearch.contains(strings, "Darkseid"));
        assertEquals(2, BinarySearch.contains(strings, "Sauron"));
        assertEquals(1, BinarySearch.contains(strings, "Khan"));
    }
}
