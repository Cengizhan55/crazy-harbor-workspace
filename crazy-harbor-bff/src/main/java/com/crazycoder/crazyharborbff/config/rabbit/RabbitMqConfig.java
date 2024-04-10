package com.crazycoder.crazyharborbff.config.rabbit;


import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RabbitMqProperties.class)
@EnableRabbit
public class RabbitMqConfig {

    private final RabbitMqProperties rabbitMqProperties;

    public RabbitMqConfig(RabbitMqProperties rabbitMqProperties) {
        this.rabbitMqProperties = rabbitMqProperties;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }


    @Bean
    public Queue conversationResponseQueue() {
        return new Queue(rabbitMqProperties.getQueueName());
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(rabbitMqProperties.getDirectExchangeProperty());
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(rabbitMqProperties.getRoutingKeyProperty());
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                  AmqpAdmin amqpAdmin,
                                  DirectExchange directExchange,
                                  Binding binding,
                                  Queue queue,
                                  Jackson2JsonMessageConverter jackson2JsonMessageConverter) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
        rabbitTemplate.setReplyTimeout(rabbitMqProperties.getReplyTimeout());
        rabbitTemplate.setReceiveTimeout(rabbitMqProperties.getReceiveTimeout());


        amqpAdmin.declareExchange(directExchange);
        amqpAdmin.declareBinding(binding);
        amqpAdmin.declareQueue(queue);


        return rabbitTemplate;
    }
}
