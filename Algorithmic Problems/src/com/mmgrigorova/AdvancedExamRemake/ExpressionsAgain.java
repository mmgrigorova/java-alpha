package com.mmgrigorova.AdvancedExamRemake;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExpressionsAgain {
    static void fakeInput() {
        String test = "123\n" +
                "6";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();

        Scanner in = new Scanner(System.in);
        String[] digits = in.nextLine().split("");
        int target = in.nextInt();
        int targetMet = 0;
        int n = digits.length - 1;

        ArrayList<StringBuilder> actions = new ArrayList<>();

        char[] ab = {'+', '-', '*', ' '};
        variate(0, n, ab, new char[n], actions);

        targetMet = generateExpressions(digits, actions, target);

        System.out.println(targetMet);
    }

    private static int evaluateExpression(StringBuilder expression, int target) {

        long tempExpression;
        StringBuilder op1 = new StringBuilder();
        StringBuilder op2 = new StringBuilder();

        while (true) {
            op1.setLength(0);
            op2.setLength(0);
            tempExpression = 0;
            int i = 0;
            boolean isNegative = false;
            if (expression.charAt(i) == '-') {
                isNegative = true;
                i++;
            }

            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                op1.append(expression.charAt(i));
                i++;
            }

            if ((op1.length() > 1 && op1.charAt(0) == '0')) {
                return 0;
            }

            if (i >= expression.length()) {
                break;
            }

            char action = expression.charAt(i);
            i++;


            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                op2.append(expression.charAt(i));
                i++;
            }

            if ((op2.length() > 1 && op2.charAt(0) == '0')) {
                return 0;
            }

            long operand1 = Long.parseLong(String.valueOf(op1)) * (isNegative ? -1 : 1);
            long operand2 = Long.parseLong(String.valueOf(op2));

            if (action == '+') {
                tempExpression = operand1 + operand2;
            } else if (action == 45) {
                tempExpression = operand1 - operand2;
            } else if (action == '*') {
                tempExpression = operand1 * operand2;
            }

            expression.replace(0, i, String.valueOf(tempExpression));
        }

        tempExpression = Long.parseLong(String.valueOf(expression));
        if (tempExpression == target) {
            return 1;
        } else {
            return 0;
        }

    }

    private static int generateExpressions(String[] digits, ArrayList<StringBuilder> actions, int target) {
        int result = 0;
        StringBuilder expression = new StringBuilder();
        for (StringBuilder action : actions) {
            expression.setLength(0);
            expression.append(digits[0]);
            for (int j = 1; j < digits.length; j++) {
                char op = action.charAt(j - 1);
                if (op != ' ') {
                    expression.append(op);
                } else {
                    expression.append("");
                }
                expression.append(digits[j]);
            }
            result += evaluateExpression(expression, target);
        }
        return result;
    }


    private static void variate(int index, int n, char[] ab, char[] variation, ArrayList<StringBuilder> actions) {
        if (index == n) {
            StringBuilder expressionVar = new StringBuilder();

            for (int i = 0; i < n; i++) {
                expressionVar.append(variation[i]);
            }

            actions.add(expressionVar);
            return;
        }

        for (char anAb : ab) {
            variation[index] = anAb;
            variate(index + 1, n, ab, variation, actions);
        }
    }
}
