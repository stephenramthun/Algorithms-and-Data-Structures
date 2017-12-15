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
        assertEquals(++size, tree.size());
        assertTrue(tree.contains(expected));

        expected = 33;
        tree.add(expected);
        assertEquals(++size, tree.size());
        assertTrue(tree.contains(expected));
    }
}
