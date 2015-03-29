package com.gruchanet.vaadin.chat;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

@Theme("defaultTheme")
@Widgetset("com.gruchanet.vaadin.chat.MyAppWidgetset")
public class DefaultUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {}

    @WebServlet(urlPatterns = {"/ui/*", "/VAADIN/*"}, name = "DefaultUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = DefaultUI.class, productionMode = false)
    public static class DefaultUIServlet extends VaadinServlet {}
}
