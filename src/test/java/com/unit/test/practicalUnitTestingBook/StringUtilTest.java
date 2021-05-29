package com.unit.test.practicalUnitTestingBook;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    private static Object[] getReversedValue() {
        return new Object[][]{
                new Object[]{"abc", "cba"},
                new Object[]{"atakan", "nakata"},
                new Object[]{"abcdefghij", "jihgfedcba"},
                new Object[]{"12547", "74521"}
        };
    }

    private static Object[] getInvalidCurrency() {
        return new String[][]{{null}, {""}};
    }

    @ParameterizedTest
    @MethodSource("getReversedValue")
    public void stringShouldReversedCorrectly(String expected, String actual) {
        assertEquals(actual, StringUtil.reverse(expected));
    }

    @ParameterizedTest
    @MethodSource("getInvalidCurrency")
    public void methodShouldThrowIAEForInvalidString(String invalidParam) {
        assertThrows(IllegalArgumentException.class, () -> StringUtil.reverse(invalidParam));
    }
}