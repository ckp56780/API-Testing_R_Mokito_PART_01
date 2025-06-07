package com.chandan.API_Testing.forUnitTest;

public class Factorial {


    //create method
    public int factorial(int number){
        int factorial=1;
        for (int i = 1; i <=number ; i++) {
            factorial=factorial*i;
        }
        return factorial;
    }
}
