package com.chandan.API_Testing.parameterized;

import com.chandan.API_Testing.forUnitTest.MathUtils_33_34;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CsvSourceDemoTest {


    //create that test method which we need to test it
    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,1",
            "2,2",
            "3,6",
            "4,24",
            "5,121"}
    )
    void factorialTest(int number, int expected){
        MathUtils_33_34 mathUtils=new MathUtils_33_34();
        assertEquals(expected,mathUtils.factorial(number));

    }
}
