package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class BitShiftMatrix {
    static void fakeInput() {
        String test = "5 \n" +
                "6\n" +
                "4\n" +
                "14 27 1 5";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void bitMatrix(){
        fakeInput();

        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        String[] movesString = in.nextLine().split(" ");
        ArrayList<Integer> moves = new ArrayList<>();

        for (String moveElem : movesString){
            moves.add(Integer.parseInt(moveElem));
        }

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < r; i++) {
        }

        int coef = Math.max(r,c);



    }
}
