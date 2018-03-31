package com.mmgrigorova.Arrays;

import java.util.*;

public class JoroTheRabbitv2 {
    public static void rabbitV2() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();

        String[] path = in.nextLine().split(", ");

        for (String elem : path) {
            array.add(Integer.parseInt(elem));
        }

        int n = array.size();
        int maxRoute = 0;
        int route = 1;

        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int step = 1; step <= n; step++) {
                int currentIndex = startIndex;
                route = 1;

                HashSet<Integer> used = new HashSet<>();

                while (!used.contains(currentIndex)) {
                    used.add(currentIndex);
                    int nextIndex = (currentIndex + step) % n;
                    if (array.get(currentIndex) >= array.get(nextIndex)) {
                        break;
                    }
                    route++;
                    currentIndex = nextIndex;
                }
                maxRoute = Math.max(maxRoute, route);
            }


        }

        System.out.println(maxRoute);
    }
}
