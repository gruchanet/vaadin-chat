package com.gruchanet.vaadin.chat.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

public class EmptyChatView extends VerticalLayout implements View {

    public EmptyChatView() {
        setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {}
}
