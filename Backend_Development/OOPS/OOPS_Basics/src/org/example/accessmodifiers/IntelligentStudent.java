package org.example.accessmodifiers;

public class IntelligentStudent extends Student {
    int IQ;
    public IntelligentStudent() {
        super();
    }

    public IntelligentStudent(String name, int age) {
        super(name, age);
        this.IQ = 100;
    }
}
