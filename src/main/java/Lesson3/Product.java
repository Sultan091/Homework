package Lesson3;

public class Product {
    private String  name;
    private String manufactureDate;
    private String manufacturer;
    private String country;
    private int price;
    private boolean reserved;

    public Product(String name, String manufactureDate, String manufacturer, String country, int price, boolean reserved) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reserved = reserved;
    }

    @Override
    public String toString(){
         return "Название: " + name +
                ", Дата: " + manufactureDate +
                ", Производитель: " + manufacturer +
                ", Страна: " + country +
                ", Цена: " + price +
                ", Забронирован: " + (reserved ? "Да" : "Нет");
    }
}
