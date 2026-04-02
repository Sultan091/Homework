package Lesson5;

public class ArrayProcessor {

    public static int processArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        // Проверка размера
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть 4x4");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть 4x4");
            }
        }

        int sum = 0;

        // Проход по массиву
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }

        return sum;
    }
}
