package com.stephenramthun.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

    @Test
    void testSorting() {
        int n = 1000;
        int r = 10;

        for (int i = 0; i < r; i++) {
            int[] array = Utility.randomArray(n);
            InsertionSort.sort(array);
            assertTrue(Utility.isSorted(array));
        }

        String[] strings = {"cbc", "abc", "bbc", "ccd", "ccb", "bbc", "aab"};
        assertFalse(Utility.isSorted(strings));
        InsertionSort.sort(strings);
        assertTrue(Utility.isSorted(strings));
    }

    @Test
    void testPermutation() {
        int n = 1000;
        int r = 10;

        for (int i = 0; i < r; i++) {
            int[] a = Utility.randomArray(n);
            int[] b = Utility.copy(a);

            InsertionSort.sort(a);
            assertTrue(Utility.arePermutations(a, b));
        }
    }
}
