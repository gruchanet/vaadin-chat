package com.gruchanet.vaadin.chat.component;

import com.gruchanet.vaadin.chat.component.parts.menu.ChatMenu;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

public class MainLayout extends HorizontalLayout {

    private ChatMenu chatMenu = new ChatMenu();
    private HorizontalLayout bodyContent = new HorizontalLayout();

    public MainLayout() {
        setSizeFull();

        initLayout();
    }

    private void initLayout() {
        addComponents(
                chatMenu,
                bodyContent
        );
    }

    public Layout getBodyContent() {
        return bodyContent;
    }
}
