/**
 * @author Sinclair DeYoung
 * @version 1.0
 * @since 2023-10-01
 * This is a calculator program that performs operations on formulas that are time consuming.
 */

public class Calculator {
    /**
     * This is the main method that serves as the entry point for the calculator application.
     * It initializes the calculator and allows for basic arithmetic operations.
     * @param 
     */

    public static void main(String[] args) {
        // calculator application entry point

    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static double divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) x / y;
    }
}