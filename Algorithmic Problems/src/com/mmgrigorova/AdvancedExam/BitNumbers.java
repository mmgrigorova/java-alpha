package com.mmgrigorova.AdvancedExam;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BitNumbers {

    public static void BitConvert() {
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(",");

        ArrayList<List<Character>> convertedNumbers = new ArrayList<>();

        for (String number : input) {
            String binaryNumber = Integer.toBinaryString(Integer.valueOf(number));
            String paddedBinary = "00000000".substring(binaryNumber.length()) + binaryNumber;
            char[] binaryArray = paddedBinary.toCharArray();

            List<Character> num = new ArrayList<>();
            for (Character c : binaryArray) {
                num.add(c);
            }
            convertedNumbers.add(num);
        }

//        for (List<Character> num : convertedNumbers) {
//            System.out.println(num.toString());
//        }

        String result = "";

        for (int i = 0; i < convertedNumbers.size(); i++) {
            ArrayList<Character> shrinkedNumber = new ArrayList<>();
            ArrayList<Character> numberToShrink = (ArrayList<Character>) convertedNumbers.get(i);
            int index;

            if (i % 2 == 0) {
                index = 1;
            } else {
                index = 0;

            }
            while (index < numberToShrink.size()) {
//                shrinkedNumber.add(numberToShrink.get(index));
                result = result + numberToShrink.get(index);
                index += 2;
            }


            //convertedNumbers.add(shrinkedNumber);

        }

        System.out.println(result);
//        for (List<Character> num : convertedNumbers) {
//            System.out.println(num.toString());
//        }

    }

}
