package com.mmgrigorova.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Power Sum
 * https://www.hackerrank.com/challenges/the-power-sum/problem
 */

public class PowerSum {
    public static void main(String[] args) {
        int x = 29;
        int n = 2;
        ArrayList<Integer> triedNumbers = new ArrayList<Integer>();
        triedNumbers.add(1);

        int answer = solve(x, n,0, triedNumbers);
        System.out.println(answer);
    }

    private static int solve(int x, int n, int currentSum, ArrayList<Integer> triedNumbers) {
        int num = 0;
        int answer = 0;

        for (int i = 0; i < triedNumbers.size(); i++) {
            num = triedNumbers.get(i);
            currentSum += Math.pow(num,n);
        }

        if (currentSum == x){
            return 1;
        } else if (currentSum < x){
            int next = triedNumbers.get(triedNumbers.size()-1) + 1;
            triedNumbers.add(next);
            answer = answer + solve(x,n,currentSum,triedNumbers);
        } else {
            currentSum -= num;
            triedNumbers.remove(triedNumbers.size()-1);
            return 0;
        }

        return answer;

    }

}
