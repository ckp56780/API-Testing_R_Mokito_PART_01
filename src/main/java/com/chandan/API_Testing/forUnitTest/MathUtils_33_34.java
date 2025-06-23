package com.chandan.API_Testing.forUnitTest;

public class MathUtils_33_34 {

    public boolean evenMethod(int number){
        return number%2==0;
    }

    //class-35--vvi
    public boolean isweekDayOrNot(Days day){
        return day!=Days.SATURDAY && day!=Days.SUNDAY;
    }

    ////class-36--@CsvSource annotation --we will use this annotation into test
    public long factorial(int number){
        int result=1;
        for (int i = 1; i <=number; i++) {
            result=result*i;
        }
        return result;
    }
}
