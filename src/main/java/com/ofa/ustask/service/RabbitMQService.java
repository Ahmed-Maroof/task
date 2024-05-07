package com.ofa.ustask.service;

import com.ofa.ustask.config.RabbitMQConfig;
import com.ofa.ustask.model.dto.RandomNumberData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private final RabbitTemplate rabbitTemplate;
    private final Jackson2JsonMessageConverter jsonMessageConverter;

    public RabbitMQService(RabbitTemplate rabbitTemplate,
                           Jackson2JsonMessageConverter jsonMessageConverter) {
        this.rabbitTemplate = rabbitTemplate;
        this.jsonMessageConverter = jsonMessageConverter;
    }

    public void sendMessage(Long id, int randomNumber) {
        RandomNumberData data = new RandomNumberData(id, randomNumber); // Assume RandomNumberData is a POJO class representing your data
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, data);
        System.out.println("Message sent to RabbitMQ: " + data);
    }

}
