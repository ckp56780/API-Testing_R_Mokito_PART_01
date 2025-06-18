package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//class-26 AfterEach
public class AfterEachTestDemoL_26 {

    private Calculator calculator;



    // @BeforeEach uses
    @BeforeEach
    void setUp(){   //it is used for reusability purpose
        calculator=new Calculator();
        System.out.println("calling before each method");

    }

    //@AfterEach uses-this annotation is basically use to cloe the resource/close the databse connection/close open filed

    @AfterEach
    void tearDown(){
        calculator=null;
        System.out.println("tear down method calling");

    }


    //Calculator calculator=new Calculator();
    @Test
    public void subtraction(){

        int actual = calculator.subtraction(3, 2);
        assertEquals(1,actual);
        System.out.println("subtraction  method calling");

    }

    @Test
    public void multiplication(){

        int actual = calculator.multiplication(3, 2);
        assertEquals(6,actual);
        System.out.println("multiplication method calling");
    }

    @Test
    public void division() {

        int actual = calculator.division(4, 2);
        assertEquals(2,actual);
        System.out.println("division method calling");
    }
}
