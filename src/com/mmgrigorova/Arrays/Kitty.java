package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kitty
 * http://judge.telerikacademy.com/problem/30kitty
 */
public class Kitty {
    static void fakeInput(){
        String test = "@@@xx@*\n" +
                "1 -1 -1 4";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void kittyPath(){
        fakeInput();
        Scanner in = new Scanner(System.in);

        String arrayString = in.nextLine();
        String[] pathString = in.nextLine().split(" ");

        ArrayList<Character> array = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        for (int i = 0; i < arrayString.length(); i++) {
            array.add(arrayString.charAt(i));
        }

        for (String direction : pathString){
            path.add(Integer.valueOf(direction));
        }

        int food = 0;
        int souls = 0;
        int deadlocks = 0;
        int position = 0;
        char treat = array.get(position);

        for (int direction = 0; direction < array.size(); direction++) {
            //for (int direction = 0; direction < path.size(); direction++) {
                if (treat == '@'){
                    ++souls;
                } else if (treat == '*'){

                }
            //}
        }

    }
}
