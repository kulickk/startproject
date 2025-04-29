package dev.kulick.startproject.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.kulick.startproject.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomEventListener {

    @EventListener
    public void handleEvent(CustomEvent event) {
        log.info("[Custom] Получен ивент: '{}'", event.getMessage());
        log.info("[Custom] Обработка в треде: {}", Thread.currentThread().getName());
    }
}