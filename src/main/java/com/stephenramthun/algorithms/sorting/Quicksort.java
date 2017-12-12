package com.stephenramthun.algorithms.sorting;

/**
 * Quicksort based on the Hoare partition scheme.
 * Uses insertion sort as a subroutine when subarray to sort is shorter than a specified limit.
 *
 * @author  Stephen Ramthun
 * @see     <a href="https://en.wikipedia.org/wiki/Quicksort#Hoare_partition_scheme">Hoare Partition Scheme</a>
 */

public class Quicksort {

    private static final int LIMIT = 50;

    /**
     * Sorts a given array of integers in ascending order.
     *
     * @param array     Array of integers to sort.
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (right - left > LIMIT) {
            int part = partition(array, left, right);
            sort(array, left, part);
            sort(array, part + 1, right);
        } else {
            InsertionSort.sort(array, left, right + 1);
        }
    }

    private static void sort(Comparable[] array, int left, int right) {
        if (right - left > LIMIT) {
            int part = partition(array, left, right);
            sort(array, left, part);
            sort(array, part + 1, right);
        } else {
            InsertionSort.sort(array, left, right + 1);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i     = left - 1;
        int j     = right + 1;

        while (i < j) {
            do {
                i++;
            } while (array[i] < pivot);

            do {
                j--;
            } while (array[j] > pivot);

            if (i < j) {
                Utility.swap(array, i, j);
            }
        }

        return j;
    }

    @SuppressWarnings("unchecked")
    private static int partition(Comparable[] array, int left, int right) {
        Comparable pivot = array[left];
        int i = left - 1;
        int j = right + 1;

        while (i < j) {
            int comparison = array[i].compareTo(pivot);

            do {
                comparison = array[i].compareTo(pivot);
                i++;
            } while (comparison > 0);

            comparison = array[j].compareTo(pivot);

            do {
                comparison = array[j].compareTo(pivot);
                j--;
            } while (comparison > 0);

            if (i < j) {
                Utility.swap(array, i, j);
            }
        }

        return j;
    }
}
