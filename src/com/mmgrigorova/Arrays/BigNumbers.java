package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BigNumbers {
    static void fakeInput() {
        String test = "3 4\n" +
                "8 3 3\n" +
                "6 2 4 2";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void bigNumbers() {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        String[] firstStrings = in.nextLine().split(" ");
        String[] secondStrings = in.nextLine().split(" ");

        n = firstStrings.length;
        m = secondStrings.length;

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        for(String firstS : firstStrings){
            first.add(Integer.parseInt(firstS));
        }

        for(String secondS : secondStrings){
            second.add(Integer.parseInt(secondS));
        }

        int max = Math.max(n,m);
        int remainder = 0;
        ArrayList<Integer> result = new ArrayList<>(max);
        int firstAdd;
        int secondAdd;

        for (int i = 0; i < max; i++) {



            if (i >= first.size()){
                firstAdd = 0;
            } else {
                firstAdd = first.get(i);
            }
            if (i >= second.size()){
                secondAdd = 0;
            } else {
                secondAdd = second.get(i);
            }


            int digit = firstAdd + secondAdd + remainder;
            if (digit >= 10) {
                remainder = digit / 10;
                digit = digit%10;
            } else {
                remainder = 0;
            }
            result.add(i, digit);
            if(i==max-1){
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + " ");
            }
        }

    }

}

