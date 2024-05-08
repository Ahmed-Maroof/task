package com.ofa.ustask.service;

import com.ofa.ustask.model.RandomNumberResult;
import com.ofa.ustask.model.dto.RandomNumberData;
import com.ofa.ustask.repository.RandomNumberResultRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RandomNumberResultServiceIntegrationTest {
    @Autowired
    private RandomNumberResultService randomNumberResultService;

    @Autowired
    private RandomNumberResultRepository randomNumberResultRepository;

    @Captor
    private ArgumentCaptor<RandomNumberData> messageCaptor;

    @Test
    public void testMessageConsumptionAndProcessing() {
        // Simulate a message payload with a random number
        RandomNumberData messageBody = new RandomNumberData(1L, 10);

        // Trigger the message listener method with the simulated message
        randomNumberResultService.receiveMessage(messageBody);

        // Retrieve the saved RandomNumberResult entity from the repository
        RandomNumberResult savedResult = randomNumberResultRepository.findFirstByOrderByIdDesc();

        // Verify that the saved record is the received random number multiplied by 2
        assertEquals(messageBody.getRandomNumber() * 2, savedResult.getMultipliedResult());
    }

}
