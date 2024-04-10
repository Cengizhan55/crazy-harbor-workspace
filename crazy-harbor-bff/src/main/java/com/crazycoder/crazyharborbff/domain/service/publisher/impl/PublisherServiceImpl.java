package com.crazycoder.crazyharborbff.domain.service.publisher.impl;

import com.crazycoder.crazyharborbff.config.rabbit.RabbitMqProperties;
import com.crazycoder.crazyharborbff.domain.service.common.BaseService;
import com.crazycoder.crazyharborbff.domain.service.publisher.PublisherService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl extends BaseService implements PublisherService {


    private final RabbitMqProperties rabbitMqProperties;

    private final RabbitTemplate rabbitTemplate;


    public PublisherServiceImpl(RabbitMqProperties rabbitMqProperties, RabbitTemplate rabbitTemplate) {
        this.rabbitMqProperties = rabbitMqProperties;
        this.rabbitTemplate = rabbitTemplate;
    }


        public void publishUserCreateEvent(String event) {

                rabbitTemplate.convertAndSend(
                        rabbitMqProperties.getDirectExchangeProperty(),
                        rabbitMqProperties.getRoutingKeyProperty(),
                        event);

        }

}
