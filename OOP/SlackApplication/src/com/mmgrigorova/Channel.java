package com.mmgrigorova;

import java.util.ArrayList;

public class Channel {
    private String name;
    private ArrayList<Message> messages;

    public Channel(String name, boolean isCurrent) {
        this.name = name;
        messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Message getMessage(String timestamp) {
        for (Message message : messages) {
            if (timestamp.equals(message.getTimestamp())) {
                return message;
            }
        }
        return null;
    }

    protected void addToHistory(Message message) {
        messages.add(message);
    }

    protected void showHistory() {
        if (messages.size() == 0) {
            System.out.println("This channel has no messages");
            System.out.println();
            return;
        }
        for (Message message : messages) {
            message.displayMessage();
        }
    }

    public void clearHistory() {
        System.out.println("History has been cleared");
        System.out.println();
        messages.clear();
    }
}
