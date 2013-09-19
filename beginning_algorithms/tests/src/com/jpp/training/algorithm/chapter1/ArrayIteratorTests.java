package com.jpp.training.algorithm.chapter1;

import static junit.framework.Assert.*;
import org.junit.Test;

public class ArrayIteratorTests {


    @Test
    public void iterateionRespectsBounds() {
        String[] array = new String[] { "A", "B", "C", "D", "E", "F" };

        /*
         * We give the iterator a start index of 1 and a count of 3. Then, we
         * expect that the first element in the iterator, is the position 1 in
         * the array
         */
        Iterator<String> iterator = new ArrayIterator(array, 1, 3);

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(array[1], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[2], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[3], iterator.current());

        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException ex) {
            // expected
        }
    }

    @Test
    public void backwardsIteration() {
        String[] array = new String[] { "A", "B", "C" };
        Iterator<String> iterator = new ArrayIterator(array);

        iterator.last();
        assertFalse(iterator.isDone());
        assertSame(array[2], iterator.current());

        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(array[1], iterator.current());

        iterator.previous();
        assertFalse(iterator.isDone());
        assertSame(array[0], iterator.current());

        iterator.previous();
        assertTrue(iterator.isDone());

        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException ex) {
            // expected
        }
    }

}
