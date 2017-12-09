package com.stephenramthun.algorithms.sorting;

public class Shellsort {

    /**
     * Sorts a given array of integers in ascending order.
     *
     * @param array     Array of integers to sort.
     */
    public static void sort(int[] array) {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        for (int gap : gaps) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;

                for (j = i; j >= gap && array[j - gap] > temp; j-= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = temp;
            }
        }
    }
}
