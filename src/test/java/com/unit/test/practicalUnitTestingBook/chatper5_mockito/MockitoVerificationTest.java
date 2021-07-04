package com.unit.test.practicalUnitTestingBook.chatper5_mockito;

import com.unit.test.practicalUnitTestingBook.chapter5_mockito.Car;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockitoVerificationTest {

    private final Car ferrari = mock(Car.class);

    @Test
    public void testVerification() {
        ferrari.driveTo("my sweet home nebraska");
        ferrari.needsFuel();

        verify(ferrari).driveTo("my sweet home nebraska");
        verify(ferrari).needsFuel();
    }
}
