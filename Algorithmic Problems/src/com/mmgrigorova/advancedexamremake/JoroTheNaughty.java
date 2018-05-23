package com.mmgrigorova.advancedexamremake;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class JoroTheNaughty {

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

    static void fakeInput() {
        String test = "6 7 3\n" +
                "0 0\n" +
                "2 2\n" +
                "-2 2\n" +
                "3 -1";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int rows = convert(input[0]);
        int cols = convert(input[1]);
        int jumps = convert(input[2]);

        String[] input2 = reader.readLine().split(" ");
        int r = convert(input2[0]);
        int c = convert(input2[1]);

        int[] dRows = new int[jumps];
        int[] dCols = new int[jumps];
//        int jump = 0;

        for (int i = 0; i < jumps; i++) {
            String[] jumpSeq = reader.readLine().split(" ");
            dRows[i] = convert(jumpSeq[0]);
            dCols[i] = convert(jumpSeq[1]);
        }

        long sumVisited = r*cols + c + 1;
        int jumpNumber = 0;

        boolean[][] visited = new boolean[rows][cols];
        boolean hasEscaped = false;
        boolean beenCaught = false;

        while(true){
            int nextRow = r + dRows[jumpNumber%jumps];
            int nextCol = c + dCols[jumpNumber%jumps];

            if (nextRow >= 0 && nextRow < rows
                    && nextCol >= 0 && nextCol < cols ){

                if (visited[nextRow][nextCol]){
                    beenCaught = true;
                    break;
                }

                r = nextRow;
                c = nextCol;

                visited[r][c] = true;
                jumpNumber += 1;
                sumVisited += r*cols + c + 1;
            } else {
                hasEscaped = true;
                break;
            }
        }

        if (hasEscaped){
            System.out.println("escaped " + sumVisited);
        }

        if (beenCaught){
            System.out.println("caught " + jumpNumber);
        }
    }
}
