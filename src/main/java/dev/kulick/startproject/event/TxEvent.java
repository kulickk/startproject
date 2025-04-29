package dev.kulick.startproject.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class TxEvent extends ApplicationEvent {
    private final String message;
    private final boolean shouldProcess;

    public TxEvent(Object source, String message, boolean shouldProcess) {
        super(source);
        this.message = message;
        this.shouldProcess = shouldProcess;
    }
}