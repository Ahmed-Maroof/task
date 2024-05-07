package com.ofa.ustask.service;

import com.ofa.ustask.model.RandomNumber;
import com.ofa.ustask.repository.RandomNumberRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberGenerator {

    private final RandomNumberRepository randomNumberRepository;
    private final RabbitMQService rabbitMQService;

    public RandomNumberGenerator(RandomNumberRepository randomNumberRepository, RabbitMQService rabbitMQService) {
        this.randomNumberRepository = randomNumberRepository;
        this.rabbitMQService = rabbitMQService;
    }

    @Scheduled(fixedRate = 10000) // Execute every 10 seconds
    public void generateAndSaveRandomNumber() {
        System.out.println("Starting the random number generation process...");
        Random random = new Random();
        int randomNumber = random.nextInt(1000); // Generate a random number between 0 and 999
        RandomNumber entity = new RandomNumber();
        entity.setRandomNumber(randomNumber);
        randomNumberRepository.save(entity);
        System.out.println("Saved random number: " + entity);

        rabbitMQService.sendMessage(entity.getId(), entity.getRandomNumber());
    }

}
