package com.gruchanet.vaadin.chat.view;

import com.gruchanet.vaadin.chat.component.menu.ChatMenu;
import com.gruchanet.vaadin.chat.component.panel.ChatPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;

public class ChatView extends HorizontalLayout implements View {

    private ChatMenu chatMenu = new ChatMenu();
    private ChatPanel chatPanel = new ChatPanel();

    public ChatView() {
        setSizeFull();

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

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // TODO: add user to chat room
    }
}
