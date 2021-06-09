package com.unit.test.practicalUnitTestingBook.chapter4_tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @ParameterizedTest(name = "#{index} - Run with password = {0}")
    @MethodSource("validPasswordProvider")
    void is_password_regex_valid(String password) {
        assertTrue(PasswordValidator.isValid(password));
    }

    @ParameterizedTest(name = "#{index} - Run with password = {0}")
    @MethodSource("invalidPasswordProvider")
    void is_password_regex_invalid(String password) {
        assertFalse(PasswordValidator.isValid(password));
    }

    static Stream<String> validPasswordProvider() {
        return Stream.of(
                "AAAbbbccc@123",
                "Hello world$123",
                "A!@#&()–a1",
                "A[{}]:;',?/*a1",
                "A~$^+=<>a1",
                "0123456789$abcdefgAB",
                "123Aa$Aa"
        );
    }

    // At least
    // one lowercase character,
    // one uppercase character,
    // one digit,
    // one special character
    // and length between 8 to 20.
    static Stream<String> invalidPasswordProvider() {
        return Stream.of(
                "12345678",                 // invalid, only digit
                "abcdefgh",                 // invalid, only lowercase
                "ABCDEFGH",                 // invalid, only uppercase
                "abc123$$$",                // invalid, at least one uppercase
                "ABC123$$$",                // invalid, at least one lowercase
                "ABC$$$$$$",                // invalid, at least one digit
                "java REGEX 123",           // invalid, at least one special character
                "java REGEX 123 %",         // invalid, % is not in the special character group []
                "________",                 // invalid
                "--------",                 // invalid
                " ",                        // empty
                ""
        );
    }
}
