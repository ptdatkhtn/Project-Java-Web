package org.hcmus.edu.spring.ui.events;

import org.hcmus.edu.spring.ui.components.SchedulerComponent;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("event-resize")
public class EventResizeEvent extends ComponentEvent<SchedulerComponent> {

    private final int eventId;
    private final int year;

    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source
     *         the source component
     * @param fromClient
     *         <code>true</code> if the event originated from the client
     */
    public EventResizeEvent(SchedulerComponent source, boolean fromClient,
            @EventData("event.detail.event.id") int eventId, @EventData("event" +
            ".detail.event.end._i[0]")  int year) {
        super(source, fromClient);
        this.eventId = eventId;
        this.year = year;
    }

    public int getEventId() {
        return eventId;
    }

    public int getYear() {
        return year;
    }
}
