package Lesson5;

public class Main {

    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "abc"} // ошибка здесь
        };

        try {
            int result = ArrayProcessor.processArray(array);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        // Генерация ArrayIndexOutOfBoundsException
        generateArrayIndexError();
    }

    public static void generateArrayIndexError() {
        try {
            int[] arr = new int[3];
            arr[5] = 10; // выход за границы
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
