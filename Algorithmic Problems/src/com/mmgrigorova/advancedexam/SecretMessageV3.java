package com.mmgrigorova.advancedexam;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isDigit;

/**
 * NOT WORKING
 * Solve Secret Message using RegEx.
 */

public class SecretMessageV3 {
    static void fakeInput() {
//        String test = "-{}-";
        String test = "2{z10{xy}}";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        String messageIn = in.nextLine();
        StringBuilder message = new StringBuilder(messageIn);

        System.out.println();
        StringBuilder result = decodeMessage(message);
    }

    public static StringBuilder decodeMessage(StringBuilder message) {

        final String pattern = "\\d+\\{[a-z]+\\}";

        Pattern p = Pattern.compile(pattern);
        Matcher match = p.matcher(message);

        String looper = "";

        boolean isFound = match.find();
        if (isFound) {
            looper = match.group();
        }

        String toRepeat = "";
        int times = 0;
        String timesCh = "";

        for (int i = 0; i < looper.length(); i++) {
            if (looper.charAt(i) == '{' || looper.charAt(i) == '}') {
                continue;
            }

            if (isDigit(looper.charAt(i))) {
                timesCh = timesCh + looper.charAt(i);
            } else {
                toRepeat = toRepeat + looper.charAt(i);
            }
            times = Integer.parseInt(timesCh);
        }

        String replacement = "";
        for (int i = 0; i < times; i++) {
            replacement += toRepeat;
        }


//        decodeMessage(messageIn);

        return null;
    }

}
