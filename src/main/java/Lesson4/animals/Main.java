package Lesson4.animals;

public class Main {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Бобик");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");

        dog1.run(150);
        dog1.swim(5);

        cat1.run(100);
        cat1.swim(10);

        System.out.println("Животных: " + Animal.animalCount);
        System.out.println("Собак: " + Dog.dogCount);
        System.out.println("Котов: " + Cat.catCount);

        Bowl bowl = new Bowl(20);

        Cat[] cats = {cat1, cat2};

        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        bowl.printFood();

        for (Cat cat : cats) {
            cat.printInfo();
        }

        bowl.addFood(20);
        bowl.printFood();
    }
}