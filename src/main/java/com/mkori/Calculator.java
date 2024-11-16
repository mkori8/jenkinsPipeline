package com.mkori;

/**
 * The Calculator class provides methods to perform basic and advanced mathematical operations.
 * It supports operations such as addition, subtraction, multiplication, division, power,
 * square root, factorial, sine, and cosine.
 *
 * <p>This class utilizes the Calculator.Operation enum to specify the desired operation.
 *
 * <p>Example usage:
 * <pre>
 *     Calculator calc = new Calculator();
 *     double result = calc.calculate(Calculator.Operation.ADD, 2, 3);
 *     System.out.println("Result: " + result); // Output: Result: 5.0
 * </pre>
 *
 * @author mkori8
 * @version 1.0
 */
public class Calculator {

    public enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        POWER,
        SQUARE_ROOT,
        FACTORIAL,
        SINE,
        COSINE
    }

    /**
     * Performs the specified mathematical operation on the given operands.
     *
     * @param operation The operation to perform, defined in the Calculator.Operation enum.
     * @param a The first operand.
     * @param b The second operand (not used for operations like SQUARE_ROOT and FACTORIAL).
     * @return The result of the calculation.
     * @throws ArithmeticException If an invalid operation is performed (e.g., division by zero).
     * @throws UnsupportedOperationException If the specified operation is not supported.
     */
    public double calculate(Operation operation, double a, double b) throws ArithmeticException {
        switch (operation) {
            case ADD:
                return add(a, b);
            case SUBTRACT:
                return subtract(a, b);
            case MULTIPLY:
                return multiply(a, b);
            case DIVIDE:
                return divide(a, b);
            case POWER:
                return power(a, b);
            case SQUARE_ROOT:
                return squareRoot(a);
            case FACTORIAL:
                return factorial((int) a);
            case SINE:
                return sine(a);
            case COSINE:
                return cosine(a);
            default:
                throw new UnsupportedOperationException("Operation not supported.");
        }
    }

    /**
     * Adds two numbers.
     *
     * @param a The first operand.
     * @param b The second operand.
     * @return The sum of {@code a} and {@code b}.
     */
    private double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     *
     * @param a The number from which to subtract.
     * @param b The number to subtract.
     * @return The result of {@code a} minus {@code b}.
     */
    private double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a The first operand.
     * @param b The second operand.
     * @return The product of {@code a} and {@code b}.
     */
    private double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     *
     * @param a The dividend.
     * @param b The divisor.
     * @return The result of {@code a} divided by {@code b}.
     * @throws ArithmeticException If {@code b} is zero.
     */
    private double divide(double a, double b) throws ArithmeticException {
        if (b == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    /**
     * Raises a number to a specified power.
     *
     * @param base     The base number.
     * @param exponent The exponent.
     * @return The result of {@code base} raised to the power of {@code exponent}.
     */
    private double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Calculates the square root of a number.
     *
     * @param a The number to find the square root of.
     * @return The square root of {@code a}.
     * @throws ArithmeticException If {@code a} is negative.
     */
    private double squareRoot(double a) throws ArithmeticException {
        if (a < 0.0) {
            throw new ArithmeticException("Square root of negative number is not allowed.");
        }
        return Math.sqrt(a);
    }

    /**
     * Calculates the factorial of a non-negative integer.
     *
     * @param a The integer to calculate the factorial of.
     * @return The factorial of {@code a}.
     * @throws ArithmeticException If {@code a} is negative.
     */
    private long factorial(int a) throws ArithmeticException {
        if (a < 0) {
            throw new ArithmeticException("Factorial of negative number is not allowed.");
        }
        long result = 1;
        for (int i = 2; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Calculates the sine of an angle in radians.
     *
     * @param angle The angle in radians.
     * @return The sine of {@code angle}.
     */
    private double sine(double angle) {
        return Math.sin(angle);
    }

    /**
     * Calculates the cosine of an angle in radians.
     *
     * @param angle The angle in radians.
     * @return The cosine of {@code angle}.
     */
    private double cosine(double angle) {
        return Math.cos(angle);
    }
}

// - documentation (logs, javadoc, site)
//- mockito
// user interface
// update readme.md

// mvn clean, mvn test, mvn spotbugs, mvn javadoc
