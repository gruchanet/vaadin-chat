package com.gruchanet.vaadin.chat.domain;

import java.util.UUID;

public class User {

    private UUID id = UUID.randomUUID();
    private String name;

    public User() {
        this("");
    }

    public User(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
