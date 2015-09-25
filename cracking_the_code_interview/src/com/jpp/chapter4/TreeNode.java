package com.jpp.chapter4;

import java.util.List;

public class TreeNode<T extends Comparable<T>> {

	private TreeNode<T> mLeft;
	private TreeNode<T> mRight;
	private T mData;

	public TreeNode(T data) {
		mData = data;
	}

	TreeNode<T> left() {
		return mLeft;
	}

	TreeNode<T> right() {
		return mRight;
	}

	T data() {
		return mData;
	}

	public String toString() {
		return mData.toString();
	}

	public TreeNode<T> insert(T data) {
		int comparission = mData.compareTo(data);
		if (comparission >= 0) {
			if (mLeft == null) {
				mLeft = new TreeNode<T>(data);
			} else {
				mLeft = mLeft.insert(data);
			}
		} else {
			if (mRight == null) {
				mRight = new TreeNode<T>(data);
			} else {
				mRight = mRight.insert(data);
			}
		}
		return this;
	}

	public TreeNode<T> lookUp(T data) {
		int comparission = mData.compareTo(data);
		if (comparission > 0) {
			if (mLeft != null) {
				return mLeft.lookUp(data);
			} else {
				return null;
			}
		} else if (comparission < 0) {
			if (mRight != null) {
				return mRight.lookUp(data);
			} else {
				return null;
			}
		} else {
			return this;
		}
	}

	public void preOrder(List<T> attachTo) {
		attachTo.add(mData);
		if (mLeft != null) {
			mLeft.preOrder(attachTo);
		}
		if (mRight != null) {
			mRight.preOrder(attachTo);
		}

	}
	
	
	public void inOrder(List<T> attachTo) {		
		if (mLeft != null) {
			mLeft.preOrder(attachTo);
		}
		attachTo.add(mData);
		if (mRight != null) {
			mRight.preOrder(attachTo);
		}

	}
	
	
	public void postOrder(List<T> attachTo) {		
		if (mLeft != null) {
			mLeft.preOrder(attachTo);
		}
		if (mRight != null) {
			mRight.preOrder(attachTo);
		}
		attachTo.add(mData);
	}

}
