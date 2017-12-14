package com.stephenramthun.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void testAdd() {
        int expectedSize = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        assertNotNull(queue);
        assertEquals(expectedSize, queue.size());

        queue.add(10);
        assertEquals(++expectedSize, queue.size());

        queue.add(20);
        assertEquals(++expectedSize, queue.size());

        queue.add(150);
        assertEquals(++expectedSize, queue.size());

        queue.add(-25);
        assertEquals(++expectedSize, queue.size());

        queue.add(50);
        assertEquals(++expectedSize, queue.size());

        assertEquals(-25, (int)queue.peek());

        queue.add(-26);
        assertEquals(++expectedSize, queue.size());
        assertEquals(-26, (int)queue.peek());

        queue.add(Integer.MAX_VALUE);
        assertEquals(++expectedSize, queue.size());
        assertEquals(-26, (int)queue.peek());
    }

    @Test
    void testPoll() {
        int n = 50;
        int expectedSize = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        assertNotNull(queue);
        assertEquals(expectedSize, queue.size());

        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        expectedSize = n;
        assertEquals(expectedSize, queue.size());

        for (int i = 0; i < n; i++) {
            int value = queue.poll();
            assertEquals(value, i);
            assertEquals(--expectedSize, queue.size());
        }
    }
}
