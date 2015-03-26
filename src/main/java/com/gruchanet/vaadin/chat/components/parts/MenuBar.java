package com.gruchanet.vaadin.chat.components.parts;

import com.gruchanet.vaadin.chat.MainUI;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MenuBar extends VerticalLayout {

    private Button createRoomBtn = new Button("Create room", FontAwesome.PLUS);
    private Button joinRoomBtn = new Button("Join room", FontAwesome.SIGN_IN);
    private Button privateChatBtn = new Button("Private chat", FontAwesome.COMMENTS_O);

    public MenuBar() {
        setStyleName("menu-bar");

        initLayout();
    }

    private void initLayout() {
        createRoomBtn.setStyleName("solid-button dark-button icon-align-top");
        joinRoomBtn.setStyleName("solid-button dark-button icon-align-top");
        privateChatBtn.setStyleName("solid-button dark-button icon-align-top");

        joinRoomBtn.addClickListener(new ButtonListener(MainUI.CHAT_ROOM));
        privateChatBtn.addClickListener(new ButtonListener(MainUI.PRIVATE_CHAT));

        addComponents(
                createRoomBtn,
                joinRoomBtn,
                privateChatBtn
        );

        createRoomBtn.setEnabled(false);
        privateChatBtn.setEnabled(false);
    }

    class ButtonListener implements Button.ClickListener {

        private String navigationLink;

        public ButtonListener(String navigationLink) {
            this.navigationLink = navigationLink;
        }

        @Override
        public void buttonClick(Button.ClickEvent clickEvent) {
            UI.getCurrent().getNavigator().navigateTo(navigationLink);
        }
    }
}
