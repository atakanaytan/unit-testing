package com.unit.test.practicalUnitTestingBook.chatper5_mockito;

import com.unit.test.practicalUnitTestingBook.chapter5_mockito.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertFalse;

public class FirstMockitoTest {

    private Car ferrari = mock(Car.class);

    @Test
    public void testIfCarIsACar() {
        assertTrue(ferrari instanceof Car);
    }

    @Test
    public void testDefaultBehaviorOfTestDouble() {
        assertFalse("new test double should return false as boolean",
                ferrari.needsFuel());
        assertEquals(0.0, ferrari.getEngineTemperature(),
                "new test double should return 0.0 as double");

        when(ferrari.needsFuel()).thenReturn(true);

        assertTrue(ferrari.needsFuel(),
                "after instructed test double should return what we want");
    }

}
