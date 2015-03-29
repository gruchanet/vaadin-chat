package com.gruchanet.vaadin.chat.service;

import com.gruchanet.vaadin.chat.domain.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageBroadcaster {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static List<MessageReceiver> receivers = new ArrayList<MessageReceiver>();

    public static synchronized void registerListener(MessageReceiver receiver) {
        receivers.add(receiver);
    }

    public static synchronized void unregisterListener(MessageReceiver receiver) {
        receivers.remove(receiver);
    }

    public static synchronized void broadcast(final Message message) {

        for (final MessageReceiver receiver : receivers) {
            executorService.execute(new Runnable() {

                @Override
                public void run() {
                    receiver.receiveMessage(message);
                }
            });
        }
    }
}
