package com.crazycoder.crazyharborconsumer.domain.service;

import com.crazycoder.crazyharborbff.domain.service.publisher.model.EventHistoryDTO;
import com.crazycoder.crazyharborcommon.util.JsonUtil;
import com.crazycoder.crazyharborconsumer.config.rabbit.RabbitMqProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventConsumerService {


    private final RabbitMqProperties rabbitMqProperties;

    public EventConsumerService(RabbitMqProperties rabbitMqProperties) {
        this.rabbitMqProperties = rabbitMqProperties;
    }

    @RabbitListener(queues = {"crazy-harbor-bff-queue"},messageConverter = "jackson2JsonMessageConverter")
    public void consumeHarborBff(String jsonData) throws JsonProcessingException {


        EventHistoryDTO consumedObject = JsonUtil.toObject(jsonData, EventHistoryDTO.class);


        log.info("queueName: " + rabbitMqProperties.getQueueName() + ". Message has taken, message is -> " + consumedObject.getDescription());

    }
}
