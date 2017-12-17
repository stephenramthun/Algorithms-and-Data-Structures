/*
 * Copyright 2017 Stephen Andrew Ramthun
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.stephenramthun.datastructures;

import java.util.function.Consumer;
import java.util.ArrayList;

/**
 * Implementation of a Binary Red Black Tree with key-value pairs.
 * For detailed explanation of how the tree is balanced, read more <a href="https://en.wikipedia.org/wiki/Red–black_tree">here</a>
 *
 * @author Stephen Ramthun
 */

public class RedBlackTree<K extends Comparable <? super K>, V> implements Collection {

  private static final boolean RED   = true;
  private static final boolean BLACK = false;

  private Node root;
  private int size;

  public RedBlackTree() {
      this.root = null;
      this.size = 0;
  }

  /**
   * Searches for and retrieves a value based on given key.
   * @param key   Key used for searching tree.
   * @return      Value associated with key if present in tree.
   *              Otherwise returns null.
   */
  public V search(K key) {
    Node node = search(key, root);
    return node != null ? node.value : null;
  }

  private Node search(K key, Node currentNode) {
    if (currentNode == null) {
      return null;
    }

    int comparison = key.compareTo(currentNode.key);
    if (comparison > 0) {
      return search(key, currentNode.right);
    } else if (comparison < 0){
      return search(key, currentNode.left);
    }

    return currentNode;
  }

  /**
   * Adds given object in the tree.
   * @param key     key to add for value in tree.
   * @param value   value to add in tree.
   * @return        true if object was added, false if
   *                object is already present in tree.
   */
  public boolean add(K key, V value) {
    if (root == null) {
      root = new Node(key, value);
      root.color = BLACK;
      size++;
      return true;
    }

    Node addedNode = add(key, value, root);
    size = addedNode != null ? size + 1 : size;
    return addedNode != null;
  }

  private Node add(K key, V value, Node node) {
    int comparison = key.compareTo(node.key);

    if (comparison > 0) {

      if (node.right == null) {
        node.right = new Node(key, value);
        node.right.parent = node;
        addCheck(node.right);
        return node;
      }

      return add(key, value, node.right);
    }

    if (comparison < 0) {

      if (node.left == null) {
        node.left = new Node(key, value);
        node.left.parent = node;
        addCheck(node.left);
        return node;
      }

      return add(key, value, node.left);
    }

    return null;
  }

  /**
   * Searches for and removes a value in the tree
   * based on given key.
   * @param key   key used for searching for value.
   * @return      true if deletion was successful,
   *              false if key is not present in tree.
   */
  public boolean remove(K key) {
    if (root == null) {
      return false;
    }

    boolean removed = remove(key, root);
    size = removed ? size - 1 : size;
    return removed;
  }

  private boolean remove(K key, Node currentNode) {
    Node node = search(key, currentNode);

    if (node == null) {
      return false;
    }

    // Two children.
    if (node.right != null && node.left != null) {
      Node predecessor = maximumPredecessor(node.left);
      node.key   = predecessor.key;
      node.value = predecessor.value;
      return remove(predecessor.key, node.left);
    }

    // At most one child.
    Node child  = node.left != null ? node.left : node.right;
    replaceNode(node, child);

    if (node.color == BLACK) {

      if (child != null && child.color == RED) {
        child.color = BLACK;
      } else {
        removeCheck(child, node.parent);
      }
    }

    return true;
  }

  // Attaches 'child' to parent of 'node'.
  // Pre-req: Node has at most one non-leaf child.
  private void replaceNode(Node node, Node child) {
    if (node.parent == null) {
      root = child;
    } else {
      if (node == node.parent.left) {
        node.parent.left = child;
      } else {
        node.parent.right = child;
      }
    }

    if (child != null) {
      child.parent = node.parent;
    }
  }

  private Node maximumPredecessor(Node currentNode) {
    if (currentNode.right == null) {
      return currentNode;
    }

    return maximumPredecessor(currentNode.right);
  }

