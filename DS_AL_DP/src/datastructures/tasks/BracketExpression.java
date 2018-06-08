package datastructures.tasks;

/**
 * TODO: Not working
 * Bracket Expressions
 * http://judge.telerikacademy.com/problem/04bracketexpressions
 */

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketExpression {

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

//        String pattern = "(?=\\()([^\\]]+)(?=\\))";
//        String pattern = "(?=\\()([^\\)]+[^\\(])(?!\\))";
        String pattern = "(?=\\()([^\\)]+[^\\(])(?!\\))";

        Pattern p = Pattern.compile(pattern);

        Stack<String> stack = new Stack<>();

        while (true) {
            if (!stack.empty()) {
                input = stack.peek();
            }
            Matcher m = p.matcher(input);
            int count = m.groupCount();

            if (!m.find()) {
                break;
            }
            for (int i = 1; i <= count; i++) {
                stack.push(m.group(i));
            }

        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
            result.append("\n");
        }


        System.out.println(result);
    }


    private static void fakeInput() {
//        String test = "5 * (123 * (1 + 3) + ((4 - 3) / 6))";
        String test = "(1 + 3) + (4 - 3)";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}
