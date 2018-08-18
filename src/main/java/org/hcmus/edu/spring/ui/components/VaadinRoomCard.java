package org.hcmus.edu.spring.ui.components;

import org.hcmus.edu.spring.backend.data.entity.Room;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("vaadin-room-card")
@HtmlImport("src/components/vaadin-room-card.html")
public class VaadinRoomCard
        extends PolymerTemplate<VaadinRoomCard.VaadinRoomCardModel> {

    public VaadinRoomCard(Room room) {
        setId("room-card-" + room.getId());
    }

    public interface VaadinRoomCardModel extends TemplateModel {
    }

}
