package com.stephenramthun.datastructures;

public interface Queue<T extends Comparable> {
    public void add(T value);
    public T peek();
    public T poll();
    public int size();
}
