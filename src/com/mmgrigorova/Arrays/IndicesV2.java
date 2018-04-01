package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.util.*;

public class IndicesV2 {
    static void fakeInput() {
        String test = "6\n" +
                "1 2 3 5 7 1";
//       String test = "11\n" +
//                "2 10 1 3 9 8 7 2 4 6 1";
//        String test = "101\n" +
//                "77 48 33 9 47 31 0 13 3 81 30 26 23 45 46 99 35 12 14 62 91 98 72 65 96 20 57 85 15 100 67 24 7 17 " +
//                "42 2 28 74 27 50 22 80 82 1 51 66 11 95 69 79 61 56 38 16 25 5 92 88 83 43 87 94 76 93 21 37 59 4 73 44 " +
//                "40 84 75 36 97 63 89 68 86 60 41 70 18 54 58 39 29 10 52 6 64 32 8 53 34 19 78 49 90 55 71";
       System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void printSequence() {
        fakeInput();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String input = in.nextLine();

        String[] numbersString = input.split(" ");
        ArrayList<Integer> indices = new ArrayList<>();

        for (String numberString : numbersString){
            indices.add(Integer.parseInt(numberString));
        }

        int size = indices.size();
        HashSet<Integer> visited = new HashSet<>();
        boolean hasLoop = false;

        ArrayList<Integer> result = new ArrayList<>();

        int position = 0;
        result.add(position);
        visited.add(position);

        while (!hasLoop){
            if (indices.get(position) >= 0 && indices.get(position) < size ) {
                result.add(indices.get(position));

            } else {
                break;
            }
            position = indices.get(position);

            if (visited.contains(position)){
                hasLoop = true;
                break;
            } else {
                visited.add(position);
            }
        }
        int resultSize = result.size();

        int loopPosition = result.get(resultSize-1);
        loopPosition = result.indexOf(loopPosition);

        if (hasLoop) {
            StringJoiner beforeLoop = new StringJoiner(" ");
            for (int i = 0; i < loopPosition; i++) {
                beforeLoop.add(result.get(i).toString());
            }
            System.out.printf(beforeLoop.toString());

            String prefix = "(";
            String infix = " ";
            String postfix = ")";

            StringJoiner joiner = new StringJoiner(infix, prefix, postfix);
            for (int i = loopPosition; i < resultSize-1; i++) {
                joiner.add(result.get(i).toString());
            }
            System.out.println(joiner.toString());
        } else {
            for(Integer prints : result){
                System.out.printf(prints + " ");
            }
        }

    }
    public static void main(String[] args) {
        IndicesV2.printSequence();
    }
}
