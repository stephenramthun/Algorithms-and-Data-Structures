package com.stephenramthun.algorithms.sorting;

import java.util.Arrays;

/**
 * Implementation of a heap sort algorithm.
 * Builds a heap by rearranging objects in an array so that they conform to the
 * properties of a heap structure, and then sorts the array in ascending order
 * by taking out the smallest object one at a time.
 */

public class Heapsort {

    /**
     * Sorts a given array of integers in ascending order.
     *
     * @param array     Array of integers to sort.
     */
    public static void sort(int[] array) {
        int end = array.length - 1;

        buildHeap(array);

        while (end > 0) {
            Utility.swap(array, end, 0);
            end--;
            siftDown(array, 0, end);
        }
    }

    private static void buildHeap(int[] array) {
        int start = parent(array.length - 1);

        while (start >= 0) {
            siftDown(array, start, array.length - 1);
            start--;
        }
    }

    private static void siftDown(int[] array, int root, int end) {
        while (leftChild(root) <= end) {
            int left  = leftChild(root);
            int right = rightChild(root);
            int swap  = root;

            if (array[left] > array[swap]) {
                swap = left;
            }

            if (right <= end && array[right] > array[swap]) {
                swap = right;
            }

            if (swap != root) {
                Utility.swap(array, root, swap);
                root = swap;
            } else {
                return;
            }
        }
    }

    private static int parent(int index) {
        return (index - 1) / 2;
    }

    private static int leftChild(int index) {
        return 2 * index + 1;
    }

    private static int rightChild(int index) {
        return 2 * index + 2;
    }
}
