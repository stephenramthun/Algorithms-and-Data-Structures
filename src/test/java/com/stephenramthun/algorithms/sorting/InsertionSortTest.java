package com.stephenramthun.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
