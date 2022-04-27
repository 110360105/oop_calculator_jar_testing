import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.*;


public class CalculatorFormTest {

    static CalculatorForm calc = new CalculatorForm();

    private double evalInput(String input) {
        double result = Double.NaN;
        char [] in_array = input.toCharArray();
        try {
            for (char c : in_array) {
                if (c == ' ') // Skip space
                    continue;

                calc.testClick(Character.toString(c));
            }
            result = calc.getResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private void clearAll() {
        try {
            calc.testClick("CLEAR");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @ Test
    public void testAddSub() {
        double result = 0;
        clearAll();
        result = evalInput("123+456-789=");
        assertEquals(-210, result, 0);
    }

    @ Test
    public void testMultiply() {
        double result = 0;
        clearAll();
        result = evalInput("5*2*3*10=");
        assertEquals(300, result, 0);
    }

    @ Test
    public void testDivision() {
        double result = 0;
        clearAll();
        result = evalInput("100/2/5=");
        assertEquals(10, result, 0);
    }

    @ Test
    public void testFloatingPoint() {
        double result = 0;
        clearAll();
        result = evalInput("0.6*0.7*0.8*0.9/2=");
        assertEquals(0.1512, result, 0);
    }

    public static void main(String[] args) {
        //calc.showWindow();

        Result result = JUnitCore.runClasses(CalculatorFormTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

}
