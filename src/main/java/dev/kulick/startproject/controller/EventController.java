package dev.kulick.startproject.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.kulick.startproject.event.AsyncEvent;
import dev.kulick.startproject.event.CustomEvent;
import dev.kulick.startproject.event.TxEvent;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final ApplicationEventPublisher publisher;

    @PostMapping("/custom")
    public String fireCustom(@RequestParam("message") String message) {
        publisher.publishEvent(new CustomEvent(this, message));
        return "Ответ от CustomEvent: " + message;
    }

    @PostMapping("/async")
    public String fireAsync(@RequestParam("message") String message) {
        publisher.publishEvent(new AsyncEvent(this, message));
        return "Ответ от AsyncEvent: " + message;
    }

    @PostMapping("/tx/commit")
    public String fireTxCommit(@RequestParam("message") String message) {
        publisher.publishEvent(new TxEvent(this, message, true));
        publisher.publishEvent(new TxEvent(this, message, false));
        return "Ответ от TransactionalEvent: " + message;
    }

}
