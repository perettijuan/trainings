package com.jpp.structures.linkedlists;

public class ListOperations {


    /**
     * Inserts an element at the top of the list.
     * 
     * @param head
     *            - the {@link ListElement} that represents the initial node of
     *            the linked list.
     * @param data
     *            - the data to insert into the new element.
     * @return - the new head of the linked list.
     */
    public static <E> ListElement<E> insertAtFront(ListElement<E> head, E data) {
        ListElement<E> element = new ListElement<E>(data);
        element.setNext(head);
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
     * the list). Note that the criteria to find an element, is to compare them
     * by it's value ( {@link ListElement#value()} )
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
        if (elementToDelete.value().equals(newHead.value())) {
            newHead = newHead.next();
        } else {
            ListElement<E> current = newHead;
            while (current != null) {
                if (current.next() != null && current.next().value().equals(elementToDelete.value())) {
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

    /**
     * Adds an element to the end of the list.
     * 
     * @param head
     *            - the head of the list. If it is null, the new element created
     *            is used as the new head.
     * @param data
     *            - the data to append in the {@link ListElement}
     * @return - the {@link ListElement} that points to the head.
     */
    public static <E> ListElement<E> add(ListElement<E> head, E data) {

        if (data == null) {
            throw new NullPointerException();
        }

        ListElement<E> newElement = new ListElement<E>(data);

        if (head == null) {
            head = newElement;
        } else {
            ListElement<E> current = head;
            while (current != null) {
                if (current.next() == null) {
                    current.setNext(newElement);
                    break;
                }
                current = current.next();
            }
        }

        return head;
    }

    /**
     * Inserts a new {@link ListElement} in the linked list, after the one that
     * is passed as parameter, only, and only if, the {@link ListElement} given
     * as parameter exists in the linked list.
     * 
     * @param head
     *            - the head of the linked list
     * @param prev
     *            - the {@link ListElement} to insert the new element after.
     * @param data
     *            - the data to add to the new {@link ListElement}
     * @return - the head of the linked list.
     */
    public static <E> ListElement<E> insertAfter(ListElement<E> head, ListElement<E> prev, E data) {
        if (head == null || prev == null || data == null) {
            throw new NullPointerException();
        }
        ListElement<E> newToInsert = new ListElement<E>(data);

        ListElement<E> current = head;
        while (current != null) {
            if (current.value().equals(prev.value())) {
                newToInsert.setNext(current.next());
                current.setNext(newToInsert);
                break;
            }
            current = current.next();
        }

        return head;
    }

}
