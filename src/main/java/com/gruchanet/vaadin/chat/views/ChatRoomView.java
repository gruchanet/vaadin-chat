package com.gruchanet.vaadin.chat.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

public class ChatRoomView extends VerticalLayout implements View {

    public ChatRoomView() {
        setSizeFull();
        setMargin(true);

        initLayout();
    }

    private void initLayout() {
        buildChatContents();
        buildChatControls();
    }

    private void buildChatContents() {
        Panel chatContents = new Panel();
        chatContents.setCaption("Chat");
        chatContents.setIcon(FontAwesome.COMMENT);

        setSizeFull();
        chatContents.setWidth(70.0f, Unit.PERCENTAGE);
        chatContents.setHeight(500.0f, Unit.PIXELS);

        addComponent(chatContents);
        setComponentAlignment(chatContents, Alignment.MIDDLE_CENTER);
    }

    private void buildChatControls() {
        HorizontalLayout chatControls = new HorizontalLayout();
        chatControls.setWidth(70.0f, Unit.PERCENTAGE);

        addComponent(chatControls);
        setComponentAlignment(chatControls, Alignment.MIDDLE_CENTER);
        setExpandRatio(chatControls, 1.0f);

        // attach chat controls
        TextField messageInput = buildMessageInput();
        Button submitButton = buildSubmitButton();

        chatControls.addComponents(
                messageInput,
                submitButton
        );
        chatControls.setExpandRatio(messageInput, 1.0f);
        chatControls.setComponentAlignment(messageInput, Alignment.MIDDLE_CENTER);
        chatControls.setComponentAlignment(submitButton, Alignment.MIDDLE_CENTER);
    }

    private TextField buildMessageInput() {
        TextField messageInput = new TextField();
        messageInput.setInputPrompt("Write message here...");
        messageInput.setWidth(100.0f, Unit.PERCENTAGE);

        return messageInput;
    }

    private Button buildSubmitButton() {
        Button submitBtn = new Button("Send");

        return submitBtn;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // TODO: implementation
    }
}
