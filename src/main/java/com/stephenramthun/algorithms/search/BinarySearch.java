package com.stephenramthun.algorithms.search;

/**
 * Implementation of a binary search algorithm for sorted arrays.
 *
 * @author Stephen Ramthun
 */

public class BinarySearch {

    /**
     * Checks whether a given key exists in a sorted array.
     *
     * @param array     Array to search for key in. Assumed sorted.
     * @param key       Key to search for in aray.
     * @return          True if key is in array.
     */
    public static boolean contains(int[] array, int key) {
        int left  = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] > key) {
                right = mid - 1;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean contains(Comparable[] array, Comparable key) {
        int left  = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            @SuppressWarnings("unchecked")
            int comparison = array[mid].compareTo(key);

            if (comparison > 0) {
                right = mid - 1;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
