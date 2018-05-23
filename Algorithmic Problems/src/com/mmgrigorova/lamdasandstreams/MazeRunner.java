package com.mmgrigorova.lamdasandstreams;

import java.util.Scanner;
import java.util.stream.Stream;
public class MazeRunner {
    static String findDirection(String digit) {

       int evensSum =  digit.chars()
                .mapToObj(x -> (char) x)
                .map(Integer::valueOf)
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(evensSum);

        int oddsSum =  digit.chars()
                .mapToObj(x -> (char) x)
                .map(Integer::valueOf)
                .filter(x -> x % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(oddsSum);


        if (evensSum < oddsSum){
            return "right";
        } else if (evensSum > oddsSum){
            return "left";
        } else {
            return "straight";
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stream.generate(in::nextLine)
                .limit(n)
                .map(String::toString)
                .map(MazeRunner::findDirection)
                .forEach(System.out::println);
    }
}
