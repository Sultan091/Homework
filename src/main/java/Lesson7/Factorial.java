package Lesson7;

public class Factorial {
    public int calculate( int n) {
        if(n < 0){
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }

        int result = 1;
        for(int i = 1;i <= n; i++){
            result *= i;
        }
        return result;
    }
}
