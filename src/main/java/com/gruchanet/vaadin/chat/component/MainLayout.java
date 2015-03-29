package com.gruchanet.vaadin.chat.component;

import com.gruchanet.vaadin.chat.component.menu.ChatMenu;
import com.gruchanet.vaadin.chat.component.panel.ChatPanel;
import com.vaadin.ui.HorizontalLayout;

public class MainLayout extends HorizontalLayout {

    private ChatMenu chatMenu = new ChatMenu();
    private ChatPanel chatPanel = new ChatPanel();

    public MainLayout() {
        setSizeFull();
        addStyleName("mainview");

        initLayout();
    }

    private void initLayout() {
        addComponents(
                chatMenu,
                chatPanel
        );

        setExpandRatio(chatPanel, 1.0f);
    }

    public ChatPanel getChatPanel() {
        return chatPanel;
    }
}
