package org.hcmus.edu.spring.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-toast")
@HtmlImport("frontend://bower_components/paper-toast/paper-toast.html")
public class PaperToast extends Component {

    public void open() {
        getElement().callFunction("open");
    }

}
