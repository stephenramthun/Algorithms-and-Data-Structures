package com.stephenramthun.algorithms.sorting;

/**
 * Implementation of bubble sort.
 *
 * @author Stephen Ramthun
 */

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

    /**
     * Sorts a given array of objects in ascending order.
     *
     * @param array     Array of object to sort.
     */
    public static void sort(Comparable[] array) {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < array.length - 1; i++) {
                @SuppressWarnings("unchecked")
                int comparison = array[i].compareTo(array[i + 1]);

                if (comparison > 0) {
                    sorted = false;
                    Utility.swap(array, i, i + 1);
                }
            }
        }
    }
}
