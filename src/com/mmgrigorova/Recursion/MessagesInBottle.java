package com.mmgrigorova.Recursion;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Messages in Bottle
 * http://judge.telerikacademy.com/problem/03messagesinbottle
 */

public class MessagesInBottle {
    static void fakeInput() {
        String test = "12345\n" +
                "A12345B1C2D3E4F5G6";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void decipher(String code, ArrayList<String> result, Hashtable<String,String> map, String
            message) {

        if (code.length() == 0) {
            result.add(message);
            return;
        }

        for (int i = 1; i < code.length() + 1; i++) {
            String key = code.substring(0, i);
            if (map.containsKey(key)) {
                String letter = map.get(key);
                String nextCode = code.substring(i);
                decipher(nextCode, result, map, message+letter);
            } else {
                continue;
            }

        }

    }

    public static void populateMap(Hashtable map, String[] message){
        for (int index = 0; index < message.length-1; index=index+2) {
           String value = message[index];
           String key = message[index+1];
            map.put(key,value);
        }
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        String code = in.nextLine();
        String[] message = in.nextLine().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        Hashtable<String,String> map = new Hashtable<String,String>();


        populateMap(map,message);

        ArrayList<String> result = new ArrayList<>();

        decipher(code, result, map, new String());
        Collections.sort(result);

        System.out.println(result.size());
        for (String messages : result) {
            System.out.println(messages);
        }


    }
}
