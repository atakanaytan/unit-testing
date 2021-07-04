package com.unit.test.practicalUnitTestingBook.chatper5_mockito.notification_service;

import com.unit.test.practicalUnitTestingBook.chapter5_mockito.notification_service.Client;
import com.unit.test.practicalUnitTestingBook.chapter5_mockito.notification_service.Message;
import com.unit.test.practicalUnitTestingBook.chapter5_mockito.notification_service.RaceResultsService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RaceResultsServiceTest {

    @Test
    public void subscribedClientShouldReceiveMessage() {
        RaceResultsService raceResults = new RaceResultsService();
        Client client = mock(Client.class);
        Message message = mock(Message.class);

        raceResults.addSubscriber(client);
        raceResults.send(message);

        verify(client).receive(message);
    }

    @Test
    public void messageShouldBeSentToAllSubscribedClients() {
        RaceResultsService raceResults = new RaceResultsService();
        Client clientA = mock(Client.class, "clientA");
        Client clientB = mock(Client.class, "clientB");
        Message message = mock(Message.class);

        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
}
