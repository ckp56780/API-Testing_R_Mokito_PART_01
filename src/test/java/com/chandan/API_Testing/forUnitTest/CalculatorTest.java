package com.chandan.API_Testing.forUnitTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void addTest(){
        Calculator calculator=new Calculator();
        int actualResult = calculator.add(10, 20);  //actual result and expected should be equal
        assertEquals(actualResult,30); //expected-means what we are expecting

    }

}