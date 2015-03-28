package com.gruchanet.vaadin.chat.domain;

import com.gruchanet.vaadin.chat.helper.Gravatar;

import java.util.UUID;

public class User { // TODO: set name & email, clicking on icon, email is required

    private UUID id = UUID.randomUUID();
    private String name;
    private String email; // TODO: add validator
    private String gravatarURL;

    public User() {
        this("", "");
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.gravatarURL = buildGravatarURL();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGravatarURL() {
        return gravatarURL;
    }

    public String buildGravatarURL() {
        return Gravatar.buildGravatarURL(email);
    }
}
