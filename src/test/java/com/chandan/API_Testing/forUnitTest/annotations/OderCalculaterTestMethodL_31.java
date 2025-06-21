package com.chandan.API_Testing.forUnitTest.annotations;

import com.chandan.API_Testing.forUnitTest.Calculator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
//HERE IN THIS LECTURE WE CAN MAINTAIN THE ORDER OF THEIR TEST METHOD
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OderCalculaterTestMethodL_31 {

    //add
    @Order(1)
    @Test
    public  void add(){
        Calculator calculator=new Calculator();
        assertEquals(7,calculator.add(3,4));

    }
    //subtract
    @Order(2)
    @Test
    public  void subtract(){
        Calculator calculator=new Calculator();
        assertEquals(2,calculator.subtraction(4,2));

    }
    //multiply
    @Order(3)
    @Test
    public  void multiply(){
        Calculator calculator=new Calculator();
        assertEquals(12,calculator.multiplication(3,4));

    }
    //divide
    @Order(4)
    @Test
    public  void divide(){
        Calculator calculator=new Calculator();
        assertEquals(2,calculator.division(4,2));

    }

}
