package com.jpp.mpreview.event;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * A listener to be notified about the occurrence of an Event. All the
 * interested for listening events changes needs to implement this interface
 *
 * @author Juan P. Peretti (juan.peretti@tallertechnologies.com)
 *
 */
public interface IEventListener {

    /**
     * Called each time that an Event is launched.
     *
     * @param event
     *            - the Event occurred.
     * @param data
     *            - some extra data associated to the event.
     * @return true if it handles the event, false any other case
     */
    boolean handleEvent(@NonNull EventController.Event event, @NonNull Bundle data);

}