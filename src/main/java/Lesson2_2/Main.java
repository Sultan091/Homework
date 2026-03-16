package Lesson2_2;

public class Main {
    public static void main(String[] args) {
        System.out.print("1) "); printThreeWords();
        System.out.print("2) "); checkSumSign();
        System.out.print("3) "); printColor();
        System.out.print("4) "); compareNumbers();
        System.out.println("5) " + twoNumbers(5, 6));
        System.out.print("6) "); code(-4);
        System.out.println("7) " + number(3));
        System.out.print("8) "); printString("Hello", 3);
        System.out.println("9) " + yearLeap(2026));
        System.out.print("10) "); massive();
        System.out.print("11) "); longMassive();
        System.out.print("12) "); multiplyNumbers();
        System.out.println("13) "); diagonalMassive();
        System.out.print("14) "); valueLen(4, 7);

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 4;
        int b = -5;

        if (a + b >= 0){
            System.out.println("Сумма положительная");}
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 101;
        if (value <= 0){
            System.out.println("Красный");
        }else if (value > 0 && value <= 100){
            System.out.println("Желтый");
        }else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 4;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean twoNumbers(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void code (int a) {
        if (a >= 0 ) {
            System.out.println("Число положительное");
        }else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean number (int a) {
        if (a < 0 ){
        return true;
        } else {
            return false;
        }
    }

    public static void printString (String text, int count) {
        for (int i = 0; i < count; i++){
            System.out.println(text);
        }
    }

    public static boolean yearLeap (int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void massive () {
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void longMassive() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void multiplyNumbers() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] < 6){
                arr[i] = arr[i] * 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void diagonalMassive() {
        int size = 4;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void valueLen(int len, int initialValue) {
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
