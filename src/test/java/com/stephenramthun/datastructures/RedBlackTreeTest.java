package com.stephenramthun.datastructures;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RedBlackTreeTest {

    @Test
    void testAdd() {
        int expected;
        int n = 100;
        int size = n;

        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();

        for (int i = 0; i < n; i++) {
            assertTrue(tree.add(i, i));
        }

        assertEquals(size, tree.size());

        for (int i = 0; i < n; i++) {
            Integer result = tree.search(i);
            assertNotNull(result);
            assertEquals(i, (int)result);
        }
    }

    @Test
    void testRemove() {
        int expected;
        int n = 100;
        int size = n;

        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();

        for (int i = 0; i < n; i++) {
            assertTrue(tree.add(i, i));
        }

        assertEquals(size, tree.size());

        for (int i = 0; i < n; i += 3) {
            assertTrue(tree.remove(i));
            assertEquals(--size, tree.size());
            assertNull(tree.search(i));
        }

        for (int i = 0; i < n; i += 2) {
            boolean removed = tree.remove(i);

            if (removed) {
                assertEquals(--size, tree.size());
            }

            assertNull(tree.search(i));
        }
    }
}
