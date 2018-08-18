package org.hcmus.edu.spring.ui.events;

import org.hcmus.edu.spring.ui.views.room.RoomDetail;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("scheduler-refresh")
public class SchedulerRefreshEvent extends ComponentEvent<RoomDetail> {

    private final int refreshed;

    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source
     *         the source component
     * @param fromClient
     *         <code>true</code> if the event originated from the client
     */
    public SchedulerRefreshEvent(RoomDetail source, boolean fromClient,
            @EventData("event.detail.refreshed") int refreshed) {
        super(source, fromClient);
        this.refreshed = refreshed;
    }

    public int getRefreshed() {
        return refreshed;
    }
}
