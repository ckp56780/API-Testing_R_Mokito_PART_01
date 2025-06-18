package com.chandan.API_Testing.forUnitTest.assertions;

import com.chandan.API_Testing.forUnitTest.Student;
import com.chandan.API_Testing.forUnitTest.StudentNotFoundException_20;
import com.chandan.API_Testing.forUnitTest.StudentService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    //create the test method for get Student
    public void getStudentTest(){
        StudentService studentService=new StudentService();

        //here we will add the student and then will chechk the assertTrue weather false or true
        //Student student=new Student(1,"chandan");

        //add students
        //studentService.addStudent(student); //then assertTrue will throw false.
        List<Student> studentList = studentService.getStudentList();  //create local variable



        boolean actualResult = studentList.isEmpty();


        //assertTrue(actualResult);  //expecting true but was false after adding the student

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
    public void getStudentFalseMethodUsingAssertFalse(){
        StudentService studentService=new StudentService();
        Student student=new Student(1,"chandan");

        List<Student> list = studentService.getStudentList();


        //add
        studentService.addStudent(student);

        boolean actualResult = list.isEmpty();

        //boolean condtion
        assertFalse(actualResult); //if we add student then it will pass bcs without adding student it was true but aspecting is false

        assertFalse(actualResult,"student list is not been empty");
        assertFalse(()->actualResult,"list is not been empty");
        assertFalse(()-> actualResult,()->"list not been empty");
        assertFalse(actualResult,()->"not to be empty");
        //assertFalse(()->"list not to empty");//we can defined this way
        assertFalse(()->actualResult);
    }

    //test case for get student by id
    @Test
    public  void  getStudentByIdTestUsingAssertNull(){

        //create StudentService  object
        StudentService studentService=new StudentService();


        //adding student
        Student student1=new Student(1,"chandan");
        studentService.addStudent(student1);
        Student actualObject = studentService.getStudentById(1); //IT WILL RETURN FALSE BCS WE ARE ASPECTING NULL BUT WAS 1 IN LIST
        //Student actualObject = studentService.getStudentById(2); //It will return true bcs id 2 will not exist in the list which will be null and aspecting null then it will pass

        //assert method-1
        //assertNull(actualObject);

        //assert method-2- which will take parameter 2
        //assertNull(actualObject,"id should not be null");

        //  //assert method-3- which will take parameter 2
        assertNull(actualObject,()->"id should not be null");
    }

    //test case for get student by id with assertion assertNotNull method
    @Test
    public  void  getStudentByIdTestUsingAssertNotNull() {

        //create StudentService  object
        StudentService studentService = new StudentService();


        //adding student
        Student student1 = new Student(1, "chandan");
        studentService.addStudent(student1);
        //Student actualObject = studentService.getStudentById(1); //IT WILL RETURN ture BCS WE ARE ASPECTING not null bcs it 1 IN LIST
        Student actualObject = studentService.getStudentById(1); //It will return false bcs id 2 will not exist in the list which will be  null and aspecting Not null then it will fail

        //assert method-1
        //assertNotNull(actualObject);

        //assert method-2- which will take parameter 2
        //assertNotNull(actualObject,"id is null"); //if use 1 then it will pass bcs this id is exits intot he list but if we put the 2 will fail bcs itis not exist
        //into the list which is null but aspecting should not null so test will fail

        // assert method-3- which will take parameter 2
        assertNotNull(actualObject,()->"student is null");

    }

    @Test
    public  void  getStudentByIdUsingAsserEqual(){

        //created studentService Class
        StudentService studentService=new StudentService();

        //create Student Object to add


        Student student=new Student(1,"chandan");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);


        //calling the comparing assertion method-1
        //assertEquals(2,actualObject.getId()); //if we use except 1 then it will fail bcs only 1 store into list as an id-1
        //if it will be 1 then the above test case will pass.

        //another method-2
        //assertEquals("chandan",actualObject.getName());



        //comparing the objects
        //assertEquals(student,actualObject);  //actual== expected



        //another method-3 which will take three argument
        //assertEquals(1,actualObject.getId(),"is should not be null");
        //if above method we will expect 2 then the test case will fail and give the error message like --it should not be null

        //another method which will also take three parameter
        assertEquals("chandan1",actualObject.getName(),()->"student name not matched with given arraylist");
    }



    @Test
    public  void  getStudentByIdUsingAsserNotEqual(){

        //created studentService Class
        StudentService studentService=new StudentService();

        //create Student Object to add


        Student student=new Student(1,"chandan");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);


        //calling the comparing assertion method-1
        //assertNotEquals(2, actualObject.getId()); //if we use except 1 then it will pass bcs only 1 store into list as an id-1
        //if it will use 1 then the above test case will fail.

        //another method-2
        //assertNotEquals("chandan1",actualObject.getName());



        //comparing the objects
        //assertNotEquals(student,actualObject);  //actual != expected then it will pass but here it is true thty it is failing



        //another method-3 which will take three argument
        //assertNotEquals(2,actualObject.getId(),"is should  be null");
        //if above method we will expect 1 then the test case will pass  and if it will be 1 then it will fail and show message like-it should  be null

        //another method which will also take three parameter
        assertNotEquals("chandan1",actualObject.getName(),()->"student name  matched with given arraylist");
    }

    @Test
   public void getStudentNameBydepartmentTestUsingAssertArrayEqual() {

        //create object
        StudentService studentService=new StudentService();

        //create student
        Student student1=new Student(1,"chandan","science");
        Student student2=new Student(2,"ramesh","science");
        Student student3=new Student(3,"umesh","commerce");

        //add student
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);

        String[] actualObjectArray = studentService.getStudentNameBydepartment("science");
        String[] expectedArray={"chandan","ramesh"};
        //assertArrayEquals(expectedArray,actualObjectArray);

        //assertArrayEquals(expectedArray,actualObjectArray,"student name is not differ");
        //"chandan","ramesh" then the above test case will pass else it will fail
        //"chandan","ramesh","umesh"-it will fail


       // assertArrayEquals(expectedArray,actualObjectArray,()->"student name should not be equal");


        //get student name by id
        Integer[] actualStudentIDs = studentService.getStudentIdsByDepartment("science");
        Integer[] expectedAStudentIDs={1,2};  //{1,2,3};

        //assertArrayEquals(actualStudentIDs,expectedAStudentIDs);


        //assertArrayEquals(actualStudentIDs,expectedAStudentIDs,"Student ids are not equal");


       assertArrayEquals(actualStudentIDs,expectedAStudentIDs,()->"student ids are not equal");
        //{1,2,3} --if we take then it will face with a custom message
    }


    //Lecture-19-by ramesh fadatare videos on udemy
    @Test
    public void getStudentNameListBydepartmentTestUsingAsserIterableEqual() {
        //create object
        StudentService studentService=new StudentService();

        //create student
        Student student1=new Student(1,"chandan","science");
        Student student2=new Student(2,"ramesh","science");
        Student student3=new Student(3,"umesh","commerce");
        //add student
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);

        //use assertion
        List<String> actualStudentNameList = studentService.getStudentNameListBydepartment("science");
        List<String> expectedStudentNameList = Arrays.asList("chandan","ramesh");
        //assertIterableEquals(actualStudentNameList,expectedStudentNameList); //it will true-// List<String> expectedStudentNameList = Arrays.asList("chandan","ramesh","ram);-if we add then another rest test will fail

        //another method-2
       // assertIterableEquals(actualStudentNameList,expectedStudentNameList,"name should not equal");
       // List<String> expectedStudentNameList = Arrays.asList("chandan","ramesh","ram); //it will fail

        //another method-3
        //assertIterableEquals(actualStudentNameList,expectedStudentNameList,()->"student name list not  equal");
       // List<String> expectedStudentNameList = Arrays.asList("chandan","ramesh","ram); //it will fail






        //this below method for test the  --getStudentIdsNameByDepartment
        //here we can write the test case for another method-getStudentIdsNameByDepartment

        List<Integer> actualStudentIdList = Arrays.asList(1, 2,3);
        List<Integer> expectedStudentIdList = studentService.getStudentIdsNameByDepartment("science"); //it will pass if {1,2} will give but if {1,2,3} will give then below all test case will fail with message

        //assertion
        //assertIterableEquals(actualStudentIdList,expectedStudentIdList);

        //assertion-2
        //assertIterableEquals(actualStudentIdList,expectedStudentIdList,"student id list is not equal");
       // List<Integer> actualStudentIdList = Arrays.asList(1, 2,3);

        //assertion-3
        assertIterableEquals(actualStudentIdList,expectedStudentIdList,()-> "student id list is not equal");
        // List<Integer> actualStudentIdList = Arrays.asList(1, 2,3);


    }

    //LECTURE-20--get student by name test method-getStudentByName
    @Test
    public void getStudentByNameTestMethodByAssertThrow(){


        //create object to add into list
        StudentService studentService=new StudentService();

        //add student into the list with above reference object
        Student student=new Student(1,"chandan","science");
        studentService.addStudent(student);

        //use assertion to compare
//        assertThrows(StudentNotFoundException_20.class,()-> {
//            studentService.getStudentByName("chandan1");  //it will pass but chandan will give then wit will fail
//
//        }); //it will fail


        //assertion method-2
        assertThrows(StudentNotFoundException_20.class,()-> {
            studentService.getStudentByName("chandan1"); //it will pass but chandan will give then wit will fail

        } ,"studentNotFound should be throw but it was not");



        //assertion method-3
//        assertThrows(StudentNotFoundException_20.class,()-> {
//            studentService.getStudentByName("chandan1"); //it will pass but chandan will give then wit will fail
//
//        } ,()->"studentNotFound should be throw but it wasn't");
    }

   // lecture-21 //assertThrowExactly method
   @Test
   public void getStudentByNameTestMethodByAssertThrowExactly() {


       //create object to add into list
       StudentService studentService = new StudentService();

       //add student into the list with above reference object
       Student student = new Student(1, "chandan", "science");
       studentService.addStudent(student);

       //use assertion to compare
       //assertThrowsExactly(StudentNotFoundException_20.class, () -> studentService.getStudentByName("ankit")); //StudentNotFoundException_20 --in the place of this we cant use the runtimeexception due to it is not following the Inheritance

       //assertThrowsExactly(StudentNotFoundException_20.class, () -> studentService.getStudentByName("ankit"),"StudentNotFoundShouldThrown but it wasn't");

       assertThrowsExactly(StudentNotFoundException_20.class, () -> studentService.getStudentByName("ankit"),()->"StudentNotFoundShouldThrown but it wasn't");
   }

}