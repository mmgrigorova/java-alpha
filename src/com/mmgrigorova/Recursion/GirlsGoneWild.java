package com.mmgrigorova.Recursion;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Girls Gone Wild
 * http://judge.telerikacademy.com/problem/04girlsgonewild
 */

public class GirlsGoneWild {
    public static long nFactorial(int n) {
        long result;
        if (n == 1 || n == 0) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            result = n * nFactorial(n - 1);
        }
        return result;
    }


    public static String getCombo(int k, String l, int curK, int curL) {
        String combo;
        if (k == 0 || curK >= k ||
                curL >= l.length() ||
                l.length() == 0) {
            return "";
        } else {
            combo = String.valueOf(curK) + l.charAt(curL);
        }
        return combo;
    }

    public static ArrayList<String> getAllCombos(int k, String l, int n, int startK, int startL,
                                                 int startGirl,
                                                 ArrayList<String> allCombos,
                                                 ArrayList<String> used) {

        if (startK >= k || startL >= l.length() || startGirl >= n) {
            used.forEach(x ->System.out.printf( "%s ",x));
            System.out.println();
            return allCombos;
        }
        boolean[] usedSkirt = new boolean[l.length()];
        String current = "";


        for (int shirtsK = 0; shirtsK < k; shirtsK++) {
            for (int skirtsL = 0; skirtsL < l.length(); skirtsL++) {
                current = getCombo(k, l, shirtsK + startGirl, skirtsL + startGirl);
                if (current.equals("")) {
                    continue;
                }
                if (used.contains(current)) {
                    continue;
                }

                used.add(current);
                allCombos.add(new String(current));

                getAllCombos(k, l, n, startK + 1, startL + 1, startGirl + 1, allCombos, used);
                used.remove(current);

            }

        }


//        String left = "";
//        String middle = " - ";
//        String right;
//        String result = "";
//        for (int kS = 0; kS < k; kS++) {
//            left = getCombo(k, l, kS, startL);
//            for (int lS = startL+1; lS < l.length(); lS++) {
//                right = getCombo(k, l, kS+1,startL + lS);
//                result  = left + middle + right;
//                allCombos.add(new String(result));
//
//            }
//            getAllCombos(k,l,n,startK+1,startL+kS, allCombos);
//        }
        return allCombos;
    }

//    public static void printGirls(int k, String l, int n, int currShirt, int currSkirt, int currGirl) {
//        if (n > k || n > l.length()) {
//            return;
//        }
//        if (currShirt == k || currSkirt == l.length()) {
//            return;
//        }
//
//        String combo = String.valueOf(currShirt) + l.charAt(currSkirt);
//        System.out.print(combo);
//        if (currGirl < n - 1) {
//            System.out.print(" - ");
//        } else {
//            System.out.print("\n");
//        }
//
//        printGirls(k, l, n, currShirt, currSkirt + 1, currGirl + 1);
//
//        System.out.println("combo approach");
//        for (int value = 0; value < k; value++) {
//            String comb = String.valueOf(value)
//        }
//
//        return;
//    }


    public static void main(String[] args) {
        int k = 3;
        String l = "abcd";
        Integer n = 2;


        ArrayList<String> clothesCombos = new ArrayList<>();

        getAllCombos(k, l, n, 0, 0, 0, clothesCombos, new ArrayList<>());
//
//        for(int girls = 0; girls<n; girls++){
//            System.out.println("Girl " + girls);
//            ArrayList<String> clothesForGirl = new ArrayList<>();
//            for (int shirts = 0; shirts < k; shirts++) {
//                for (int skirts = 0; skirts < l.length(); skirts++) {
//                    String combo = String.valueOf(shirts)+l.charAt(skirts);
//                    clothesForGirl.add(combo);
//                    System.out.println(combo);
//                }
//            }
//            clothesCombos.add(new ArrayList<>(clothesForGirl));
//        }

//        System.out.println("Combo result: " + getCombo(k,l, 0, 0));

//        clothesCombos.forEach(System.out::println);
        System.out.println(clothesCombos.size());

//        System.out.println(combinations);

    }
}

