import Lesson7.Calculator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd(){
        assertEquals(calculator.add(2,3),5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero(){
        calculator.divide(10,0);
    }
}
