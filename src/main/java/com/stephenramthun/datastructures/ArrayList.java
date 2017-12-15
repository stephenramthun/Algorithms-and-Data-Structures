package com.stephenramthun.datastructures;

public class ArrayList<T extends Comparable> implements List, Collection {

    private final int DEFAULT_SIZE      = 30;
    private final double EXPANSION_RATE = 0.5;

    private Comparable[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Comparable[DEFAULT_SIZE];
        this.size     = 0;
    }

    public ArrayList(int n) {
        this.elements = new Comparable[n];
        this.size     = 0;
    }

    /**
     * Returns the element at given index without removing it from the List.
     * @param index     Index of element to return.
     * @return          Element at given index if it exists. If index exceeds
     *                  the size of the array, null is returned.
     */
    public Comparable get(int index) {
        if (index >= size) {
            return null;
        }

        return elements[index];
    }

    @Override
    public void add(Comparable value) {
        if (size >= elements.length) {
            expandArraySize();
        }

        elements[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Initializes a new array of size n + n * EXPANSION_RATE, where n is the
     * number of elements currently in the array list. Copies the values
     * over from the old to the new array and replaces the old array with the
     * new one.
     */
    private void expandArraySize() {
        int newSize = elements.length + (int)(elements.length * EXPANSION_RATE);
        Comparable[] array = new Comparable[newSize];

        for (int i = 0; i < elements.length; i++) {
            array[i] = elements[i];
        }

        elements = array;
    }
}
