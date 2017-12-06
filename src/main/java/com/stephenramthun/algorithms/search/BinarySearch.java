package com.stephenramthun.algorithms.search;

public class BinarySearch {

    public static boolean contains(int[] array, int key) {
        int left  = 0;
        int right = array.length -1 ;

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
}
