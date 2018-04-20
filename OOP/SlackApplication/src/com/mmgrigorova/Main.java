package com.mmgrigorova;

import com.mmgrigorova.Messages.Text;

public class Main {

    public static void main(String[] args) {
        Application app = new Application("general");
        app.createChannel("spam");
        app.setCurrent("general");
        app.getCurrentChannel();

        app.postText("Joro", "Hi, guys! How are you?", "2018-04-20 21:06:48.789");
        app.postText("Maria", "Hi, I'm great!", "2018-04-20 21:07:48.000");
        app.postImage("Maria", "cuteKitten.jpg", "2018-04-20 21:07:48.987");
        app.postFile("Ivan", "Calculate Fibonacci.xls", "2018-04-20 21:10:48.234");

        app.likeMessage("2018-04-20 21:07:48.987", "Maria");
        app.likeMessage("2018-04-20 21:07:48.987", "Ivan");
        app.listHistory();
    }
}
