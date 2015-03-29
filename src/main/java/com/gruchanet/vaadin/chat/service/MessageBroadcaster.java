package com.gruchanet.vaadin.chat.service;

import com.gruchanet.vaadin.chat.domain.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageBroadcaster {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static List<MessageListener> listeners = new ArrayList<>();

    public static synchronized void registerListener(MessageListener listener) {
        listeners.add(listener);
    }

    public static synchronized void unregisterListener(MessageListener listener) {
        listeners.remove(listener);
    }

    public static synchronized void broadcast(final Message message) {

        for (final MessageListener listener : listeners) {
            executorService.execute(new Runnable() {

                @Override
                public void run() {
                    listener.receiveMessage(message);
                }
            });
        }
    }
}
