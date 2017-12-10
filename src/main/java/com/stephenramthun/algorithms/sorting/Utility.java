package com.stephenramthun.algorithms.sorting;

import java.util.Random;

/*
 * Common operations used in the implementation and testing of various sorting algorithms.
 */

class Utility {

    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static void swap(Comparable[] array, int a, int b) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static int[] randomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n);
        }

        return array;
    }

    static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            @SuppressWarnings("unchecked")
            int comparison = array[i].compareTo(array[i + 1]);

            if (comparison > 0) {
                return false;
            }
        }

        return true;
    }

    // Assumes non-negative values
    static boolean arePermutations(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        int[] count;
        int diff;
        int max = 0;

        // Find max value in both a and b
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) max = a[i];
            if (b[i] > max) max = b[i];
        }

        count = new int[max + 1];

        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }

        for (int i = 0; i < b.length; i++) {
            count[b[i]]--;
        }

        for (int i : count) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }

    static int[] copy(int[] a) {
        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        return b;
    }
}
