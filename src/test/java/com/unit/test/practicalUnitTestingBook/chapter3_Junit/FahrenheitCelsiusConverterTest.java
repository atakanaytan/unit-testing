package com.unit.test.practicalUnitTestingBook.chapter3_Junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class FahrenheitCelsiusConverterTest {

    private static Object[] getCelsiusValues() {
        return new Object[][]{
                new Object[]{32, 0},
                new Object[]{98, 37},
                new Object[]{212, 100},
        };
    }


    private static Object[] getFahrenheitValues() {
        return new Object[][]{
                new Object[]{0, 32},
                new Object[]{37, 100},
                new Object[]{100, 212},
        };
    }

    @ParameterizedTest()
    @MethodSource("getCelsiusValues")
    public void shouldConvertCelsiusToFahrenheit(int expected, int actual) {
        assertEquals(expected, FahrenheitCelsiusConverter.toFahrenheit(actual));
    }

    @ParameterizedTest
    @MethodSource("getFahrenheitValues")
    public void shouldConvertFahrenheitToCelsius(int expected, int actual) {
        assertEquals(expected, FahrenheitCelsiusConverter.toCelsius(actual));
    }
}
