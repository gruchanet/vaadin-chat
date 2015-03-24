package com.gruchanet.vaadin.chat.components;

import com.gruchanet.vaadin.chat.components.parts.MenuBar;
import com.gruchanet.vaadin.chat.components.parts.TopBar;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class MainLayout extends VerticalLayout {

    private TopBar topBar = new TopBar();
    private MenuBar menuBar = new MenuBar();

    public MainLayout() {
        initLayout();
    }

    private void initLayout() {
        addComponents(
                topBar,
                menuBar
        );

        setComponentAlignment(topBar, Alignment.TOP_LEFT);
        setComponentAlignment(menuBar, Alignment.TOP_LEFT);
    }
}
