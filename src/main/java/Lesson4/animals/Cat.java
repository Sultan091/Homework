package Lesson4.animals;

public class Cat extends Animal {

    public static int catCount = 0;
    private boolean full;

    public Cat(String name) {
        super(name, 200, 0);
        this.full = false;
        catCount++;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.takeFood(foodAmount)) {
            full = true;
            System.out.println(name + " поел.");
        } else {
            System.out.println(name + " не смог поесть. Мало еды.");
        }
    }

    public void printInfo() {
        System.out.println(name + " сытость: " + full);
    }
}