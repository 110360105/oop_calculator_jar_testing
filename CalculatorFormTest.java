import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Request;
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
        String test_str = "123456-9876543+389274=";
		System.out.println("Testing addition and subtraction:");
		System.out.println(test_str);
        result = evalInput(test_str);
        assertEquals(-9363813, result, 0);
    }

    @ Test
    public void testMultiply() {
        double result = 0;
        clearAll();
        result = evalInput("15*2*3*123=");
        assertEquals(11070, result, 0);
    }

    @ Test
    public void testDivision() {
        double result = 0;
        clearAll();
        String test_str = "100/2/5=";
		System.out.println("Testing division:");
		System.out.println(test_str);
        result = evalInput(test_str);
        assertEquals(10, result, 0);
    }

    @ Test
    public void testFloatingPoint() {
        double result = 0;
        clearAll();
		String test_str = "0.6*0.7*0.8*0.9/2=";
		System.out.println("Testing floating point calculation:");
		System.out.println(test_str);
        result = evalInput(test_str);
        assertEquals(0.1512, result, 0);
    }

    public static void main(String[] args) {
        //calc.showWindow();
		int test_id = -1;
		
		if (args.length == 1) {
			try{
				test_id = Integer.parseInt(args[0]);
			} catch (NumberFormatException ex){
				ex.printStackTrace();
			}
		}
		
		Request request = null;

		switch(test_id)
		{
			case 0:
				request = Request.method(CalculatorFormTest.class, "testAddSub");
				break;
		
			case 1:
				request = Request.method(CalculatorFormTest.class, "testMultiply");
				break;
				
			case 2:
				request = Request.method(CalculatorFormTest.class, "testDivision");
				break;
				
			case 3:
				request = Request.method(CalculatorFormTest.class, "testFloatingPoint");
				break;
		}
		
		Result result;

		if (test_id == -1)
			result = JUnitCore.runClasses(CalculatorFormTest.class);
		else
			result = new JUnitCore().run(request);
        
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
		
        System.out.println(result.wasSuccessful());
    }

}
