package com.mmgrigorova.advancedexam;

import java.util.ArrayList;

/**
 * Sum Triangle from Array\
 * https://www.geeksforgeeks.org/sum-triangle-from-array/
 */

public class SumTriangle {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i< arr.length; i++ ){
            a.add( arr[i]);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        result = sumTriangle(a, 0, result);
        result.add(a);

        for(ArrayList res : result){
            System.out.println(res.toString());
        }
    }

    private static ArrayList<ArrayList<Integer>>  sumTriangle(ArrayList<Integer> a,
                                                 int index,
                                                 ArrayList<ArrayList<Integer>> result) {
        if (a.size() == 1 || a.size() == 0 || index == a.size()){
            return result;
        }
        ArrayList<Integer> newArray = new ArrayList<>();

        for (int i = 0; i < a.size()-1; i++) {
            int tempSum = a.get(i) + a.get(i+1);
            newArray.add(tempSum);
        }

        sumTriangle(newArray, index+1, result);
        result.add(newArray);

        return result;
    }
}
