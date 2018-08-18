package org.hcmus.edu.spring.ui.events;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;

import org.hcmus.edu.spring.ui.components.SchedulerComponent;

@DomEvent("event-click")
public class EventClickEvent extends ComponentEvent<SchedulerComponent> {
    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source
     *         the source component
     * @param fromClient
     *         <code>true</code> if the event originated from the client
     */
    public EventClickEvent(SchedulerComponent source, boolean fromClient) {
        super(source, fromClient);
    }
}
