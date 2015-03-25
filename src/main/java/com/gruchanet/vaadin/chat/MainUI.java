package com.gruchanet.vaadin.chat;

import javax.servlet.annotation.WebServlet;

import com.gruchanet.vaadin.chat.components.MainLayout;
import com.gruchanet.vaadin.chat.views.ChatRoomView;
import com.gruchanet.vaadin.chat.views.EmptyChatView;
import com.gruchanet.vaadin.chat.views.PrivateChatView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 *
 */
@Theme("defaultTheme")
@Widgetset("com.gruchanet.vaadin.chat.MyAppWidgetset")
public class MainUI extends UI {

    private Navigator navigator;
    private MainLayout layout;

    private static final String PRIVATE_CHAT_VIEW = "chat/private";
    private static final String CHAT_ROOM_VIEW = "chat/room";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        initLayout();
        initNavigator();
    }

    private void initLayout() {
        layout = new MainLayout();

        setContent(layout);
    }

    private void initNavigator() {
        navigator = new Navigator(this, layout.getInnerLayout().getBodyContent());

        registerViews();
    }

    private void registerViews() {
        navigator.addView("", new EmptyChatView());
        navigator.addView(PRIVATE_CHAT_VIEW, new PrivateChatView());
        navigator.addView(CHAT_ROOM_VIEW, new ChatRoomView());
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {}
}
