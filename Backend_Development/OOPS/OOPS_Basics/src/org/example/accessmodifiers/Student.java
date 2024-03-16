package org.example.accessmodifiers;

public class Student {
    public String name;
    int age;
    private String branch;
    protected double psp;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
