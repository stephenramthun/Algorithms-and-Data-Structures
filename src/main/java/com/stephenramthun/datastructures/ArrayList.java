package com.stephenramthun.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of an Array List data structure.
 *
 * @author Stephen Ramthun
 */

public class ArrayList<T extends Comparable> implements List, Collection, Iterable<T> {

    private final int DEFAULT_SIZE      = 30;
    private final double EXPANSION_RATE = 0.5;

    private Comparable[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Comparable[DEFAULT_SIZE];
        this.size     = 0;
    }

    /**
     * Initializes an ArrayList with initial capacity n.
     * @param n     Initial capacity.
     */
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

    /**
     * Inserts an element at the specified position if possible.
     * @param element   Element to add to the List.
     * @param index     The position in the List where the element should be
     *                  inserted.
     * @return          True if insertion was successful, false if index
     *                  exceeds the current size of the List.
     */
    public boolean insert(Comparable element, int index) {
        if (index >= size || index < 0) {
            return false;
        }

        elements[index] = element;
        return true;
    }

    /**
     * Adds an element to the end of the List.
     * @param element     Element to add to the List.
     */
    @Override
    public void add(Comparable element) {
        if (size >= elements.length) {
            expandArraySize();
        }

        elements[size] = element;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size - 1; i++) {
            sb.append(elements[i]);
            sb.append(", ");
        }

        if (size > 0) {
            sb.append(elements[size - 1]);
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }


    class ArrayListIterator implements Iterator<T> {
        int cursor;

        public ArrayListIterator() {
            this.cursor = 0;
        }

        public boolean hasNext() {
            return this.cursor < ArrayList.this.size;
        }

        @SuppressWarnings("unchecked")
        public T next() {
            if (hasNext()) {
                T value = (T)ArrayList.this.elements[cursor];
                cursor++;
                return value;
            }

            throw new NoSuchElementException();
        }
    }
}
