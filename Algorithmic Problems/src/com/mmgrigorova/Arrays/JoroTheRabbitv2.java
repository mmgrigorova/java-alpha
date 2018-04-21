package com.mmgrigorova.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Joro The Rabbit
 * http://judge.telerikacademy.com/problem/22jorotherabbit
 */

public class JoroTheRabbitv2 {
    public static void rabbitV2() {
        Scanner in = new Scanner(System.in);

        String[] path = in.nextLine().split(", ");
        ArrayList<Integer> array = new ArrayList<>(path.length);

        for (String elem : path) {
            array.add(Integer.parseInt(elem));
        }

        int n = array.size();
        int maxRoute = 0;
        int route = 1;


        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int step = 1; step < n; step++) {
                int currentIndex = startIndex;
                route = 1;
                boolean hasNext = true;

                while (hasNext) {
                    int nextIndex = (currentIndex + step) % n;
                    if (array.get(currentIndex) >= array.get(nextIndex)) {
                        hasNext = false;
                        break;
                    } else {
                        route++;
                        currentIndex = nextIndex;
                    }

                }
                maxRoute = Math.max(maxRoute, route);
            }


        }

        System.out.println(maxRoute);
    }
    public static void main(String[] args) {
        JoroTheRabbitv2.rabbitV2();
        //Indices.indices();
    }
}
