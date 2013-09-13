package com.jpp.structures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * An unbalanced binary search tree.
 * 
 * @author Juan Peretti
 * 
 * @param <Value>
 */
public class BinarySearchTree<Value extends Comparable<Value>> {


    private Node<Value> mRoot;

    /**
     * Default constructor
     */
    public BinarySearchTree() {

    }

    /**
     * Constructor with initial value.
     * 
     * @param value
     *            - the value to be at the root of the tree.
     */
    public BinarySearchTree(Value value) {
        mRoot = new Node<Value>(null, null, value);
    }

    /**
     * Inserts a new value into the tree. Note that the insertion does not
     * ensures the balance on the tree.
     * 
     * @param value
     *            - the new value to insert
     * @return - the inserted node.
     */
    public Node<Value> insert(Value value) {
        Node<Value> node = new Node<Value>(null, null, value);
        if (mRoot == null) {
            mRoot = node;
        } else {
            node = insert(mRoot, node);
        }
        return node;
    }

    /**
     * Recursive private function used to insert new elements in the tree.
     * 
     * @param subtree
     *            - the subtree that can contain the new value.
     * @param toInsert
     *            - the node to insert
     * @return - the modified subtree.
     */
    private Node<Value> insert(Node<Value> subtree, Node<Value> toInsert) {
        System.out.println(subtree);
        Value newNodeValue = toInsert.data();
        int comparission = subtree.data().compareTo(newNodeValue);
        if (comparission > 0) {
            if (subtree.left() != null) {
                insert(subtree.left(), toInsert);
            } else {
                subtree.setLeft(toInsert);
            }
        } else if (comparission < 0) {
            if (subtree.right() != null) {
                insert(subtree.right(), toInsert);
            } else {
                subtree.setRight(toInsert);
            }
        } else {
            throw new UnsupportedOperationException("Unable to add an element that already exists.");
        }
        return subtree;
    }

    /**
     * Finds the height of the tree. Note that the height of a tree is equals to
     * the tallest of it's subtrees plus one (the root). The order of this
     * function is O(n), because the function is called once per node in the
     * tree.
     * 
     * @return
     */
    public int height() {
        int height = 0;
        if (mRoot == null) {
            height = 0;
        } else {
            height = 1 + Math.max(height(mRoot.left()), height(mRoot.right()));
        }
        return height;
    }

    /**
     * Recursive method that calculates the height of the tree. The height of a
     * tree is defined by the number of levels between the root and the last of
     * the leafs.
     * 
     * @param subtree
     * @return
     */
    private int height(Node<Value> subtree) {
        if (subtree == null) {
            return 0;
        } else {
            return Math.max(height(subtree.left()), height(subtree.right()));
        }
    }

    /**
     * Iterates over each element in the tree in preorder traversal: first the
     * current node, then the left node and after that the right node.
     * 
     * @return
     */
    public List<Node<Value>> preorderTraversal() {
        List<Node<Value>> result = new ArrayList<Node<Value>>();
        return preorderTraversal(mRoot, result);
    }

    /**
     * Recursive function that iterates over each element in the subtree in
     * preorder.
     * 
     * @param subtree
     * @param result
     * @return
     */
    private List<Node<Value>> preorderTraversal(Node<Value> subtree, List<Node<Value>> result) {
        result.add(subtree);
        if (subtree.left() != null) {
            preorderTraversal(subtree.left(), result);
        }
        if (subtree.right() != null) {
            preorderTraversal(subtree.right(), result);
        }
        return result;
    }

    /**
     * Balances the BST in three steps: 1 - creates a list following this
     * algorithm: from the root of the subtree, take the left subtree and add
     * all the values to the list, then add the current element and finally add
     * all the elements in the right subtree. 2 - Balances the tree from the
     * middle of the list, going to the left first and to the right after.
     */
    public void balance() {
        List<Node<Value>> orderedList = new ArrayList<Node<Value>>();
        fillListInOrder(mRoot, orderedList);
        mRoot = null;
        balanceTree(orderedList, 0, orderedList.size() - 1);
    }

    /**
     * Executes the balancing on the BST. Calls are made recursively first to
     * consume the left half of the list and then to consume the right half
     * 
     * @param list
     * @param min
     * @param max
     */
    private void balanceTree(List<Node<Value>> list, int min, int max) {
        if (min <= max) {
            int midElementIndex = (int) Math.ceil(((double) min + max) / 2);
            Node<Value> midElement = list.get(midElementIndex);
            insert(midElement.data());
            balanceTree(list, min, midElementIndex - 1);
            balanceTree(list, midElementIndex + 1, max);
        }
    }

    /**
     * Fills the {@link List} given as parameter with each element in the tree.
     * 
     * @param subTree
     *            - the subtree elements to add
     * @param orderedList
     *            - the list to append nodes and sort it.
     */
    private void fillListInOrder(Node<Value> subTree, List<Node<Value>> orderedList) {
        if (subTree != null) {
            fillListInOrder(subTree.left(), orderedList);
            orderedList.add(subTree);
            fillListInOrder(subTree.right(), orderedList);
        }
        // Collections.sort(orderedList);
    }

    // Delete
    // Insert
    // Find lowest value
    // Find highest value
}
