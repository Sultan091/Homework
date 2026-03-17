package Lesson4.animals;

public class Bowl {

    private int food;

    public Bowl(int food) {

        this.food = food;
    }

    public boolean takeFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        food += amount;
    }

    public void printFood() {
        System.out.println("Еды в миске: " + food);
    }
}