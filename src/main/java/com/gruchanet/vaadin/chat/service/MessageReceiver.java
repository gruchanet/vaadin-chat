package com.gruchanet.vaadin.chat.service;

import com.gruchanet.vaadin.chat.domain.Message;

public interface MessageReceiver {

    public void receiveMessage(Message message);
}
