package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Calculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//class_21
public class DisabledCalculatorTest {

    Calculator calculator=new Calculator();
    @Test
    public void subtraction(){
        int actual = calculator.subtraction(3, 2);
        assertEquals(1,actual);

    }

    @Disabled("disabled till fix the bugs #2")  //any name can put here
    @Test
    public void multiplication(){
        int actual = calculator.multiplication(3, 2);
        assertEquals(6,actual);
    }

    @Test
    public void division() {
        int actual = calculator.division(4, 2);
        assertEquals(2,actual);
    }
}
