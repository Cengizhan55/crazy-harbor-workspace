package com.crazycoder.crazyharborconsumer.config.rabbit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "rabbit-mq")
@Component
public class RabbitMqProperties {
    private String queueName;
    private String directExchangeProperty;
    private String routingKeyProperty;
    private Long replyTimeout;
    private Long receiveTimeout;
}
