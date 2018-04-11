package com.mmgrigorova.Recursion;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Girls Gone Wild
 * http://judge.telerikacademy.com/problem/04girlsgonewild
 *
 * Solved in class
 */

public class GirlsGoneWildClass {

    static void fakeInput() {
        String test = "3\n" +
                "baca\n" +
                "2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int shirtsCount = in.nextInt();
        in.nextLine();
        String skirts = in.nextLine();
        int girlsCount = in.nextInt();
    }
}
//
//        int skirtsCombinations = getCombinations(shirtsCount,girlsCount);
//        var shirtsVariations = getVariations(skirts,girlsCount);
//
//        for (var skirtsCimbination : skirtsCombinations){
//            for (var shirtsVariation : shirtsVariations){
//
//            }
//        }
//
//    }
//
//    private static int getVariations(String skirts, int girlsCount) {
//        if (current == k){
//            System.out.println();
//        }
//
//
//    }
//
//    private static var getCombinations(int shirtsCount, int girlsCount, int k, int[] combinations) {
//
//    }
//}
