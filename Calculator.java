/**
 * @author Sinclair DeYoung
 * @version 2.0
 * @since 2025-04-08
 * This is a calculator program that performs operations on formulas that are time consuming.
 */

public class Calculator {
    /**
     * This is the main method that serves as the entry podouble for the calculator application.
     * It initializes the calculator and allows for basic arithmetic operations.
     * @param 
     */


    public static void main(String[] args) {
        /**
         * This is the main method that serves as the entry point for the calculator application.
         * It initializes the calculator and allows for basic arithmetic operations.
         * @param args command line arguments
         * @return void
         */

    }

    public static float add(float x, float y) {
        /**
         * This method adds two float numbers.
         * @param x the first float number
         * @param y the second float number
         * @return the sum of x and y
         */
        return x + y;
    }

    public static float subtract(float x, float y) {
        /**
         * This method subtracts the second float number from the first.
         * @param x the first float number
         * @param y the second float number
         * @return the difference of x and y
         */
        return x - y;
    }

    public static float multiply(float x, float y) {
        /**
         * This method multiplies two float numbers.
         * @param x the first float number
         * @param y the second float number
         * @return the product of x and y
         */
        return x * y;
    }

    public static float divide(float x, float y) {
        /**
         * This method divides the first float number by the second.
         * @param x the first float number
         * @param y the second float number
         * @return the quotient of x and y
         * @throws ArithmeticException if division by zero is attempted
         */
        if (y == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (float) x / y;
    }

    /** 
     * Version 2.0 code
     * 
     */

    public static float modulus(float x, float y) {
        /**
         * This method calculates the modulus of the first float number by the second.
         * @param x the first float number
         * @param y the second float number
         * @return the remainder of x divided by y
         * @throws ArithmeticException if division by zero is attempted
         */
        if (y == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return x % y;
    }

}