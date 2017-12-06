package com.stephenramthun.algorithms.sorting;

public class BubbleSort {

    /**
     * Sorts a given array of integers in ascending order.
     *
     * @param array     Array of integers to sort.
     */
    public static void sort(int[] array) {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    sorted = false;
                    Utility.swap(array, i, i + 1);
                }
            }
        }
    }
}
