package com.accenture.academy.unit.calculator;

import com.accenture.academy.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void shouldAdd() {

        //Given
        int x = 1;
        int y = 5;
        int expected = 6;

        //When
        int result = calculator.add(x, y);

        //Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldSubtract() {

        //Given
        int x = 10;
        int y = 5;
        int expected = 5;

        //When
        int result = calculator.subtract(x, y);

        //Then
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void shouldMultiply() {

        //Given
        int x = 5;
        int y = 5;
        int expected = 25;

        //When
        int result = calculator.multiply(x, y);

        //Then
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void shouldDivide() {

        //Given
        int x = 10;
        int y = 5;
        int expected = 2;

        //When
        int result = calculator.divide(x, y);

        //Then
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void shouldThrowExceptionWhenDivideByZero() {

        //Given
        int x = 5;
        int y = 0;

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(x, y));

    }

    @Test
    void shouldThrowExceptionWhenNumbersAreNotBetween0And100WhileAdding() {
        //Given
        int x = 130;
        int y = 130;

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add(x, y));
    }

    @Test
    void shouldThrowExceptionWhenNumbersAreNotBetween0And100WhileSubtraction() {
        //Given
        int x = 130;
        int y = 130;

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.subtract(x, y));
    }

    @Test
    void shouldThrowExceptionWhenFirstNumberIsZeroInMultiplication() {
        //Given
        int x = 0;
        int y = 23;

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.multiply(x, y));
    }

    @Test
    void shouldThrowExceptionWhenNumbersAreNotBetween1And30WhileMultiplication() {
        //Given
        int x = -2;
        int y = 31;

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.multiply(x, y));
    }

    @Test
    void shouldThrowExceptionWhenNumbersAreNotMeetingExpectationWhileDividing() {
        //Given
        int x = 1002;
        int y = 102;

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(x, y));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "calculator-parameterized-test-add.csv")
    void shouldAdd_CsvFileParameter(int x, int y, int expected) {

        Assertions.assertEquals(calculator.add(x, y), expected);
    }

    @ParameterizedTest
    @MethodSource("argumentsMethod")
    void shouldAdd_MethodSource(int x, int y, int expected) {
        Assertions.assertEquals(calculator.add(x, y), expected);
    }

    @ParameterizedTest
    @CsvSource({"2,3,5", "10,25,35"})
    void shouldAdd_CsvFileParameters(int x, int y, int expected) {

        Assertions.assertEquals(calculator.add(x, y), expected);
    }

    private static Stream<Arguments> argumentsMethod(){
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(2, 8, 10),
                Arguments.of(2, 7, 9)
        );
    }

}

