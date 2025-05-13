package dev.kulick.startproject.receiver;

import dev.kulick.startproject.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Receiver {

    @RabbitListener(queues = "${app.queue.a}")
    public void receive(ChatMessage msg) {
        log.info("Service-A received: {}", msg);
    }
}