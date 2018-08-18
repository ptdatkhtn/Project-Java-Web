package org.hcmus.edu.spring.ui.views.login;

import org.hcmus.edu.spring.ui.utils.UiConst;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("login-view")
@HtmlImport("src/views/login/login-view.html")

@Route(value = "login")
@PageTitle("### Classroom Management ###")
@Viewport(UiConst.VIEWPORT)
public class LoginView extends PolymerTemplate<TemplateModel> {

}
