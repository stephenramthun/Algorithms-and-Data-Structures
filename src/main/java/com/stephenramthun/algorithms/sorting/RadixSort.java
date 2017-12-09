package com.stephenramthun.algorithms.sorting;

/**
 * Least significant digit Radix Sort.
 *
 * @author  Stephen Ramthun
 */

public class RadixSort {

    private static final int DIGIT_SIZE = 6;
    private static final int SORT_THRESHOLD = 50;
    private static final int MASK = (1 << DIGIT_SIZE) - 1;

    /**
     * Sorts a given array of integers in ascending order.
     *
     * @param array     Array of integers to sort.
     */
    public static void sort(int[] array) {
        int max = maxValue(array);

        for (int i = 0; max > 0; i++) {
            int shift = i * DIGIT_SIZE;
            sort(array, shift);
            max = (max >> shift);
        }
    }

    private static void sort(int[] array, int shift) {
        int[] count  = new int[MASK + 1];
        int[] sorted = new int[array.length];

        // Count occurences of digits
        for (int i = 0; i < array.length; i++) {
            count[(array[i] >> shift) & MASK]++;
        }

        int acc = 0;
        int j   = 0;
        for (int i = 0; i < count.length; i++) {
            j = count[i];
            count[i] = acc;
            acc += j;
        }

        for (int i = 0; i < array.length; i++) {
            int digit = (array[i] >> shift) & MASK;
            sorted[count[digit]] = array[i];
            count[digit]++;
        }

        // Copy elements from sorted to a
        for (int i = 0; i < array.length; i++) {
            array[i] = sorted[i];
        }
    }

    private static int maxValue(int[] array) {
        int max = 0;

        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }

        return max;
    }
}
