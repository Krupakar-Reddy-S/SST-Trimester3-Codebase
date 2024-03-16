package org.example.accessmodifiers2;

import org.example.accessmodifiers.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.name);
        // System.out.println(student.branch); // As branch is private, it cannot be accessed from another class
        // System.out.println(student.age); // As age is default, it cannot be accessed from another package
        // System.out.println(student.psp); // As psp is protected, it cannot be accessed from another package
    }
}
