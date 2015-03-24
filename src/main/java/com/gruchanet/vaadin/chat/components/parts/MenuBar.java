package com.gruchanet.vaadin.chat.components.parts;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class MenuBar extends VerticalLayout {

    private Button createRoomBtn = new Button("Create room");
    private Button joinRoomBtn = new Button("Join room");
    private Button privateChatBtn = new Button("Private chat");

    private Button testChatBtn = new Button("Test chat");

    public MenuBar() {
        setWidth(150.0f, Unit.PIXELS);
        setHeight(100.0f, Unit.PERCENTAGE);
        setStyleName("menu-bar");

        initLayout();
    }

    private void initLayout() {
        createRoomBtn.setIcon(FontAwesome.PLUS);
        joinRoomBtn.setIcon(FontAwesome.SIGN_IN);
        privateChatBtn.setIcon(FontAwesome.COMMENTS_O);

        createRoomBtn.setStyleName("solid-button dark-button icon-align-top");
        joinRoomBtn.setStyleName("solid-button dark-button icon-align-top");
        privateChatBtn.setStyleName("solid-button dark-button icon-align-top");

        addComponents(
                createRoomBtn,
                joinRoomBtn,
                privateChatBtn
        );

        // test components
        testChatBtn.setIcon(FontAwesome.WECHAT);
        testChatBtn.setStyleName("solid-button dark-button icon-align-top");
        addComponent(testChatBtn);
    }
}
