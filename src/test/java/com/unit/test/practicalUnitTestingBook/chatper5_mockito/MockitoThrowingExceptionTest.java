package com.unit.test.practicalUnitTestingBook.chatper5_mockito;

import com.unit.test.practicalUnitTestingBook.chapter5_mockito.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoThrowingExceptionTest {

    private Car ferrari = mock(Car.class);

    @Test
    public void throwException() {
        when(ferrari.needsFuel()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class,
                () -> ferrari.needsFuel());
    }
}
