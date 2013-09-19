package com.jpp.training.algorithm.chapter1;

public interface Predicate<Value> {


    /**
     * Evaluates the value parameter in order to determine if meets some
     * selection criteria
     * 
     * @param value
     *            - the Value to evaluate
     * @return - true if meets the criteria, false any other case.
     */
    public boolean evaluate(Value value);

}
