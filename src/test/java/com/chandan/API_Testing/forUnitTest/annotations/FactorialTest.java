package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {  //should be public, default but not be protected


    @Test
    protected void factorialTest(){ //should be public, default and protected
        Factorial factorial=new Factorial();
        int actualValue = factorial.factorial(5);
        //assertEquals(120,actualValue);
        assertEquals(120,actualValue);

    }

}