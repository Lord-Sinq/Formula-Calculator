/**
 * @author Sinclair DeYoung
 * @version 1.0
 * @since 2023-10-01
 * This is a calculator program that performs operations on formulas that are time consuming.
 */

public class Calculator {
    /**
     * This is the main method that serves as the entry podouble for the calculator application.
     * It initializes the calculator and allows for basic arithmetic operations.
     * @param 
     */
    

    public static void main(String[] args) {
        // calculator application entry podouble

    }

    public static float add(float x, float y) {
        return x + y;
    }

    public static float subtract(float x, float y) {
        return x - y;
    }

    public static float multiply(float x, float y) {
        return x * y;
    }

    public static float divide(float x, float y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (float) x / y;
    }
}