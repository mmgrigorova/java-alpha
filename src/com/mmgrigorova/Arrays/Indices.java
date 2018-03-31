package com.mmgrigorova.Arrays;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Indices {
    static void fakeInput(){
        String test = "6\n" +
                "1 2 3 5 7 8";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void indices(){

        fakeInput();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String input = in.nextLine();

        String[] numbersString = input.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String numberString : numbersString){
            numbers.add(Integer.parseInt(numberString));
        }

        int index = 0;
        ArrayList<Integer> result = new ArrayList<>();
        boolean hasLoop = false;

        while(0 <= index &&
                index < numbers.size()
                ){
            if(!result.contains(index)){

            }
            if(hasLoop){
                System.out.println("Loop");
                String toPrint = "";
                for (int i = 0; i < result.size(); i++) {
                    if(i == index){
                        toPrint += "(";
                    }else{
                        toPrint += "";
                    }
                    toPrint += " " + result.get(i);
                }
            }
            result.add(index);
            index = numbers.get(index);
        }

        String toPrint = result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(toPrint);
    }
}
