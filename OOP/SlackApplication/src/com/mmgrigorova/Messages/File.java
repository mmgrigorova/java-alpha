package com.mmgrigorova.Messages;

import com.mmgrigorova.Downloadable;
import com.mmgrigorova.Message;

public class File extends Message implements Downloadable {
    String fileName;

    public File(String shortName, String fileName, String timestamp) {
        super(MessageType.FILE, shortName, timestamp);
        this.fileName = fileName;
    }

    @Override
    public void download(String downloadURL){
        System.out.printf("%s has been downloaded to %s.", fileName, downloadURL);
    };

    @Override
    public void displayMessage() {
        System.out.println(this);
        if (likes > 0){
            System.out.printf("%d likes",likes);
        }

    }

    @Override
    public String toString() {
        return super.toString() + " uploaded file " + fileName;
    }
}
