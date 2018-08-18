package org.hcmus.edu.spring.ui.events;

import org.hcmus.edu.spring.ui.entities.EventCreateEntity;
import org.hcmus.edu.spring.ui.views.room.RoomDetail;

import com.google.gson.Gson;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("event-update-backend")
public class EventUpdateEvent extends ComponentEvent<RoomDetail> {

    private final String jsonData;

    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source
     *         the source component
     * @param fromClient
     *         <code>true</code> if the event originated from the client
     */
    public EventUpdateEvent(RoomDetail source, boolean fromClient,
            @EventData("event.detail")  String jsonData) {
        super(source, fromClient);
        this.jsonData = jsonData;
    }

    public EventCreateEntity getCreateEventObject() {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, EventCreateEntity.class);
    }
}
