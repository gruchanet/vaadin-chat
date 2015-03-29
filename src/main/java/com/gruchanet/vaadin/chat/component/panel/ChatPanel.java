package com.gruchanet.vaadin.chat.component.panel;

import com.gruchanet.vaadin.chat.component.emoticons.EmoticonType;
import com.gruchanet.vaadin.chat.component.message.MessageLayout;
import com.gruchanet.vaadin.chat.config.Config;
import com.gruchanet.vaadin.chat.domain.ChatRoom;
import com.gruchanet.vaadin.chat.domain.Message;
import com.gruchanet.vaadin.chat.helper.Session;
import com.gruchanet.vaadin.chat.helper.formatter.emoticon.EmoticonFormatter;
import com.gruchanet.vaadin.chat.service.MessageBroadcaster;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.ui.*;

import java.io.File;

public class ChatPanel extends Panel {

    private ChatRoom chatRoom = new ChatRoom(); // TODO: event -> add message/user -> update layout

    private VerticalLayout messagesContent;
    private TextField messageInput;
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
        final HorizontalLayout chatControls = new HorizontalLayout();
        chatControls.setMargin(true);
        chatControls.setWidth(100.0f, Unit.PERCENTAGE);
        chatControls.setStyleName("chat-controls");

        emoticonsButton = buildEmoticonsButton();
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

        chatControls.addComponents(
                emoticonsButton,
                messageInput
        );
        chatControls.setExpandRatio(messageInput, 1.0f);
        chatControls.setComponentAlignment(messageInput, Alignment.MIDDLE_CENTER);

        return chatControls;
    }

    private TextField buildMessageInput() {
        TextField messageInput = new TextField();
        messageInput.setInputPrompt("Write message here...");
        messageInput.setWidth(100.0f, Unit.PERCENTAGE);

        return messageInput;
    }

    private Button buildEmoticonsButton() {
        Button emoticonsButton = new Button("", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().addWindow(new EmoticonsSelectWindow());
            }
        });
        emoticonsButton.setIcon(FontAwesome.SMILE_O);

        return emoticonsButton;
    }

//    private void renderMessages() { // TODO: render past messages
//        for (Message message : chatRoom.getMessages()) {
//            renderMessage(message);
//        }
//    }

    public ChatPanel renderMessage(Message message) {
        messagesContent.addComponent(new MessageLayout(message));

        return this;
    }

    public ChatPanel scrollToBottom() {
        UI.getCurrent().scrollIntoView(messagesContent);

        return this;
    }

    private class EmoticonsSelectWindow extends Window {

        public EmoticonsSelectWindow() {
            super("Select emoticon");
            center();

            setContent(buildEmoticonsGrid());
        }

        private Component buildEmoticonsGrid() {
            GridLayout emoticonsGrid = new GridLayout(4, 4);
            emoticonsGrid.setSpacing(true);
            emoticonsGrid.setMargin(true);

            putEmoticonsIntoGrid(emoticonsGrid);

            return emoticonsGrid;
        }

        private GridLayout putEmoticonsIntoGrid(GridLayout emoticonsGrid) {
            for (EmoticonType emoticon : EmoticonType.values()) {
                if (emoticon.isShown()) {
                    Resource resource = new FileResource(new File(Config.EMOTICONS_PATH + emoticon.getFile()));

                    Button emoticonBtn = new Button(null, resource);
                    emoticonBtn.setStyleName("borderless");
                    emoticonBtn.setDescription(emoticon.getText());
                    emoticonBtn.setData(emoticon);
                    emoticonBtn.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            EmoticonType emoticon = (EmoticonType) clickEvent.getButton().getData();
                            String message = messageInput.getValue();

                            // get cursor position
                            int inputCursorPosition = messageInput.getCursorPosition();
                            if (inputCursorPosition > message.length()) {
                                inputCursorPosition = 0;
                            }

                            // put emoticon text
                            String emoticonText = " " + EmoticonFormatter.encloseWithTidle(emoticon.getText()) + " ";
                            String newMessage = message.substring(0, inputCursorPosition) +
                                    emoticonText +
                                    message.substring(inputCursorPosition, messageInput.getValue().length());
                            messageInput.setValue(newMessage);

                            // regain focus & set cursor position
                            messageInput.setCursorPosition(inputCursorPosition + emoticonText.length());
                        }
                    });

                    emoticonsGrid.addComponent(emoticonBtn);
                }
            }

            return emoticonsGrid;
        }
    }
}
