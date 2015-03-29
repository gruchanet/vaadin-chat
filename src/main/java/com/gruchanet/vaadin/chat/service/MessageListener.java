package com.gruchanet.vaadin.chat.service;

import com.gruchanet.vaadin.chat.domain.Message;

public interface MessageListener {

    public void receiveMessage(Message message);
}
