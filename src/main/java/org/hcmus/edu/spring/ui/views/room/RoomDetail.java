package org.hcmus.edu.spring.ui.views.room;

import java.util.Optional;

import org.hcmus.edu.spring.backend.data.entity.Role;
import org.hcmus.edu.spring.backend.data.entity.Room;
import org.hcmus.edu.spring.backend.data.entity.RoomBooking;
import org.hcmus.edu.spring.backend.data.entity.User;
import org.hcmus.edu.spring.backend.service.RoomBookingService;
import org.hcmus.edu.spring.backend.service.RoomService;
import org.hcmus.edu.spring.backend.service.UserService;
import org.hcmus.edu.spring.ui.MainView;
import org.hcmus.edu.spring.ui.components.PaperButton;
import org.hcmus.edu.spring.ui.components.PaperToast;
import org.hcmus.edu.spring.ui.components.SchedulerComponent;
import org.hcmus.edu.spring.ui.entities.EventCreateEntity;
import org.hcmus.edu.spring.ui.events.EventClickEvent;
import org.hcmus.edu.spring.ui.events.EventCreateEvent;
import org.hcmus.edu.spring.ui.events.EventDeleteEvent;
import org.hcmus.edu.spring.ui.events.EventResizeEvent;
import org.hcmus.edu.spring.ui.events.EventUpdateEvent;
import org.hcmus.edu.spring.ui.events.SchedulerRefreshEvent;
import org.hcmus.edu.spring.ui.utils.UiConst;
import org.hcmus.edu.spring.ui.utils.converters.LocalDateConverter;
import org.hcmus.edu.spring.ui.utils.converters.LocalTimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.Include;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("room-detail")
@HtmlImport("src/views/room/room-detail.html")
@Route(value = UiConst.ROOM_DETAIL, layout = MainView.class)
public class RoomDetail extends PolymerTemplate<RoomDetail.RoomListModel>
        implements HasUrlParameter<Integer> {

    private Room currentRoom;
    private User user;

    private RoomService roomService;
    private UserService userService;
    private RoomBookingService roomBookingService;

    LocalTimeConverter timeConverter = new LocalTimeConverter();
    LocalDateConverter dateConverter = new LocalDateConverter();

    @Id("deleteEventBtn")
    private PaperButton deleteEventBtn;

    @Id("calender")
    private SchedulerComponent calender;

    @Id("eventClickToast")
    private PaperToast eventClickToast;

    @Autowired
    public RoomDetail(RoomService roomService, UserService userService,
            RoomBookingService roomBookingService) {
        this.roomService = roomService;
        this.userService = userService;
        this.roomBookingService = roomBookingService;

        calender.addEventResizeListener(this::resizeEvent);
        calender.addEventClickListener(this::clickEvent);

        addListener(SchedulerRefreshEvent.class, this::refreshScheduler);
        addListener(EventCreateEvent.class, this::createEvent);
        addListener(EventDeleteEvent.class, this::deleteEvent);
        addListener(EventUpdateEvent.class, this::updateEvent);
    }

    private void clickEvent(EventClickEvent eventClickEvent) {
        if (isOperatorUser()) {
            eventClickToast.open();
        }
    }

    private void updateEvent(EventUpdateEvent event) {
        EventCreateEntity frontEndData = event.getCreateEventObject();

        RoomBooking roomBooking = roomBookingService.findById(frontEndData.getId());
        roomBooking.setTitle(frontEndData.getTitle())
                .setApproval(frontEndData.getApproval())
                .setDate(dateConverter.decode(frontEndData.getDate()))
                .setToTime(timeConverter.decode(frontEndData.getToTime(),"HH:mm:ss"))
                .setFromTime(timeConverter.decode(frontEndData.getFromTime(),"HH:mm:ss"));

        roomBookingService.save(roomBooking);
    }

    private void deleteEvent(EventDeleteEvent event) {
        roomBookingService.deleteById(event.getId());
    }

    private void createEvent(EventCreateEvent event) {
        Authentication userAuthentication = SecurityContextHolder.getContext().getAuthentication();
        user = userService.findByEmail(userAuthentication.getName());
        EventCreateEntity entity = event.getCreateEventObject();

        RoomBooking roomBooking = new RoomBooking();
        roomBooking.setUser(user)
                .setRoom(this.currentRoom)
                .setFromTime(timeConverter.decode(entity.getFromTime(),"HH:mm:ss"))
                .setToTime(timeConverter.decode(entity.getToTime(), "HH:mm:ss"))
                .setDate(dateConverter.decode(entity.getDate()))
                .setTitle(entity.getTitle())
                .setApproval(entity.getApproval());
        roomBookingService.save(roomBooking);
        this.currentRoom = roomService.findById(this.currentRoom.getId()).get();
        getModel().setRoom(this.currentRoom);
    }

    private boolean isOperatorUser() {
        Authentication userAuthentication = SecurityContextHolder.getContext().getAuthentication();
        return userAuthentication.getAuthorities().stream().findFirst().get()
                .getAuthority().equals(Role.OPERATOR);
    }

    private void refreshScheduler(SchedulerRefreshEvent event) {
        // System.out.println("Refreshed scheduler: " + event.getRefreshed());
    }

    private void resizeEvent(EventResizeEvent event) {
        // System.out.println(String.format("Resize event activated: %s, %s",
        //        event.getEventId(), event.getYear()));
    }

    @Override
    public void setParameter(BeforeEvent event,
            @OptionalParameter Integer parameter) {
        Optional<Room> room = roomService.findById(parameter);
        this.currentRoom = room.get();
        getModel().setRoom(this.currentRoom);
    }

    public interface RoomListModel extends TemplateModel {
        @Include({ "id", "name", "accommodation", "damage", "imageUrl",
                "description", "roomBookings.id", "roomBookings.user.name",
                "roomBookings.fromTime", "roomBookings.toTime",
                "roomBookings.date", "roomBookings.title",
                "roomBookings.approval" })
        @Encode(value = LocalTimeConverter.class, path = "roomBookings.fromTime")
        @Encode(value = LocalTimeConverter.class, path = "roomBookings.toTime")
        @Encode(value = LocalDateConverter.class, path = "roomBookings.date")
        void setRoom(Room room);
    }
}
