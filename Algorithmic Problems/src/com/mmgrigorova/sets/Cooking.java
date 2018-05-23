package com.mmgrigorova.sets;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Cooking
 * http://judge.telerikacademy.com/problem/01cooking
 */

public class Cooking {
    static void fakeInput() {
        String test = "2\n" +
                "1:cups:Sugar\n" +
                "1.006:ls:Old milK\n" +
                "2\n" +
                "800:mls:old MILK\n" +
                "1.5:cups:sugar";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int recipeLines = in.nextInt();

        Map<String, Ingredient> recipe = new HashMap<String, Ingredient>();

        for (int i = 0; i < recipeLines; i++) {
            String[] recipeLine = in.nextLine().split(":");
            String key = recipeLine[2].toLowerCase();
            double quantity = Double.parseDouble(recipeLine[0]);
            String measurement = recipeLine[1];
            String ingredientName = recipeLine[2];

            Ingredient ingredient = new Ingredient(quantity, measurement, ingredientName);

        }

        Ingredient n = new Ingredient(1.05, "ls", "SuGar");

        System.out.println(n);


    }

    private static class Ingredient{
        private double quantity;
        private String measurement;
        private String ingredientName;

        public Ingredient(double quantity, String measurement, String ingredientName){
            this.quantity = quantity;
            this.measurement = measurement;
            this.ingredientName = ingredientName;
        }

        @Override
        public String toString() {
            return String.format("%.2f:%s:%s",quantity,measurement,ingredientName);
        }
    }
}
