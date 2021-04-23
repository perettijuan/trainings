package com.jpp.chapter3;

import java.util.ArrayList;

public class MultiStack<T extends Comparable<T>> {

	private static final int TRESHOLD = 4;

	private ArrayList<Stack<T>> mStackArray;
	private int mCount;
	private int mTresHold;
	private int mCurrentIndex;

	public MultiStack(int tresHold) {
		if (tresHold == 0) {
			mTresHold = TRESHOLD;
		} else {
			mTresHold = tresHold;
		}
	}

	public void push(T data) {
		if (mStackArray == null) {
			mStackArray = new ArrayList<Stack<T>>();
			Stack<T> stack = new Stack<T>();
			stack.push(data);
			mStackArray.add(mCurrentIndex, stack);
		} else {
			if (mCount == mTresHold) {
				mCount = 0;
				mCurrentIndex++;
				Stack<T> stack = new Stack<T>();
				stack.push(data);
				mStackArray.add(mCurrentIndex, stack);
			} else {
				Stack<T> currentStack = mStackArray.get(mCurrentIndex);
				currentStack.push(data);
			}
		}
		mCount++;
	}

	public T pop() {
		if (mStackArray == null) {
			return null;
		}

		Stack<T> currentStack = mStackArray.get(mCurrentIndex);
		T data = currentStack.pop();
		if (data == null) {
			mStackArray.remove(mCurrentIndex);
			if(mCurrentIndex > 0) {
				mCurrentIndex--;
				currentStack = mStackArray.get(mCurrentIndex);
				data = currentStack.pop();
			}
		}

		return data;

	}

	public int mStackCount() {
		return mStackArray.size();
	}

}
