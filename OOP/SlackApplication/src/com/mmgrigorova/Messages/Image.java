package com.mmgrigorova.Messages;

import com.mmgrigorova.Downloadable;
import com.mmgrigorova.Likeable;
import com.mmgrigorova.Message;
import com.mmgrigorova.User;

public class Image extends Message implements Likeable, Downloadable {
    private String imageName;

    public Image(String shortName, String imageName, String timestamp) {
        super(MessageType.IMAGE, shortName, timestamp);
        this.imageName = imageName;
    }

    @Override
    public void like(String userShortName) {
        likes++;
        System.out.printf("%s liked your message.\n", userShortName);
    }

    @Override
    public void download(String downloadURL){
        System.out.printf("%s has been downloaded to %s.", imageName, downloadURL);
    };

    @Override
    public void displayMessage() {
        System.out.print(this);
        if (likes>0){
            System.out.printf("\n %d likes\n", likes);
        }
    }


    @Override
    public String toString() {
        return super.toString() + " posted image " + imageName;
    }
}
