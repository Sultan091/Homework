package Lesson3;

public class Product {
    String name;
    String manufactureDate;
    String manufacturer;
    String country;
    int price;
    boolean reserved;

    public Product(String name, String manufactureDate, String manufacturer, String country, int price, boolean reserved) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reserved = reserved;
    }
    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + manufactureDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна: " + country);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Забронирован: " + (reserved ? "Да" : "Нет"));
        System.out.println("-----------------------------");
    }
}
