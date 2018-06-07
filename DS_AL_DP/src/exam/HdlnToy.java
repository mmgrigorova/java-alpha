package exam;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;

public class HdlnToy {
    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        int tagsCount = in.nextInt();
        in.nextLine();

        for (int i = 0; i < tagsCount; i++) {
            String tagString = in.nextLine();
            int indent = Integer.parseInt(tagString.substring(1));

            while (!stack.empty() && indent <= Integer.parseInt(stack.peek().substring(1))){
                String popped = stack.pop();
                int n = stack.size();
                System.out.printf("%s</%s>%n", calcSpaces(n), popped);
            }

            int n = stack.size();
            stack.push(tagString);
            System.out.printf("%s<%s>%n", calcSpaces(n), tagString);
        }

        while (!stack.empty()){
            String popped = stack.pop();
            int n = stack.size();
            System.out.printf("%s</%s>%n", calcSpaces(n), popped);
        }
    }

    private static String calcSpaces(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(" ");
        }
        return result.toString();
    }

    private static void fakeInput() {

        String test = "9\n" +
                "a1\n" +
                "b2\n" +
                "c3\n" +
                "d3\n" +
                "e2\n" +
                "f3\n" +
                "g2\n" +
                "h1\n" +
                "i2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}