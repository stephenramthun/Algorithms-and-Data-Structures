package com.stephenramthun.datastructures;



public class PriorityQueue<T extends Comparable> {

    private final int DEFAULT_SIZE = 30;
    private Comparable[] values;

    public PriorityQueue() {
        this.values = new Comparable[DEFAULT_SIZE];
    }

    public PriorityQueue(int n) {
        this.values = new Comparable[n];
    }

    public PriorityQueue(T[] values) {
        this.values = (Comparable[])values;
        buildHeap();
    }

    private void buildHeap() {
        int start = parent(values.length - 1);

        while (start >= 0) {
            siftDown(start, values.length - 1);
            start--;
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDown(int root, int end) {
        while (leftChild(root) <= end) {
            int left  = leftChild(root);
            int right = rightChild(root);
            int swap  = root;

            int comparison = values[left].compareTo(values[swap]);

            if (comparison > 0) {
                swap = left;
            }

            comparison = values[right].compareTo(values[swap]);

            if (right <= end && comparison > 0) {
                swap = right;
            }

            if (swap != root) {
                swap(root, swap);
                root = swap;
            } else {
                return;
            }
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int a, int b) {
        Comparable temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }
}
