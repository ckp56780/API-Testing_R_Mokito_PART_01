package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*; //always should be static
import org.junit.jupiter.api.Test;

public class NestedTestAnnotationL_30 {

    //created instance for reusability purpose
    private Calculator calculator;

    //create the setup method which will run every time before each method
    @BeforeEach
    void setUp(){
        calculator=new Calculator();
    }

    //create the Nested class-to combine all addition tests here
    @Nested
     class AdditionAllScenariosTest {


        //create add test positive number
        @Test
        public void addTestPositiveNumber(){
            assertEquals(7,calculator.add(3,4));
        }

        //create add test positive & negative number
        @Test
        public void addTestPositiveAndNegativeNumber(){
            assertEquals(1,calculator.add(4,-3));
        }

        //create add test negative and negative number
        @Test
        public void addTestNegativeAndNegativeNumber(){
            assertEquals(-7,calculator.add(-3,-4));
        }

    }

    //create the Nested class-to combine all Negative tests here
    @Nested
    class SubtractionAllScenariosTest {

        //create subtraction of test positive number
        @Test
        public void subtractTestPositiveNumber(){
            assertEquals(1,calculator.subtraction(4,3));
        }

        //create subtraction of test large to small number
        @Test
        public void subtractTestLargeToSmallerNumber(){
            assertEquals(-4,calculator.subtraction(3,7));
        }

        //create the inner Nested clas
        @Nested
        class EdgeCases_innerclass {

            //create subtraction of test with zero
            @Test
            public void subtractTestByZeroNumber(){
                assertEquals(4,calculator.subtraction(4,0));
            }

            //create subtraction of test subtract itself
            @Test
            public void subtractTestItSelfNumber(){
                assertEquals(0,calculator.subtraction(3,3));
            }
        }


    }
}
