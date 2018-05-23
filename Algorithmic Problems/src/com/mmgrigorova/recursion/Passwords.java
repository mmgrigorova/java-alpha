package com.mmgrigorova.recursion;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Passwords {
    private static int convert(String s) {
        int value = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else {
                value = value * 10 + (s.charAt(i) - '0');
            }
        }
        if (flag == -1) {
            return -value;
        }
        return value;
    }

    private static void fakeInput() {
//        String test = "10 >>>>>>>>> 1";
        String test = "10 <<<<<<<<< 1";
//        String test = "2 > 13";
//        String test = "7 <=>>=< 23";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = convert(input[0]);
        String directions = input[1];
        int k = convert(input[2]);
        ArrayList<Integer> password = new ArrayList<>();

        hack(directions, -1, -1, password, 0, n, k, 0);
    }

    private static void hack(String directions,
                             int dirIndex,
                             int currentNumber,
                             ArrayList<Integer> password,
                             int index,
                             int n, int k, int passwordCount) {

       if (passwordCount > k){
           return;
       }

        if (password.size() == n || dirIndex == directions.length()) {
            passwordCount += 1;
            if (passwordCount == k) {
                for (Integer c : password) {
                    System.out.print(c);
                }
                System.out.println();
                System.out.println(passwordCount);
                return;
            }
        }

        ArrayList<Integer> keys = getKeys(directions, dirIndex, currentNumber);

        for (int keyIndex = 0; keyIndex < keys.size(); keyIndex++) {
            password.add(index, keys.get(keyIndex));
            currentNumber = keys.get(keyIndex);
            hack(directions, dirIndex + 1, currentNumber, password, index + 1, n, k, passwordCount);
            password.remove(index);
        }

    }

    private static ArrayList<Integer> getKeys(String directions, int dirIndex, int currentNumber) {
        ArrayList<Integer> keys = new ArrayList<>();


        if (dirIndex == -1) {
            for (int i = 1; i < 10; i++) {
                keys.add(i);
            }
            keys.add(0);
            return keys;
        }
        char direction = directions.charAt(dirIndex);
        if (direction == '>') {
            for (int i = currentNumber + 1; i < 10; i++) {
                keys.add(i);
            }
            keys.add(0);
        } else if (direction == '<') {
            for (int i = 1; i < currentNumber; i++) {
                keys.add(i);
            }
        } else {
            keys.add(currentNumber);
        }
        return keys;
    }
}
