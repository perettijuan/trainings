package com.jpp.training.algorithm.chapter1;

public class ReverseIterator implements Iterator<String> {


    private final Iterator<String> mOriginalIterator;

    public ReverseIterator(Iterator<String> iterator) {
        if (iterator == null) {
            throw new IllegalArgumentException("iterator can not be null");
        }
        mOriginalIterator = iterator;
    }

    @Override
    public void first() {
        mOriginalIterator.last();
    }

    @Override
    public void last() {
        mOriginalIterator.first();
    }

    @Override
    public boolean isDone() {
        return mOriginalIterator.isDone();
    }

    @Override
    public void next() {
        mOriginalIterator.previous();
    }

    @Override
    public void previous() {
        mOriginalIterator.next();
    }

    @Override
    public String current() throws IteratorOutOfBoundsException {
        return mOriginalIterator.current();
    }

}
