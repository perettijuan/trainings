package com.tree.main;

public class IntegerValue implements Comparable<IntegerValue> {

	private int mValue;

	public IntegerValue(int value) {
		mValue = value;
	}

	public int getValue() {
		return mValue;
	}

	@Override
	public int compareTo(IntegerValue another) {
		if (mValue == another.mValue) {
			return 0;
		} else if (mValue > another.mValue) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(mValue);
	}
	
	

}
