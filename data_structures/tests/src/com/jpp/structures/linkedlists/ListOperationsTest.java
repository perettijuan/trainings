package com.jpp.structures.linkedlists;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListOperationsTest {


    private ListElement<Integer> mHead;

    @Before
    public void setUp() {
        mHead = new ListElement<Integer>(0);
        int count = 100;
        ListElement<Integer> current = mHead;
        for (int i = 1; i < count; i++) {
            ListElement<Integer> next = new ListElement<Integer>(i);
            current.setNext(next);
            current = next;
        }
    }

    @Test
    public void insertAtFront() {
        ListElement<Integer> head = new ListElement<Integer>(12);
        Integer data = new Integer(13);
        head = ListOperations.insertAtFront(head, data);
        assertEquals(head.value(), data);
    }

    @Test
    public void insertAtFrontWithNullHead() {
        Integer data = new Integer(112);
        ListElement<Integer> head = ListOperations.insertAtFront(null, data);
        assertEquals(data, head.value());
    }

    @Test
    public void findElement() {
        Integer data = new Integer(67);
        ListElement<Integer> founded = ListOperations.find(mHead, data);       
        assertEquals(data, founded.value());
    }
    
    
    @Test
    public void lookForElementThatIsNotInTheList() {
        Integer data = new Integer(600);
        ListElement<Integer> founded = ListOperations.find(mHead, data);       
        assertNull(founded);
    }
    
    
    @Test
    public void lookForElementNull() {       
        ListElement<Integer> founded = ListOperations.find(mHead, null);       
        assertNull(founded);
    }
    
    
    
    @Test
    public void deleteElement() {
        ListElement<Integer> toDelete = new ListElement<Integer>(3);
        ListOperations.deleteElement(mHead, toDelete);
        ListElement<Integer> elem = mHead;
        ListElement<Integer> found = null;
        while (elem != null && elem.value() != null) {
            if (elem.value().equals(3)) {
                found = elem;
                break;
            }
            elem = elem.next();
        }
        assertNull(found);
    }
    
    
    
    @Test
    public void deleteHead() {
        ListElement<Integer> toDelete = mHead;
        ListElement<Integer> head = mHead;
        ListElement<Integer> found = ListOperations.deleteElement(head, toDelete);
        assertEquals(new Integer(1), found.value());
    }

    @Test
    public void insertAfter() {
        Integer data = new Integer(875);
        ListElement<Integer> prev = ListOperations.find(mHead, new Integer(60)); 
        ListOperations.insertAfter(mHead, prev, data);
        assertEquals(prev.next().value(), data);
    }
    
}
