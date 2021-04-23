package com.sorting.core;

import java.util.Comparator;

public class CallCountingComparator<E> implements Comparator<E> {


    private final Comparator<E> mComparator;
    private int mCallCount;

    public CallCountingComparator(Comparator<E> comparator) {
        mComparator = comparator;
        mCallCount = 0;
    }

    @Override
    public int compare(E o1, E o2) {
        mCallCount++;
        return mComparator.compare(o1, o2);
    }

    public int getCallCount() {
        return mCallCount;
    }

}
