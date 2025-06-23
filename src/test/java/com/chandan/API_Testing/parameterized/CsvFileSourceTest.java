package com.chandan.API_Testing.parameterized;

import com.chandan.API_Testing.forUnitTest.MathUtils_33_34;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//class-37
public class CsvFileSourceTest {

    //create that test method which we need to test it
    @ParameterizedTest
   @CsvFileSource(resources = "/factorial_data.csv")
    void factorialTestUsingCsvFileSource(int number, int expected){
        MathUtils_33_34 mathUtils=new MathUtils_33_34();
        assertEquals(expected,mathUtils.factorial(number));

    }
}
