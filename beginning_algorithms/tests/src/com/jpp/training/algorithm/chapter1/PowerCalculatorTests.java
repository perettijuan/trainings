package com.jpp.training.algorithm.chapter1;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.jpp.training.algorithm.chapter1.PowerCalculator;

public class PowerCalculatorTests {


    @Test
    public void anythingRaisedToThePowerOfZeroIsOne() {        
        assertEquals(1, PowerCalculator.calculate(0, 0));
        assertEquals(1, PowerCalculator.calculate(1, 0));
        assertEquals(1, PowerCalculator.calculate(3, 0));
        assertEquals(1, PowerCalculator.calculate(178, 0));        
    }
    
    @Test
    public void anythingRaisedToThePowerOfOneIsItSelf() {       
        assertEquals(1, PowerCalculator.calculate(1, 1));
        assertEquals(2, PowerCalculator.calculate(2, 1));
        assertEquals(27, PowerCalculator.calculate(27, 1));
        assertEquals(178, PowerCalculator.calculate(178, 1));
    }
    
    @Test
    public void calculateNumbers() {       
        assertEquals(0, PowerCalculator.calculate(0, 2));
        assertEquals(1, PowerCalculator.calculate(1, 2));
        assertEquals(4, PowerCalculator.calculate(2, 2));
        assertEquals(8, PowerCalculator.calculate(2, 3));
        assertEquals(27, PowerCalculator.calculate(3, 3));
    }

}
