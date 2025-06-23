package com.chandan.API_Testing.parameterized;

import com.chandan.API_Testing.forUnitTest.MathUtils_33_34;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//L-37
public class MethodSourceDemoTest {


    @ParameterizedTest
    @MethodSource("argumentsProviders")
    void factorialTest(int number, int expected){
        MathUtils_33_34 mathUtils=new MathUtils_33_34();

        assertEquals(expected,mathUtils.factorial(number));
    }

    //Factory method
    static Stream<Arguments> argumentsProviders(){
        return Stream.of(
                Arguments.arguments(0,1),
                Arguments.arguments(1,1),
                Arguments.arguments(2,2),
                Arguments.arguments(3,6),
                Arguments.arguments(4,24),
                Arguments.arguments(5,120)

        );
    }
}
