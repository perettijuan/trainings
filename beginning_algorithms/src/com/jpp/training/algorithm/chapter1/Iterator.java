package com.jpp.training.algorithm.chapter1;

public interface Iterator<E> {


    /**
     * Moves the iterator to the initial element on the underlying data.
     */
    public void first();

    /**
     * Moves the iterator to the last element in the underlying data.
     */
    public void last();

    /**
     * Determines whether the iterator refers to an item.
     * 
     * @return - true if the end has been reached; false to indicate that more
     *         items needs to be processed.
     */
    public boolean isDone();

    /**
     * Moves the iterator to the next element in the underlying data.
     */
    public void next();

    /**
     * Moves the iterator to the previous element in the underlying data.
     */
    public void previous();

    /**
     * Obtains the value of the current item.
     * 
     * @return - the value of the current item.
     * @throws IteratorOutOfBoundsException
     *             - if there is no current item.
     */
    public E current() throws IteratorOutOfBoundsException;

}
