package Polymorphism;

public class AnimalUtil {
    public void printAnimalName(Animal animal) {
        System.out.println(animal.name);
        animal.move();
    }
}
