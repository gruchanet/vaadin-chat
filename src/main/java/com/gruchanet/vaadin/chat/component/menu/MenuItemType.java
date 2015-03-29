package com.gruchanet.vaadin.chat.component.menu;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum MenuItemType { // TODO: navigation (create room, join room, private chat)
    HOME_PAGE(
            "Home page",
            FontAwesome.HOME,
            "",
            null
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
