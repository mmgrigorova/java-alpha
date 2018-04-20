package com.mmgrigorova.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * In progress
 * Primes to N
 * http://judge.telerikacademy.com/problem/09primeston
 */

public class PrimesofNMethods {

    static boolean isPrime (int number){
        boolean isPrime = true;
        // We are checking up to the square of number. After that the dividers are the same
        int maxDivider = (int) Math.sqrt(number);

        for (int divider = 2; divider <= maxDivider; divider++) {
            if(number%divider == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    static ArrayList<Integer> getPrimes(int n){

        //ArrayList<Boolean> isPrimes = new ArrayList<>(n);

        //1. list with n+1 indices - mark which are primes
        List<Boolean> isPrime = Stream.generate(() -> true).limit(n+1).collect(Collectors.toList());

        //2. for each found prime, iterate prime * 2, * 3 ...
        for (int number = 2; number < n+1 ; number++) {
            for (int x = number+number; x < n+1; x+= number){
                isPrime.set(x,false);
            }
        }


        //3. extract primes
        ArrayList<Integer> primes  = new ArrayList<>(n);
        for(int i = 1; i < isPrime.size(); i++) {
            if (isPrime.get(i)){
                primes.add(i);
            }
        }
    return primes;

    }

    static ArrayList<Integer> collectPrimes(ArrayList<Boolean> list){
        ArrayList<Integer> allPrimes = new ArrayList<>();
        return allPrimes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

    //    getPrimes(n).forEach(System.out::println);
        getPrimes(n).forEach(x -> System.out.print(x + " "));

    }
}
