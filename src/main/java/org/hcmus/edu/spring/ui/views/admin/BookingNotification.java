package org.hcmus.edu.spring.ui.views.admin;

import org.hcmus.edu.spring.app.security.SecurityUtils;
import org.hcmus.edu.spring.backend.data.entity.Role;
import org.hcmus.edu.spring.ui.MainView;
import org.hcmus.edu.spring.ui.utils.UiConst;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

@Tag("booking-notification")
@HtmlImport("src/views/admin/booking-notification.html")
@Route(value = UiConst.BOOKING_NOTIFICATION, layout = MainView.class)

@Secured(Role.OPERATOR)
public class BookingNotification extends PolymerTemplate<BookingNotification.BookingNotificationModel>  implements
        BeforeEnterObserver {

    public BookingNotification() {
        // You can initialise any data required for the connected UI components here.
    }

    public interface BookingNotificationModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (!SecurityUtils.isAccessGranted(event.getNavigationTarget())) {
            event.rerouteToError(AccessDeniedException.class);
        }
    }
}
