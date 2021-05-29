package com.unit.test.practicalUnitTestingBook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    private static final int VALID_AMOUNT = 5;

    private static Object[] getInvalidCurrency() {
        return new String[][]{{null}, {""}};
    }

    @Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "TL");

        assertEquals(10, money.getAmount());
        assertEquals("TL", money.getCurrency());
    }

    @ParameterizedTest
    @CsvSource(value = {"10, TL", "15, USD", "100, EURO"})
    public void constructorTestWithParameterizedTest(int amount, String currency) {
        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    @ParameterizedTest
    @MethodSource("getInvalidCurrency")
    public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
        assertThrows(IllegalArgumentException.class, () -> new Money(VALID_AMOUNT, invalidCurrency));
    }
}