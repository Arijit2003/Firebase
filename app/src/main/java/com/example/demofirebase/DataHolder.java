package com.example.demofirebase;

public class DataHolder {
    String Name;
    String Course;
    String CGPA;

    public DataHolder(String name, String course, String CGPA) {
        this.Name = name;
        this.Course = course;
        this.CGPA = CGPA;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        this.Course = course;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }
}
