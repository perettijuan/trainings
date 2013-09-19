package com.jpp.training.algorithm.chapter1;

/**
 * Interface that defines a generic way of obtaining an {@link Iterator}
 * 
 * @author Juan Peretti
 * 
 * @param <E>
 */
public interface Iterable<E> {


    /**
     * @return - the {@link Iterator} for this iterable element.
     */
    public Iterator<E> iterator();

}
