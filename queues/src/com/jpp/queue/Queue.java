package com.jpp.queue;

/**
 * Interface that defines the signature of all possible queue implementations.
 * 
 * @author Juan Peretti
 * 
 * @param <T>
 *            - the type of the object to be handled by this queue.
 */
public interface Queue<T> {


    /**
     * Stores a value in the queue
     * 
     * @param value
     *            - the value to insert in the queue.
     */
    public void enqueue(T value);

    /**
     * Retrieves the value at the head of the queue. The size of the queue will
     * decrease by one.
     * 
     * @return - the value at the head of the queue.
     * @throws EmptyQueueException
     *             - if there are no more items in the queue.
     */
    public T dequeue() throws EmptyQueueException;

    /**
     * Deletes all elements from the queue. The size of the queue will be reset
     * to zero.
     */
    public void clear();

    /**
     * Obtains the number of elements in the queue.
     * 
     * @return - the number of elements in the queue.
     */
    public int size();

    /**
     * Determines whether the queue is empty (size() == 0) or not.
     * 
     * @return - true if the queue is empty, false any other case.
     */
    public boolean isEmpty();

}
