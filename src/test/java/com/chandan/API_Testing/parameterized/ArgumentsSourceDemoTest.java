package com.chandan.API_Testing.parameterized;

import com.chandan.API_Testing.forUnitTest.MathUtils_33_34;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import  static org.junit.jupiter.api.Assertions.*;

//class-39_2
public class ArgumentsSourceDemoTest {


    //create the test method-
    @ParameterizedTest
    @ArgumentsSource(FactorialArgumentProvider.class)
    void  factorialTest(int number,int expected){
        MathUtils_33_34 mathUtils=new MathUtils_33_34();
        assertEquals(expected,mathUtils.factorial(number));
    }
}
