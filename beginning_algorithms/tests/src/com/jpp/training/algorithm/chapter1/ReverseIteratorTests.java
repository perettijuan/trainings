package com.jpp.training.algorithm.chapter1;

import static junit.framework.Assert.*;
import org.junit.Test;

public class ReverseIteratorTests {


    private static final String[] ARRAY = new String[] { "A", "B", "C" };

    @Test
    public void forwardsIterationBecomesBackwards() {
        Iterator<String> iterator = new ReverseIterator(new ArrayIterator(ARRAY));

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[2], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[1], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[0], iterator.current());

        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // Expected
        }
    }

    
    @Test
    public void backwardsIterationBecomesForwards() {
        Iterator<String> iterator = new ReverseIterator(new ArrayIterator(ARRAY));

        iterator.last();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[0], iterator.current());

        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[1], iterator.current());

        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[2], iterator.current());

        iterator.previous();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // Expected
        } 
    }
    
}
