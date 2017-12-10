package com.stephenramthun.datastructures;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void testInit() {
        LinkedList<Integer> a = new LinkedList<>();

        for (int i = 0; i < 1000; i++) {
            a = new LinkedList<>(100);
        }

        LinkedList<String> b = new LinkedList<>();
        b = new LinkedList<>("list");
        b = new LinkedList<>("of");
        b = new LinkedList<>("strings");
    }

    @Test
    void testAdd() {
        LinkedList<Integer> a = new LinkedList<>();
        int expected;
        int size = 0;

        expected = 100;
        a.add(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, (int)a.getFirst());
        assertEquals(expected, (int)a.getLast());

        expected = -2;
        a.add(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, (int)a.getLast());
        assertNotEquals(expected, (int)a.getFirst());

        expected = 35;
        a.addLast(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, (int)a.getLast());
        assertNotEquals(expected, (int)a.getFirst());

        expected = 22;
        a.addFirst(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, (int)a.getFirst());
        assertNotEquals(expected, (int)a.getLast());
    }

    @Test
    void testRemove() {
        LinkedList<String> a = new LinkedList<>();
        String[] values = {"this", "is", "an", "array", "of", "strings"};
        int size = values.length;
        String expected;
        String removed;

        for (String string: values) {
            a.add(string);
        }

        assertEquals(size, a.size());
        assertEquals(values[0], (String)a.getFirst());
        assertEquals(values[5], (String)a.getLast());

        removed = a.removeLast();
        assertEquals(values[5], removed);
        assertEquals(--size, a.size());
        assertNotEquals(removed, (String)a.getLast());

        removed = a.removeFirst();
        assertEquals(values[0], removed);
        assertEquals(--size, a.size());
        assertNotEquals(removed, (String)a.getFirst());

        removed = a.removeFirst();
        assertEquals(values[1], removed);
        assertEquals(--size, a.size());
        assertNotEquals(removed, (String)a.getFirst());

        removed = a.removeFirst();
        assertEquals(values[2], removed);
        assertEquals(--size, a.size());
        assertNotEquals(removed, (String)a.getFirst());

        removed = a.removeLast();
        assertEquals(values[4], removed);
        assertEquals(--size, a.size());
        assertNotEquals(removed, (String)a.getLast());

        removed = a.removeLast();
        assertEquals(values[3], removed);
        assertEquals(--size, a.size());

        assertNull(a.getFirst());
        assertNull(a.getLast());
        assertNull(a.removeFirst());
        assertNull(a.removeLast());
        assertEquals(0, a.size());
    }
}
