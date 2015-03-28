package com.gruchanet.vaadin.chat.component;

import com.gruchanet.vaadin.chat.component.part.menu.ChatMenu;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

public class MainLayout extends HorizontalLayout {

    private ChatMenu chatMenu = new ChatMenu();
    private HorizontalLayout bodyContent = new HorizontalLayout();

    public MainLayout() {
        setSizeFull();
        addStyleName("mainview");

        initLayout();
    }

    private void initLayout() {
        bodyContent.addStyleName("view-content");
        bodyContent.setSizeFull();

        addComponents(
                chatMenu,
                bodyContent
        );

        setExpandRatio(bodyContent, 1.0f);
    }

    public Layout getBodyContent() {
        return bodyContent;
    }
}
