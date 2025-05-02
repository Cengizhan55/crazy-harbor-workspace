package com.crazycoder.crazyharborbff.domain.service.rabbit;


import com.crazycoder.crazyharborbff.config.rabbit.RabbitMqConfig;
import com.crazycoder.crazyharborbff.config.rabbit.RabbitMqProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@EnableConfigurationProperties(RabbitMqProperties.class)
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    private final RabbitMqProperties rabbitMqProperties;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate, RabbitMqProperties rabbitMqProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMqProperties = rabbitMqProperties;
    }


    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(rabbitMqProperties.getRoutingKeyProperty(),rabbitMqProperties.getRoutingKeyProperty(),message);
    }
}
