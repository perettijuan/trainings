package com.jpp.structures.linkedlists;

public class ListOperations {


    /**
     * Inserts an element at the top of the list.
     * 
     * @param list
     *            - the {@link ListElement} that represents the initial node of
     *            the linked list.
     * @param data
     *            - the data to insert into the new element.
     * @return - the new head of the linked list.
     */
    public static <E> ListElement<E> insertAtFront(ListElement<E> list, E data) {
        ListElement<E> element = new ListElement<E>(data);
        element.setNext(list);
        return element;
    }

    /**
     * Finds a given element of data in the linked list.
     * 
     * @param head
     *            - the current head of the linked list
     * @param data
     *            - the data to look for.
     * @return - the {@link ListElement} that contains the data if founded.
     *         Otherwise, returns the head of the list.
     */
    public static <E> ListElement<E> find(ListElement<E> head, E data) {
        ListElement<E> elem = head;
        while (elem != null && elem.value() != null) {
            if (elem.value().equals(data)) {
                break;
            }
            elem = elem.next();
        }
        return elem;
    }

    /**
     * Deletes the {@link ListElement} received as parameter (if it is found in
     * the list).
     * 
     * @param head
     *            - the {@link ListElement} that points to the head of the
     *            linked list
     * @param elementToDelete
     *            - the {@link ListElement} to delete from the list.
     * @return - the head of the linked list.
     */
    public static <E> ListElement<E> deleteElement(ListElement<E> head, ListElement<E> elementToDelete) {

        if (head == null || elementToDelete == null) {
            throw new NullPointerException();
        }

        ListElement<E> newHead = head;

        /*
         * If the element to delete is the head of the list, we have to update
         * the head
         */
        if (elementToDelete.equals(newHead)) {
            newHead = newHead.next();
            newHead = null;
        } else {
            ListElement<E> current = newHead;
            while (current != null) {
                if (current.next() != null && current.next().equals(elementToDelete)) {
                    /* Founded the element to delete. */
                    current.setNext(elementToDelete.next());
                    elementToDelete = null;
                    break;
                }
                current = current.next();
            }
        }

        return newHead;

    }

    
    public static <E> ListElement<E> add(ListElement<E> head, E data) {
        
        return head;
    }
    
//    insert at the end
//    insert after
//    insert at
}
