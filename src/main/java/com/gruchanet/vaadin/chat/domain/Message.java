package com.gruchanet.vaadin.chat.domain;

import java.util.Date;
import java.util.UUID;

public class Message {

    private UUID id = UUID.randomUUID();
    private User user;
    private String text;
    private Date sentAt;

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
        this.sentAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSentAt() {
        return sentAt;
    }
}
