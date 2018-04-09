package com.mmgrigorova.Recursion;

import java.util.ArrayList;

public class GirlsGoneWildV2 {
    public static void generateCombos(int n,
                                      ArrayList<Integer> tShirts,
                                      int iTShirts,
                                      ArrayList<Character> skirts,
                                      int iSkirts,
                                      ArrayList<String> combinations,
                                      ArrayList<ArrayList<String>> row) {

        if(iTShirts == tShirts.size()-1 ||iSkirts == skirts.size()-1){
            String current = String.valueOf(tShirts.get(0)) + skirts.get(0);
            return;
        }


            for (int iTshirt = iTShirts; iTshirt < tShirts.size(); iTshirt++) {
                for (int iSkirt = iSkirts; iSkirt < skirts.size(); iSkirt++) {
                    for (int girl = 0; girl < n; girl++) {
                    String current = String.valueOf(tShirts.get(iTshirt)) + skirts.get(iSkirt);
                    if (combinations.contains(current)) {
                        continue;
                    }
                    combinations.add(current);
                    row.add(combinations);
                }
            }

        }
      generateCombos(n,tShirts,iTShirts+1, skirts, iSkirts+1, combinations, row);

    }


    public static void main(String[] args) {
        Integer k = 3;
        String l = "aabc";
        int n = 2;

        ArrayList<Integer> tShirts = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            tShirts.add(i, i);
        }
        ArrayList<Character> skirts = new ArrayList<>();
        for (int i = 0; i < l.length(); i++) {
            skirts.add(i, l.charAt(i));
        }
        ArrayList<String> combinations = new ArrayList<String>();
        ArrayList<ArrayList<String>> row = new ArrayList<ArrayList<String>>();

        generateCombos(n, tShirts, 0, skirts, 0, combinations, row);
        combinations.forEach(System.out::println);
        row.forEach(System.out::println);
    }
}
