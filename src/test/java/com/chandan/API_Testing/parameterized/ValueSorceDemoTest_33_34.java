package com.chandan.API_Testing.parameterized;

import com.chandan.API_Testing.forUnitTest.MathUtils_33_34;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
//vvi section--read more
public class ValueSorceDemoTest_33_34 {


    @ParameterizedTest
    @ValueSource(ints = {2,4,6,7,10})
    void isEvenTest(int number){

        MathUtils_33_34 mathUtils=new MathUtils_33_34(); //creating object
        assertTrue(mathUtils.evenMethod(number));


        //assertTrue(mathUtils.evenMethod(2));//it is true
        //assertTrue(mathUtils.evenMethod(4));
       // assertTrue(mathUtils.evenMethod(9));//it will fail and all test case will fail
        //assertTrue(mathUtils.evenMethod(10));
        //assertTrue(mathUtils.evenMethod(12));

        //summery:-if we have to test some number that is basically even or not then we
        //need to write the above assertTrue method to check 100 number at 100 times due to which we will use
        //@Parametrized annotation to skip 100 lines of code
        //and if any odd number comes, then from starting to last all test cases will also get  failed
        //instead of above all we can use-
        // @ParameterizedTest
        //    @ValueSource(ints = {2,4,6,7,10})

    }

    //use of valueSource
    @ParameterizedTest
    @ValueSource(strings = {"chandan","parametrized","shweta","balakrishna","1"})
    public void valueSource(String parameter){
        assertNotNull(parameter);

    }
}
