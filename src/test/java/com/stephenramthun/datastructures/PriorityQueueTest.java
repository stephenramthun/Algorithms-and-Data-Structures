package com.stephenramthun.datastructures;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PriorityQueueTest {

    @Test
    void testInit() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        assertNotNull(queue);

        queue = new PriorityQueue<>(2000);
        assertNotNull(queue);

        int n = 20;
        Integer[] integers = new Integer[n];

        for (int i = 0; i < n; i++) {
            integers[i] = i;
        }

        queue = new PriorityQueue<>(integers);
        assertNotNull(queue);
    }

    @Test
    void testInsert() {
        int expectedSize = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        assertNotNull(queue);
        assertEquals(expectedSize, queue.size());

        queue.insert(10);
        assertEquals(++expectedSize, queue.size());

        queue.insert(20);
        assertEquals(++expectedSize, queue.size());

        queue.insert(150);
        assertEquals(++expectedSize, queue.size());

        queue.insert(-25);
        assertEquals(++expectedSize, queue.size());

        queue.insert(50);
        assertEquals(++expectedSize, queue.size());

        assertEquals(-25, (int)queue.peek());

        queue.insert(-26);
        assertEquals(++expectedSize, queue.size());
        assertEquals(-26, (int)queue.peek());

        queue.insert(Integer.MAX_VALUE);
        assertEquals(++expectedSize, queue.size());
        assertEquals(-26, (int)queue.peek());

    }
}
