package com.stephenramthun.datastructures;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @Test
    void testAdd() {
        int expected;
        int size = 0;

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        expected = 10;
        tree.add(expected);
        assertEquals(++size, tree.size());
        assertTrue(tree.contains(expected));
        assertFalse(tree.contains(9));
        assertFalse(tree.contains(11));
        assertFalse(tree.contains(-1));

        expected = -1;
        tree.add(expected);
        assertEquals(++size, tree.size());
        assertTrue(tree.contains(expected));

        expected = 20;
        tree.add(expected);
        assertEquals(++size, tree.size());
        assertTrue(tree.contains(expected));

        expected = 20;
        tree.add(expected);
        assertEquals(size, tree.size());
        assertTrue(tree.contains(expected));

        expected = 33;
        tree.add(expected);
        assertEquals(++size, tree.size());
        assertTrue(tree.contains(expected));
    }

    @Test
    void testRemove() {
        int expected;
        int size;

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(10);
        tree.add(7);
        tree.add(12);
        tree.add(11);
        tree.add(15);
        tree.add(1);
        tree.add(0);
        tree.add(3);
        tree.add(8);
        tree.add(9);

        size = 10;
        assertEquals(size, tree.size());

        expected = 0;
        assertTrue(tree.remove(expected));
        assertEquals(--size, tree.size());
        assertFalse(tree.contains(expected));

        expected = 1;
        assertTrue(tree.remove(expected));
        assertEquals(--size, tree.size());
        assertFalse(tree.contains(expected));
        assertTrue(tree.contains(3));

        expected = 12;
        assertTrue(tree.remove(expected));
        assertEquals(--size, tree.size());
        assertFalse(tree.contains(expected));
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(15));
    }
}
