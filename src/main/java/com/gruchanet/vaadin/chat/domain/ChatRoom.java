package com.gruchanet.vaadin.chat.domain;

import java.util.List;

public class ChatRoom {

    private List<User> users;
    private List<Message> messages;

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
