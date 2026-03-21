package Lesson6.Phonebook;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "111-111");
        phoneBook.add("Иванов", "222-222");
        phoneBook.add("Петров", "333-333");
        phoneBook.add("Сидоров", "444-444");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Смирнов: " + phoneBook.get("Смирнов")); // нет записей
    }
}