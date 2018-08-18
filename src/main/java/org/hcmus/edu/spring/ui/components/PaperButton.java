package org.hcmus.edu.spring.ui.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

@Tag("paper-button")
@HtmlImport("frontend://bower_components/paper-button/paper-button.html")
public class PaperButton extends Component {

    public Registration addClickListener(
            ComponentEventListener<ClickEvent<PaperButton>> listener) {
        return addListener(ClickEvent.class, (ComponentEventListener) listener);
    }

}
