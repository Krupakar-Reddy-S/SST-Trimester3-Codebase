package Polymorphism;

public class Animal {
    String name;

    public Animal(){
        this.name = "";
    }

    public Animal(String name) {
        this.name = name;
    }

    public void move() {
        if (! this.name.isEmpty()) {
            System.out.println(this.name + " is moving!");
        }
        else{
            System.out.println("Animals can move");
        }
    }
}
