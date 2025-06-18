package com.chandan.API_Testing.forUnitTest;

public class Calculator {
    public int add(int a ,int b){
        return a+b;
    }

    //class_21
    public int subtraction(int a ,int b){
        return a-b;
    }

    public int multiplication(int a ,int b){
        return a*b;
    }

    public int division(int a ,int b){
        if (b==0 ){
            throw  new ArithmeticException("b cant be zero");
        }
        return a/b;
    }

}
