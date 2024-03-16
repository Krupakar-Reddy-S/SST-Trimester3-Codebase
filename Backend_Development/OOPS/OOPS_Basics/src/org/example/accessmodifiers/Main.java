package org.example.accessmodifiers;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.name);
        System.out.println(student.age);
        // System.out.println(student.branch); // As branch is private, it cannot be accessed from another class
        System.out.println(student.psp);
        System.out.println();
        // System.out.println("DEBUG");

        Student student2 = new Student("John", 20);
        System.out.println(student2.name);
        System.out.println(student2.age);
        // System.out.println(student2.branch); // As branch is private, it cannot be accessed from another class
        System.out.println(student2.psp); // Since psp is not given a value in the constructor, it will be 0.0
        System.out.println();

        IntelligentStudent intelligentStudent = new IntelligentStudent("SRK", 25);
        System.out.println(intelligentStudent.name);
        System.out.println(intelligentStudent.age);
        // System.out.println(intelligentStudent.branch); // As branch is private, it cannot be accessed from another class
        System.out.println(intelligentStudent.psp);
        System.out.println(intelligentStudent.IQ);
        System.out.println();
    }
}
