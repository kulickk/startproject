package dev.kulick.startproject.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import dev.kulick.startproject.event.TxEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TxEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleTxEvent(TxEvent event) {
        if (event.isShouldProcess() == true) {
            log.info("[TransactionalListener] Обработка события после коммита: {}", event.getMessage());
        } else {
            log.info("[TransactionalListener] Пропуск обработки события: {}", event.getMessage());
        }
    }
}