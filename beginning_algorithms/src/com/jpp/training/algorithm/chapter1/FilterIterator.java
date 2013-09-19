package com.jpp.training.algorithm.chapter1;

public class FilterIterator implements Iterator<String> {


    private final Iterator<String> mIterator;
    private final Predicate<String> mPredicate;

    public FilterIterator(Iterator<String> iterator, Predicate<String> predicate) {
        if (iterator == null) {
            throw new IllegalArgumentException("iterator can not be null");
        }

        if (predicate == null) {
            throw new IllegalArgumentException("predicate can not be null");
        }

        mIterator = iterator;
        mPredicate = predicate;
    }

    @Override
    public void first() {
        mIterator.first();
        filterForwards();
    }

    @Override
    public void last() {
        mIterator.last();
        filterBackwards();
    }

    @Override
    public boolean isDone() {
        return mIterator.isDone();
    }

    @Override
    public void next() {
        mIterator.next();
        filterForwards();
    }

    @Override
    public void previous() {
        mIterator.previous();
        filterBackwards();
    }

    @Override
    public String current() throws IteratorOutOfBoundsException {
        return mIterator.current();
    }

    private void filterForwards() {
        while (!mIterator.isDone() && !mPredicate.evaluate(mIterator.current())) {
            mIterator.next();
        }
    }

    private void filterBackwards() {
        while (!mIterator.isDone() && !mPredicate.evaluate(mIterator.current())) {
            mIterator.previous();
        }
    }
}
