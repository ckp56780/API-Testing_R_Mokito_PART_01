package com.chandan.API_Testing.forUnitTest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private  int id;
    private String name;
    private String department;

    //constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Student(int id, String name,String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    //getter and setters

}
