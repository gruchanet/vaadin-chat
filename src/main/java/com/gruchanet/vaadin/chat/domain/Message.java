package com.gruchanet.vaadin.chat.domain;

import java.util.UUID;

public class Message {

    private UUID id = UUID.randomUUID();
    private User user;
    private String message;

    public Message(User user, String message) {
        this.user = user;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
