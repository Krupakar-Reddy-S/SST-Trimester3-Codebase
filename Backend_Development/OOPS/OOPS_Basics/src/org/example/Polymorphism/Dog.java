package org.example.Polymorphism;

public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    public void move() {
        if (! this.name.isEmpty()) {
            System.out.println(this.name + " is moving!");
        }
        else {
            System.out.println("Dogs can move");
        }
    }

    public void bark() {
        if (! this.name.isEmpty()) {
            bark(this.name);
        }
        else {
            System.out.println("Dogs can bark");
        }
    }

    public void bark(String name) {
        System.out.println(name + " is barking!");
    }
}
