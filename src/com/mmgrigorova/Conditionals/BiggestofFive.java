package Conditionals;
import java.util.Scanner;

/**
 * Biggest of Five
 * Write a program that finds the biggest of 5 numbers that are read from the console, using only 5 if statements.
 */

public class BiggestofFive {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        float n1 = in.nextFloat();
        float n2 = in.nextFloat();
        float n3 = in.nextFloat();
        float n4 = in.nextFloat();
        float n5 = in.nextFloat();
        in.close();

        if (n1 >=-200 && n1 <= 200 && n2 >=-200 && n2 <= 200 && n3 >=-200 && n3 <= 200
                && n4 >=-200 && n4 <= 200 && n5 >=-200 && n5 <= 200){
            float result = n5;

            if(n1 >= n2 && n1 >= n3 && n1 >= n4 && n1 >= n5 ){
                result = n1;
            } else if(n2 >= n1 && n2 >= n3 && n2 >= n4 && n2 >= n5){
                result = n2;
            } else if(n3 >= n1 && n3 >= n2 && n3 >= n4 && n3 >= n5){
                result = n3;
            } else if(n4 >= n1 && n4 >= n2 && n4 >= n3 && n4 >= n5){
                result = n4;
            }


            if(result == (int)result){
                System.out.println((int) result);
            } else {
                 System.out.println(result);
            }
            
        }

    }
}

