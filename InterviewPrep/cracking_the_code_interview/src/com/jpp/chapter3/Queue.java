package com.jpp.chapter3;

import com.jpp.chapter2.Node;

public class Queue<T extends Comparable<T>> {

	private Node<T> mTail;
	private Node<T> mRoot;

	public void push(T data) {
		if (mRoot == null) {
			mRoot = new Node<T>(data);
		} else {
			if (mTail == null) {
				mTail = new Node<T>(data);
				mRoot.setNext(mTail);
			} else {
				Node<T> newTail = new Node<T>(data);
				mTail.setNext(newTail);
				mTail = newTail;
			}
		}
	}

	public T pop() {
		if (mRoot == null) {
			return null;
		}

		Node<T> pop = mRoot;
		mRoot = mRoot.next();
		return pop.getData();
	}

}
