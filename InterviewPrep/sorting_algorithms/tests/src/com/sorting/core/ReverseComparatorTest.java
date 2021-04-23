package com.sorting.core;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.sorting.core.ReverseComparator;

public class ReverseComparatorTest {


    private ReverseComparator<String> mComparator;

    @Before
    public void setUp() {
        mComparator = new ReverseComparator<String>();
    }

    @Test
    public void lessThanBecomesGreaterThan() {
        assertTrue(mComparator.compare("A", "B") > 0);
    }
    
    @Test 
    public void greaterThanBecomesLessThan() {
        assertTrue(mComparator.compare("B", "A") < 0);
    }

    
    @Test 
    public void equalsRemainsUnchanged() {
        assertTrue(mComparator.compare("A", "A") == 0);
    }
}
