package com.chandan.API_Testing.parameterized;

import com.chandan.API_Testing.forUnitTest.Days;
import com.chandan.API_Testing.forUnitTest.MathUtils_33_34;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import  static org.junit.jupiter.api.Assertions.*;



//class-35-vvi
public class enumSourceDemoTest {


    //create the test method
    @ParameterizedTest
    @EnumSource(value = Days.class,names = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"})
    void  isWeeekDaysOrNot(Days day){
        MathUtils_33_34 mathUtils=new MathUtils_33_34();
        assertTrue(mathUtils.isweekDayOrNot(day));
        //SO HERE SATURDAY IS NOT WEEK DAY-THAT'S-WHY IT IS GETTING FAILED

    }

}
