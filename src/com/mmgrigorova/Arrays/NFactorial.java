package com.mmgrigorova.Arrays;

import java.math.BigInteger;

public class NFactorial {
    public static long nFactorial(int n){
        long result;
        if (n==1){
            result = 1;
        } else if (n==2){
            result = 2;
        }
        else {
            result = n*nFactorial(n-1);
        }
        return result;
    }
}
