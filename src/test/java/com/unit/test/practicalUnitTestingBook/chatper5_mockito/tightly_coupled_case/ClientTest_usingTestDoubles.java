package com.unit.test.practicalUnitTestingBook.chatper5_mockito.tightly_coupled_case;

import com.unit.test.practicalUnitTestingBook.chapter5_mockito.tightly_coupled_case.Client;
import com.unit.test.practicalUnitTestingBook.chapter5_mockito.tightly_coupled_case.Phone;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest_usingTestDoubles {

    final static Phone MOBILE_PHONE = mock(Phone.class);
    final static Phone STATIONERY_PHONE = mock(Phone.class);

    Client client = new Client();

    @Test
    public void shouldReturnTrueIfClientHasMobile() {
        when(MOBILE_PHONE.isMobile()).thenReturn(true);

        client.addPhone(MOBILE_PHONE);
        client.addPhone(STATIONERY_PHONE);
        assertTrue(client.hasMobile());
    }

    @Test
    public void shouldReturnFalseIfClientHasNoMobile() {
        client.addPhone(STATIONERY_PHONE);
        assertFalse(client.hasMobile());
    }
}
