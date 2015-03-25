package com.gruchanet.vaadin.chat.components.parts;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

public class InnerLayout extends HorizontalLayout {

    private MenuBar menuBar = new MenuBar();
    private HorizontalLayout bodyContent = new HorizontalLayout();

    public InnerLayout() {
        setStyleName("full-size-layout");

        initLayout();
    }

    private void initLayout() {
        addComponents(
                menuBar,
                bodyContent
        );
    }

    public Layout getBodyContent() {
        return bodyContent;
    }
}
