package com.stephenramthun.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HeapsortTest {

    @Test
    void testHeapify() {
        int[] array = {9, 16, 2, 4, 10, 23, 55, 10, 10, 11, 2};
        Heapsort.sort(array);
    }

    @Test
    void testSorting() {
        int n = 1000;
        int r = 10;

        for (int i = 0; i < r; i++) {
            int[] array = Utility.randomArray(n);
            Heapsort.sort(array);
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

            Heapsort.sort(a);
            assertTrue(Utility.arePermutations(a, b));
        }
    }
}
