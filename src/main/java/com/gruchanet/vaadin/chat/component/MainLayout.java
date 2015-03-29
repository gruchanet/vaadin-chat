package com.gruchanet.vaadin.chat.component;

import com.gruchanet.vaadin.chat.view.ChatView;
import com.vaadin.ui.VerticalLayout;

public class MainLayout extends VerticalLayout {

    public MainLayout() {
        setSizeFull();
        addStyleName("mainview");
    }

    public ChatView getChatView() {
        for (int i = 0; i < getComponentCount(); i++) {
            if (getComponent(i) instanceof ChatView) {
                return (ChatView) getComponent(i);
            }
        }

        return null;
    }
}
