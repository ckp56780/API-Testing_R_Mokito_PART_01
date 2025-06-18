package com.chandan.API_Testing.forUnitTest;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class StudentService {

    //create method for get Student
    private final List<Student> studentList=new ArrayList<>();

    //get all students
    public List<Student> getStudent(){
        return this.studentList;
    }
    //add Student
    public void addStudent(Student student){
        studentList.add(student);
    }

    //get student by ID
    public  Student getStudentById(int studentId){
        return studentList.stream()
                .filter(student -> student.getId()==studentId)
                .findFirst().orElse(null);
    }

    //get student name by department
    public String[] getStudentNameBydepartment(String department) {
        return studentList.stream()
                .filter(student -> student.getDepartment().equals(department))
                .map(Student::getName)
                .toArray(String[]::new);
    }

    //get student name by Id
    public  Integer[] getStudentIdsByDepartment(String department){
        return studentList.stream()
                .filter(student -> student.getDepartment().equals(department))
                .map(Student::getId)
                .toArray(Integer[]::new);
    }



    //Lecture-19-by ramesh fadatare videos on udemy
    //get student name list by department method
    public List<String> getStudentNameListBydepartment(String department) {
        return studentList.stream()
                .filter(student -> student.getDepartment().equals(department))
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    //get student name list by id
    public  List<Integer> getStudentIdsNameByDepartment(String department){
        return studentList.stream()
                .filter(student -> student.getDepartment().equals(department))
                .map(Student::getId)
                .collect(Collectors.toList());
    }

    //lecture-20
    public Student getStudentByName(String name){
        return studentList.stream()
                .filter((student)->student.getName().equals(name))
                .findFirst()
                .orElseThrow(()->new StudentNotFoundException_20("student not found with name"+name));
    }

}
