package org.example.Polymorphism;

public class Cat extends Animal{

    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    public void move() {
        if (! this.name.isEmpty()) {
            System.out.println(this.name + " is moving!");
        }
        else {
            System.out.println("Cats can move");
        }
    }

    public void meow() {
        if (! this.name.isEmpty()) {
            meow(this.name);
        }
        else{
            System.out.println("Cats can meow");
        }
    }

    public void meow(String name) {
        System.out.println(name + " is meowing!");
    }
}