  /**
   * Traverses the tree, mapping a given Consumer 'function' to
   * each value in the tree. Traversal happens from left to right,
   * depth first.
   * @param function     Consumer<E> to apply to each value in tree.
   */
  public void map(Consumer<V> function) {
    traverse(root, function);
  }

  /**
   * Builds and returns an ArrayList with values in tree
   * sorted ascending.
   * @return    values in tree sorted ascending.
   */
  public ArrayList<V> toSortedArrayList() {
    ArrayList<V> values = new ArrayList<>();
    map(values::add);
    return values;
  }

  // Helper-method for traversing the tree.
  private void traverse(Node currentNode, Consumer<V> function) {
    if (currentNode == null) {
      return;
    }

    if (currentNode.left != null) {
      traverse(currentNode.left, function);
    }

    // Pass node value as argument to function
    function.accept(currentNode.value);

    if (currentNode.right != null) {
      traverse(currentNode.right, function);
    }
  }

  /**
   * Calculate and return height of tree.
   * @return  height of tree.
   */
  public int height() {
    if (isEmpty() || root.isLeaf()) {
      return 0;
    }
    return height(root);
  }

  private int height(Node node) {
    int left  = node.left  != null ? height(node.left)  : -1;
    int right = node.right != null ? height(node.right) : -1;
    if (left > right) {
      return left + 1;
    } else {
      return right + 1;
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public String toString() {
      return "";
  }

  // Finds depth of given node in tree.
  private int depth(Node node) {
    if (node.parent == null) {
      return 0;
    }

    return 1 + depth(node.parent);
  }

  /*****************
   * NODE ROTATION *
   *****************/

  private void rotateRight(Node node) {
    Node temp = node.left.right;  // Placeholder
    node.left.right = node;       // Set node as child of new top node.

    // Set new parent relations for new top node.
    if (node == root) {
      root = node.left;
    } else if (node == node.parent.right) {
      node.parent.right = node.left;
    } else {
      node.parent.left = node.left;
    }

    node.left.parent = node.parent;
    node.parent      = node.left;
    node.left        = temp;
    if (temp != null) {
      temp.parent = node;
    }
  }

  private void rotateLeft(Node node) {
    Node temp = node.right.left;  // Placeholder
    node.right.left = node;       // Set node as child of new top node.

    // Set new parent relations for new top node.
    if (node == root) {
      root = node.right;
    } else if (node == node.parent.left) {
      node.parent.left = node.right;
    } else {
      node.parent.right = node.right;
    }

    node.right.parent = node.parent;
    node.parent       = node.right;
    node.right        = temp;
    if (temp != null) {
      temp.parent = node;
    }
  }

  /******************
   * TREE-BALANCING *
   ******************/

  // Ensure that node maintains the balance
  // of the Red Black Tree after addion.
  // If parent of node is BLACK, everything
  // is by definition OK.
  private void addCheck(Node node) {
    // Is node root?
    if (node.parent == null) {
      node.color = BLACK;
      return;
    }

    if (node.parent.color == BLACK) {
      return;
    }

    Node uncle       = node.uncle();
    Node grandparent = node.grandparent();

    // Parent is RED and uncle is RED.
    if (uncle != null && uncle.color == RED) {
      uncle.color       = BLACK;
      node.parent.color = BLACK;
      grandparent.color = RED;
      addCheck(grandparent);
      return;
    }

    // Parent is RED and uncle is BLACK (or null)
    node = straightenPath(node, grandparent);
    node.parent.color = BLACK;
    grandparent.color = RED;

    if (node == node.parent.left) {
      rotateRight(grandparent);
    } else {
      rotateLeft(grandparent);
    }
  }

  // Check if the path to grandparent of 'node' contains
  // any curves, or if it is a straight line. If path has
  // curves, rotate grandparent node accordingly.
  private Node straightenPath(Node node, Node grandparent) {
    if (node == node.parent.left && node.parent == grandparent.right) {
      rotateRight(node.parent);
      return node.right;
    } else if (node == node.parent.right && node.parent == grandparent.left) {
      rotateLeft(node.parent);
      return node.left;
    }
    return node;
  }

  private void removeCheck(Node replacement, Node parent) {
    if (parent != null) {
      removeCase1(replacement, parent);
    }
  }

  private void removeCase1(Node replacement, Node parent) {
    Node sibling = replacedSibling(replacement, parent);

    if (sibling != null && sibling.color == RED) {
      sibling.parent.color = RED;
      sibling.color        = BLACK;

      if (sibling == sibling.parent.left) {
        rotateRight(parent);
      } else {
        rotateLeft(parent);
      }
    }

    removeCase2(replacement, parent);
  }

  private void removeCase2(Node replacement, Node parent) {
    Node sibling = replacedSibling(replacement, parent);

    if (sibling != null &&
        sibling.color  == BLACK &&
        (sibling.left  == null || sibling.left.color  == BLACK) &&
        (sibling.right == null || sibling.right.color == BLACK) &&
        parent.color   == BLACK) {
      sibling.color = RED;
      removeCheck(parent.sibling(), parent.parent);
    } else {
      removeCase3(replacement, parent);
    }
  }

  private void removeCase3(Node replacement, Node parent) {
    Node sibling = replacedSibling(replacement, parent);

    if (sibling != null &&
        sibling.color  == BLACK &&
        (sibling.left  == null || sibling.left.color  == BLACK) &&
        (sibling.right == null || sibling.right.color == BLACK) &&
        parent.color   == RED) {
      sibling.color = RED;
      parent.color  = BLACK;
    } else {
      removeCase4(replacement, parent);
    }
  }

  private void removeCase4(Node replacement, Node parent) {
    Node sibling = replacedSibling(replacement, parent);

    if (sibling != null && sibling.color == BLACK) {
      if (sibling == parent.right &&
          (sibling.left  != null && sibling.left.color  == RED) &&
          (sibling.right == null || sibling.right.color == BLACK)) {
        sibling.color      = RED;
        sibling.left.color = BLACK;
        rotateRight(sibling);
      } else if (sibling == parent.left &&
          (sibling.right != null && sibling.right.color == RED) &&
          (sibling.left  == null || sibling.left.color  == BLACK)) {
        sibling.color       = RED;
        sibling.right.color = BLACK;
        rotateLeft(sibling);
      }
    }

    removeCase5(replacement, parent);
  }

  private void removeCase5(Node replacement, Node parent) {
    Node sibling = replacedSibling(replacement, parent);

    if (sibling != null) {
      sibling.color = parent.color;
      parent.color  = BLACK;

      if (sibling == parent.right &&
          sibling.right != null) {
        sibling.right.color = BLACK;
        rotateLeft(parent);
      } else if (sibling == parent.left &&
          sibling.left != null) {
        sibling.left.color = BLACK;
        rotateRight(parent);
      }
    }
  }

  // Helper method for finding siblings of possibly null nodes.
  private Node replacedSibling(Node replacement, Node parent) {
    if (replacement == null) {
      return parent.right != null ? parent.right : parent.left;
    }
    return replacement.sibling();
  }

  private class Node {
    K key;
    V value;
    Node left;
    Node right;
    Node parent;
    boolean color;

    Node(K key, V value) {
      this.key   = key;
      this.value = value;
      this.color = RED;
    }

    boolean isLeaf() {
      return left == null && right == null;
    }

    Node grandparent() {
      return parent != null ? parent.parent : null;
    }

    Node uncle() {
      return parent != null ? parent.sibling() : null;
    }

    Node sibling() {
      if (parent == null) {
        return null;
      }
      return this == parent.right ? parent.left : parent.right;
    }
  }
}
