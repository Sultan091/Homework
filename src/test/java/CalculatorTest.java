import Lesson7.Calculator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd(){
        assertEquals(Calculator.add(2,3),5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero(){
        Calculator.divide(10,0);
    }
}
