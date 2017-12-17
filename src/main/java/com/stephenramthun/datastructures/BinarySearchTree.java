package com.stephenramthun.datastructures;

/**
 * Implementation of a non-balancing binary search tree structure. Attempting
 * to insert multiple values that are equal to each other according to their
 * natural order will not be successful, as this implementation does not
 * support multiple values that are equal to each other.
 *
 * @author Stephen Ramthun
 */

public class BinarySearchTree<T extends Comparable> implements Collection {

    Node root;
    int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Adds a value to the tree as long as the value does not already exist in
     * tree.
     * @param value     Value to add to the tree.
     * @return          True if value was added successfully.
     */
    @SuppressWarnings("unchecked")
    public boolean add(T value) {
        boolean added = false;

        if (root == null) {
            root = new Node(value);
            added = true;
        } else {
            added = root.add(new Node(value));
        }

        if (added) size++;
        return added;
    }

    /**
     * Removes a value from the tree.
     * @param value     Value to remove from the tree.
     * @return          True if removal was successful.
     */
    @SuppressWarnings("unchecked")
    public boolean remove(T value) {
        if (root == null) {
            return false;
        }

        Node previous = root;
        Node current = previous;

        while (current != null) {
            int comparison = current.value.compareTo(value);

            if (comparison < 0) {
                previous = current;
                current = current.right;
            } else if (comparison > 0) {
                previous = current;
                current = current.left;
            } else {
                previous.remove(current);
                size--;
                return true;
            }
        }

        return false;
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

        Node(T value) {
            this.value  = value;
            this.left   = null;
            this.right  = null;
        }

        @SuppressWarnings("unchecked")
        boolean add(Node node) {
            int comparison = this.value.compareTo(node.value);

            if (comparison < 0) {

                if (right == null) {
                    right = node;
                    return true;
                }

                return right.add(node);

            } else if (comparison > 0) {

                if (left == null) {
                    left = node;
                    return true;
                }

                return left.add(node);
            }

            return false;
        }

        /*
         * Recursively finds the node to remove, identifies its children if
         * any, and replaces it with an appropriate node if necessary.
         */
        @SuppressWarnings("unchecked")
        void remove(Node node) {

            if (node.isLeaf()) {

                if (node == root) {
                    root = null;
                } else if (node == left) {
                    left = null;
                } else {
                    right = null;
                }

            } else if (node.right == null && node.left != null) {

                if (node == left) {

                    if (node == root) {
                        root = node.left;
                    } else {
                        left = node.left;
                    }

                } else {

                    if (node == root) {
                        root = node.left;
                    } else {
                        right = node.left;
                    }
                }

            } else if (node.right != null && node.left == null) {

                if (node == left) {

                    if (node == root) {
                        root = node.right;
                    } else {
                        left = node.right;
                    }

                } else {

                    if (node == root) {
                        root = node.right;
                    } else {
                        right = node.right;
                    }
                }

            } else {
                Node successor = node.successor();
                T temp = (T)node.value;
                node.value = successor.value;
                successor.value = temp;
                node.remove(successor);
            }
        }

        /*
         * Finds the successor node of this Node, which is the smallest node
         * according to their natural ordering in the right subtree of this
         * Node.
         */
        Node successor() {
            Node current = right;

            while (current != null && current.left != null) {
                current = current.left;
            }

            return current;
        }

        /*
         * Finds the predecessor node of this Node, which is the largest node
         * according to their natural ordering in the left subtree of this
         * Node.
         */
        Node predecessor() {
            Node current = left;

            while (current != null) {
                current = current.right;
            }

            return current;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        /*
         * Finds a Node with a value if it exists. Returns a boolean value
         * indicating the existence of the Node.
         */
        @SuppressWarnings("unchecked")
        boolean find(T value) {
            int comparison = this.value.compareTo(value);

            if (comparison < 0) {

                if (right == null) {
                    return false;
                }

                return right.find(value);

            } else if (comparison > 0) {

                if (left == null) {
                    return false;
                }

                return left.find(value);

            } else {
                return true;
            }
        }
    }
}
