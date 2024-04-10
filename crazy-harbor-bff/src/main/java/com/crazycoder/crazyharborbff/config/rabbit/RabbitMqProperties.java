package com.crazycoder.crazyharborbff.config.rabbit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "rabbit-mq")
public class RabbitMqProperties {
    private String queueName;
    private String directExchangeProperty;
    private String routingKeyProperty;
    private Long replyTimeout;
    private Long receiveTimeout;
}
