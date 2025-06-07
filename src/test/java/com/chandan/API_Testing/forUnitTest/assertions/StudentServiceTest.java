package com.chandan.API_Testing.forUnitTest.assertions;

import com.chandan.API_Testing.forUnitTest.Student;
import com.chandan.API_Testing.forUnitTest.StudentService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    //create the test method for get Student
    public void getStudentTest(){
        StudentService studentService=new StudentService();
        //Student student=new Student(1,"chandan");
        List<Student> studentList = studentService.getStudentList();

        //add
        //studentService.addStudent(student); //then assertTrue will throw false.

        boolean actualResult = studentList.isEmpty();

        //
       // assertTrue(actualResult);

        //boolean supplier funtional interface
        //assertTrue(()-> actualResult); //if any student exists, then it will fail other wise
        //if not added any student in the list then it will give the result the true bcs it si empty list.

        ////boolean supplier funtional interface and message
        //assertTrue(()->actualResult,"list is empty");

        //assertTrue(actualResult,"list is empty");

        //assertTrue(actualResult,()->"student list is empty");

        assertTrue(()->actualResult,()->"student list is empty");
    }


    //create assert false method to test the false asssertion
    @Test
    public void getStudentFalseMethod(){
        StudentService studentService=new StudentService();
        Student student=new Student(1,"chandan");

        List<Student> list = studentService.getStudentList();

        //add
        studentService.addStudent(student);

        boolean actualResult = list.isEmpty();

        //boolean condtion
        assertFalse(actualResult); //if we add student then it will pass

        assertFalse(actualResult,"student list is not been empty");
        assertFalse(()->actualResult,"list is not been empty");
        assertFalse(()-> actualResult,()->"list not been empty");
        assertFalse(actualResult,()->"not to be empty");
        //assertFalse(()->"list not to empty");//we can defined this way
        assertFalse(()->actualResult);
    }
}