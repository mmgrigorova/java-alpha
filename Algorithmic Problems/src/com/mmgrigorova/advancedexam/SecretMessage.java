package com.mmgrigorova.advancedexam;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class SecretMessage {

    static String decoded = "";


    static void fakeInput() {
//        String test = "-{}-";
        String test = "2{z10{xy}}";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void decode(String message, String decoded) {
        int left = 0;
        int right = 0;
        if (message == null) {

            decoded = "";
            System.out.println(decoded);
            return;
        }


        boolean hasInternal = false;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '{') {
                if (left > 0) {
                    hasInternal = true;
                    continue;
                }
                left = i;
                continue;
            }
            if (message.charAt(i) == '}') {
                if (hasInternal) {
                    hasInternal = false;
                    continue;
                }
                right = i;
                break;
            }
            if (right > 0) {
                break;
            }
        }

        if (left == 0 && right == 0) {

            decoded = message;
            System.out.println(decoded);
            return;
        }


        int startIndex = 0;
        int looperStart = 0;

        for (int i = 0; i < left; i++) {
            if(Character.isDigit(message.charAt(i))){
                startIndex = Integer.parseInt(message.substring(i,left));
                looperStart = i;
                break;
            }
        }


        int looper = startIndex;

        String start = message.substring(0, looperStart);
        String middle = message.substring(left + 1, right);
        String end = message.substring(right + 1);

        String looped = "";

        for (int i = 0; i < looper; i++) {
            looped += middle;
        }

        middle = looped;
        String newMessage = start + middle + end;
       decode(newMessage, decoded);

        return;
    }


    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
//        String decoded = "";

//        decode(message, decoded);
        decode(message, decoded);

//        System.out.println(decoded);
    }
}
