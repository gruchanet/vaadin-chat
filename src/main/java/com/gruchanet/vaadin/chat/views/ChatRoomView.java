package com.gruchanet.vaadin.chat.views;

import com.gruchanet.vaadin.chat.component.panel.ChatPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

public class ChatRoomView extends VerticalLayout implements View {

    public ChatRoomView() {
        setHeight(100.0f, Unit.PERCENTAGE);
        setMargin(true);

        ChatPanel chatPanel = new ChatPanel();

        addComponent(chatPanel);
        setComponentAlignment(chatPanel, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // TODO: implementation
    }
}
