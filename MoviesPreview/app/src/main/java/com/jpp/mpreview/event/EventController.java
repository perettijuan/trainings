package com.jpp.mpreview.event;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

/**
 * An event controller that will handle events on an application level: each time that
 * an action is started, an event will be triggered and any registered listener will get
 * notified.<br>
 * This is based on the observer pattern.
 * <br>
 * Created by Juan P. Peretti
 */
public class EventController {

    public enum Event {
        RETRIEVE_REMOTE_CONFIGURATION,
        RETRIEVE_MOVIE_LIST;
    }

    // A 'bitmap' with all the listeners
    private HashMap<Event, Vector<IEventListener>> mEventListeners;

    /**
     * Class constructor
     */
    public EventController() {
        mEventListeners = new HashMap<>();
        init();
    }

    /**
     * Initialized the listeners data model
     */
    private void init() {
        for (Event event : Event.values()) {
            mEventListeners.put(event, new Vector<IEventListener>());
        }
    }

    /**
     * Notifies about the occurrence of a given Event.
     *
     * @param event - the Event to notify about.
     * @param data  - a Bundle containing any extra data needed
     * @return true if any of the IEventListener handles it, false any
     * other case
     */
    public boolean notifyEvent(@NonNull Event event, @Nullable Bundle data) {
        Vector<IEventListener> listeners = mEventListeners.get(event);
        boolean eventHandled = false;
        if (listeners != null) {
            Enumeration<IEventListener> elements = listeners.elements();
            if (elements != null) {
                while (elements.hasMoreElements()) {
                    eventHandled = (elements.nextElement()).handleEvent(event, data);
                }
            }
        }

        return eventHandled;
    }


    /**
     * Registers a single IEventListener to 'listen' for one
     * Event
     *
     * @param event    - the Event to listen for
     * @param listener - the IEventListener to register
     * @return - true if the IEventListener has been registered, false
     * any other case
     */
    public boolean registerToSingleEvent(@NonNull Event event, @NonNull IEventListener listener) {
        synchronized (mEventListeners) {
            boolean registered = false;
            Vector<IEventListener> listeners = mEventListeners.get(event);
            if (listeners != null) {
                listeners.add(listener);
            }
            return registered;
        }
    }


    /**
     * Unregisters an IEventListener that is listening for a single
     * Event
     *
     * @param event    - the Event to unregister for
     * @param listener - the IEventListener to unregister
     */
    public void unregisterFromEvent(@NonNull Event event, @NonNull IEventListener listener) {
        synchronized (mEventListeners) {
            if (listener != null) {
                String listenerName = listener.getClass().getName();
                Vector<IEventListener> listeners = mEventListeners.get(event);
                if (listeners != null) {
                    for (int i = 0; i < listeners.size(); i++) {
                        IEventListener current = listeners.elementAt(i);
                        if (current.getClass().getName().equals(listenerName)) {
                            listeners.remove(listener);
                            break;
                        }
                    }
                }
            }
        }
    }


    public void clearAll() {
        mEventListeners.clear();
    }
}
