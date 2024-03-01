package Polymorphism;

public class Client {
    public static void main(String[] args) {
        Animal a = new Animal("SRK");
        a.move();
        // The following line will not compile as the method bark() is not defined in the Animal class
        // a.bark();

        AnimalUtil animalUtil = new AnimalUtil();
        animalUtil.printAnimalName(a);

        Animal d = new Dog();
        d.move();
        // The following line will not compile as the method bark() is not defined in the Animal class
        // d.bark();

        Dog dog = new Dog("Snoop");
        dog.bark();
        animalUtil.printAnimalName(dog);


        Cat cat = new Cat("Deepak");
        cat.meow();


    }
}
