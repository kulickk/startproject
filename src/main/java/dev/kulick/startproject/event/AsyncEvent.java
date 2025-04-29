package dev.kulick.startproject.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class AsyncEvent extends ApplicationEvent {
    private final String message;

    public AsyncEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}