package com.stephenramthun.datastructures;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
