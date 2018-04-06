package com.mmgrigorova.Arrays;

public class ReverseString {
    public static String stringReverse(String str){
        if (str.length() == 0){
            return str;
        }

        return stringReverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String reverse = stringReverse("maratonka");
        System.out.println(reverse);
    }
}
