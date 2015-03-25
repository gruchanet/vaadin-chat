package com.gruchanet.vaadin.chat.components;

import com.gruchanet.vaadin.chat.components.parts.InnerLayout;
import com.gruchanet.vaadin.chat.components.parts.TopBar;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class MainLayout extends VerticalLayout {

    private TopBar topBar = new TopBar();
    private InnerLayout innerLayout = new InnerLayout();

    public MainLayout() {
        setStyleName("full-size-layout");

        initLayout();
    }

    private void initLayout() {
        addComponents(
                topBar,
                innerLayout
        );

        setComponentAlignment(topBar, Alignment.TOP_LEFT);
        setComponentAlignment(innerLayout, Alignment.TOP_LEFT);
    }

    public InnerLayout getInnerLayout() {
        return innerLayout;
    }
}
