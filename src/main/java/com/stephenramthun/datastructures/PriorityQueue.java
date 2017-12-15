package com.stephenramthun.datastructures;

/**
 * Implementation of a priority queue data structure based on a binary heap.
 * Elements in the priority queue are dequeued based on their natural order
 * ascending, from lowest to highest. A lower natural ordering implies a higher
 * priority.
 *
 * @author Stephen Ramthun
 */

public class PriorityQueue<T extends Comparable> implements Queue {

    private final int DEFAULT_SIZE      = 30;
    private final double EXPANSION_RATE = 0.5;

    private Comparable[] values;
    private int size;

    public PriorityQueue() {
        this.values = new Comparable[DEFAULT_SIZE];
        this.size = 0;
    }

    public PriorityQueue(int n) {
        this.values = new Comparable[n];
        this.size = n;
    }

    public PriorityQueue(T[] values) {
        this.values = (Comparable[])values;
        this.size = values.length;
        buildHeap();
    }

    /**
     * Returns the element with the highest priority in the queue without
     * removing it.
     * @return  The element with the highest priority.
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            return null;
        }

        return (T)values[0];
    }

    /**
     * Removes and returns the element with the highest priority in the queue.
     * @return  The element with the highest priority.
     */
    @SuppressWarnings("unchecked")
    public T poll() {
        if (size == 0) {
            return null;
        }

        T value = (T)values[0];
        size--;
        swap(0, size);
        values[size] = null;
        buildHeap();

        return value;
     }

    /**
     * Inserts the given value in the priority queue with priority based on the
     * natural ordering of the value inserted compared to the other values in
     * the queue.
     */
    @SuppressWarnings("unchecked")
    public void add(Comparable value) {
        if (size == values.length) {
            expandArraySize();
        }

        values[size] = value;
        int parent = parent(size);
        int child  = size;

        int comparison = values[parent].compareTo(values[child]);

        while (comparison > 0) {
            swap(parent, child);
            child  = parent;
            parent = parent(parent);

            if (parent < 0 || parent == child) {
                break;
            }

            comparison = values[parent].compareTo(values[child]);
        }

        size++;
    }

    /**
     * Returns the number of elements in the queue.
     * @return  The number of elements in the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if queue is empty.
     * @return  True if there are no elements in the queue.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size - 1; i++) {
            sb.append(values[i]);
            sb.append(", ");
        }

        if (size > 0) {
            sb.append(values[size - 1]);
        }

        sb.append("]");
        return sb.toString();
    }

    private void buildHeap() {
        int start = parent(size - 1);

        while (start >= 0) {
            siftDown(start, size - 1);
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

            if (comparison < 0) {
                swap = left;
            }

            if (right <= end) {
                comparison = values[right].compareTo(values[swap]);

                if (comparison < 0) {
                    swap = right;
                }
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

    /*
     * Initializes a new array of size n + n * EXPANSION_RATE, where n is the
     * number of elements currently in the priority queue. Copies the values
     * over from the old to the new array and replaces the old array with the
     * new one.
     */
    private void expandArraySize() {
        int newSize = values.length + (int)(values.length * EXPANSION_RATE);
        Comparable[] array = new Comparable[newSize];

        for (int i = 0; i < values.length; i++) {
            array[i] = values[i];
        }

        values = array;
    }
}
