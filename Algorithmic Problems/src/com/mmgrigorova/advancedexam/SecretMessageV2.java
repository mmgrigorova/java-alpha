package com.mmgrigorova.advancedexam;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 *
 * check if it wokrs?>>>
 */

public class SecretMessageV2 {

static String decoded = "";


    static void fakeInput() {
//        String test = "-{}-";
//        String test = "2{z10{xy}}";
        String test = "4{a}2{xz}";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static StringBuilder decode(StringBuilder message, StringBuilder decoded) {
        int left = 0;
        int right = 0;
        if (message.equals("")) {
            //System.out.println(decoded);
            return decoded;
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
            //System.out.println(decoded);
            return decoded;
        }


        int startIndex = 0;
        int looperStart = 0;

        for (int i = 0; i < left; i++) {
            if (Character.isDigit(message.charAt(i))) {
                startIndex = Integer.parseInt(message.substring(i, left));
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
        StringBuilder newMessage = new StringBuilder("");
        newMessage.append(start);
        newMessage.append(middle);
        newMessage.append(end);
        decode(newMessage, decoded);

        return decoded;
    }


    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        String messageIn = in.nextLine();
        StringBuilder message = new StringBuilder(messageIn);
        StringBuilder decoded = new StringBuilder("");
        decoded = decode(message, decoded);

        System.out.println(decoded);
    }
}
