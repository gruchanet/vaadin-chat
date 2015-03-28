package com.gruchanet.vaadin.chat.component.part.menu;

import com.gruchanet.vaadin.chat.views.ChatRoomView;
import com.gruchanet.vaadin.chat.views.PrivateChatView;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum MenuItemType {
    CREATE_ROOM("<s>Create room</s>", FontAwesome.PLUS, "", null), // TODO: ignore CREATE_ROOM MenuItemButton [3rd param -> null]
    JOIN_ROOM("Join room", FontAwesome.SIGN_IN, "room", ChatRoomView.class),
    PRIVATE_CHAT("<s>Private chat</s>", FontAwesome.COMMENTS_O, "private", PrivateChatView.class);

    private final String description;
    private final Resource icon;
    private final String navigationLink;
    private final Class<? extends View> viewClass;

    private MenuItemType(
            final String description,
            final Resource icon,
            final String navigationLink,
            final Class<? extends View> viewClass
    ) {
        this.description = description;
        this.icon = icon;
        this.navigationLink = navigationLink;
        this.viewClass = viewClass;
    }

    public String getDescription() {
        return description;
    }

    public Resource getIcon() {
        return icon;
    }

    public String getNavigationLink() {
        return navigationLink;
    }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }
}
