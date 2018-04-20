package com.mmgrigorova;

import com.mmgrigorova.Messages.MessageType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Message {
    MessageType type;
    User author;
    String content;
    String timestamp;
    protected int likes;
    //TODO check if people already liked message

    public Message(MessageType type, String shortName, String timestamp) {
        this.type = type;
        author = new User(shortName);
        this.timestamp = timestamp;
//        this.timestamp = (new Timestamp(System.currentTimeMillis())).toString();
        likes = 0;
    }

    public abstract void displayMessage();

    public String getMessageAuthor(){
        return author.getShortName();
    }

    public String getTimestamp(){
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", timestamp, getMessageAuthor());
    }


}
