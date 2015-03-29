package com.gruchanet.vaadin.chat;

import javax.servlet.annotation.WebServlet;

import com.gruchanet.vaadin.chat.component.MainLayout;
import com.gruchanet.vaadin.chat.domain.Message;
import com.gruchanet.vaadin.chat.domain.User;
import com.gruchanet.vaadin.chat.helper.RandomStringGenerator;
import com.gruchanet.vaadin.chat.helper.Session;
import com.gruchanet.vaadin.chat.service.MessageBroadcaster;
import com.gruchanet.vaadin.chat.service.MessageListener;
import com.vaadin.annotations.*;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

@Theme("defaultTheme")
@Widgetset("com.gruchanet.vaadin.chat.MyAppWidgetset")
@Title("BeChat")
@Push
public class MainUI extends UI implements MessageListener {

//    private Navigator navigator;
    private MainLayout layout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        initializeUser();

        MessageBroadcaster.registerListener(this);

        initLayout();
        initNavigator();
    }

    @Override
    public void detach() {
        MessageBroadcaster.unregisterListener(this);

        super.detach();
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
//        navigator = new Navigator(this, layout.getBodyContent());
//
//        registerViews();
    }

    private void registerViews() { // TODO: navigation
//        navigator.addView("", new ChatRoomView()); // new EmptyChatView()
//        navigator.addView(MenuItemType.JOIN_ROOM.getNavigationLink(), new ChatRoomView());
//        navigator.addView(MenuItemType.PRIVATE_CHAT.getNavigationLink(), new PrivateChatView());
    }

    @Override
    public void receiveMessage(final Message message) {
        access(new Runnable() {

            @Override
            public void run() {
                layout.getChatPanel()
                        .renderMessage(message)
                        .scrollToBottom();
            }
        });
    }

    @WebServlet(urlPatterns = "/chat/*", name = "MainUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MainUIServlet extends VaadinServlet {}
}
