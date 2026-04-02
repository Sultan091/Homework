package Lesson3;

public class Park {
    public class Attraction {
        private String info;
        private String workTime;
        private int price;

        public Attraction(String info, String workTime, int price) {
            this.info = info;
            this.workTime = workTime;
            this.price = price;
        }

    @Override
        public String toString(){
            return info + " | " + workTime + " | " + price + " руб.";
        }
    }
}
