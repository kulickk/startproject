package dev.kulick.startproject.service;

import dev.kulick.startproject.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SenderService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.exchange}")
    private String exchange;

    @Value("${app.routing.toB}")
    private String routingKeyToB;

    public void send(ChatMessage msg) {
        log.info("Service-A sending: {}", msg);
        rabbitTemplate.convertAndSend(exchange, routingKeyToB, msg);
    }
}