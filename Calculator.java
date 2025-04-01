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

    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) x / y;
    }
}