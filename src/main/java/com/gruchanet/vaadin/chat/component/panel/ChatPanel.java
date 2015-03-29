package com.gruchanet.vaadin.chat.component.panel;

import com.gruchanet.vaadin.chat.component.message.MessageLayout;
import com.gruchanet.vaadin.chat.domain.ChatRoom;
import com.gruchanet.vaadin.chat.domain.Message;
import com.gruchanet.vaadin.chat.domain.User;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

public class ChatPanel extends Panel {

    private ChatRoom chatRoom = new ChatRoom(); // TODO: event -> add message/user -> update layout

    public ChatPanel() {
        setCaption("Chat room");
        setIcon(FontAwesome.COMMENT);

        setWidth(70.0f, Unit.PERCENTAGE);
        setHeight(100.0f, Unit.PERCENTAGE);

        setContent(buildContent());
    }

    private Component buildContent() {
        final VerticalLayout innerContent = new VerticalLayout();
        innerContent.setSizeFull();

        Component messagesContent = buildMessagesContent();
        Component chatControls = buildChatControls();

        innerContent.addComponents(
                messagesContent,
                chatControls
        );
        innerContent.setExpandRatio(messagesContent, 1.0f);
        innerContent.setComponentAlignment(chatControls, Alignment.BOTTOM_CENTER);

        return innerContent;
    }

    private Component buildMessagesContent() {
        final VerticalLayout messagesContent = new VerticalLayout();
        messagesContent.setMargin(true);
        messagesContent.setSpacing(true);
        messagesContent.setStyleName("chat-content");

        // TODO: test
        messagesContent.addComponents(
                new MessageLayout(new Message(
                        new User("tester"),
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales."
                )),
                new MessageLayout(new Message(
                        new User("~anonymous"),
                        "Dolore amino potes, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                                "Dolore amino potes, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                                "Dolore amino potes, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                                "Dolore amino potes, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales."
                )),
                new MessageLayout(new Message(
                        new User("~anon123"),
                        "Dolore amino potes, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                                "Dolore amino potes, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                                "Dolore amino potes, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales." +
                                "Dolore amino potes, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales."
                ))
        );
        // TODO: END test

        return messagesContent;
    }

    private Component buildChatControls() {
        final HorizontalLayout chatControls = new HorizontalLayout();
        chatControls.setMargin(true);
        chatControls.setWidth(100.0f, Unit.PERCENTAGE);
        chatControls.setStyleName("chat-controls");

        TextField messageInput = buildMessageInput();
        Button submitButton = buildSubmitButton();

        chatControls.addComponents(
                messageInput,
                submitButton
        );
        chatControls.setExpandRatio(messageInput, 1.0f);
        chatControls.setComponentAlignment(messageInput, Alignment.MIDDLE_CENTER);
        chatControls.setComponentAlignment(submitButton, Alignment.MIDDLE_CENTER);

        return chatControls;
    }

    private TextField buildMessageInput() {
        TextField messageInput = new TextField();
        messageInput.setInputPrompt("Write message here...");
        messageInput.setWidth(100.0f, Unit.PERCENTAGE);

        return messageInput;
    }

    private Button buildSubmitButton() {
        Button submitBtn = new Button("Send", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                // TODO:
            }
        });

        return submitBtn;
    }
}
