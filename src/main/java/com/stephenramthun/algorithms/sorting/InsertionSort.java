package com.stephenramthun.algorithms.sorting;

/**
 * Insertion sort.
 *
 * @author  Stephen Ramthun
 */

public class InsertionSort {

    /**
     * Sorts a given array of integers in ascending order.
     *
     * @param array     Array of integers to sort.
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length);
    }

    static void sort(int[] array, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }
    }

    /**
     * Sorts a given array of objects in ascending order.
     *
     * @param array     Array of objects to sort.
     */
    public static void sort(Comparable[] array) {
        sort(array, 0, array.length);
    }

    @SuppressWarnings("unchecked")
    static void sort(Comparable[] array, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            Comparable temp = array[i];
            int j = i - 1;
            int comparison = array[j].compareTo(temp);

            while (j >= 0 && comparison > 0) {
                array[j + 1] = array[j];
                j--;

                if (j >= 0) {
                    comparison = array[j].compareTo(temp);
                }
            }

            array[j + 1] = temp;
        }
    }
}
