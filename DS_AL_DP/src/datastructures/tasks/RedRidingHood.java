package datastructures.tasks;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class RedRidingHood {
    public static void main(String[] args) {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    }

    static void fakeInput() {
        String test = "5\n" +
                "4 5 1 3 0\n" +
                "1 2\n" +
                "5 1\n" +
                "4 5\n" +
                "3 2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}
