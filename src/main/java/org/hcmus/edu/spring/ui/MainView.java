package org.hcmus.edu.spring.ui;

import java.util.ArrayList;
import java.util.List;

import org.hcmus.edu.spring.app.security.SecurityUtils;
import org.hcmus.edu.spring.ui.components.AppNavigation;
import org.hcmus.edu.spring.ui.entities.PageInfo;
import org.hcmus.edu.spring.ui.utils.UiConst;
import org.hcmus.edu.spring.ui.views.admin.BookingNotification;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.templatemodel.TemplateModel;

import static org.hcmus.edu.spring.ui.utils.UiConst.PAGE_LOGOUT;

/**
 * The main view contains a simple label element and a template element.
 */
@Viewport(UiConst.VIEWPORT)
@Route
@PageTitle("### Classroom Management ###")
@Tag("main-view")
@HtmlImport("src/main-view.html")
public class MainView extends PolymerTemplate<TemplateModel> implements
        RouterLayout {

    @Id("appNavigation")
    private AppNavigation appNavigation;

    @Autowired
    public MainView() {
        List<PageInfo> pages = new ArrayList<>();

        pages.add(new PageInfo(UiConst.ROOM_LIST, "", "Rooms"));

        if (SecurityUtils.isAccessGranted(BookingNotification.class)) {
            pages.add(new PageInfo(UiConst.BOOKING_NOTIFICATION, "",
                    "Notifications"));
        }

        pages.add(new PageInfo(PAGE_LOGOUT, "", "Log Out"));

        appNavigation.init(pages, UiConst.ROOM_LIST, PAGE_LOGOUT);
    }

}
