package Arrays;

import java.util.Scanner;

public class ThreeGroups {
    public static void threeGroups(){
        Scanner in = new Scanner(System.in);
        String array  = in.nextLine();
        int[] arr = new int[array.length()];
        String[] arraySplit = intString.split(" ");

        for (int i = 0; i<array.length(); i++){
            arr[i] = Integer.parseInt(arraySplit[i]);
        }


    }
}
