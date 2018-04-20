package com.mmgrigorova.Messages;

import com.mmgrigorova.Likeable;
import com.mmgrigorova.Message;
import com.mmgrigorova.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Text extends Message implements Likeable {
    String text;

    public Text(String userShortName, String messageText, String timestamp) {
        super(MessageType.TEXT, userShortName, timestamp);
        text = messageText;
    }

    @Override
    public void like(String userShortName) {
       likes++;
        System.out.printf("%s liked your message.", userShortName );
    }

    @Override
    public void displayMessage() {
        System.out.println(this);
        if (likes>0){
            System.out.printf("\n %d likes", likes);
        }
    }


    @Override
    public String toString() {
        return super.toString() + ": " + text;
    }
}
