package com.gruchanet.vaadin.chat;

import javax.servlet.annotation.WebServlet;

import com.gruchanet.vaadin.chat.component.MainLayout;
import com.gruchanet.vaadin.chat.component.parts.menu.MenuItemType;
import com.gruchanet.vaadin.chat.domain.User;
import com.gruchanet.vaadin.chat.event.MenuItemChangeEvent;
import com.gruchanet.vaadin.chat.helper.RandomStringGenerator;
import com.gruchanet.vaadin.chat.helper.Session;
import com.gruchanet.vaadin.chat.views.ChatRoomView;
import com.gruchanet.vaadin.chat.views.EmptyChatView;
import com.gruchanet.vaadin.chat.views.PrivateChatView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

/**
 *
 */
@Theme("defaultTheme")
@Widgetset("com.gruchanet.vaadin.chat.MyAppWidgetset")
@Title("BeChat")
public class MainUI extends UI {

    private Navigator navigator;
    private MainLayout layout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        initializeUser();

        initLayout();
        initNavigator();
    }

    private void initializeUser() {
        User currentUser = Session.getCurrentUser();

        if (currentUser == null) {
            User user = new User();

            try {
                user.setName(
                        "~anon" + RandomStringGenerator.generateRandomString(
                                6,
                                RandomStringGenerator.Mode.NUMERIC
                        )
                );
            } catch (Exception ex){
                user.setName("~anonymous");
            }

            Session.setCurrentUser(user);
        }
    }

    private void initLayout() {
        layout = new MainLayout();

        setContent(layout);
    }

    private void initNavigator() {
        navigator = new Navigator(this, layout.getBodyContent());

        registerViews();
    }

    private void registerViews() {
        navigator.addView("", new EmptyChatView());
        navigator.addView(MenuItemType.JOIN_ROOM.getNavigationLink(), new ChatRoomView());
        navigator.addView(MenuItemType.PRIVATE_CHAT.getNavigationLink(), new PrivateChatView());
    }

    @WebServlet(urlPatterns = "/chat/*", name = "MainUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MainUIServlet extends VaadinServlet {}
}
