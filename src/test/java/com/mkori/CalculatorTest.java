package com.mkori;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        double result = calc.calculate(Calculator.Operation.ADD, 2, 3);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testSubtract() {
        double result = calc.calculate(Calculator.Operation.SUBTRACT, 5, 3);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testMultiply() {
        double result = calc.calculate(Calculator.Operation.MULTIPLY, 4, 5);
        assertEquals(20.0, result, 0.0001);
    }

    @Test
    public void testDivide() {
        try {
            double result = calc.calculate(Calculator.Operation.DIVIDE, 10, 2);
            assertEquals(5.0, result, 0.0001);
        } catch (ArithmeticException e) {
            fail("Division by non-zero should not throw exception.");
        }
    }

    @Test
    public void testDivideByZero() {
        try {
            calc.calculate(Calculator.Operation.DIVIDE, 10, 0);
            fail("Division by zero should throw ArithmeticException.");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }

    @Test
    public void testPower() {
        double result = calc.calculate(Calculator.Operation.POWER, 2, 3);
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    public void testSquareRoot() {
        try {
            double result = calc.calculate(Calculator.Operation.SQUARE_ROOT, 16.0, 0);
            assertEquals(4.0, result, 0.0001);
        } catch (ArithmeticException e) {
            fail("Square root of non-negative number should not throw exception.");
        }
    }

    @Test
    public void testSquareRootNegative() {
        try {
            calc.calculate(Calculator.Operation.SQUARE_ROOT, -9.0, 0);
            fail("Square root of negative number should throw ArithmeticException.");
        } catch (ArithmeticException e) {
            assertEquals("Square root of negative number is not allowed.", e.getMessage());
        }
    }

    @Test
    public void testFactorial() {
        try {
            double result = calc.calculate(Calculator.Operation.FACTORIAL, 5.0, 0);
            assertEquals(120.0, result, 0.0001);
        } catch (ArithmeticException e) {
            fail("Factorial of non-negative number should not throw exception.");
        }
    }

    @Test
    public void testFactorialNegative() {
        try {
            calc.calculate(Calculator.Operation.FACTORIAL, -3.0, 0);
            fail("Factorial of negative number should throw ArithmeticException.");
        } catch (ArithmeticException e) {
            assertEquals("Factorial of negative number is not allowed.", e.getMessage());
        }
    }

    @Test
    public void testSine() {
        double result = calc.calculate(Calculator.Operation.SINE, Math.PI / 2, 0);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    public void testCosine() {
        double result = calc.calculate(Calculator.Operation.COSINE, 0.0, 0);
        assertEquals(1.0, result, 0.0001);
    }
}


// Using Parametrized Tests

/*
package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CalculatorParameterizedTest {

    private Calculator calc;
    private Calculator.Operation operation;
    private double operand1;
    private double operand2;
    private double expectedResult;
    private boolean expectException;
    private String expectedMessage;

    public CalculatorParameterizedTest(Calculator.Operation operation, double operand1, double operand2,
                                      double expectedResult, boolean expectException, String expectedMessage) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.expectedResult = expectedResult;
        this.expectException = expectException;
        this.expectedMessage = expectedMessage;
    }

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Parameterized.Parameters(name = "{index}: {0}({1}, {2})={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            // Operation, Operand1, Operand2, Expected Result, Expect Exception, Expected Message
            {Calculator.Operation.ADD, 2, 3, 5.0, false, null},
            {Calculator.Operation.SUBTRACT, 5, 3, 2.0, false, null},
            {Calculator.Operation.MULTIPLY, 4, 5, 20.0, false, null},
            {Calculator.Operation.DIVIDE, 10, 2, 5.0, false, null},
            {Calculator.Operation.DIVIDE, 10, 0, 0.0, true, "Division by zero is not allowed."},
            {Calculator.Operation.POWER, 2, 3, 8.0, false, null},
            {Calculator.Operation.SQUARE_ROOT, 16.0, 0, 4.0, false, null},
            {Calculator.Operation.SQUARE_ROOT, -9.0, 0, 0.0, true, "Square root of negative number is not allowed."},
            {Calculator.Operation.FACTORIAL, 5.0, 0, 120.0, false, null},
            {Calculator.Operation.FACTORIAL, -3.0, 0, 0.0, true, "Factorial of negative number is not allowed."},
            {Calculator.Operation.SINE, Math.PI / 2, 0, 1.0, false, null},
            {Calculator.Operation.COSINE, 0.0, 0, 1.0, false, null},
            {Calculator.Operation.COSINE, Math.PI / 2, 0, 0.0, false, null}
        });
    }

    @Test
    public void testCalculatorOperations() {
        try {
            double result = calc.calculate(operation, operand1, operand2);
            if (expectException) {
                fail("Expected an exception for operation: " + operation);
            }
            assertEquals(expectedResult, result, 0.0001);
        } catch (ArithmeticException e) {
            if (!expectException) {
                fail("Did not expect an exception for operation: " + operation);
            }
            assertEquals(expectedMessage, e.getMessage());
        } catch (UnsupportedOperationException e) {
            fail("Unsupported operation: " + operation);
        }
    }
}

 */