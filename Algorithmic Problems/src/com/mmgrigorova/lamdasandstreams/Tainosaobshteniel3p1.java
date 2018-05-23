package com.mmgrigorova.lamdasandstreams;

import java.util.Scanner;

public class Tainosaobshteniel3p1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuilder string = new StringBuilder(in.nextLine());

        string.reverse().chars()
                .filter(Character::isLetter)
                .mapToObj(x -> (char) x)
                .forEach(System.out::print);

    }
}
