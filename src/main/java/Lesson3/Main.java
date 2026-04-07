package Lesson3;

public class main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 14 Pro", "15.01.2025",
                "Apple Inc.", "USA", 7499, false);
        productsArray[2] = new Product("Xiaomi Mi 12", "20.12.2024",
                "Xiaomi Corp.", "China", 4299, false);
        productsArray[3] = new Product("Sony Bravia X90", "10.11.2024",
                "Sony Corp.", "Japan", 6599, true);
        productsArray[4] = new Product("Dell Inspiron 15", "05.02.2025",
                "Dell Inc.", "USA", 4999, false);

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println(productsArray[i]);;
        }

        Park myPark = new Park();

        Park.Attraction a1 = myPark.new Attraction("Американские горки", "10:00 - 20:00", 500);
        System.out.println(a1);
    }
}
