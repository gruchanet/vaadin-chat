package com.gruchanet.vaadin.chat.domain;

import com.gruchanet.vaadin.chat.helper.Gravatar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

import org.hibernate.validator.constraints.*;

public class User { // TODO: set name & email, clicking on icon, email is required

    private UUID id = UUID.randomUUID();

    @NotNull
    @Length(min = 2, max = 32)
    @Pattern(regexp = "[~a-zA-Z0-9_ ]*")
    private String name;

    @Email
    private String email;

    private String gravatarURL;

    public User() {
        this("");
    }

    public User(String name) {
        this(name, "");
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
        this.gravatarURL = buildGravatarURL();
    }

    public String getGravatarURL() {
        return gravatarURL;
    }

    public String buildGravatarURL() {
        return Gravatar.buildGravatarURL(email);
    }
}
