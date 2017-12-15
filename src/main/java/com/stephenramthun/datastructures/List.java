package com.stephenramthun.datastructures;

public interface List<T extends Comparable> {

    /**
     * Adds an element to the List.
     * @param element     Element to add to the List.
     */
    public void add(T element);
}
