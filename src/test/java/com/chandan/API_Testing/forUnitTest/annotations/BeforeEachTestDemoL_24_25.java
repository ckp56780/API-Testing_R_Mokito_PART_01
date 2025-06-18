package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//class-24-25-beforeEach- he we will use this method for the run the common code or
//use the common code to run before each method.
public class BeforeEachTestDemoL_24_25 {

    private Calculator calculator;

    //here we can add the setup method-
//    Calculator setUp(){
//        Calculator calculator=new Calculator();
//        return calculator;
//    }

    //instead of the above we can use the @BeforeEach
    @BeforeEach
    void setUp(){
        calculator=new Calculator();
        System.out.println("calling before each method");

    }


    //Calculator calculator=new Calculator();
    @Test
    public void subtraction(){
//        Calculator calculator=setUp();
        int actual = calculator.subtraction(3, 2);
        assertEquals(1,actual);
        System.out.println("subtraction before each method");

    }

    @Test
    public void multiplication(){
//        Calculator calculator=setUp();
        int actual = calculator.multiplication(3, 2);
        assertEquals(6,actual);
        System.out.println("multiplication before each method");
    }

    @Test
    public void division() {
//        Calculator calculator=setUp();
        int actual = calculator.division(4, 2);
        assertEquals(2,actual);
        System.out.println("division before each method");
    }
}
