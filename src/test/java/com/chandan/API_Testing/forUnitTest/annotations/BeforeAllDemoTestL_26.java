package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//L-26
public class BeforeAllDemoTestL_26 {

    private static Calculator calculator;  //this should be also static


    @BeforeAll  //it will execute at once
    static void setUpBeforeAll(){ //here @BeforeAll method should be static,
        //this method is basically creating for the connection of database or instantiated the variable which need into all test methods at once
        calculator=new Calculator();
        System.out.println("calling beforeAll method once");

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
