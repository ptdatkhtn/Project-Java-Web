package org.hcmus.edu.spring.ui.events;

import org.hcmus.edu.spring.ui.views.room.RoomDetail;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("event-delete-backend")
public class EventDeleteEvent extends ComponentEvent<RoomDetail> {

    private final Integer id;

    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source
     *         the source component
     * @param fromClient
     *         <code>true</code> if the event originated from the client
     */
    public EventDeleteEvent(RoomDetail source, boolean fromClient,
            @EventData("event.detail.id") Integer id) {
        super(source, fromClient);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
