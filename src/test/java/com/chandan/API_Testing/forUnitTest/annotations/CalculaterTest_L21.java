package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculation operation test")
public class CalculaterTest_L21 {

    //create all test method-

    @DisplayName("addition of two number")
    @Test
      void addTest(){
        Calculator calculator=new Calculator();
        int actual = calculator.add(1, 2);
        assertEquals(3,actual);
    }

    @DisplayName("subtraction of two number")
    @Test
    void subTest(){
        Calculator calculator=new Calculator();
        int actual = calculator.subtraction(3, 2);
        assertEquals(1,actual);
    }

    @DisplayName("multiplication of two number")
    @Test
    void multiplicationTest(){
        Calculator calculator=new Calculator();
        int actual = calculator.multiplication(1, 2);
        assertEquals(2,actual);
    }

    @DisplayName("division of two number")
    @Test
    void divisionTest(){
        Calculator calculator=new Calculator();
        int actual = calculator.division(4, 2);
        assertEquals(2,actual);
    }


}
