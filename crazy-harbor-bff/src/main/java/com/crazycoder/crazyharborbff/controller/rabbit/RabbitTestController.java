package com.crazycoder.crazyharborbff.controller.rabbit;


import com.crazycoder.crazyharborbff.domain.service.rabbit.RabbitMQProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rabbit/v1")
@RestController
public class RabbitTestController {

    private final RabbitMQProducer rabbitMQProducer;

    public RabbitTestController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @PostMapping
    public void sendRabbitMessage(String message){
        rabbitMQProducer.sendMessage(message);
    }
}
