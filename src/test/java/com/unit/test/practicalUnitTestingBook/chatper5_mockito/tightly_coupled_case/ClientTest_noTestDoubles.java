package com.unit.test.practicalUnitTestingBook.chatper5_mockito.tightly_coupled_case;

import com.unit.test.practicalUnitTestingBook.chapter5_mockito.tightly_coupled_case.Client;
import com.unit.test.practicalUnitTestingBook.chapter5_mockito.tightly_coupled_case.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest_noTestDoubles {

    // real objects are created for the tests

    final static String ANY_NUMBER = "999-888-777";
    final static Phone MOBILE_PHONE = new Phone(ANY_NUMBER, true);
    final static Phone STATIONERY_PHONE = new Phone(ANY_NUMBER, false);

    Client client = new Client();

    @Test
    public void shouldReturnTrueIfClientHasMobile() {
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