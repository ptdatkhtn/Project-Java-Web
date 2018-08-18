package org.hcmus.edu.spring.ui.components;

import java.util.ArrayList;
import java.util.List;

import org.hcmus.edu.spring.backend.data.entity.User;
import org.hcmus.edu.spring.backend.service.UserService;
import org.hcmus.edu.spring.ui.entities.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.templatemodel.Include;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("app-navigation")
@HtmlImport("src/components/app-navigation.html")
public class AppNavigation extends PolymerTemplate<AppNavigation.AppNavigationModel>
        implements AfterNavigationObserver {

    @Id("tabs")
    private Tabs tabs;

    private List<String> hrefs = new ArrayList<>();
    private String logoutHref;
    private String defaultHref;
    private String currentHref;

    @Autowired
    public AppNavigation(UserService userService) {
        Authentication userAuthentication = SecurityContextHolder.getContext().getAuthentication();
        getModel().setUser(userService.findByEmail(userAuthentication.getName()));
    }

    public void init(List<PageInfo> pages, String defaultHref, String logoutHref) {
        this.logoutHref = logoutHref;
        this.defaultHref = defaultHref;

        pages.forEach(page -> {
            Tab tab = new Tab(page.getTitle());
            hrefs.add(page.getLink());
            tabs.add(tab);
        });
        tabs.addSelectedChangeListener(e -> navigate());
    }

    private void navigate() {
        int idx = tabs.getSelectedIndex();
        if (idx >= 0 && idx < hrefs.size()) {
            String href = hrefs.get(idx);
            if (href.equals(logoutHref)) {
                UI.getCurrent().getPage().executeJavaScript("location.assign('logout')");
            } else if (!href.equals(currentHref)) {
                UI.getCurrent().navigate(href);
            }
        }
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        String href = event.getLocation().getFirstSegment().isEmpty() ? defaultHref
                : event.getLocation().getFirstSegment();
        currentHref = href;
        tabs.setSelectedIndex(hrefs.indexOf(href));
    }

    public interface AppNavigationModel extends TemplateModel {
        @Include({ "name",  "roleId"})
        void setUser(User user);
    }

}
