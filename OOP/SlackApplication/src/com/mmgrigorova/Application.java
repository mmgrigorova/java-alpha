package com.mmgrigorova;

import com.mmgrigorova.Messages.File;
import com.mmgrigorova.Messages.Image;
import com.mmgrigorova.Messages.MessageType;
import com.mmgrigorova.Messages.Text;

import java.util.ArrayList;
import java.util.Set;

public class Application {
    private ArrayList<Channel> channels;
    private Channel currentChannel;

    public Application() {
        channels = new ArrayList<>();
        currentChannel = null;
    }

    public Application(String firstChannel){
        channels = new ArrayList<>();
        createChannel(firstChannel);
        currentChannel = channels.get(0);
    }

    //TODO Create methods for posting Text, Image,

    public void createChannel(String name){
        Channel created = new Channel(name, false);
        currentChannel = created;
        channels.add(created);
    }

    public void setCurrent(String channelName){
        currentChannel = findChannel(channelName);
        System.out.printf("Current channel is: %s\n", currentChannel.getName());
    }

    public Channel getCurrentChannel(){
        return currentChannel;
    }

    public Channel findChannel(String channelName){
        for (Channel channel : channels){
            if(channel.getName().equals(channelName)){
                return channel;
            }
        }
        System.out.println("No channel found with such name.");
        return null;
    }


    public void postText(String userShortName, String text, String timestamp){
        currentChannel.addToHistory(new Text(userShortName, text, timestamp));
    }

    public void postImage(String userShortName, String imageName, String timestamp){
        currentChannel.addToHistory(new Image(userShortName, imageName, timestamp));
    }

    public void postFile(String userShortName, String fileName, String timestamp){
        currentChannel.addToHistory(new File(userShortName, fileName, timestamp));
    }


    public void listHistory(){
        currentChannel.showHistory();
    }

    public void likeMessage(String timestamp, String userShortName){

        if (currentChannel.getMessage(timestamp) instanceof Likeable){
            ((Likeable)currentChannel.getMessage(timestamp)).like(userShortName);
        } else {
            System.out.println("You cannot like this message");
        }
    }


}
