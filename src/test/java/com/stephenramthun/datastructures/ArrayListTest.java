package com.stephenramthun.datastructures;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ArrayListTest {

    @Test
    void testInit() {
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            a = new ArrayList<>(100);
        }

        ArrayList<String> b = new ArrayList<>();
    }

    @Test
    void testAdd() {
        ArrayList<Integer> a = new ArrayList<>();
        int expected;
        int size = 0;

        expected = 100;
        a.add(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, a.get(0));

        expected = 101;
        a.add(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, a.get(1));

        expected = 250;
        a.add(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, a.get(2));

        expected = -50;
        a.add(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, a.get(3));

        expected = Integer.MAX_VALUE;
        a.add(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, a.get(4));

        expected = 0;
        a.add(expected);
        assertEquals(++size, a.size());
        assertEquals(expected, a.get(5));

        assertNotEquals(expected, a.get(0));
        assertNotEquals(expected, a.get(1));
        assertNotEquals(expected, a.get(2));
        assertNotEquals(expected, a.get(3));
        assertNotEquals(expected, a.get(4));
    }

    @Test
    void testInsert() {
        ArrayList<Integer> a = new ArrayList<>();
        int expected;
        int size = 0;
        int n = 100;

        for (int i = 0; i < n; i++) {
            a.add(i);
            assertEquals(++size, a.size());
        }

        for (int i = 0; i < n; i++) {
            a.insert(n - i - 1, i);
            assertEquals(size, a.size());
        }

        for (int i = 0; i < n; i++) {
            assertNotEquals(i, (int)a.get(i));
            assertEquals(n - i - 1, (int)a.get(i));
        }

        assertFalse(a.insert(0, size + 1));
        assertFalse(a.insert(0, size + 100));
        assertFalse(a.insert(0, -1));
    }

    @Test
    void testIterator() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        int count = 0;
        for (Integer i : list) {
            count++;
        }

        assertEquals(count, list.size());
    }
}
