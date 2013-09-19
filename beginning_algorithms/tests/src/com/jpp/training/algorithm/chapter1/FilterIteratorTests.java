package com.jpp.training.algorithm.chapter1;

import static junit.framework.Assert.*;

import org.junit.Test;

public class FilterIteratorTests {


    private static final String[] ARRAY = { "A", "B", "C" };

    private static final class DummyPredicate implements Predicate<String> {


        private final Iterator<String> mIterator;
        private final boolean mResult;

        public DummyPredicate(boolean result, Iterator<String> iterator) {
            mIterator = iterator;
            mResult = result;
            mIterator.first();
        }

        @Override
        public boolean evaluate(String value) {
            mIterator.next();
            return mResult;
        }

    }

    @Test
    public void forwardsIterationIncludesItemsWhenPredicatereturnsTrue() {
        Iterator<String> expectedIterator = new ArrayIterator(ARRAY);
        Iterator<String> underlyingIterator = new ArrayIterator(ARRAY);

        Iterator<String> iterator = new FilterIterator(underlyingIterator, new DummyPredicate(true, expectedIterator));

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[0], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[1], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[2], iterator.current());

        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }

        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

    @Test
    public void forwardsIterationExcludesItemsWhenPredicatereturnsFalse() {
        Iterator<String> expectedIterator = new ArrayIterator(ARRAY);
        Iterator<String> underlyingIterator = new ArrayIterator(ARRAY);

        Iterator<String> iterator = new FilterIterator(underlyingIterator, new DummyPredicate(false, expectedIterator));

        iterator.first();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }

        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

    @Test
    public void backwardsIterationIncludesItemsWhenPredicatereturnsTrue() {
        Iterator<String> expectedIterator = new ArrayIterator(ARRAY);
        Iterator<String> underlyingIterator = new ArrayIterator(ARRAY);

        Iterator<String> iterator = new FilterIterator(underlyingIterator, new DummyPredicate(true, expectedIterator));

        iterator.last();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[2], iterator.current());

        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[1], iterator.current());

        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[0], iterator.current());

        iterator.previous();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }

        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

    @Test
    public void backwardsIterationExcludesItemsWhenPredicatereturnsFalse() {
        Iterator<String> expectedIterator = new ArrayIterator(ARRAY);
        Iterator<String> underlyingIterator = new ArrayIterator(ARRAY);

        Iterator<String> iterator = new FilterIterator(underlyingIterator, new DummyPredicate(false, expectedIterator));

        iterator.last();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }

        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

}
