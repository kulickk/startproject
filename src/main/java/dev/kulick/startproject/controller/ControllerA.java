package dev.kulick.startproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.kulick.startproject.model.ChatMessage;
import dev.kulick.startproject.service.SenderService;

@RestController
@RequestMapping("/api/a")
@RequiredArgsConstructor
public class ControllerA {

    private final SenderService senderService;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody ChatMessage msg) {
        msg.setFrom("service-a");
        msg.setTo("service-b");
        senderService.send(msg);
        return ResponseEntity.ok("Sent from Service-A");
    }
}