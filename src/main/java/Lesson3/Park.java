package Lesson3;

public class Park {
    public class Attraction {
        String info;
        String workTime;
        int price;

        public Attraction(String info, String workTime, int price) {
            this.info = info;
            this.workTime = workTime;
            this.price = price;
        }
        public void printInfo() {
            System.out.println("Аттракцион: " + info);
            System.out.println("Время работы: " + workTime);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("-----------------------------");
        }
    }
}
