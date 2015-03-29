package com.gruchanet.vaadin.chat.component.message;

import com.gruchanet.vaadin.chat.domain.Message;
import com.gruchanet.vaadin.chat.domain.User;
import com.gruchanet.vaadin.chat.helper.html.HTMLFormatter;
import com.gruchanet.vaadin.chat.helper.html.TextFormatType;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageLayout extends GridLayout {

    public MessageLayout(Message message) {
        super(5, 5);
        setSizeFull();
        setStyleName("chat-message");

        initLayout(message);
    }

    private void initLayout(Message message) {
        addComponent(buildAvatarContent(message.getUser()), 0, 0, 0, 1);
        addComponent(buildMessageTime(message.getSentAt()), 4, 0);
        addComponent(buildMessageText(message.getText()), 1, 1, 4, 4);
    }

    private Component buildAvatarContent(User user) {
        VerticalLayout avatarContent = new VerticalLayout();
        avatarContent.setSizeFull();

        Component avatarIcon = buildAvatarIcon(user.getGravatarURL());
        Component userName = buildUserName(user.getName());

        avatarContent.addComponents(
                avatarIcon,
                userName
        );
        avatarContent.setComponentAlignment(avatarIcon, Alignment.MIDDLE_CENTER);
        avatarContent.setComponentAlignment(userName, Alignment.MIDDLE_CENTER);

        return avatarContent;
    }

    private Component buildAvatarIcon(String url) {
        Image avatarIcon = new Image("",  new ExternalResource(url));
        avatarIcon.setStyleName("avatar-icon");

        return avatarIcon;
    }

    private Component buildUserName(String userName) {
        Label userNameCaption = new Label(HTMLFormatter.formatText(userName, TextFormatType.BOLD), ContentMode.HTML);
        userNameCaption.setStyleName("centered-text");

        return userNameCaption;
    }

    private Component buildMessageTime(Date messageSentAt) {
        String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(messageSentAt);

        Label messageTime =
                new Label(FontAwesome.CLOCK_O.getHtml() + " " +  formattedTime, ContentMode.HTML); // TODO: gray text color
        messageTime.addStyleName("message-time");

        return messageTime;
    }

    private Component buildMessageText(String message) {
        return new Label(message);
    }
}
