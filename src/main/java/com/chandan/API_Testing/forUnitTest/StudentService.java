package com.chandan.API_Testing.forUnitTest;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> studentList=new ArrayList<>();

    //create method for get Student
    public List<Student> getStudentList(){
        return this.studentList;

    }

    //add Student
    public void addStudent(Student student){
        studentList.add(student);
    }

}
