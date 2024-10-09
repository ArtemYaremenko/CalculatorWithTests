package pro.sky.CalculatorWithTests.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.CalculatorWithTests.exceptions.MissingParameterException;
import pro.sky.CalculatorWithTests.exceptions.ZeroDivisorException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorServiceImplTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    private static Stream<Arguments> validArgumentsForTest() {
        return Stream.of(Arguments.of(0, 100500),
                Arguments.of(-1000, 1000),
                Arguments.of(32, 128),
                Arguments.of(450_000, 4_500_000)
        );
    }

    private static Stream<Arguments> nullArgumentsForTest() {
        return Stream.of(Arguments.of(null, 10),
                Arguments.of(1024, null),
                Arguments.of(null, null)
        );
    }
    @ParameterizedTest
    @MethodSource("validArgumentsForTest")
    void sumWithValidArgumentsTest(Integer a, Integer b) {
        int expected = a + b;

        //test
        int actual = calculatorService.sum(a, b);

        //check
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("nullArgumentsForTest")
    void sumWithNullArgumentsTest(Integer a, Integer b) {
        //test
        assertThrows(MissingParameterException.class, () -> calculatorService.sum(a, b));
    }

    @ParameterizedTest
    @MethodSource("validArgumentsForTest")
    void diffWithValidArgumentsTest(Integer a, Integer b) {
        int expected = a - b;

        //test
        int actual = calculatorService.diff(a, b);

        //check
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("nullArgumentsForTest")
    void diffWithNullArgumentsTest(Integer a, Integer b) {
        //test
        assertThrows(MissingParameterException.class, () -> calculatorService.diff(a, b));
    }

    @ParameterizedTest
    @MethodSource("validArgumentsForTest")
    void multiplyWithValidArgumentsTest(Integer a, Integer b) {
        int expected = a * b;

        //test
        int actual = calculatorService.multiply(a, b);

        //check
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("nullArgumentsForTest")
    void multiplyWithNullArgumentsTest(Integer a, Integer b) {
        //test
        assertThrows(MissingParameterException.class, () -> calculatorService.multiply(a, b));
    }

    @ParameterizedTest
    @MethodSource("validArgumentsForTest")
    void devideWithValidArgumentsTest(Integer a, Integer b) {
        int expected = a / b;

        //test
        int actual = calculatorService.divide(a, b);

        //check
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("nullArgumentsForTest")
    void devideWithNullArgumentsTest(Integer a, Integer b) {
        //test
        assertThrows(MissingParameterException.class, () -> calculatorService.divide(a, b));
    }

    @Test
    void divisionByZero() {
        Integer a = 9999;
        Integer b = 0;

        //Test
        assertThrows(ZeroDivisorException.class, () -> calculatorService.divide(a, b));
    }

}