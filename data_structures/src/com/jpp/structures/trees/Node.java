package com.jpp.structures.trees;

/**
 * A node for a binary search tree.
 * 
 * @author Juan Peretti
 * 
 * @param <T>
 *            - the data type that the node will hold.
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {


    private T mData;
    private Node<T> mLeft;
    private Node<T> mRight;

    public Node(Node<T> left, Node<T> right, T data) {
        mLeft = left;
        mRight = right;
        mData = data;
    }

    Node<T> left() {
        return mLeft;
    }

    Node<T> right() {
        return mRight;
    }

    void setLeft(Node<T> left) {
        mLeft = left;
    }

    void setRight(Node<T> right) {
        mRight = right;
    }

    public T data() {
        return mData;
    }

    @Override
    public String toString() {
        String returnValue = "Value: " + mData.toString();
        if (mLeft != null) {
            returnValue += " LEFT -> " + mLeft.data().toString();
        }
        if (mRight != null) {
            returnValue += " RIGHT -> " + mRight.data().toString();
        }
        return returnValue;
    }

    @Override
    public int compareTo(Node<T> o) {
        return mData.compareTo(o.data());
    }

}
