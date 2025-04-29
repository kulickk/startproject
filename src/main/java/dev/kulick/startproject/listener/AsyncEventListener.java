package dev.kulick.startproject.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import dev.kulick.startproject.event.AsyncEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AsyncEventListener {

    @Async
    @EventListener
    public void handleAsyncEvent(AsyncEvent event) {
        log.info("[Async] Начало обработки: '{}'", event.getMessage());
        log.info("[Async] Тред: {}", Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("[Async] Обработка завершена");
    }
}