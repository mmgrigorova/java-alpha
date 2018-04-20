package com.mmgrigorova.Messages;

import com.mmgrigorova.Message;

public class Icon extends Message {
    public Icon(MessageType type, String shortName, String timestamp) {
        super(type, shortName, timestamp);
    }

    @Override
    public void displayMessage() {

    }
}
