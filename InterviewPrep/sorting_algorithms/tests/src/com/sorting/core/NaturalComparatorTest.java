package com.sorting.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sorting.core.NaturalComparator;

public class NaturalComparatorTest {

    private NaturalComparator<String> mComparator;
    
    @Before
    public void setUp() {
        mComparator = new NaturalComparator<String>();
    }
    
    @Test
    public void greaterThan() {        
        assertTrue(mComparator.compare("B", "A") > 0);
    }
    
    
    @Test 
    public void equalsTo() {
        assertTrue(mComparator.compare("A", "A") == 0);
    }
    
}
