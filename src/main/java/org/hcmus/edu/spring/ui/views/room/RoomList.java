package org.hcmus.edu.spring.ui.views.room;

import org.hcmus.edu.spring.backend.service.RoomService;
import org.hcmus.edu.spring.ui.MainView;
import org.hcmus.edu.spring.ui.utils.UiConst;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.Exclude;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

@Tag("room-list")
@HtmlImport("src/views/room/room-list.html")
@Route(value = UiConst.ROOM_LIST, layout = MainView.class)
public class RoomList extends PolymerTemplate<RoomList.RoomListModel> {

    @Autowired
    public RoomList(RoomService roomService) {
        String json = new Gson().toJson(roomService.findAllWithoutBooking());
        getModel().setRoomsJson(json);
    }

    public interface RoomListModel extends TemplateModel {
        void setRoomsJson(String roomsJson);
    }
}
