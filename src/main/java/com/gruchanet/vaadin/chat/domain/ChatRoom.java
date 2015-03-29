package com.gruchanet.vaadin.chat.domain;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

    private List<User> users = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }
}
