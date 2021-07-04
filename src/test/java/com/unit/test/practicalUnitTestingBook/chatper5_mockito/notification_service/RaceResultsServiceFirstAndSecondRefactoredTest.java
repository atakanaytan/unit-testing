package com.unit.test.practicalUnitTestingBook.chatper5_mockito.notification_service;

import com.unit.test.practicalUnitTestingBook.chapter5_mockito.notification_service.Client;
import com.unit.test.practicalUnitTestingBook.chapter5_mockito.notification_service.Message;
import com.unit.test.practicalUnitTestingBook.chapter5_mockito.notification_service.RaceResultsService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RaceResultsServiceFirstAndSecondRefactoredTest {

    private final RaceResultsService raceResults = new RaceResultsService();
    private final Message message  = mock(Message.class);
    private final Client clientA = mock(Client.class);
    private final Client clientB = mock(Client.class);

    // zero subscriber
    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    // one subscriber
    @Test
    public void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

        verify(clientA).receive(message);
    }

    // two subscriber
    @Test
    public void allSubscribedClientsShouldReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientA, times(1)).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);

        raceResults.send(message);

        verify(clientA, never()).receive(message);
    }
}
