package com.gruchanet.vaadin.chat.components.parts;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

public class TopBar extends HorizontalLayout {

    private Button homeBtn = new Button();

    public TopBar() {
        setMargin(true);
        setWidth(100.0f, Unit.PERCENTAGE);
        setStyleName("top-bar");

        initLayout();
    }

    private void initLayout() {
        homeBtn.setIcon(FontAwesome.HOME);
        homeBtn.setStyleName("dark-button");

        addComponents(
                homeBtn
        );
    }
}
