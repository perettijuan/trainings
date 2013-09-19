package com.jpp.training.algorithm.chapter1;

import java.util.Arrays;

public class ArrayIterator implements Iterator<String> {


    private final String[] mArray;
    private final int mStart;
    private final int mEnd;
    private int mCurrent = -1;

    public ArrayIterator(String[] array, int start, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("length can not be negative");
        }
        if (array == null) {
            throw new IllegalArgumentException("array can not be null");
        }
        if (start <= 0) {
            throw new IllegalArgumentException("start can not be negative");
        }

        if (start > array.length) {
            throw new IllegalArgumentException("start can not be higher that the array's length");
        }

        mArray = Arrays.copyOf(array, array.length);
        mStart = start;
        mEnd = start + length - 1;

        if (mEnd > mArray.length) {
            throw new IllegalArgumentException("start + length can't be > array.length");
        }
    }

    public ArrayIterator(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array can not be null");
        }

        mArray = Arrays.copyOf(array, array.length);
        mStart = 0;
        mEnd = array.length - 1;
    }

    @Override
    public void first() {
        mCurrent = mStart;
    }

    @Override
    public void last() {
        mCurrent = mEnd;
    }

    @Override
    public boolean isDone() {
        return mCurrent < mStart || mCurrent > mEnd;
    }

    @Override
    public void next() {
        ++mCurrent;
    }

    @Override
    public void previous() {
        --mCurrent;
    }

    @Override
    public String current() throws IteratorOutOfBoundsException {
        if (isDone()) {
            throw new IteratorOutOfBoundsException();
        }
        return mArray[mCurrent];
    }

}
