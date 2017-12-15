package com.stephenramthun.datastructures;

public class BinarySearchTree<T extends Comparable> implements Collection {

    Node root;
    int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Adds a value to the tree.
     * @param value     Value to add to the tree.
     */
    @SuppressWarnings("unchecked")
    public void add(T value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.add(value);
        }

        size++;
    }

    /**
     * Checks if a value exists in the tree.
     * @param value     Value to check if exists in tree.
     */
    @SuppressWarnings("unchecked")
    public boolean contains(T value) {
        if (root == null) {
            return false;
        }

        return root.find(value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node<T extends Comparable> {
        T value;
        Node left;
        Node right;
        ArrayList<T> equals;

        Node(T value) {
            this.value  = value;
            this.left   = null;
            this.right  = null;
            this.equals = new ArrayList<>();
        }

        @SuppressWarnings("unchecked")
        void add(T value) {
            int comparison = this.value.compareTo(value);

            if (comparison > 0) {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.add(value);
                }
            } else if (comparison < 0) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.add(value);
                }
            } else {
                equals.add(value);
            }
        }

        @SuppressWarnings("unchecked")
        boolean find(T value) {
            int comparison = this.value.compareTo(value);

            if (comparison > 0) {
                if (right == null) {
                    return false;
                }

                return right.find(value);

            } else if (comparison < 0) {
                if (left == null) {
                    return false;
                }

                return left.find(value);

            } else {
                if (this.value == value) {
                    return true;
                }

                for (T equal : equals) {
                    if (equal == value) {
                        return true;
                    }
                }

                return false;
            }
        }
    }
}
