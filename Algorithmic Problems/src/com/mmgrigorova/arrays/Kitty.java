package com.mmgrigorova.arrays;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kitty
 * http://judge.telerikacademy.com/problem/30kitty
 */

public class Kitty {
    private static boolean hasDeadlock;

    static void fakeInput() {
        String test = "@@@xx@*\n" +
                "1 -1 -1 4";
//        String test = "x@*@*@*\n" +
//        "2 -1 2 -1";
//        String test = "@*@*@*xxx\n" +
//                "1 -1 1 -1 2 1 1 1 1 1 1";
//        String test = "@x@@**xx@*@@\n" +
//                "-8 -11 16 11 -26 -6 -8 -16 10 10 -43 31 -28 -9 -36 9 -2 -41 11";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void displayDedlock(int deadlocks) {
        System.out.println("You are deadlocked, you greedy kitty!\n" +
                "Jumps before deadlock: " + deadlocks);
        hasDeadlock = true;
    }

    static ArrayList<Character> array = new ArrayList<>();
    static ArrayList<Integer> path = new ArrayList<>();


    public static int nextPosition(int position, int direction) {
            int next;
            if (direction >= path.size()){
                next = direction-1;
            } else {
                next = position + path.get(direction);
            }

            next = next % array.size();
            if (next>=0) {
                return position = next;
            } else {
                return position = array.size() + next;
            }
    }

    public static void kittyPath() {
        //fakeInput();
        Scanner in = new Scanner(System.in);

        String arrayString = in.nextLine();
        String[] pathString = in.nextLine().split(" ");

        for (int i = 0; i < arrayString.length(); i++) {
            array.add(arrayString.charAt(i));
        }

        for (String direction : pathString) {
            path.add(Integer.valueOf(direction));
        }

        int food = 0;
        int souls = 0;
        int deadlocks = 0;
        int position = 0;

        for (int direction = 0; direction <= path.size(); direction++) {
               //System.out.println(position + " " + array.get(position) + " direction " + path.get(direction));

            if (array.get(position) == '@') {
                ++souls;
                array.set(position, '-');
                position = nextPosition(position, direction);

            } else if (array.get(position) == '*') {
                ++food;
                array.set(position, '-');
                position = nextPosition(position, direction);

            } else if (array.get(position) == 'x') {
                ++deadlocks;
                if (position % 2 == 0) {
                    if (souls == 0) {
                        displayDedlock(direction);
                        break;
                    } else {
                        array.set(position, '@');
                        --souls;
                        position = nextPosition(position, direction);
                    }
                    // position = math.abs((position + path.get(direction)) % array.size());
                } else {
                    if (food == 0) {
                        displayDedlock(direction);
                        break;
                    } else {
                        array.set(position, '*');
                        --food;
                        position = nextPosition(position, direction);
                    }
                    //  position = math.abs((position + path.get(direction)) % array.size());
                }
            } else if (array.get(position) == '-') {
                position = nextPosition(position, direction);
                continue;
            }
        }
        if (!hasDeadlock) {
            System.out.println("Coder souls collected: " + souls + '\n' +
                    "Food collected: " + food + '\n' +
                    "Deadlocks: " + deadlocks);
        }

    }
}
