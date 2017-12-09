package com.stephenramthun.algorithms.sorting;

public class RadixSort {

    private static final int DIGIT_SIZE = 6;

    public static void sort(int[] array) {
        sort(array, 0, array.length);
    }

    private static void sort(int[] array, int left, int right) {
        int mask    = (1 << DIGIT_SIZE) - 1;
        int[] count = new int[mask + 1];

        
    }
}
