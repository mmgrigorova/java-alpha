package com.mmgrigorova.AdvancedExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Expressions - from Editorial. Not working
 */

public class Expressions {
    public static void main(String[] args) {

        //Solution per editorial

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int digit = in.nextInt();

        int[] numbers = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            numbers[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        int counter = 0;
        counter = evaluateExpression(numbers, digit, 1, numbers[0], 1, 0, false);

        System.out.println(counter);
    }

    public static int evaluateExpression(int[] numbers, int value, int indexNums, int currentNumber, int
            currentProduct, int currentSum, boolean isNegative){
        int result = 0;

        if (indexNums == numbers.length){
            currentProduct += currentNumber;
            currentSum += isNegative ? (-1*currentProduct) : currentProduct;

            if (currentSum == value){
                return 1;
            }

            return 0;
        }

        int nextSum = currentSum + currentProduct * currentNumber * (isNegative ? -1 : 1);
        result += evaluateExpression(numbers, value, indexNums+1, numbers[indexNums], 1, nextSum, false);
        result += evaluateExpression(numbers, value, indexNums+1, numbers[indexNums], 1, nextSum, true);

        int nextProduct = currentProduct * currentNumber;
        result += evaluateExpression(numbers, value, indexNums + 1, numbers[indexNums], nextProduct, currentSum,
                isNegative);

        if (currentNumber != 0){
            int nextNumber = currentNumber * 10 + numbers[indexNums];
            result += evaluateExpression(numbers, value, indexNums+1, nextNumber, currentProduct, currentSum,
                    isNegative);
        }

        return result;
    }
}
