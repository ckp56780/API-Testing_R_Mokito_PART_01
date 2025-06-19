package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Calculator;
import org.junit.jupiter.api.*;

import  static org.junit.jupiter.api.Assertions.*;

public class RepeatedTestDemoTest_L29 {

    //life cycle of the all @RepeatedTest
    //setup method
    @BeforeEach
    void  setupBeforeEachTest(){
        System.out.println("setup method is calling");
    }

    //tearDown method
    @AfterEach
    void  setupAfterEachTest(){
        System.out.println("tearDown method is calling");
    }

    //beforeAll method
    @BeforeAll
   static void  setupBeforeAllTest(){
        System.out.println("before all method is calling");
    }


    //AfterAll method
    @AfterAll
    static void  tearDownAfterAllTest(){
        System.out.println("after all method is calling");
    }



    //create a add method test
    //@Test
    //@RepeatedTest(5)
    //or
    @RepeatedTest(value = 5,name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Test is running repeatedly")
    void  addTest(){
        Calculator calculator=new Calculator();
        int actual = calculator.add(1, 3);
        assertEquals(4,actual);
        System.out.println("add test method is calling");
    }
}
