package com.gruchanet.vaadin.chat.component.menu;

import com.gruchanet.vaadin.chat.helper.html.HTMLFormatter;
import com.gruchanet.vaadin.chat.helper.html.TextFormatType;
import com.gruchanet.vaadin.chat.views.ChatRoomView;
import com.gruchanet.vaadin.chat.views.PrivateChatView;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum MenuItemType { // TODO: navigation
    CREATE_ROOM( // TODO: ignore CREATE_ROOM MenuItemButton [3rd param -> null]
            HTMLFormatter.formatText("Create room", TextFormatType.STRIKE),
            FontAwesome.PLUS,
            "",
            null
    ),
    JOIN_ROOM(
            HTMLFormatter.formatText("Join room", TextFormatType.STRIKE),
            FontAwesome.SIGN_IN,
            "room",
            ChatRoomView.class
    ),
    PRIVATE_CHAT(
            HTMLFormatter.formatText("Private chat", TextFormatType.STRIKE),
            FontAwesome.COMMENTS_O,
            "private",
            PrivateChatView.class
    );

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
