package datastructures.tasks;

import java.io.ByteArrayInputStream;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BracketExpression {
    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        StringBuilder expression = new StringBuilder("");
        Stack<String> stack = new Stack<>();
        int lBracketCounter = 0;
        boolean[] visited = new boolean[input.length()];

        while (true) {
            boolean hasBrackets = false;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(') {
                    hasBrackets = true;
                    lBracketCounter += 1;
                }
                if (lBracketCounter > 0) {
                    expression.append(c);
                }
                if (c == ')') {
                    lBracketCounter -= 1;
                }


                if (lBracketCounter == 0 && expression.length() > 1) {
                    stack.push(expression.toString());
                    expression = new StringBuilder();
                    hasBrackets = false;
                }

            }
            if (!hasBrackets) {
                break;
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
        String test = "5 * (123 * (1 + 3) + ((4 - 3) / 6))";
//        String test = "(1 + 3) + (4 - 3)";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}
