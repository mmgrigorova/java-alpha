package com.mmgrigorova.Recursion;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Girls Gone Wild
 * http://judge.telerikacademy.com/problem/04girlsgonewild
 * <p>
 * Solved in class
 */

public class GirlsGoneWildClass {

    static void fakeInput() {
        String test = "3\n" +
                "aabc\n" +
                "2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }


    public static void main(String[] args) {
        // fakeInput();
        Scanner in = new Scanner(System.in);

        int tshirtsCount = in.nextInt();
        in.nextLine();
        String skirts = in.nextLine();

        //"Sort" a string
        char[] skirtsArray = skirts.toCharArray();
        Arrays.sort(skirtsArray);
        skirts = new String(skirtsArray);

        int girlsCount = in.nextInt();

        ArrayList<ArrayList<Integer>> tshirtsCombinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        for (int i = 0; i < girlsCount; i++) {
            combination.add(i,0);
        }
        getTshirtCombinations(tshirtsCount, girlsCount, 0, 0, combination,
                tshirtsCombinations);

        ArrayList<List<Character>> skirtsCombinations = new ArrayList<>();
        List<Character> combinationSkirts = new ArrayList<>();
        for (int i = 0; i < girlsCount; i++) {
            combinationSkirts.add(i,' ');
        }

        getSkirtCombinations(skirts, girlsCount, 0, 0,
                new HashSet<>(), combinationSkirts,
                skirtsCombinations);

        int combinations = tshirtsCombinations.size() * skirtsCombinations.size();
        System.out.println(combinations);

        ArrayList<String> result = new ArrayList<>();
        result = combine(tshirtsCombinations, skirtsCombinations, girlsCount);

        result.forEach(System.out::println);

    }

    private static ArrayList<String> combine(ArrayList<ArrayList<Integer>> tshirtsCombinations,
                                             ArrayList<List<Character>> skirtsCombinations, int girlsCount) {
        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<Integer> tshirt : tshirtsCombinations) {
            for (List<Character> skirt : skirtsCombinations) {
                StringBuilder row = new StringBuilder();
                for (int i = 0; i < girlsCount; i++) {
                    row.append(tshirt.get(i)).append(skirt.get(i));
                    if ((i != girlsCount - 1)) {
                        row.append("-");
                    } else {
                        continue;
                    }
                }
                result.add(row.toString());
            }

        }
        result.sort(String::compareTo);
        return result;
    }

    private static void getSkirtCombinations(String skirts, int girlsCount,
                                             int start, int index,
                                             HashSet<Integer> used,
                                             List<Character> combinationSkirts,
                                             ArrayList<List<Character>> skirtsCombinations) {
        if (index == girlsCount) {
            skirtsCombinations.add(new ArrayList<>(combinationSkirts));
            return;
        }

        for (int value = start; value < skirts.length(); value++) {
            if (used.contains(value)) {
                continue;
            }
//            if (combinationSkirts.get(index) != null &&
//                    combinationSkirts.get(index).equals(skirts.charAt(value))) {
            if (value > 0 && skirts.charAt(value) == skirts.charAt(value - 1) && !used.contains(value - 1)) {
                continue;
            }
            used.add(value);
            combinationSkirts.set(index, skirts.charAt(value));
            getSkirtCombinations(skirts, girlsCount, 0, index + 1, used, combinationSkirts, skirtsCombinations);
            used.remove(value);
        }
        return;
    }

    private static void getTshirtCombinations(int n, int k, int start, int index,
                                              List<Integer> combination,
                                              ArrayList<ArrayList<Integer>>
                                                      tshirtsCombinations) {
        if (index == k) {
            tshirtsCombinations.add(new ArrayList<>(combination));
            return;
        }
        for (int value = start; value < n; value++) {
            combination.set(index, value);
            getTshirtCombinations(n, k, value + 1, index + 1, combination, tshirtsCombinations);
        }
        return;
    }
}
