package com.gruchanet.vaadin.chat.helper;

import com.gruchanet.vaadin.chat.domain.User;
import com.vaadin.server.VaadinSession;

public class Session {

    public static User getCurrentUser() {
        return VaadinSession.getCurrent().getAttribute(User.class);
    }

    public static void setCurrentUser(User user) {
        VaadinSession.getCurrent().setAttribute(User.class, user);
    }
}
