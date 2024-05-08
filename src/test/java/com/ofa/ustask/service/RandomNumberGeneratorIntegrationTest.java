package com.ofa.ustask.service;


import com.ofa.ustask.model.RandomNumber;
import com.ofa.ustask.repository.RandomNumberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Random;

import static org.mockito.Mockito.*;

@SpringBootTest

public class RandomNumberGeneratorIntegrationTest {

    @MockBean
    private RandomNumberGenerator randomNumberGenerator;

    @MockBean
    private RabbitMQService rabbitMQService;

    @Autowired
    private RandomNumberRepository randomNumberRepository;


    @Test
    public void testGenerateAndSaveRandomNumber() {
        // Mock randomNumberRepository and rabbitMQService
        RandomNumberRepository randomNumberRepository = Mockito.mock(RandomNumberRepository.class);
        RabbitMQService rabbitMQService = Mockito.mock(RabbitMQService.class);

        // Create an instance of the class containing generateAndSaveRandomNumber method
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(randomNumberRepository, rabbitMQService);

        // Mock the Random class to return a fixed random number
        Random mockRandom = Mockito.mock(Random.class);
        when(mockRandom.nextInt(1000)).thenReturn(123); // Use any number as desired for testing

        // Call the method to test
        randomNumberGenerator.generateAndSaveRandomNumber();

        // Verify that save method was called with the correct entity
        verify(randomNumberRepository, times(1)).save(any(RandomNumber.class));
    }
}
