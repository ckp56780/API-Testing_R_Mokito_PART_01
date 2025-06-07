package com.chandan.API_Testing.forUnitTest;

public class Student {
    private  int id;
    private String name;

    //constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //getter and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
