package com.ofa.ustask.service;

import com.ofa.ustask.model.RandomNumberResult;
import com.ofa.ustask.model.dto.RandomNumberData;
import com.ofa.ustask.repository.RandomNumberResultRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RandomNumberResultService {


    private final RandomNumberResultRepository resultRepository;

    public RandomNumberResultService(RandomNumberResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @RabbitListener(queues = "${spring.rabbitmq.listener.queue-name}")
    public void receiveMessage(RandomNumberData data) {
        System.out.println("Received message from RabbitMQ: " + data);

        int multipliedResult = data.getRandomNumber() * 2;

        RandomNumberResult result = new RandomNumberResult();
        result.setId(data.getId());
        result.setMultipliedResult(multipliedResult);
        resultRepository.save(result);

        System.out.println("Result saved: " + result);
    }


}
