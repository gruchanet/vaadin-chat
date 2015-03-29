package com.gruchanet.vaadin.chat.component.panel;

import com.gruchanet.vaadin.chat.component.message.MessageLayout;
import com.gruchanet.vaadin.chat.domain.ChatRoom;
import com.gruchanet.vaadin.chat.domain.Message;
import com.gruchanet.vaadin.chat.helper.Session;
import com.gruchanet.vaadin.chat.service.MessageBroadcaster;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

public class ChatPanel extends Panel {

    private ChatRoom chatRoom = new ChatRoom(); // TODO: event -> add message/user -> update layout

    private VerticalLayout messagesContent;
    private TextField messageInput;
//    private Button submitButton;
    private Button emoticonsButton;

    public ChatPanel() {
        setCaption("Chat room");
        setIcon(FontAwesome.COMMENT);

        setWidth(70.0f, Unit.PERCENTAGE);
        setHeight(100.0f, Unit.PERCENTAGE);

        setContent(buildContent());
//        renderMessages();
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
        messagesContent = new VerticalLayout();
        messagesContent.setMargin(true);
        messagesContent.setSpacing(true);
        messagesContent.setStyleName("chat-content");

        return messagesContent;
    }

    private Component buildChatControls() {
        final HorizontalLayout chatControls = new HorizontalLayout(); // TODO: input submit
        chatControls.setMargin(true);
        chatControls.setWidth(100.0f, Unit.PERCENTAGE);
        chatControls.setStyleName("chat-controls");

        messageInput = buildMessageInput();
        messageInput.setImmediate(true);
        messageInput.addShortcutListener(new ShortcutListener("Shortcut Name", ShortcutAction.KeyCode.ENTER, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                if (!messageInput.isEmpty()) {
                    MessageBroadcaster.broadcast(
                            new Message(Session.getCurrentUser(), messageInput.getValue())
                    );
                    messageInput.clear();
                }
            }
        });
//        Button submitButton = buildSubmitButton();
        emoticonsButton = buildEmoticonsButton();

        chatControls.addComponents(
                messageInput,
//                submitButton
                emoticonsButton
        );
        chatControls.setExpandRatio(messageInput, 1.0f);
        chatControls.setComponentAlignment(messageInput, Alignment.MIDDLE_CENTER);
//        chatControls.setComponentAlignment(submitButton, Alignment.MIDDLE_CENTER); // TODO: emoticon button

        return chatControls;
    }

    private TextField buildMessageInput() {
        TextField messageInput = new TextField();
        messageInput.setInputPrompt("Write message here...");
        messageInput.setWidth(100.0f, Unit.PERCENTAGE);

        return messageInput;
    }

//    private Button buildSubmitButton() {
//        Button submitButton = new Button("Send", new Button.ClickListener() {
//            @Override
//            public void buttonClick(Button.ClickEvent clickEvent) {
//                MessageBroadcaster.broadcast(
//                        new Message(Session.getCurrentUser(), messageInput.getValue())
//                );
//                messageInput.clear();
//                // TODO: + input submit -> <enter>
//            }
//        });
//
//        return submitButton;
//    }

    private Button buildEmoticonsButton() {
        Button emoticonsButton = new Button("", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                // TODO: emoticons handler
            }
        });
        emoticonsButton.setIcon(FontAwesome.SMILE_O);

        return emoticonsButton;
    }

//    private void renderMessages() {
//        for (Message message : chatRoom.getMessages()) {
//            renderMessage(message);
//        }
//    }

    public void renderMessage(Message message) {
        messagesContent.addComponent(new MessageLayout(message));
    }
}
