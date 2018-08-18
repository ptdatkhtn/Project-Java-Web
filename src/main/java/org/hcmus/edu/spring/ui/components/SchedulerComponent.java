package org.hcmus.edu.spring.ui.components;

import org.hcmus.edu.spring.ui.events.EventClickEvent;
import org.hcmus.edu.spring.ui.events.EventResizeEvent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

@Tag("scheduler-component")
@HtmlImport("frontend://bower_components/scheduler-component/scheduler-component.html")
public class SchedulerComponent extends Component {

    public Registration addEventResizeListener(
            ComponentEventListener<EventResizeEvent> listener) {
        return addListener(EventResizeEvent.class, listener);
    }

    public Registration addEventClickListener
            (ComponentEventListener<EventClickEvent> listener) {
        return addListener(EventClickEvent.class, listener);
    }
}
